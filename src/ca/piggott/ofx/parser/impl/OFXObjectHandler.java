package ca.piggott.ofx.parser.impl;

import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import ca.piggott.ofx.internal.model.Constants;
import ca.piggott.ofx.internal.model.OFXAvailableBalance;
import ca.piggott.ofx.internal.model.OFXBankAccountFrom;
import ca.piggott.ofx.internal.model.OFXBankTransactionList;
import ca.piggott.ofx.internal.model.OFXBankingMessage;
import ca.piggott.ofx.internal.model.OFXCreditCardAccountFrom;
import ca.piggott.ofx.internal.model.OFXCreditCardMsgSrsV1;
import ca.piggott.ofx.internal.model.OFXCreditCardStatementTransactionResponse;
import ca.piggott.ofx.internal.model.OFXLedgerBalance;
import ca.piggott.ofx.internal.model.OFXRoot;
import ca.piggott.ofx.internal.model.OFXSignOnMsgSrsV1;
import ca.piggott.ofx.internal.model.OFXSignOnResponse;
import ca.piggott.ofx.internal.model.OFXStatementTransaction;
import ca.piggott.ofx.internal.model.OFXStatementTransactionResponse;
import ca.piggott.ofx.internal.model.OFXStatementTransactions;
import ca.piggott.ofx.internal.model.OFXStatus;
import ca.piggott.ofx.model.IOFXRoot;

public class OFXObjectHandler extends DefaultHandler  {

	private Stack<OFXObject> stack = new Stack<OFXObject>();
	private String openElement;

	@Override
	public void characters(char[] ch, int start, int length) {
		if (openElement != null)
			stack.peek().addProperty(openElement, new String(ch, start, length).trim());
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		openElement = null;
		if (!Constants.OFX.equals(qName) && stack.size() > 1) {
			OFXObject obj = stack.pop();
			stack.peek().addObject(obj);
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		openElement = null;
		if (Constants.STATEMENT_TRANSACTION.equals(qName))
			stack.push(new OFXStatementTransaction());
		else if (Constants.STATUS.equals(qName))
			stack.push(new OFXStatus());
		else if (Constants.OFX.equals(qName))
			stack.push(new OFXRoot());
		else if (Constants.BANKMSGSRSV1.equals(qName))
			stack.push(new OFXBankingMessage());
		else if (Constants.SIGNONMSGSRSV1.equals(qName))
			stack.push(new OFXSignOnMsgSrsV1());
		else if (Constants.STATEMENT_TRANSACTIONS.equals(qName))
			stack.push(new OFXStatementTransactions());
		else if (Constants.SIGN_ON_RESPONSE.equals(qName))
			stack.push(new OFXSignOnResponse());
		else if (Constants.STATEMENT_TRANSACTION_RESPONSE.equals(qName))
			stack.push(new OFXStatementTransactionResponse());
		else if (Constants.BANK_ACCOUT_FROM.equals(qName))
			stack.push(new OFXBankAccountFrom());
		else if (Constants.BANK_TRANSACTION_LIST.equals(qName)) 
			stack.push(new OFXBankTransactionList());
		else if (Constants.LEDGER_BALANCE.equals(qName))
			stack.push(new OFXLedgerBalance());
		else if (Constants.AVAILBLE_BALANCE.equals(qName))
			stack.push(new OFXAvailableBalance());
		else if (Constants.CREDIT_CARD_STATEMENT_TRANSACTION_REPONSE.equals(qName))
			stack.push(new OFXCreditCardStatementTransactionResponse());
		else if (Constants.CREDITCARDMSGSRSV1.equals(qName))
			stack.push(new OFXCreditCardMsgSrsV1());
		else if (Constants.CCACCTFROM.equals(qName))
			stack.push(new OFXCreditCardAccountFrom());
		else if (Constants.CC_STATEMENT_TRANSACTIONS.equals(qName))
			stack.push(new OFXCreditCardStatementTransactions());
		else 
			openElement = qName;
	}

	public IOFXRoot getObject() {
		if (!stack.isEmpty() && stack.peek() instanceof OFXRoot)
			return (IOFXRoot) stack.pop();
		return null;
	}
}

package ca.piggott.ofx.parser.impl;

import ca.piggott.ofx.internal.model.Constants;
import ca.piggott.ofx.internal.model.OFXAvailableBalance;
import ca.piggott.ofx.internal.model.OFXBankTransactionList;
import ca.piggott.ofx.internal.model.OFXLedgerBalance;
import ca.piggott.ofx.model.IOFXBalance;
import ca.piggott.ofx.model.IOFXBankTransactionList;
import ca.piggott.ofx.model.IOFXCreditCardAccountFrom;
import ca.piggott.ofx.model.IOFXCreditCardStatementTransactions;

/**
 * CCSTMTRS
 */
public class OFXCreditCardStatementTransactions implements OFXObject, IOFXCreditCardStatementTransactions {
	private String currency;
	private IOFXCreditCardAccountFrom source;
	private IOFXBankTransactionList transactionList;
	private IOFXBalance ledgerBalance;
	private IOFXBalance availableBalance;

	@Override
	public void addProperty(String tag, String item) {
		if (Constants.CURRENCY.equals(tag))
			currency = item;
		else
			throw new IllegalArgumentException();
	}

	@Override
	public void addObject(OFXObject obj) {
		if (obj instanceof IOFXCreditCardAccountFrom)
			source = (IOFXCreditCardAccountFrom) obj;
		else if (obj instanceof OFXBankTransactionList)
			transactionList = (IOFXBankTransactionList) obj;
		else if (obj instanceof OFXLedgerBalance) 
			ledgerBalance = (IOFXBalance) obj;
		else if (obj instanceof OFXAvailableBalance)
			availableBalance = (IOFXBalance) obj;
		else
			throw new IllegalArgumentException();
	}
	
	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransactions#setLedgerBalance(ca.piggott.ofx.model.IOFXBalance)
	 */
	@Override
	public void setLedgerBalance(IOFXBalance ledgerBalance) {
		this.ledgerBalance = ledgerBalance;
	}
	
	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransactions#getLedgerBalance()
	 */
	@Override
	public IOFXBalance getLedgerBalance() {
		return ledgerBalance;
	}
	
	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransactions#setAvailableBalance(ca.piggott.ofx.model.IOFXBalance)
	 */
	@Override
	public void setAvailableBalance(IOFXBalance availableBalance) {
		this.availableBalance = availableBalance;
	}
	
	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransactions#getAvailableBalance()
	 */
	@Override
	public IOFXBalance getAvailableBalance() {
		return availableBalance;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransactions#setCurrency(java.lang.String)
	 */
	@Override
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransactions#getCurrency()
	 */
	@Override
	public String getCurrency() {
		return currency;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransactions#setSource(ca.piggott.ofx.model.IOFXCreditCardAccountFrom)
	 */
	@Override
	public void setSource(IOFXCreditCardAccountFrom source) {
		this.source = source;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransactions#getSource()
	 */
	@Override
	public IOFXCreditCardAccountFrom getSource() {
		return source;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransactions#setTransactionList(ca.piggott.ofx.model.IOFXBankTransactionList)
	 */
	@Override
	public void setTransactionList(IOFXBankTransactionList transactionList) {
		this.transactionList = transactionList;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransactions#getTransactionList()
	 */
	@Override
	public IOFXBankTransactionList getTransactionList() {
		return transactionList;
	}

}

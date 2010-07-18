package ca.piggott.ofx.internal.model;

import ca.piggott.ofx.model.IOFXCreditCardStatementTransactionResponse;
import ca.piggott.ofx.model.IOFXCreditCardStatementTransactions;
import ca.piggott.ofx.model.IOFXStatus;
import ca.piggott.ofx.parser.impl.OFXObject;

public class OFXCreditCardStatementTransactionResponse implements OFXObject, IOFXCreditCardStatementTransactionResponse {
	private String transactionUID;
	private IOFXStatus status;
	private IOFXCreditCardStatementTransactions transactions;

	@Override
	public void addProperty(String tag, String item) {
		if (Constants.TRANSACTION_UID.equals(tag))
			transactionUID = item;
		else
			throw new IllegalArgumentException();
	}

	@Override
	public void addObject(OFXObject obj) {
		if (obj instanceof OFXStatus)
			status = (IOFXStatus) obj;
		else if (obj instanceof IOFXCreditCardStatementTransactions)
			transactions = (IOFXCreditCardStatementTransactions) obj;
		else
			throw new IllegalArgumentException();
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXCreditCardStatementTransactionResponse#getStatus()
	 */
	@Override
	public IOFXStatus getStatus() {
		return status;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXCreditCardStatementTransactionResponse#getTransactions()
	 */
	@Override
	public IOFXCreditCardStatementTransactions getTransactions() {
		return transactions;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXCreditCardStatementTransactionResponse#getTransactionUID()
	 */
	@Override
	public String getTransactionUID() {
		return transactionUID;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXCreditCardStatementTransactionResponse#setStatus(ca.piggott.ofx.model.IOFXStatus)
	 */
	@Override
	public void setStatus(IOFXStatus status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXCreditCardStatementTransactionResponse#setTransactions(ca.piggott.ofx.model.IOFXCreditCardStatementTransactions)
	 */
	@Override
	public void setTransactions(IOFXCreditCardStatementTransactions transactions) {
		this.transactions = transactions;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXCreditCardStatementTransactionResponse#setTransactionUID(java.lang.String)
	 */
	@Override
	public void setTransactionUID(String transactionUID) {
		assert(transactionUID.length() <= 36);
		this.transactionUID = transactionUID;
	}
}

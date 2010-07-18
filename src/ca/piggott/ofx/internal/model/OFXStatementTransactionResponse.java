package ca.piggott.ofx.internal.model;

import ca.piggott.ofx.model.IOFXStatementTransactionResponse;
import ca.piggott.ofx.model.IOFXStatementTransactions;
import ca.piggott.ofx.model.IOFXStatus;
import ca.piggott.ofx.parser.impl.OFXObject;

/**
 * STMTTRNRS
 */
public class OFXStatementTransactionResponse implements OFXObject, IOFXStatementTransactionResponse {
	private String transactionUID;
	private IOFXStatus status;
	private IOFXStatementTransactions transactions;

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
		else if (obj instanceof OFXStatementTransactions)
			transactions = (IOFXStatementTransactions) obj;
		else
			throw new IllegalArgumentException();
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransactionResponse#setStatus(ca.piggott.ofx.internal.model.OFXStatus)
	 */
	@Override
	public void setStatus(IOFXStatus status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransactionResponse#getStatus()
	 */
	@Override
	public IOFXStatus getStatus() {
		return status;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransactionResponse#setTransactionUID(java.lang.String)
	 */
	@Override
	public void setTransactionUID(String transactionUID) {
		this.transactionUID = transactionUID;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransactionResponse#getTransactionUID()
	 */
	@Override
	public String getTransactionUID() {
		return transactionUID;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransactionResponse#setTransactions(ca.piggott.ofx.internal.model.OFXStatementTransactions)
	 */
	@Override
	public void setTransactions(IOFXStatementTransactions transactions) {
		this.transactions = transactions;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransactionResponse#getTransactions()
	 */
	@Override
	public IOFXStatementTransactions getTransactions() {
		return transactions;
	}

}

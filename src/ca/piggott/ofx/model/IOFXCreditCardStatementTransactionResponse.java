package ca.piggott.ofx.model;

public interface IOFXCreditCardStatementTransactionResponse {

	/**
	 * Get the response {@code IOFXStatus}
	 * @return the status
	 */
	public IOFXStatus getStatus();

	/**
	 * Get the credit card statement transactions.
	 * @return the transactions
	 */
	public IOFXCreditCardStatementTransactions getTransactions();

	public String getTransactionUID();

	public void setStatus(IOFXStatus status);

	public void setTransactions(IOFXCreditCardStatementTransactions transactions);

	public void setTransactionUID(String transactionUID);
}
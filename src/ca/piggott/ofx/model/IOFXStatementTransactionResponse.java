package ca.piggott.ofx.model;

public interface IOFXStatementTransactionResponse {

	public void setStatus(IOFXStatus status);

	public IOFXStatus getStatus();

	public void setTransactionUID(String transactionUID);

	public String getTransactionUID();

	public void setTransactions(IOFXStatementTransactions transactions);

	public IOFXStatementTransactions getTransactions();

}
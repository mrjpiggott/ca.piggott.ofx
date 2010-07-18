package ca.piggott.ofx.model;


public interface IOFXBankingMessage {

	public void setResp(IOFXStatementTransactionResponse resp);

	public IOFXStatementTransactionResponse getResp();
}
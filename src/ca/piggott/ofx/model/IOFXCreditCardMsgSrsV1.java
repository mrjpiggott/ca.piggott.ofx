package ca.piggott.ofx.model;


public interface IOFXCreditCardMsgSrsV1 {

	public void setResponse(IOFXCreditCardStatementTransactionResponse response);

	public IOFXCreditCardStatementTransactionResponse getResponse();
}
package ca.piggott.ofx.model;


public interface IOFXRoot {

	public abstract IOFXBankingMessage getBankingMsg();

	public abstract IOFXSignOnMessageServiceV1 getSignOnMsg();

	public abstract void setBankingMsg(IOFXBankingMessage bankingMsg);

	public abstract void setSignOnMsg(IOFXSignOnMessageServiceV1 signOnMsg);

}
package ca.piggott.ofx.model;


public interface IOFXCreditCardStatementTransactions {

	public void setLedgerBalance(IOFXBalance ledgerBalance);

	public IOFXBalance getLedgerBalance();

	public void setAvailableBalance(IOFXBalance availableBalance);

	public IOFXBalance getAvailableBalance();

	public void setCurrency(String currency);

	public String getCurrency();

	public void setSource(IOFXCreditCardAccountFrom source);

	public IOFXCreditCardAccountFrom getSource();

	public void setTransactionList(IOFXBankTransactionList transactionList);

	public IOFXBankTransactionList getTransactionList();

}
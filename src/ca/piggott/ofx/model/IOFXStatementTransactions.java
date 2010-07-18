package ca.piggott.ofx.model;

/**
 * Statement response aggregate.
 */
public interface IOFXStatementTransactions {

	/**
	 * <p>The balance available in the account. 
	 * @return the available balance
	 */
	public IOFXBalance getAvailableBalance();

	/**
	 * <p>The currency the transactions are calculated in.
	 * <p>OFX 2.1.1 specifies 3-digit country codes.
	 * @return the currency
	 */
	public String getCurrency();

	/**
	 * <p>Get the ledger balance amount.
	 * @return
	 */
	public IOFXBalance getLedgerBalance();

	/**
	 * Get the bank account source.
	 * @return
	 */
	public IOFXBankAccount getSource();

	/**
	 * Get the list of transactions.
	 * @return 
	 */
	public IOFXBankTransactionList getTransactionList();

	public void setAvailableBalance(IOFXBalance availableBalance);

	public void setCurrency(String currency);

	public void setLedgerBalance(IOFXBalance ledgerBalance);

	public void setSource(IOFXBankAccount source);

	public void setTransactionList(IOFXBankTransactionList transactionList);
}
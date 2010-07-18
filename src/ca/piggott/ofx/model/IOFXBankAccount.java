package ca.piggott.ofx.model;

public interface IOFXBankAccount {

	/**
	 * <p>Get the account ID.
	 * <p>OFX 2.1.1 specifies 22 character length
	 * @return the account id
	 */
	public String getAccountID();

	/**
	 * <p>Get the bank ID.
	 * <p>OFX 2.1.1 specifies 9 character length
	 * @return
	 */
	public String getBankID();

	/**
	 * <p>Get the {@code AccountType}
	 * @return the account type
	 */
	public AccountType getType();

	/**
	 * <p>Set the account id.
	 * <p>OFX 2.1.1 specifies 22 character length
	 * @param accountId the account id
	 */
	public void setAccountID(String accountId);

	/**
	 * <p>Set the bank ID.
	 * <p>OFX 2.1.1 specifies 9 character length
	 * @param bankId the bank id
	 */
	public void setBankID(String bankId);

	/**
	 * <p>Get the {@code AccountType}
	 * @param type the account type
	 */
	public void setType(AccountType type);
}
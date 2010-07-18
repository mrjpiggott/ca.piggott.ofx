package ca.piggott.ofx.internal.model;

import ca.piggott.ofx.model.AccountType;
import ca.piggott.ofx.model.IOFXBankAccount;
import ca.piggott.ofx.parser.impl.OFXObject;

/**
 * See BANKACCTFROM
 */
public class OFXBankAccountFrom implements OFXObject, IOFXBankAccount {
	private String bankID;
	private String accountID;
	private AccountType type;

	@Override
	public void addProperty(String tag, String item) {
		if (Constants.ACCOUNT_TYPE.equals(tag))
			setType(AccountType.getType(item));
		else if (Constants.ACCOUNT_ID.equals(tag))
			setAccountID(item);
		else if (Constants.BANK_ID.equals(tag))
			setBankID(item);
		else
			throw new IllegalArgumentException("Unknown tag:"+tag+" value:"+item);
	}

	@Override
	public void addObject(OFXObject obj) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXBankAccountFrom#setBankID(java.lang.String)
	 */
	@Override
	public void setBankID(String bankId) {
		assert(bankId.length() <= 9);
		this.bankID = bankId;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXBankAccountFrom#getBankID()
	 */
	@Override
	public String getBankID() {
		return bankID;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXBankAccountFrom#setAccountID(java.lang.String)
	 */
	@Override
	public void setAccountID(String accountId) {
		assert(accountId.length() <= 22);
		this.accountID = accountId;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXBankAccountFrom#getAccountID()
	 */
	@Override
	public String getAccountID() {
		return accountID;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXBankAccountFrom#setType(ca.piggott.ofx.model.AccountType)
	 */
	@Override
	public void setType(AccountType type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXBankAccountFrom#getType()
	 */
	@Override
	public AccountType getType() {
		return type;
	}
}

package ca.piggott.ofx.internal.model;

import ca.piggott.ofx.model.IOFXCreditCardAccountFrom;
import ca.piggott.ofx.parser.impl.OFXObject;

public class OFXCreditCardAccountFrom implements OFXObject, IOFXCreditCardAccountFrom {

	private String accountId;

	@Override
	public void addProperty(String tag, String item) {
		if (Constants.ACCOUNT_ID.equals(tag))
			accountId = item;
		else
			throw new IllegalArgumentException();
	}

	@Override
	public void addObject(OFXObject obj) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXCreditCardAccountFrom#setAccountId(java.lang.String)
	 */
	@Override
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXCreditCardAccountFrom#getAccountId()
	 */
	@Override
	public String getAccountId() {
		return accountId;
	}
}

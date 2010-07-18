package ca.piggott.ofx.internal.model;

import java.math.BigDecimal;
import java.util.Date;

import ca.piggott.ofx.model.IOFXBalance;
import ca.piggott.ofx.parser.impl.OFXObject;

public class OFXLedgerBalance implements OFXObject, IOFXBalance {

	private BigDecimal balance;
	private Date date;

	@Override
	public void addProperty(String tag, String item) {
		if (Constants.BALANCE_AMOUNT.equals(tag))
			setBalance(new BigDecimal(item));
		else if (Constants.DATE_AS_OF.equals(tag))
			setDate(Constants.parseDateTime(item));
		else
			throw new IllegalArgumentException("Unknown tag:"+tag+" value:"+item);
	}

	@Override
	public void addObject(OFXObject obj) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXBalance#setDate(java.util.Date)
	 */
	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXBalance#getDate()
	 */
	@Override
	public Date getDate() {
		return date;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXBalance#setBalance(java.math.BigDecimal)
	 */
	@Override
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXBalance#getBalance()
	 */
	@Override
	public BigDecimal getBalance() {
		return balance;
	}
}

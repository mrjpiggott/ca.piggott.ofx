package ca.piggott.ofx.internal.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import ca.piggott.ofx.model.IOFXBankTransactionList;
import ca.piggott.ofx.model.IOFXStatementTransaction;
import ca.piggott.ofx.parser.impl.OFXObject;

/**
 * BANKTRANLIST
 */
public class OFXBankTransactionList implements OFXObject, IOFXBankTransactionList {

	private Collection<IOFXStatementTransaction> transactions = new ArrayList<IOFXStatementTransaction>();

	private Date dateStart;
	private Date dateEnd;

	@Override
	public void addProperty(String tag, String item) {
		if (Constants.DATE_START.equals(tag))
			dateStart = Constants.parseDate(item);
		else if (Constants.DATE_END.equals(tag))
			dateEnd = Constants.parseDateTime(item);
		else
			throw new IllegalArgumentException();
	}

	@Override
	public void addObject(OFXObject obj) {
		if (obj instanceof OFXStatementTransaction)
			transactions.add((OFXStatementTransaction) obj);
		else
			throw new IllegalArgumentException();
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXBankTransactionList#setDateEnd(java.util.Date)
	 */
	@Override
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXBankTransactionList#getDateEnd()
	 */
	@Override
	public Date getDateEnd() {
		return dateEnd;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXBankTransactionList#setDateStart(java.util.Date)
	 */
	@Override
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXBankTransactionList#getDateStart()
	 */
	@Override
	public Date getDateStart() {
		return dateStart;
	}

	@Override
	public void setTransactions(Collection<IOFXStatementTransaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public Collection<IOFXStatementTransaction> getTransactions() {
		return transactions;
	}

}

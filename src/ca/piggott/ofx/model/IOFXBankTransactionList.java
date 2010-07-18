package ca.piggott.ofx.model;

import java.util.Collection;
import java.util.Date;

public interface IOFXBankTransactionList {

	/**
	 * <p>Get the end date for the transaction list period
	 * @return the end date
	 */
	public Date getDateEnd();

	/**
	 * <p>Get the start date for the transaction list period.
	 * @return the start date
	 */
	public Date getDateStart();

	/**
	 * <p>The collection of statement transactions for the period/
	 * @return the statement transactions
	 */
	public Collection<IOFXStatementTransaction> getTransactions();

	/**
	 * <p>Get the end date for the transaction list period
	 * @return the end date
	 */
	public void setDateEnd(Date dateEnd);

	/**
	 * <p>Get the start date for the transaction list period.
	 * @return the start date
	 */
	public void setDateStart(Date dateStart);

	/**
	 * <p>The collection of statement transactions for the period/
	 * @return the statement transactions
	 */
	public void setTransactions(Collection<IOFXStatementTransaction> transactions);

}
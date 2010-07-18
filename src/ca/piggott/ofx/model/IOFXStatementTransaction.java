package ca.piggott.ofx.model;

import java.math.BigDecimal;
import java.util.Date;

public interface IOFXStatementTransaction {

	/**
	 * Get the amount of the transaction
	 * @return the amount
	 */
	public BigDecimal getAmount();

	/**
	 * Get the date the transaction was posted to the account.
	 * @return the date
	 */
	public Date getDatePosted();

	/**
	 * <p>Get the Financial Institution Transaction ID.
	 * <p>OFX 2.1.1 specifies the field may be up to 255 characters in length.
	 * @return the FITID
	 */
	public String getFinancialInstitutionTransactionID();

	/**
	 * <p>Get additional information about the transaction.
	 * <p>OFX 2.1.1 specifies the field may be up to 255 characters in length.
	 * @return the memo
	 */
	public String getMemo();

	/**
	 * Get the name of the payee or description of the transaction.
	 * @return the name
	 */
	public String getName();

	/**
	 * Get the {@code TransactionType} of this transaction.
	 * @return the transaction type
	 */
	public TransactionType getTransactionType();

	/**
	 * Set the amount of the transaction
	 * @param the amount
	 */
	public void setAmount(BigDecimal amount);

	/**
	 * Set the date the transaction was posted to the account.
	 * @param the date
	 */
	public void setDatePosted(Date datePosted);

	/**
	 * <p>Get the Financial Institution Transaction ID.
	 * <p>OFX 2.1.1 specifies the field may be up to 255 characters in length.
	 * @return the FITID
	 */
	public void setFinancialInstitutionTransactionID(String fitid);

	/**
	 * <p>Get additional information about the transaction.
	 * <p>OFX 2.1.1 specifies up to 255 characters in length.
	 * @return the memo
	 */
	public void setMemo(String memo);

	/**
	 * Set the name of the payee or description of the transaction.
	 * @param the name
	 */
	public void setName(String name);

	/**
	 * Set the {@code TransactionType} of this transaction.
	 * @param the transaction type
	 */
	public void setTransactionType(TransactionType transactionType);

	/**
	 * Valid transaction types specified by OFX 2.1.1
	 */
	public static enum TransactionType {
		CREDIT("CREDIT"),
		DEBIT("DEBIT"),
		INT("INT"),
		DIV("DIV"),
		FEE("FEE"),
		SRVCHG("SRVCHG"),
		DEP("DEP"),
		ATM("ATM"),
		POS("POS"),
		XFER("XFER"),
		CHECK("CHECK"),
		PAYMENT("PAYMENT"),
		CASH("CASH"),
		DIRECTDEP("DIRECTDEP"),
		DIRECTDEBIT("DIRECTDEBIT"),
		REPEATPMT("REPEATPMT"),
		OTHER("OTHER");

		private String name;

		private TransactionType(String name) {
			this.name = name;
		}

		public static TransactionType getType(String name) {
			for (TransactionType type : TransactionType.values())
				if (type.name.equals(name))
					return type;
			return null;
		}
		
		public String toString() {
			return name;
		}
	}
}
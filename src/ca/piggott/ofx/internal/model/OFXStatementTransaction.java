package ca.piggott.ofx.internal.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ca.piggott.ofx.model.IOFXStatementTransaction;
import ca.piggott.ofx.parser.impl.OFXObject;

/**
 * STMTTRN
 */
public class OFXStatementTransaction implements OFXObject, IOFXStatementTransaction {
	private Date datePosted;
	private BigDecimal amount;
	private String institutionTransactionID;
	private String memo;
	private String name;
	private TransactionType transactionType;
	private Map<String, String> optional = new HashMap<String,String>();

	@Override
	public void addProperty(String tag, String item) {
		if (Constants.TRNTYPE.equals(tag))
			transactionType = TransactionType.getType(item);
		else if (Constants.DTPOSTED.equals(tag))
			datePosted = Constants.parseDateTime(item);
		else if (Constants.TRANSACTION_AMOUNT.equals(tag))
			amount = new BigDecimal(item);
		else if (Constants.FINANCIAL_INSTITUTION_TRANSACTION_ID.equals(tag))
			institutionTransactionID = item;
		else if (Constants.NAME.equals(tag))
			name = item;
		else if (Constants.MEMO.equals(tag))
			memo = item;
		else
			optional.put(tag, item);
	}

	@Override
	public void addObject(OFXObject obj) {
			throw new IllegalArgumentException();
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransaction#setDatePosted(java.util.Date)
	 */
	@Override
	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransaction#getDatePosted()
	 */
	@Override
	public Date getDatePosted() {
		return datePosted;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransaction#setAmount(java.math.BigDecimal)
	 */
	@Override
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransaction#getAmount()
	 */
	@Override
	public BigDecimal getAmount() {
		return amount;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransaction#setFitid(java.lang.String)
	 */
	@Override
	public void setFinancialInstitutionTransactionID(String institutionTransactionID) {
		this.institutionTransactionID = institutionTransactionID;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransaction#getFitid()
	 */
	@Override
	public String getFinancialInstitutionTransactionID() {
		return institutionTransactionID;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransaction#setMemo(java.lang.String)
	 */
	@Override
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransaction#getMemo()
	 */
	@Override
	public String getMemo() {
		assert(memo.length() <= 255);
		return memo;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransaction#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		assert(name.length() <= 255);
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransaction#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransaction#setTransactionType(ca.piggott.ofx.model.IOFXStatementTransaction.TransactionType)
	 */
	@Override
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatementTransaction#getTransactionType()
	 */
	@Override
	public TransactionType getTransactionType() {
		return transactionType;
	}
}

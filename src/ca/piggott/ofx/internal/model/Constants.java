package ca.piggott.ofx.internal.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {
	public static final String DATE_AS_OF = "DTASOF";

	public static final String DATE_END = "DTEND";

	public static final String DATE_START = "DTSTART";

	public static final String BANKMSGSRSV1 = "BANKMSGSRSV1";  // Banking message

	public static final String OFX = "OFX"; // Root object

	public static final String STATEMENT_TRANSACTIONS = "STMTRS";

	public static final String STATEMENT_TRANSACTION_RESPONSE = "STMTTRNRS";

	public static final String LEDGER_BALANCE = "LEDGERBAL";

	public static final String BANK_TRANSACTION_LIST = "BANKTRANLIST";

	public static final String SIGNONMSGSRSV1 = "SIGNONMSGSRSV1";

	public static final String SIGN_ON_RESPONSE = "SONRS";

	public static final String STATEMENT_TRANSACTION = "STMTTRN";

	public static final String STATUS = "STATUS";  // Message status

	public static final String BANK_ACCOUT_FROM = "BANKACCTFROM";

	public static final String AVAILBLE_BALANCE = "AVAILBAL";

	public static final String BALANCE_AMOUNT = "BALAMT";

	public static final String BANK_ID = "BANKID";

	public static final String ACCOUNT_ID = "ACCTID";

	public static final String ACCOUNT_TYPE = "ACCTTYPE";

	public static final String DTSERVER = "DTSERVER";

	public static final String LANGUAGE = "LANGUAGE";

	public static final String DTPROFUP = "DTPROFUP";

	public static final String DTACCTUP = "DTACCTUP";

	public static final String CODE = "CODE";

	public static final String SEVERITY = "SEVERITY";

	public static final String MESSAGE = "MESSAGE";

	public static final String TRNTYPE = "TRNTYPE";

	public static final String DTPOSTED = "DTPOSTED";

	public static final String TRANSACTION_AMOUNT = "TRNAMT";

	public static final String FINANCIAL_INSTITUTION_TRANSACTION_ID = "FITID";

	public static final String NAME = "NAME";

	public static final String MEMO = "MEMO";

	public static final String CURRENCY = "CURDEF";
	
	public static final String TRANSACTION_UID = "TRNUID";
	
	public static final String USERKEY = "USERKEY";
	
	public static final String CREDITCARDMSGSRSV1 = "CREDITCARDMSGSRSV1";
	
	public static final String CREDIT_CARD_STATEMENT_TRANSACTION_REPONSE = "CCSTMTTRNRS";
	
	public static final String CCACCTFROM = "CCACCTFROM";
	
	public static final String CC_STATEMENT_TRANSACTIONS = "CCSTMTRS";

	private static final SimpleDateFormat dateFormatter;
	private static final SimpleDateFormat dateTimeFormatter;
	private static final SimpleDateFormat dateTimeTZFormatter;

	public static final String CCSTMTRS = "CCSTMTRS";
	
	static {
		dateFormatter = new SimpleDateFormat("yyyyMMdd");
		dateTimeFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
		dateTimeTZFormatter = new SimpleDateFormat("yyyyMMddHHmmss.SSSzzz");
	}
	
	static Date parseDateTimeWithTZ(String date) {
		assert(date.length() == 18);
		try {
			return dateTimeTZFormatter.parse(date.substring(0,18) + date.substring(date.indexOf(':'), 3));
		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid date format: " + date);
		}
	}


	static Date parseDateTime(String date) {
		try {
			return dateTimeFormatter.parse(date);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid date format: " + date);
		}
	}
	
	static Date parseDate(String date) {
		try {
			return dateFormatter.parse(date);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid date format: " + date);
		}
	}
}

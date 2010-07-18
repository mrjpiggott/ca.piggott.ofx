package ca.piggott.ofx.model;

public enum AccountType {
	CHECKING("CHECKING"),
	SAVINGS("SAVINGS"),
	MONEYMRKT("MONEYMRKT"),
	CREDLINE("CREDLINE");

	private String name;

	private AccountType(String name) {
		this.name = name;
	}
	
	public static AccountType getType(String type) {
		for (AccountType t : AccountType.values())
			if (t.name.equals(type))
				return t;
		return null;
	}
}

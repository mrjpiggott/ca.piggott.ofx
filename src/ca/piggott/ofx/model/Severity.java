package ca.piggott.ofx.model;

public enum Severity {
	INFO("INFO"),
	WARN("WARN"),
	ERROR("ERROR");
	
	private String name;
	
	private Severity(String name) {
		this.name = name;
	}
	
	public static Severity getSeverity(String type) {
		for (Severity t : Severity.values())
			if (t.name.equals(type))
				return t;
		return null;
	}
}

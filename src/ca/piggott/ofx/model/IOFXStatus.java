package ca.piggott.ofx.model;

public interface IOFXStatus {

	public int getCode();

	public String getMessage();

	public Severity getSeverity();

	public void setCode(int code);

	public void setMessage(String message);

	public void setSeverity(Severity severity);

}
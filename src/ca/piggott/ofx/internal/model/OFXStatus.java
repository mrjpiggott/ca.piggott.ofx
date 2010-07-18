package ca.piggott.ofx.internal.model;

import ca.piggott.ofx.model.IOFXStatus;
import ca.piggott.ofx.model.Severity;
import ca.piggott.ofx.parser.impl.OFXObject;

public class OFXStatus implements OFXObject, IOFXStatus {

	private int code;
	private Severity severity;
	private String message;

	@Override
	public void addProperty(String tag, String item) {
		if (Constants.CODE.equals(tag))
			setCode(Integer.parseInt(item));
		else if (Constants.SEVERITY.equals(tag))
			setSeverity(Severity.getSeverity(tag));
		else if (Constants.MESSAGE.equals(tag))
			setMessage(tag);
		else
			throw new IllegalArgumentException();
	}

	@Override
	public void addObject(OFXObject obj) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatus#getCode()
	 */
	@Override
	public int getCode() {
		return code;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatus#getMessage()
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatus#getSeverity()
	 */
	@Override
	public Severity getSeverity() {
		return severity;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatus#setCode(int)
	 */
	@Override
	public void setCode(int code) {
		this.code = code;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatus#setMessage(java.lang.String)
	 */
	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXStatus#setSeverity(java.lang.String)
	 */
	@Override
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}
}

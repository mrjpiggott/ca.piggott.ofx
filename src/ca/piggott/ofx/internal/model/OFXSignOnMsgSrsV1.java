package ca.piggott.ofx.internal.model;

import ca.piggott.ofx.model.IOFXSignOnMessageServiceV1;
import ca.piggott.ofx.model.IOFXSignOnResponse;
import ca.piggott.ofx.parser.impl.OFXObject;

public class OFXSignOnMsgSrsV1 implements OFXObject, IOFXSignOnMessageServiceV1 {
	private IOFXSignOnResponse signOnResponse;

	@Override
	public void addProperty(String tag, String item) {
			throw new IllegalArgumentException();
	}

	public void addObject(OFXObject obj) {
		if (obj instanceof OFXSignOnResponse)
			signOnResponse = (IOFXSignOnResponse) obj;
		else
			throw new IllegalArgumentException();
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXSignOnMessageServiceV1#setSignOnResponse(ca.piggott.ofx.internal.model.OFXSignOnResponse)
	 */
	@Override
	public void setSignOnResponse(IOFXSignOnResponse signOnResponse) {
		this.signOnResponse = signOnResponse;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXSignOnMessageServiceV1#getSignOnResponse()
	 */
	@Override
	public IOFXSignOnResponse getSignOnResponse() {
		return signOnResponse;
	}
}

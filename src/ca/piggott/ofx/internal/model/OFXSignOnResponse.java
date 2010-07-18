package ca.piggott.ofx.internal.model;

import java.util.Date;

import ca.piggott.ofx.model.IOFXSignOnResponse;
import ca.piggott.ofx.model.IOFXStatus;
import ca.piggott.ofx.parser.impl.OFXObject;

public class OFXSignOnResponse implements OFXObject, IOFXSignOnResponse {
	private Date serverDate;
	private Date dateProfileUpdated;
	private Date dateAccountUpdated;
	private String language;
	private IOFXStatus status;
	private String userKey;

	@Override
	public void addProperty(String tag, String item) {
		if (Constants.DTSERVER.equals(tag))
			serverDate = Constants.parseDateTime(item);
		else if (Constants.LANGUAGE.equals(tag))
			language = item;
		else if (Constants.DTPROFUP.equals(tag))
			dateProfileUpdated = Constants.parseDateTime(item);
		else if (Constants.DTACCTUP.equals(tag))
			dateAccountUpdated = Constants.parseDateTime(item);
		else if (Constants.USERKEY.equals(tag)) {
			setUserKey(item);
		} else if ("INTU.BID".equals(tag) || "INTU.USERID".equals(tag)) {
			// These are apparently used by Intuit to force banks to give them cash
		} else
			throw new IllegalArgumentException("Unknown tag:"+tag+" value:"+item);
	}

	@Override
	public void addObject(OFXObject obj) {
		if (obj instanceof OFXStatus)
			status = (IOFXStatus) obj;
		else 
			throw new IllegalArgumentException();
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXSignOnResponse#setServerDate(java.util.Date)
	 */
	@Override
	public void setServerDate(Date serverDate) {
		this.serverDate = serverDate;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXSignOnResponse#getServerDate()
	 */
	@Override
	public Date getServerDate() {
		return serverDate;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXSignOnResponse#setDateProfileUpdated(java.util.Date)
	 */
	@Override
	public void setDateProfileUpdated(Date dateProfileUpdated) {
		this.dateProfileUpdated = dateProfileUpdated;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXSignOnResponse#getDateProfileUpdated()
	 */
	@Override
	public Date getDateProfileUpdated() {
		return dateProfileUpdated;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXSignOnResponse#setDateAccountUpdated(java.util.Date)
	 */
	@Override
	public void setDateAccountUpdated(Date dateAccountUpdated) {
		this.dateAccountUpdated = dateAccountUpdated;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXSignOnResponse#getDateAccountUpdated()
	 */
	@Override
	public Date getDateAccountUpdated() {
		return dateAccountUpdated;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXSignOnResponse#setLanguage(java.lang.String)
	 */
	@Override
	public void setLanguage(String language) {
		assert(language.length() == 3);
		this.language = language;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXSignOnResponse#getLanguage()
	 */
	@Override
	public String getLanguage() {
		return language;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXSignOnResponse#setStatus(ca.piggott.ofx.internal.model.OFXStatus)
	 */
	@Override
	public void setStatus(IOFXStatus status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXSignOnResponse#getStatus()
	 */
	@Override
	public IOFXStatus getStatus() {
		return status;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public String getUserKey() {
		return userKey;
	}

	
}

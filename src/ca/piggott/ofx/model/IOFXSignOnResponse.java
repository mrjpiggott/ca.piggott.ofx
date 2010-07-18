package ca.piggott.ofx.model;

import java.util.Date;


public interface IOFXSignOnResponse {

	/**
	 * Get the date the account was updated.
	 * @return the date
	 */
	public Date getDateAccountUpdated();

	/**
	 * Get the date the profile was updated.
	 * @return the date
	 */
	public Date getDateProfileUpdated();

	/**
	 * Get the language
	 * @return the language
	 */
	public String getLanguage();

	/**
	 * Get the date of the server
	 * @return the date
	 */
	public Date getServerDate();

	/**
	 * Get the response status
	 * @return the status
	 */
	public IOFXStatus getStatus();

	/**
	 * 
	 * @param dateAccountUpdated
	 */
	public void setDateAccountUpdated(Date dateAccountUpdated);

	/**
	 * 
	 * @param dateProfileUpdated
	 */
	public void setDateProfileUpdated(Date dateProfileUpdated);

	/**
	 * <p>Set the language 
	 * @param language the language
	 */
	public void setLanguage(String language);

	/**
	 * 
	 * @param serverDate
	 */
	public void setServerDate(Date serverDate);

	/**
	 * 
	 * @param status
	 */
	public void setStatus(IOFXStatus status);
}
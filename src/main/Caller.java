package main;

import java.util.Date;

/**
 * A class meant to represent a caller and store their data
 * @author Alessandro Cavicchioli
 * @version 1.0
 */
public class Caller 
{
	private String name;
	private String phoneNumber;
	private Date callDateTime;
	
	/**
	 * Creates a caller object with the given parameters and the current date and time
	 * @param name the name of the caller
	 * @param phoneNumber the phone number of the caller
	 */
	public Caller(String name, String phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.callDateTime = new Date();
	}

	/**
	 * Returns the name of this caller
	 * @return the name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Returns the phone number of this caller
	 * @return the phone number
	 */
	public String getPhoneNumber() 
	{
		return phoneNumber;
	}

	/**
	 * Returns the date and time this call was
	 * @return the date and time
	 */
	public Date getCallDateTime() 
	{
		return callDateTime;
	}
	
	/**
	 * Returns a printable representation of this caller name and phone number, as well as
	 * how long it has been waiting for
	 */
	@Override
	public String toString()
	{
		long timeWaited = new Date().getTime() - callDateTime.getTime();
		return name + " - " + phoneNumber + "\nTime waited: " + timeWaited + "seconds";
	}
}
package com.emmanuelagboola.daofab.advice;

/*
 * Class that handles messages resulting from DaofabException
 */
public class DaofabErrorMessage {

  	private String message;
  	private int statusCode;
  
  	/*
  	 * Constructor for DaofabException
  	 * @param String message The message of the exception
  	 * @param int  statusCode The exception status code
  	 */
	public DaofabErrorMessage(String message, int  statusCode) {
		this.message = message;
		this.statusCode = statusCode;
	}

	/*
	 * Getter to return the message value
	 */
	public String getMessage() {
		return message;
	}
	/*
	 * Setter to set the message value
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/*
	 * Getter to return the status code
	 */
	public int getStatusCode() {
		return statusCode;
	}
	/*
	 * Setter to set the status code
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
		
}

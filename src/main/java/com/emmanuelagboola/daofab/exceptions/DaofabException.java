package com.emmanuelagboola.daofab.exceptions;

/*
 * Custom exception class that handles exceptions resulting from daofab application
 */
public class DaofabException extends Exception {

	private String message;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* 
	 * DaofabException constructor
	 * @param String message
	 */
	public DaofabException (String message){
		super(message);
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}

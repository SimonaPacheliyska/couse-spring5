package com.fmi.spring5.exception;

public class NonExistingEntityException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public NonExistingEntityException(String message) {
		this.message = message;
		System.out.println(message);
	}

}

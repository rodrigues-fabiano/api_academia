package com.residencia.academia.exception;

@SuppressWarnings("serial")
public class NoSuchElementFoundException extends RuntimeException {

	public NoSuchElementFoundException(String message) {
		super(message);
	}
}

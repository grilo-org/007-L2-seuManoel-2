package com.seuManoel.seuManoel.exception;

public class ProdutoIncompativelException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ProdutoIncompativelException(String message) {
		super(message);
	}
}
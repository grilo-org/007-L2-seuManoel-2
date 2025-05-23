package com.seuManoel.seuManoel.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProdutoIncompativelException.class)
	public ResponseEntity<String> handleProdutoIncompativel(ProdutoIncompativelException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
}

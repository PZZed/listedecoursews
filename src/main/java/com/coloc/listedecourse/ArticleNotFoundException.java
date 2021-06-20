package com.coloc.listedecourse;

public class ArticleNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 8685896945608579062L;

	public ArticleNotFoundException(String message) {
		super(message);
	}
}

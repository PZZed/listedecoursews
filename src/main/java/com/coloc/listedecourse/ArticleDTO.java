package com.coloc.listedecourse;

import lombok.Data;

@Data
public class ArticleDTO {
	private Long id;
	private String name;
	private String category;
	private Integer quantity;
}

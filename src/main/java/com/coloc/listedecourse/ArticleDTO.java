package com.coloc.listedecourse;

import lombok.Data;

@Data
public class ArticleDTO {
	private Long id;
	private String name;
	private String categorie;
	private Integer quantity;
}

package com.coloc.listedecourse;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

	Article toEntity(ArticleDTO dto);

	ArticleDTO toDTO(Article entity);

	List<ArticleDTO> toDTO(List<Article> entity);
}

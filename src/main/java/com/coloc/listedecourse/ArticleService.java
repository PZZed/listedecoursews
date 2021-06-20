package com.coloc.listedecourse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private ArticleMapper mapper;

	public Long create(ArticleDTO dto) {
		Article entity = mapper.toEntity(dto);
		return articleRepository.save(entity).getId();
	}

	public List<ArticleDTO> getAll() {
		return mapper.toDTO(articleRepository.findAll());
	}

	public ArticleDTO getById(Long id) {
		Optional<Article> articleRequeset = articleRepository.findById(id);
		if (articleRequeset.isPresent()) {
			return mapper.toDTO(articleRequeset.get());
		}
		throw new ArticleNotFoundException(String.format("L'article avec l'id : {id} n'existe pas", id));
	}

	public void deleteAll() {
		articleRepository.deleteAll();
	}

	public void deleteById(Long id) {
		articleRepository.deleteById(id);
	}

}

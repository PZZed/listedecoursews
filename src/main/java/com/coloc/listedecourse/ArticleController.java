package com.coloc.listedecourse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody ArticleDTO article) {
		Long id = articleService.create(article);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<List<ArticleDTO>> getAll() {
		return ResponseEntity.ok(articleService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ArticleDTO> getById(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(articleService.getById(id));
		} catch (ArticleNotFoundException e) {
			return new ResponseEntity<ArticleDTO>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping
	public ResponseEntity<Void> deleteAll() {
		articleService.deleteAll();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
		articleService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}

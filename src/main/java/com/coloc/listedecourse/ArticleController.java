package com.coloc.listedecourse;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody ArticleDTO article, UriComponentsBuilder componentBuilder) {

		Long id = articleService.create(article);
		UriComponents component = componentBuilder.path("/api/article/{id}").buildAndExpand(id);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(component.toUri());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<List<ArticleDTO>> getAll() {
		return ResponseEntity.ok(articleService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ArticleDTO> getById(@PathParam("id") Long id) {
		try {
			return ResponseEntity.ok(articleService.getById(id));
		} catch (ArticleNotFoundException e) {
			return new ResponseEntity<ArticleDTO>(HttpStatus.NOT_FOUND);
		}

	}

}

package com.STARZ.games.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.STARZ.games.model.Categoria;
import com.STARZ.games.repository.categoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins="*", allowedHeaders="*")
public class categoriaController {

	@Autowired
	private categoriaRepository repository;
	
	@GetMapping 
	public ResponseEntity<List<Categoria>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Categoria>> findByDescricao(@PathVariable String descricao){
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.findAllByDescricaoIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> post(@RequestBody Categoria categoria){
		return ResponseEntity.ok(repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> putProduto(@RequestBody Categoria categoria){
		return ResponseEntity.ok(repository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable long id) {
		repository.deleteById(id);
	}
}






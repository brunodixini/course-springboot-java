package com.example.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.Product;
import com.example.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	// notacao para mostrar que este é o ponto de injecao de dependencia da classe ProductService
	@Autowired
	private ProductService service;
	
	// anotation pra falar que esse metodo responde a uma requisicao do tipo get do http
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// este value indica que a requisicao vai aceitar um id dentro da url
	@GetMapping(value="/{id}")
	// pro spring considerar que o parametro de entrada da funcao é o que vem do url, usa-se o @PathVariable 
	public ResponseEntity<Product> findById(@PathVariable Long id ) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}


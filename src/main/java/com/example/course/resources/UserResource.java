package com.example.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.User;
import com.example.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	// notacao para mostrar que este é o ponto de injecao de dependencia da classe UserService
	@Autowired
	private UserService service;
	
	// anotation pra falar que esse metodo responde a uma requisicao do tipo get do http
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// este value indica que a requisicao vai aceitar um id dentro da url
	@GetMapping(value="/{id}")
	// pro spring considerar que o parametro de entrada da funcao é o que vem do url, usa-se o @PathVariable 
	public ResponseEntity<User> findById(@PathVariable Long id ) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}


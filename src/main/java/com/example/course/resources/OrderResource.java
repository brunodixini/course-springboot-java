package com.example.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.Order;
import com.example.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	// notacao para mostrar que este é o ponto de injecao de dependencia da classe OrderService
	@Autowired
	private OrderService service;
	
	// anotation pra falar que esse metodo responde a uma requisicao do tipo get do http
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// este value indica que a requisicao vai aceitar um id dentro da url
	@GetMapping(value="/{id}")
	// pro spring considerar que o parametro de entrada da funcao é o que vem do url, usa-se o @PathVariable 
	public ResponseEntity<Order> findById(@PathVariable Long id ) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}


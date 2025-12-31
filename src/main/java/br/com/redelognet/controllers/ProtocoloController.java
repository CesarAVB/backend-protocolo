package br.com.redelognet.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.redelognet.entities.Protocolo;
import br.com.redelognet.services.ProtocoloService;

@RestController
@RequestMapping("/api/v1/protocolo")
public class ProtocoloController {

	@Autowired
	private ProtocoloService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Protocolo> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Protocolo findById(@PathVariable("id") Integer id) {
		return service.findById(id);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		service.delete(id);
	}
}

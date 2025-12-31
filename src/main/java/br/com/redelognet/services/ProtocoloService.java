package br.com.redelognet.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.redelognet.entities.Protocolo;
import br.com.redelognet.exception.ResourceNotFoundException;
import br.com.redelognet.repositories.ProtocoloRepository;

@Service
public class ProtocoloService {

	private Logger logger = Logger.getLogger(ProtocoloService.class.getName());
	
	@Autowired
	private ProtocoloRepository repository;

	public List<Protocolo> findAll() {
		logger.info("Buscando todos os protocolos!");	 
		return repository.findAll();
	}
	
	public Protocolo findById(Integer id) {
		logger.info("Buscando protocolo!");
		return repository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Nenhum resultado encontrado para este ID.") );
	}
	
	public void delete(Integer id) {
		logger.info("Apagando protocolo!");
		Protocolo protocolo = repository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Nenhum resultado encontrado para este ID.") );
		repository.delete(protocolo);
	}
	
}

package br.com.mario.abaco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mario.abaco.model.Sistema;
import br.com.mario.abaco.repository.SistemaRepository;

@Service
public class SistemaService {
	
	@Autowired
	private SistemaRepository repo;
	
	public Sistema findByNome(String nome){
		return repo.findByNome(nome);
	}

}

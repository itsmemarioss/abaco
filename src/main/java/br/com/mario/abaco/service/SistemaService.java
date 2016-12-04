package br.com.mario.abaco.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mario.abaco.model.ConfiguracaoException;
import br.com.mario.abaco.model.Sistema;
import br.com.mario.abaco.repository.ConfiguracaoRepository;
import br.com.mario.abaco.repository.SistemaRepository;

@Service
public class SistemaService {
	
	@Autowired
	private SistemaRepository repo;
	
	@Autowired
	private ConfiguracaoRepository conf;
	
	public Sistema findByNome(String nome){
		return repo.findByNome(nome);
	}
	
	public void save(Sistema sistema) throws ConfiguracaoException{

		String root = null;
		
		try{
			root = conf.findOne(1l).getPasta();
			Files.createDirectories(Paths.get(root, sistema.getNome()));
		}catch(NullPointerException e){
			throw new ConfiguracaoException("Configuração para upload de arquivos não definida");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Path folder = Paths.get(root);
		
		repo.save(sistema);

		try {
			Files.createDirectories(folder);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

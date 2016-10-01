package br.com.mario.abaco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mario.abaco.model.Instituicao;

public interface InstituicoesRepository extends JpaRepository<Instituicao, String> {

}

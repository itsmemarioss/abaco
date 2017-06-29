package br.edu.ufca.abaco.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDAO<E,I> {
	
	@PersistenceContext
	EntityManager entityManager;
	private final Class<E> entityClass;
	
	public GenericDAO(Class clazz){
		entityClass = clazz;
	}
	
	public void salvar(E entity){
		entityManager.persist(entity);
	}
	
	public E atualizar(E entity){
		return entityManager.merge(entity);
	}
	
	public Optional<E> buscar(I id){
		return Optional.ofNullable(entityManager.find(entityClass, id));
	}
}

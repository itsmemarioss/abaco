package br.edu.ufca.abaco.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author mario
 *
 * @param <E> Tipo da Entidade
 * @param <K> Tipo da chave primária
 */
public class DAOGenerico<E, K> {
	
	@PersistenceContext
	private EntityManager em;
	
	private Class<E> clazz;
	
	public DAOGenerico(Class<E> clazz){
		this.clazz = clazz;
	}
	
	public void atualizar(E e){
		em.merge(e);
	}
	
	public void salvar(E e){
		em.persist(e);
	}
	
	public void setEntityManager(EntityManager entityManager){
		em = entityManager;
	}

}

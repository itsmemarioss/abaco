package br.edu.ufca.abaco.core.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author mario
 *
 * @param <E> Tipo da Entidade
 * @param <K> Tipo da chave primária
 */
public abstract class DAOGenerico<E extends BaseEntity<K>, K> implements Serializable{
	
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
	
	public void excluir(K key) {
        E entityToBeRemoved = em.getReference(clazz, key);
        em.remove(entityToBeRemoved);
    }

    public E buscarPorId(K key) {
        return em.find(clazz, key);
    }

	public List<E> listar(){
		return em.createQuery("from "+ clazz.getName(), clazz).getResultList();
	}
	
	public void setEntityManager(EntityManager entityManager){
		em = entityManager;
	}

}

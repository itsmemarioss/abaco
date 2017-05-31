

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.edu.ufca.abaco.core.FuncaoDeDado;
import br.edu.ufca.abaco.core.TipoFuncaoDado;

public class Main {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("abaco").createEntityManager();
		System.out.println("EntityManager criado com sucesso!!");
		
		FuncaoDeDado funcao = new FuncaoDeDado(0, 0, TipoFuncaoDado.ALI);
		
		em.getTransaction().begin();
		em.persist(funcao);
		em.getTransaction().commit();
		
		System.out.println("Registro salvo com sucesso");
		
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.submit(() -> System.out.println("..."));
	}

}

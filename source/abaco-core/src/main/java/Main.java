

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("abaco").createEntityManager();
		System.out.println("EntityManager criado com sucesso!!");

	}

}

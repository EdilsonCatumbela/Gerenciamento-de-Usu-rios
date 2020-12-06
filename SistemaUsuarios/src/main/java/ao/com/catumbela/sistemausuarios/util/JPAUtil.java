package ao.com.catumbela.sistemausuarios.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("UsuariosPU");

	
	public static EntityManager getEntityManager() {
		EntityManager sessao = fabrica.createEntityManager();

		return sessao;
	}

}

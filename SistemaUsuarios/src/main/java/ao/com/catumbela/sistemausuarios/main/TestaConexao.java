package ao.com.catumbela.sistemausuarios.main;

import javax.persistence.EntityManager;

import ao.com.catumbela.sistemausuarios.util.JPAUtil;

public class TestaConexao {

	public static void main(String[] args) {
			
		EntityManager sessao = JPAUtil.getEntityManager();
		sessao.close();
		

	}

}

package ao.com.catumbela.sistemausuarios.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ao.com.catumbela.sistemausuarios.domain.Cargo;
import ao.com.catumbela.sistemausuarios.util.JPAUtil;

public class CargoDAO {
	public void salvar(Cargo cargo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.persist(cargo);
		transacao.commit();
		sessao.close();

	}

	public Cargo buscar(Long codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		Cargo cargo = sessao.find(Cargo.class, codigo);
		return cargo;

	}

	@SuppressWarnings("unchecked")
	public List<Cargo> listar() {
		String jpql = "select p from Cargo p order by nomeCargo";
		EntityManager sessao = JPAUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		List<Cargo> resultado = consulta.getResultList();
		return resultado;

	}
	
	public void excluir(Long codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		Cargo cargo= sessao.find(Cargo.class, codigo);
		sessao.remove(cargo);
		transacao.commit();
		sessao.close();
	}
	
	public void editar(Cargo cargo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin(); 
		sessao.merge(cargo);
		transacao.commit();
		sessao.close();
	}
	
	public void merge(Cargo cargo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.merge(cargo);
		transacao.commit();
		sessao.close();

	}


}

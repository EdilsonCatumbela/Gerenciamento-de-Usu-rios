package ao.com.catumbela.sistemausuarios.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import ao.com.catumbela.sistemausuarios.dao.CargoDAO;
import ao.com.catumbela.sistemausuarios.dao.UsuarioDAO;
import ao.com.catumbela.sistemausuarios.domain.Cargo;
import ao.com.catumbela.sistemausuarios.domain.Usuario;
import lombok.Data;

@SuppressWarnings("serial")
@Named
@ViewScoped
@Data
public class UsuarioBean implements Serializable {
	private Usuario usuario;
	private List<Usuario> usuarios;
	private CargoDAO cargoDAO;
	private List<Cargo> cargos;
	private UsuarioDAO usuarioDAO;

	@PostConstruct
	public void listar() {
		try {

			cargoDAO = new CargoDAO();

			UsuarioDAO usuarioDAO = new UsuarioDAO();

			usuario = new Usuario();
			cargos = cargoDAO.listar();
			usuarios = usuarioDAO.listar();

		} catch (Exception erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os usuarios");
			erro.printStackTrace();
		}
	}

	public void novo() {
		usuario = new Usuario();
	}

	public void salvar() {
		try {

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.merge(usuario);

			usuario = new Usuario();
			cargoDAO = new CargoDAO();
			usuarios = usuarioDAO.listar();
			cargos = cargoDAO.listar();

			Messages.addFlashGlobalInfo("usuário salvo com sucesso");
		} catch (Exception erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar os usuarios");
			erro.printStackTrace();

		}
	}

	public void excluir(Usuario usuarioSeleciondo) {
		try {
			usuario = usuarioSeleciondo;
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.excluir(usuario.getCodigo());
			Messages.addGlobalInfo("Usuário removido com sucesso");

			usuarios = usuarioDAO.listar();

			// Messages.addGlobalInfo("Nome: " + usuario.getNome() + "cpf: " +
			// usuario.getCpf() + "data: " + usuario.getDataNascimento() + "Sexo: " +
			// usuario.getSexo() + "Cargo: " + usuario.getCargo());

		} catch (Exception erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover os usuarios");
			erro.printStackTrace();

		}
	}

	public void editar(Usuario usuarioSeleciondo) {
		usuario = usuarioSeleciondo;
	}

}

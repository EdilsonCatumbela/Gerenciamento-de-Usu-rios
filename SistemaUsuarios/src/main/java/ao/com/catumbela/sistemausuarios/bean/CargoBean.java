package ao.com.catumbela.sistemausuarios.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import ao.com.catumbela.sistemausuarios.dao.CargoDAO;
import ao.com.catumbela.sistemausuarios.domain.Cargo;
import lombok.Data;

@SuppressWarnings("serial")
@Named
@ViewScoped
@Data
public class CargoBean implements Serializable {
	private Cargo cargo;
	private List<Cargo> cargos;

	@PostConstruct
	public void listar() {
		try {
			CargoDAO cargoDAO = new CargoDAO();
			cargo = new Cargo();
			cargos = cargoDAO.listar();

		} catch (Exception erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os cargos");
			erro.printStackTrace();
		}
	}

	public void novo() {
		cargo = new Cargo();
	}

	public void salvar() {
		try {

			CargoDAO cargoDAO = new CargoDAO();
			cargoDAO.merge(cargo);
			novo();
			cargos = cargoDAO.listar();
			Messages.addGlobalInfo("Cargo salvo com sucesso");

		} catch (Exception erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o cargo");
			erro.printStackTrace();
		}

	}

	public void excluir(Cargo cargoSelecionado) {
		try {

			cargo = cargoSelecionado;
			CargoDAO cargoDAO = new CargoDAO();
			cargoDAO.excluir(cargo.getCodigo());
			cargos = cargoDAO.listar();
			Messages.addGlobalInfo("Cargo removido com sucesso");

		} catch (Exception erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o cargo");
			erro.printStackTrace();
		}
	}

	public void editar(Cargo cargoSelecionado) {
			cargo = cargoSelecionado;
	}

}

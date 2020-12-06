package ao.com.catumbela.sistemausuarios.dao;

import org.junit.Test;

import ao.com.catumbela.sistemausuarios.domain.Cargo;

public class CargoDAOTest {
	
	@Test
	public void salvar() {
		
		Cargo cargo = new Cargo();
		cargo.setNomeCargo("Gerente");
		
		CargoDAO cargoDAO = new CargoDAO();
		cargoDAO.salvar(cargo);
		
	}

}

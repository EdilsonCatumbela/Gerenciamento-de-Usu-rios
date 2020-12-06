package ao.com.catumbela.sistemausuarios.dao;

import java.time.LocalDate;

import org.junit.Test;

import ao.com.catumbela.sistemausuarios.domain.Cargo;
import ao.com.catumbela.sistemausuarios.domain.Usuario;

public class UsuarioDAOTest {
	
	@Test
	public void salvar() {
		
		CargoDAO  cargoDAO = new CargoDAO();
		Cargo cargo = cargoDAO.buscar(1L);
		
		Usuario u1 = new Usuario();
		//p1.setCodigo(1L);
		u1.setNome("Edilson Fonseca Catumbela");
		u1.setCpf("777-777");
		u1.setDataNascimento(LocalDate.of(2020, 12, 05));
		u1.setSexo('M');
		//u1.setCargo(cargo);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(u1);
		
		
	}

}

package ao.com.catumbela.sistemausuarios.domain;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		
		Usuario usuario1 = new Usuario();
		usuario1.setCodigo(1L);
		usuario1.setNome("Edilson Fonseca Catumbela");;
		usuario1.setCpf("77777-777");
		usuario1.setDataNascimento(LocalDate.of(1991, 02, 06));
		usuario1.setSexo('M');
		//usuario1.setCargo("Adm");
		
		System.out.println( usuario1.getCodigo() + ". "+usuario1.getNome());
		

	}

}

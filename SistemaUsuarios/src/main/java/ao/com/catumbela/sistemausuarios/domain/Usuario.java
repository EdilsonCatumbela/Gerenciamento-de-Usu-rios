package ao.com.catumbela.sistemausuarios.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends Pessoa {
	
	@OneToOne
	@JoinColumn(nullable = false)
	@NotNull(message = "O campo cargo é obrigatório")
	private Cargo cargo;
	
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}

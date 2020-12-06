package ao.com.catumbela.sistemausuarios.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column (length = 50, nullable = false, unique = true)
	private String nome;
	
	@Column(length = 14, nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private LocalDate dataNascimento;
	
	private char sexo; 

}

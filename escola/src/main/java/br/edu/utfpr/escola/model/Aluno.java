package br.edu.utfpr.escola.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries(@NamedQuery(name="Aluno.dataNascimentoMenorQue"
				, query="select a from Aluno a "
						+ "where a.dataNascimento <= ?1"))
public class Aluno {

	@Id
	@SequenceGenerator(name="aluno_seq",sequenceName="aluno_seq")
	@GeneratedValue(generator="aluno_seq",
			strategy = GenerationType.SEQUENCE)
	private Long codigo;
	
	@Column(length = 150, nullable = false)
	private String nome;
	
	private LocalDate dataNascimento;

	public Aluno(){
		
	}
	
	public Aluno(String nome, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}

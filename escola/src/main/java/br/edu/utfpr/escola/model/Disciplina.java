package br.edu.utfpr.escola.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Disciplina {

	@Id
	@SequenceGenerator(name = "disciplina_seq", sequenceName = "disciplina_seq")
	@GeneratedValue(generator = "disciplina_seq", strategy = GenerationType.SEQUENCE)
	private Long codigo;

	@Column(length = 150, nullable = false)
	private String nome;

	@ManyToOne(fetch = FetchType.LAZY)
	private Curso curso;

	public Disciplina() {

	}

	public Disciplina(String nome, Curso curso) {
		this.nome = nome;
		this.curso = curso;
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}

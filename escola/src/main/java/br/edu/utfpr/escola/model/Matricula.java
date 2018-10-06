package br.edu.utfpr.escola.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Matricula {

	@Id
	@SequenceGenerator(name = "matricula_seq", sequenceName = "matricula_seq")
	@GeneratedValue(generator = "matricula_seq", strategy = GenerationType.SEQUENCE)
	private Long codigo;

	@ManyToOne(fetch=FetchType.LAZY)
	private Aluno aluno;

	@ManyToOne(fetch=FetchType.LAZY)
	private Disciplina disciplina;

	private Double nota;
	
	public Matricula(){
		
	}

	public Matricula(Aluno aluno, Disciplina disciplina) {
		super();
		this.aluno = aluno;
		this.disciplina = disciplina;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

}
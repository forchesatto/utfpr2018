package br.edu.utfpr.escola.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedSubgraph;
import javax.persistence.SequenceGenerator;

@Entity

@NamedEntityGraphs(
		value={
			@NamedEntityGraph(name="Matricula.completo", 
				attributeNodes=
				{
				  @NamedAttributeNode("aluno"),
				  @NamedAttributeNode("disciplina"),
				  @NamedAttributeNode(value="disciplina",
				  		subgraph="curso")
				}, 
				subgraphs={@NamedSubgraph(name="curso", 
							attributeNodes=
								@NamedAttributeNode("curso"))})})
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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(updatable=false)
	private Usuario usuario;
	
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}

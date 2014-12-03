package br.ufpb.projetoPOO;

import java.util.List;

public class Turma {
	private String numero;
	private Professor professor;
	private List <Exercicio> exercicios;
	private List <Aluno> alunos;
	private String disciplina;
	private List <Mensagem> mensagens;
	
	public Turma(String numero,String disciplina){
		this.disciplina=disciplina;
		this.numero=numero;
	}
	
	public void setProfessor(Professor professor){
		this.professor = professor;
	}
	
	public void setAluno(Aluno aluno){
		this.alunos.add(aluno);
	}
	
	public void setExercicio(Exercicio exercicio){
		this.exercicios.add(exercicio);
	}
	
	public void setMenssagem(Mensagem mensagem){
		this.mensagens.add(mensagem);
	}
	
	public List<Exercicio> getExercicios(){
		return this.exercicios;
	}

	public String getNumero(){
		return this.numero;
	}
	
	public String ToString(){
		return "Turma: "+this.numero+" Disciplina: "+this.disciplina;
	}
	
}

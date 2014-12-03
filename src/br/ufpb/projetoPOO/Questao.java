package br.ufpb.projetoPOO;

public class Questao {

	private String numero;
	private String tipo;
	private String descricao;
	private String respostaProfessor;
	private String respostaAluno;
	private double pontosQuestao;
	private double pontosAluno;
	
	public Questao(){
		this.numero= "sem numero";
		this.tipo=" sem tipo";
		this.descricao="sem descricao";
		this.respostaProfessor=" sem resposta Professor";
		this.respostaAluno=" sem resposta Aluno";
		this.pontosQuestao=0;
		this.pontosAluno=0;
	}
	
	public void setNumero(String numero){
		this.numero=numero;
	}
	
	public void setDescricao(String descricao){
		this.descricao=descricao;
	}
	
	public void setPontosQuestao(double pontos){
		this.pontosQuestao=pontos;
	}
	
	public void setPontosAluno(double pontosAluno){
		this.pontosAluno=pontosAluno;
	}
	
	public void setTipo(String tipo){
		this.tipo=tipo;
	}
	
	public String getQuestaoAluno(){
		return "Numero: " + this.numero + "\n Descrição: " + this.descricao;
	}
	public String getQuestaoProfessor(){
		return "Numero: " + this.numero + "\n Descrição: " + this.descricao + "\n\n Resposta do Professor " + this.respostaProfessor + "\n Vale: " + this.pontosQuestao + " pontos";
	}
}

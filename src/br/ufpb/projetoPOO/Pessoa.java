package br.ufpb.projetoPOO;

public  abstract class Pessoa {

	private String nome;
	private String matricula;
	
	public Pessoa(String nome,String matricula){
		this.nome=nome;
		this.matricula=matricula;
	}
	
	public void setNome(String nom){
		this.nome=nom;
	}
	
	public void setMatricula(String mat){
		this.matricula=mat;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getMatricula(){
		return this.matricula;
	}
	
	public abstract String informacoesDaPessoa();
}

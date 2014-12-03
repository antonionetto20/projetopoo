package br.ufpb.projetoPOO;

public class Professor extends Pessoa{

	public Professor(String nome,String matricula){
		super(nome,matricula);
	}

	public String informacoesDaPessoa() {
		// TODO Auto-generated method stub
		return "Nome: "+this.getNome()+" Matricula: "+this.getMatricula();
	}
}

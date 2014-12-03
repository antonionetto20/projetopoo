package br.ufpb.projetoPOO;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa{
	
	List<String> respostasEnviadas;
	
	public Aluno(String nome,String matricula){
		super(nome,matricula);
		this.respostasEnviadas = new ArrayList<String>();
	}
	
	public List<String> getRespostasEnviadas(){
		return this.respostasEnviadas;
	}

	@Override
	public String informacoesDaPessoa() {
		// TODO Auto-generated method stub
		return "Nome: "+this.getNome()+" Matricula: "+this.getMatricula();
	}

}

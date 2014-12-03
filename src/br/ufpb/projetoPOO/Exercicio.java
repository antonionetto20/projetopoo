package br.ufpb.projetoPOO;

import java.util.ArrayList;
import java.util.List;

public class Exercicio {

	private String numero;
	private double pontosExercicio;
	private List <Questao> questoes;
	
	public Exercicio(String numero){
		this.numero = numero;
		this.questoes = new ArrayList<Questao>();
	}
	public void setPontosExercicio(double pontos){
		this.pontosExercicio = pontos;
	}
	public double getPontosExercicio(){
		return this.pontosExercicio;
	}
	
	public String getNumero(){
		return this.numero;
	}
	public String toString(){
		return "Número do exercicio: " + this.numero + " Vale " + this.pontosExercicio + " Pontos.";
	}
	
}

package br.ufpb.projetoPOO;

public class Mensagem {
	
	private String numero;
	private String assunto;
	private String texto;
	
	public Mensagem(){
		this.numero = "sem numero";
		this.assunto="sem assunto";
		this.texto="sem texto";
	}
	public void setNumero(String numero){
		this.numero = numero;
	}
	
	public void setAssunto(String assuntoMsg){
		this.assunto=assuntoMsg;
	}
	
	public void setTexto(String textoMsg){
		this.texto=textoMsg;
	}
	
	public String ToString(){
		return "Numero: " + this.numero  + "\n Assunto: " + this.assunto + "\n Mensagem: " + this.texto;
	}
}

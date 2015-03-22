
public abstract class Questao {
	private String numero;
	private String descricao;
	private TipoQuestao tipo;
	private long qtdeAcertos;
	
	public Questao(){
		
	}
	
	public Questao(String num,String descr,TipoQuestao t){
		this.numero = num;
		this.descricao = descr;
		this.tipo = t;
		this.qtdeAcertos = 0;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoQuestao getTipo() {
		return tipo;
	}

	public void setTipo(TipoQuestao tipo) {
		this.tipo = tipo;
	}

	public long getQtdeAcertos() {
		return qtdeAcertos;
	}

	public void setQtdeAcertos(long qtde) {
		this.qtdeAcertos += qtde;
	}

	public String toString(){
		return "(Questão:"+this.numero+")\n"+this.descricao;
	}
	
	public abstract String exibeRespostaCorreta();
}

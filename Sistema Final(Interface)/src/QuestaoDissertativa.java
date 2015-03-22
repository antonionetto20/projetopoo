
public class QuestaoDissertativa extends Questao{
	private String resposta;
	
	public QuestaoDissertativa(String num, String descr, TipoQuestao t, String resp){
		super(num,descr,t);
		this.resposta = resp;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	public String exibeRespostaCorreta(){
		return this.resposta;
	}
}

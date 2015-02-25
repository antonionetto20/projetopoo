
public class Questao{
	private TipoQuestao tipo;
	private String numero;
	private String descricao;
	private String respostaCorreta;
	private String respostaAluno;
	
	public Questao(){
		
	}
	public Questao(String num,String descricao,String respCorreta,TipoQuestao tipo){
		this.tipo = tipo;
		this.numero = num;
		this.descricao = descricao;
		this.respostaCorreta = respCorreta;
		this.respostaAluno ="";
	}
	
	public void setTipo(TipoQuestao tipo){
		this.tipo = tipo;
	}
	
	public TipoQuestao getTipo(){
		return this.tipo;
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

	public String getRespostaCorreta() {
		return respostaCorreta;
	}

	public void setRespostaCorreta(String respostaCorreta) {
		this.respostaCorreta = respostaCorreta;
	}

	public String getRespostaAluno() {
		return respostaAluno;
	}

	public void setRespostaAluno(String respostaAluno) {
		this.respostaAluno = respostaAluno;
	}
}

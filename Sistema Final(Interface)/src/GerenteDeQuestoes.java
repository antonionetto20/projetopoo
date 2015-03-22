
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class GerenteDeQuestoes {
	private Map<String,QuestaoVouF> questoesVouF;
	private Map<String,QuestaoMultiplaEscolha> questoesMultiplaEscolha;
	private Map<String,QuestaoDissertativa> questoesDissertativa;
	
	
	public GerenteDeQuestoes(){
		this.questoesVouF = new HashMap<String,QuestaoVouF>();
		this.questoesMultiplaEscolha = new HashMap<String,QuestaoMultiplaEscolha>();
		this.questoesDissertativa = new HashMap<String,QuestaoDissertativa>();
	}
	
	public void cadastroQuestaoVouF(String num,String descr,TipoQuestao t,String r1,String r2, String r3, String r4, String r5) throws QuestaoJaExisteException{
		if(this.questoesVouF.get(num) == null && this.questoesDissertativa.get(num) == null && this.questoesMultiplaEscolha.get(num) == null){
			this.questoesVouF.put(num, new QuestaoVouF(num,descr,t,r1,r2,r3,r4,r5));
		}else{
			throw new QuestaoJaExisteException("Já existe uma questão cadastrada com esse número !!!");
		}
	}
	
	public void cadastroQuestaoMultiplaEscolha(String num,String descr,TipoQuestao t,String resp) throws QuestaoJaExisteException{
		if(this.questoesVouF.get(num) == null && this.questoesDissertativa.get(num) == null && this.questoesMultiplaEscolha.get(num) == null){
			this.questoesMultiplaEscolha.put(num, new QuestaoMultiplaEscolha(num,descr,t,resp));
		}else{
			throw new QuestaoJaExisteException("Já existe uma questão cadastrada com esse número !!!");
		}
	}
	
	public void cadastroQuestaoDissertativa(String num,String descr,TipoQuestao t,String resp) throws QuestaoJaExisteException{
		if(this.questoesVouF.get(num) == null && this.questoesDissertativa.get(num) == null && this.questoesMultiplaEscolha.get(num) == null){
			this.questoesDissertativa.put(num, new QuestaoDissertativa(num,descr,t,resp));
		}else{
			throw new QuestaoJaExisteException("Já existe uma questão cadastrada com esse número !!!");
		}
	}
	
	public Questao pesquisaQuestao(String num) throws QuestaoInexistenteException{
		if(this.questoesDissertativa.get(num) != null){
			return this.questoesDissertativa.get(num);
		}else if(this.questoesMultiplaEscolha.get(num) != null){
			return this.questoesMultiplaEscolha.get(num);
		}else if(this.questoesVouF.get(num) != null){
			return this.questoesVouF.get(num);
		}else{
			throw new QuestaoInexistenteException("Não existe questão cadastrada com esse número !!!");
		}
	}
	
	public String pesquisaDescricaoQuestao(String num) throws QuestaoInexistenteException{
		if(this.questoesDissertativa.get(num) != null){
			 return this.questoesDissertativa.get(num).toString();
		}else if(this.questoesMultiplaEscolha.get(num) != null){
			return this.questoesMultiplaEscolha.get(num).toString();
		}else if(this.questoesVouF.get(num) != null){
			return this.questoesVouF.get(num).toString();
		}else{
			throw new QuestaoInexistenteException("Não existe questão cadastrada com esse número !!!");
		}
	}
	
	public void removeQuestao(String num) throws QuestaoInexistenteException{
		if(this.questoesDissertativa.get(num) != null){
			 this.questoesDissertativa.remove(num);
		}else if(this.questoesMultiplaEscolha.get(num) != null){
			this.questoesMultiplaEscolha.remove(num);
		}else if(this.questoesVouF.get(num) != null){
			this.questoesVouF.remove(num);
		}else{
			throw new QuestaoInexistenteException("Não existe questão cadastrada com esse número !!!");
		}
	}
	
	public Map<String,QuestaoVouF> retornaQuestoesVouF(){
		return this.questoesVouF;
	}
	
	public Map<String,QuestaoMultiplaEscolha> retornaQuestoesMultiplaEscolha(){
		return this.questoesMultiplaEscolha;
	}
	
	public Map<String,QuestaoDissertativa> retornaQuestoesDissertativa(){
		return this.questoesDissertativa;
	}
	
	public Questao sorteiaQuestao(){
		Questao [] questoes = new Questao[this.questoesDissertativa.size() + this.questoesMultiplaEscolha.size() + this.questoesVouF.size()];
		int cont = 0;
		for(Questao q: this.questoesDissertativa.values()){
			questoes[cont] = q;
			cont++;
		}
		for(Questao q: this.questoesMultiplaEscolha.values()){
			questoes[cont] = q;
			cont++;
		}
		for(Questao q: this.questoesVouF.values()){
			questoes[cont] = q;
			cont++;
		}
		Random gerador = new Random();
		int x = gerador.nextInt(questoes.length);
		return questoes[x];
	}
	
	public void modificarDescricaoQuestao(String num, String descr)throws QuestaoInexistenteException{
		pesquisaQuestao(num).setDescricao(descr);
	}
	
	public void modificarRespostaQuestaoVouF(String num, String r1, String r2, String r3, String r4, String r5)throws QuestaoInexistenteException{
		if(this.questoesVouF.get(num) != null){
			this.questoesVouF.get(num).setResp1(r1);
			this.questoesVouF.get(num).setResp2(r2);
			this.questoesVouF.get(num).setResp3(r3);
			this.questoesVouF.get(num).setResp4(r4);
			this.questoesVouF.get(num).setResp5(r5);
		}else{
			throw new QuestaoInexistenteException("Não existe questão cadastrada com esse número !!!");
		}
	}
	
	public void modificarRespostaQuestaoMultiplaEscolha(String num, String resp)throws QuestaoInexistenteException{
		if(this.questoesMultiplaEscolha.get(num) != null){
			this.questoesMultiplaEscolha.get(num).setResposta(resp);
		}else{
			throw new QuestaoInexistenteException("Não existe questão cadastrada com esse número !!!");
		}
	}
	
	public void modificarRespostaQuestaoDissertativa(String num, String resp)throws QuestaoInexistenteException{
		if(this.questoesDissertativa.get(num) != null){
			this.questoesDissertativa.get(num).setResposta(resp);
		}else{
			throw new QuestaoInexistenteException("Não existe questão cadastrada com esse número !!!");
		}
	}
	
	public void aumentaAcertos(String num, TipoQuestao t){
		if(t == TipoQuestao.Dissertativa){
			this.questoesDissertativa.get(num).setQtdeAcertos(1);
		}else if(t == TipoQuestao.MultEscolha){
			this.questoesMultiplaEscolha.get(num).setQtdeAcertos(1);
		}else{
			this.questoesVouF.get(num).setQtdeAcertos(1);
		}
	}
	
	public String exibeRespostaCerta(String num) throws QuestaoInexistenteException{
			return pesquisaQuestao(num).exibeRespostaCorreta();
	}
	
	public String corrigeRespostaVouF(String numQ, String rA1, String rA2, String rA3, String rA4, String rA5) throws QuestaoInexistenteException{
		
		int acertos = 0;
		if(rA1.equals(retornaQuestoesVouF().get(numQ).getResp1())){
			acertos++;
		}
		if(rA2.equals(retornaQuestoesVouF().get(numQ).getResp2())){
			acertos++;
		}
		if(rA3.equals(retornaQuestoesVouF().get(numQ).getResp3())){
			acertos++;
		}
		if(rA4.equals(retornaQuestoesVouF().get(numQ).getResp4())){
			acertos++;
		}
		if(rA5.equals(retornaQuestoesVouF().get(numQ).getResp5())){
			acertos++;
		}
		if(acertos == 5){
			pesquisaQuestao(numQ).setQtdeAcertos(1);
			return "Acertou tudo";
		}else{
			return "Nao acertou tudo";
		}
		
	}
	
	public String corrigeRespostaMultiplaEscolha(String numQ, String resp) throws QuestaoInexistenteException{
		String resposta=null;
		if(resp.equals(exibeRespostaCerta(numQ))){
			pesquisaQuestao(numQ).setQtdeAcertos(1);
			resposta="Acertou";
		}else{
			resposta="Errou";
		}
		return resposta;
	}
	
	public String enviaRespostaDissertativa(String numQ, String resp, String matA){
		return "Matricula do aluno: /n/n" + matA + 
				"Descricão da pergunta: /n/n" + retornaQuestoesDissertativa().get(numQ).getDescricao() + "/n/n" +
				"Resposta correta: /n/n" + retornaQuestoesDissertativa().get(numQ).getResposta() + "/n/n" +
				"Resposta do aluno: /n/n" + resp;
	}
	
}

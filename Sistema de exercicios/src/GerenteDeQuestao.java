import java.util.HashMap;
import java.util.Map;


public class GerenteDeQuestao {
	private Map<String,Questao> questoesVouF;
	private Map<String,Questao> questoesDissertativas;
	private Map<String,Questao> questoesMultiplaEscolha;
	
	public GerenteDeQuestao(){
		this.questoesVouF = new HashMap<String,Questao>();
		this.questoesDissertativas = new HashMap<String,Questao>();
		this.questoesMultiplaEscolha = new HashMap<String,Questao>();
	}
	
	public void cadastrarQuestao(String num,String descricao,String respCorreta,TipoQuestao tipo) throws QuestaoJaExisteException{
		if(tipo == TipoQuestao.V_OU_F && this.questoesVouF.get(num) == null){
			this.questoesVouF.put(num,new Questao(num,descricao,respCorreta,tipo));
		}else if(tipo == TipoQuestao.DISSERTATIVA && this.questoesDissertativas.get(num) == null){
			this.questoesDissertativas.put(num,new Questao(num,descricao,respCorreta,tipo));
		}else if(tipo == TipoQuestao.MULTIPLA_ESCOLHA && this.questoesMultiplaEscolha.get(num) == null){
			this.questoesMultiplaEscolha.put(num,new Questao(num,descricao,respCorreta,tipo));
		}else{
			throw new QuestaoJaExisteException("Já existe questão cadastrada com esse número");
		}
	}
	
	public Questao pesquisaQuestaoEmTipo(String num,TipoQuestao tipo)throws QuestaoInexistenteException {
		if(this.questoesDissertativas.get(num) == null && this.questoesMultiplaEscolha.get(num) == null && this.questoesVouF.get(num) == null){
			throw new QuestaoInexistenteException("Questão não está cadastrada");
		}else{
			if(tipo == TipoQuestao.V_OU_F){
				return this.questoesVouF.get(num);
			}else if(tipo == TipoQuestao.DISSERTATIVA){
				return this.questoesDissertativas.get(num);
			}else{
				return this.questoesMultiplaEscolha.get(num);
			}
		}
	}
	
	public void removerQuestao(String num,TipoQuestao tipo)throws QuestaoInexistenteException {
		Questao q = pesquisaQuestaoEmTipo(num,tipo);
		if(tipo == TipoQuestao.V_OU_F){
			this.questoesVouF.remove(num,q);
		}else if(tipo == TipoQuestao.DISSERTATIVA){
			this.questoesDissertativas.remove(num,q);
		}else{
			this.questoesMultiplaEscolha.remove(num,q);
		}
	}
	
	public Map<String,Questao> getQuestoesDoTipo(TipoQuestao tipo){
		if(tipo == TipoQuestao.V_OU_F){
			return this.questoesVouF;
		}else if(tipo == TipoQuestao.DISSERTATIVA){
			return this.questoesDissertativas;
		}else{
			return this.questoesMultiplaEscolha;
		}
	}
	
	public void editarDescricaoDeQuestao(String num, String descricao,TipoQuestao tipo)throws QuestaoInexistenteException {
		Questao q = pesquisaQuestaoEmTipo(num,tipo);
		q.setDescricao(descricao);
	}
	
	public void editarRespostaDeQuestao(String num, String resposta,TipoQuestao tipo)throws QuestaoInexistenteException {
		Questao q = pesquisaQuestaoEmTipo(num,tipo);
		q.setRespostaCorreta(resposta);
	}
}

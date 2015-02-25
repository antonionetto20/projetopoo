import java.util.HashMap;
import java.util.Map;


public class Exercicio {
	private String numero;
	private Map<String,Questao> questoes;
	
	public Exercicio(String num){
		this.numero = num;
		this.questoes = new HashMap<String,Questao>();
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Map<String, Questao> getQuestoes() {
		return questoes;
	}
	
	public void setQuestaoEmExercicio(String num, TipoQuestao tipo) throws QuestaoInexistenteException{
		GerenteDeQuestao gQ = new GerenteDeQuestao();
		this.questoes.put(num,gQ.pesquisaQuestaoEmTipo(num, tipo));
	}
}

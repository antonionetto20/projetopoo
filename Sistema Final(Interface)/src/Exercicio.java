import java.util.HashMap;
import java.util.Map;


public class Exercicio {
	private String numero;
	private Map<String,Questao> questoesExercicio;
	private long qtdeAlunosQueFecharam;
	
	public Exercicio(){
		
	}
	
	public Exercicio(String num){
		this.numero = num;
		this.questoesExercicio = new HashMap<String,Questao>();
		this.qtdeAlunosQueFecharam = 0;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Map<String, Questao> getQuestoesExercicio() {
		return questoesExercicio;
	}

	public void setQuestoesExercicio(Questao q) {
		this.questoesExercicio.put(q.getNumero(), q);
	}

	public long getQtdeAlunosQueFecharam() {
		return qtdeAlunosQueFecharam;
	}

	public void setQtdeAlunosQueFecharam(long qtde) {
		this.qtdeAlunosQueFecharam += qtde;
	}
	
	public String retornaAcertosQuestoes(){
		String msg = "";
		for(Questao q: this.questoesExercicio.values()){
			msg += q.getQtdeAcertos() + " Acertaram a questão: " + q.getNumero() + "\n";
		}
		return msg;
	}
	
	public String mostraMsgAoProfessor(){
		return this.qtdeAlunosQueFecharam + " alunos fecharam o exercicio de número: " + this.numero +
				"\n " + retornaAcertosQuestoes();
	}
	
}

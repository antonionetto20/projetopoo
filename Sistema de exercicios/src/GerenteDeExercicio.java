import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class GerenteDeExercicio {
	private Map<String,Exercicio> exercicios;
	
	public GerenteDeExercicio(){
		this.exercicios = new HashMap<String,Exercicio>();
	}
	
	public void cadastrarExercicio(String num) throws ExercicioJaExisteException{
		if(this.exercicios.get(num) == null){
			this.exercicios.put(num, new Exercicio(num));
		}else{
			throw new ExercicioJaExisteException("Já existe um exercicio cadastrado com esse número no Sistema");
		}
	}
	
	public Exercicio pesquisaExercicio(String num)throws ExercicioInexistenteException{
		Exercicio e = this.exercicios.get(num);
		if(e == null){
			throw new ExercicioInexistenteException("Exercicio não existe");
		}else{
			return e;
		}
	}
	
	public Questao pesquisaQuestaoExercicio(String numE,String numQ) throws ExercicioInexistenteException,QuestaoInexistenteException{
		Exercicio e = pesquisaExercicio(numE);
		if(e.getQuestoes().get(numQ) == null){
			throw new QuestaoInexistenteException("Questao não existe");
		}else{
			return e.getQuestoes().get(numQ);
		}
	}
	
	public void inserirQuestaoEmExercicio(String numExer,String numQ,TipoQuestao tipo)throws ExercicioInexistenteException, QuestaoInexistenteException{
		Exercicio e = pesquisaExercicio(numExer);
		e.setQuestaoEmExercicio(numQ,tipo);
	}
	
	public void excluirExercicio(String num)throws ExercicioInexistenteException{
		Exercicio e = pesquisaExercicio(num);
		this.exercicios.remove(num,e);
	}
	
	public void excluirQuestaoDeExercicio(String numE,String numQ) throws ExercicioInexistenteException, QuestaoInexistenteException{
		Exercicio e = pesquisaExercicio(numE);
		Questao q = pesquisaQuestaoExercicio(numE,numQ);
		e.getQuestoes().remove(numQ,q);
	}
	
	public Map<String,Questao> getQuestoesExercicio(String numE) throws ExercicioInexistenteException{
		Exercicio e = pesquisaExercicio(numE);
		return e.getQuestoes();
	}
	
	public Map<String,Exercicio> getExercicios(){
		return this.exercicios;
	}
	
	public Exercicio sortearExercicio(){
		Exercicio [] exercicios1 = new Exercicio[this.exercicios.size()];
		int cont = 0;
		for(Exercicio e: this.exercicios.values()){
			exercicios1[cont] = e;
			cont++;
		}
		Random gerador = new Random();
		int x = gerador.nextInt(this.exercicios.size());
		return exercicios1[x];
	}
}

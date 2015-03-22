import java.util.HashMap;
import java.util.Map;


public class GerenteDeExercicios {
	private Map<String,Exercicio> exercicios;
	
	public GerenteDeExercicios(){
		this.exercicios = new HashMap<String,Exercicio>();
	}
	
	public void CadastraExercicio(String num) throws ExercicioJaExisteException{
		if(this.exercicios.get(num) == null){
			this.exercicios.put(num, new Exercicio(num));
		}else{
			throw new ExercicioJaExisteException("Já existe um exercicio cadastrado com esse número !!!");
		}
	}
	
	public Exercicio pesquisaExercicio(String num) throws ExercicioInexistenteException{
		if(this.exercicios.get(num) != null){
			return this.exercicios.get(num);
		}else{
			throw new ExercicioInexistenteException("Não existe exercicio cadastrado com esse número!!!");
		}
	}
	
	public void adicionaQuestaoEmExercicio(String num,Questao q) throws ExercicioInexistenteException{
		pesquisaExercicio(num).setQuestoesExercicio(q);
	}
	
	public void removeExercicio(String num) throws ExercicioInexistenteException{
		if(this.exercicios.get(num) != null){
			this.exercicios.remove(num);
		}else{
			throw new ExercicioInexistenteException("Não existe exercicio cadastrado com esse número!!!");
		}
	}
	
	public Map<String,Questao> retornaQuestoesDeExercicio(String num) throws ExercicioInexistenteException{
		if(this.exercicios.get(num) != null){
			return this.exercicios.get(num).getQuestoesExercicio();
		}else{
			throw new ExercicioInexistenteException("Não existe exercicio cadastrado com esse número!!!");
		}
	}
	
	public Map<String,Exercicio> pesquisaExercicios(){
		return this.exercicios;
	}
	
	public void incrementaQtdeFechamentosExercicio(String num){
		this.exercicios.get(num).setQtdeAlunosQueFecharam(1);
	}
}

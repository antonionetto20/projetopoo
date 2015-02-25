
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GerenteDeRespostas {
	
	private static String matriculaProfessor = "12345";
	private Map<String,RespostaExercicio> exerRespondidos;
	
	public GerenteDeRespostas(){
		this.exerRespondidos = new HashMap<String,RespostaExercicio>();
	}
	
	public void cadastrarRespostasExercicio(String numR,String matA,String numE) throws RespostaJaExisteException{
		if(this.exerRespondidos.get(numR) == null){
			this.exerRespondidos.put(matA, new RespostaExercicio(numR,matA,numE));
		}else{
			throw new RespostaJaExisteException("Já existe uma resposta cadastrada com esse número");
		}
	}
	
	public void cadastraRespostaDeQuestaoEmResposta(String numR, String resp) throws RespostaInexistenteException{
		boolean achou = false;
		for(RespostaExercicio rE: this.exerRespondidos.values()){
			if(rE.getNumExercicio().equals(numR)){
				rE.setRespostas(resp);
				achou = true;
			}
		}if(achou == false){
			throw new RespostaInexistenteException("Não existe resposta cadastrada com esse número");
		}
	}
	
	public Map<String,RespostaExercicio> pesquisaRespExer(String numE)throws RespostaInexistenteException{
		Map<String,RespostaExercicio> lR = new HashMap<String,RespostaExercicio>();
		for(RespostaExercicio rE: this.exerRespondidos.values()){
			if(rE.getNumExercicio().equals(numE)){
				lR.put(numE,rE);
			}
		}
		if(lR.size() == 0){
			throw new RespostaInexistenteException("Resposta não existe");
		}else{
			return lR;
		}
	}
	
	public void excluirResposta(String num) throws RespostaInexistenteException{
		RespostaExercicio rE = this.exerRespondidos.get(num);
		if(rE == null){
			throw new RespostaInexistenteException("Não existe resposta com esse número");
		}else{
			this.exerRespondidos.remove(rE);
		}
	}
	
	public Map<String,RespostaExercicio> getRespExer(){
		return this.exerRespondidos;
	}
	
	public List<String> getRespostasExercicioRespondido(String numExeResp){
		return this.exerRespondidos.get(numExeResp).getRespostas();
	}
	
	public String getMatProf(){
		return this.matriculaProfessor;
	}
}

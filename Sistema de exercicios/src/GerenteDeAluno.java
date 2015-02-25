import java.util.HashMap;
import java.util.Map;


public class GerenteDeAluno {
	private Map<String,Aluno> alunos;
	
	public GerenteDeAluno(){
		this.alunos = new HashMap<String,Aluno>();
	}
	
	public void cadastrarAluno(String nome,String matricula)throws AlunoJaExisteException{
		if(this.alunos.get(matricula) == null){
			this.alunos.put(matricula,new Aluno(nome, matricula));
		}else{
			throw new AlunoJaExisteException("Matricula já cadastrada no Sistema");
		}
	}
	
	public Aluno pesquisaAluno(String matricula)throws AlunoInexistenteException {
		if(this.alunos.get(matricula) == null){
			throw new AlunoInexistenteException("Aluno não está cadastrado");
		}else{
			return this.alunos.get(matricula);
		}
	}
	
	public void removerAluno(String matricula)throws AlunoInexistenteException {
		Aluno a = pesquisaAluno(matricula);
		this.alunos.remove(matricula,a);
	}
	
	public Map<String,Aluno> getAlunos(){
		return this.alunos;
	}
}

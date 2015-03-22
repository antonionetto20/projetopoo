import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GerenteDePessoa {
	private Professor p;
	private Map<String,Aluno> alunos;
	
	public GerenteDePessoa(){
		this.p = new Professor();
		this.alunos = new HashMap<String,Aluno>();
	}
	
	public void cadastraAluno(String mat) throws AlunoJaExisteException{
		if(this.alunos.get(mat) == null){
			this.alunos.put(mat, new Aluno(mat));
		}else{
			throw new AlunoJaExisteException("Já existe um aluno cadastrado com essa matricula !!!");
		}
	}
	
	public void removeAluno(String mat)throws AlunoInexistenteException{
		if(this.alunos.get(mat) != null){
			this.alunos.remove(mat);
		}else{
			throw new AlunoInexistenteException("Não existe aluno cadastrado com essa matricula !!!");
		}
	}
	
	public Aluno pesquisaAluno(String mat) throws AlunoInexistenteException{
		if(this.alunos.get(mat) != null){
			return this.alunos.get(mat);
		}else{
			throw new AlunoInexistenteException("Não existe aluno cadastrado com essa matricula!!!");
		}
	}
	
	public Map<String,Aluno> retornaAlunos(){
		return this.alunos;
	}
	
	public void enviarMsgAoProfessor(String msg){
		this.p.getMensagens().add(msg);
	}
	
	public void enviarMsgAoAluno(String matA, String msg) throws AlunoInexistenteException{
		if(this.alunos.get(matA) != null){
			this.alunos.get(matA).getMensagens().add(msg);
		}else{
			throw new AlunoInexistenteException("Não existe aluno cadastrado com essa matricula !!!");
		}
	}
	
	public List<String> retornaMsgsProf(){
		return this.p.getMensagens();
	}
}

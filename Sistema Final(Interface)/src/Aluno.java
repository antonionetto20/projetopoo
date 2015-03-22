import java.util.ArrayList;
import java.util.List;


public class Aluno {
	private String matricula;
	private List<String> mensagens;
	
	public Aluno(){
		
	}
	public Aluno(String mat){
		this.matricula = mat;
		this.mensagens = new ArrayList<String>();
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<String> getMensagens() {
		return mensagens;
	}
}

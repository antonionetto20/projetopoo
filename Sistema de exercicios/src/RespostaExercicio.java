import java.util.ArrayList;
import java.util.List;


public class RespostaExercicio {

	private String numR;
	private String matAluno;
	private String numExercicio;
	private List<String> respostas;
	
	public RespostaExercicio(){
		this.numR = "sem numero";
		this.matAluno = "Sem matricula";
		this.numExercicio = "Sem numero";
		this.respostas = new ArrayList<String>();
	}
	
	public RespostaExercicio(String numR,String matAluno,String numExercicio){
		this.respostas = new ArrayList<String>();
		this.numExercicio = numExercicio;
		this.matAluno = matAluno;
		this.numR = numR;
	}

	public String getNumR() {
		return numR;
	}

	public void setNumR(String numR) {
		this.numR = numR;
	}

	public String getMatAluno() {
		return matAluno;
	}

	public void setMatAluno(String matAluno) {
		this.matAluno = matAluno;
	}

	public String getNumExercicio() {
		return numExercicio;
	}

	public void setNumExercicio(String numExercicio) {
		this.numExercicio = numExercicio;
	}

	public List<String> getRespostas() {
		return respostas;
	}

	public void setRespostas(String resp) {
		this.respostas.add(resp);
	}	
}

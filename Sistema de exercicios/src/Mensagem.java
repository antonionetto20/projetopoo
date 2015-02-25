import java.util.ArrayList;
import java.util.List;


public class Mensagem {
	private String numMensagem;
	private List<String> matDestinatario;
	private String mensagem;
	
	public Mensagem(String numM,String msg){
		this.matDestinatario = new ArrayList<String>();
		this.mensagem = msg;
		this.numMensagem = numM;
	}

	public String getNumMensagem() {
		return numMensagem;
	}

	public void setNumMensagem(String numMensagem) {
		this.numMensagem = numMensagem;
	}
	
	public List<String> getMatDestinatario() {
		return matDestinatario;
	}

	public void setMatDestinatario(String matDest) {
		this.matDestinatario.add(matDest);
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}

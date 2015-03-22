import java.util.ArrayList;
import java.util.List;


public class Professor {
	private static String matricula = "1234";
	private List<String> mensagens;
	
	public Professor(){
		this.mensagens = new ArrayList<String>();
	}
	
	public String getMatricula(){
		return this.matricula;
	}
	
	public List<String> getMensagens(){
		return this.mensagens;
	}
}

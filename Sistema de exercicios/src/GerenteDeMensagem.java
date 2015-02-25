import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GerenteDeMensagem {
	private Map<String,Mensagem> mensagens;
	
	public GerenteDeMensagem(){
		this.mensagens = new HashMap<String,Mensagem>();
	}
	
	public void cadastrarMensagemPara(String numMensagem,String matAluno,String msg) throws MensagemJaExisteException{
		if(this.mensagens.get(numMensagem) == null){
			Mensagem m = new Mensagem(numMensagem,msg);
			m.setMatDestinatario(matAluno);
		}else{
			throw new MensagemJaExisteException("Já existe uma mensagem com esse número cadastrada");
		}
	}
	
	public List<Mensagem> pesquisarMensagensDe(String matAluno)throws MensagemInexistenteException{
		List<Mensagem> msgs = new ArrayList<Mensagem>();
		for(Mensagem m: this.mensagens.values()){
			for(String mt: m.getMatDestinatario()){
				if(mt.equals(matAluno)){
					msgs.add(m);
				}
			}
		}if(msgs.size() == 0){
			throw new MensagemInexistenteException("Não existe mensagens para esse aluno.");
		}else{ 
			return msgs;
		}
	}
	
	public void removerMensagemDe(String matAluno)throws MensagemInexistenteException{
		List<Mensagem> msgs = pesquisarMensagensDe(matAluno);
		for(Mensagem m: msgs){
			this.mensagens.remove(matAluno,m);
		}
	}
}

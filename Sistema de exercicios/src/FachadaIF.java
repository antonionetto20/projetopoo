import java.util.List;
import java.util.Map;


public interface FachadaIF {
	
	public void cadastroDeAluno(String nome, String matricula);
	public Aluno pesquisaAluno(String matricula) throws AlunoInexistenteException;
	public void excluirAluno(String matricula) throws AlunoInexistenteException;
	public Map<String,Aluno> exibeAlunos();
	public void cadastraQuestao(String num,String descricao,String respCorreta);
	public Questao pesquisaQuestao(String num) throws QuestaoInexistenteException;
	public void excluirQuestao(String num) throws QuestaoInexistenteException;
	public void editarDescricaoDeQuestao(String num,String descricao) throws QuestaoInexistenteException;
	public void editarRespostaDeQuestao(String num,String resposta) throws QuestaoInexistenteException;
	public Map<String,Questao> exibeQuestoes();
	public void cadastrarExercicio(String num);
	public void inserirQuestaoEmExercicio(String numE,String numQ,Questao q) throws ExercicioInexistenteException;
	public Questao pesquisaQuestaoEmExercicio(String numE,String numQ) throws ExercicioInexistenteException, QuestaoInexistenteException;
	public void excluirQuestaoDeExercicio(String numE,String numQ) throws ExercicioInexistenteException, QuestaoInexistenteException;
	public Map<String,Questao> exibeQuestoesDeExercicio(String numE) throws ExercicioInexistenteException;
	public Exercicio pesquisaExercicio(String num) throws ExercicioInexistenteException;
	public void excluirExercicio(String num) throws ExercicioInexistenteException;
	public Map<String,Exercicio> exibeExercicios();
	public void cadastrarMensagem(String matDestinatario,String msg);
	public List<Mensagem> pesquisaMensagem(String matAluno) throws MensagemInexistenteException;
	public void excluirMensagem(String matAluno) throws MensagemInexistenteException;
	public void cadastrarRespostasExercicio(String numR,String matA,String numE) throws RespostaJaExisteException;
	public void cadastraRespostaDeQuestaoEmResposta(String numR, String resp) throws RespostaInexistenteException;
	public Map<String,RespostaExercicio> pesquisaRespExer(String numE)throws RespostaInexistenteException;
	public void excluirResposta(String num) throws RespostaInexistenteException;
	public Map<String,RespostaExercicio> getRespexer();
	public List<String> exibeRespostasDeExerRespondido(String numExeResp);
	
}

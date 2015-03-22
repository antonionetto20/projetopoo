import java.util.List;
import java.util.Map;


public interface FachadaIF {
	
	public void cadastraAlunoNoSistema(String matricula) throws AlunoJaExisteException;
	
	public void removerAlunoSistema(String matricula)throws AlunoInexistenteException;
	
	public Aluno pesquisaAluno(String mat) throws AlunoInexistenteException;
	
	public Map<String,Aluno> retornaAlunos();
	
	public void enviarMensagemParaProfessor(String mensagem);
	
	public List<String> retornaMsgsProf();
	
	public void enviarMensagemParaAluno(String matriculaAluno, String mensagem) throws AlunoInexistenteException;
	
	public void cadastrarQuestaoVouF(String num,String descr,TipoQuestao t,String r1,String r2, String r3, String r4, String r5) throws QuestaoJaExisteException;
	
	public void cadastrarQuestaoMultiplaEscolha(String num,String descr,TipoQuestao t,String resp) throws QuestaoJaExisteException;
	
	public void cadastroQuestaoDissertativa(String num,String descr,TipoQuestao t,String resp) throws QuestaoJaExisteException;
	
	public Questao pesquisaQuestao(String num) throws QuestaoInexistenteException;
	
	public String pesquisaDescricaoQuestao(String num) throws QuestaoInexistenteException;
	
	public void removerQuestao(String num) throws QuestaoInexistenteException;
	
	public Map<String,QuestaoVouF> retornaQuestoesVouF();
	
	public Map<String,QuestaoMultiplaEscolha> retornaQuestoesMultiplaEscolha();
	
	public Map<String,QuestaoDissertativa> retornaQuestoesDissertativa();
	
	public Questao sortearQuestao();
	
	public void modificarDescricaoQuestao(String num, String descr)throws QuestaoInexistenteException;
	
	public void modificarRespostaQuestaoVouF(String num, String r1, String r2, String r3, String r4, String r5)throws QuestaoInexistenteException;
	
	public void modificarRespostaQuestaoMultiplaEscolha(String num, String resp)throws QuestaoInexistenteException;
	
	public void modificarRespostaQuestaoDissertativa(String num, String resp)throws QuestaoInexistenteException;
	
	public void aumentaAcertosEmQuestao(String num, TipoQuestao t);
	
	public String exibeRespostaCerta(String num) throws QuestaoInexistenteException;
	
	public String corrigeRespostaVouF(String numQ, String rA1, String rA2, String rA3, String rA4, String rA5) throws QuestaoInexistenteException;
	
	public String corrigeRespostaMultiplaEscolha(String numQ, String resp) throws QuestaoInexistenteException;
	
	public String enviaRespostaDissertativa(String numQ, String resp, String matA);
	
	public void CadastraExercicio(String num) throws ExercicioJaExisteException;
	
	public Exercicio pesquisaExercicio(String num) throws ExercicioInexistenteException;
	
	public void adicionaQuestaoEmExercicio(String num,Questao q) throws ExercicioInexistenteException;
	
	public void removeExercicio(String num) throws ExercicioInexistenteException;
	
	public Map<String,Questao> retornaQuestoesDeExercicio(String num) throws ExercicioInexistenteException;
	
	public Map<String,Exercicio> pesquisaExercicios();
	
	public void incrementaQtdeFechamentosExercicio(String num);
	
}

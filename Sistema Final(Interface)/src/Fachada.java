import java.util.List;
import java.util.Map;


public class Fachada implements FachadaIF{
	private GerenteDePessoa gP;
	private GerenteDeQuestoes gQ;
	private GerenteDeExercicios gE;
	
	public Fachada(){
		this.gP = new GerenteDePessoa();
		this.gQ = new GerenteDeQuestoes();
		this.gE = new GerenteDeExercicios();
	}
	
	public void cadastraAlunoNoSistema(String matricula) throws AlunoJaExisteException{
		this.gP.cadastraAluno(matricula);
	}
	
	public void removerAlunoSistema(String matricula)throws AlunoInexistenteException{
		this.gP.removeAluno(matricula);
	}
	
	public Aluno pesquisaAluno(String mat) throws AlunoInexistenteException{
		return this.gP.pesquisaAluno(mat);
	}
	
	public Map<String,Aluno> retornaAlunos(){
		return this.gP.retornaAlunos();
	}
	
	public void enviarMensagemParaProfessor(String mensagem){
		this.gP.enviarMsgAoProfessor(mensagem);
	}
	
	public List<String> retornaMsgsProf(){
		return this.gP.retornaMsgsProf();
	}
	
	public void enviarMensagemParaAluno(String matriculaAluno, String mensagem) throws AlunoInexistenteException{
		this.gP.enviarMsgAoAluno(matriculaAluno, mensagem);
	}
	
	
	public void cadastrarQuestaoVouF(String num,String descr,TipoQuestao t,String r1,String r2, String r3, String r4, String r5) throws QuestaoJaExisteException{
		this.gQ.cadastroQuestaoVouF(num, descr, t, r1, r2, r3, r4, r5);
	}
	
	public void cadastrarQuestaoMultiplaEscolha(String num,String descr,TipoQuestao t,String resp) throws QuestaoJaExisteException{
		this.gQ.cadastroQuestaoMultiplaEscolha(num, descr, t, resp);
	}
	
	public void cadastroQuestaoDissertativa(String num,String descr,TipoQuestao t,String resp) throws QuestaoJaExisteException{
		this.gQ.cadastroQuestaoDissertativa(num, descr, t, resp);
	}
	
	public Questao pesquisaQuestao(String num) throws QuestaoInexistenteException{
		return this.gQ.pesquisaQuestao(num);
	}
	
	public String pesquisaDescricaoQuestao(String num) throws QuestaoInexistenteException{
		return this.gQ.pesquisaDescricaoQuestao(num);
	}
	
	public void removerQuestao(String num) throws QuestaoInexistenteException{
		this.gQ.removeQuestao(num);
	}
	
	public Map<String,QuestaoVouF> retornaQuestoesVouF(){
		return this.gQ.retornaQuestoesVouF();
	}
	
	public Map<String,QuestaoMultiplaEscolha> retornaQuestoesMultiplaEscolha(){
		return this.gQ.retornaQuestoesMultiplaEscolha();
	}
	
	public Map<String,QuestaoDissertativa> retornaQuestoesDissertativa(){
		return this.gQ.retornaQuestoesDissertativa();
	}
	
	public Questao sortearQuestao(){
		return this.gQ.sorteiaQuestao();
	}
	
	public void modificarDescricaoQuestao(String num, String descr)throws QuestaoInexistenteException{
		this.gQ.modificarDescricaoQuestao(num, descr);
	}
	
	public void modificarRespostaQuestaoVouF(String num, String r1, String r2, String r3, String r4, String r5)throws QuestaoInexistenteException{
		this.gQ.modificarRespostaQuestaoVouF(num, r1, r2, r3, r4, r5);
	}
	
	public void modificarRespostaQuestaoMultiplaEscolha(String num, String resp)throws QuestaoInexistenteException{
		this.gQ.modificarRespostaQuestaoMultiplaEscolha(num, resp);
	}
	
	public void modificarRespostaQuestaoDissertativa(String num, String resp)throws QuestaoInexistenteException{
		this.gQ.modificarRespostaQuestaoDissertativa(num, resp);
	}
	
	public void aumentaAcertosEmQuestao(String num, TipoQuestao t){
		this.gQ.aumentaAcertos(num, t);
	}
	
	public String exibeRespostaCerta(String num) throws QuestaoInexistenteException{
		return this.gQ.exibeRespostaCerta(num);
	}
	
	public String corrigeRespostaVouF(String numQ, String rA1, String rA2, String rA3, String rA4, String rA5) throws QuestaoInexistenteException{
		return this.gQ.corrigeRespostaVouF(numQ, rA1, rA2, rA3, rA4, rA5);
	}
	
	public String corrigeRespostaMultiplaEscolha(String numQ, String resp) throws QuestaoInexistenteException{
		return this.gQ.corrigeRespostaMultiplaEscolha(numQ, resp);
	}
	
	public String enviaRespostaDissertativa(String numQ, String resp, String matA){
		return this.gQ.enviaRespostaDissertativa(numQ, resp, matA);
	}
	
	public void CadastraExercicio(String num) throws ExercicioJaExisteException{
		this.gE.CadastraExercicio(num);
	}
	
	public Exercicio pesquisaExercicio(String num) throws ExercicioInexistenteException{
		return this.gE.pesquisaExercicio(num);
	}
	
	public void adicionaQuestaoEmExercicio(String num,Questao q) throws ExercicioInexistenteException{
		this.gE.adicionaQuestaoEmExercicio(num, q);
	}
	
	public void removeExercicio(String num) throws ExercicioInexistenteException{
		this.gE.removeExercicio(num);
	}
	
	public Map<String,Questao> retornaQuestoesDeExercicio(String num) throws ExercicioInexistenteException{
		return this.gE.retornaQuestoesDeExercicio(num);
	}
	
	public Map<String,Exercicio> pesquisaExercicios(){
		return this.gE.pesquisaExercicios();
	}
	
	public void incrementaQtdeFechamentosExercicio(String num){
		this.gE.incrementaQtdeFechamentosExercicio(num);
	}
	
}

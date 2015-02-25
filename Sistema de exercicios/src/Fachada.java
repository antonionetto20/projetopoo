import java.util.List;
import java.util.Map;


public class Fachada {
	
	private GerenteDeAluno gA = new GerenteDeAluno();
	private GerenteDeQuestao gQ = new GerenteDeQuestao();
	private GerenteDeExercicio gE = new GerenteDeExercicio();
	private GerenteDeMensagem gM = new GerenteDeMensagem();
	private GerenteDeRespostas gR = new GerenteDeRespostas();
	
	public void cadastroDeAluno(String nome, String matricula) throws AlunoJaExisteException{
		this.gA.cadastrarAluno(nome, matricula);
	}
	
	public Aluno pesquisaAluno(String matricula) throws AlunoInexistenteException{
		return this.gA.pesquisaAluno(matricula);
	}
	
	public void excluirAluno(String matricula) throws AlunoInexistenteException{
		this.gA.removerAluno(matricula);
	}
	
	public Map<String,Aluno> exibeAlunos(){
		return this.gA.getAlunos();
	}
	
	public void cadastraQuestao(String num,String descricao,String respCorreta,TipoQuestao tipo) throws QuestaoJaExisteException{
		this.gQ.cadastrarQuestao(num, descricao, respCorreta,tipo);
	}
	
	public Questao pesquisaQuestao(String num,TipoQuestao tipo) throws QuestaoInexistenteException{
		return this.gQ.pesquisaQuestaoEmTipo(num,tipo);
	}
	
	public void excluirQuestao(String num,TipoQuestao tipo) throws QuestaoInexistenteException{
		this.gQ.removerQuestao(num,tipo);
	}
	
	public void editarDescricaoDeQuestao(String num,String descricao,TipoQuestao tipo) throws QuestaoInexistenteException{
		this.gQ.editarDescricaoDeQuestao(num, descricao,tipo);
	}
	
	public void editarRespostaDeQuestao(String num,String resposta,TipoQuestao tipo) throws QuestaoInexistenteException{
		this.gQ.editarRespostaDeQuestao(num, resposta,tipo);
	}
	
	public Map<String,Questao> exibeQuestoes(TipoQuestao tipo){
		return this.gQ.getQuestoesDoTipo(tipo);
	}
	
	public void cadastrarExercicio(String num) throws ExercicioJaExisteException{
		this.gE.cadastrarExercicio(num);
	}
	
	public void inserirQuestaoEmExercicio(String numE,String numQ,TipoQuestao tipo) throws ExercicioInexistenteException, QuestaoInexistenteException{
		this.gE.inserirQuestaoEmExercicio(numE, numQ, tipo);
	}
	
	public Questao pesquisaQuestaoEmExercicio(String numE,String numQ) throws ExercicioInexistenteException, QuestaoInexistenteException{
		return this.gE.pesquisaQuestaoExercicio(numE, numQ);
	}
	
	public void excluirQuestaoDeExercicio(String numE,String numQ) throws ExercicioInexistenteException, QuestaoInexistenteException{
		this.gE.excluirQuestaoDeExercicio(numE, numQ);
	}
	
	public Map<String,Questao> exibeQuestoesDeExercicio(String numE) throws ExercicioInexistenteException{
		return this.gE.getQuestoesExercicio(numE);
	}
	
	public Exercicio pesquisaExercicio(String num) throws ExercicioInexistenteException{
		return this.gE.pesquisaExercicio(num);
	}
	
	public void excluirExercicio(String num) throws ExercicioInexistenteException{
		this.gE.excluirExercicio(num);
	}
	
	public Map<String,Exercicio> exibeExercicios(){
		return this.gE.getExercicios();
	}
	
	public Exercicio sortearExercicioParaAluno(){
		return this.gE.sortearExercicio();
	}
	
	public void cadastrarMensagem(String numM,String matDestinatario,String msg) throws MensagemJaExisteException{
		this.gM.cadastrarMensagemPara(numM,matDestinatario, msg);
	}
	
	public List<Mensagem> pesquisaMensagem(String matAluno) throws MensagemInexistenteException{
		return this.gM.pesquisarMensagensDe(matAluno);
	}
	
	public void excluirMensagem(String matAluno) throws MensagemInexistenteException{
		this.gM.removerMensagemDe(matAluno);
	}
	
	public void insereRespostasExercicio(String numR,String matA,String numE) throws RespostaJaExisteException{
		this.gR.cadastrarRespostasExercicio(numR, matA, numE);
	}
	
	public void insereRespostaDeQuestaoEmResposta(String numR, String resp) throws RespostaInexistenteException{
		this.gR.cadastraRespostaDeQuestaoEmResposta(numR, resp);
	}
	
	public Map<String,RespostaExercicio> exibeRespostaExer(String numE)throws RespostaInexistenteException{
		return this.gR.pesquisaRespExer(numE);
	}
	public void excluirResposta(String num) throws RespostaInexistenteException{
		this.gR.excluirResposta(num);
	}
	public Map<String,RespostaExercicio> getRespostasExer(){
		return this.gR.getRespExer();
	}
	public List<String> exibeRespostasDeExerRespondido(String numExeResp){
		return this.gR.getRespostasExercicioRespondido(numExeResp);
	}
}

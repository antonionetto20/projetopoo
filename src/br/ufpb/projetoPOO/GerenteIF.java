package br.ufpb.projetoPOO;

import java.util.List;

public interface GerenteIF {

	
	public void cadastrarTurma(String numero,String disciplina) throws TurmaJaExisteException;
	public List<String> pesquisarTurmas()throws TurmaInexistenteException;
	public void excluirTurma(String numTurma) throws TurmaInexistenteException;
	public void cadastraProfessorEmTurma(String numTurma, Pessoa professor) throws TurmaInexistenteException;
	public void cadastraAlunoEmTurma(String numTurma,Pessoa aluno)throws TurmaInexistenteException;
	public void cadastraExercicioDeTurma(String numTurma,Exercicio exercicio)throws TurmaInexistenteException;
	public void excluirExercicioDeTurma(String numTurma,String numExercicio)throws TurmaInexistenteException,ExercicioJaExisteException;
	public void cadastraMensagemDeTurma(String numTurma,Mensagem mensagem) throws TurmaInexistenteException;
	
	//Paramos aqui
	
	public void excluirMensagemDeTurma(String numMensagem,String numTurma);
	public void cadastraQuestaoEmBancoDeDados(Questao questao);
	public void excluirQuestaoDoBancoDeDados(String numQuestao,String tipoQuestao);
	public void cadastraQuestaoEmExercicio(String numQuestao,String numTurma,String numExercicio);
	public void corrigeExercicio(String numTurma,String numExercicio);
	public void alunoResponderQuestao(String numTurma,String numExercicio,String resposta);
	public void sortearQuestaoParaExercicioEmTurma(String numTurma,String numExercicio);
	public void adicionaAlunoEmMap(Aluno aluno);
	public void imprimeAlunosMapa();
	public void imprimeSoNomeAlunosMapa();
	public void removeAlunoMapa(String matricula);
	
}

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestaFachada {
	private Fachada fa;

	@Before
	public void setUp() throws Exception {
		this.fa = new Fachada();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCadastroPesquisaRemoveAluno() throws AlunoInexistenteException, AlunoJaExisteException{
		
		// Adicionando alunos
		fa.cadastroDeAluno("Antonio", "81221162");
		fa.cadastroDeAluno("Thalles", "81221169");
		fa.cadastroDeAluno("Ayrton", "81221168");
		
		// testando a pesquisa aluno
		assertTrue(fa.pesquisaAluno("81221162").getNome().equals("Antonio"));
		assertFalse(fa.pesquisaAluno("81221162").getNome() != "Antonio");
		assertEquals(fa.pesquisaAluno("81221162").getNome(),"Antonio");
		
		// excluindo aluno
		fa.excluirAluno("81221168");
		
		// // testando se foi excluido pesquisando a qtde no Map
		assertTrue(fa.exibeAlunos().size() == 2);
		assertFalse(fa.exibeAlunos().size() != 2);
		assertEquals(fa.exibeAlunos().size(), 2);
		
		// Perguntar a Ayla
		//try{
			//fa.excluirAluno("81221169");
			//fa.excluirAluno("81221162");
			
		//	assertTrue(fa.exibeAlunos().size() == 2);
		//	assertFalse(fa.exibeAlunos().size() != 2);
		//	assertEquals(fa.exibeAlunos().size(), 2);
			
		//}catch(){
			//fail("ERRO, Lista VAZIA");
		//}
		
	}
	
	public void testCadastroPesquisaEditaRemoveQuestao() throws QuestaoInexistenteException, QuestaoJaExisteException{
		
		//Adicionando Questões
		fa.cadastraQuestao("1", "Quanto é 1 + 1 ?", "2",TipoQuestao.DISSERTATIVA);
		fa.cadastraQuestao("2", "Marque a correta: () 1 + 1 = 3 () 1 + 2 = 3", "(X) 1 + 2 = 3", TipoQuestao.MULTIPLA_ESCOLHA);
		fa.cadastraQuestao("3", "Marque V ou F: () 1 + 1 = 3 () 1 + 2 = 3", "(F) 1 + 1 = 3 (V) 1 + 2 = 3", TipoQuestao.V_OU_F);
		
		// Testando pesquisa questões
		assertTrue(fa.pesquisaQuestao("1", TipoQuestao.DISSERTATIVA).getDescricao() == "Quanto é 1 + 1 ?");
		assertFalse(fa.pesquisaQuestao("1", TipoQuestao.DISSERTATIVA).getDescricao() != "Quanto é 1 + 1 ?");
		assertEquals(fa.pesquisaQuestao("1", TipoQuestao.DISSERTATIVA).getRespostaCorreta(),"2");
		
		// editando questão
		fa.editarDescricaoDeQuestao("1","Quanto é 2 + 2 ?" , TipoQuestao.DISSERTATIVA);
		fa.editarRespostaDeQuestao("1","4" , TipoQuestao.DISSERTATIVA);
		
		// Testando se foi editado com exito
		assertTrue(fa.pesquisaQuestao("1", TipoQuestao.DISSERTATIVA).getDescricao().equals("Quanto é 2 + 2 ?"));
		assertTrue(fa.pesquisaQuestao("1", TipoQuestao.DISSERTATIVA).getRespostaCorreta().equals("4"));
		
		// excluindo questao
		fa.excluirQuestao("2", TipoQuestao.MULTIPLA_ESCOLHA);
		
		// testando se foi excluida pesquisando a qtde no Map
		assertTrue(fa.exibeQuestoes(TipoQuestao.DISSERTATIVA).size() == 1);
		assertFalse(fa.exibeQuestoes(TipoQuestao.MULTIPLA_ESCOLHA).size() != 0);
		assertEquals(fa.exibeQuestoes(TipoQuestao.V_OU_F).size(),1);
		
	}
	
	public void testeCadastroPesquisaSorteiaRemoveExercicio() throws ExercicioInexistenteException, ExercicioJaExisteException{
		
		// cadastrando exercicios
		fa.cadastrarExercicio("1");
		fa.cadastrarExercicio("2");
		fa.cadastrarExercicio("3");
		
		// testando pesquisando exercicio adicionado
		assertTrue(fa.pesquisaExercicio("1").getQuestoes().size() == 0);
		
		// excluindo exercicio
		fa.excluirExercicio("2");
		
		// testando se foi excluida pesquisando a qtde no Map
		assertTrue(fa.exibeExercicios().size() == 2);
		assertFalse(fa.exibeExercicios().size() != 2);
		assertEquals(fa.exibeExercicios().size(), 2);
		
		List<Exercicio> ex1 = new ArrayList<Exercicio>();
		ex1.add(this.fa.sortearExercicioParaAluno());
		assertTrue(ex1.size() == 1);
		
	}
	
	public void testeCadastroPesquisaRemoveQuestaoExercicio() throws ExercicioInexistenteException, QuestaoInexistenteException, ExercicioJaExisteException, QuestaoJaExisteException{
		
		// cadastrando exercicio
		fa.cadastrarExercicio("1");
		
		// cadastrando questoes
		fa.cadastraQuestao("1", "Quanto é 1 + 1 ?", "2",TipoQuestao.DISSERTATIVA);
		fa.cadastraQuestao("2", "Marque a correta: () 1 + 1 = 3 () 1 + 2 = 3", "(X) 1 + 2 = 3", TipoQuestao.MULTIPLA_ESCOLHA);
		fa.cadastraQuestao("3", "Marque V ou F: () 1 + 1 = 3 () 1 + 2 = 3", "(F) 1 + 1 = 3 (V) 1 + 2 = 3", TipoQuestao.V_OU_F);
		
		// inserindo a questao
		fa.inserirQuestaoEmExercicio("1", "1",TipoQuestao.DISSERTATIVA );
		fa.inserirQuestaoEmExercicio("1", "2",TipoQuestao.MULTIPLA_ESCOLHA );
		fa.inserirQuestaoEmExercicio("1", "3",TipoQuestao.V_OU_F );
		
		// testando se a questao foi inserida no exercicio
		assertTrue(fa.pesquisaQuestaoEmExercicio("1", "1").getDescricao().equals("Quanto é 1 + 1 ?"));
		assertFalse(fa.pesquisaQuestaoEmExercicio("1", "1").getRespostaCorreta() != "2");
		assertEquals(fa.pesquisaQuestaoEmExercicio("1", "3").getDescricao(), "Marque V ou F: () 1 + 1 = 3 () 1 + 2 = 3");
		
		// excluindo a questao do exercicio
		fa.excluirQuestaoDeExercicio("1", "2");
		
		// testando se foi excluida pesquisando a qtde no Map
		assertTrue(fa.exibeQuestoesDeExercicio("1").size() == 2);
		assertFalse(fa.exibeQuestoesDeExercicio("1").size() != 2);
		assertEquals(fa.exibeQuestoesDeExercicio("1").size(), 2);
		
	}
	
	public void testaCadastraPesquisaExcluiMensagem() throws MensagemInexistenteException, MensagemJaExisteException{
		
		// cadastrando msgs
		fa.cadastrarMensagem("1","111", "Thalles, você foi muito mal na prova");
		fa.cadastrarMensagem("2","333", "Antônio, você foi muito bem na prova");
		fa.cadastrarMensagem("3","222", "Antônio e Thalles, vocês não conseguiram fazer os botões");
		
		// excluindo msg
		fa.excluirMensagem("333");
		
		// pesquisando e testando se foi cadastrada a msg
		assertTrue(fa.pesquisaMensagem("111").get(0).getMensagem() == "Thalles, você foi muito mal na prova");
		assertFalse(fa.pesquisaMensagem("111").get(0).getMensagem() != "Thalles, você foi muito mal na prova");
		assertEquals(fa.pesquisaMensagem("111").get(0).getMensagem(), "Thalles, você foi muito mal na prova");
		
		// testando se foi excluida pesquisando a qtde no Map
		assertTrue(fa.pesquisaMensagem("111").size() == 1);
		assertFalse(fa.pesquisaMensagem("111").size() != 1);
		assertEquals(fa.pesquisaMensagem("111").size(), 1);
		
	}
	
	public void testaCadastroPesquisaRemoveExibe() throws RespostaJaExisteException, RespostaInexistenteException{
		
		// cadastrando exercicios respondidos
		this.fa.insereRespostasExercicio("1", "81221162", "1");
		this.fa.insereRespostasExercicio("2", "81221168", "2");
		
		// cadastrando respostas nos exercicios respondidos
		this.fa.insereRespostaDeQuestaoEmResposta("1", "Questao 5 R= (X) 2");
		this.fa.insereRespostaDeQuestaoEmResposta("1", "Questao 2 R= (V) 2,(F) 5,(V) 6");
		this.fa.insereRespostaDeQuestaoEmResposta("2", "Questao 6 R= Antônio Neto é Gato");
		
		//testando o os metodos de pesquisa dos exercicios respondidos e suas respostas
		assertTrue(this.fa.exibeRespostaExer("1").values().size() == 1);
		assertTrue(this.fa.getRespostasExer().size() == 2);
		assertFalse(this.fa.exibeRespostaExer("1").values().size() != 1);
		assertFalse(this.fa.getRespostasExer().size() != 2);
		assertTrue(this.fa.exibeRespostasDeExerRespondido("1").size() == 2);
		
		// testando excluindo exercicio respondido
		this.fa.excluirResposta("1");
		assertTrue(this.fa.getRespostasExer().size() == 1);
	}
}

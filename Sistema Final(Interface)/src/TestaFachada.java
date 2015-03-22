import static org.junit.Assert.*;

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

	@Test
	public void testaGerenteDePessoas() throws AlunoJaExisteException, AlunoInexistenteException {
		
		this.fa.cadastraAlunoNoSistema("81221169");
		this.fa.cadastraAlunoNoSistema("81221168");
		this.fa.cadastraAlunoNoSistema("81221162");
		
		assertTrue(this.fa.retornaAlunos().size() == 3);
		
		this.fa.removerAlunoSistema("81221162");
		
		assertTrue(this.fa.retornaAlunos().size() == 2);
		
		this.fa.enviarMensagemParaAluno("81221169", "Tu é inteligente");
		
		assertTrue(this.fa.pesquisaAluno("81221169").getMensagens().size() == 1);
		
		this.fa.enviarMensagemParaProfessor("Professor bonzinho");
		
		assertTrue(this.fa.retornaMsgsProf().size() == 1);
		
	}
	
	@Test
	public void testaGerenteDeQuestoes() throws QuestaoJaExisteException, QuestaoInexistenteException{
		
		this.fa.cadastrarQuestaoVouF("1", "Quanto é 1+1 ? ", TipoQuestao.VouF, "V", "V", "F", "V", "F");
		this.fa.cadastrarQuestaoMultiplaEscolha("2", "Marque a letra correta", TipoQuestao.MultEscolha, "A");
		this.fa.cadastroQuestaoDissertativa("3", "Quanto é 2+1", TipoQuestao.Dissertativa, "3");
		this.fa.cadastroQuestaoDissertativa("4", "Quanto é 2+2", TipoQuestao.Dissertativa, "4");
		
		assertTrue(this.fa.pesquisaQuestao("1").getDescricao().equals("Quanto é 1+1 ? "));
		assertFalse(this.fa.pesquisaQuestao("2").exibeRespostaCorreta() != "A");
		assertEquals(this.fa.pesquisaQuestao("3").getQtdeAcertos(),0);
		
		assertTrue(this.fa.retornaQuestoesDissertativa().size() == 2);
		this.fa.removerQuestao("3");
		assertTrue(this.fa.retornaQuestoesDissertativa().size() == 1);
		
		this.fa.aumentaAcertosEmQuestao("2", TipoQuestao.MultEscolha);
		assertEquals(this.fa.pesquisaQuestao("2").getQtdeAcertos(),1);
		
		this.fa.modificarDescricaoQuestao("2", "Modificado");
		assertTrue(this.fa.pesquisaQuestao("2").getDescricao().equals("Modificado"));
		
		assertEquals(this.fa.corrigeRespostaMultiplaEscolha("2", "A"),"Acertou");
		assertTrue(this.fa.corrigeRespostaVouF("1", "V", "V", "F", "V", "F").equals("Acertou tudo"));
		this.fa.enviarMensagemParaProfessor(this.fa.enviaRespostaDissertativa("4", "4", "81221162"));
		
		assertTrue(this.fa.retornaMsgsProf().size() == 1);
	
	}
	@Test
	public void testaGerenteDeExercicios() throws ExercicioJaExisteException, ExercicioInexistenteException{
		
		this.fa.CadastraExercicio("1");
		this.fa.CadastraExercicio("2");
		
		this.fa.adicionaQuestaoEmExercicio("1", new QuestaoVouF("1", "Quanto é 1+1 ? ", TipoQuestao.VouF, "V", "V", "F", "V", "F"));
		assertEquals(this.fa.pesquisaExercicio("1").getQuestoesExercicio().get("1").getDescricao(),"Quanto é 1+1 ? ");
		assertTrue(this.fa.pesquisaExercicio("1").getQuestoesExercicio().size() == 1);
		
		this.fa.incrementaQtdeFechamentosExercicio("1");
		assertTrue(this.fa.pesquisaExercicio("1").getQtdeAlunosQueFecharam() == 1);
		
		assertTrue(this.fa.pesquisaExercicios().size() == 2);
		this.fa.removeExercicio("2");
		assertTrue(this.fa.pesquisaExercicios().size() == 1);
			
	}
	
}

import java.awt.*;

import javax.swing.JOptionPane;

import java.awt.event.*;

import javax.swing.*;

public class GuiMenuPrincipal extends JFrame{

	private Container contentPane;
	private JMenuBar mnBarra;
	private JMenu mnAluno, mnProfessor,mnExercicio;
	private Fachada fD;
	private JMenuItem  miModificaRespostaQuestaoVouF , miModificaRespostaQuestaoMult , miModificaRespostaDissert , miModificaDescrQuestao , miMostraPesquisaExercicio , miCadastrarExercicio , miPesquisarExercicio , miRemoveExercicio , miRemoveQuestao , miEnviaRespostaDissert , miCadastrarRespostaQuestoesMult , miCadastrarRespostaQuestoesVouF, miCadastrarQuestoesVouF ,miCadastrarQuestoesMulEscolha , miCadastrarQuestoesDissert, miSorteaQuestao, miSair, micadastrarAluno , miremoverAluno , mipesquisaAluno,mimsgAluno,  miRespondeQuestoes, miFeedBack;
	
	public GuiMenuPrincipal(){
		this.fD=new Fachada();
		inicializarComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setTitle("Menu Principal");
		setBounds(0,0,800,600);
		contentPane = getContentPane();
		mnBarra = new JMenuBar();
		mnAluno = new JMenu("Aluno");
		mnExercicio = new JMenu("Exercicio");
		mnAluno.setMnemonic('A');
		miSorteaQuestao= new JMenuItem("Sortea Questão");
		miRespondeQuestoes = new JMenuItem("Responder Questões");
		miFeedBack = new JMenuItem("FeedBack");
		mnProfessor = new JMenu("Professor");
		mnProfessor.setMnemonic('E');
		miSair = new JMenuItem("Sair");
		miSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		micadastrarAluno = new JMenuItem("Cadastrar Aluno");
		miremoverAluno = new JMenuItem("Remover Aluno");
		mipesquisaAluno = new JMenuItem("Pesquisar Aluno");
		miCadastrarQuestoesVouF = new JMenuItem("Cadastrar QuestoesVouF");
		miCadastrarQuestoesMulEscolha = new JMenuItem("Cadastrar Questoes Multipla Escolha");
		miCadastrarQuestoesDissert = new JMenuItem("Cadastrar Questoes Dissertativas");
		miCadastrarRespostaQuestoesVouF = new JMenuItem("Cadastrar Resposta Verdadeiro ou Falso");
		miCadastrarRespostaQuestoesMult = new JMenuItem("Cadastrar Resposta Multipla Escolha");
		miEnviaRespostaDissert = new JMenuItem("Cadastrar Resposta Dissertativa");
		mimsgAluno = new JMenuItem("Enviar Mensagem para o Aluno");
		miRemoveQuestao = new JMenuItem("Remover Questao");
		miRemoveExercicio = new JMenuItem("Remover Exercicio");
		miPesquisarExercicio = new JMenuItem("Pesquisa Exercicio");
		miCadastrarExercicio = new JMenuItem("Cadastrar Exercicio");
		miMostraPesquisaExercicio = new JMenuItem("Pesquisa e mostra Exercicios");
		miModificaDescrQuestao = new JMenuItem("Modifica Descrição de Questão");
		miModificaRespostaDissert = new JMenuItem("Modifica Resposta Questão Dissertativa");
		miModificaRespostaQuestaoMult = new JMenuItem("Modifica Resposta Questão Multiplica Escolha");
		miModificaRespostaQuestaoVouF = new JMenuItem("Modifica Resposta Questão V ou F");
		
		mnAluno.add(miSair);
		mnAluno.add(miFeedBack);
		mnAluno.add(miEnviaRespostaDissert);
		mnAluno.add(miCadastrarRespostaQuestoesMult);
		mnAluno.add(miCadastrarRespostaQuestoesVouF);
		mnAluno.add(mnExercicio);
		
		mnExercicio.add(miSorteaQuestao);
		mnExercicio.add(miRespondeQuestoes);
		
		mnProfessor.add(miModificaRespostaDissert);
		mnProfessor.add(miModificaRespostaQuestaoMult);
		mnProfessor.add(miModificaRespostaQuestaoVouF);
		mnProfessor.add(miModificaDescrQuestao);
		mnProfessor.add(miCadastrarExercicio);
		mnProfessor.add(miPesquisarExercicio);
		mnProfessor.add(micadastrarAluno);
		mnProfessor.add(miremoverAluno);
		mnProfessor.add(mipesquisaAluno);
		mnProfessor.add(mimsgAluno);
		mnProfessor.add(miCadastrarQuestoesVouF);
		mnProfessor.add(miCadastrarQuestoesMulEscolha);
		mnProfessor.add(miCadastrarQuestoesDissert);
		mnProfessor.add(miRemoveQuestao);
		mnProfessor.add(miRemoveExercicio);
		mnProfessor.add(miMostraPesquisaExercicio);
		
		mnBarra.add(mnAluno);
		mnBarra.add(mnProfessor);
		setJMenuBar(mnBarra);
		
	}

	private void definirEventos() {
		miSair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		micadastrarAluno.addActionListener(new ActionListener(){// Cadastra Aluno
			public void actionPerformed(ActionEvent e){
				String mat= JOptionPane.showInputDialog("MATRICULA: ");
				try {
					fD.cadastraAlunoNoSistema(mat);
				} catch (AlunoJaExisteException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		miremoverAluno.addActionListener(new ActionListener(){// remove Aluno pela matricula
			public void actionPerformed(ActionEvent e) {
				String mat= JOptionPane.showInputDialog("MATRICULA: ");
				try {
					fD.removerAlunoSistema(mat);
				} catch (AlunoInexistenteException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		mipesquisaAluno.addActionListener(new ActionListener(){// Pesquisa Aluno pela Matricula.
			public void actionPerformed(ActionEvent e) {
				String mat= JOptionPane.showInputDialog("MATRICULA: ");
				try {
					JOptionPane.showMessageDialog(null,fD.pesquisaAluno(mat).getMensagens());
				} catch (AlunoInexistenteException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		
		mimsgAluno.addActionListener(new ActionListener(){// Mensagem para Aluno.
			public void actionPerformed (ActionEvent e){
				String mat= JOptionPane.showInputDialog("MATRICULA: ");
				String msg= JOptionPane.showInputDialog("Mensagem:  ");
				try {
					fD.enviarMensagemParaAluno(mat, msg);
				} catch (AlunoInexistenteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		miSorteaQuestao.addActionListener(new ActionListener(){ // Sorteia a Questao.
			public void actionPerformed (ActionEvent e){
				fD.sortearQuestao();
				
			}
		});
	
		miCadastrarQuestoesVouF.addActionListener (new ActionListener(){
			public void actionPerformed (ActionEvent e){
				String num= JOptionPane.showInputDialog("Numero da Questão");
				String descr= JOptionPane.showInputDialog("Descrição");
				String r1= JOptionPane.showInputDialog("Resposta Numero 1");
				String r2 = JOptionPane.showInputDialog("Resposta Numero 2");
				String r3 = JOptionPane.showInputDialog("Resposta Numero 3");
				String r4 = JOptionPane.showInputDialog("Resposta Numero 4");
				String r5 = JOptionPane.showInputDialog("Resposta Numero 5");
			 try {
				fD.cadastrarQuestaoVouF(num, descr, TipoQuestao.MultEscolha, r1, r2, r3, r4, r5);
			} catch (QuestaoJaExisteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			}
		});
		miCadastrarQuestoesMulEscolha.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				String num = JOptionPane.showInputDialog("Digite o número da questão");
				String descr = JOptionPane.showInputDialog("Descrição");
				String resp = JOptionPane.showInputDialog("Resposta");
				try {
					fD.cadastrarQuestaoMultiplaEscolha(num, descr, TipoQuestao.MultEscolha, resp);
				} catch (QuestaoJaExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		miCadastrarQuestoesDissert.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
			
				String num = JOptionPane.showInputDialog("Numero da questão");
				String descr = JOptionPane.showInputDialog("Descrição:");
				String resp = JOptionPane.showInputDialog("Resposta");
				try {
					fD.cadastroQuestaoDissertativa(num, descr, TipoQuestao.Dissertativa, resp);
				} catch (QuestaoJaExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		miEnviaRespostaDissert.addActionListener(new ActionListener(){ // Envia mensagem para o Professor
			public void actionPerformed (ActionEvent e){
				
				String numQ = JOptionPane.showInputDialog("Numero da Questao");
				String resp = JOptionPane.showInputDialog("Resposta");
				String matA = JOptionPane.showInputDialog("Matricula do Aluno:");
				fD.enviarMensagemParaProfessor(fD.enviaRespostaDissertativa(numQ, resp, matA));
			}
		});
		
		miRemoveQuestao.addActionListener(new ActionListener(){ // Remove Questão
			public void actionPerformed (ActionEvent e){
				
				String num = JOptionPane.showInputDialog("Digite o Número da Questão");
				try {
					fD.removerQuestao(num);
				} catch (QuestaoInexistenteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		miRemoveExercicio.addActionListener(new ActionListener(){// Remover Exercicio
			public void actionPerformed (ActionEvent e){
			
				String num = JOptionPane.showInputDialog("Digite o Número do Exercicio");
				try {
					fD.removeExercicio(num);
				} catch (ExercicioInexistenteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		miCadastrarExercicio.addActionListener(new ActionListener(){// Cadastrar Exercicio
			public void actionPerformed (ActionEvent e){
			
				String num = JOptionPane.showInputDialog("Digite o número do exercicio");
				try {
					fD.CadastraExercicio(num);
				} catch (ExercicioJaExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		miPesquisarExercicio.addActionListener(new ActionListener(){ // Pesquisa Exercicio
			public void actionPerformed (ActionEvent e){
				
				String num = JOptionPane.showInputDialog("Digite o número do exercicio");
				try {
					fD.pesquisaExercicio(num);
				} catch (ExercicioInexistenteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		miMostraPesquisaExercicio.addActionListener(new ActionListener(){ // Mostra todos os exercicios
			public void actionPerformed (ActionEvent e){
				
				JOptionPane.showMessageDialog(null, fD.pesquisaExercicios());
			}
		});
		
		miModificaDescrQuestao.addActionListener(new ActionListener(){ // Modifica descrição da Questão
			public void actionPerformed (ActionEvent e){
			
				
				String num = JOptionPane.showInputDialog("Digite o Número da Questao");
				String descr = JOptionPane.showInputDialog("Digite a Nova Descrição");
				try {
					fD.modificarDescricaoQuestao(num, descr);
				} catch (QuestaoInexistenteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		miModificaRespostaDissert.addActionListener(new ActionListener(){ // Modifica Resposta da questões dissertativa
			public void actionPerformed(ActionEvent e){
				
				
				String num = JOptionPane.showInputDialog("Digite o Número da Questao");
				String resp = JOptionPane.showInputDialog("Digite a Resposta");
				try {
					fD.modificarRespostaQuestaoDissertativa(num, resp);
				} catch (QuestaoInexistenteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		miModificaRespostaQuestaoMult.addActionListener(new ActionListener(){ // Modifica Resposta da Questão
			public void actionPerformed(ActionEvent e){
			
				String num = JOptionPane.showInputDialog("Digite Núumero da Questao");
				String resp = JOptionPane.showInputDialog("Digite a Resposta");
				try {
					fD.modificarRespostaQuestaoMultiplaEscolha(num, resp);
				} catch (QuestaoInexistenteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		miModificaRespostaQuestaoVouF.addActionListener(new ActionListener(){ // Modifica Resposta da Questao V ou F
			public void actionPerformed (ActionEvent e){
			
				String num = JOptionPane.showInputDialog("Digite o Número da Questão");
				String r1 = JOptionPane.showInputDialog("Digite a Resposta1 ");
				String r2 = JOptionPane.showInputDialog("Digite a Resposta2");
				String r3 = JOptionPane.showInputDialog("Digite a Resposta3");
				String r4 = JOptionPane.showInputDialog("Digite a Resposta4");
				String r5 = JOptionPane.showInputDialog("Digite a Resposta5");
				try {
					fD.modificarRespostaQuestaoVouF(num, r1, r2, r3, r4, r5);
				} catch (QuestaoInexistenteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
	public static void abrir(){
		GuiMenuPrincipal frame = new GuiMenuPrincipal();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width) / 2, (tela.height - frame.getSize().height) / 2);
		frame.setVisible(true);
		
	}
}
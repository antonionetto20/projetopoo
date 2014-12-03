package br.ufpb.projetoPOO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gerente implements GerenteIF{

	List <Turma> turmas;
	List <Questao> questoesVouF;
	List <Questao> questpesDissertativas;
	List <Questao> questoesMultEscolha;
	Map<String,Aluno> alunosM;
	
	public Gerente(){
		this.turmas=new ArrayList <Turma> ();
		this.questoesVouF=new ArrayList <Questao>();
		this.questpesDissertativas=new ArrayList <Questao>();
		this.questoesMultEscolha=new ArrayList <Questao>();
		this.alunosM = new HashMap<String,Aluno>();
	}
	
	
	public void cadastrarTurma(String numero,String disciplina)throws TurmaJaExisteException{
		if(this.turmas.size() > 0){
			for(Turma t: this.turmas){
				if(t.getNumero().equals(numero)){
					throw new TurmaJaExisteException("Já existe uma turma com esse número");
				}
			}
		}
		new Turma(numero, disciplina);	
		
	}
	
	public List<String> pesquisarTurmas()throws TurmaInexistenteException{
		if(this.turmas.size() > 0){
			List<String> turmasS = new ArrayList<String>();
			for(Turma t: turmas){
				turmasS.add(t.ToString() + "\n");
			}return turmasS;
		}else{
			throw new TurmaInexistenteException("Não existem turmas");
		}
	}

	public void excluirTurma(String numTurma)throws TurmaInexistenteException{
		boolean existe = false;
		for(Turma t: this.turmas){
			if(t.getNumero().equals(numTurma)){
				this.turmas.remove(t);
				existe = true;
				break;
			}
		}if(existe == false){
			throw new TurmaInexistenteException("Turma não existe");
		}
	}
	
	
	public void cadastraProfessorEmTurma(String numTurma, Professor professor) throws TurmaInexistenteException {
		boolean existe = false;
		if(this.turmas.size() > 0){
			for(Turma t: this.turmas){
				if(t.getNumero().equals(numTurma)){
					t.setProfessor(professor);
					existe = true;
					break;
				}
			}
		}throw new TurmaInexistenteException("Não existe uma turma com esse número");
	}

	public void cadastraAlunoEmTurma(String numTurma, Aluno aluno) throws TurmaInexistenteException {
		boolean existe = false;
		if(this.turmas.size() > 0){
			for(Turma t: this.turmas){
				if(t.getNumero().equals(numTurma)){
					t.setAluno(aluno);
					existe = true;
					break;
				}
			}
		}throw new TurmaInexistenteException("Não existe uma turma com esse número");
	}
	
	public void cadastraExercicioEmTurma(String numTurma, Exercicio exercicio) throws TurmaInexistenteException {
		boolean existe = false;
		if(this.turmas.size() > 0){
			for(Turma t: this.turmas){
				if(t.getNumero().equals(numTurma)){
					t.setExercicio(exercicio);
					existe = true;
					break;
				}
			}
		}throw new TurmaInexistenteException("Não existe uma turma com esse número");
	}
	
	public void excluirExercicioDeTurma(String numTurma,String numExercicio)throws TurmaInexistenteException,ExercicioJaExisteException{
		boolean existe = false;
		if(this.turmas.size() > 0){
			for(Turma t: this.turmas){
				if(t.getNumero().equals(numTurma)){
					if(t.getExercicios().size() > 0){
						for(Exercicio e: t.getExercicios()){
							if(e.getNumero().equals(numExercicio)){
								t.getExercicios().remove(e);
								existe = true;
								break;
							}
						}throw new ExercicioJaExisteException("Não existe um exercicio com esse numero");
						
					}
				}
			}
		}throw new TurmaInexistenteException("Não existe uma turma com esse número");
	}

	public void cadastraMensagemDeTurma(String numTurma,Mensagem mensagem) throws TurmaInexistenteException {
		boolean existe = false;
		if(this.turmas.size() > 0){
			for(Turma t: this.turmas){
				if(t.getNumero().equals(numTurma)){
					t.setMenssagem(mensagem);
					existe = true;
					break;
				}
			}
		}throw new TurmaInexistenteException("Não existe uma turma com esse número");
	}

	//Paramos aqui
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
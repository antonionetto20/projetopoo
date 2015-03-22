
public class CorretorRespostas {
	GerenteDeQuestoes q;
	public CorretorRespostas(){
		this.q = new GerenteDeQuestoes();
	}
	
	public String corrigeRespostaVouF(String numQ, String rA1, String rA2, String rA3, String rA4, String rA5){
		String msg = "Respostas corretas: a)" + q.retornaQuestoesVouF().get(numQ).getResp1() + 
				     " b)" + q.retornaQuestoesVouF().get(numQ).getResp2() + 
				     " c)" + q.retornaQuestoesVouF().get(numQ).getResp3() + 
				     " d)" + q.retornaQuestoesVouF().get(numQ).getResp4() + 
				     " e)" + q.retornaQuestoesVouF().get(numQ).getResp5() + "/n/n";
		if(rA1.equals(q.retornaQuestoesVouF().get(numQ).getResp1())){
			msg += "Você acertou a letra a), parabéns !!!/n/n";
		}else{
			msg += "Você marcou: " + rA1 + " na letra e) e errou a alternativa, que pena !!!/n/n";
		}
		if(rA2.equals(q.retornaQuestoesVouF().get(numQ).getResp2())){
			msg += "Você acertou a letra b), parabéns !!!/n/n";
		}else{
			msg += "Você marcou: " + rA2 + " na letra e) e errou a alternativa, que pena !!!/n/n";
		}
		if(rA3.equals(q.retornaQuestoesVouF().get(numQ).getResp3())){
			msg += "Você acertou a letra c), parabéns !!!/n/n";
		}else{
			msg += "Você marcou: " + rA3 + " na letra e) e errou a alternativa, que pena !!!/n/n";
		}
		if(rA4.equals(q.retornaQuestoesVouF().get(numQ).getResp4())){
			msg += "Você acertou a letra d), parabéns !!!/n/n";
		}else{
			msg += "Você marcou: " + rA4 + " na letra e) e errou a alternativa, que pena !!!/n/n";
		}
		if(rA5.equals(q.retornaQuestoesVouF().get(numQ).getResp5())){
			msg += "Você acertou a letra e), parabéns !!!/n/n";
		}else{
			msg += "Você marcou: " + rA5 + " na letra e) e errou a alternativa, que pena !!!/n/n";
		}
		return msg;
	}
	
	public String corrigeRespostaMultiplaEscolha(String numQ, String resp){
		String msg = "Resposta correta: " + q.retornaQuestoesMultiplaEscolha().get(numQ).getResposta() + "/n/n";
		if(resp.equals(q.retornaQuestoesMultiplaEscolha().get(numQ).getResposta())){
			msg += "Você acertou a alternativa, parabéns !!!/n/n";
		}else{
			msg += "Você marcou a letra: " + resp + " e errou a alternativa, que pena !!!/n/n";
		}return msg;
	}
	
	public String enviaRespostaDissertativa(String numQ, String resp, String matA){
		return "Matricula do aluno: /n/n" + matA + 
				"Descricão da pergunta: /n/n" + q.retornaQuestoesDissertativa().get(numQ).getDescricao() + "/n/n" +
				"Resposta correta: /n/n" + q.retornaQuestoesDissertativa().get(numQ).getResposta() + "/n/n" +
				"Resposta do aluno: /n/n" + resp;
	}
	
	
}

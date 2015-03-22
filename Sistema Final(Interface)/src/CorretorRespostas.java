
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
			msg += "Voc� acertou a letra a), parab�ns !!!/n/n";
		}else{
			msg += "Voc� marcou: " + rA1 + " na letra e) e errou a alternativa, que pena !!!/n/n";
		}
		if(rA2.equals(q.retornaQuestoesVouF().get(numQ).getResp2())){
			msg += "Voc� acertou a letra b), parab�ns !!!/n/n";
		}else{
			msg += "Voc� marcou: " + rA2 + " na letra e) e errou a alternativa, que pena !!!/n/n";
		}
		if(rA3.equals(q.retornaQuestoesVouF().get(numQ).getResp3())){
			msg += "Voc� acertou a letra c), parab�ns !!!/n/n";
		}else{
			msg += "Voc� marcou: " + rA3 + " na letra e) e errou a alternativa, que pena !!!/n/n";
		}
		if(rA4.equals(q.retornaQuestoesVouF().get(numQ).getResp4())){
			msg += "Voc� acertou a letra d), parab�ns !!!/n/n";
		}else{
			msg += "Voc� marcou: " + rA4 + " na letra e) e errou a alternativa, que pena !!!/n/n";
		}
		if(rA5.equals(q.retornaQuestoesVouF().get(numQ).getResp5())){
			msg += "Voc� acertou a letra e), parab�ns !!!/n/n";
		}else{
			msg += "Voc� marcou: " + rA5 + " na letra e) e errou a alternativa, que pena !!!/n/n";
		}
		return msg;
	}
	
	public String corrigeRespostaMultiplaEscolha(String numQ, String resp){
		String msg = "Resposta correta: " + q.retornaQuestoesMultiplaEscolha().get(numQ).getResposta() + "/n/n";
		if(resp.equals(q.retornaQuestoesMultiplaEscolha().get(numQ).getResposta())){
			msg += "Voc� acertou a alternativa, parab�ns !!!/n/n";
		}else{
			msg += "Voc� marcou a letra: " + resp + " e errou a alternativa, que pena !!!/n/n";
		}return msg;
	}
	
	public String enviaRespostaDissertativa(String numQ, String resp, String matA){
		return "Matricula do aluno: /n/n" + matA + 
				"Descric�o da pergunta: /n/n" + q.retornaQuestoesDissertativa().get(numQ).getDescricao() + "/n/n" +
				"Resposta correta: /n/n" + q.retornaQuestoesDissertativa().get(numQ).getResposta() + "/n/n" +
				"Resposta do aluno: /n/n" + resp;
	}
	
	
}

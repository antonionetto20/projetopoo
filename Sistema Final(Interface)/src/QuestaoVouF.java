
public class QuestaoVouF extends Questao{
	private String resp1,resp2,resp3,resp4,resp5;
	
	public QuestaoVouF(String num, String descr, TipoQuestao t, String r1, String r2, String r3, String r4, String r5){
		super(num,descr,t);
		this.resp1 = r1;
		this.resp2 = r2;
		this.resp3 = r3;
		this.resp4 = r4;
		this.resp5 = r5;
	}

	public String getResp1() {
		return resp1;
	}

	public void setResp1(String resp1) {
		this.resp1 = resp1;
	}

	public String getResp2() {
		return resp2;
	}

	public void setResp2(String resp2) {
		this.resp2 = resp2;
	}

	public String getResp3() {
		return resp3;
	}

	public void setResp3(String resp3) {
		this.resp3 = resp3;
	}

	public String getResp4() {
		return resp4;
	}

	public void setResp4(String resp4) {
		this.resp4 = resp4;
	}

	public String getResp5() {
		return resp5;
	}

	public void setResp5(String resp5) {
		this.resp5 = resp5;
	}
	
	public String exibeRespostaCorreta(){
		return this.resp1 + "\n" + this.resp2 + "\n" + this.resp3 + "\n" + this.resp4 + "\n" + this.resp5;
	}
}

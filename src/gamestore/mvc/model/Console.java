package gamestore.mvc.model;

public class Console extends Produto {
	
	private String tipoDrive;
	private String outrasInformacoes;
	
	public String getTipoDrive() {
		return tipoDrive;
	}
	
	public void setTipoDrive(String tipoDrive) {
		this.tipoDrive = tipoDrive;
	}
	
	public String getOutrasInformacoes() {
		return outrasInformacoes;
	}
	
	public void setOutrasInformacoes(String outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
	}
	
}

package gamestore.mvc.model.pojo;

public class Console extends Produto {
	
	private String tipoDrive;
	private String outrasInformacoes;
	
	public String getTipoDrive() {
		return tipoDrive;
	}
	
	public Console setTipoDrive(String tipoDrive) {
		this.tipoDrive = tipoDrive;
		return this;
	}
	
	public String getOutrasInformacoes() {
		return outrasInformacoes;
	}
	
	public Console setOutrasInformacoes(String outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
		return this;
	}
	
}

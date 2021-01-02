package gamestore.mvc.model.pojo;

public class Console extends Produto {
	
	private int consoleId;
	private String tipoDrive;
	private String outrasInformacoes;
	
	public Console(int produtoId, String nome, String descricao, float preco, int consoleId, String tipoDrive,
			String outrasInformacoes) {
		super(produtoId, nome, descricao, preco);
		this.consoleId = consoleId;
		this.tipoDrive = tipoDrive;
		this.outrasInformacoes = outrasInformacoes;
	}
	
	public Console(int produtoId, String nome, String descricao, float preco, String tipoDrive,
			String outrasInformacoes) {
		super(produtoId, nome, descricao, preco);
		this.tipoDrive = tipoDrive;
		this.outrasInformacoes = outrasInformacoes;
	}
	
	public Console() {
		
	}

	public int getConsoleId() {
		return consoleId;
	}

	public Console setConsoleId(int consoleId) {
		this.consoleId = consoleId;
		return this;
	}

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

package gamestore.mvc.model.pojo;

public class Acessorio extends Produto{


	public Acessorio(int produtoId, String nome, String descricao, float preco, int acessorioId,
			String outrasInformacoes) {
		super(produtoId, nome, descricao, preco);
		this.acessorioId = acessorioId;
		this.outrasInformacoes = outrasInformacoes;
	}

	public Acessorio(String nome, String descricao, float preco, int acessorioId,
			String outrasInformacoes) {
		super(nome, descricao, preco);
		this.acessorioId = acessorioId;
		this.outrasInformacoes = outrasInformacoes;
	}

	public Acessorio() {

	}

	public Acessorio(String nome, String descricao, float preco, String outrasInformacoes) {
		super(nome, descricao, preco);
		this.outrasInformacoes = outrasInformacoes;
	}

	private int acessorioId;
	private String outrasInformacoes;

	public int getAcessorioId() {
		return acessorioId;
	}

	public Acessorio setAcessorioId(int acessorioId) {
		this.acessorioId = acessorioId;
		return this;
	}

	public String getOutrasInformacoes() {
		return outrasInformacoes;
	}

	public Acessorio setOutrasInformacoes(String outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
		return this;
	}

}

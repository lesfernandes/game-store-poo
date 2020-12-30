package gamestore.mvc.model.pojo;

public class Acessorio extends Produto{
	
	private String nome;
	private String descricao;
	private String outrasInformacoes;
	
	public String getNome() {
		return nome;
	}
	
	public Acessorio setNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Acessorio setDescricao(String descricao) {
		this.descricao = descricao;
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

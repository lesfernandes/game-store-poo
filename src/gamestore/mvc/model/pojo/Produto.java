package gamestore.mvc.model.pojo;

public class Produto {
	
	private String nome;
	private String descricao;
	private double preco;
	
	public String getNome() {
		return nome;
	}
	
	public Produto setNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Produto setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public Produto setPreco(double preco) {
		this.preco = preco;
		return this;
	}
	
	
}

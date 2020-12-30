package gamestore.mvc.model.pojo;

public class Cliente {
	
	private int codigo;
	private String nome;
	private String endereco;
	private String outrasInformacoes;
	
	public int getCodigo() {
		return codigo;
	}
	
	public Cliente setCodigo(int codigo) {
		this.codigo = codigo;
		return this;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Cliente setNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public Cliente setEndereco(String endereco) {
		this.endereco = endereco;
		return this;
	}
	
	public String getOutrasInformacoes() {
		return outrasInformacoes;
	}
	
	public Cliente setOutrasInformacoes(String outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
		return this;
	}
}

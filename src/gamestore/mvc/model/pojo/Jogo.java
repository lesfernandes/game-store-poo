package gamestore.mvc.model.pojo;

public class Jogo extends Produto {
	
	private String nome;
	private int memoriaNecessaria;
	private int numeroDeJogadores;
	private String outrasInformacoes;
	
	public String getNome() {
		return nome;
	}
	
	public Jogo setNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public int getMemoriaNecessaria() {
		return memoriaNecessaria;
	}
	
	public Jogo setMemoriaNecessaria(int memoriaNecessaria) {
		this.memoriaNecessaria = memoriaNecessaria;
		return this;
	}
	
	public int getNumeroDeJogadores() {
		return numeroDeJogadores;
	}
	
	public Jogo setNumeroDeJogadores(int numeroDeJogadores) {
		this.numeroDeJogadores = numeroDeJogadores;
		return this;
	}
	
	public String getOutrasInformacoes() {
		return outrasInformacoes;
	}
	
	public Jogo setOutrasInformacoes(String outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
		return this;
	}
	
	
}

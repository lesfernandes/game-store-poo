package gamestore.mvc.model.pojo;

public class Jogo extends Produto {
	
	private String nome;
	private int memoriaNecessaria;
	private int numeroDeJogadores;
	private String outrasInformacoes;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getMemoriaNecessaria() {
		return memoriaNecessaria;
	}
	
	public void setMemoriaNecessaria(int memoriaNecessaria) {
		this.memoriaNecessaria = memoriaNecessaria;
	}
	
	public int getNumeroDeJogadores() {
		return numeroDeJogadores;
	}
	
	public void setNumeroDeJogadores(int numeroDeJogadores) {
		this.numeroDeJogadores = numeroDeJogadores;
	}
	
	public String getOutrasInformacoes() {
		return outrasInformacoes;
	}
	
	public void setOutrasInformacoes(String outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
	}
	
	
}

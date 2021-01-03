package gamestore.mvc.model.pojo;

public class Jogo extends Produto {

	private int jogoId;
	private int memoriaNecessaria;
	private int numeroDeJogadores;
	private String outrasInformacoes;


	public Jogo(int produtoId, String nome, String descricao, float preco, int jogoId, int memoriaNecessaria,
			int numeroDeJogadores, String outrasInformacoes) {
		super(produtoId, nome, descricao, preco);
		this.jogoId = jogoId;
		this.memoriaNecessaria = memoriaNecessaria;
		this.numeroDeJogadores = numeroDeJogadores;
		this.outrasInformacoes = outrasInformacoes;
	}

	public Jogo(String nome, String descricao, float preco, int jogoId, int memoriaNecessaria,
			int numeroDeJogadores, String outrasInformacoes) {
		super(nome, descricao, preco);
		this.jogoId = jogoId;
		this.memoriaNecessaria = memoriaNecessaria;
		this.numeroDeJogadores = numeroDeJogadores;
		this.outrasInformacoes = outrasInformacoes;
	}

	public Jogo() {

	}

	public Jogo(String nome, String descricao, float preco, int memoriaNecessaria,
			int numeroDeJogadores, String outrasInformacoes) {
		super(nome, descricao, preco);
		this.memoriaNecessaria = memoriaNecessaria;
		this.numeroDeJogadores = numeroDeJogadores;
		this.outrasInformacoes = outrasInformacoes;
	}

	public int getJogoId() {
		return jogoId;
	}

	public Jogo setJogoId(int jogoId) {
		this.jogoId = jogoId;
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

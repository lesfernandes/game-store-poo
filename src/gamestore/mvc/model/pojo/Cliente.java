package gamestore.mvc.model.pojo;

public class Cliente {

	private int clienteId;
	private int codigo;
	private String nome;
	private String endereco;
	private String outrasInformacoes;

	public Cliente(int clienteId, int codigo, String nome, String endereco, String outrasInformacoes) {
		super();
		this.clienteId = clienteId;
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.outrasInformacoes = outrasInformacoes;
	}


	public Cliente(int codigo, String nome, String endereco, String outrasInformacoes) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.outrasInformacoes = outrasInformacoes;
	}


	public Cliente() {

	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

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


	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + "]";
	}


}

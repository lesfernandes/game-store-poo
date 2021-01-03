package gamestore.mvc.model.pojo;

import java.time.LocalDate;

public class Compra {

	private int compraId;
	private LocalDate data;
	private String outrasInformacoes;
	private Produto produto;
	private Cliente cliente;

	public Compra(int compraId, LocalDate data, String outrasInformacoes, Produto produto, Cliente cliente) {
		super();
		this.compraId = compraId;
		this.data = data;
		this.outrasInformacoes = outrasInformacoes;
		this.produto = produto;
		this.cliente = cliente;
	}


	public Compra(LocalDate data, String outrasInformacoes, Produto produto, Cliente cliente) {
		super();
		this.data = data;
		this.outrasInformacoes = outrasInformacoes;
		this.produto = produto;
		this.cliente = cliente;
	}


	public Compra() {

	}

	public int getCompraId() {
		return compraId;
	}

	public Compra setCompraId(int compraId) {
		this.compraId = compraId;
		return this;
	}


	public LocalDate getData() {
		return data;
	}

	public Compra setData(LocalDate data) {
		this.data = data;
		return this;
	}

	public String getOutrasInformacoes() {
		return outrasInformacoes;
	}

	public Compra setOutrasInformacoes(String outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
		return this;
	}

	public Produto getProduto() {
		return produto;
	}

	public Compra setProduto(Produto produto) {
		this.produto = produto;
		return this;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Compra setCliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}
}

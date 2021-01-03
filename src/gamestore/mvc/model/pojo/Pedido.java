package gamestore.mvc.model.pojo;

import java.time.LocalDate;

public class Pedido {

	private int pedidoId;
	private LocalDate data;
	private String outrasInformacoes;
	private Produto produto;
	private Cliente cliente;

	public Pedido(int pedidoId, LocalDate data, String outrasInformacoes, Produto produto, Cliente cliente) {
		super();
		this.pedidoId = pedidoId;
		this.data = data;
		this.outrasInformacoes = outrasInformacoes;
		this.produto = produto;
		this.cliente = cliente;
	}

	public Pedido(LocalDate data, String outrasInformacoes, Produto produto, Cliente cliente) {
		super();
		this.data = data;
		this.outrasInformacoes = outrasInformacoes;
		this.produto = produto;
		this.cliente = cliente;
	}

	public Pedido() {

	}


	public int getPedidoId() {
		return pedidoId;
	}

	public Pedido setPedidoId(int pedidoId) {
		this.pedidoId = pedidoId;
		return this;
	}

	public LocalDate getData() {
		return data;
	}

	public Pedido setData(LocalDate data) {
		this.data = data;
		return this;
	}

	public String getOutrasInformacoes() {
		return outrasInformacoes;
	}

	public Pedido setOutrasInformacoes(String outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
		return this;
	}

	public Produto getProduto() {
		return produto;
	}

	public Pedido setProduto(Produto produto) {
		this.produto = produto;
		return this;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Pedido setCliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}

}

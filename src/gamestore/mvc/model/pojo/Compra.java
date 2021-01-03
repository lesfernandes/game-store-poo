package gamestore.mvc.model.pojo;

import java.util.Date;

public class Compra {
	
	private int compraId;
	private Date data;
	private String outrasInformacoes;
	private Produto produto;
	private Cliente cliente;
	
	public Compra(int compraId, Date data, String outrasInformacoes, Produto produto, Cliente cliente) {
		super();
		this.compraId = compraId;
		this.data = data;
		this.outrasInformacoes = outrasInformacoes;
		this.produto = produto;
		this.cliente = cliente;
	}
	

	public Compra(Date data, String outrasInformacoes, Produto produto, Cliente cliente) {
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


	public Date getData() {
		return data;
	}
	
	public Compra setData(Date data) {
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

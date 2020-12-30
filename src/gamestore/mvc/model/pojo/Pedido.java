package gamestore.mvc.model.pojo;

import java.util.List;

public class Pedido {
	
	private String data;
	private String outrasInformacoes;
	private List<Produto> produtos;
	private Cliente cliente;
	
	public String getData() {
		return data;
	}
	
	public Pedido setData(String data) {
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
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public Pedido setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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

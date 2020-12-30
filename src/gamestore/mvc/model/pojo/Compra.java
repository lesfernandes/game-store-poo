package gamestore.mvc.model.pojo;

import java.util.List;

public class Compra {
	
	private String data;
	private String outrasInformacoes;
	private List<Produto> produto;
	private Cliente cliente;
	
	public String getData() {
		return data;
	}
	
	public Compra setData(String data) {
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
	
	public List<Produto> getProduto() {
		return produto;
	}

	public Compra setProduto(List<Produto> produto) {
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

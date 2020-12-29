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
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getOutrasInformacoes() {
		return outrasInformacoes;
	}
	
	public void setOutrasInformacoes(String outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}

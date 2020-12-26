package gamestore.mvc.model;

public class Pedido {
	
	private String data;
	private String outrasInformacoes;
	private Produto produto;
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
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}

package gamestore.mvc.model.pojo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produto {

	private Integer produto_id;
	private StringProperty nome;
	private String descricao;
	private float preco;

	public Produto(int produtoId, String nome, String descricao, float preco) {
		super();
		this.produto_id = produtoId;
		this.nome = new SimpleStringProperty(nome);
		this.descricao = descricao;
		this.preco = preco;
	}

	public Produto(String nome, String descricao, float preco) {
		super();
		this.nome = new SimpleStringProperty(nome);
		this.descricao = descricao;
		this.preco = preco;
	}

	public Produto() {

	}

	public Integer getProdutoId() {
		return produto_id;
	}

	public Produto setProdutoId(Integer id) {
		this.produto_id = id;
		return this;
	}

	public String getNome() {
		return nome.get();
	}

	public Produto setNome(String nome) {
		this.nome.set(nome);
		return this;
	}

	public StringProperty nomeProperty() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Produto setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public float getPreco() {
		return preco;
	}

	public Produto setPreco(float preco) {
		this.preco = preco;
		return this;
	}


}

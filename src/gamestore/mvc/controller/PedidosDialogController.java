package gamestore.mvc.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import gamestore.mvc.model.dao.implementation.MysqlClienteDAO;
import gamestore.mvc.model.dao.implementation.MysqlPedidoDAO;
import gamestore.mvc.model.dao.implementation.MysqlProdutoDAO;
import gamestore.mvc.model.dao.interfaces.IClienteDAO;
import gamestore.mvc.model.dao.interfaces.IPedidoDAO;
import gamestore.mvc.model.dao.interfaces.IProdutoDAO;
import gamestore.mvc.model.pojo.Cliente;
import gamestore.mvc.model.pojo.Pedido;
import gamestore.mvc.model.pojo.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PedidosDialogController implements Initializable{
	@FXML
	DatePicker dataInput;

	@FXML
	TextField outrasInformacoesInput;

	@FXML
	ComboBox<Produto> produtoInput;

	@FXML
	ComboBox<Cliente> clienteInput;

	@FXML
	Button cancelarBtn;

	@FXML
	Button salvarBtn;

	private ObservableList<Produto> produtos;
	private ObservableList<Cliente> clientes;

	private Stage dialogStage;
	private Pedido pedido = null;
	private IPedidoDAO dao = new MysqlPedidoDAO();

	@FXML
	void handleCancelar(ActionEvent event) {
		dialogStage.close();
	}

	@FXML
	void handleSalvar(ActionEvent event) {
		LocalDate data = dataInput.getValue();
		String outrasInformacoes = outrasInformacoesInput.getText();
		Produto produto = produtoInput.getValue();
		Cliente cliente = clienteInput.getValue();

		if(this.pedido == null) {
			this.pedido = new Pedido(data, outrasInformacoes, produto, cliente);
			dao.save(this.pedido);
		} else {
			this.pedido.setData(data).setOutrasInformacoes(outrasInformacoes).setProduto(produto).setCliente(cliente);
			dao.update(this.pedido);
		}

		dialogStage.close();
	}

	public void setPedido(Pedido compra) {
		this.pedido = compra;

		dataInput.setValue(this.pedido.getData());
		outrasInformacoesInput.setText(this.pedido.getOutrasInformacoes());
		produtoInput.setValue(this.pedido.getProduto());
		clienteInput.setValue(this.pedido.getCliente());
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void loadProdutos() {
		IProdutoDAO dao = new MysqlProdutoDAO();
		produtos = FXCollections.observableArrayList(dao.getAll());

		produtoInput.setItems(produtos);
	}

	public void loadClientes() {
		IClienteDAO dao = new MysqlClienteDAO();
		clientes = FXCollections.observableArrayList(dao.getAll());

		clienteInput.setItems(clientes);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadProdutos();
		loadClientes();
	}

}

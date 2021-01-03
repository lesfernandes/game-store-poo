package gamestore.mvc.controller;

import java.net.URL;
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		salvarBtn.setOnAction((ActionEvent event)->{
			Pedido pedido = new Pedido(dataInput.getValue(),
										outrasInformacoesInput.getText(),
										produtoInput.getValue(),
										clienteInput.getValue());

			IPedidoDAO dao = new MysqlPedidoDAO();
			dao.save(pedido);
		});

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

}

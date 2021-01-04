package gamestore.mvc.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import gamestore.mvc.model.pojo.Produto;
import gamestore.mvc.model.dao.implementation.MysqlClienteDAO;
import gamestore.mvc.model.dao.implementation.MysqlCompraDAO;
import gamestore.mvc.model.dao.implementation.MysqlProdutoDAO;
import gamestore.mvc.model.dao.interfaces.IClienteDAO;
import gamestore.mvc.model.dao.interfaces.ICompraDAO;
import gamestore.mvc.model.dao.interfaces.IProdutoDAO;
import gamestore.mvc.model.pojo.Cliente;
import gamestore.mvc.model.pojo.Compra;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ComboBox;

public class ComprasDialogController implements Initializable{

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
	private Compra compra = null;
	private ICompraDAO dao = new MysqlCompraDAO();

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

		if(this.compra == null) {
			this.compra = new Compra(data, outrasInformacoes, produto, cliente);
			dao.save(this.compra);
		} else {
			this.compra.setData(data).setOutrasInformacoes(outrasInformacoes).setProduto(produto).setCliente(cliente);
			dao.update(this.compra);
		}

		dialogStage.close();
	}

	public void setCompra(Compra compra) {
		this.compra = compra;

		dataInput.setValue(this.compra.getData());
		outrasInformacoesInput.setText(this.compra.getOutrasInformacoes());
		produtoInput.setValue(this.compra.getProduto());
		clienteInput.setValue(this.compra.getCliente());
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

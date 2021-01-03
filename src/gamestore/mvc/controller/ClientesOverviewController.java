package gamestore.mvc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import gamestore.mvc.model.dao.implementation.MysqlClienteDAO;
import gamestore.mvc.model.dao.interfaces.IClienteDAO;
import gamestore.mvc.model.pojo.Cliente;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ClientesOverviewController implements Initializable{

	@FXML
	TableView<Cliente> clienteTable;

	@FXML
	TableColumn<Cliente, Number> codigoColumn;

	@FXML
	TableColumn<Cliente, String> nomeColumn;

	@FXML
	Label codigoLabel;

	@FXML
	Label nomeLabel;

	@FXML
	Label enderecoLabel;

	@FXML
	Label outrasInformacoesLabel;

	private ObservableList<Cliente> clienteData;
	private IClienteDAO dao = new MysqlClienteDAO();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		clienteData = FXCollections.observableArrayList(dao.getAll());

		codigoColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCodigo()));
		nomeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
	}

	private void showClienteDetails(Cliente cliente) {
	    if (cliente != null) {
	    	codigoLabel.setText(Integer.toString(cliente.getCodigo()));
	    	nomeLabel.setText(cliente.getNome());
	    	enderecoLabel.setText(cliente.getEndereco());
	    	outrasInformacoesLabel.setText(cliente.getOutrasInformacoes());

	    } else {
	    	codigoLabel.setText("");
	    	nomeLabel.setText("");
	    	enderecoLabel.setText("");
	    	outrasInformacoesLabel.setText("");
	    }
	}

	/**
	 * Chamado quando o usu�rio clica no bot�o delete.
	 */
	@FXML
	private void handleDeleteCliente() {
	    Cliente cliente = clienteTable.getSelectionModel().getSelectedItem();
	    dao.delete(cliente);
	}

}

package gamestore.mvc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import gamestore.mvc.model.dao.implementation.MysqlPedidoDAO;
import gamestore.mvc.model.dao.interfaces.IPedidoDAO;
import gamestore.mvc.model.pojo.Pedido;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;

public class PedidosOverviewController implements Initializable{
	@FXML
	TableView<Pedido> pedidoTable;

	@FXML
	TableColumn<Pedido, String> dataColumn;

	@FXML
	TableColumn<Pedido, String> produtoColumn;

	@FXML
	Label dataLabel;

	@FXML
	Label outrasInformacoesLabel;

	@FXML
	Label produtoLabel;

	@FXML
	Label clienteLabel;

	private ObservableList<Pedido> pedidoData;
	private IPedidoDAO dao = new MysqlPedidoDAO();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		pedidoData = FXCollections.observableArrayList(dao.getAll());

		pedidoTable.setRowFactory(tv -> {
			TableRow<Pedido> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				Pedido pedido = row.getItem();
				setCurrentPedido(pedido);
			});
			return row;
		});

		dataColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getData().toString()));
		produtoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProduto().getNome()));

		pedidoTable.setItems(pedidoData);
	}

	public void setCurrentPedido(Pedido pedido){
		dataLabel.setText(pedido.getData().toString());
		outrasInformacoesLabel.setText(pedido.getOutrasInformacoes());
		produtoLabel.setText(pedido.getProduto().getNome());
		clienteLabel.setText(pedido.getCliente().getNome());
	}

	/**
	 * Botão delete.
	 */
	@FXML
	private void handleDeletePedido() {
		Pedido pedido = pedidoTable.getSelectionModel().getSelectedItem();
		pedidoTable.getItems().remove(pedido);
	    dao.delete(pedido);
	}
}

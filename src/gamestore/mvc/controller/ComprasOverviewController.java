package gamestore.mvc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import gamestore.mvc.model.dao.implementation.MysqlCompraDAO;
import gamestore.mvc.model.dao.interfaces.ICompraDAO;
import gamestore.mvc.model.pojo.Compra;

public class ComprasOverviewController implements Initializable{

	@FXML
	TableView<Compra> compraTable;

	@FXML
	TableColumn<Compra, String> dataColumn;

	@FXML
	TableColumn<Compra, String> produtoColumn;

	@FXML
	Label dataLabel;

	@FXML
	Label outrasInformacoesLabel;

	@FXML
	Label produtoLabel;

	@FXML
	Label clienteLabel;

	private ObservableList<Compra> compraData;
	private ICompraDAO dao = new MysqlCompraDAO();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		compraData = FXCollections.observableArrayList(dao.getAll());

		compraTable.setRowFactory(tv -> {
			TableRow<Compra> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				Compra compra = row.getItem();
				setCurrentCompra(compra);
			});
			return row;
		});

		dataColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getData().toString()));
		produtoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProduto().getNome()));

		compraTable.setItems(compraData);
	}

	public void setCurrentCompra(Compra compra){
		dataLabel.setText(compra.getData().toString());
		outrasInformacoesLabel.setText(compra.getOutrasInformacoes());
		produtoLabel.setText(compra.getProduto().getNome());
		clienteLabel.setText(compra.getCliente().getNome());
	}

	/**
	 * Botão delete.
	 */
	@FXML
	private void handleDeleteCompra() {
	    Compra compra = compraTable.getSelectionModel().getSelectedItem();
	    compraTable.getItems().remove(compra);
	    dao.delete(compra);
	}

}

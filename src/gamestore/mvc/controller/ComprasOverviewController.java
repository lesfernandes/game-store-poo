package gamestore.mvc.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import gamestore.mvc.app.Main;
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

	private ObservableList<Compra> compraData = null;
	private ICompraDAO dao = new MysqlCompraDAO();
	private Compra currentCompra = null;

	@FXML
	void handleEditar(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/ComprasDialog.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Editar Compra");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Define o cliente no controller.
			ComprasDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setCompra(currentCompra);

			// Mostra a janela e espera at� o usu�rio fechar.
			dialogStage.showAndWait();

			getData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleExcluir(ActionEvent event) {
		if(currentCompra != null) {
			dao.delete(currentCompra);
			compraTable.getItems().remove(currentCompra);
			this.currentCompra = null;
		}
	}

	@FXML
	void handleNovo(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/ComprasDialog.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Nova Compra");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			// dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			ComprasDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			// Mostra a janela e espera até o usuário fechar.
			dialogStage.showAndWait();

			getData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getData() {
		dao.getAll();
		compraData = FXCollections.observableArrayList(dao.getAll());
		compraTable.setItems(compraData);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

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

		getData();
	}

	public void setCurrentCompra(Compra compra){
		this.currentCompra = compra;

		dataLabel.setText(compra.getData().toString());
		outrasInformacoesLabel.setText(compra.getOutrasInformacoes());
		produtoLabel.setText(compra.getProduto().getNome());
		clienteLabel.setText(compra.getCliente().getNome());
	}

}

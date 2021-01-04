package gamestore.mvc.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gamestore.mvc.app.Main;
import gamestore.mvc.model.dao.implementation.MysqlPedidoDAO;
import gamestore.mvc.model.dao.interfaces.IPedidoDAO;
import gamestore.mvc.model.pojo.Pedido;
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
	private Pedido currentPedido = null;

	@FXML
	void handleEditar(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/PedidosDialog.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Editar Pedido");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Define o cliente no controller.
			PedidosDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setPedido(currentPedido);

			// Mostra a janela e espera até o usuário fechar.
			dialogStage.showAndWait();

			getData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleExcluir(ActionEvent event) {
		if(currentPedido != null) {
			dao.delete(currentPedido);
			pedidoTable.getItems().remove(currentPedido);
			this.currentPedido = null;
		}
	}

	@FXML
	void handleNovo(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/PedidosDialog.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Novo Pedido");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			// dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			PedidosDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			// Mostra a janela e espera atÃ© o usuÃ¡rio fechar.
			dialogStage.showAndWait();

			getData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getData() {
		dao.getAll();
		pedidoData = FXCollections.observableArrayList(dao.getAll());
		pedidoTable.setItems(pedidoData);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

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

		getData();
	}

	public void setCurrentPedido(Pedido pedido){
		this.currentPedido = pedido;

		dataLabel.setText(pedido.getData().toString());
		outrasInformacoesLabel.setText(pedido.getOutrasInformacoes());
		produtoLabel.setText(pedido.getProduto().getNome());
		clienteLabel.setText(pedido.getCliente().getNome());
	}
}

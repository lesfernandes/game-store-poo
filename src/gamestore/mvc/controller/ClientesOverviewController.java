	package gamestore.mvc.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gamestore.mvc.app.Main;
import gamestore.mvc.model.dao.implementation.MysqlClienteDAO;
import gamestore.mvc.model.dao.interfaces.IClienteDAO;
import gamestore.mvc.model.pojo.Cliente;
import javafx.beans.property.SimpleIntegerProperty;
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

	private ObservableList<Cliente> clienteData = null;
	private IClienteDAO dao = new MysqlClienteDAO();
	private Cliente currentCliente = null;

	@FXML
	void handleEditar(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/ClientesDialog.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Editar Cliente");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Define o cliente no controller.
			ClientesDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setCliente(currentCliente);

			// Mostra a janela e espera até o usuário fechar.
			dialogStage.showAndWait();

			getData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleExcluir(ActionEvent event) {
		if(currentCliente != null) {
			dao.delete(currentCliente);
			clienteTable.getItems().remove(currentCliente);
			this.currentCliente = null;
		}
	}

	@FXML
	void handleNovo(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/ClientesDialog.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Novo Cliente");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			// dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			ClientesDialogController controller = loader.getController();
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
		clienteData = FXCollections.observableArrayList(dao.getAll());
		clienteTable.setItems(clienteData);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		clienteTable.setRowFactory( tv -> {
		    TableRow<Cliente> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		    	Cliente cliente = row.getItem();
		    	setCurrentCliente(cliente);
		    });
		    return row ;
		});

		codigoColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCodigo()));
		nomeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));

		getData();
	}

	private void setCurrentCliente(Cliente cliente) {
		this.currentCliente = cliente;

    	codigoLabel.setText(Integer.toString(cliente.getCodigo()));
    	nomeLabel.setText(cliente.getNome());
    	enderecoLabel.setText(cliente.getEndereco());
    	outrasInformacoesLabel.setText(cliente.getOutrasInformacoes());
	}

}

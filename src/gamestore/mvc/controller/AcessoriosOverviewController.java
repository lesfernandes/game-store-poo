package gamestore.mvc.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gamestore.mvc.app.Main;
import gamestore.mvc.model.dao.implementation.MysqlAcessorioDAO;
import gamestore.mvc.model.dao.interfaces.IAcessorioDAO;
import gamestore.mvc.model.pojo.Acessorio;
import javafx.beans.property.SimpleFloatProperty;
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

public class AcessoriosOverviewController implements Initializable{

	@FXML
	TableView<Acessorio> acessorioTable;

	@FXML
	TableColumn<Acessorio, String> nomeColumn;

	@FXML
	TableColumn<Acessorio, Number> precoColumn;

	@FXML
	Label nomeLabel;

	@FXML
	Label descricaoLabel;

	@FXML
	Label precoLabel;

	@FXML
	Label outrasInformacoesLabel;

	private ObservableList<Acessorio> acessorioData = null;
	private IAcessorioDAO dao = new MysqlAcessorioDAO();
	private Acessorio currentAcessorio = null;

	@FXML
	void handleEditar(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/AcessoriosDialog.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Person");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Define o acessorio no controller.
			AcessoriosDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setAcessorio(currentAcessorio);

			// Mostra a janela e espera até o usuário fechar.
			dialogStage.showAndWait();

			getData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleExcluir(ActionEvent event) {
		if(currentAcessorio != null) {
			dao.delete(currentAcessorio);
			acessorioTable.getItems().remove(currentAcessorio);
			this.currentAcessorio = null;
		}
	}

	@FXML
	void handleNovo(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/AcessoriosDialog.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Person");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			// dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Mostra a janela e espera até o usuário fechar.
			dialogStage.showAndWait();

			getData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getData() {
		dao.getAll();
		acessorioData = FXCollections.observableArrayList(dao.getAll());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		getData();

		// Row factory (add the handle click event)
		acessorioTable.setRowFactory( tableView -> {
			TableRow<Acessorio> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				Acessorio acessorio = row.getItem();
				setCurrentAcessorio(acessorio);
			});
			return row ;
		});

		// Columns Factory
		nomeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nomeProperty()));
		precoColumn.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getPreco()));


		acessorioTable.setItems(acessorioData);
	}

	private void setCurrentAcessorio(Acessorio acessorio) {
		this.currentAcessorio =  acessorio;

		nomeLabel.setText(acessorio.getNome());
		descricaoLabel.setText(acessorio.getDescricao());
		precoLabel.setText(String.valueOf(acessorio.getPreco()));
		outrasInformacoesLabel.setText(acessorio.getOutrasInformacoes());
	}

}

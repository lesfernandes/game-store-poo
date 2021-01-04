package gamestore.mvc.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gamestore.mvc.app.Main;
import gamestore.mvc.model.dao.implementation.MysqlJogoDAO;
import gamestore.mvc.model.dao.interfaces.IJogoDAO;
import gamestore.mvc.model.pojo.Jogo;
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

public class JogosOverviewController implements Initializable{
	@FXML
	TableView<Jogo> tableView;
	
	@FXML
	TableColumn<Jogo, String> nomeColumn;

	@FXML
	TableColumn<Jogo, Number> precoColumn;

	@FXML
	private Label nomeLabel;

	@FXML
	private Label memoriaNecessariaLabel;

	@FXML
	private Label numeroJogadoresLabel;

	@FXML
	private Label outrasInformacoesLabel;

	@FXML
	private Label descricaoLabel;

	@FXML
	private Label precoLabel;


	private ObservableList<Jogo> tableData = null;
	private IJogoDAO dao = new MysqlJogoDAO();
	private Jogo currentItem = null;

	private void getData() {
		dao.getAll();
		tableData = FXCollections.observableArrayList(dao.getAll());
		tableView.setItems(tableData);
	}

	private void setCurrentItem(Jogo jogo) {
		this.currentItem =  jogo;

		nomeLabel.setText(jogo.getNome());
		memoriaNecessariaLabel.setText(jogo.getDescricao());
		numeroJogadoresLabel.setText(String.valueOf(jogo.getNumeroDeJogadores()));
		outrasInformacoesLabel.setText(jogo.getOutrasInformacoes());
		descricaoLabel.setText(jogo.getDescricao());
		precoLabel.setText(String.valueOf(jogo.getPreco()));
	}

	private void openDialog(String title, Jogo jogo) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/JogosDialog.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle(title);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Define o acessorio no controller.
			JogosDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setJogo(jogo);

			// Mostra a janela e espera até o usuário fechar.
			dialogStage.showAndWait();

			getData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleEditar(ActionEvent event) {
		if(this.currentItem != null) {
			openDialog("Editar Jogo", currentItem);
			getData();
		}
	}

	@FXML
	void handleExcluir(ActionEvent event) {
		if(currentItem != null) {
			dao.delete(currentItem);
			tableView.getItems().remove(currentItem);
			this.currentItem = null;
		}
	}

	@FXML
	void handleNovo(ActionEvent event) {
		openDialog("Novo Jogo", null);
		getData();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Row factory (add the handle click event)
		tableView.setRowFactory( tableView -> {
			TableRow<Jogo> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				Jogo jogo = row.getItem();
				if(jogo != null) {
					setCurrentItem(jogo);					
				}
			});
			return row ;
		});

		// Columns Factory
		nomeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		precoColumn.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getPreco()));

		getData();

	}

}

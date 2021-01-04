package gamestore.mvc.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gamestore.mvc.app.Main;
import gamestore.mvc.model.dao.implementation.MysqlConsoleDAO;
import gamestore.mvc.model.dao.interfaces.IConsoleDAO;
import gamestore.mvc.model.pojo.Console;
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

public class ConsolesOverviewController implements Initializable {

	@FXML
	TableView<Console> tableView;
	
    @FXML
    private TableColumn<Console, String> nomeColumn;

    @FXML
    private TableColumn<Console, Number> precoColumn;

    @FXML
    private Label nomeLabel;

    @FXML
    private Label descricaoLabel;

    @FXML
    private Label precoLabel;

    @FXML
    private Label tipoDriveLabel;

    @FXML
    private Label outrasInformacoesLabel;

    private ObservableList<Console> tableData = null;
	private IConsoleDAO dao = new MysqlConsoleDAO();
	private Console currentItem = null;

	private void getData() {
		dao.getAll();
		tableData = FXCollections.observableArrayList(dao.getAll());
		tableView.setItems(tableData);
	}

	private void setCurrentItem(Console console) {
		this.currentItem =  console;

		nomeLabel.setText(console.getNome());
		outrasInformacoesLabel.setText(console.getOutrasInformacoes());
		descricaoLabel.setText(console.getDescricao());
		precoLabel.setText(String.valueOf(console.getPreco()));
		tipoDriveLabel.setText(console.getTipoDrive());
	}

	private void openDialog(String title, Console console) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/ConsolesDialog.fxml"));
			AnchorPane page;
			page = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle(title);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Define o acessorio no controller.
			ConsolesDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setConsole(console);

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
			openDialog("Editar Console", currentItem);
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
		openDialog("Novo Console", null);
		getData();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Row factory (add the handle click event)
		tableView.setRowFactory( tableView -> {
			TableRow<Console> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				Console console = row.getItem();
				if(console != null) {
					setCurrentItem(console);					
				}
			});
			return row;
		});

		// Columns Factory
		nomeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		precoColumn.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getPreco()));

		getData();

	}

}

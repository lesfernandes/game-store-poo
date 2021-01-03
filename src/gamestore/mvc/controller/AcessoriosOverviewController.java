package gamestore.mvc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import gamestore.mvc.app.Main;
import gamestore.mvc.model.pojo.Acessorio;

public class AcessoriosOverviewController implements Initializable{

	@FXML
	TableView<Acessorio> acessorioTable;

	@FXML
	TableColumn<Acessorio, String> nomeColumn;

	@FXML
	TableColumn<Acessorio, String> precoColumn;

	@FXML
	Label nomeLabel;

	@FXML
	Label descricaoLabel;

	@FXML
	Label precoLabel;

	@FXML
	Label outrasInformacoesLabel;

	Main main;

	public AcessoriosOverviewController() {
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nomeColumn.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		precoColumn.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
	}

	public void setMain(Main main) {
        this.main = main;

        acessorioTable.setItems(main.getAcessorioData());
    }
	
	/*private void showPersonDetails(Acessorio acessorio) {
	    if (acessorio != null) {
	    	nomeLabel.setText(acessorio.getNome());
	    	descricaoLabel.setText(acessorio.getDescricao());
	    	precoLabel.setText(acessorio.getPreco());
	    	outrasInformacoesLabel.setText(acessorio.toString(person.getPostalCode()));

	    } else {
	        firstNameLabel.setText("");
	        lastNameLabel.setText("");
	        streetLabel.setText("");
	        postalCodeLabel.setText("");
	        cityLabel.setText("");
	        birthdayLabel.setText("");
	    }
	}*/
	
}

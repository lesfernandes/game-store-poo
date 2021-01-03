package gamestore.mvc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import gamestore.mvc.app.Main;
import gamestore.mvc.model.dao.implementation.MysqlAcessorioDAO;
import gamestore.mvc.model.dao.interfaces.IAcessorioDAO;
import gamestore.mvc.model.pojo.Acessorio;

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

	Main main;

	private ObservableList<Acessorio> acessorioData = null;
	private IAcessorioDAO dao = new MysqlAcessorioDAO();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dao.getAll();
		acessorioData = FXCollections.observableArrayList(dao.getAll());
		
		nomeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nomeProperty()));
		precoColumn.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getPreco()));
		acessorioTable.setItems(acessorioData);
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

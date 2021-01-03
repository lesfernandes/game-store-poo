package gamestore.mvc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import gamestore.mvc.model.dao.implementation.MysqlConsoleDAO;
import gamestore.mvc.model.dao.interfaces.IConsoleDAO;
import gamestore.mvc.model.pojo.Console;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConsolesDialogController implements Initializable {

	@FXML
	TextField nomeInput;

	@FXML
	TextField descricaoInput;

	@FXML
	TextField precoInput;

	@FXML
	TextField tipoDriveInput;

	@FXML
	TextField outrasInformacoesInput;

	@FXML
	Button cancelarBtn;

	@FXML
	Button salvarBtn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		salvarBtn.setOnAction((ActionEvent event)->{
			Console console = new Console(nomeInput.getText(),
										descricaoInput.getText(),
										Float.parseFloat(precoInput.getText()),
										tipoDriveInput.getText(),
										outrasInformacoesInput.getText());

			IConsoleDAO dao = new MysqlConsoleDAO();
			dao.save(console);
		}
	);

	}

}

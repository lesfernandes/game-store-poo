package gamestore.mvc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import gamestore.mvc.model.dao.implementation.MysqlAcessorioDAO;
import gamestore.mvc.model.dao.interfaces.IAcessorioDAO;
import gamestore.mvc.model.pojo.Acessorio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AcessoriosDialogController implements Initializable{

	@FXML
	TextField nomeInput;

	@FXML
	TextField descricaoInput;

	@FXML
	TextField precoInput;

	@FXML
	TextField outrasInformacoesInput;

	@FXML
	Button cancelarBtn;

	@FXML
	Button salvarBtn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		salvarBtn.setOnAction((ActionEvent event)->{
				Acessorio acessorio = new Acessorio(nomeInput.getText(),
													descricaoInput.getText(),
													Float.parseFloat(precoInput.getText()),
													outrasInformacoesInput.getText());
				
				IAcessorioDAO dao = new MysqlAcessorioDAO();
				
				dao.save(acessorio);
			}
		);

	}

}

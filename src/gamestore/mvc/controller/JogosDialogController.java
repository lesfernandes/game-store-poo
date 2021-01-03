package gamestore.mvc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import gamestore.mvc.model.dao.implementation.MysqlJogoDAO;
import gamestore.mvc.model.dao.interfaces.IJogoDAO;
import gamestore.mvc.model.pojo.Jogo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class JogosDialogController implements Initializable {

	@FXML
	TextField nomeInput;

	@FXML
	TextField descricaoInput;

	@FXML
	TextField precoInput;

	@FXML
	TextField memoriaNecessariaInput;

	@FXML
	TextField numeroJogadoresInpunt;

	@FXML
	TextField outrasInformacoesInput;

	@FXML
	Button cancelarBtn;

	@FXML
	Button salvarBtn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		salvarBtn.setOnAction((ActionEvent event)->{
			Jogo jogo = new Jogo(nomeInput.getText(),
								descricaoInput.getText(),
								Float.parseFloat(precoInput.getText()),
								Integer.parseInt(memoriaNecessariaInput.getText()),
								Integer.parseInt(numeroJogadoresInpunt.getText()),
								outrasInformacoesInput.getText());

			IJogoDAO dao = new MysqlJogoDAO();
			dao.save(jogo);
		}
	);

	}

}

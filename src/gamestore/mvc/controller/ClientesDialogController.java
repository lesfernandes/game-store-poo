package gamestore.mvc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import gamestore.mvc.model.dao.implementation.MysqlClienteDAO;
import gamestore.mvc.model.dao.interfaces.IClienteDAO;
import gamestore.mvc.model.pojo.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ClientesDialogController implements Initializable{

	@FXML
	TextField codigoInput;

	@FXML
	TextField nomeInput;

	@FXML
	TextField enderecoInput;

	@FXML
	TextField outrasInformacoesInput;

	@FXML
	Button cancelarBtn;

	@FXML
	Button salvarBtn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		salvarBtn.setOnAction((ActionEvent event)->{
				Cliente cliente = new Cliente(Integer.parseInt(codigoInput.getText()),
											nomeInput.getText(),
											enderecoInput.getText(),
											outrasInformacoesInput.getText());

				IClienteDAO dao = new MysqlClienteDAO();

				dao.save(cliente);
			});

	}

}

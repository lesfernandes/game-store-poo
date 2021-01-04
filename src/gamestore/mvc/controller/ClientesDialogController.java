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
import javafx.stage.Stage;

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

	private Stage dialogStage;
	private Cliente cliente = null;
	private IClienteDAO dao = new MysqlClienteDAO();

	@FXML
	void handleCancelar(ActionEvent event) {
		dialogStage.close();
	}

	@FXML
	void handleSalvar(ActionEvent event) {
		int codigo = Integer.parseInt(codigoInput.getText());
		String nome = nomeInput.getText();
		String endereco = enderecoInput.getText();
		String outrasInformacoes = outrasInformacoesInput.getText();

		if(this.cliente == null) {
			this.cliente = new Cliente(codigo, nome, endereco, outrasInformacoes);
			dao.save(this.cliente);
		} else {
			this.cliente.setCodigo(codigo).setNome(nome).setEndereco(endereco).setOutrasInformacoes(outrasInformacoes);
			dao.update(this.cliente);
		}

		dialogStage.close();
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;

		codigoInput.setText(Integer.toString(this.cliente.getCodigo()));
		nomeInput.setText(this.cliente.getNome());
		enderecoInput.setText(this.cliente.getEndereco());
		outrasInformacoesInput.setText(this.cliente.getOutrasInformacoes());
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

}

package gamestore.mvc.controller;

import gamestore.mvc.model.dao.implementation.MysqlConsoleDAO;
import gamestore.mvc.model.dao.interfaces.IConsoleDAO;
import gamestore.mvc.model.pojo.Console;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConsolesDialogController {

    @FXML
    private Button salvarBtn;

    @FXML
    private TextField nomeInput;

    @FXML
    private TextField descricaoInput;

    @FXML
    private TextField precoInput;

    @FXML
    private TextField tipoDriveInput;

    @FXML
    private TextField outrasInformacoesInput;

    private Stage dialogStage;
  	private Console currentItem = null;
  	private IConsoleDAO dao = new MysqlConsoleDAO();

      @FXML
      void handleCancelar(ActionEvent event) {
      	dialogStage.close();
      }

      @FXML
      void handleSalvar(ActionEvent event) {
      	String nome = nomeInput.getText();
  		String descricao = descricaoInput.getText();
  		Float preco = Float.parseFloat(precoInput.getText());
  		String tipoDrive = tipoDriveInput.getText();
  		String outrasInformacoes = outrasInformacoesInput.getText();

  		if (this.currentItem == null) {
  			this.currentItem = new Console(nome, descricao, preco, tipoDrive, outrasInformacoes);
  			dao.save(this.currentItem);
  		} else {
  			this.currentItem
  			.setTipoDrive(tipoDrive)
  			.setOutrasInformacoes(outrasInformacoes)
  			.setDescricao(descricao)
  			.setPreco(preco)
  			.setNome(nome);
  			
  			dao.update(this.currentItem);
  		}

  		dialogStage.close();
      }

      public void setConsole(Console console) {
      	if(console != null) {
      		this.currentItem = console;
      		
      		nomeInput.setText(this.currentItem.getNome());
      		descricaoInput.setText(this.currentItem.getDescricao());
      		precoInput.setText(String.valueOf(this.currentItem.getPreco()));
      		tipoDriveInput.setText(this.currentItem.getTipoDrive());
      		outrasInformacoesInput.setText(this.currentItem.getOutrasInformacoes());
      	}
  	}

  	public void setDialogStage(Stage dialogStage) {
  		this.dialogStage = dialogStage;
  	}


}

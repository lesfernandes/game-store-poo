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
import javafx.stage.Stage;

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
	    
    private Stage dialogStage;
    private Acessorio acessorio = null;
    private IAcessorioDAO dao = new MysqlAcessorioDAO();
    
    @FXML
    void handleCancelar(ActionEvent event) {
    	dialogStage.close();
    	System.out.println("batata frita com repolho");
    }

    @FXML
    void handleSalvar(ActionEvent event) {
    	
    	String nome = nomeInput.getText();
    	String descricao = descricaoInput.getText();
    	Float preco = Float.parseFloat(precoInput.getText());
    	String outrasInformacoes = outrasInformacoesInput.getText();
    	
    	if(this.acessorio == null) {
    		this.acessorio = new Acessorio(nome, descricao, preco, outrasInformacoes);
    		dao.save(this.acessorio);
    	} else {
    		this.acessorio.setOutrasInformacoes(outrasInformacoes)
    						.setDescricao(descricao)
    						.setPreco(preco)
    						.setNome(nome);
    		System.out.println(this.acessorio.toString());
    		dao.update(this.acessorio);
    	}
    	
    	dialogStage.close();
    }
    
    public void setAcessorio(Acessorio acessorio) {
    	this.acessorio = acessorio;
    	
    	nomeInput.setText(this.acessorio.getNome());
    	descricaoInput.setText(this.acessorio.getDescricao());
    	precoInput.setText(String.valueOf(this.acessorio.getPreco()));
    	outrasInformacoesInput.setText(this.acessorio.getOutrasInformacoes());
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	 
}

package gamestore.mvc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import gamestore.mvc.model.dao.implementation.MysqlJogoDAO;
import gamestore.mvc.model.dao.interfaces.IJogoDAO;
import gamestore.mvc.model.pojo.Jogo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class JogosDialogController implements Initializable{

    @FXML
    private TextField nomeInput;

    @FXML
    private TextField descricaoInput;

    @FXML
    private TextField precoInput;

    @FXML
    private TextField memoriaNecessariaInput;

    @FXML
    private TextField numeroJogadoresInput;

    @FXML
    private TextField outrasInformacoesInput;
    
    private Stage dialogStage;
	private Jogo currentItem = null;
	private IJogoDAO dao = new MysqlJogoDAO();

    @FXML
    void handleCancelar(ActionEvent event) {
    	dialogStage.close();
    }

    @FXML
    void handleSalvar(ActionEvent event) {
    	String nome = nomeInput.getText();
		String descricao = descricaoInput.getText();
		Float preco = Float.parseFloat(precoInput.getText());
		String outrasInformacoes = outrasInformacoesInput.getText();
		int memoriaNecessaria = Integer.valueOf(memoriaNecessariaInput.getText());
		int numeroJogadores = Integer.valueOf(numeroJogadoresInput.getText());

		if (this.currentItem == null) {
			this.currentItem = new Jogo(nome, descricao, numeroJogadores, memoriaNecessaria, numeroJogadores, outrasInformacoes);
			dao.save(this.currentItem);
		} else {
			this.currentItem
			.setOutrasInformacoes(outrasInformacoes)
			.setMemoriaNecessaria(memoriaNecessaria)
			.setNumeroDeJogadores(numeroJogadores)
			.setDescricao(descricao)
			.setPreco(preco)
			.setNome(nome);
			
			dao.update(this.currentItem);
		}

		dialogStage.close();
    }

    public void setJogo(Jogo jogo) {
    	if(jogo != null) {
    		this.currentItem = jogo;
    		
    		nomeInput.setText(this.currentItem.getNome());
    		descricaoInput.setText(this.currentItem.getDescricao());
    		precoInput.setText(String.valueOf(this.currentItem.getPreco()));
    		outrasInformacoesInput.setText(this.currentItem.getOutrasInformacoes());
    		memoriaNecessariaInput.setText(String.valueOf(this.currentItem.getMemoriaNecessaria()));
    		numeroJogadoresInput.setText(String.valueOf(this.currentItem.getNumeroDeJogadores()));
    	}
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

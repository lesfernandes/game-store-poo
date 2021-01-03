package gamestore.mvc.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gamestore.mvc.app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MenuController implements Initializable{
	
	@FXML
	private BorderPane rootBorderPane;

	@FXML
	private MenuButton menuButton;

    @FXML
    void handleAcessoriosMenu(ActionEvent event) {
    	menuButton.setText("Acessórios");
    	changeView("../view/AcessoriosOverview.fxml");
    }

    @FXML
    void handleClientesMenu(ActionEvent event) {
    	menuButton.setText("Clientes");
    	changeView("../view/ClientesOverview.fxml");
    }

    @FXML
    void handleComprasMenu(ActionEvent event) {
    	menuButton.setText("Compras");
    	changeView("../view/ComprasOverview.fxml");
    }

    @FXML
    void handleConsolesMenu(ActionEvent event) {
    	menuButton.setText("Consoles");
    	changeView("../view/ConsolesOverview.fxml");
    }

    @FXML
    void handleJogosMenu(ActionEvent event) {
    	menuButton.setText("Jogos");
    	changeView("../view/JogosOverview.fxml");
    }

    @FXML
    void handlePedidosMenu(ActionEvent event) {
    	menuButton.setText("Pedidos");
    	changeView("../view/PedidosOverview.fxml");
    }

    @FXML
    void handleProdutosMenu(ActionEvent event) {
    	menuButton.setText("Produtos");
    	changeView("../view/MenuOverview.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
    
	
	private void changeView(String viewPath) {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(viewPath));
            AnchorPane acessorioOverview = (AnchorPane) loader.load();

            rootBorderPane.setCenter(acessorioOverview);

        } catch (IOException e) {
            e.printStackTrace();
        }
	}	
}

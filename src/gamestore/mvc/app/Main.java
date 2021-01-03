package gamestore.mvc.app;

import java.io.IOException;

import gamestore.mvc.model.dao.implementation.MysqlAcessorioDAO;
import gamestore.mvc.model.dao.interfaces.IAcessorioDAO;
import gamestore.mvc.model.pojo.Acessorio;
import gamestore.mvc.controller.AcessoriosOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{

	private Stage primaryStage;
	private BorderPane rootLayout;

	private ObservableList<Acessorio> acessorioData = FXCollections.observableArrayList();
	private IAcessorioDAO dao = new MysqlAcessorioDAO();

	public Main(){
		acessorioData = dao.getAll();
	}

	public ObservableList<Acessorio> getAcessorioData() {
		return acessorioData;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Gamestore");

		initRootLayout();

		showAcessoriosOverview();

	}

	/**
	 * Inicializa o layout base.
	 */
	public void initRootLayout() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	/**
     * Mostra o inicial overview dentro do root layout.
     */

	public void showAcessoriosOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/AcessoriosOverview.fxml"));
            AnchorPane acessorioOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(acessorioOverview);

            AcessoriosOverviewController controller = loader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	/**
	 * Retorna o palco principal.
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {

		launch(args);

	}



}

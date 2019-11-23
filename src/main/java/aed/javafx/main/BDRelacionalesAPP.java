package aed.javafx.main;

import aed.javafx.bdrelacionales.BaseDatosRelacionalesController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BDRelacionalesAPP extends Application {
	
	private BaseDatosRelacionalesController bdRelacional;
//	private EstanciasProcedimientosController estancias;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		bdRelacional= new BaseDatosRelacionalesController();
//		estancias= new EstanciasProcedimientosController();
		Scene scene = new Scene(bdRelacional.getView());
//		Scene scene = new Scene(estancias.getView());
		primaryStage.setTitle("Base de datos relacionales");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}

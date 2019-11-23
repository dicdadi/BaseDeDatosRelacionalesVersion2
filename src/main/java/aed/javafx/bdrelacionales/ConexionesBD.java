package aed.javafx.bdrelacionales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ConexionesBD {
	private Connection conexion=null;

	public Connection conexionMYSQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdresidenciasescolaresrosmen", "root", "");

		} catch (ClassNotFoundException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de conexión");
			alert.setHeaderText("Se ha producido un error a la conexion de la BD");
			alert.show();
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de conexión");
			alert.setHeaderText("Se ha producido un error a la conexion de la BD");
			alert.show();
		}
		return conexion;
	}

	public Connection conexionSQL() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conexion = DriverManager.getConnection(
					"jdbc:sqlserver://LAPTOP-OFULADPK\\SQLEXPRESS;DataBaseName=bdresidenciasescolaresrosmen", "sa",
					"sa");

		} catch (ClassNotFoundException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de conexión");
			alert.setHeaderText("Se ha producido un error a la conexion de la BD");
			alert.show();
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de conexión");
			alert.setHeaderText("Se ha producido un error a la conexion de la BD");
			alert.show();
		}
		return conexion;
	}

	public Connection conexionACCESS() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			conexion = DriverManager.getConnection("jdbc:ucanaccess://BDRelacionales.accdb");

		} catch (ClassNotFoundException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de conexión");
			alert.setHeaderText("Se ha producido un error a la conexion de la BD");
			alert.show();
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de conexión");
			alert.setHeaderText("Se ha producido un error a la conexion de la BD");
			alert.show();
		}

		return conexion;
	}

}

package aed.javafx.bdrelacionales;

import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class BaseDatosRelacionalesController implements Initializable {
	private BaseDatosRelacionalesModel bdModel = new BaseDatosRelacionalesModel();
//		private ObservableList<Estancias> Estancias = FXCollections.observableArrayList();
	private ObservableList<Residencias> Residencias = FXCollections.observableArrayList();
	private EstanciasProcedimientosController Estancias;
	private Connection conexion;
	@FXML
	private BorderPane View;

	@FXML
	private GridPane GridPaneBD;

	@FXML
	private VBox VboxBD;

	@FXML
	private HBox HboxSelecion;

	@FXML
	private Label SelecionLabel;

	@FXML
	private ComboBox<String> ComboBD;

	@FXML
	private HBox HboxBDConectada;

	@FXML
	private Label ConectadoLabel;

	@FXML
	private Label MensajeBDLabel;

	@FXML
	private HBox HboxEstadoDB;

	@FXML
	private Label LabelEstado;

	@FXML
	private ImageView ImagenEstado;

	@FXML
	private VBox VboxConexion;

	@FXML
	private Button ConectarseBoton;

	@FXML
	private Button DesconectarseBoton;

	@FXML
	private HBox HboxTabla;

	@FXML
	private VBox VboxBotonesTabla;

	@FXML
	private HBox HboxInsertarVisualizar;

	@FXML
	private Button Visualizar;

	@FXML
	private Button Insertar;

	@FXML
	private HBox HboxEliminarModificar;

	@FXML
	private Button Modificar;

	@FXML
	private Button Eliminar;

	@FXML
	private HBox HboxProcedimientos;

	@FXML
	private Button ProcedimientoDNI;

	@FXML
	private Button ProcedimientoUNI;

	@FXML
	private HBox HboxProcedimientoMeses;

	@FXML
	private Button ProcedimientoMeses;

	@FXML
	private Button ProcedimientoInsertar;

	@FXML
	private TableView<Residencias> TablaVistaResidencias;

	@FXML
	private TableColumn<Residencias, Integer> ColumnaId;

	@FXML
	private TableColumn<Residencias, String> ColumnaNombreResidencia;

	@FXML
	private TableColumn<Residencias, String> ColumnaNombreUniversidad;

	@FXML
	private TableColumn<Residencias, String> ColumnaCodigoUniversidad;

	@FXML
	private TableColumn<Residencias, Integer> ColumnaPrecioMensual;

	@FXML
	private TableColumn<Residencias, Boolean> ColumnaComedor;

	// -------------------------------Insertar Residencia View
	// -------------------------------------------------//
	@FXML
	private BorderPane InsertarResidenciaView;

	@FXML
	private TextField NombreResidenciaText;

	@FXML
	private ComboBox<String> ComboUniversidad;

	@FXML
	private CheckBox ComedorCheckBox;

	@FXML
	private TextField PrecioMensualText;

	@FXML
	private Button InsertarResidencia;

//----------------------------------------------------------------Modificar Residencia view----------------------------------------------------------------\\	 
	@FXML
	private BorderPane ModificarResidenciaView;

	@FXML
	private TextField NombreResidenciaTextModificar;

	@FXML
	private ComboBox<String> ComboUniversidadModificar;

	@FXML
	private CheckBox ComedorCheckBoxModificar;

	@FXML
	private TextField PrecioMensualTextModificar;

	@FXML
	private Button ModificarResidencia;

	@FXML
	private Label IdResidenciaModificar;
	// ----------------------------------------------------Procedimiento
	// Universidad----------------------------------------
	@FXML
	private GridPane ProcedimientoUniversidadView;

	@FXML
	private TextField PrecioProcedimiento;

	@FXML
	private Button AceptarProcedimientoUni;

	@FXML
	private ComboBox<String> ComboUniversidadProcedimiento;

	// -----------------------Procedimiento Insertar----------------------------------------\\
	@FXML
	private BorderPane InsertarResidenciaProcedimientoView;

	@FXML
	private TextField NombreResidenciaProcedimientoText;

	@FXML
	private ComboBox<String> ComboUniversidadProcedimientoInsertar;

	@FXML
	private CheckBox ComedorCheckBoxProcedimiento;

	@FXML
	private TextField PrecioMensualTextProcedimiento;

	@FXML
	private Button InsertarResidenciaProcedimiento;

//----------------------------------------------------------Conexión y desconexión a la base de datos----------------------------------------------------------\\
	@FXML
	void onConectarseAction(ActionEvent event) {
//		Image imagen = new Image("/images/conexionON.png");
//		ImagenEstado.setImage(imagen);
		TablaVistaResidencias.getItems().clear();
		ConexionesBD conexiones = new ConexionesBD();
		switch (ComboBD.getSelectionModel().getSelectedIndex()) {
		case 0:
				conexion = conexiones.conexionMYSQL();
				if(!conexion.equals(null)) {
				Image imagen = new Image("/images/conexionON.png");
				ImagenEstado.setImage(imagen);
				MensajeBDLabel.setText("Mysql");
				botonesOn(true);
				procedimientosOn(true);
				ConectarseBoton.disableProperty().setValue(true);
				DesconectarseBoton.disableProperty().setValue(false);
				}
			
			break;
		case 1:
			
				conexion = conexiones.conexionSQL();
				if(!conexion.equals(null)) {
				Image imagen = new Image("/images/conexionON.png");
				ImagenEstado.setImage(imagen);
				MensajeBDLabel.setText("Sql");
				botonesOn(true);
				procedimientosOn(true);
				ConectarseBoton.disableProperty().setValue(true);
				DesconectarseBoton.disableProperty().setValue(false);
				}
			
			break;

		case 2:
			
				conexion = conexiones.conexionACCESS();
				if(!conexion.equals(null)) {
				Image imagen = new Image("/images/conexionON.png");
				ImagenEstado.setImage(imagen);
				MensajeBDLabel.setText("Access");
				botonesOn(true);
				ConectarseBoton.disableProperty().setValue(true);
				DesconectarseBoton.disableProperty().setValue(false);
				
				}
			

			break;
		default:
			break;
		}
	}

	@FXML
	void onDesconectarseAction(ActionEvent event) {
		try {
			conexion.close();
			Image imagen = new Image("/images/conexionOFF.png");
			ImagenEstado.setImage(imagen);
			MensajeBDLabel.setText("<No hay base de datos conectada actualmente>");
			TablaVistaResidencias.getItems().clear();
			botonesOn(false);
			procedimientosOn(false);
			ConectarseBoton.disableProperty().setValue(false);
			DesconectarseBoton.disableProperty().setValue(true);
			
		} catch (SQLException e) {

				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error de desconexión");
				alert.setHeaderText("Se ha producido un error en la desconexion de la BD");
				alert.show();
		}
	}

//----------------------------------------------------------Visualizar Tabla----------------------------------------------------------\\
	@FXML
	void onVisualizarAction(ActionEvent event) {
		try {
			TablaVistaResidencias.getItems().clear();
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT codResidencia, nomResidencia, nomUniversidad,residencias.codUniversidad, precioMensual,comedor FROM residencias INNER JOIN universidades ON  universidades.codUniversidad = residencias.codUniversidad order by codResidencia ");
			while (rs.next()) {

				Residencias.add(new Residencias(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getBoolean(6)));
			}

		} catch (SQLException e) {
			
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error de visualizacion");
				alert.setHeaderText("Se ha producido un error en la visualización");
				alert.show();
		}
	}

//----------------------------------------------------------Insertar Datos----------------------------------------------------------\\   
	// Boton de la vista principal
	@FXML
	void onInsertarAction(ActionEvent event) throws IOException {

		// Abre un "formulario de inserción"
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/InsertarFXMLView.fxml"));
		loader.setController(this);
		loader.load();

		List<List<String>> universidades = devuelveNombresUniversidad();// Llamo a un función propia que devuelve dos
																		// listas, uno con los nombres de universidad y
																		// otra con sus códigos

		ComboUniversidad.getItems().addAll(universidades.get(1));
		ComboUniversidad.getSelectionModel().selectFirst();
		Stage stage = new Stage();
		stage.setTitle("Insertar datos");
		stage.setScene(new Scene(InsertarResidenciaView));
		stage.show();

	}

	// Boton de la vista formulario
	@FXML
	void onInsertarResidenciaAction(ActionEvent event) {

		try {
			// De esta manera recojo el codigo de la universidad a través de su nombre
			String codigoUniversidad = (devuelveNombresUniversidad().get(0)
					.get(ComboUniversidad.getSelectionModel().getSelectedIndex()));
			// Envio los datos recogidos a una funcion propia que hace la inserción
			insertaResidencia(NombreResidenciaText.getText(), codigoUniversidad, ComedorCheckBox.isSelected(),
					Integer.parseInt(PrecioMensualText.getText()));

			Stage stage = (Stage) InsertarResidencia.getScene().getWindow();
			stage.close();
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de inserción");
			alert.setHeaderText("Compruebe que el campo precio mensual contiene solo valores numéricos");
			alert.show();
		}
	}

	// Funcion que hace la inserción
	private void insertaResidencia(String nombreResidencia, String codUniversidad, boolean comedor, int precioMensual) {
		try {
			java.sql.PreparedStatement insertar = conexion.prepareStatement(
					"INSERT INTO residencias(nomResidencia,codUniversidad,comedor,precioMensual) VALUES(?,?,?,?)");
			insertar.setString(1, nombreResidencia);
			insertar.setString(2, codUniversidad);
			insertar.setBoolean(3, comedor);
			insertar.setInt(4, precioMensual);
			insertar.execute();
			// Agregar un alerta de que se ha insertado correctamente
			onVisualizarAction(null);
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error inserción");
			alert.setHeaderText("No se ha podido realizar la inserción");
			alert.show();
		}
	}

	// Función que devuelve dos listas creadas de manera simultanea de manera que
	// guarden el nombre y el codigo de la universidad.
	// De esta manera mantienen el mismo indice en la lista
	private List<List<String>> devuelveNombresUniversidad() {
		// Creo un listado bidemensional con dos listas que guardaran simultanemeante en
		// una el codigo de la universidad y en la otra su nombra,
		// coincidiendo de esta manera sus indices
		List<List<String>> prueba = new ArrayList<List<String>>();
		prueba.add(new ArrayList<String>());// lista de los codigos de universidades
		prueba.add(new ArrayList<String>());// Lista de los nombres de universidades

		Statement stmt;
		try {
			stmt = conexion.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT codUniversidad,nomUniversidad FROM universidades order by codUniversidad");
			while (rs.next()) {
				// nombreUniversidades.getItems().add(rs.getString(1));
				prueba.get(0).add(rs.getString(1));
				prueba.get(1).add(rs.getString(2));

			}

		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error listado");
			alert.setHeaderText("No se ha podido realizar un listado de las universidades");
			alert.show();
		}
		return prueba;
	}

//----------------------------------------------------------Modificar registro----------------------------------------------------------\\
	@FXML
	void onModificarAction(ActionEvent event) throws IOException {
		// Abre un "formulario de inserción"
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ModificarFXMLView.fxml"));
		loader.setController(this);
		loader.load();

		List<List<String>> universidades = devuelveNombresUniversidad();// Llamo a un función propia que devuelve dos
																		// listas, uno con los nombres de universidad y
																		// otra con sus códigos
		int idResidencia = TablaVistaResidencias.getSelectionModel().getSelectedItem().getId();
		String nombreResidencia = TablaVistaResidencias.getSelectionModel().getSelectedItem().getNombreResidencia();
		String codigoUniversidad = TablaVistaResidencias.getSelectionModel().getSelectedItem().getCodigoUniversidad();
		Boolean comedor = TablaVistaResidencias.getSelectionModel().getSelectedItem().isComedor();
		int precioMensual = TablaVistaResidencias.getSelectionModel().getSelectedItem().getPrecioMensual();
		int indiceCodigo = devuelveNombresUniversidad().get(0).lastIndexOf(codigoUniversidad);
		// Es mis dos listas, cada nombre de universidad y codigo, tienen el mismo
		// indice
		IdResidenciaModificar.setText(Integer.toString(idResidencia));
		NombreResidenciaTextModificar.setText(nombreResidencia);
		ComboUniversidadModificar.getItems().addAll(universidades.get(1));
		ComboUniversidadModificar.getSelectionModel().select(indiceCodigo);
		ComedorCheckBoxModificar.setSelected(comedor);
		PrecioMensualTextModificar.setText(Integer.toString(precioMensual));

		Stage stage = new Stage();
		stage.setTitle("Modificar datos");
		stage.setScene(new Scene(ModificarResidenciaView));
		stage.show();
	}

	@FXML
	void onModificarResidenciaAction(ActionEvent event) {
		try {
			String codigoUniversidad = (devuelveNombresUniversidad().get(0)
					.get(ComboUniversidadModificar.getSelectionModel().getSelectedIndex()));
			// Envio los datos recogidos a una funcion propia que hace la inserción
			modificaResidencia(Integer.parseInt(IdResidenciaModificar.getText()),
					NombreResidenciaTextModificar.getText(), codigoUniversidad, ComedorCheckBoxModificar.isSelected(),
					Integer.parseInt(PrecioMensualTextModificar.getText()));

			Stage stage = (Stage) ModificarResidencia.getScene().getWindow();
			stage.close();
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de modificación");
			alert.setHeaderText("Compruebe que el campo precio mensual solo tiene valores numéricos");
			alert.show();
		}

	}

	private void modificaResidencia(int codigoResidencia, String nombreResidencia, String codUniversidad,
			boolean comedor, int precioMensual) {

		try {
			java.sql.PreparedStatement modificar = conexion.prepareStatement(
					"UPDATE residencias SET nomResidencia=?,codUniversidad=?,comedor=?,precioMensual=? WHERE codResidencia=?");
			modificar.setString(1, nombreResidencia);
			modificar.setString(2, codUniversidad);
			modificar.setBoolean(3, comedor);
			modificar.setInt(4, precioMensual);
			modificar.setInt(5, codigoResidencia);
			modificar.execute();
			// Agregar un alerta de que se ha insertado correctamente
			onVisualizarAction(null);
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de modificación");
			alert.setHeaderText("Se ha producido un error en la modificación");
			alert.show();
		}

	}

	// ----------------------------------------------------------Eliminar
	// registro----------------------------------------------------------\\
	@FXML
	void onEliminarAction(ActionEvent event) {
		int idResidencia = TablaVistaResidencias.getSelectionModel().getSelectedItem().getId();
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Eliminar resindecia");
		alert.setContentText("Estas seguro de querer eliminar el registro con id: " + idResidencia);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			eliminarRegistro(idResidencia);
		} else {
			System.out.println("CANcel");
		}

	}

	private void eliminarRegistro(int idResidencia) {

		try {
			java.sql.PreparedStatement eliminar = conexion
					.prepareStatement("DELETE FROM residencias WHERE codResidencia=?");
			eliminar.setInt(1, idResidencia);
			eliminar.execute();
			// Agregar un alerta de que se ha eliminado correctamente
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Éxito en la eliminación");
			alert.setHeaderText("Se ha eliminado el registro correctamente");
			alert.show();
			onVisualizarAction(null);
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de eliminación");
			alert.setHeaderText("No se ha podido eliminar el registro.");
			alert.show();
		}

	}
	// ----------------------------------------------------------Procedimiento
	// DNI----------------------------------------------------------\\

	@FXML
	void onProcedimientoDNIAction(ActionEvent event) throws IOException {
		Estancias = new EstanciasProcedimientosController();
		Estancias.Estancias.clear();
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Procedimiento busqueda por DNI");
		dialog.setContentText("Introduce un DNI válido:");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			try {
				CallableStatement procedure=null;
				if(MensajeBDLabel.getText().equals("Mysql")) {
					procedure = conexion.prepareCall("CALL EstanciasAlumno(?)");
				}else {
					procedure = conexion.prepareCall("{CALL EstanciasAlumno(?)}");
				}
				procedure.setString(1, result.get());
				ResultSet resultado = procedure.executeQuery();
				while (resultado.next()) {
					Estancias.Estancias.add(new EstanciasProcedimiento(resultado.getString(1), resultado.getString(2),
							resultado.getDate(3).toString(), resultado.getDate(4).toString(), resultado.getInt(5)));

				}
				Stage stage = new Stage();
				stage.setTitle("Consulta DNI");
				stage.setScene(new Scene(Estancias.getView()));
				stage.show();
			} catch (SQLException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error de procedimiento");
				alert.setHeaderText("No se ha podido ejecutar el procedimiento.");
				alert.show();
			}

		}
	}

	// ----------------------------------------------------------Procedimiento
	// Meses----------------------------------------------------------\\
	@FXML
	void onProcedimientoMesesAction(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Procedimiento meses estudiante");
		dialog.setContentText("Introduce un DNI válido:");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			try {
				CallableStatement procedure = conexion.prepareCall("{?=CALL sumaMeses(?)}");
				procedure.registerOutParameter(1, Types.INTEGER);
				procedure.setString(2, result.get());
				procedure.execute();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Procedimiento meses");
				alert.setHeaderText("Éxito en la ejecución del procedimiento,mostrando resultados.");
				alert.setContentText("Total meses: " + procedure.getInt(1));
				alert.showAndWait();

				// System.out.println(procedure.getInt(1));

			} catch (SQLException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error de procedimiento");
				alert.setHeaderText("No se ha podido realizar el procedimiento.");
				alert.show();
			}

		}

	}
	// ----------------------------------------------------------Procedimiento
	// Universidad----------------------------------------------------------\\

	@FXML
	void onProcedimientoUniAction(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProcedimientoUniversidadView.fxml"));
		loader.setController(this);
		loader.load();

		List<List<String>> universidades = devuelveNombresUniversidad();
		ComboUniversidadProcedimiento.getItems().addAll(universidades.get(1));
		ComboUniversidadProcedimiento.getSelectionModel().selectFirst();

		Stage stage = new Stage();
		stage.setTitle("Procedimiento universidad");
		stage.setScene(new Scene(ProcedimientoUniversidadView));
		stage.show();

	}

	@FXML
	void onAceptarProcedimientoUniversidadAction(ActionEvent event) {
		try {

			String nombreUniversidad = ComboUniversidadProcedimiento.getSelectionModel().getSelectedItem();
			int precioDado = Integer.parseInt(PrecioProcedimiento.getText());
			procesaProcedimientoUniversidad(nombreUniversidad, precioDado);
			Stage stage = (Stage) AceptarProcedimientoUni.getScene().getWindow();
			stage.close();
		} catch (NumberFormatException e) {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de procedimiento");
			alert.setHeaderText("Introduce un valor numérico");
			alert.show();
		}

	}

	private void procesaProcedimientoUniversidad(String nombreUniversidad, int precioDado) {
		try {
//			CallableStatement procedure = conexion.prepareCall("{?=CALL sumaMeses(?)}");
			CallableStatement procedure=null;
			if(MensajeBDLabel.getText().equals("Mysql")) {
			 procedure = conexion.prepareCall("CALL comprobarResis(?,?,?,?)");
			}else {
				procedure = conexion.prepareCall("{CALL comprobarResis(?,?,?,?)}");
				
			}

			procedure.registerOutParameter(1, Types.INTEGER);
			procedure.registerOutParameter(2, Types.INTEGER);
			procedure.setString(3, nombreUniversidad);
			procedure.setInt(4, precioDado);
			procedure.execute();

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Procedimiento universidad");
			alert.setHeaderText("Éxito en la ejecución del procedimiento,mostrando resultados");
			alert.setContentText("Total residencias: " + procedure.getInt(1)
					+ " \n Residencias con precio inferior al dado: " + procedure.getInt(2));
			alert.showAndWait();

		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de procedimiento");
			alert.setHeaderText("No se ha podido ejecutar el procedimiento");
			alert.show();
		}

	}

//-----------------------------ProcedimientoInsertar--------------------------\\
	@FXML
	void onProcedimientoInsertarAction(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/InsertarProcedimientoView.fxml"));
		loader.setController(this);
		loader.load();

		List<List<String>> universidades = devuelveNombresUniversidad();// Llamo a un función propia que devuelve dos
																		// listas, uno con los nombres de universidad y
																		// otra con sus códigos

		ComboUniversidadProcedimientoInsertar.getItems().addAll(universidades.get(1));
		ComboUniversidadProcedimientoInsertar.getSelectionModel().selectFirst();
		Stage stage = new Stage();
		stage.setTitle("Insertar datos por procedimiento");
		stage.setScene(new Scene(InsertarResidenciaProcedimientoView));
		stage.show();
	}

	@FXML
	void onInsertarResidenciaProcedimientoAction(ActionEvent event) {
		try {
			// De esta manera recojo el codigo de la universidad a través de su nombre
			String codigoUniversidad = (devuelveNombresUniversidad().get(0)
					.get(ComboUniversidadProcedimientoInsertar.getSelectionModel().getSelectedIndex()));
			// Envio los datos recogidos a una funcion propia que hace la inserción
			insertaResidenciaProcedimiento(NombreResidenciaProcedimientoText.getText(), codigoUniversidad,
					ComedorCheckBoxProcedimiento.isSelected(),
					Integer.parseInt(PrecioMensualTextProcedimiento.getText()));

			Stage stage = (Stage) InsertarResidenciaProcedimiento.getScene().getWindow();
			stage.close();
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de procedimiento");
			alert.setHeaderText("Introduce valores numéricos en el campo precio mensual");
			alert.show();
		}

	}

	private void insertaResidenciaProcedimiento(String nombreResidencia, String codUniversidad, boolean comedor,
			int precioMensual) {

		try {
			CallableStatement procedure = null;
			if(MensajeBDLabel.getText().equals("Mysql")) {
				procedure = conexion.prepareCall("CALL InsertarResi (?,?,?,?,?,?)");
			}else {
				procedure = conexion.prepareCall("{CALL InsertarResi (?,?,?,?,?,?)}");
			}
			
			procedure.registerOutParameter(1, Types.INTEGER);
			procedure.registerOutParameter(2, Types.INTEGER);
			procedure.setString(3, nombreResidencia);
			procedure.setInt(4, precioMensual);
			procedure.setString(5, codUniversidad);
			procedure.setBoolean(6, comedor);
			procedure.execute();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Procedimiento insertar");
			alert.setHeaderText("Éxito en la ejecución del procedimiento,mostrando resultados");
			alert.setContentText(
					"Universidad existe: " + procedure.getInt(1) + " \n Residencia insertada: " + procedure.getInt(2));
			alert.show();
			onVisualizarAction(null);
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de procedimiento");
			alert.setHeaderText("No se ha podido ejecutar el procedimiento");
			alert.show();
		}
	}

	public BaseDatosRelacionalesController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BaseDeDatosRelacionalesFXMLVersion2.fxml"));
		loader.setController(this);
		loader.load();
		botonesOn(false);
		procedimientosOn(false);
		DesconectarseBoton.disableProperty().setValue(true);

	}
	private void botonesOn(boolean on) {
		if(on) {
			Visualizar.disableProperty().setValue(false);
			Insertar.disableProperty().set(false);
		
		}else {
			Visualizar.disableProperty().setValue(true);
			Insertar.disableProperty().set(true);
		}
		
	}
	
	private void procedimientosOn(boolean on) {
		if(on) {
			ProcedimientoDNI.disableProperty().setValue(false);
			ProcedimientoInsertar.disableProperty().setValue(false);
			ProcedimientoMeses.disableProperty().setValue(false);
			ProcedimientoUNI.disableProperty().setValue(false);
		}else {
			
			ProcedimientoDNI.disableProperty().setValue(true);
			ProcedimientoInsertar.disableProperty().setValue(true);
			ProcedimientoMeses.disableProperty().setValue(true);
			ProcedimientoUNI.disableProperty().setValue(true);
			
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/*------------------------------------Binding---------------------------------------------*/
		bdModel.comboBoxSeleccionado.bind(ComboBD.getSelectionModel().selectedItemProperty());
		Modificar.disableProperty().bind(TablaVistaResidencias.getSelectionModel().selectedItemProperty().isNull());
		Eliminar.disableProperty().bind(TablaVistaResidencias.getSelectionModel().selectedItemProperty().isNull());
		/*----------------------------------------------------------------------------------------*/
		ComboBD.getItems().clear();
		ComboBD.getItems().addAll("Mysql", "Sql", "Access");
		ComboBD.getSelectionModel().selectFirst();
	

		/*------------------------------------Tabla estancias------------------------------------------------*/

//		ColumnaNombre.setCellValueFactory(new PropertyValueFactory<>("NombreEstudiante"));
//		ColumnaCodigoEstudiante.setCellValueFactory(new PropertyValueFactory<>("CodigoEstudiante"));
//		ColumnaResidencia.setCellValueFactory(new PropertyValueFactory<>("NombreResidencia"));
//		ColumnaCodigoResidencia.setCellValueFactory(new PropertyValueFactory<>("CodigoResidencia"));
//		ColumnaFechaInicio.setCellValueFactory(new PropertyValueFactory<>("FechaInicio"));
//		ColumnaFechaFin.setCellValueFactory(new PropertyValueFactory<>("FechaFin"));
//		ColumnaPrecioPagado.setCellValueFactory(new PropertyValueFactory<>("PrecioPagado"));
//		//Estancias.add(new Estancias("Prueba",1,"residencia",1,"10-1-2009","11-2-2010",1000));
//		TablaVista.setItems(Estancias);

		/*----------------------------------------------------------------------------------------*/

		/*------------------------------------Tabla Residencias------------------------------------------------*/
		ColumnaId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		ColumnaNombreResidencia.setCellValueFactory(new PropertyValueFactory<>("NombreResidencia"));
		ColumnaNombreUniversidad.setCellValueFactory(new PropertyValueFactory<>("NombreUniversidad"));
		ColumnaCodigoUniversidad.setCellValueFactory(new PropertyValueFactory<>("CodigoUniversidad"));
		ColumnaPrecioMensual.setCellValueFactory(new PropertyValueFactory<>("PrecioMensual"));
		ColumnaComedor.setCellValueFactory(new PropertyValueFactory<>("Comedor"));

		// Residencias.add(new
		// Residencias(1,"residencia1","universidad1","codUniversidad1",900,true));
		TablaVistaResidencias.setItems(Residencias);

		/*----------------------------------------------------------------------------------------*/

	}

	public BorderPane getView() {
		return View;
	}

}

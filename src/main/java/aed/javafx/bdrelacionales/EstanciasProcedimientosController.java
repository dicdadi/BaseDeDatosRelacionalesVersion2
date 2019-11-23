package aed.javafx.bdrelacionales;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class EstanciasProcedimientosController implements Initializable {
	public ObservableList<EstanciasProcedimiento> Estancias = FXCollections.observableArrayList();
	 @FXML
	    private BorderPane EstanciasProcedimientoView;

	    @FXML
	    private TableView<EstanciasProcedimiento> EstanciasProcedimiento;

	    @FXML
	    private TableColumn<EstanciasProcedimiento, String> ColumnaNombreResidencia;

	    @FXML
	    private TableColumn<EstanciasProcedimiento, String> ColumnaNombreUniversidad;

	    @FXML
	    private TableColumn<EstanciasProcedimiento, String> ColumnaInicio;

	    @FXML
	    private TableColumn<EstanciasProcedimiento, String> ColumnaFin;

	    @FXML
	    private TableColumn<EstanciasProcedimiento, Integer> ColumnaPrecio;
	    
	    
	    public EstanciasProcedimientosController() throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProcedimientoEstanciasView.fxml"));
			loader.setController(this);
			loader.load();
		}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ColumnaNombreResidencia.setCellValueFactory(new PropertyValueFactory<>("NombreResidencia"));
		ColumnaNombreUniversidad.setCellValueFactory(new PropertyValueFactory<>("NombreUniversidad"));
		ColumnaInicio.setCellValueFactory(new PropertyValueFactory<>("FechaInicio"));
		ColumnaFin.setCellValueFactory(new PropertyValueFactory<>("FechaFin"));
		ColumnaPrecio.setCellValueFactory(new PropertyValueFactory<>("PrecioPagado"));
		EstanciasProcedimiento.getItems().clear();
//		Estancias.add(new EstanciasProcedimiento("Prueba","prueba","adas","asdsad",900));
		EstanciasProcedimiento.setItems(Estancias);

	}
	public BorderPane getView() {
		return EstanciasProcedimientoView;
	}

}

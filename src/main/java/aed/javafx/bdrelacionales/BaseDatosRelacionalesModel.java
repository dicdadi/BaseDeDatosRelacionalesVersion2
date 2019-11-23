package aed.javafx.bdrelacionales;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BaseDatosRelacionalesModel {

	StringProperty comboBoxSeleccionado= new SimpleStringProperty();
	BooleanProperty conectado = new SimpleBooleanProperty();
	public final StringProperty comboBoxSeleccionadoProperty() {
		return this.comboBoxSeleccionado;
	}
	

	public final String getComboBoxSeleccionado() {
		return this.comboBoxSeleccionadoProperty().get();
	}
	

	public final void setComboBoxSeleccionado(final String comboBoxSeleccionado) {
		this.comboBoxSeleccionadoProperty().set(comboBoxSeleccionado);
	}


	public final BooleanProperty conectadoProperty() {
		return this.conectado;
	}
	


	public final boolean isConectado() {
		return this.conectadoProperty().get();
	}
	


	public final void setConectado(final boolean conectado) {
		this.conectadoProperty().set(conectado);
	}
	
	
	

}

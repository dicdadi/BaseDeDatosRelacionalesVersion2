package aed.javafx.bdrelacionales;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Estancias {
	private SimpleStringProperty nombreEstudiante, nombreResidencia, fechaInicio, fechaFin;
	private SimpleIntegerProperty codigoEstudiante, codigoResidencia, precioPagado;

	public Estancias(
			String nombreEstudiante,
			int codigoEstudiante, 
			String nombreResidencia,
			int codigoResidencia, 
			String fechaInicio, 
			String fechaFin,
		 int precioPagado) 
	{
		this.nombreEstudiante = new SimpleStringProperty(nombreEstudiante);
		this.nombreResidencia = new SimpleStringProperty(nombreResidencia);
		this.fechaInicio = new SimpleStringProperty(fechaInicio);
		this.fechaFin = new SimpleStringProperty(fechaFin);
		this.codigoEstudiante = new SimpleIntegerProperty(codigoEstudiante);
		this.codigoResidencia = new SimpleIntegerProperty(codigoResidencia);
		this.precioPagado = new SimpleIntegerProperty(precioPagado);
	}

	public final SimpleStringProperty nombreEstudianteProperty() {
		return this.nombreEstudiante;
	}

	public final String getNombreEstudiante() {
		return this.nombreEstudianteProperty().get();
	}

	public final void setNombreEstudiante(final String nombreEstudiante) {
		this.nombreEstudianteProperty().set(nombreEstudiante);
	}

	public final SimpleStringProperty nombreResidenciaProperty() {
		return this.nombreResidencia;
	}

	public final String getNombreResidencia() {
		return this.nombreResidenciaProperty().get();
	}

	public final void setNombreResidencia(final String nombreResidencia) {
		this.nombreResidenciaProperty().set(nombreResidencia);
	}

	public final SimpleStringProperty fechaInicioProperty() {
		return this.fechaInicio;
	}

	public final String getFechaInicio() {
		return this.fechaInicioProperty().get();
	}

	public final void setFechaInicio(final String fechaInicio) {
		this.fechaInicioProperty().set(fechaInicio);
	}

	public final SimpleStringProperty fechaFinProperty() {
		return this.fechaFin;
	}

	public final String getFechaFin() {
		return this.fechaFinProperty().get();
	}

	public final void setFechaFin(final String fechaFin) {
		this.fechaFinProperty().set(fechaFin);
	}

	public final SimpleIntegerProperty codigoEstudianteProperty() {
		return this.codigoEstudiante;
	}

	public final int getCodigoEstudiante() {
		return this.codigoEstudianteProperty().get();
	}

	public final void setCodigoEstudiante(final int codigoEstudiante) {
		this.codigoEstudianteProperty().set(codigoEstudiante);
	}

	public final SimpleIntegerProperty codigoResidenciaProperty() {
		return this.codigoResidencia;
	}

	public final int getCodigoResidencia() {
		return this.codigoResidenciaProperty().get();
	}

	public final void setCodigoResidencia(final int codigoResidencia) {
		this.codigoResidenciaProperty().set(codigoResidencia);
	}

	public final SimpleIntegerProperty precioPagadoProperty() {
		return this.precioPagado;
	}

	public final int getPrecioPagado() {
		return this.precioPagadoProperty().get();
	}

	public final void setPrecioPagado(final int precioPagado) {
		this.precioPagadoProperty().set(precioPagado);
	}

}

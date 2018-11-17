package mx.edu.upmh.asistentecátedra.modelo;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Alumno extends EntidadID implements Comparable<Alumno> {
	/*----------------------------------------------------------------
	* ATRIBUTOS
	* ---------------------------------------------------------------*/
	public static final String SEPARADOR_APELLIDOS = ", ";
	private static BooleanProperty apellidosPrimero = new SimpleBooleanProperty(false);
	private StringProperty matrícula	= new SimpleStringProperty();
	private StringProperty nombres		= new SimpleStringProperty();
	private StringProperty apellidos	= new SimpleStringProperty();
	private StringExpression nombreCompleto ;
	
	
		
	/*----------------------------------------------------------------
	 * CONSTRUCTORES
	 * ---------------------------------------------------------------*/
	
	/*----------------------------------------------------------------
	 * MÉTODOS
	 * ---------------------------------------------------------------*/
	/*
	 * Ordena por orden alfabético de los apellidos
	 * */
	@Override
	public int compareTo(Alumno o) {
		return this.getApellidos().compareTo(o.getApellidos());
	}
	
	public String getApellidos( ) {
		return apellidos.get();
	}
	
	
	
		public static boolean getApellidosPrimero() {
		return apellidosPrimero.get();
	}

	public String getMatrícula( ) {
		return this.matrícula.get();
	}
	
	public String getNombreCompleto(  ) {
		return this.getNombreCompleto(false);
	}
	public String getNombreCompleto( boolean apellidosPrimero ) {
		return (apellidosPrimero ? (this.getApellidos()+SEPARADOR_APELLIDOS+this.getNombres()):(this.getNombres()+" "+ this.getApellidos()) );
	}
	
	public String getNombres( ) {
		return this.nombres.get();
	}
	
	public StringExpression nombreCompletoProperty() {
		if( this.nombreCompleto == null ) {
			this.nombreCompleto = ( this.getApellidosPrimero() ? Bindings.concat(this.apellidos, SEPARADOR_APELLIDOS, this.nombres) :  Bindings.concat(this.nombres, " " , this.apellidos) );
		}
		return this.nombreCompleto;
	}
	
	public void setApellidos( String apellidos ) {
		//TODO Validar apellidos
		this.apellidos.set(apellidos);
	}
	
	public void setApellidosPrimero( boolean b ) {
		this.apellidosPrimero.set(b);
	}
	
	public void setMatrícula( String matrícula) {
		//TODO Validar matrícula
		this.matrícula.set(matrícula);
	}
	
	public void setNombres( String nombres) {
		//TODO Validar nombres
		this.nombres.set(nombres);
	}

	@Override
	public String toString() {
		return getNombreCompleto();
	}
	
	
	
	
}

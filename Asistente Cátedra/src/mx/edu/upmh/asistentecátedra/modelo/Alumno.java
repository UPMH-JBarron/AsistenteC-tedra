package mx.edu.upmh.asistentecátedra.modelo;

import javafx.beans.property.StringProperty;

public class Alumno extends EntidadID {
	/*----------------------------------------------------------------
	* ATRIBUTOS
	* ---------------------------------------------------------------*/
	public static final String SEPARADOR_APELLIDOS = ", ";
	
	private StringProperty matrícula;
	private StringProperty nombres;
	private StringProperty apellidos;
		
	/*----------------------------------------------------------------
	 * CONSTRUCTORES
	 * ---------------------------------------------------------------*/
	/*----------------------------------------------------------------
	 * MÉTODOS
	 * ---------------------------------------------------------------*/
	public String getApellidos( ) {
		return apellidos.get();
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
	
	public void setApellidos( String apellidos ) {
		//TODO Validar apellidos
		this.apellidos.set(apellidos);
	}
	
	public void setMatrícula( String matrícula) {
		//TODO Validar matrícula
		this.matrícula.set(matrícula);
	}
	
	public void setNombres( String nombres) {
		//TODO Validar nombres
		this.nombres.set(nombres);
	}
	
	
}

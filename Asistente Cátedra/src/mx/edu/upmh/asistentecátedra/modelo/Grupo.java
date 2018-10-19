package mx.edu.upmh.asistentecátedra.modelo;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Grupo extends EntidadID{
	/*----------------------------------------------------------------
	* ATRIBUTOS
	* ---------------------------------------------------------------*/
	private StringProperty nombre;
	private ObservableList<Alumno> alumnos;
	
	/*----------------------------------------------------------------
	 * CONSTRUCTORES
	 * ---------------------------------------------------------------*/
	public Grupo() {
	}
	public Grupo(int id, String nombre) {
		this( id, nombre, "");		
	}
	
	public Grupo(int id, String nombre, String notas) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setNotas(notas);
	}
	
	
	/*----------------------------------------------------------------
	 * MÉTODOS
	 * ---------------------------------------------------------------*/
	
	public ObservableList<Alumno> getAlumnos( ){
		if( this.alumnos == null ) {
			this.alumnos = FXCollections.observableArrayList( new ArrayList<Alumno>() );
		}
		return this.alumnos;
	}
	
	/**
	 * @return El nombre del grupo
	 */
	public String getNombre() {
		return nombre.get();
	}
	
	public StringProperty nombreProperty( ) {
		return this.nombre;
	}
	
	/**
	 * @param nombre El nombre del grupo
	 */
	public void setNombre(String nombre) {
		this.nombre.set( nombre );
	}
	
	
	
}

package mx.edu.upmh.asistentecátedra.modelo;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Curso extends EntidadID{
	/*----------------------------------------------------------------
	* ATRIBUTOS
	* ---------------------------------------------------------------*/
	public static final String SEPARADOR_CURSO = " - ";
	private StringExpression nombre;
	
	private StringProperty nombreMateria = new SimpleStringProperty();
	private Grupo grupo	= new Grupo( );
	
	/*----------------------------------------------------------------
	 * CONSTRUCTORES
	 * ---------------------------------------------------------------*/
	public Curso( ) {
		
	}
	public Curso( int id, String nombreMateria  ) {
		this( id, nombreMateria, null );
	}
	public Curso( int id, String nombreMateria, Grupo grupo  ) {
		this.setId(id);
		this.setNombreMateria(nombreMateria);
		this.setGrupo(grupo);
	}
	
	/*----------------------------------------------------------------
	 * MÉTODOS
	 * ---------------------------------------------------------------*/
	private void configurar( ) {
		//TODO Tratar nulos
		if( this.grupo != null) {
			this.nombre = Bindings.concat(this.nombreMateria , SEPARADOR_CURSO, this.grupo.nombreProperty() );
		}
	}
	
	public Grupo getGrupo() {
		return this.grupo;
	}
	
	public String getNombreMateria() {
		return this.nombreMateria.get();
	}
	
	public String getNombre( ) {
		return this.nombre.get();
	}
	
	public StringExpression nombreProperty( ) {
		return this.nombre;
	}
	
	public void setGrupo( Grupo grupo) {
		this.grupo = grupo;
		this.configurar();
	}
	
	public void setNombreMateria( String nombreMateria ) {
		this.nombreMateria.set(nombreMateria);
	}

	@Override
	public String toString() {
		return getNombre();
	}
	
	

}

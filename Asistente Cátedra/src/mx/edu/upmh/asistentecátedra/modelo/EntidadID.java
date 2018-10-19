package mx.edu.upmh.asistentecátedra.modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public abstract class EntidadID {
	/*----------------------------------------------------------------
	* ATRIBUTOS
	* ---------------------------------------------------------------*/
	private IntegerProperty id;
	private StringProperty notas;
	
	/*----------------------------------------------------------------
	 * CONSTRUCTORES
	 * ---------------------------------------------------------------*/
	/*----------------------------------------------------------------
	 * MÉTODOS
	 * ---------------------------------------------------------------*/
	/**
	 * @return El ID del grupo
	 */
	public int getId() {
		return id.intValue();
	}
	
	/**
	 * @return Notas sobre el grupo
	 */
	public String getNotas() {
		return notas.get();
	}
	
	/**
	 * @param id El id del grupo
	 */
	public void setId(int id) {
		this.id.set(  id );
	}
	
	/**
	 * @param nombre Las notas sobre el grupo
	 */
	public void setNotas(String notas) {
		this.notas.set( notas );
	}
}

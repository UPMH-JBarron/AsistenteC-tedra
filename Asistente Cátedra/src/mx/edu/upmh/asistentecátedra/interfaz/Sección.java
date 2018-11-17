/**
 * 
 */
package mx.edu.upmh.asistentecátedra.interfaz;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import mx.edu.upmh.asistentecátedra.AsistenteCátedra;

/**
 * @author jbarron
 *
 */
public abstract class Sección  {
	/*----------------------------------------------------------------
	* ATRIBUTOS
	* ---------------------------------------------------------------*/
	private Object datos;
	
	/*----------------------------------------------------------------
	 * MÉTODOS
	 * ---------------------------------------------------------------*/
	public final void setDatos(Object datos) {
		this.datos = datos;
	}
	
	protected final Object getDatos() {
		return this.datos;
	}
}

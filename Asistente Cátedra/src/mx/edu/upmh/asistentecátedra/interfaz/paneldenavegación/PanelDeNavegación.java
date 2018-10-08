/**
 * 
 */
package mx.edu.upmh.asistentecátedra.interfaz.paneldenavegación;


import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mx.edu.upmh.asistentecátedra.modelo.Ciclo;


/**
 * @author jbarron
 *
 */
public class PanelDeNavegación extends ToolBar {
	/*----------------------------------------------------------------
	* ATRIBUTOS
	* ---------------------------------------------------------------*/
	private Object objDestino;
	private Button btnInicio;
	
	/*----------------------------------------------------------------
	 * CONSTRUCTORES
	 * ---------------------------------------------------------------*/
	public PanelDeNavegación() {
		this.btnInicio = new Button("Inicio");
		this.btnInicio.setId("btnInicio");
	}
		
	/*----------------------------------------------------------------
	 * MÉTODOS
	 * ---------------------------------------------------------------*/
	
	
	private void construirRuta( Object objDestino ) {
		if( objDestino == null ) {
			return;
		}
		if( Ciclo.class.isAssignableFrom(objDestino.getClass()) ) {
			// TODO Mostrar información del ciclo
		}
		
	}
	/**
	 * Reconfigura la barra de navegación para mostrar el destino hacia el objeto indicado.
	 * @param objDestino Objeto de información al que se desea mostrar la ruta.
	 */
	public void setDestino( Object objDestino ) {
		this.objDestino = objDestino;
		this.getItems().clear();
		this.construirRuta( objDestino );
	}
	
	
}

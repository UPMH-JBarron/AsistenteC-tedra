/**
 * 
 */
package mx.edu.upmh.asistentecátedra.interfaz.paneldenavegación;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import mx.edu.upmh.asistentecátedra.modelo.Ciclo;


/**
 * @author jbarron
 *
 */
public class PanelDeNavegación {
	/*----------------------------------------------------------------
	* ATRIBUTOS
	* ---------------------------------------------------------------*/
	private Object objDestino;
	
	@FXML private Button btnInicio;
	@FXML private ToolBar panelRuta;
	
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
	
	
	private void construirRuta( ) {
		if( this.objDestino == null ) {
			return;
		}
		if( Ciclo.class.isAssignableFrom(this.objDestino.getClass()) ) {
			// TODO Mostrar información del ciclo
			Node nodoDestino = new Button( this.objDestino.toString() );
			nodoDestino.getStyleClass().add("NodoRuta");
			this.panelRuta.getItems().add( nodoDestino );
			
		}
		
	}
	@FXML
	private void irInicio( ActionEvent e ) {
		System.out.println("Ir al inicio");
	}
	
	
	/**
	 * Reconfigura la barra de navegación para mostrar el destino hacia el objeto indicado.
	 * @param objDestino Objeto de información al que se desea mostrar la ruta.
	 */
	
	public void setDestino( Object objDestino ) {
		this.objDestino = objDestino;
		this.construirRuta( );
	}
	
	
	
	
	
	
}

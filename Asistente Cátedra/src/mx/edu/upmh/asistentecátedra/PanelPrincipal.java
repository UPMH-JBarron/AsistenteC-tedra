/**
 * 
 */
package mx.edu.upmh.asistentecátedra;


import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import mx.edu.upmh.asistentecátedra.AsistenteCátedra.SECCIÓN;
import mx.edu.upmh.asistentecátedra.interfaz.paneldenavegación.PanelDeNavegación;


/**
 * @author Javier Elias Barrón López <jbarron@upmh.edu.mx>
 *
 */
public class PanelPrincipal {
	/*----------------------------------------------------------------
	 * ATRIBUTOS
	 * ---------------------------------------------------------------*/
	@FXML private PanelDeNavegación panelDeNavegaciónController;
	@FXML private BorderPane panelPrincipal;
	
	/*----------------------------------------------------------------
	 * CONSTRUCTORES
	 * ---------------------------------------------------------------*/
	
	/*----------------------------------------------------------------
	 * MÉTODOS
	 * ---------------------------------------------------------------*/
	public Object getDestino( ) {
		return this.panelDeNavegaciónController.getDestino();
	}
	
	public void setContenido( SECCIÓN sección, Parent nodoContenido , Object datos) {
		this.panelDeNavegaciónController.setDestino(sección, datos);
		this.panelPrincipal.setCenter(nodoContenido);
		
	}
		
}

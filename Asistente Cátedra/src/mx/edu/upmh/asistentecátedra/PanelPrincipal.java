/**
 * 
 */
package mx.edu.upmh.asistentecátedra;


import javafx.fxml.FXML;
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
	
	/*----------------------------------------------------------------
	 * CONSTRUCTORES
	 * ---------------------------------------------------------------*/
	
	/*----------------------------------------------------------------
	 * MÉTODOS
	 * ---------------------------------------------------------------*/
	@FXML
	public void initialize( ) {
		System.out.println( "PanelPrincipal cargado" );
	}
		
}

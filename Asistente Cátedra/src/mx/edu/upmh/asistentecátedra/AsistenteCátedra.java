/**
 * Clase principal del asistente de cátedra.
 */
package mx.edu.upmh.asistentecátedra;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.stage.Stage;
import mx.edu.upmh.asistentecátedra.interfaz.barradenavegación.PanelDeNavegación;

/**
 * @author Javier Elias Barrón López <jbarron@upmh.edu.mx>
 *
 */
public class AsistenteCátedra extends Application {
	/*----------------------------------------------------------------
	 * ATRIBUTOS
	 * ---------------------------------------------------------------*/
	/*----------------------------------------------------------------
	 * CONSTRUCTORES
	 * ---------------------------------------------------------------*/
	/*----------------------------------------------------------------
	 * MÉTODOS
	 * ---------------------------------------------------------------*/
	public static void main(String [] args) {
		launch(args);
	}

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		PanelPrincipal panelPrincipal = new PanelPrincipal( );
		Scene escena = new Scene(panelPrincipal, 1024,  768);
		primaryStage.setTitle("UPMH - Asistente para el catedrático - Javier Barrón");
		primaryStage.setScene(escena);
		primaryStage.setMaximized(true);
		primaryStage.show();

	}

}

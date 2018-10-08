/**
 * Clase principal del asistente de cátedra.
 */
package mx.edu.upmh.asistentecátedra;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.stage.Stage;
import mx.edu.upmh.asistentecátedra.interfaz.paneldenavegación.PanelDeNavegación;

/**
 * @author Javier Elias Barrón López <jbarron@upmh.edu.mx>
 *
 */
public class AsistenteCátedra extends Application {
	/*----------------------------------------------------------------
	 * ATRIBUTOS
	 * ---------------------------------------------------------------*/
	public static final String CSS_ARCHIVO ="/mx/edu/upmh/asistentecátedra/interfaz/Interfaz.css";
	
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
		FXMLLoader cargadorFXML = new FXMLLoader(getClass().getResource( "/mx/edu/upmh/asistentecátedra/PanelPrincipal.fxml" ) );
		Parent raízPanelPrincipal = null;
		PanelPrincipal ctrlPanelPrincipal = null;
		try {
			raízPanelPrincipal =  (Parent) cargadorFXML.load();
			ctrlPanelPrincipal =  cargadorFXML.getController();
		} catch (Exception e) {
 
			e.printStackTrace();
		}	
		Scene escena = new Scene(raízPanelPrincipal, 1024,  768);
		//escena.getStylesheets().add(this.getClass().getResource(CSS_ARCHIVO).toExternalForm());
		primaryStage.setTitle("UPMH - Asistente para el catedrático - Javier Barrón");
		primaryStage.setScene(escena);
		primaryStage.setMaximized(true);
		primaryStage.show();

	}

}

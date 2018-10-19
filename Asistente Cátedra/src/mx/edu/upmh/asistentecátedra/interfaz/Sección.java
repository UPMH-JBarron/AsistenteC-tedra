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
	
	/*----------------------------------------------------------------
	 * MÉTODOS
	 * ---------------------------------------------------------------*/
	protected abstract String getRutaFXML( );
	
	public void configurar( BorderPane contenedor, Object datos ) {
		URL urlFXML = getClass().getResource(AsistenteCátedra.RAÍZ_PROYECTO + this.getRutaFXML() );
		//DEBUG 
		System.out.println( "URL:" + urlFXML.toString() );
		
		FXMLLoader cargadorFXML = new FXMLLoader(urlFXML);
		Parent raízContenido = null;
		
		try {
			 raízContenido	= (Parent) cargadorFXML.load();
			 raízContenido.getStylesheets().clear();
			 raízContenido.getStylesheets().add( AsistenteCátedra.CSS_ARCHIVO );
		}catch (IOException e) {
			raízContenido = new Label("Error al cargar el archivo FXML de "+this.getClass().getSimpleName() );
			e.printStackTrace();
		}finally {
			//DEBUG
			System.out.println( "Agregar al centro" );
			contenedor.setCenter(raízContenido);
		}
		
	}
	
	
	
	
	
	
	
	
}

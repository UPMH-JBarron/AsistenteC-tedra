/**
 * Clase principal del asistente de cátedra.
 */
package mx.edu.upmh.asistentecátedra;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mx.edu.upmh.asistentecátedra.interfaz.Sección;

/**
 * @author Javier Elias Barrón López <jbarron@upmh.edu.mx>
 *
 */
public class AsistenteCátedra extends Application {
	/*----------------------------------------------------------------
	 * ENUM
	 * ---------------------------------------------------------------*/
	//TODO Asignar rutas
	public enum SECCIÓN{ 
		  CICLOS("interfaz/ciclos/Ciclos.fxml")
		, CURSOS("interfaz/cursos/Cursos.fxml")
		, LISTA("interfaz/alumnos/Lista.fxml")
		/*, SECCIONES("")
		, CARGA_CALIFICACIONES("")
		, CONFIGURACIÓN("")
		, ACERCA_DE("")
		*/
		;
		
		private String rutaFXML;
		
		private SECCIÓN(String rutaFXML) {
			this.rutaFXML = rutaFXML;
		}
		
		private String getRutaFXML( ) {
			return this.rutaFXML;
		}
		 
	}
	
	/*----------------------------------------------------------------
	 * ATRIBUTOS
	 * ---------------------------------------------------------------*/
	public static final String RAÍZ_PROYECTO = "/mx/edu/upmh/asistentecátedra/";
	public static final String CSS_ARCHIVO ="/mx/edu/upmh/asistentecátedra/interfaz/Interfaz.css";
	private static AsistenteCátedra instancia = null;
	private SECCIÓN sección;
	private Object datos;
	@FXML private PanelPrincipal panelPrincipalController;
	
	
	
	
	
	
	
	/*----------------------------------------------------------------
	 * CONSTRUCTORES
	 * ---------------------------------------------------------------*/
	/*----------------------------------------------------------------
	 * MÉTODOS
	 * ---------------------------------------------------------------*/
	
	
	
	public static void main(String [] args) {
		launch(args);
	}

	public static AsistenteCátedra getInstancia() {
		return instancia;
	}
	
	public Object getDestino( ) {
		return this.panelPrincipalController.getDestino();
	}

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		instancia = this;
		// Cargar Panel principal
		URL fxmlPanelPrincipal = getClass().getResource(RAÍZ_PROYECTO + "/PanelPrincipal.fxml");
		BorderPane panelPrincipal = null;
		try {
			FXMLLoader fxml = new FXMLLoader(fxmlPanelPrincipal);
			panelPrincipal = (BorderPane)fxml.load();
			this.panelPrincipalController = fxml.getController();
		}catch(Exception e) {
			System.out.println( "No se pudo cargar el panel principal" );
			e.printStackTrace();
		}
		Scene escena = new Scene(panelPrincipal, 1024, 768);
		primaryStage.setScene(escena);
		primaryStage.setTitle("UPMH - Asistente para el catedrático - Javier Barrón");
		primaryStage.setMaximized(true);
		primaryStage.show();
		

	}
	
	/**
	 * Muestra una sección específica de la aplicación. Si la sección espera información adicional se debe usar el método {@link #setSección(SECCIÓN, Object) setSección }.
	 * @param sección Sección de la aplicación a mostrar.
	 */
	public void setSección( SECCIÓN sección  ) {
		this.setSección(sección, null);
	}
	/**
	 * Muestra una sección específica de la aplicación. 
	 * @param sección Sección de la aplicación a mostrar.
	 * @param info	Objeto con la información adicional a mostrar. El tipo de objeto esperado dependerá de la sección indicada.
	 */
	public void setSección( SECCIÓN sección, Object datos ) {
		this.datos = datos;
		this.sección = sección;
		Sección controladorSección = null;
		
		
		URL urlFXML = getClass().getResource(RAÍZ_PROYECTO + sección.getRutaFXML() );
		//DEBUG System.out.println( "URL:" + urlFXML.toString() );
		
		FXMLLoader cargadorFXML = new FXMLLoader(urlFXML);
		Parent raízContenido = null;
		
		try {
			
			 raízContenido	= (Parent) cargadorFXML.load();
			 controladorSección = (Sección) cargadorFXML.getController();
			 controladorSección.setDatos(datos);
			 raízContenido.getStylesheets().clear();
			 raízContenido.getStylesheets().add( CSS_ARCHIVO );
			 
			 
		}catch (IOException e) {
			e.printStackTrace();
			raízContenido = new Label("Error al cargar el archivo FXML de "+sección );
			
		}finally {
			this.panelPrincipalController.setContenido( sección, raízContenido, datos );
		}
		
		
	}

} // class

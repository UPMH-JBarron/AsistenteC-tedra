/**
 * Clase principal del asistente de cátedra.
 */
package mx.edu.upmh.asistentecátedra;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mx.edu.upmh.asistentecátedra.interfaz.Sección;
import mx.edu.upmh.asistentecátedra.interfaz.ciclos.SecciónCiclos;

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
		  CICLOS
		, CURSOS
		/*, LISTAS("")
		, SECCIONES("")
		, CARGA_CALIFICACIONES("")
		, CONFIGURACIÓN("")
		, ACERCA_DE("")
		*/
		;
		 
	}
	
	/*----------------------------------------------------------------
	 * ATRIBUTOS
	 * ---------------------------------------------------------------*/
	public static final String RAÍZ_PROYECTO = "/mx/edu/upmh/asistentecátedra/";
	public static final String CSS_ARCHIVO ="/mx/edu/upmh/asistentecátedra/interfaz/Interfaz.css";
	private static AsistenteCátedra instancia = null;
	private SECCIÓN sección;
	private PanelPrincipal panelPrincipalController;
	
	
	
	
	
	
	
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
		
		this.sección = sección;
		Sección controladorSección = null;
		switch( sección ) {
			case CICLOS:
				controladorSección = new SecciónCiclos();
				break;
			default:
				System.out.println( getClass().getSimpleName() + ":\tSección no configurada (" + sección.toString() + ")"   );
				controladorSección = new SecciónCiclos();
				
		}
		//System.out.println( "Configurar: " + this.panelPrincipal  );
		//controladorSección.configurar(this.panelPrincipal, datos);
		
		
		/*
		URL urlFXML = getClass().getResource(RAÍZ_PROYECTO + sección.getRutaRelativa() );
		//DEBUG System.out.println( "URL:" + urlFXML.toString() );
		
		FXMLLoader cargadorFXML = new FXMLLoader(urlFXML);
		Parent raízContenido = null;
		
		try {
			 raízContenido	= (Parent) cargadorFXML.load();
			 raízContenido.getStylesheets().clear();
			 raízContenido.getStylesheets().add( CSS_ARCHIVO );
			Sección controladorSección = (Sección) cargadorFXML.getController();
		}catch (IOException e) {
			raízContenido = new Label("Error al cargar el archivo FXML de "+sección );
			e.printStackTrace();
		}finally {
			this.panelPrincipalController.setContenido( raízContenido, info );
			
		}
		*/
	}

} // class

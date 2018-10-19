/**
 * 
 */
package mx.edu.upmh.asistentecátedra.interfaz.ciclos;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.Map.Entry;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import mx.edu.upmh.asistentecátedra.AsistenteCátedra;
import mx.edu.upmh.asistentecátedra.modelo.Ciclo;
import mx.edu.upmh.asistentecátedra.modelo.Ciclo.Periodo;

/**
 * @author Javier Barrón <jbarron@upmh.edu.mx>
 *
 */
public class SelectorCiclo extends HBox implements EventHandler<ActionEvent> {
	/*----------------------------------------------------------------
	* CLASES INTERNAS
	* ---------------------------------------------------------------*/
	public class CicloSeleccionadoEvent extends ActionEvent{
		private Ciclo ciclo;

		public CicloSeleccionadoEvent(Ciclo ciclo) {
			super();
			this.ciclo = ciclo;
		}

		public Ciclo getCiclo() {
			return ciclo;
		}

		public void setCiclo(Ciclo ciclo) {
			this.ciclo = ciclo;
		}
		
		
	}
	
	/*----------------------------------------------------------------
	* ATRIBUTOS
	* ---------------------------------------------------------------*/
	@FXML private Label	lblAño;
	@FXML private HBox	panelPeriodos;
	private IntegerProperty año = new SimpleIntegerProperty(0);
	private EnumMap<Ciclo.Periodo, Ciclo> ciclos;
	
	/*----------------------------------------------------------------
	 * CONSTRUCTORES
	 * ---------------------------------------------------------------*/
	public SelectorCiclo( int año, Ciclo... c  ) {
		super();
		this.setAño(año);
		// Obtener ciclos
		ciclos = new EnumMap<>(Periodo.class);
		for( Ciclo iCiclo : c ) {
			this.ciclos.put(iCiclo.getPeriodo(), iCiclo);
		}
		// Cargar la interfaz
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(AsistenteCátedra.RAÍZ_PROYECTO + "interfaz/ciclos/SelectorCiclo.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
	     try {
	         fxmlLoader.load();
	     } catch (IOException exception) {
	         throw new RuntimeException(exception);
	     }
	}
	
	/*----------------------------------------------------------------
	 * MÉTODOS
	 * ---------------------------------------------------------------*/
	/*public void configurarInterfaz( ) {
		
	}
	*/
	
	public int getAño() {
		return año.get();
	}
	
	
	
	@Override
	public void handle(ActionEvent event) {
		CicloSeleccionadoEvent eventoCiclo = new CicloSeleccionadoEvent((Ciclo)((Button)event.getSource()).getUserData());
		this.fireEvent(eventoCiclo);
		event.consume();
	}

	@FXML
	public void initialize(){
		DecimalFormat formatoAño = new DecimalFormat();
		formatoAño.setGroupingUsed(false);
		
		this.lblAño.textProperty().bindBidirectional(this.año, formatoAño );
		this.panelPeriodos.getChildren().clear();
		for(Entry<Ciclo.Periodo, Ciclo> e : this.ciclos.entrySet()) {
			Button btnPeriodo = new Button(e.getKey().toString());
			btnPeriodo.setUserData(e.getValue());
			// Configurar escuchadores
			btnPeriodo.setOnAction(this);
			this.panelPeriodos.getChildren().add(btnPeriodo);
		}
		
	}

	public void setAño(int año) {
		this.año.set(año);;
	}
	
	public boolean enMismoAño( Ciclo c ) {
		if( this.getAño() >= 0 ) {
			if( c.getAño() != this.getAño() ) {
				return false;
			}
		}
		return true;
	}

}

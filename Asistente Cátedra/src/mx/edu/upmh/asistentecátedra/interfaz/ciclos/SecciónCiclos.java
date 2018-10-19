/**
 * 
 */
package mx.edu.upmh.asistentecátedra.interfaz.ciclos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import mx.edu.upmh.asistentecátedra.AsistenteCátedra;
import mx.edu.upmh.asistentecátedra.AsistenteCátedra.SECCIÓN;
import mx.edu.upmh.asistentecátedra.interfaz.Sección;
import mx.edu.upmh.asistentecátedra.interfaz.ciclos.SelectorCiclo.CicloSeleccionadoEvent;
import mx.edu.upmh.asistentecátedra.modelo.Ciclo;
import mx.edu.upmh.asistentecátedra.modelo.Ciclo.Periodo;

/**
 * @author jbarron
 *
 */
public class SecciónCiclos extends Sección implements EventHandler<ActionEvent>{
	/*----------------------------------------------------------------
	* ATRIBUTOS
	* ---------------------------------------------------------------*/
	@FXML private VBox panelCiclos;
	private ArrayList<Ciclo> ciclos = new ArrayList<>();
	
	
	/*----------------------------------------------------------------
	 * CONSTRUCTORES
	 * ---------------------------------------------------------------*/
	/*----------------------------------------------------------------
	 * MÉTODOS
	 * ---------------------------------------------------------------*/

	
	
	private void iniciarEscaneo( ) {
		// DEBUG Ciclos de prueba
		Ciclo c1 = new Ciclo(Periodo.MAYO_AGOSTO, 2016);
		Ciclo c2 = new Ciclo(Periodo.ENERO_ABRIL, 2017);
		Ciclo c3 = new Ciclo(Periodo.MAYO_AGOSTO, 2017);
		Ciclo c4 = new Ciclo(Periodo.SEPTIEMBRE_DICIEMBRE, 2017);
		Ciclo c5 = new Ciclo(Periodo.MAYO_AGOSTO, 2018);
		ciclos.add( c1 );
		ciclos.add( c2 );
		ciclos.add( c3 );
		ciclos.add( c4 );
		ciclos.add( c5 );
		/*
		System.out.println(c1.toString() + " VS " +c2.toString() +" = " + c1.compareTo(c2) );
		System.out.println(c2.toString() + " VS " +c3.toString() +" = " + c2.compareTo(c3) );
		System.out.println(c2.toString() + " VS " +c1.toString() +" = " + c2.compareTo(c1) );
		System.out.println(c3.toString() + " VS " +c2.toString() +" = " + c3.compareTo(c2) );
		
		System.out.println(c1.toString() + " VS " +c5.toString() +" = " + c1.compareTo(c5) );
		System.out.println(c5.toString() + " VS " +c1.toString() +" = " + c5.compareTo(c1) );
		*/
		
		SelectorCiclo sc = new SelectorCiclo(2017,c2, c3, c4);
		sc.addEventHandler(CicloSeleccionadoEvent.ACTION, this);
		
		
		this.panelCiclos.getChildren().add(sc);
		
		
		this.escaneoFinalizado();
	}
	
	@Override
	protected String getRutaFXML() {
		return "interfaz/ciclos/Ciclos.fxml";
	}

	private void escaneoFinalizado( ) {
		// Ordenar ciclos de forma descendente
		ciclos.sort(new Comparator<Ciclo>() {
			public int compare(Ciclo c1, Ciclo c2) {
				return c2.compareTo(c1);
			}
		});
		
		// Crear selectores de ciclo
		
		
	}
	
	
	
	@Override
	public void handle(ActionEvent event) {
		Ciclo cicloSeleccionado = ((CicloSeleccionadoEvent)event).getCiclo();
		//DEBUG System.out.println( "Ciclo seleccionado: " + cicloSeleccionado.toString() );
		AsistenteCátedra.getInstancia().setSección(SECCIÓN.CURSOS, cicloSeleccionado);
		
		event.consume();
		
	}

	@FXML
	public void initialize( ) {
		// TODO Iniciar tarea asíncrona para buscar ciclos en el directorio
		//DEBUG
		System.out.println( "Ciclos Initialize" );
		this.iniciarEscaneo();
	}
}

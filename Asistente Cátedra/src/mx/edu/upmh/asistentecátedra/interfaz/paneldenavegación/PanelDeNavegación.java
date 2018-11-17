/**
 * 
 */
package mx.edu.upmh.asistentecátedra.interfaz.paneldenavegación;


import java.util.ArrayList;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import mx.edu.upmh.asistentecátedra.AsistenteCátedra;
import mx.edu.upmh.asistentecátedra.AsistenteCátedra.SECCIÓN;
import mx.edu.upmh.asistentecátedra.modelo.Ciclo;
import mx.edu.upmh.asistentecátedra.modelo.Curso;


/**
 * @author jbarron
 *
 */
public class PanelDeNavegación implements EventHandler<ActionEvent>{
	/*----------------------------------------------------------------
	* ATRIBUTOS
	* ---------------------------------------------------------------*/
	private Object objDestino;
	
	@FXML private Button btnInicio;
	@FXML private ToolBar panelRuta;
	
	
	private Button	btnCiclo;
	private Button	btnCurso;

	
	
	/*----------------------------------------------------------------
	 * CONSTRUCTORES
	 * ---------------------------------------------------------------*/
	@FXML
	public void initialize() {
		
		this.btnInicio.setOnAction(this);
		
		this.btnCiclo	= new Button( "Ciclo" );
		this.btnCiclo.setOnAction(this);
		this.btnCurso	= new Button("Curso");
		this.btnCurso.setOnAction(this);

		
		 
	}
		
	/*----------------------------------------------------------------
	 * MÉTODOS
	 * ---------------------------------------------------------------*/
	
	
	private void construirRuta( SECCIÓN sección, Object datos ) {
		
		this.panelRuta.getItems().clear();
		ArrayList<Node> nodosRuta = new ArrayList<>();
		switch( sección ) {
		case LISTA:
			// Botón del curso
			Curso curso = (Curso) datos;
			this.btnCurso.setText(curso.getNombre());
			nodosRuta.add(btnCurso);
			datos = curso.getCiclo();
		case CURSOS:
			// Botón del ciclo
			Ciclo ciclo = (Ciclo) datos;
			this.btnCiclo.setText(ciclo.toString());
			this.btnCiclo.setUserData(ciclo);
			nodosRuta.add( this.btnCiclo);
			break;
		
		case CICLOS:
		default:
			
		}
		Collections.reverse(nodosRuta);
		this.panelRuta.getItems().addAll(nodosRuta);
	}
	
	public Object getDestino( ) {
		return this.objDestino;
	}
	
	
	
	@Override
	public void handle(ActionEvent event) {
		
		if( event.getSource() == this.btnInicio  ) {
			AsistenteCátedra.getInstancia().setSección(SECCIÓN.CICLOS);
		}else if( event.getSource() == btnCiclo ) {
			System.out.println(this.btnCiclo.getUserData().toString());
			AsistenteCátedra.getInstancia().setSección(SECCIÓN.CURSOS, this.btnCiclo.getUserData());
		}
		
	}

	
	
	/**
	 * Reconfigura la barra de navegación para mostrar el destino hacia el objeto indicado.
	 * @param objDestino Objeto de información al que se desea mostrar la ruta.
	 */
	
	public void setDestino( SECCIÓN sección, Object objDestino ) {
		this.objDestino = objDestino;
		this.construirRuta( sección, objDestino );
	}
	
	
	
	
	
	
}

package mx.edu.upmh.asistentecátedra.modelo;
/**
 * Representa a un ciclo (cuatrimestre) específico.
 * */
public class Ciclo {
	/*----------------------------------------------------------------
	* ENUM
	* ---------------------------------------------------------------*/
	public enum Periodo{
		  ENERO_ABRIL("Enero - Abril")
		, MAYO_AGOSTO("Mayo - Agosto")
		, SEPTIEMBRE_DICIEMBRE("Septiembre - Diciembre");
		
		
		private String cadena;
		Periodo( String cadena ){
			this.cadena = cadena;
		}
		@Override
		public String toString() {
			return this.cadena;
		}
		
	}
	/*----------------------------------------------------------------
	* ATRIBUTOS
	* ---------------------------------------------------------------*/
	private int año;
	private Periodo periodo;
	
	public int getAño() {
		return año;
	}
	public Periodo getPeriodo() {
		return periodo;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	
	/*----------------------------------------------------------------
	 * CONSTRUCTORES
	 * ---------------------------------------------------------------*/
	/*----------------------------------------------------------------
	 * MÉTODOS
	 * ---------------------------------------------------------------*/
	
}

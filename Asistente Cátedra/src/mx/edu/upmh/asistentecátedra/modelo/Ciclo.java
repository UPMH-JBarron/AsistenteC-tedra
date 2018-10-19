package mx.edu.upmh.asistentecátedra.modelo;
/**
 * Representa a un ciclo (cuatrimestre) específico.
 * */
public class Ciclo implements Comparable<Ciclo>{
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
	public Ciclo( ) {
		this( Periodo.ENERO_ABRIL, 1970 );
	}
	
	public Ciclo( Periodo periodo, int año ) {
		this.setPeriodo(periodo);
		this.setAño(año);
	}
	
	
	/*----------------------------------------------------------------
	 * MÉTODOS
	 * ---------------------------------------------------------------*/
	@Override
	public int compareTo(Ciclo otro) {
		// Comparar años para obtener la diferencia en años
		int difAños = this.getAño() - otro.getAño();
		int difPeriodos = this.getPeriodo().ordinal() - otro.getPeriodo().ordinal();
		int periodosPorAño = Periodo.values().length;
		int diferencia = 0;
		if( difAños == 0 ) {
			diferencia = difPeriodos;
		}else if(difAños > 0) {
			int periodosIntermedios = ((difAños-1) * periodosPorAño);
			int periodosExtraOtro = periodosPorAño - otro.getPeriodo().ordinal() - 1;
			int periodosExtraActual = this.getPeriodo().ordinal() +1 ;
			diferencia = periodosExtraOtro + periodosIntermedios + periodosExtraActual;
		}else {
			int periodosIntermedios = ((Math.abs(difAños)-1) * periodosPorAño);
			int periodosExtraActual = periodosPorAño - this.getPeriodo().ordinal() - 1;
			int periodosExtraOtro = otro.getPeriodo().ordinal()+1;
			 
			diferencia = -(periodosExtraOtro + periodosIntermedios + periodosExtraActual);
		}
		
		return diferencia;
	}
	@Override
	public String toString() {
		return new StringBuffer(this.getPeriodo().toString()).append(" ").append(this.getAño()).toString();
	}
	
	
	
}

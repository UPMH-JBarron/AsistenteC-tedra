package mx.edu.upmh.asistentecátedra.modelo;

import java.time.MonthDay;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Curso extends EntidadID{
	/*----------------------------------------------------------------
	* ATRIBUTOS
	* ---------------------------------------------------------------*/
	public static final String SEPARADOR_CURSO = " - ";
	private StringProperty nombre = new SimpleStringProperty();
	private ObservableList<Alumno> alumnos = FXCollections.observableArrayList();
	private ObservableList<Sesión> sesiones= FXCollections.observableArrayList();
	private Ciclo ciclo;
	private RegistroAsistencias asistencias = new RegistroAsistencias();
	
	private ObjectProperty<MonthDay> fechaPrimerCorte	= new SimpleObjectProperty<MonthDay>();
	private ObjectProperty<MonthDay> fechaSegundoCorte= new SimpleObjectProperty<MonthDay>();
	private ObjectProperty<MonthDay> fechaTercerCorte= new SimpleObjectProperty<MonthDay>();
	
	/*----------------------------------------------------------------
	 * CONSTRUCTORES
	 * ---------------------------------------------------------------*/
	public Curso( ) {
		super();
	}
	public Curso( int id, String nombre, Ciclo ciclo) {
		this( id, nombre, null, ciclo );
	}
	
	
	public Curso( int id, String nombre, Grupo grupo, Ciclo ciclo  ) {
		this.setId(id);
		this.setNombre(nombre);
		this.alumnos = grupo.getAlumnos();
		this.ciclo	= ciclo;
	}
	
	/*----------------------------------------------------------------
	 * MÉTODOS
	 * ---------------------------------------------------------------*/
	
	public ObjectProperty<MonthDay> fechaPrimerCorteProperty(){
		return this.fechaPrimerCorte;
	}
	public ObjectProperty<MonthDay> fechaSegundoCorteProperty(){
		return this.fechaSegundoCorte;
	}
	public ObjectProperty<MonthDay> fechaTercerCorteProperty(){
		return this.fechaTercerCorte;
	}
	
	public ObservableList<Alumno> getAlumnos() {
		return this.alumnos;
	}
	public Ciclo getCiclo() {
		return ciclo;
	}
	
	public MonthDay getFechaPrimerCorte( ) {
		return this.fechaPrimerCorte.get();
	}
	
	public MonthDay getFechaSegundoCorte( ) {
		return this.fechaSegundoCorte.get();
	}
	public MonthDay getFechaTercerCorte( ) {
		return this.fechaTercerCorte.get();
	}
	
	public String getNombre( ) {
		return this.nombre.get();
	}
	
	
	
	
	
	public ObservableList<Sesión> getSesiones() {
		return this.sesiones;
	}
	
	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}
	
	public void setFechaPrimerCorte( MonthDay fechaCorte) {
		this.fechaPrimerCorte.set( fechaCorte );
	}
	
	public void setFechaSegundoCorte( MonthDay fechaCorte) {
		this.fechaSegundoCorte.set( fechaCorte );
	}
	
	public void setFechaTercerCorte( MonthDay fechaCorte) {
		this.fechaTercerCorte.set( fechaCorte );
	}
	
	public void setNombre( String nombre ) {
		this.nombre.set(nombre);
	}
	
	public StringProperty nombreProperty( ) {
		return this.nombre;
	}
	
	
	
	public RegistroAsistencias getAsistencias() {
		return asistencias;
	}
	
	@Override
	public String toString() {
		return getNombre();
	}
	
	

}

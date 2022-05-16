package Class;


import Exception.AlumnoException;

public class Alumno extends Persona {

	private MiCalendar fecIng;
	
	private Integer cantMatAprob;
	
	private Double promedio;

	/*validar setters*/
	public MiCalendar getFecIng() {
		return fecIng;
	}

	public void setFecIng(MiCalendar fecIng) {
		this.fecIng = fecIng;
	}

	public Integer getCantMatAprob() {
		return cantMatAprob;
	}

	public void setCantMatAprob(Integer cantMatAprob) {
		this.cantMatAprob = cantMatAprob;
	}

	public Double getPromedio() {
		return promedio;
	}

	public void setPromedio(Double promedio) throws AlumnoException {
		if(promedio < 0 || promedio > 10){
			throw new AlumnoException("El promedio es inv�lido");
		}
		this.promedio = promedio;
	}

	public Alumno() {
		super();
	}
	
	public Alumno(Integer dni) {
		super(dni);
		// TODO Auto-generated constructor stub
	}

	public Alumno(Integer dni, String nombre, String apellido, MiCalendar fecNac, MiCalendar fecIng,
			Integer cantMatAprob, Double promedio) throws AlumnoException {
		super(dni, nombre, apellido, fecNac);
		this.fecIng = fecIng;
		setPromedio(promedio);
		setCantMatAprob(cantMatAprob);
	}
	
	public Alumno(Persona persona, MiCalendar fecIng,
			Integer cantMatAprob, Double promedio) throws AlumnoException {
		super(persona.getDni(), persona.nombre, persona.apellido, persona.fecNac);
		this.fecIng = fecIng;
		setPromedio(promedio);
		setCantMatAprob(cantMatAprob);
	}

	@Override
	public String toString() {
		return super.toString();/* + System.lineSeparator() 
		+ "Alumno [promedio=" + promedio + "]" 
		+ System.lineSeparator() + "Fecha Ingreso: " + fecIng.toString();*/
	}
	
}
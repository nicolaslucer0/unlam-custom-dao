package Class;


import Exception.PersonaException;
import Exception.PersonaNombreException;

public class Persona {
	
	private Integer dni;
	
	protected String nombre;
	
	protected String apellido;

	protected MiCalendar fecNac;
        
        public static String DELIMITADOR = "\t";

	public Persona(Integer dni, String nombre, String apellido, MiCalendar fecNac) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecNac = fecNac;
	}
	
	public Persona() {}
	
	public Persona(Integer dni) {
		this.dni = dni;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) throws PersonaException {
		if(dni == null || dni <= 0)
                    throw new PersonaException("Ingrese un valor mayor a 0");
		this.dni = dni;
	}

	public String getNombre() {
		if(nombre==null)
                    return "S/N";
		return nombre.trim();
	}

	public void setNombre(String nombre) throws PersonaNombreException  {
		if(nombre == null || nombre.trim().isEmpty())
                    throw new PersonaNombreException("El nombre no puede estar vacio");
		//Validar caracteres validos
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public MiCalendar getFecNac() {
		return fecNac;
	}

	public void setFecNac(MiCalendar fecNac) {
		this.fecNac = fecNac;
	}
	
	@Override
	public String toString() {
            String apellido2 = this.apellido.length() > 20?
                    this.apellido.substring(0,20) : this.apellido;
            String nombre2 = this.nombre.length() > 20?
                    this.nombre.substring(0,20) : this.nombre;
		return String.format("%08d" + DELIMITADOR + "%20s" + DELIMITADOR + "%20s" + DELIMITADOR + "",
                        getDni(),
			nombre2,
                        apellido2,
                        this.fecNac.toString()); 
	}
	
}
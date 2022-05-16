/*import Exception.AlumnoException;
import Exception.MiCalendarioException;
import Exception.PersonaException;
import Exception.PersonaNombreException;

public class AlumnoTest {

	@Test
	public void testSetCantMatAprob() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPromedio() {
		fail("Not yet implemented");
	}

	@Test
	public void testAlumno() {
		Alumno alumno = new Alumno();
		 assertNotNull(alumno);
		 
		 System.out.println(alumno.toString());
	}

	@Test
	public void testAlumnoDni() {
		Alumno alumno = new Alumno(123456);
		
		assertNotNull(alumno);
		assertNotNull(alumno.getDni());
		assertEquals(Integer.valueOf(123456), alumno.getDni());
	}
	
	@Test
	public void testAlumnoFull() throws MiCalendarioException, AlumnoException {
		Persona persona;
		Alumno alumno = null;
		try {
			persona = new Persona(12345678,"NombreTest", "ApellidoTEst", new MiCalendar(10,8,1990));
			MiCalendar miCalendario = new MiCalendar();
			alumno = new Alumno(persona, miCalendario,10,8.5);
			System.out.println(alumno.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
*/
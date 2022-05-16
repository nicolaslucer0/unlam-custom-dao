/*import java.util.Calendar;

import Exception.MiCalendarioException;
import Exception.PersonaException;
import Exception.PersonaNombreException;

public class PersonaTest {

	private static final Integer DNITEST = 333333;

	@Test
	public void testPersona() {
		Persona p = new Persona();
		assertNotNull(p);
	}
	
	@Test
	public void TestPersonaDni(){
		Persona p = new Persona(DNITEST);
		assertNotNull(p);
		assertEquals(DNITEST, p.getDni());
	}

	@Test
	public void TestPersonaDniNegativo(){
		Persona p = new Persona();
		try {
			p.setDni(-3);
		} catch (PersonaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestPersonaDniException(){
		Persona p = new Persona();
		try {
			p.setDni(null);
		} catch (PersonaException e) {
			e.printStackTrace();
		}
		assertNotEquals(null, p.getDni());
	}
	
	@Test
	public void TestPersonaNombre(){
		Persona p = new Persona();
		try {
			p.setNombre("Pepe");
			assertEquals("Pepe", p.getNombre());
		} catch (PersonaNombreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void TestSetWrongFecNac(){
		Persona p = new Persona();
		MiCalendar fecNac;
		try {
			fecNac = new MiCalendar(2022, Calendar.APRIL, 33);
			p.setFecNac(fecNac);
		} catch (MiCalendarioException e) {
			e.printStackTrace();
			fail();
		}
		assertEquals(Calendar.getInstance().get(Calendar.YEAR),
				p.getFecNac().get(Calendar.YEAR));
	}
	
}*/

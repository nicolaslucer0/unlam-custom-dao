/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import Class.Alumno;
import DAO.AlumnoDaoTxt;
import DAO.DAO;
import DAO.DAOException;
import Exception.AlumnoException;
import Exception.MiCalendarioException;
import java.util.Calendar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author laboratorios
 */
public class AlumnoDaoTest {
    
    public AlumnoDaoTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @org.junit.jupiter.api.Test
    public void TestCreate() throws AlumnoException, DAOException, MiCalendarioException{
        System.out.println("Create");
        Alumno alumno = new Alumno(112458888, "Nombre","Apellido", new MiCalendar(1 , 4, 2022), null, 10, 7.0);
        DAO dao = new AlumnoDaoTxt("AlumnoDaoTxt");
        dao.create(alumno);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

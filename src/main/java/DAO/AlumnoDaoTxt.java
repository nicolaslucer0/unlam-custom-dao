/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Class.Alumno;
import Class.MiCalendar;
import static Class.Persona.DELIMITADOR;
import Exception.AlumnoException;
import Exception.MiCalendarioException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlumnoDaoTxt extends DAO<Alumno, Integer> {

    private RandomAccessFile raf;

    public AlumnoDaoTxt(String fullPath) throws DAOException {
        File file = new File(fullPath);
        try {
            raf = new RandomAccessFile(file, "rws");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Archivo no encoentrado. " + ex.getMessage());
        }
    }

    @Override
    public void create(Alumno alumno) throws DAOException {
        try {
            if (exist(alumno.getDni())) {
                throw new DAOException("Error, el alumno ya existe, DNI: " + alumno.getDni());
            }
            raf.seek(raf.length());
            raf.writeBytes(alumno.toString() + System.lineSeparator());
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error crear el alumno. " + ex.getMessage());
        }
    }

    @Override
    public Alumno read(Integer pk) throws DAOException {
        try {
            raf.seek(0);
            //recorrer
            String line;
            String[] campos;
            while ((line = raf.readLine()) != null) {
                campos = line.split(DELIMITADOR);
                if (pk.equals(Integer.valueOf(campos[0]))) {
                    try {
                        return buildAlumno(campos);
                    } catch (NumberFormatException e) {
                        throw new DAOException("Error de dato numerico. " + e.getMessage());
                    }
                }
            }
            throw new DAOException("No se encontró el alumno buscado. ");

        } catch (IOException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error de I/O. " + ex.getMessage());
        }
    }

    @Override
    public void update(Alumno entity) throws DAOException {
        try {
            String line;
            String[] campos;
            raf.seek(0);
            while ((line = raf.readLine()) != null) {
                campos = line.split(DELIMITADOR);
                if (Objects.equals(Integer.valueOf(campos[0]), entity.getDni())) {
                    Long puntero = raf.getFilePointer();
                    puntero = puntero - line.length();
                    raf.seek(puntero);
                    raf.writeBytes(entity.toString() + System.lineSeparator());
                }
            }

        } catch (IOException e) {
            throw new DAOException("Error al leer el archivo");
        }

    }

    @Override
    public void hardDelete(Integer pk) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void softDelete(Integer pk) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> findAll(boolean includeDeleted) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() throws DAOException {
        try {
            raf.close();
        } catch (IOException e) {
            throw new DAOException("Error al leer el archivo");
        }
    }

    @Override
    public boolean exist(Integer dni) throws DAOException {
        try {
            raf.seek(0);
            //recorrer
            String line;
            String[] campos;
            while ((line = raf.readLine()) != null) {
                campos = line.split(DELIMITADOR);
                if (dni.equals(Integer.valueOf(campos[0]))) {
                    return true;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error de I/O. " + ex.getMessage());
        }
        return false;
    }

    private MiCalendar getCalendarFromString(String fecha) throws MiCalendarioException {
        String[] fechaSplitted = fecha.split("/");
        Integer dia = Integer.valueOf(fechaSplitted[0]);
        Integer mes = Integer.valueOf(fechaSplitted[0]);
        Integer anio = Integer.valueOf(fechaSplitted[0]);
        return new MiCalendar(anio, mes, dia);
    }

    private Alumno buildAlumno(String[] campos) throws DAOException {
        Alumno alumno;
        Integer dni = Integer.valueOf(campos[0]);
        String nombre = campos[1];
        String apellido = campos[2];
        MiCalendar fecNac;
        MiCalendar fecIng;
        try {
            fecNac = getCalendarFromString(campos[3]);
            fecIng = getCalendarFromString(campos[4]);
        } catch (MiCalendarioException e) {
            throw new DAOException("Error al intentar leer la fecha. " + e.getMessage());
        }
        Integer cantMatAprob = Integer.valueOf(campos[5]);
        Double promedio = Double.valueOf(campos[6]);
        try {
            alumno = new Alumno(dni, nombre, apellido, fecNac, fecIng, cantMatAprob, promedio);
        } catch (AlumnoException e) {
            throw new DAOException("Error al intentar leer la fecha. " + e.getMessage());
        }

        return alumno;
    }
}

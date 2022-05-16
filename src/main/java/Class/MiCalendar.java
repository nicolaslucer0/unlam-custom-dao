/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import Exception.MiCalendarioException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author laboratorios
 */
public class MiCalendar extends GregorianCalendar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MiCalendar() {
		super();
	}
        
        public MiCalendar (String fecha) throws MiCalendarioException {
            fecha.split("/");
        }

	public MiCalendar(int dia, int mes, int anio) throws MiCalendarioException {
		super(anio, mes-1, dia);
		setLenient(false);
		try {
			this.get(Calendar.YEAR);
		} catch (Exception e) {
			throw new MiCalendarioException("La fecha es invalida");
		}
	}
	
	public int getDia(){
		return this.get(Calendar.DAY_OF_MONTH);
	}
	public int getMes(){
		return this.get(Calendar.MONTH)+1;
	}
	public int getAnio(){
		return this.get(Calendar.YEAR);
	}

	@Override
	public String toString() {
		return String.format("%02d/%02d/%04d",
                        this.getDia()
                        ,this.getMes()
                        ,this.getAnio());
	}
}


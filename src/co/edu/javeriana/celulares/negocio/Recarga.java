package co.edu.javeriana.celulares.negocio;
import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * 
 * @author Oscar Castelblanco y Lucas Gnecco
 *
 */

public class Recarga implements Serializable{
	
	/**
	 * Fecha en que se realizo la recarga
	 */
	private GregorianCalendar fechaRecarga;
	
	/**
	 * Valor de la recarga
	 */
	private long valorRecarga;

	
	/**
	 * Retorna la fecha en que se realizo la recarga
	 * @return Fecha de la recarga
	 */
	public GregorianCalendar getFechaRecarga() {
		return fechaRecarga;
	}

	/**
	 * Modifica la fecha de la recarga.
	 * @param fechaRecarga La nueva fecha de la recarga
	 */
	public void setFechaRecarga(GregorianCalendar fechaRecarga) {
		this.fechaRecarga = fechaRecarga;
	}
	
	
	/**
	 * Retorna el valor de la recarga
	 * 
	 * @return El valor de la recarga
	 */
	public long getValorRecarga() {
		return valorRecarga;
	}

	/**
	 * Modifica el valor de la recarga
	 * 
	 * @param valorRecarga De tipo long con el nuevo valor de la recarga.
	 */
	public void setValorRecarga(long valorRecarga) {
		this.valorRecarga = valorRecarga;
	}
	
	

}

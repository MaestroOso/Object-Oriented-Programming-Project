package co.edu.javeriana.celulares.negocio;

import java.io.Serializable;
/**
 * 
 * @author Oscar Castelblanco y Lucas Gnecco
 *
 */

public class ExCliente extends Exception implements Serializable{
	/**
	 * String que contendrá el tipo de error por el cual se ejecutó la excepcion
	 */
	String det;
	
	/**
	 * Constructor de la Excepcion que recibe como parametro el detalle por el cual se ejecuta la excepcion
	 * @param un String que representa el motivo por el cual se realiza la excepcion
	 * @return ninguno
	 */
	public ExCliente(String cad)
	{
		det = "[Cliente]: " +cad;
	}
	
	/**
	 * Metodo de tipo toString que retorna un String con los detalles de la excepcion
	 * @param ninguno
	 * @return un String con los detalles de la excepcion
	 */
	@Override
	public String toString() {
		return det;
	}
	
	

}

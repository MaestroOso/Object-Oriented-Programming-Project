package co.edu.javeriana.celulares.negocio;

import java.io.Serializable;

/**
 * @author Oscar Castelblanco y Lucas Gnecco
 *
 * Clase de tipo enumerado que representa el Tipo de documento de identificacion de un Cliente
 */
public enum TipoId implements Serializable{
	CC, CE, TI;
	
	/**
     * Metodo que se encarga de retornar el enumerado TipoId con su valor
     * 
     * @param un objeto de tipo String que representa una cadena de la cual se quiere saber su valor enumerado
     * @return un TipoId con el TipoId sobre el cual estaba la cadena
     */
	public static TipoId darTipoId(String s)
	{
		if(s.equalsIgnoreCase("cc"))
			return TipoId.CC;

		if(s.equalsIgnoreCase("ce"))
			return TipoId.CE;

		if(s.equalsIgnoreCase("ti"))
			return TipoId.TI;
		
		return null;
	}
}

package co.edu.javeriana.celulares.negocio;

import java.io.Serializable;
import java.util.Comparator;
/**
 * @author Oscar Castelblanco y Lucas Gnecco
 */



public class CompararCedulasClientes implements Comparator, Serializable{

	/**
	 * Compara dos objetos de tipo Cliente por su cedula
	 * @param o1 Objeto que se espera sea de tipo PLan
	 * @param o2 Objeto que se espera sea de tipo Plan
	 * @return un entero indicando que objeto es mayor segun el paramtero deseado
	 */
	public int compare(Object o1, Object o2)
	{
		return (((Cliente)o1).getCedula().compareTo(((Cliente)o2).getCedula()));
	}
}
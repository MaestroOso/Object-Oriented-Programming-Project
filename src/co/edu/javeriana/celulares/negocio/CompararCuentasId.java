package co.edu.javeriana.celulares.negocio;

import java.io.Serializable;
import java.util.Comparator;
/**
 * @author Oscar Castelblanco y Lucas Gnecco
 */



public class CompararCuentasId implements Comparator, Serializable{

	/**
	 * Compara dos objetos de tipo plan por su nombre
	 * Orden alfabetico
	 * 
	 * @param o1 Objeto que se espera sea de tipo PLan
	 * @param o2 Objeto que se espera sea de tipo Plan
	 * @return un entero indicando que objeto es mayor segun el paramtero deseado
	 */
	public int compare(Object o1, Object o2)
	{
		return (int)(((Cuenta)o1).getId() - ((Cuenta)o2).getId());
	}
}
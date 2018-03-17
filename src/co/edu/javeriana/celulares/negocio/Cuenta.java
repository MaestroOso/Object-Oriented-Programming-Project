package co.edu.javeriana.celulares.negocio;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

public abstract class Cuenta implements Serializable{
	
	/**
	 * Numero con el id de la cuenta. Es unico entre todas las cuentas de la empresa.
	 */
	protected long id;
	
	/**
	 * Numero telefonico al cual esta asociado la cuenta.
	 */
	protected String numero;
	
	/**
	 * Objeto de tipo CLiente al cual pertenece la cuenta.
	 */
	private Cliente usuario;
	
	/**
	 * Lista con objetos de tipo LLamada. Aqui se registran todas las llamadas que realice esta cuenta, representada con su numero telefonico y su id.
	 */
	protected List<LLamada> llamadas;
	
	/**
	 * Objeto de tipo Plan al cual pertenece la cuenta.
	 */
	protected Plan plan;
	
	/**
	 * Metodo de tipo abstracto que calcula el pago a realizar por el uso de la cuenta. Este metodo debe ser implementado
	 * por cada una de las clases que hereden de Cuenta.
	 * @param un objeto de tipo GregorianCalendar que representa la fecha para la cual se quiere realizar el calculo del pago
	 * @return un long que representa el pago total a realizar por la cuenta en una fecha especifica
	 */
	public abstract long obtenerPagoCuenta(GregorianCalendar f);
	
	/**
	 * Metodo de tipo abstracto que agrega una Llamada a la cuenta. Este metodo debe ser implementado
	 * por cada una de las clases que hereden de Cuenta.
	 * Retorna una excepcion en caso de haber alguna falla en el proceso
	 * @param un objeto de tipo String que representa el tipo de llamada
	 * @param un objeto de tipo GregorianCalendar que representa la fecha de la llamada
	 * @param un objeto de tipo String que representa el destino de la llamada
	 * @param un objeto de tipo String que representa la duracion de la llamada
	 * @param un objeto de tipo Indicativo que representa la zona a la cual se está realizando la llamada
	 * @return un long que representa el pago total a realizar por la cuenta en una fecha especifica
	 */
	public abstract String agregarLLamada(String tipo, GregorianCalendar fecha, String destino, String duracion, Indicativo ind) throws ExLLamada, ExCuenta;

	
	/**
	 * Retorna el usuario al que pertenece la cuenta. Este es de tipo Cliente
	 * 
	 * @return EL objeto Cliente en cuya lista de cuentas esta esta cuenta
	 */
	public Cliente getUsuario() {
		return usuario;
	}

	/**
	 * Modifica el usuario de esta cuenta. Usuario es de tipo Cliente.
	 *  
	 * @param usuario El objeto de tipo Cliente al que pertenece esta cuenta.
	 */
	public void setUsuario(Cliente usuario) {
		this.usuario = usuario;
	}
	
	

	/**
	 * Retorna el objeto Plan del cual es esta cuenta.
	 * 
	 * @return El plan al cual pertenece esta cuenta
	 */
	public Plan getPlan() {
		return plan;
	}

	/**
	 * Modifica el plan al que pertenece la cuenta. plan es de tipo PlanPrepago
	 * 
	 * @param plan
	 */
	public void setPlan(Plan plan) {
		this.plan = plan;
	}


	/**
	 * Retorna el id de esta cuenta. Es de tipo long
	 * @return
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Modifica el id de la cuenta. El parametro id es de tipo long
	 * 
	 * @param id El nuevo id de la cuenta
	 */
	public void setId(long id) {
		this.id= id;
	}

	/**
	 * Retorna el numero al que esta asociada la cuenta. Es de tipo long
	 * 
	 * @return El numero telefonico de la cuenta
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Modifica el numero telefonico de la cuenta
	 * 
	 * @param numero De tipo long
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Retorna la lista de llamadas de la cuenta.
	 * 
	 * @return La lista de llamadas de tipo List(LLamada)
	 */
	public List<LLamada> getLlamadas() {
		return llamadas;
	}

	/**
	 * Modifica la lista de llamadas de la cuenta. Recibe como parametro la nueva lista de llamadas
	 * 
	 * @param llamadas De tipo List(LLamada)
	 */
	public void setLlamadas(List<LLamada> llamadas) {
		this.llamadas = llamadas;
	}

	/**
	 * Metodo de tipo toString que retorna un string con la informacion principal de la cuenta
	 * 
	 * @param ninguno
	 * @return un objeto de tipo String con la informacion de la cuenta
	 */
	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", numero=" + numero + ", llamadas="
				+ llamadas + "]";
	}
	
	

}

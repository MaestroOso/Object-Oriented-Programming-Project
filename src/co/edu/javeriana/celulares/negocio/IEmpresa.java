package co.edu.javeriana.celulares.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import co.edu.javeriana.celulares.presentacion.Utils;



public interface IEmpresa extends Serializable{
	
	
	/**
	 * Retorna un String para ser mostrado en pantalla con las cuentas que tiene la empresa. 
	 * Puede mostrar las prepago, postpago o ambas, dependiendo de lo que se introduuzca en el parametro cuales.
	 * (pre, post, prepost)
	 */
	public List<Cuenta> mostrarCuentas(String cuales);
	
	/**
	 * Inserta un cliente en la lista de clientes de la empresa. Los datos del cliente pasan en objetos String, mas no en un objeto cliente.
	 * Si la cedula ingresada ya esta registrada retorna un mensaje de error. Si logra ingresar al cliente retorna un mensaje de exito.
	 * 
	 */
	public void agregarCliente(String nombre, String ced, String dir, String tipo) throws ExCliente;


	/**
	 * Inserta un plan prepago en la lista de planes prepago de la empresa. Los datos del plan pasan en objetos String.
	 * Si el nombre ingresado ya esta registrado retorna un mensaje de error. Si logra ingresar el plan retorna un mensaje de exito.
	 */
	public void agregarPlanPre(String nombre, String valor) throws ExPlan;


	/**
	 * Inserta un plan postpago en la lista de planes postpago de la empresa. Los datos del plan pasan en objetos String.
	 * Si el nombre ingresado ya esta registrado retorna un mensaje de error. Si logra ingresar el plan retorna un mensaje de exito.
	 * 
	 */
	public void agregarPlanPost(String nombre, String valor, String numMin, String valorMinAd) throws ExPlan;	

	
	/**
	 * Retorna toda la informacion de los planes prepago de la empresa para ser mostrado en la interface.
	 * Si no hay planes, retorna la cadena vacia.
	 */
	public List<PlanPrepago> mostrarPlanesPre();
	
	/**
	 * Retorna toda la informacion de los planes postpago de la empresa para ser mostrado en la interface.
	 * Si no hay planes, retorna la cadena vacia.
	 */
	public List<PlanPostpago> mostrarPlanesPost();
	
	/**
	 * Retorna la informacion de todos los clientes de la empresa para ser mostrado en la interface.
	 * Si no hay clientes, retorna la cadena vacia.
	 */
	public List<Cliente> mostrarClientes();
	
	/**
	 * Retorna la informacion de todos los clientes de la empresa para ser mostrado en la interface.
	 * Si no hay clientes, retorna la cadena vacia.
	 */
	public List<Cliente> mostrarClientesPre();
	
	/**
	 * Retorna la informacion de todos los clientes de la empresa para ser mostrado en la interface.
	 * Si no hay clientes, retorna la cadena vacia.
	 */
	public List<Cliente> mostrarClientesPos();

	/**
	 * Agrega una cuenta nueva de cualquiera de los dos tipos, dependiendo de los que diga el paramtro tipo (PRE o POST).
	 * Busca si la cuenta existe, si el clinete con dicha cedula existe y si el plan al que se quiere asociar existe. Solo si todo existe se agrega la cuenta.
	 * El encargado de crear la cuenta es el plan mismo, y este a su vez le retorna la cuenta al cliente para que este la agruege en su lista.
	 * De esta manera la cuenta queda asociada y almacenada en un plan y en un cliente. 
	 */
	public String agregarCuenta(String tipo, String nombre, String ced, String num) throws ExCliente, ExPlan, ExCuenta;
	
	/**
	 * Registra una llamada en la cuenta con el id indicado si la encuentra. El metodo funciona tanto para cuentas prepago como para postpago pues hace uso del metodo buscarCuentaId, que retorna un Object.
	 * 
	 */
	public String registrarLLamada(String tipo, String id, GregorianCalendar fecha, String destino, String duracion, Indicativo ind) throws ExLLamada, ExCuenta ;
	
	
	/**
	 * Registra una recarga. A partir de un id busca la cuenta y le pasa toda ls informacion a la cuenta para que registre la recarga.
	 * 
	 */
	public String registrarRecarga(String id, GregorianCalendar fecha, String valorr);
	
	
	/**
	 * Genera un string con el reporte de fin de mes de los planes postpago. Este reporte muestra todas las cuentas de todos los clientes que estes suscritos a un plan postpago, con los respectivos gastos
	 * y duraciones.
	 */
	public String reporteFinMesPost();


	/**
	 * Genera un string con el reporte de fin de mes de los planes prepago. Este reporte muestra todas las cuentas de todos los clientes que estes suscritos a un plan prepago, con los respectivos gastos
	 * y duraciones.
	 */
	public String reporteFinMesPre();
	
	/**
	 * Retorna una lista con todos los planes que hay
	 * 
	 * @param ninguno
	 * @return Un objeto de tipo List con los planes que se tienen
	 */
	public List<Plan> getPlanes();

	/**
	 * Modifica la lista de planes que se tienen
	 *  
	 * @param Un objeto de tipo List con los planes
	 * @return ninguno
	 */
	public void setPlanes(List<Plan> planes);
	
	/**
	 * Retorna una mapa que esta ordenado por las cedulas de los clientes y tiene objetos de tipo
	 * cliente que hacen parte de la iempresa
	 * 
	 * @param ninguno
	 * @return Un objeto de tipo mapa con los clientes que se tienen
	 */
	public Map<String, Cliente> getClientes();
	

	/**
	 * Modifica el mapa de clientes que tiene la iempresa
	 *  
	 * @param Un objeto de tipo Map con los clientes
	 */
	public void setClientes(Map<String, Cliente> clientes);
	
	/**
	 * Dado un id busca si alguna cuenta esta registrada con dicho id. El atributo num se recibe como un String.
	 * Se busca la cuenta en ambas listas, tanto las prepago como las postpago y se retorna de ser encontrada. Por eso el tipo de retorno es de tipo Object, y es necesario que cualquier metodo que
	 * use esta busqueda verifique de que tipo es el objeto devuelto.
	 * 
	 * @param num String con el id.
	 * @return Un Object con la cuenta asociada a dicho id o null.
	 */
	public Cuenta buscarCuentaId(String num);
	
	
	/**
	 * 
	 * Busca en el mapa de clientes el Id mas alto en el cual se ha registrado uno de ellos. Este metodo se utiliza en 
	 * la carga de la iempresa para poder seguir enumerando los clientes por Id´s consecutivos, sin repetir los previamente
	 * existentes
	 * 
	 * @param ninguno
	 * @return un entero que representa el Id mas alto encontrado o 0 si no hay ningun cliente en la iempresa
	 */
	public int getIdMasAlto();
	
	//public String reportePorCuenta();
	
	
}

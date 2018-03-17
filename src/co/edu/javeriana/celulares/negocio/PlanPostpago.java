package co.edu.javeriana.celulares.negocio;
import java.util.*;
/**
 * 
 * @author Oscar Castelblanco y Lucas Gnecco
 *
 */

public class PlanPostpago extends Plan{
	
	/**
	 * Los minutos que tiene el cliente contemplaos dentro del plan sin pagar una tarifa extra
	 */
	private long numeroMinutos;
	
	/**
	 * Valor del minuto luego de pasarse de la cantidad acordada en el plan
	 */
	private long valorMinutoAdicional;
	
	/**
	 * Lista de cuentas que pertenecen a este plan
	 */
	private List<CuentaPostpago> cuentas;
	
	
	/**
	 * Constructos que instancia la lista de cuentas del plan.
	 */
	public PlanPostpago(long valor, String nom, long numMin, long valorMinAd)
	{
		super(valor, nom);
		this.numeroMinutos = numMin;
		this.valorMinutoAdicional = valorMinAd;
		cuentas = new ArrayList<CuentaPostpago>();
	}
	
	
	/**
	 * Retorna el numero de minutos que tiene el plan.
	 * 
	 * @return el numero de minutos del plan
	 */
	public long getNumeroMinutos() {
		return numeroMinutos;
	}
	
	/**
	 * Modifica el numero de minutos del plan
	 * 
	 * @param numeroMinutos De tipo long con el nuevo numero de minutos del plan
	 */
	public void setNumeroMinutos(long numeroMinutos) {
		this.numeroMinutos = numeroMinutos;
	}
	
	/**
	 * Retorna el valor de un minuto una vez exedido el numero de minutos estandar del plan
	 * 
	 * @return Valor de los minutos adicionales
	 */
	public long getValorMinutoAdicional() {
		return valorMinutoAdicional;
	}
	
	/**
	 * Modifica el valor de los minutos adicionales
	 * @param valorMinutoAdicional De tipo lon con el nuevo valor de los minutos adicionales
	 */
	public void setValorMinutoAdicional(long valorMinutoAdicional) {
		this.valorMinutoAdicional = valorMinutoAdicional;
	}
	
	/**
	 * Retorna la lista con las cuentas asociadas al plan.
	 * 
	 * @return Lista de cuentas que perteneces a este plan
	 */
	public List<CuentaPostpago> getCuentas() {
		return cuentas;
	}
	
	/**
	 * Modifica la lista de cuentas asociadas al plan
	 * 
	 * @param cuentas De tipo List(CuentaPostpago) con las nuevas cuentas asociadas al plan
	 */
	public void setCuentas(List<CuentaPostpago> cuentas) {
		this.cuentas = cuentas;
	}
	
	
	/**
	 * Recibe el numero al cual se va a asociar una cuenta, la crea y la agruega en la lista de cuentas.
	 * Adem�s retorna la cuenta creada para poder ser utilizada una vez creada.
	 * 
	 * @param num El numero telefonico de la cuenta
	 * @return La cuenta creada.
	 */
	public CuentaPostpago agregarCuenta(String num)
	{
		CuentaPostpago c = new CuentaPostpago(this);
		c.setNumero(num);
		cuentas.add(c);
		return c;
		
	}
	
	
	
	/**
	 * Retorna un String con los id y los numeros de todas las cuentas asociadas a este plan para ser mostrado por pantalla en el Test.
	 * 
	 * 
	 * @return String  con la informacionde las cuentas
	 */
	public String mostrarCuentasPost()
	{
		String r = "";
		if(!cuentas.isEmpty())
		{
			CuentaPostpago p;
			ListIterator<CuentaPostpago> it = cuentas.listIterator(0);
			while(it.hasNext())
			{
				p = it.next();
				r = r.concat(p.getId() + "\t " + p.getNumero() + "\n");
			}
		}
		return r;
	}
	
	
}

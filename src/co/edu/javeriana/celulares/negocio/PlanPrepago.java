package co.edu.javeriana.celulares.negocio;
import java.io.Serializable;
import java.util.*;

/**
 * 
 * @author Oscar Castelblanco y Lucas Gnecco
 *
 */

public class PlanPrepago extends Plan implements Serializable{
	

	
	/**
	 * Lista de cuentas que pertenecen a este plan
	 */
	private List<CuentaPrepago> cuentas;
	
	
	/**
	 * Constructos que instancia la lista de cuentas del plan.
	 */

	public PlanPrepago(long valor, String nom)
	{
		super(valor, nom);
		cuentas = new ArrayList<CuentaPrepago>();
	}
	
	
	
	/**
	 * Retorna la lista con las cuentas asociadas al plan.
	 * 
	 * @return Lista de cuentas que perteneces a este plan
	 */
	public List<CuentaPrepago> getCuentas() {
		return cuentas;
	}

	/**
	 * Modifica la lista de cuentas asociadas al plan
	 * 
	 * @param cuentas De tipo List(CuentaPostpago) con las nuevas cuentas asociadas al plan
	 */
	public void setCuentas(List<CuentaPrepago> cuentas) {
		this.cuentas = cuentas;
	}

	
	/**
	 * Recibe el numero al cual se va a asociar una cuenta, la crea y la agruega en la lista de cuentas.
	 * Adem�s retorna la cuenta creada para poder ser utilizada una vez creada.
	 * 
	 * @param num El numero telefonico de la cuenta
	 * @return La cuenta creada.
	 */
	public CuentaPrepago agregarCuenta(String num)
	{
		
		CuentaPrepago c = new CuentaPrepago(this);
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
	public String mostrarCuentasPre()
	{
		String r = "";
		if(!cuentas.isEmpty())
		{
			CuentaPrepago p;
			ListIterator<CuentaPrepago> it = cuentas.listIterator(0);
			while(it.hasNext())
			{
				p = it.next();
				r = r.concat(p.getId() + "\t " + p.getNumero() + "\n");
			}
		}
		return r;
	}
	
	
	
}

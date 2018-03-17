package co.edu.javeriana.celulares.negocio;
import java.util.*;

import co.edu.javeriana.celulares.presentacion.Utils;

/**
 * 
 * @author Oscar Castelblanco y Lucas Gnecco
 *
 */

public class CuentaPrepago extends Cuenta{
	
	
	
	/**
	 * Lista con objetos de tipo Recarga. Aqui se registran todas las recargas que realice esta cuenta, representada con su numero telefonico y su id.
	 */
	private List<Recarga> recargas;
	
	
	
	
	/**
	 * Constructor de un objeto CuentaPrepago que inicializa sus respectivas listas y le asigna un id unico a la cuenta usando CONSECUTIVO, de la clase utilitaria UTILS.
	 * Recibe el parametro pl de tipo PlanPrepago. Esto se debe a que el plan va a crear la cuenta, y como esta le pertencese este mismo se pasa a la cuenta.
	 * 
	 * @param pl El PlanPrepago al cual pertenece la cuenta
	 */
	public CuentaPrepago(PlanPrepago pl)
	{
		this.plan = pl;
		Utils.CONSECUTIVO ++;
		this.id = Utils.CONSECUTIVO;
		this.llamadas = new ArrayList<LLamada>();
		this.recargas = new ArrayList<Recarga>();
	}
	



	/**
	 * Retorna la lista de recargas de la cuenta.
	 * 
	 * @return La lista de recargas de tipo List(Recarga)
	 */
	public List<Recarga> getRecargas() {
		return recargas;
	}
	
	
	/**
	 * Modifica la lista de recargas de la cuenta. Recibe como parametro la nueva lista de recargas
	 * 
	 * @param recargas De tipo List(Recarga)
	 */
	public void setRecargas(List<Recarga> recargas) {
		this.recargas = recargas;
	}

	/**
	 * Retorna un long con saldo de cuenta hasta el momento, es decir la suma de todas las recargas hechas.
	 * 
	 * @return El saldo de la cuenta.
	 */
	public long saldo(GregorianCalendar g)
	{
		Recarga re = new Recarga();
		
		long r =0;
		if (! this.recargas.isEmpty())
		{
			
			ListIterator<Recarga> it = this.recargas.listIterator(0);
			while(it.hasNext())
			{
				re = it.next();
				if(g.compareTo(re.getFechaRecarga()) >= 0)
					r += re.getValorRecarga();
			}
			
		}
		if (! this.llamadas.isEmpty())
		{
			LLamada ll;
			ListIterator<LLamada> itl = this.llamadas.listIterator(0);
			while(itl.hasNext())
			{
				ll = itl.next();
				if(g.compareTo(ll.getFecha()) >= 0)
					r -= re.getValorRecarga();
			}
			
		}
		return r;
	}
	
	
	
	/**
	 * Agrega una llamada en la lista de llamadas de esta cuenta si tiene el saldo disponible.
	 * 
	 * @param fecha Objeto GregorianCalendar con la fecha en la que se realiza la llamada
	 * @param destino EL numero de destino de la llamada
	 * @param duracion Los minutos que se duro la llamada
	 * @return Un mensaje representativo del estado final de la operacion y el valor de la llamada.
	 */
	public String agregarLLamada(String tipo, GregorianCalendar fecha, String destino, String duracion, Indicativo ind) throws ExLLamada, ExCuenta
	{
		
		if(tipo.equalsIgnoreCase("NACIONAL"))
		{
			LLamadaNacional ll = new LLamadaNacional(destino, fecha, Long.parseLong(duracion), this);
			if(this.saldo(fecha) >= ll.getValor())
			{
				this.llamadas.add(ll);
				return "LLamada agregada. Valor: " + ll.getValor();
			
			}
			else
				throw (new ExCuenta("Saldo Insuficiente"));
		}
		else
		{
			if(tipo.equalsIgnoreCase("INTERNACIONAL"))
			{
				LLamadaInternacional ll = new LLamadaInternacional(ind.getValue() + "-" + destino, fecha, Long.parseLong(duracion), this, ind);
				if(ll.getIndicativo() == null)
					throw (new ExLLamada("Indicativo incorrecto"));
				if(this.saldo(fecha) >= ll.getValor())
				{
					this.llamadas.add(ll);
					return "LLamada agregada. Valor: " + ll.getValor();
				
				}
				else
					throw (new ExCuenta("Saldo Insuficiente"));
			}
			else
			{
				return "Tipo incorrecto";
			}
		}
		
	}

	
	
	/**
	 * Agrega una recarga a la lista de recargas de la cuenta.
	 * 
	 * @param fecha Objeto GregorianCalendar con la fecha en que se hizo la recarga
	 * @param valorr El valor de la recarga
	 * @return
	 */
	public String agregarRecarga(GregorianCalendar fecha, String valorr)
	{

		Recarga r = new Recarga();
		r.setFechaRecarga(fecha);
		r.setValorRecarga((long)Integer.parseInt(valorr));
		this.recargas.add(r);
		return "Recarga agregada";
	}


	/**
	 * Metodo que calcula el pago a realizar por el uso de la cuenta. 
	 * 
	 * @param un objeto de tipo GregorianCalendar que representa la fecha para la cual se quiere realizar el calculo del pago
	 * @return un long que representa el pago total a realizar por la cuenta en una fecha especifica
	 */
	public long obtenerPagoCuenta(GregorianCalendar f)
	{
		long gasto = 0;
		ListIterator<Recarga> it = this.recargas.listIterator();
		Recarga r;
		while(it.hasNext())
		{
			r = it.next();
			if(r.getFechaRecarga().get(Calendar.MONTH) == f.get(Calendar.MONTH) && r.getFechaRecarga().get(Calendar.YEAR) == f.get(Calendar.YEAR))
				gasto += r.getValorRecarga();
		}
		return gasto;
		
	}
	
	/**
	 * Metodo que calcula el total de minutos usados en una fecha especifica por parte de la cuenta dependiendo de las 
	 * llamadas realizadas
	 * 
	 * @param un objeto de tipo GregorianCalendar que representa la fecha para la cual se quiere realizar el calculo del uso de minutos usados
	 * @return un long que representa el numero total de minutos usados
	 */
	public long totalGastoMinutos(GregorianCalendar f)
	{
		long r =0;
		if (! this.llamadas.isEmpty())
		{
			LLamada ll;
			ListIterator<LLamada> it = this.llamadas.listIterator(0);
			while(it.hasNext())
			{
				ll = it.next();
				if (ll.getFecha().get(Calendar.MONTH) == f.get(Calendar.MONTH) && ll.getFecha().get(Calendar.YEAR) == f.get(Calendar.YEAR) )
					r += ll.getDuracion();
			}
			
		}
		return r;
	}

}

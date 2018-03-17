package co.edu.javeriana.celulares.negocio;

import java.util.*;

import co.edu.javeriana.celulares.presentacion.Utils;

/**
 * 
 * @author Oscar Castelblanco y Lucas Gnecco
 *
 */
	
public class CuentaPostpago extends Cuenta{

	
	
	/**
	 * Objeto GregorianCalendar que registra el momento donde el cliente excede los minutos contemplados en el plan.
	 * A partir de esta fecha se le cobra un recargo por cada minuto que consuma
	 */
	private GregorianCalendar fechaMinutosAdicionales;

	


	
	/**
	 * Constructor de un objeto CuentaPostpago que inicializa sus respectivas listas y le asigna un id unico a la cuenta usando CONSECUTIVO, de la clase utilitaria UTILS.
	 * Recibe el parametro pl de tipo PlanPostpago. Esto se debe a que el plan va a crear la cuenta, y como esta le pertencese este mismo se pasa a la cuenta.
	 * 
	 * @param pl El PlanPostpago al cual pertenece la cuenta
	 */
	public CuentaPostpago(PlanPostpago pl)
	{
		this.plan = pl;
		Utils.CONSECUTIVO ++;
		this.id = Utils.CONSECUTIVO;
		this.llamadas = new ArrayList<LLamada>();
		this.fechaMinutosAdicionales = null;
	}
	
	
	
	






	

	

	/**
	 * Retorna el objeto GregorianCalendar donde se almacena la fecha desde la cual se cobran los minutos con la nueva tarifa.
	 * Se establece este atributo cuando el total de minutos consumidos sobrepasa los estipulados en el plan, de lo contrario permanece en null.
	 * 
	 * @return El objeto Gregorian Calendar con la fecha donde se sobrepasaaron los minutos que tenia el plan, o null si aun no se han sobrepasado
	 */
	public GregorianCalendar getFechaMinutosAdicionales() {
		return fechaMinutosAdicionales;
	}

	/**
	 * Modifica la fecha desde la cual se empieza a cobrar la tarifa de minutos adicionales.
	 * Parametro fechaMinutosAdicionales es de tipo GregorianCalendar.
	 * 
	 * @param fechaMinutosAdicionales
	 */
	public void setFechaMinutosAdicionales(GregorianCalendar fechaMinutosAdicionales) {
		this.fechaMinutosAdicionales = fechaMinutosAdicionales;
	}
	
	
	/**
	 * Retorna un long con el total de minutos consumidos en esta cuenta hasta el momento.
	 * 
	 * @return Los minutos consumidos hasta el momento por el usuario con esta cuenta
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


	/**
	 * Agrega una llamada en la lista de llamadas de esta cuenta. Revisa el gasto hasta el momento de minutos, y si excede lo acordado en el plan modifica el atributo fechaMinutosAdicionales.
	 * A partir de ahi las llamadas se cobran con la nueva tarifa.
	 * 
	 * @param un objeto de tipo String que representa el tipo de llamada
	 * @param un objeto de tipo GregorianCalendar que representa la fecha de la llamada
	 * @param un objeto de tipo String que representa el destino de la llamada
	 * @param un objeto de tipo String que representa la duracion de la llamada
	 * @param un objeto de tipo Indicativo que representa la zona a la cual se está realizando la llamada
	 * @return Un mensaje representativo del estado final de la operacion y el valor de la llamada.
	 */
	public String agregarLLamada(String tipo, GregorianCalendar fecha, String destino, String duracion, Indicativo ind) throws ExLLamada
	{
		GregorianCalendar f = new GregorianCalendar();

		if(this.fechaMinutosAdicionales == null)
		{
			PlanPostpago po = (PlanPostpago)this.getPlan();
			if(this.totalGastoMinutos(f) + (long)Integer.parseInt(duracion) >= po.getNumeroMinutos())
			{
				this.setFechaMinutosAdicionales(fecha);
			}

		}

		if(tipo.equalsIgnoreCase("NACIONAL"))
		{
			LLamadaNacional ll = new LLamadaNacional(destino, fecha, Long.parseLong(duracion), this);

			this.llamadas.add(ll);
			return "LLamada agregada. Valor: " + ll.getValor() + "\nDestino: " + ll.getTelefonoDestinatario();


		}
		else
		{
			if(tipo.equalsIgnoreCase("INTERNACIONAL"))
			{
				LLamadaInternacional ll = new LLamadaInternacional(ind.getValue() + "-" + destino, fecha, Long.parseLong(duracion), this, ind);
				if(ll.getIndicativo() == null)
					throw (new ExLLamada("Indicativo incorrecto"));
				this.llamadas.add(ll);
				return "LLamada agregada. Valor: " + ll.getValor() +  "\nDestino: " + ll.getTelefonoDestinatario();

			}
			else
			{
				return "Tipo incorrecto";
			}
		}
		
	}	
	
	
	/**
	 * Metodo que calcula el pago a realizar por el uso de la cuenta.
	 * 
	 * @param un objeto de tipo GregorianCalendar que representa la fecha para la cual se quiere realizar el calculo del pago
	 * @return un long que representa el pago total a realizar por la cuenta en una fecha especifica
	 */
	public long obtenerPagoCuenta(GregorianCalendar f)
	{
		long gasto = this.totalGastoMinutos(f);
		PlanPostpago p = (PlanPostpago)this.plan;
		if (gasto <= p.getNumeroMinutos())
		{
			return p.getNumeroMinutos() * p.getValorMinuto();
		}
		
		gasto = 0;
		LLamada ll;
		ListIterator<LLamada> it = this.llamadas.listIterator();
		while(it.hasNext())
		{
			ll = it.next();
			if(ll.getFecha().get(Calendar.MONTH) == f.get(Calendar.MONTH) && ll.getFecha().get(Calendar.YEAR) == f.get(Calendar.YEAR))
				gasto += ll.getValor();
		}
		return gasto;
		
	}
	
	
}

package co.edu.javeriana.celulares.negocio;
import java.util.*;

import co.edu.javeriana.celulares.presentacion.Utils;

/**
 * 
 * @author Oscar Castelblanco y Lucas Gnecco
 *
 */

public class Empresa implements IEmpresa{
	
	/**
	 * Lista de planes que tiene una empresa
	 */
	private List<Plan> planes;
	
	
	/**
	 * Mapa de clientes que tiene una empresa. La llave del mapa es un String con la cedula del cliente y el objeto
	 * es un objeto de tipo Cliente
	 */
	private Map<String, Cliente> clientes;

	/**
	 * Retorna una lista con todos los planes que hay en la empresa
	 * 
	 * @return Un objeto de tipo List con los planes que tiene la empresa
	 */
	public List<Plan> getPlanes() {
		return planes;
	}


	/**
	 * Modifica la lista de planes que tiene la empresa
	 *  
	 * @param Un objeto de tipo List con los planes
	 */
	public void setPlanes(List<Plan> planes) {
		this.planes = planes;
	}


	/**
	 * Retorna una mapa que esta ordenado por las cedulas de los clientes y tiene objetos de tipo
	 * cliente que hacen parte de la empresa
	 * 
	 * @return Un objeto de tipo mapa con los clientes que tiene la empresa
	 */
	public Map<String, Cliente> getClientes() {
		return clientes;
	}

	/**
	 * Modifica el mapa de clientes que tiene la empresa
	 *  
	 * @param Un objeto de tipo Map con los clientes
	 */
	public void setClientes(Map<String, Cliente> clientes) {
		this.clientes = clientes;
	}


	/**
	 * Constructos que al crear una empresa le asigna memoria a las diferentes listas que contiene el objeto Empresa, 
	 * implementandolos como objetos de tipo ArrayList.
	 * 
	 * @param Ninguno
	 * @return Nada 
	 * 
	 */
	public Empresa()
	{
		clientes = new HashMap<String, Cliente>();
		planes  = new ArrayList<Plan>();
		
	}
	
	

	/**
	 * 
	 * Busca en la lista de planes  de la empresa a un plan con el mismo nombre que se ingresa. De no encontrarlo retorna null.
	 * 
	 * @param nom String con el nombre del plan que se quiere buscar.
	 * @return El plan que se estaba buscando (por referencia) o null de no encontrarlo
	 */

	public Plan buscarPlan(String nom)
	{
		Plan p;
		if (planes != null)
		{
			ListIterator<Plan> it = planes.listIterator(0);
			while(it.hasNext())
			{
				p = it.next();
				if(p.getNombre().equalsIgnoreCase(nom))
				{
					return p;

				}
			}

			return null;
		}
		else
		{
			return null;
		}
	}


	
	
	



	

	/**
	 * Inserta un cliente en la lista de clientes de la empresa. Los datos del cliente pasan en objetos String, mas no en un objeto cliente.
	 * Si la cedula ingresada ya esta registrada retorna un mensaje de error. Si logra ingresar al cliente retorna un mensaje de exito.
	 * 
	 * @param nombre String con el nombre del cliente a ingresar.
	 * @param ced String con la cedula del cliente a ingresar.
	 * @param dir String con la direccion del cliente a ingresar.
	 * @return Un String con un mensaje representativo del resultado de la operacion.
	 */
	public void agregarCliente(String nombre, String ced, String dir, String tipo) throws ExCliente
	{
		if(!clientes.isEmpty())
		{
			if(clientes.containsKey(ced))
				throw (new ExCliente("Cedula " + ced + " ya registrada"));
		}

		try{
			clientes.put(ced, new Cliente(nombre, ced, dir, tipo));
		}catch(ExCliente e)
		{
			throw e;
		}
		

		
		
	}




	/**
	 * Inserta un plan prepago en la lista de planes prepago de la empresa. Los datos del plan pasan en objetos String.
	 * Si el nombre ingresado ya esta registrado retorna un mensaje de error. Si logra ingresar el plan retorna un mensaje de exito.
	 * 
	 * @param nombre String con el nombre del plan a ingresar.
	 * @param valor String con el valor del minuto para el plan. Se convertira luego en long
	 * @return Un String con un mensaje representativo del resultado de la operacion.
	 */
	public void agregarPlanPre(String nombre, String valor) throws ExPlan{

		
			Plan a = buscarPlan(nombre);

			if (a == null || (a != null && a instanceof PlanPostpago))
			{	
				PlanPrepago p = new PlanPrepago(Long.parseLong(valor), nombre);
				planes.add(p);
				

			}
			else
			{
				throw (new ExPlan("Plan prepago repetido"));
			}		
		
		
		
	}



	/**
	 * Inserta un plan postpago en la lista de planes postpago de la empresa. Los datos del plan pasan en objetos String.
	 * Si el nombre ingresado ya esta registrado retorna un mensaje de error. Si logra ingresar el plan retorna un mensaje de exito.
	 * 
	 * @param nombre String con el nombre del plan a ingresar.
	 * @param valor String con el valor del minuto para el plan. Se convertira luego en long
	 * @param numMin String con el numero de minutos que tiene el plan. Se convertira luego en long
	 * @param valorMinAd String con el valor de un minuto adicional, es decir el precio del minuto si se excede la cantidad de minutos que tiene el plan. Se convertira luego en long
	 * @return Un String con un mensaje representativo del resultado de la operacion.
	 */
	public void agregarPlanPost(String nombre, String valor, String numMin, String valorMinAd) throws ExPlan{

		Plan a = buscarPlan(nombre);

		if (a == null || (a != null && a instanceof PlanPrepago))
		{	

				PlanPostpago p = new PlanPostpago(Long.parseLong(valor), nombre, Long.parseLong(numMin), Long.parseLong(valorMinAd));
		
				
				planes.add(p);
				

			}
			else
			{
				throw (new ExPlan("Plan postpago repetido"));
			}		
		}
	


	
	/**
	 * Retorna toda la informacion de los planes prepago de la empresa para ser mostrado en la interface.
	 * Si no hay planes, retorna la cadena vacia.
	 * 
	 * @return Un String con toda la informacion de todos los planes prepago de la empresa.
	 */
	public List<PlanPrepago> mostrarPlanesPre()
	{
		String r = new String();
		
		Plan p;
		if (planes != null)
		{
			r = r.concat("#PLANES PREPAGO\n" + "#Nombre ------ ValorMinuto\n");
			ListIterator<Plan> it = planes.listIterator(0);
			List<PlanPrepago> li = new ArrayList<PlanPrepago>();
			while(it.hasNext())
			{
				p = it.next();
				if(p instanceof PlanPrepago)
					li.add((PlanPrepago)p);
				
			}
			
			Collections.sort(li, new CompararNombresPlan());
			return li;
		}
		else
		{
			return null;
		}
	}
	
	
	
	/**
	 * Retorna toda la informacion de los planes postpago de la empresa para ser mostrado en la interface.
	 * Si no hay planes, retorna la cadena vacia.
	 * 
	 * @return Un String con toda la informacion de todos los planes postpago de la empresa.
	 */
	public List<PlanPostpago> mostrarPlanesPost()
	{
		Plan p;
		if (planes != null)
		{
			ListIterator<Plan> it = planes.listIterator(0);
			List<PlanPostpago> li = new ArrayList<PlanPostpago>();
			while(it.hasNext())
			{
				p = it.next();
				if(p instanceof PlanPostpago)
					li.add((PlanPostpago)p);
				
			}
			
			Collections.sort(li, new CompararNombresPlan());
			
			return li;
		}
		else
		{
			return null;
		}
	}
	
	
	
	/**
	 * Retorna la informacion de todos los clientes de la empresa para ser mostrado en la interface.
	 * Si no hay clientes, retorna la cadena vacia.
	 * 
	 * @return Un String con toda la informacion de todos los clientes de la empresa.
	 */
	public List<Cliente> mostrarClientes()
	{
		Cliente p;
		if (! clientes.isEmpty())
		{
			
			Set<String> ll = clientes.keySet();
			List<String> li = new ArrayList<String>(ll);
			Collections.sort(li);
			ListIterator<String> it = li.listIterator();
			List<Cliente> cc = new ArrayList<Cliente>();
			while(it.hasNext())
			{
				p = clientes.get(it.next());
				cc.add(p);
				
			}
			//Collections.sort(cc, new CompararCedulasClientes());
			return cc;
		}
		else
		{
			return null;
		}
	}
	
	
	/**
	 * Retorna la informacion de todos los clientes de la empresa para ser mostrado en la interface.
	 * Si no hay clientes, retorna la cadena vacia.
	 * 
	 * @return Un String con toda la informacion de todos los clientes de la empresa.
	 */
	public List<Cliente> mostrarClientesPos()
	{
		Cliente p;
		if (! clientes.isEmpty())
		{
			Set<String> ll = clientes.keySet();
			List<String> li = new ArrayList<String>(ll);
			Collections.sort(li);
			ListIterator<String> it = li.listIterator();
			List<Cliente> cc = new ArrayList<Cliente>();
			while(it.hasNext())
			{
				p = clientes.get(it.next());
				if(p.tienePost())
					cc.add(p);
				
			}
			Collections.sort(cc, new CompararCedulasClientes());
			return cc;
		}
		else
		{
			return null;
		}
	}
	
	
	/**
	 * Retorna la informacion de todos los clientes de la empresa para ser mostrado en la interface.
	 * Si no hay clientes, retorna la cadena vacia.
	 * 
	 * @return Un String con toda la informacion de todos los clientes de la empresa.
	 */
	public List<Cliente> mostrarClientesPre()
	{
		Cliente p;
		if (! clientes.isEmpty())
		{
			Set<String> ll = clientes.keySet();
			List<String> li = new ArrayList<String>(ll);
			Collections.sort(li);
			ListIterator<String> it = li.listIterator();
			List<Cliente> cc = new ArrayList<Cliente>();
			while(it.hasNext())
			{
				p = clientes.get(it.next());
				if(p.tienePre())
					cc.add(p);
				
			}
			Collections.sort(cc, new CompararCedulasClientes());
			return cc;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Dado un numero busca si alguna cuenta tiene registrado dicho numero telefonico. El atributo num es este numero y se recibe como un String.
	 * Se busca la cuenta en ambas listas, tanto las prepago como las postpago y se retorna de ser encontrada. Por eso el tipo de retorno es de tipo Object, y es necesario que cualquier metodo que
	 * use esta busqueda verifique de que tipo es el objeto devuelto.
	 * 
	 * @param num String con el numero telefonico
	 * @return Una Cuenta con la cuenta asociada a dicho numero o null.
	 */
	public Cuenta buscarCuentaNumero(String num)
	{
		Cliente p;
		
		Set<String> ll = clientes.keySet();
		List<String> li = new ArrayList<String>(ll);
		ListIterator<String> it = li.listIterator();
		ListIterator<Cuenta> cu;
		Cuenta c;
		while(it.hasNext())
		{
			p = clientes.get(it.next());
			cu = p.getCuentas().listIterator();
			while(cu.hasNext())
			{
				c = cu.next();
				if (c.getNumero().equalsIgnoreCase(num))
					return c;
			}
			
		}
		
		return null;
		
	}
	
	
	
	/**
	 * Dado un id busca si alguna cuenta esta registrada con dicho id. El atributo num se recibe como un String.
	 * Se busca la cuenta en ambas listas, tanto las prepago como las postpago y se retorna de ser encontrada. Por eso el tipo de retorno es de tipo Object, y es necesario que cualquier metodo que
	 * use esta busqueda verifique de que tipo es el objeto devuelto.
	 * 
	 * @param num String con el id.
	 * @return Un Object con la cuenta asociada a dicho id o null.
	 */
	public Cuenta buscarCuentaId(String num)
	{

		Cliente p;

		Set<String> ll = clientes.keySet();
		List<String> li = new ArrayList<String>(ll);
		ListIterator<String> it = li.listIterator();
		ListIterator<Cuenta> cu;
		Cuenta c;
		while(it.hasNext())
		{
			p = clientes.get(it.next());
			cu = p.getCuentas().listIterator();
			while(cu.hasNext())
			{
				c = cu.next();
				if (c.getId() == Long.parseLong(num))
					return c;
			}
			
		}
		
		return null;
		
	}
	
	
	
	
	
	
	/**
	 * Agrega una cuenta nueva de cualquiera de los dos tipos, dependiendo de los que diga el paramtro tipo (PRE o POST).
	 * Busca si la cuenta existe, si el clinete con dicha cedula existe y si el plan al que se quiere asociar existe. Solo si todo existe se agrega la cuenta.
	 * El encargado de crear la cuenta es el plan mismo, y este a su vez le retorna la cuenta al cliente para que este la agruege en su lista.
	 * De esta manera la cuenta queda asociada y almacenada en un plan y en un cliente. 
	 * 
	 * @param tipo String dependiendo del tipo de la cuenta. (PRE o POST)
	 * @param nombre String con el nombre del plan del cual se quiere crear la cuenta
	 * @param ced String con la cedula del cliente al cual pertenecera la cuenta
	 * @param num Numero telefonico al cual se quiere asociar la cuenta nueva
	 * @return Un mensaje dependiendo del estado final de la operacion. Este indica si se agrego la cuenta, o si se presento algun problema
	 */
	public String agregarCuenta(String tipo, String nombre, String ced, String num)throws ExCliente, ExPlan, ExCuenta
	{
		//Crear la cuenta y almacenarla en la lista de cuentas de dicho plan.
		//Luego asignarsela al cliente
		//Numero ya usado?
		
		Plan p;
	
		if (! clientes.containsKey(ced))
		{
			throw (new ExCliente("Cedula no encontrada"));
		}
		
		Cuenta obj = buscarCuentaNumero(num);
		if (obj != null)
		{
			throw (new ExCuenta("Numero ya ocuopado"));
		}
		
		if(tipo.equalsIgnoreCase("PREPAGO"))
		{
			p = buscarPlan(nombre);
			if (p == null || (p != null && p instanceof PlanPostpago))
			{
				throw (new ExPlan("El Plan no existe"));
			}
			else
			{
				Cliente c = clientes.get(ced);
				
				return c.agregarCuenta(((PlanPrepago)p).agregarCuenta(num));
				
			}
		}
		else
		{
			if(tipo.equalsIgnoreCase("POSTPAGO"))
			{
				p = buscarPlan(nombre);
				if (p == null || (p != null && p instanceof PlanPrepago))
				{
					throw (new ExPlan("El plan no existe"));
				}
				else
				{
					Cliente c = clientes.get(ced);
					return c.agregarCuenta(((PlanPostpago)p).agregarCuenta(num));
				}
			}
			else
			{
				throw (new ExCuenta("Tipo Incorrecto"));
			}
		}
		
		
	}
	
	
	/**
	 * Registra una llamada en la cuenta con el id indicado si la encuentra. El metodo funciona tanto para cuentas prepago como para postpago pues hace uso del metodo buscarCuentaId, que retorna un Object.
	 * 
	 * @param id Id de la cuenta que realiza la llamada
	 * @param fecha GregorianCalendar con la fecha en que se hizo la llamada
	 * @param destino Numero destinatario de la llamada
	 * @param duracion La duracion de la llamada en minutos.
	 * @return
	 */
	public String registrarLLamada(String tipo, String id, GregorianCalendar fecha, String destino, String duracion, Indicativo ind) throws ExLLamada, ExCuenta
	{
		Cuenta obj = buscarCuentaId(id);
		if(obj == null)
		{
			return "Error. El id no es valido. No existe la cuenta";
		}
		else
		{
			try
			{
				String r = obj.agregarLLamada(tipo, fecha, destino, duracion, ind);
				return r;
				
			}catch(ExLLamada e)
			{
				throw e;
			}
			catch(ExCuenta cc)
			{
				throw cc;
			}
			
			
			
		}
			
	}
	
	
	
	/**
	 * Retorna un String para ser mostrado en pantalla con las cuentas que tiene la empresa. 
	 * Puede mostrar las prepago, postpago o ambas, dependiendo de lo que se introduuzca en el parametro cuales.
	 * (pre, post, prepost)
	 * 
	 * @param cuales Cuales cuentas se quieren mostrar
	 * @return Un string con las informacion de las cuentas deseadas.
	 */
	public List<Cuenta> mostrarCuentas(String cuales)
	{
		

		
		Cliente p;

		Set<String> ll = clientes.keySet();
		List<String> li = new ArrayList<String>(ll);
		ListIterator<String> it = li.listIterator();
		ListIterator<Cuenta> cu;
		List<Cuenta> lista = new ArrayList<Cuenta>();
		Cuenta c;
	
		if(cuales.equalsIgnoreCase("pre") || cuales.equalsIgnoreCase("prepost"))
		{
			it = li.listIterator();
			while(it.hasNext())
			{
				p = clientes.get(it.next());
				cu = p.getCuentas().listIterator();
				while(cu.hasNext())
				{
					c = cu.next();
					if (c instanceof CuentaPrepago)
					{
						lista.add(c);
					}
						
				}
				
			}
		}
		if(cuales.equalsIgnoreCase("post") || cuales.equalsIgnoreCase("prepost"))
		{
			it = li.listIterator();
			
			while(it.hasNext())
			{
				p = clientes.get(it.next());
				cu = p.getCuentas().listIterator();
				while(cu.hasNext())
				{
					c = cu.next();
					if (c instanceof CuentaPostpago)
					{
						lista.add(c);
					}
				}
				
			}
		}
		
		Collections.sort(lista, new CompararCuentasId());

		return lista;
		
	}
	
	
	/**
	 * Registra una recarga. A partir de un id busca la cuenta y le pasa toda ls informacion a la cuenta para que registre la recarga.
	 * 
	 * @param id Id de la cuenta
	 * @param fecha fecha de la recarga
	 * @param valorr valor de la recarga
	 * @return
	 */
	public String registrarRecarga(String id, GregorianCalendar fecha, String valorr)
	{
		
			Cuenta obj = this.buscarCuentaId(id);
			if (obj == null)
			{
				return "Error. No existe la cuenta " + id;
			}
			else
			{
				if(obj instanceof CuentaPrepago)
				{
					return ((CuentaPrepago)obj).agregarRecarga(fecha, valorr);
				}
				else
				{
					return "Error. Mismatch";
				}
			}
		
			
	}
	
	/**
	 * Genera un string con el reporte de fin de mes de los planes postpago. Este reporte muestra todas las cuentas de todos los clientes que estes suscritos a un plan postpago, con los respectivos gastos
	 * y duraciones.
	 * 
	 * @return Un String con el reporte completo
	 */
	public String reporteFinMesPost()
	{
		String m = new String();
		if(!this.clientes.isEmpty())
		{
			
			
			GregorianCalendar ff = new GregorianCalendar();
			Cliente c = new Cliente();
			long dur, durc, durt, totalcliente, totalt, valorp;
			Cuenta p;
			LLamada ll;
			Set<String> llaves = clientes.keySet();
			List<String> li = new ArrayList<String>(llaves);
			ListIterator<String> it = li.listIterator();
			ListIterator<Cuenta> cu;
			List<Cuenta> lista = new ArrayList<Cuenta>();
			List<Cliente> cli = new ArrayList<Cliente>();
			String s = new String();

			//Tomamos los clientes que tienen cuentas postpago
			while(it.hasNext())
			{
				s = it.next();
				if(clientes.get(s).tienePost())
					cli.add(clientes.get(s));
			}

			//Ordenamos la lista de clientes por cedula
			Collections.sort(cli, new CompararCedulasClientes());

			ListIterator<Cliente> itc = cli.listIterator();
			ListIterator<LLamada> itl;
			List<LLamada> lisll = new ArrayList<LLamada>();
			totalt = 0;
			durt = 0;
			//Empezamos a recorrer la lista de clientes
			while(itc.hasNext())
			{
				totalcliente = 0;
				durc = 0;
				c = itc.next();
				m += Utils.espacios("--CLIENTE: ", 12) +  Utils.espacios(c.getNombre(), 15) + Utils.espacios(", CC ",5) + Utils.espacios(String.valueOf(c.getCedula()), 10) + Utils.espacios(", ", 3) + Utils.espacios(c.getDireccion(), 20) + "\n";
				//cu recorre ahora las cuentas del cliente
				cu = c.getCuentas().listIterator(0);
				lista.clear();
				while(cu.hasNext())
				{
					Cuenta n = cu.next();
					if(n instanceof CuentaPostpago)
						lista.add(n);
				}

				cu = lista.listIterator(0);

				//En lista estan las cuentas postpago de dicho cliente
				while(cu.hasNext())
				{
					p = cu.next();
					m += Utils.espacios(" ", 4)+ Utils.espacios("Cuenta Postpago #", 17) +  Utils.espacios(String.valueOf(p.getId()), 5) + Utils.espacios(": Num ", 6) + Utils.espacios(String.valueOf(p.getNumero()), 10) + Utils.espacios(", Plan ", 7) + Utils.espacios(p.getPlan().getNombre(), 15) + "\n\n";
					m += Utils.espacios(" ", 8) + Utils.espacios("Llamadas:  ", 11)+ Utils.espacios("Fecha", 15) + Utils.espacios("TelefonoDestinatario", 21) +    Utils.espacios("Duracion",10 )   + Utils.espacios("Valor", 8) +"\n\n";
					//lisll ahora tiene las llamadas de dicha cuenta de dicho cliente
					lisll = p.getLlamadas();
					//Las ordenamos por fecha
					Collections.sort(lisll, new CompararLLamadasFecha());
					itl = lisll.listIterator(0);
					valorp = 0;
					dur =0;

					while(itl.hasNext())
					{
						ll = itl.next();
						if (ll.getFecha().get(Calendar.MONTH) == ff.get(Calendar.MONTH) && ll.getFecha().get(Calendar.YEAR) == ff.get(Calendar.YEAR))
						{
							valorp += ll.getValor();
							dur += ll.getDuracion();
							m += Utils.espacios(" ",19) + Utils.espacios(Utils.convertirFechaCadena(ll.getFecha()), 15)  + Utils.espacios(String.valueOf(ll.getTelefonoDestinatario()), 21) + Utils.espacios(String.valueOf(ll.getDuracion()), 10) +  Utils.espacios(String.valueOf(ll.getValor()), 8) + "\n";
						}
					}
					m += Utils.espacios(" ", 19) + Utils.espacios("TotalCuenta: ----------------------------", 55) +  Utils.espacios(String.valueOf(dur),10) + valorp + "\n";

					//-------
					m += Utils.espacios(" ",19) + Utils.espacios("Valor a Pagar: ----------------------------", 65) + p.obtenerPagoCuenta(ff) + "\n\n";
					totalcliente += p.obtenerPagoCuenta(ff);
					durc += dur;
				}
				totalt += totalcliente;
				durt += durc;
				m += Utils.espacios(" ",8) + Utils.espacios("Total Cliente: ----------------------------", 66) + Utils.espacios(String.valueOf(durc),10) + totalcliente + "\n" + "\n\n\n";
			}

			m += Utils.espacios("TOTAL TODOS LOS CLIENTES: -----------------------", 74) + Utils.espacios(String.valueOf(durt),10) + totalt + "\n" + "\n";
		}
		return m;
	}



	/**
	 * Genera un string con el reporte de fin de mes de los planes prepago. Este reporte muestra todas las cuentas de todos los clientes que estes suscritos a un plan prepago, con los respectivos gastos
	 * y duraciones.
	 * 
	 * @return Un String con el reporte completo
	 */
	
	public String reporteFinMesPre()
	{
		String m = new String();
		if(!this.clientes.isEmpty())
		{
			GregorianCalendar ff = new GregorianCalendar();
			Cliente c = new Cliente();
			long dur, durc, durt, totalcliente, totalcuenta, totalt;
			LLamada ll;
			Cuenta p;
		
			ListIterator<LLamada> itl;
			Recarga r;
			ListIterator<Recarga> itr;
			
			Set<String> llaves = clientes.keySet();
			List<String> li = new ArrayList<String>(llaves);
			ListIterator<String> it = li.listIterator();
			ListIterator<Cuenta> cu;
			List<Cuenta> lista = new ArrayList<Cuenta>();
			List<Cliente> cli = new ArrayList<Cliente>();
			String s = new String();
			
			while(it.hasNext())
			{
				s = it.next();
				if(clientes.get(s).tienePre())
					cli.add(clientes.get(s));
			}
			
			Collections.sort(cli, new CompararCedulasClientes());

			
			ListIterator<Cliente> itc = cli.listIterator();
			
			List<LLamada> lisll = new ArrayList<LLamada>();
			List<Recarga> lisr = new ArrayList<Recarga>();
			
			totalt = 0;
			durt = 0;
			while(itc.hasNext())
			{
				totalcliente = 0;
				durc = 0;
				c = itc.next();
				m += Utils.espacios("--CLIENTE: ", 12) +  Utils.espacios(c.getNombre(), 15) + Utils.espacios(", CC ",5) + Utils.espacios(String.valueOf(c.getCedula()), 10) + Utils.espacios(", ", 3) + Utils.espacios(c.getDireccion(), 20) + "\n";
				
				cu = c.getCuentas().listIterator(0);
				lista.clear();
				while(cu.hasNext())
				{
					p = cu.next();
					if(p instanceof CuentaPrepago)
						lista.add(p);
				}
				
				cu = lista.listIterator(0);
				
				while(cu.hasNext())
				{
					p = cu.next();
					m += Utils.espacios(" ", 4)+ Utils.espacios("Cuenta Postpago #", 17) +  Utils.espacios(String.valueOf(p.getId()), 5) + Utils.espacios(": Num ", 6) + Utils.espacios(String.valueOf(p.getNumero()), 10) + Utils.espacios(", Plan ", 7) + Utils.espacios(p.getPlan().getNombre(), 15) + "\n\n";
					//recargas
					m += Utils.espacios(" ", 8) + Utils.espacios("Recargas:  ", 11) + Utils.espacios("Fecha", 15) + "Valor\n";
					totalcuenta = 0;

					lisr = ((CuentaPrepago)p).getRecargas();
					Collections.sort(lisll, new CompararRecargaFecha());
					itr = lisr.listIterator(0);
					
					while(itr.hasNext())
					{
						r = itr.next();
						if(r.getFechaRecarga().get(Calendar.MONTH) == ff.get(Calendar.MONTH) && r.getFechaRecarga().get(Calendar.YEAR) == ff.get(Calendar.YEAR))
						{
							
							m += Utils.espacios(" ", 19) + Utils.espacios(Utils.convertirFechaCadena(r.getFechaRecarga()), 15) + r.getValorRecarga() + "\n";
						}
					}
					m += Utils.espacios(" ", 19) + Utils.espacios("TotalRecargas: ----------------------------", 55) +  Utils.espacios(String.valueOf(p.obtenerPagoCuenta(ff)),10) + "\n";

					

					totalcuenta += p.obtenerPagoCuenta(ff);
					totalcliente += totalcuenta;


					m += Utils.espacios(" ", 8) + Utils.espacios("Llamadas:  ", 11)+ Utils.espacios("Fecha", 15) + Utils.espacios("TelefonoDestinatario", 21) +    Utils.espacios("Duracion",10 )   + Utils.espacios("Valor", 8) +"\n\n";
					lisll = p.getLlamadas();
					Collections.sort(lisll, new CompararLLamadasFecha());
					itl = lisll.listIterator(0);
					
					totalcuenta = 0;
					dur =0;
					while(itl.hasNext())
					{
						ll = itl.next();
						if (ll.getFecha().get(Calendar.MONTH) == ff.get(Calendar.MONTH) && ll.getFecha().get(Calendar.YEAR) == ff.get(Calendar.YEAR))
						{
							totalcuenta += ll.getValor();
							dur += ll.getDuracion();
							m += Utils.espacios(" ",19) + Utils.espacios(Utils.convertirFechaCadena(ll.getFecha()), 16)  + Utils.espacios(String.valueOf(ll.getTelefonoDestinatario()), 20) + Utils.espacios(String.valueOf(ll.getDuracion()), 10) +  Utils.espacios(String.valueOf(ll.getValor()), 8) + "\n";
						}
					}
					durc += dur;
					m += Utils.espacios(" ", 19) + Utils.espacios("TotalLLamadas: ----------------------------", 55) +  Utils.espacios(String.valueOf(dur),10) + totalcuenta + "\n";




				}
				totalt += totalcliente;
				durt += durc;
				m += Utils.espacios(" ",8) + Utils.espacios("Total Cliente: ----------------------------", 66) + Utils.espacios(String.valueOf(durc),10) +  totalcliente  + "\n\n\n";
			}

			m += Utils.espacios("TOTAL TODOS LOS CLIENTES: -----------------------", 64) + Utils.espacios("Duracion: " + String.valueOf(durt),20) + "Valor: "+totalt + "\n" + "\n";
		}
		return m;
	}
	
	
	/**
	 * 
	 * Busca en el mapa de clientes el Id mas alto en el cual se ha registrado uno de ellos. Este metodo se utiliza en 
	 * la carga de la empresa para poder seguir enumerando los clientes por Id´s consecutivos, sin repetir los previamente
	 * existentes
	 * 
	 * @param ninguno
	 * @return un entero que representa el Id mas alto encontrado o 0 si no hay ningun cliente en la empresa
	 */
	public int getIdMasAlto()
	{
		
		int m =0;
		Set<String> ll = clientes.keySet();
		List<String> li = new ArrayList<String>(ll);
		List<Cuenta> lista = new ArrayList<Cuenta>();
		if(!li.isEmpty())
		{
			for(String s : li)
			{
				lista = clientes.get(s).getCuentas();
				if(!lista.isEmpty())
				{
					for(Cuenta c : lista)
					{
						if(m<c.getId())
						{
							m = (int)c.getId();
						}
					}
				}
			}
		}
		return m;
	}

}
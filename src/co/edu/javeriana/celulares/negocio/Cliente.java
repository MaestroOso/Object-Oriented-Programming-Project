package co.edu.javeriana.celulares.negocio;

import java.io.Serializable;
import java.util.*;

/**
 * 
 * @author Oscar Castelblanco y Lucas Gnecco
 *
 */

public class Cliente implements Serializable{
	
	/**
	 * Nombre del cliente. Incluye el apellido
	 */
	private String nombre;
	
	/**
	 * Cedula del cliente. Es unica y es util para diferenciar clientes
	 */
	private String cedula;
	
	/**
	 * Direccion de vivienda del cliente
	 */
	private String direccion;
	
	/**
	 * Lista con las cuentas asociadas a este cliente.
	 */
	private List<Cuenta> cuentas;


	/**
	 * Tipo de documento del cliente
	 */
	private TipoId tipo;
	
	  
	/**
	 * Retorna un objeto de tipo TipoId con el tipo de identificacion del cliente
	 * 
	 * @return El tipo de documento de Identificacion del cliente de tipo TipoId
	 */
	public TipoId getTipo() {
		return tipo;
	}
	
	/**
	 * Modifica el tipo de Id de un cliente. 
	 * El nuevo Id sera el que se introduzca en el parametro tipo, de tipo TipoId.
	 * 
	 * @param tipo de Id, un TipoId con el nuevo tipo de Id del Cliente
	 */
	public void setTipo(TipoId tipo) {
		this.tipo = tipo;
	}

	/**
	 * Constructos que instancia ambas listas del Cliente.
	 */
	public Cliente()
	{
		cuentas = new ArrayList<Cuenta>();
		
	}
	
	/**
	 * Constructor que recibe los datos de un cliente y lo crea con dicha informacion.
	 * Crea a su vez las listas de cuentas y las deja vacias y listas para ser llenadas.
	 * 
	 * @param nombre String con el nombre del cliente
	 * @param cedula String con la cedula del cliente. Se espera que sea un numero, pero puede recibir caracteres distintos a numeros.
	 * @param direccion String con la direccion del cliente
	 * @return Nada
	 */
	public Cliente(String nombre, String cedula, String direccion, String tipo) throws ExCliente
	{
		this.nombre = nombre;
		this.cedula = cedula;
		this.direccion = direccion;
		this.tipo = TipoId.darTipoId(tipo);
		if(this.tipo == null)
			throw (new ExCliente("Tipo de Id incorrecto"));
		cuentas = new ArrayList<Cuenta>();
		
	}

	/**
	 * Retorna un obtejo String con el nombre del cliente
	 * 
	 * @return El nombre del cliente
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Modifica el nombre de un cliente. El nuevo nombre sera el que se introduzca en el parametro nombre, de tipo String.
	 * 
	 * @param nombre String con el nuevo nombre del Cliente
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * Retorna un obtejo String con la cedula del cliente
	 * 
	 * @return La cedula del cliente
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * Modifica la cedula de este cliente. La nueva cedula es la que se ingresa en el String cedula como parametro.
	 * 
	 * @param cedula Objeto String con la nueva cedula del cliente
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	/**
	 * Retorna un obtejo String con la direccion del cliente
	 * 
	 * @return La direccion del cliente
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Modifica la direccion del cliente. La nueva direccion es la que entra como String en el parametro direccion
	 * 
	 * @param direccion Un String con la nueva direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Retorna la lista de cuentas prepago del cliente. Este objeto es de tipo List(CuentaPrepago).
	 * 
	 * @return Objeto List con las cuentas prepago del cliente
	 */
	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	/**
	 * Modifica la lista de cuentas prepago del cliente. La nueva lista es la que entra como parametro cuentasPre, de tipo List(CuentaPrepago)
	 * 
	 * @param cuentasPre La nueva lista de cuentas prepago del cliente
	 */
	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	
	
	
	
	/**
	 * Agrega una cuenta en la lista de cuentas prepago o postpago del cliente.
	 * El metodo recibe un objeto que puede ser de tipo CuentaPrepago o CuentaPostpago y dependiendo del tipo la agrega en la respectiva lista
	 * Retorna un String con un mensaje sobre el estado final de la operacion.
	 * 
	 * @param cuenta Object que se espera sea de tipo CUentaPrepago o CuentaPostpago
	 * @return Un String con un mensaje sobre el estado de la operacion.
	 */
	public String agregarCuenta(Cuenta cuenta)
	{
		
			if (cuenta instanceof CuentaPrepago)
			{
				CuentaPrepago p = (CuentaPrepago)cuenta;
				p.setUsuario(this);
				cuentas.add(p);
				return "Cuenta prepago agregada. \nId: " + p.getId() + "\nNumero: " + p.getNumero() + ".\nAsociada al plan:  " + p.getPlan().getNombre() + " \nCliente de cedula: " + p.getUsuario().getCedula();
			}
			else
			{
				if (cuenta instanceof CuentaPostpago)
				{
					CuentaPostpago p = (CuentaPostpago)cuenta;
					p.setUsuario(this);
					cuentas.add(p);
					return "Cuenta postpago agregada. \nId: " + p.getId() + "\nNumero: " + p.getNumero() + ".\nAsociada al plan:  " + p.getPlan().getNombre() + " \nCliente de cedula: " + p.getUsuario().getCedula();
				}
				else
				{
					return "Error. Mismatch";
				}
			}
		
	}
	
	/**
	 * Metodo encargado de verificar si el cliente tiene un plan de tipo Postpago
	 * 
	 * @param ninguno
	 * @return Un booleano que es true si el cliente tiene un plan de este tipo y false de lo contrario.
	 */
	public boolean tienePost()
	{
		ListIterator<Cuenta> it = cuentas.listIterator();
		while(it.hasNext())
		{
			if(it.next() instanceof CuentaPostpago)
				return true;
		}
		return false;
	}
	
	/**
	 * Metodo encargado de verificar si el cliente tiene un plan de tipo Prepago
	 * 
	 * @param ninguno
	 * @return Un booleano que es true si el cliente tiene un plan de este tipo y false de lo contrario.
	 */
	public boolean tienePre()
	{
		ListIterator<Cuenta> it = cuentas.listIterator();
		while(it.hasNext())
		{
			if(it.next() instanceof CuentaPrepago)
				return true;
		}
		return false;
	}
	
	/**
	 * Metodo encargado de calcular el precio total que un cliente debe pagar por su o sus planes Postpago
	 * 
	 * @param Un objeto de tipo Gregorian Calendar que representa la fecha para la cual quiere calcular el pago a realizar
	 * @return Un long que es el precio total a pagar por sus planes postpago
	 */
	public long darValorPagarPost(GregorianCalendar g)
	{
		
		if(this.cuentas.isEmpty())
			return 0;
		else
		{
			long r=0;
			for(Cuenta c:this.cuentas)
			{
				if(c instanceof CuentaPostpago)
				{
					r += c.obtenerPagoCuenta(g);
				}
			}
			return r;
		}
		
	}
	
	/**
	 * Metodo encargado de calcular el precio total que un cliente debe pagar por su o sus planes Prepago
	 * 
	 * @param Un objeto de tipo Gregorian Calendar que representa la fecha para la cual quiere calcular el pago a realizar
	 * @return Un long que es el precio total a pagar por sus planes Prepago
	 */
	public long darValorPagarPre(GregorianCalendar g)
	{
		
		if(this.cuentas.isEmpty())
			return 0;
		else
		{
			long r=0;
			for(Cuenta c:this.cuentas)
			{
				if(c instanceof CuentaPrepago)
				{
					r += c.obtenerPagoCuenta(g);
				}
			}
			return r;
		}
		
	}
	
	/**
	 * Metodo encargado de calcular el numero total de minutos que ha usado el cliente en sus planes prepago
	 * 
	 * @param Un objeto de tipo Gregorian Calendar que representa la fecha para la cual quiere calcular el numero de minutos usados
	 * @return Un long que es el numero total de minutos usados en sus planes prepago
	 */
	public long darMinutosPre(GregorianCalendar g)
	{
		
		if(this.cuentas.isEmpty())
			return 0;
		else
		{
			long r=0;
			for(Cuenta c:this.cuentas)
			{
				if(c instanceof CuentaPrepago)
				{
					r +=( (CuentaPrepago)c).totalGastoMinutos(g);
				}
			}
			return r;
		}
		
	}
	
	
	
	
	
}

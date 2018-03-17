package co.edu.javeriana.celulares.negocio;

import java.util.GregorianCalendar;

/**
 *
 */

/**
 * @author salainformatica
 *
 */
public class LLamadaInternacional extends LLamada {
	
	/**
	 * Un enumerado que representa el Indicativo al cual se realiza la llamada
	 */
	private Indicativo indicativo;
	
	
	/**
	 * Retorna el Indicativo al cual se realiza la cuenta
	 *  
	 * @param ninguno
	 * @return El indicativo de la llamada
	 */
    public Indicativo getIndicativo() {
		return indicativo;
	}
    
    /**
	 * Modifica el indicativo de la llamadaInternacional
	 *  
	 * @param el Indicativo al cual se realiza la llamada
	 * @return ninguno
	 */
	public void setIndicativo(Indicativo indicativo) {
		this.indicativo = indicativo;
	}
	
	/**
	 * Metodo constructor de la llamada Internacional. Hace llamado al constructor de la clase Llamada de la cual hereda
	 * y luego añade el indicativo al cual pertenece la llamada.
	 * @param telefonoDestinatario. Un String que representa el numero al cual se realiza la llamada
     * @param fecha. Un objeto de tipo GregorianCalendar que representa la fecha de realización de la llamada
     * @param duracion. Un long que representa la duracion de la llamada
     * @param cu. La cuenta sobre la cual se hace la llamada.
	 * @param ind. Objeto de tipo enumerado, Indicativo que representa la zona a la cual se realiza la llamada
	 */
	public LLamadaInternacional(String telefonoDestinatario, GregorianCalendar fecha, long duracion, Cuenta cu, Indicativo ind){
        super(telefonoDestinatario, fecha, duracion, cu);
        this.indicativo = ind;
        
    }
    
	/**
     * Metodo abstracto que calcula el valor a pagar por la llamada
     * @param Una Cuenta
     * @return un long con el valor total a pagar 
     */
    public long calcularValor(Cuenta cu){
    	
    	long v;
    	if (cu instanceof CuentaPrepago)
    		v = this.duracion * cu.getPlan().getValorMinuto();
    	else
    	{
    		if(((CuentaPostpago)cu).getFechaMinutosAdicionales() == null)
    		{
    			v = this.duracion * cu.getPlan().getValorMinuto();
    		}
    		else
    		{
    			PlanPostpago po = (PlanPostpago)cu.getPlan();
    			v = this.duracion * po.getValorMinutoAdicional();
    		}
    	}
    	
    	
    	return v + (long)(v*0.2);
    	
            
    }
    
}
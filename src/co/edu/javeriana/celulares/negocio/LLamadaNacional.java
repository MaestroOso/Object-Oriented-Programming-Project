package co.edu.javeriana.celulares.negocio;

import java.util.GregorianCalendar;

/**
 *
 */

/**
 * @author salainformatica
 *
 */
public class LLamadaNacional extends LLamada {
    
	/**
	 * Metodo constructor de la llamada Internacional. Hace llamado al constructor de la clase Llamada de la cual hereda.
	 * @param telefonoDestinatario. Un String que representa el numero al cual se realiza la llamada
     * @param fecha. Un objeto de tipo GregorianCalendar que representa la fecha de realización de la llamada
     * @param duracion. Un long que representa la duracion de la llamada
     * @param cu. La cuenta sobre la cual se hace la llamada.
	 */
    public LLamadaNacional(String telefonoDestinatario, GregorianCalendar fecha, long duracion, Cuenta cu){
        super(telefonoDestinatario, fecha, duracion, cu);
        
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
    	return v;
    	
            
    }
    
}
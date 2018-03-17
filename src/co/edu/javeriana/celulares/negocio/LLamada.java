package co.edu.javeriana.celulares.negocio;
import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 *
 */

/**
 * @author Oscar Castelblanco y Lucas Gnecco
 *
 */
public abstract class LLamada implements Serializable{
	
    /**
     * Un objeto de tipo String que representa el telefono del destinatario de la llamada
     */
    protected String telefonoDestinatario;
    
    /**
     * Un objeto de tipo GregorianCalendar que representa la fecha de la llamada
     */
    protected GregorianCalendar fecha;
    
    /**
     * Un long que representa la duracion de la llamada
     */ 
    protected long duracion;
    
    /**
     * Un long que representa el valor de la llamada
     */
    protected long valor;
    
    /**
     * Metodo abstracto que calcula el valor a pagar por la llamada
     * @param Una Cuenta
     * @return un long con el valor total a pagar 
     */
    public abstract long calcularValor(Cuenta cu);
    
    /**
     * Metodo constructor de una llamada. Recibe como parametros el telefono del destinatario, la fecha de la llamada,
     * la duracion de la misma y un objeto de tipo Cuenta
     * Con la informacion obtenida calcula el valor de la llamada
     * 
     * @param telefonoDestinatario. Un String que representa el numero al cual se realiza la llamada
     * @param fecha. Un objeto de tipo GregorianCalendar que representa la fecha de realización de la llamada
     * @param duracion. Un long que representa la duracion de la llamada
     * @param cu. La cuenta sobre la cual se hace la llamada.
     */
    public LLamada(String telefonoDestinatario, GregorianCalendar fecha, long duracion, Cuenta cu){
        
        this.telefonoDestinatario = telefonoDestinatario;
        this.fecha = fecha;
        this.duracion = duracion;
        this.valor = calcularValor(cu);
       
    }

    /**
     * @return the telefonoDestinatario
     */
    public String getTelefonoDestinatario() {
        return telefonoDestinatario;
    }

    /**
     * @param telefonoDestinatario the telefonoDestinatario to set
     */
    public void setTelefonoDestinatario(String telefonoDestinatario) {
        this.telefonoDestinatario = telefonoDestinatario;
    }

    /**
     * @return the fecha
     */
    public GregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the duracion
     */
    public long getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the valor
     */
    public long getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(long valor) {
        this.valor = valor;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Llamada [telefonoDestinatario=" + telefonoDestinatario
                + ", fecha=" + fecha + ", duracion=" + duracion + ", valor="
                + valor + "]";
    }
    
}
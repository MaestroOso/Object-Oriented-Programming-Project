package co.edu.javeriana.celulares.negocio;


/**
 * @author Oscar Castelblanco y Lucas Gnecco
 *
 * Clase de tipo enumerado que representa el Indicativo de región de una llamada
 */
public enum Indicativo {
	USA ("1"),
	ESPANA ("34"),
	FRANCIA ("33"),
	ARGENTINA ("54");
	
	
	/**
	 * Metodo por defecto que crea un enumerado y le asigna el tipo de enumerado que se manda como parametro
	 * 
	 * @param value. Un objeto de tipo String que representa el enumerado.
	 * @return ninguno
	 */
	private Indicativo(String value){
        this.value = value;
    }
	
	/**
	 * Un objeto de tipo String que representa el enumerado Indicativo
	 */
    private final String value;

    
    /**
     * Metodo que retorna el valor del Indicativo
     * @param ninguno
     * @return un String que representa el valor del enumerado
     */
    public String getValue(){return value;}
	
    /**
     * Metodo que se encarga de retornar el enumerado Indicativo con su valor
     * 
     * @param un objeto de tipo String que representa una cadena de la cual se quiere saber su valor enumerado
     * @return un Indicativo con el Indicativo sobre el cual estaba la cadena
     */
	public static Indicativo darIndicativo(String s)
	{
		if(s.equalsIgnoreCase("usa"))
			return Indicativo.USA;

		if(s.equalsIgnoreCase("espana"))
			return Indicativo.ESPANA;

		if(s.equalsIgnoreCase("francia"))
			return Indicativo.FRANCIA;

		if(s.equalsIgnoreCase("argentina"))
			return Indicativo.ARGENTINA;
		return null;
	}
}

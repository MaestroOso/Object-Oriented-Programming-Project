package co.edu.javeriana.celulares.negocio;

import java.io.Serializable;

public abstract class Plan implements Serializable{
	

	/**
	 * El valor del minuto para este plan
	 */
	protected long valorMinuto;
	
	/**
	 * Nombre del plan
	 */
	protected String nombre;

	/**
	 * Retorna el valor de un minuto en este plan
	 * 
	 * @return El valor del minuto
	 */
	public long getValorMinuto() {
		return valorMinuto;
	}

	/**
	 * Modifica el valor del minuto en este plan
	 * 
	 * @param valorMinuto De tipo long con el nuevo valor del minuto para el plan
	 */
	public void setValorMinuto(long valorMinuto) {
		this.valorMinuto = valorMinuto;
	}

	/**
	 * Retorna el nombre del plan
	 * 
	 * @return El nombre del plan
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre del plan.
	 * 
	 * @param nombre String con el nuevo nombre del plan
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	/**
	 * Constructor que crea un plan con un nombre y un valor de los minutos dado.
	 * 
	 * @param valor De tipo long
	 * @param nom Objeto String con el nombre del plan
	 */
	public Plan(long valor, String nom)
	{
		this.valorMinuto = valor;
		this.nombre = nom;
	}


	
	
	
	
	
	@Override
	public String toString() {
		return "Plan [valorMinuto=" + valorMinuto + ", nombre=" + nombre + "]";
	}

	
}

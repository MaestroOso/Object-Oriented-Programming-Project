package co.edu.javeriana.celulares.presentacion;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class Utils {
	
	/**
	 * Representa el numero en el cual se han numerado los clientes
	 */
	public static int CONSECUTIVO = 0; 

	/**
	 * Metodo que retorna el mes en el que está una fecha de tipo GregorianCalendar como un String
	 * @param f. Un objeto de tipo GregorianCalendar que representa una fecha
	 * @return un String con la cadena que hace referencia a uno de los meses del año. En caso de no ser uno valido retorna
	 * vacio
	 */
	public static String darMes(GregorianCalendar f)
	{
		int o = f.get(Calendar.MONTH);
		switch (o)
		{
		case 0:
			return "Enero";
		case 1:
			return "Febrero";
			
		case 2:
			return "Marzo";
		case 3:
			return "Abril";
			
		case 4:
			return "Mayo";
			
		case 5:
			return "Junio";
			
		case 6:
			return "Julio";
			
		case 7:
			return "Agosto";
			
		case 8:
			return "Septiembre";
			
		case 9:
			return "Octubre";
			
		case 10:
			return "Noviembre";
			
		case 11:
			return "Diciembre";
			
		default:
			return "";
		}
	}
	
	/**
	 * Metodo que retorna el mes dependiendo de un entero que va de 0 a 11, siendo 0 Enero y 11 Diciembre
	 * @param o. Un entero que representa un mes
	 * @return un String con la cadena que hace referencia a uno de los meses del año. En caso de no ser uno valido retorna
	 * vacio
	 */
	public static String darMes(int o)
	{
		switch (o)
		{
		case 0:
			return "Enero";
		case 1:
			return "Febrero";
			
		case 2:
			return "Marzo";
		case 3:
			return "Abril";
			
		case 4:
			return "Mayo";
			
		case 5:
			return "Junio";
			
		case 6:
			return "Julio";
			
		case 7:
			return "Agosto";
			
		case 8:
			return "Septiembre";
			
		case 9:
			return "Octubre";
			
		case 10:
			return "Noviembre";
			
		case 11:
			return "Diciembre";
			
		default:
			return "";
		}
	}
	
	/**
	 * Metodo que convierte una fecha dada en un String a un objeto de tipo GregorianCalendar
	 * @param cad. Un objeto de tipo String que representa una fecha dada en un formato especifico
	 * @return un objeto de tipo GregorianCalendar con la fecha que estaba en la cadena
	 */
	public static GregorianCalendar convertirCadenaFecha(String cad){
		GregorianCalendar fecha;
		int dia,mes,agno;
		Scanner s = new Scanner(cad).useDelimiter("-");
		agno=s.nextInt();
		mes=s.nextInt();
		dia=s.nextInt();
		
		fecha=new GregorianCalendar(agno,mes-1,dia);
		
		return fecha;
	}
	
	/**
	 * Metodo que convierte una fecha que esta en un GregorianCalendar a un objeto de tipo String
	 * @param f. Un objeto de tipo GregorianCalendar que representa una fecha
	 * @return un String que tiene una fecha
	 */
	public static String convertirFechaCadena(GregorianCalendar f){
		
		return ""+f.get(Calendar.YEAR) + "-" + (f.get(Calendar.MONTH)+1) + "-" + f.get(Calendar.DAY_OF_MONTH);
	}

	
	
	/**
	 * Retorna una cadena con formato de espacios modificado para una impresion visualmente agradable
	 * Recibe el parametro <i>men</i> un objeto de tipo String con el la cadena que se quiere arreglar
	 * y <i>espacios</i> un entero con el numero de espacios que se desea tenga la cadena
	 * 
	 * @param men un String con la cadena inicial
	 * @param int un int con el numero de espacios que se desea tenga la cadena
	 * @return un String con la cadena modificada
	 */
	public static String espacios(String men, int espacios)
	{
		int tam = men.length();
		for(int i = tam; i<espacios; i++)
		{
			men+=" ";
		}
		return men;
	}
	
	/**
	 * Metodo que verifica si una cadena es de tipo numerico
	 * @param str. Una cadena que puede contener un numero
	 * @return un booleano verificando si dicha cadena es o no de tipo numerico
	 */
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
	
	/**
	 * Metodo que retorna un numero de mes dependiendo de una cadena
	 * @param o. Una cadena que representa uno de los doce meses del año
	 * @return un entero que representa el mes del año al cual hace referencia la cadena ingresada. Este puede estar entre 0 y 11
	 */
	public static int darNumMes(String o)
	{
		if(o.equalsIgnoreCase("Enero"))
			return 0;
		if(o.equalsIgnoreCase("febrero"))
			return 1;
		if(o.equalsIgnoreCase("marzo"))
			return 2;
		if(o.equalsIgnoreCase("abril"))
			return 3;
		if(o.equalsIgnoreCase("mayo"))
			return 4;
		if(o.equalsIgnoreCase("junio"))
			return 5;
		if(o.equalsIgnoreCase("julio"))
			return 6;
		if(o.equalsIgnoreCase("agosto"))
			return 7;
		if(o.equalsIgnoreCase("septiempre"))
			return 8;
		if(o.equalsIgnoreCase("octubre"))
			return 9;
		if(o.equalsIgnoreCase("noviembre"))
			return 10;
		if(o.equalsIgnoreCase("diciembre"))
			return 11;
		
		return -1;
		
		
	}
	
	
}

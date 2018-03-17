package co.edu.javeriana.celulares.presentacion;
import java.io.*;
import co.edu.javeriana.celulares.negocio.IEmpresa;
import co.edu.javeriana.celulares.negocio.Empresa;

public class TestTeclado {
	
	/**
	 * Representa la IEmpresa sobre la cual se realizan todos los metodos
	 */
	private static IEmpresa empresaCelulares = new Empresa();

	
	
	
	
	/**
	 * Despliega un menu en la pantalla mostrando al usuario los servicios a los que puede acceder. Recibe del usuario un caracter que representa el servicio al que desea acceder el usuario. Se convierte en un entero para retornar
	 * 
	 * @param Ninguno
	 * @return El entero que representa la opcion que decide el usuario. 
	 * 
	 */
	
	public static int menu(){
			
		int opcion=-1;
		String op;
		
		try{
			
			System.out.println("1.Ingresar Clientes");
			System.out.println("2.Ingresar planes de Prepago");
			System.out.println("3.Ingresar planes de Postpago");
			System.out.println("4.Agregar nueva cuenta de prepago o postpago");
			System.out.println("5.Agregar una llamada nacional o internacional");
			System.out.println("6.Agregar una recarga");
			System.out.println("7.Reporte de facturacion Postpago al fin de mes");
			System.out.println("8.Reporte de recargas al fin de mes");
			System.out.println("9.Reporte de llamadas por cuenta");
			System.out.println("10.Salir");
			
			BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
			op=bf.readLine();
			opcion=Integer.parseInt(op);
			return opcion;
		}
		catch (Exception e){
		   System.out.println("Ocurrio un error en la aplicacion" + e);	
		}
		
		return opcion;
		
	}
	
	
	

	/**
	 * Ingresa los datos de los clientes de la empresa a partir de un archivo de texto. El nombre del archivo de texto
	 * lo proporciona el usuario y es pasado en el objeto String nom.
	 * 
	 * @param nom String con el nombre del archivo de texto para cargar la informacion de los clientes
	 * @return Nada 
	 * 
	 */

	public static void ingresarClientes(String nom){
		try{
			FileReader in = new FileReader(new File("./" + nom));
			BufferedReader bf = new BufferedReader(in);
			String aux, tok[];

			while (!(aux = bf.readLine().trim()).equalsIgnoreCase("#FIN"))
			{
				if (!(aux.startsWith("#")) && ! (aux.replaceAll("\\s+", "").trim().length() == 0))
				{
					tok = aux.split("\\*");
					//Ingresar cliente
					// System.out.println(empresaCelulares.agregarCliente(tok[0].trim(), tok[1].trim(), tok[2].trim(), tok[3].trim()));
					
				}
			}


			System.out.println("Proceso realizado con exito");
			in.close();
		}
		catch(Exception e)
		{
			System.out.println("Problemas con el archivo!");
		}
	}

	
	

	/**
	 * Ingresa los datos de los planes prepago de la empresa a partir de un archivo de texto. El nombre del archivo de texto
	 * lo proporciona el usuario y es pasado en el objeto String nom.
	 * 
	 * @param nom String con el nombre del archivo de texto para cargar la informacion de los planes prepago
	 * @return Nada 
	 * 
	 */
	
	public static void ingresarPlanesPrepago(String nom){
		try{
			FileReader in = new FileReader(new File("./" + nom));
			BufferedReader bf = new BufferedReader(in);
			String aux, tok[];

			while (!(aux = bf.readLine().trim()).equalsIgnoreCase("#FIN"))
			{
				if (!(aux.startsWith("#")) && ! (aux.replaceAll("\\s+", "").trim().length() == 0))
				{
					tok = aux.split("\\*");
					//Ingresar plan
					// System.out.println(empresaCelulares.agregarPlanPre(tok[0].trim(), tok[1].trim()));
					
				}
			}

			System.out.println("Proceso realizado con exito");
			in.close();
		}
		catch(Exception e)
		{
			System.out.println("Problemas con el archivo!");
		}
	}

	
	
	/**
	 * Ingresa los datos de los planes postpago de la empresa a partir de un archivo de texto. El nombre del archivo de texto
	 * lo proporciona el usuario y es pasado en el objeto String nom.
	 * 
	 * @param nom String con el nombre del archivo de texto para cargar la informacion de los planes postpago
	 * @return Nada 
	 * 
	 */
	
	public static void ingresarPlanesPostpago(String nom){
		try{
			FileReader in = new FileReader(new File("./" + nom));
			BufferedReader bf = new BufferedReader(in);
			String aux, tok[];

			while (!(aux = bf.readLine().trim()).equalsIgnoreCase("#FIN"))
			{
				if (!(aux.startsWith("#")) && ! (aux.replaceAll("\\s+", "").trim().length() == 0))
				{
					tok = aux.split("\\*");
					//Ingresar plan
					// System.out.println(empresaCelulares.agregarPlanPost(tok[0].trim(), tok[1].trim(), tok[2].trim(), tok[3].trim()));
				}
			}

			System.out.println("Proceso realizado con exito");
			in.close();
		}
		catch(Exception e)
		{
			System.out.println("Problemas con el archivo!");
		}
	}

	
	
	
	/**
	 * Escribe un reporte en un archivo de nombre arch. Recibe el nombre del archivo y el mensaje a escribir.
	 * @param arch El nombre del archivo
	 * @param mensaje El mensaje a escribir en el archivo. Debe ser un String ya formateado para escribirlo.
	 */
	public static void reporte(String arch, String mensaje)
	{
		try{
			FileWriter out = new FileWriter(new File(arch));
			out.write(mensaje);
			out.close();
			
		}
		catch(Exception e)
		{
			System.out.println("Problemas con el archivo!");
		}
	}

	
	
//	
//	
	
	/**
	 * Metodo main
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		empresaCelulares = new Empresa();
		
		
		
		
		
		
		/**
		 * Entero usado para leer la opcion que requiere el usuario y desplegar el respectivo servicio.
		 */
		int op=-1;
		
		
		String auxS = new String();
		
		String auxS2 = new String();
		String auxS3 = new String();
		String auxS4 = new String();
		String auxS5 = new String();
		
		try{

			op = menu();
			BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));

			while (op!=10){
				try{	
					switch(op){
					case 1: 




						break;

					case 2: 

					

						break;

					case 3: 

						
						break;

					case 4: 

						
						break;

					case 5:

						

						break;

					case 6: 
						
						
					case 7: 


						break;
						
					case 8: 
						

						break;

					case 9: 

						//Sustentacion
					//	System.out.println(empresaCelulares.reportePorCuenta());

						break;

					default:
						System.out.println("Opcion Invalida!!! ");
						break;
					}

				}catch(Exception e){
					System.out.println(" " + e);

				}finally{
					op=menu();
				}
			}

		}
		catch (Exception e){
			System.out.println("Ocurrio un error en la aplicacion" + e);	
		}



	}

}

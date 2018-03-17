package co.edu.javeriana.celulares.presentacion;
import java.awt.BorderLayout;

import co.edu.javeriana.celulares.negocio.Cliente;
import co.edu.javeriana.celulares.negocio.CompararCedulasClientes;
import co.edu.javeriana.celulares.negocio.CompararLLamadasFecha;
import co.edu.javeriana.celulares.negocio.CompararRecargaFecha;
import co.edu.javeriana.celulares.negocio.Cuenta;
import co.edu.javeriana.celulares.negocio.CuentaPostpago;
import co.edu.javeriana.celulares.negocio.CuentaPrepago;
import co.edu.javeriana.celulares.negocio.ExPlan;
import co.edu.javeriana.celulares.negocio.IEmpresa;
import co.edu.javeriana.celulares.negocio.Empresa;
import co.edu.javeriana.celulares.negocio.ExCliente;
import co.edu.javeriana.celulares.negocio.Indicativo;
import co.edu.javeriana.celulares.negocio.LLamada;
import co.edu.javeriana.celulares.negocio.Plan;
import co.edu.javeriana.celulares.negocio.Recarga;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import java.awt.Dimension;
import javax.swing.JTabbedPane;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JDialog;
import javax.swing.JTextArea;

public class Ventana extends JFrame {

	private IEmpresa JM = new Empresa();  //  @jve:decl-index=0:
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTabbedPane ServiciosPane = null;
	private JPanel MenuServicios = null;
	private JLabel TituloMenu = null;
	private JButton BMenuCargar = null;
	private JButton BArgegarCuenta = null;
	private JButton BRegistrarLLamada = null;
	private JButton BAgregarRecarga = null;
	private JButton BReportePost = null;
	private JButton BReportePre = null;
	private JButton BReporteIngresos = null;
	private JButton BCargarSistema = null;
	private JButton BSalvarSistema = null;
	private JPanel PanelAcciones = null;
	private JPanel PanelReportes = null;
	private JPanel PanelSerializacion = null;
	private JPanel CargarClientesYPlanes = null;
	private JLabel TituloCargarClientesYplanes = null;
	private JPanel BotonesCargar = null;
	private JButton BCargarClientes = null;
	private JButton BCargarPlPos = null;
	private JButton BCargarPlPre = null;
	private JButton BRegresar = null;
	private JPanel PanelRegresar = null;
	private JPanel PanelCrearCuenta = null;
	private JLabel TituloCuenta = null;
	private JPanel PanelOpcionesCuentaNueva = null;
	private JTextField TextCuentaNumero = null;
	private JLabel LabelCuentaNumero = null;
	private JComboBox ComboCuentaCliente = null;
	private JLabel LabelCuentaCliente = null;
	private JComboBox ComboCuentaPlan = null;
	private JLabel LabelCuentaPlan = null;
	private JComboBox ComboCuentaTipo = null;
	private JLabel LabelCuentaTipo = null;
	private JPanel PanelCuentaRegresar = null;
	private JButton BCuentaCrear = null;
	private JPanel PanelRegistrarLLamada = null;
	private JLabel LabelTituloLlamada = null;
	private JPanel PanelLLamadaOpciones = null;
	private JTextField TextLLamadaDuracion = null;
	private JTextField TextLLamadaDestino = null;
	private JLabel LabelLLamadaDestino = null;
	private JLabel LabelLLamadaDuracion = null;
	private JPanel PanelLLamadaFecha = null;
	private JComboBox ComboLlamadaDia = null;
	private JComboBox ComboLlamadaMes = null;
	private JComboBox ComboLlamadaAno = null;
	private JLabel LabelLLamadaFecha = null;
	private JComboBox ComboLLamadaPaisDestino = null;
	private JLabel LabelLLamadaPaisDestino = null;
	private JComboBox ComboLLamadaTipo = null;
	private JLabel LabelLLamadaTipo = null;
	private JComboBox ComboLLamadaCuenta = null;
	private JLabel LabelLLamadaCuenta = null;
	private JPanel PanelLLamadaRegresar = null;

	private JButton BRegLLamada = null;
	private JPanel PanelAgregarRecarga = null;
	private JLabel LabelTituloRecarga = null;
	private JPanel PanelOpcionesRecarga = null;
	private JLabel LabelRecargaCuenta = null;
	private JLabel LabelRecargaFecha = null;
	private JLabel LabelRecargaValor = null;
	private JComboBox ComboRecargaCuenta = null;
	private JTextField TextRecargaValor = null;
	private JPanel PanelRecargaFecha = null;
	private JComboBox ComboRecargaDia = null;
	private JComboBox ComboRecargaMes = null;
	private JComboBox ComboRecargaAno = null;
	private JPanel PanelRecargaRegresar = null;
	private JButton BRecargaAgregar = null;
	private JButton BCuentaRegresar = null;
	private JButton BRegresarLLamada = null;
	private JButton BRecargaRegresar = null;
	private JPanel PanelReportePost = null;
	private JPanel PanelMesReporteRepPost = null;
	private JComboBox ComboReportePostMes = null;
	private JComboBox ComboReportePostAno = null;
	private JPanel PanelTituloRepPost = null;
	private JLabel LabelTituloRepPost = null;
	private JPanel PanelOpcionesRepPost = null;
	private JPanel PanelRepPostRegresar = null;
	private JButton BRepPostRegresar = null;
	private JButton BRepPostMostrarClientes = null;
	private JButton BRepPostMostrarCuentas = null;
	private JButton BRepPostMostrarLlamadas = null;
	private JScrollPane ScrollRepPostClientes = null;
	private JTable TableRepPostClientes = null;
	private JScrollPane ScrollRepPostCuentas = null;
	private JTable TableRepPostCuentas = null;
	private JScrollPane ScrollRepPostLLamadas = null;
	private JTable TablerepPostLLamadas = null;
	private JPanel PanelReportePre = null;  //  @jve:decl-index=0:visual-constraint="661,59"
	private JPanel PanelTituloRepPre = null;
	private JPanel PanelOpcionesRepPre = null;  //  @jve:decl-index=0:visual-constraint="640,340"
	private JPanel PanelRepPreRegresar = null;
	private JPanel PanelMesReporteRepPre = null;
	private JComboBox ComboReportePreAno = null;
	private JComboBox ComboReportePreMes = null;
	private JLabel LabelTituloRepPre = null;
	private JButton BRepPreRegresar = null;
	private JPanel PanelRepPostOpcionesClientes = null;  //  @jve:decl-index=0:visual-constraint="617,220"
	private JLabel LabelRepPostOpcionesClientes = null;
	private JLabel LabelRepPostOpcionesClientesValor = null;
	private JPanel PanelRepPostOpcionesCuentas = null;  //  @jve:decl-index=0:visual-constraint="633,170"
	private JLabel LabelRepPostOpcionesCuentas = null;
	private JPanel PanelRepPostOpcionesLLamadas = null;  //  @jve:decl-index=0:visual-constraint="633,174"
	private JLabel LabelRepPostOpcionesLLamadas = null;
	private JLabel LabelRepPostOpcionesLLamadasValor = null;
	private JPanel PanelRepPreOpcionesClientes = null;
	private JLabel LabelRepPreOpcionesClientes = null;
	private JLabel LabelRepPreOpcionesClienteTotal = null;
	private JScrollPane ScrollRepPreClientes = null;
	private JTable TableRepPreClientes = null;
	private JPanel PanelRepPreOpcionesCuentas = null;
	private JLabel LabelRepPreOpcionesCuentas = null;
	private JScrollPane ScrollRepPreCuentas = null;
	private JTable TableRepPreCuentas = null;
	private JPanel PanelRepPreOpcionesDoble = null;
	private JPanel PanelRepPreOpcionesRecargaEncabezado = null;
	private JLabel LabelRepPreOpcionesRecargas = null;
	private JButton BRepPreRecargas = null;
	private JPanel PanelRepPreOpcionesRecargas = null;  //  @jve:decl-index=0:visual-constraint="430,296"
	private JLabel LabelRepPreOpcionesRecargasTotal = null;
	private JScrollPane ScrollRepPreRecargas = null;
	private JTable TableRepPreRecargas = null;
	private JPanel PanelRepPreOpcionesLlamadas = null;
	private JPanel PanelRepPreOpcionesLLamadaEncabezado = null;
	private JLabel LabelRepPreOpcionesLLamadas = null;
	private JButton BRepPreLLamadas = null;
	private JLabel LabelRepPreOpcionesLLamadasTotal = null;
	private JScrollPane ScrollRepPreLLamadas = null;
	private JTable TableRepPreLLamadas = null;
	private JPanel PanelRepPreClientesEncabezado = null;  //  @jve:decl-index=0:visual-constraint="674,155"
	private JButton BPreClientes = null;
	private JPanel PanelRepPreCuentasEncabezado = null;  //  @jve:decl-index=0:visual-constraint="770,186"
	private JButton BPreCuentas = null;
	private JPanel PanelRepPostClientesEncabezado = null;  //  @jve:decl-index=0:visual-constraint="693,166"
	private JPanel PanelRepPostCuentasEncabezado = null;  //  @jve:decl-index=0:visual-constraint="645,197"
	private JPanel PanelRepPostLLamadasEncabezado = null;  //  @jve:decl-index=0:visual-constraint="707,205"
	
	private Icon icon;
	
	
	
	
	
	/**
	 * This is the default constructor
	 */
	public Ventana() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1000, 700);
		this.setContentPane(getJContentPane());
		this.setTitle("JAVEMOVIL");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getServiciosPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}
	
	
	
	//-------------------------------------------------
	/**
	 * Ingresa los datos de los clientes de la empresa a partir de un archivo de texto. El nombre del archivo de texto
	 * lo proporciona el usuario y es pasado en el objeto String nom.
	 * 
	 * @param nom String con el nombre del archivo de texto para cargar la informacion de los clientes
	 * @return Nada 
	 * 
	 */

	public String ingresarClientes(File nom){
		try{
			FileReader in = new FileReader(nom);
			BufferedReader bf = new BufferedReader(in);
			String aux, tok[];
			String m = new String();

			while (!(aux = bf.readLine().trim()).equalsIgnoreCase("#FIN"))
			{
				if (!(aux.startsWith("#")) && !(aux.replaceAll("\\s+", "").trim().length() == 0))
				{
					tok = aux.split("\\*");
					//Ingresar cliente
					try{
					 JM.agregarCliente(tok[0].trim(),  tok[2].trim(), tok[3].trim(), tok[1].trim());
					}
					catch(ExCliente c)
					{
						m += c + "\n";
						
					}
				}
			}

			in.close();
			return m + "Proceso realizado con exito";
			
		}
		catch(Exception e)
		{
			return "Problemas con el archivo!" + e;
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
	
	public String ingresarPlanesPrepago(File nom){
		try{
			FileReader in = new FileReader(nom);
			BufferedReader bf = new BufferedReader(in);
			String aux;
			String[] tok;
			String m = new String();

			while (!(aux = bf.readLine().trim()).equalsIgnoreCase("#FIN"))
			{
				if (!(aux.startsWith("#")) && ! (aux.replaceAll("\\s+", "").trim().length() == 0))
				{
					tok = aux.split("\\*");
					//Ingresar plan

					try{
						aux = tok[2];

						m = "Archvo Incorrecto";
						return m;
					}
					catch(ArrayIndexOutOfBoundsException a)
					{
						try{
							JM.agregarPlanPre(tok[0].trim(), tok[1].trim());
						}
						catch(ExPlan p)
						{
							m += p + "\n";
						}

					}


				}
			}

			in.close();
			return m + "Proceso realizado con exito";
			
		}
		catch(Exception e)
		{
			return "Problemas con el archivo!" + e;
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
	
	public String ingresarPlanesPostpago(File nom){
		try{
			FileReader in = new FileReader(nom);
			BufferedReader bf = new BufferedReader(in);
			String aux, tok[];
			String m = new String();
			while (!(aux = bf.readLine().trim()).equalsIgnoreCase("#FIN"))
			{
				if (!(aux.startsWith("#")) && ! (aux.replaceAll("\\s+", "").trim().length() == 0))
				{
					tok = aux.split("\\*");
					//Ingresar plan
					try{
						 JM.agregarPlanPost(tok[0].trim(), tok[1].trim(), tok[2].trim(), tok[3].trim());
						}
						catch(ExPlan p)
						{
							m += p + "\n";
						}
				}
			}
			in.close();

			return "Proceso realizado con exito";
			
		}
		catch(Exception e)
		{
			return "Problemas con el archivo!" + e;
		}
	}
	
	 /**
     * Crea un archivo donde guarda la libreria por medio de Serializacion. El nombre del archivo a crear es proporcionado en el parametro arch de tipo String.
     * 
     * 
     * @param arch Un objeto de tipo String con el nombre con el que se creara el archivo con la libreria.
     * @return Nada
     * 
     */
    public void salvar(){
 
    	
        try{
        	JFileChooser c = new JFileChooser();
        	int v = c.showSaveDialog(new JFrame());
        	if(v == JFileChooser.APPROVE_OPTION)
        	{
        		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(c.getSelectedFile()));


        		out.writeObject(JM);
        		out.close();
        	}

        }
        catch(IOException e)
        {
        	Icon icon = new ImageIcon("fish8.png");
            JOptionPane.showMessageDialog(null, "Problemas al abrir el archivo!\n" + e + "\n", "Error", JOptionPane.ERROR_MESSAGE, icon);
        }
        catch(Exception e)
        {
        	Icon icon = new ImageIcon("fish8.png");
            JOptionPane.showMessageDialog(null, "Problemas con el archivo!\n" + e + "\n", "Error", JOptionPane.ERROR_MESSAGE, icon);
         }
 
 
    }
 
 
 
 
    /**
     * Carga una libreria de un archivo por medio de Deserializacion. El nombre del archivo es proporcionado en el parametro arch de tipo String.
     * 
     * 
     * @param arch Un objeto de tipo String con el nombre del archivo del que se cargara la libreria.
     * @return Nada
     * 
     */
    
    public void cargar(){
 
        try{
        	JFileChooser c = new JFileChooser();
        	int v = c.showOpenDialog(new JFrame());
        	if(v == JFileChooser.APPROVE_OPTION)
        	{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(c.getSelectedFile()));
            Object obj;
            obj = (Empresa)in.readObject();
            if (obj instanceof Empresa)
            {
                JM = (Empresa)obj;
                Utils.CONSECUTIVO = JM.getIdMasAlto();
            }
 
            in.close();
        	}
 
        }
        catch(IOException e)
        {
        	Icon icon = new ImageIcon("fish8.png");
            JOptionPane.showMessageDialog(null, "Problemas al abrir el archivo!\n" + e + "\n", "Error", JOptionPane.ERROR_MESSAGE, icon);
        }
        catch(Exception e)
        {
        	Icon icon = new ImageIcon("fish8.png");
            JOptionPane.showMessageDialog(null, "Problemas con el archivo!\n" + e + "\n", "Error", JOptionPane.ERROR_MESSAGE, icon);
         }
 
 
    }
 

	
	
	
	/**
	 * Escribe un reporte en un archivo de nombre arch. Recibe el nombre del archivo y el mensaje a escribir.
	 * @param arch El nombre del archivo
	 * @param mensaje El mensaje a escribir en el archivo. Debe ser un String ya formateado para escribirlo.
	 */
	public String reporte(String arch, String mensaje)
	{
		try{
			FileWriter out = new FileWriter(new File(arch));
			out.write(mensaje);
			out.close();
			return "Proceso realizado con exito";
			
		}
		catch(Exception e)
		{
			return "Problemas con el archivo!" + e;
		}
	}

	//--------------------------------------------------------------------
	
	
	

	/**
	 * This method initializes ServiciosPane	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getServiciosPane() {
		if (ServiciosPane == null) {
			ServiciosPane = new JTabbedPane();
			ServiciosPane.addTab("Menu de Servicios", null, getMenuServicios(), null);
			ServiciosPane.addTab("Cargar Clientes y Planes", null, getCargarClientesYPlanes(), null);
			ServiciosPane.addTab("Nueva Cuenta", null, getPanelCrearCuenta(), null);
			ServiciosPane.addTab("Registrar LLamada", null, getPanelRegistrarLLamada(), null);
			ServiciosPane.addTab("Agregar Recarga", null, getPanelAgregarRecarga(), null);
			ServiciosPane.addTab("Reporte Postpago", null, getPanelReportePost(), null);
			ServiciosPane.addTab("Reporte Prepago", null, getPanelReportePre(), null);
			ChangeListener changeListener = new ChangeListener() {
			      public void stateChanged(ChangeEvent changeEvent) {
			        reset();
			      }
			    };
			    ServiciosPane.addChangeListener(changeListener);
		}
		return ServiciosPane;
	}

	/**
	 * This method initializes MenuServicios	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getMenuServicios() {
		if (MenuServicios == null) {
			TituloMenu = new JLabel();
			TituloMenu.setText("Servicios JaveMovil");
			TituloMenu.setFont(new Font("Chalkduster", Font.BOLD, 24));
			TituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
			MenuServicios = new JPanel();
			MenuServicios.setLayout(new BorderLayout());
			MenuServicios.add(TituloMenu, BorderLayout.NORTH);
			MenuServicios.add(getPanelAcciones(), BorderLayout.WEST);
			MenuServicios.add(getPanelReportes(), BorderLayout.EAST);
			MenuServicios.add(getPanelSerializacion(), BorderLayout.SOUTH);
			try{
			BufferedImage myPicture = ImageIO.read(new File("cel.png"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			//add(picLabel);
			MenuServicios.add(picLabel, BorderLayout.CENTER);
			}catch(Exception e)
			{
				
			}
			
			
		}
		return MenuServicios;
	}
	
	/**
	 * This method initializes BMenuCargar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	
	private JButton getBMenuCargar() {
		if (BMenuCargar == null) {
			BMenuCargar = new JButton();
			BMenuCargar.setFont(new Font("Chalkduster", Font.BOLD, 18));
			BMenuCargar.setText("Cargar Clientes y Planes");
			BMenuCargar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getServiciosPane().setSelectedIndex(1);
				}
			});
		}
		return BMenuCargar;
	}

	
	/**
	 * This method initializes BArgegarCuenta	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBArgegarCuenta() {
		if (BArgegarCuenta == null) {
			BArgegarCuenta = new JButton();
			BArgegarCuenta.setFont(new Font("Chalkduster", Font.BOLD, 18));
			BArgegarCuenta.setText("Agregar Cuenta");
			BArgegarCuenta.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getServiciosPane().setSelectedIndex(2);
				}
			});
		}
		return BArgegarCuenta;
	}

	/**
	 * This method initializes BRegistrarLLamada	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBRegistrarLLamada() {
		if (BRegistrarLLamada == null) {
			BRegistrarLLamada = new JButton();
			BRegistrarLLamada.setFont(new Font("Chalkduster", Font.BOLD, 18));
			BRegistrarLLamada.setText("Registrar LLamada");
			BRegistrarLLamada.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getServiciosPane().setSelectedIndex(3);
				}
			});
		}
		return BRegistrarLLamada;
	}

	/**
	 * This method initializes BAgregarRecarga	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBAgregarRecarga() {
		if (BAgregarRecarga == null) {
			BAgregarRecarga = new JButton();
			BAgregarRecarga.setFont(new Font("Chalkduster", Font.BOLD, 18));
			BAgregarRecarga.setText("Agregar Recarga");
			BAgregarRecarga.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getServiciosPane().setSelectedIndex(4);
				}
			});
		}
		return BAgregarRecarga;
	}

	/**createImage
	 * This method initializes BReportePost	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBReportePost() {
		if (BReportePost == null) {
			BReportePost = new JButton();
			BReportePost.setFont(new Font("Chalkduster", Font.BOLD, 18));
			BReportePost.setText("Reporte Postpago");
			BReportePost.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getServiciosPane().setSelectedIndex(5);
				}
			});
		}
		return BReportePost;
	}

	/**
	 * This method initializes BReportePre	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBReportePre() {
		if (BReportePre == null) {
			BReportePre = new JButton();
			BReportePre.setFont(new Font("Chalkduster", Font.BOLD, 18));
			BReportePre.setText("Reporte Prepago");
			BReportePre.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getServiciosPane().setSelectedIndex(6);
				}
			});
		}
		return BReportePre;
	}

	/**
	 * This method initializes BReporteIngresos	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBReporteIngresos() {
		if (BReporteIngresos == null) {
			BReporteIngresos = new JButton();
			BReporteIngresos.setText("Reporte ingresos Esperados");
		}
		return BReporteIngresos;
	}

	/**
	 * This method initializes BCargarSistema	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBCargarSistema() {
		if (BCargarSistema == null) {
			BCargarSistema = new JButton();
			BCargarSistema.setFont(new Font("Chalkduster", Font.BOLD, 18));
			BCargarSistema.setText("Cargar Sistema");
			BCargarSistema.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cargar();				}
			});
		}
		return BCargarSistema;
	}

	/**
	 * This method initializes BSalvarSistema	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBSalvarSistema() {
		if (BSalvarSistema == null) {
			BSalvarSistema = new JButton();
			BSalvarSistema.setFont(new Font("Chalkduster", Font.BOLD, 18));
			BSalvarSistema.setText("Salvar Sistema");
			BSalvarSistema.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salvar();
				}
			});
		}
		return BSalvarSistema;
	}

	/**
	 * This method initializes PanelAcciones	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelAcciones() {
		if (PanelAcciones == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(4);
			gridLayout.setColumns(1);
			PanelAcciones = new JPanel();
			PanelAcciones.setLayout(gridLayout);
			PanelAcciones.add(getBMenuCargar(), null);
			PanelAcciones.add(getBArgegarCuenta(), null);
			PanelAcciones.add(getBRegistrarLLamada(), null);
			PanelAcciones.add(getBAgregarRecarga(), null);
		}
		return PanelAcciones;
	}

	/**
	 * This method initializes PanelReportes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelReportes() {
		if (PanelReportes == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(2);
			gridLayout1.setColumns(1);
			PanelReportes = new JPanel();
			PanelReportes.setLayout(gridLayout1);
			PanelReportes.add(getBReportePost(), null);
			PanelReportes.add(getBReportePre(), null);
			//PanelReportes.add(getBReporteIngresos(), null);
		}
		return PanelReportes;
	}

	/**
	 * This method initializes PanelSerializacion	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelSerializacion() {
		if (PanelSerializacion == null) {
			GridLayout gridLayout2 = new GridLayout();
			gridLayout2.setRows(1);
			gridLayout2.setColumns(2);
			PanelSerializacion = new JPanel();
			PanelSerializacion.setLayout(gridLayout2);
			PanelSerializacion.add(getBCargarSistema(), null);
			PanelSerializacion.add(getBSalvarSistema(), null);
		}
		return PanelSerializacion;
	}

	/**
	 * This method initializes CargarClientesYPlanes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getCargarClientesYPlanes() {
		if (CargarClientesYPlanes == null) {
			TituloCargarClientesYplanes = new JLabel();
			TituloCargarClientesYplanes.setText("Cargar Clientes y Planes");
			TituloCargarClientesYplanes.setHorizontalAlignment(SwingConstants.CENTER);
			CargarClientesYPlanes = new JPanel();
			CargarClientesYPlanes.setLayout(new BorderLayout());
			CargarClientesYPlanes.add(TituloCargarClientesYplanes, BorderLayout.NORTH);
			CargarClientesYPlanes.add(getPanelRegresar(), BorderLayout.SOUTH);
			CargarClientesYPlanes.add(getBotonesCargar(), BorderLayout.CENTER);
		}
		return CargarClientesYPlanes;
	}

	/**
	 * This method initializes BotonesCargar	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getBotonesCargar() {
		if (BotonesCargar == null) {
			GridLayout gridLayout3 = new GridLayout();
			gridLayout3.setRows(3);
			gridLayout3.setHgap(14);
			gridLayout3.setVgap(27);
			gridLayout3.setColumns(1);
			BotonesCargar = new JPanel();
			BotonesCargar.setLayout(gridLayout3);
			BotonesCargar.add(getBCargarClientes(), null);
			BotonesCargar.add(getBCargarPlPos(), null);
			
			BotonesCargar.add(getBCargarPlPre(), null);
		}
		return BotonesCargar;
	}

	/**
	 * This method initializes BCargarClientes	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBCargarClientes() {
		if (BCargarClientes == null) {
			Icon icon = new ImageIcon("fish14.png");
			BCargarClientes = new JButton(icon);
			BCargarClientes.setFont(new Font("Chalkduster", Font.BOLD, 18));
			BCargarClientes.setText("Seleccionar archivo Clientes");
			BCargarClientes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//File Chooser
					  JFileChooser chooser = new JFileChooser();
					    //FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files",
					      //  "txt");
					    //chooser.setFileFilter();
					    int returnVal = chooser.showOpenDialog(new JFrame());
					    if(returnVal == JFileChooser.APPROVE_OPTION) {
					    	
					    	
					    	
					    	JDialog d = new JDialog();
					    	
					    	
					    	/*JTextPane m = new JTextPane();
					    	m.setText("Se eligio el archivo \n" + chooser.getSelectedFile().getName() + " \n \n" + ingresarClientes(chooser.getSelectedFile()));
					    	m.setBackground(Color.LIGHT_GRAY);
					    	m.setMargin(new Insets(130,20,180,20));
					          
					    	m.setEditable(false);
					    	m.setCursor(null);*/
					    	//d.add(m);
					    	d.setSize(400, 400);
					    	//d.setTitle("Apertura de archivo");
					    	d.setLocationRelativeTo(jContentPane);
					    	Icon icon = new ImageIcon("pets1.png");
					    	
					    	
					    	JOptionPane.showMessageDialog(d, "Se eligio el archivo \n" + chooser.getSelectedFile().getName() + " \n \n" + ingresarClientes(chooser.getSelectedFile()),"Clientes Ingresados", JOptionPane.INFORMATION_MESSAGE, icon);
					    	
					    	//d.setVisible(true);
					    	/*
					    	try {
					    	    Thread.sleep(3000);                 //1000 milliseconds is one second.
					    	} catch(InterruptedException ex) {
					    	    Thread.currentThread().interrupt();
					    	}	*/
					    	//d.setVisible(false);
					    	//d.dispose();
					    	
					    }
					    
				}
			});
		}
		return BCargarClientes;
	}

	/**
	 * This method initializes BCargarPlPos	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBCargarPlPos() {
		if (BCargarPlPos == null) {
			BCargarPlPos = new JButton(new ImageIcon("elephant6.png"));
			BCargarPlPos.setFont(new Font("Chalkduster", Font.BOLD, 18));
			BCargarPlPos.setText("Seleccionar archivo Planes Postpago");
			BCargarPlPos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//File Chooser
					  JFileChooser chooser = new JFileChooser();
					   /* FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files",
					        "txt");
					    chooser.setFileFilter(filter);*/
					    int returnVal = chooser.showOpenDialog(new JFrame());
					    if(returnVal == JFileChooser.APPROVE_OPTION) {
					    	
					    	
					    	
					    	
					    	JDialog d = new JDialog();


					    	/*JTextPane m = new JTextPane();
					    	m.setText("Se eligio el archivo \n" + chooser.getSelectedFile().getName() + " \n \n" + ingresarClientes(chooser.getSelectedFile()));
					    	m.setBackground(Color.LIGHT_GRAY);
					    	m.setMargin(new Insets(130,20,180,20));
					          
					    	m.setEditable(false);
					    	m.setCursor(null);*/
					    	//d.add(m);
					    	d.setSize(400, 400);
					    	//d.setTitle("Apertura de archivo");
					    	d.setLocationRelativeTo(jContentPane);
					    	icon = new ImageIcon("pets1.png");

					    	JOptionPane.showMessageDialog(d, "Se eligio el archivo \n" + chooser.getSelectedFile().getName() + " \n \n" + ingresarPlanesPostpago(chooser.getSelectedFile()),"Clientes Ingresados", JOptionPane.INFORMATION_MESSAGE, icon);
					    	//d.setVisible(true);
					    }
				}
			});
		}
		return BCargarPlPos;
	}

	/**
	 * This method initializes BCargarPlPre	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBCargarPlPre() {
		if (BCargarPlPre == null) {
			BCargarPlPre = new JButton(new ImageIcon("sheep1.png"));
			BCargarPlPre.setFont(new Font("Chalkduster", Font.BOLD, 18));
			BCargarPlPre.setText("Seleccionar archivo Planes prepago");
			BCargarPlPre.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//File Chooser
					  JFileChooser chooser = new JFileChooser();
					    /*FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files",
					        "txt");
					    chooser.setFileFilter(filter);*/
					    int returnVal = chooser.showOpenDialog(new JFrame());
					    if(returnVal == JFileChooser.APPROVE_OPTION) {
					    	

					    	JDialog d = new JDialog();


					    	/*JTextPane m = new JTextPane();
					    	m.setText("Se eligio el archivo \n" + chooser.getSelectedFile().getName() + " \n \n" + ingresarClientes(chooser.getSelectedFile()));
					    	m.setBackground(Color.LIGHT_GRAY);
					    	m.setMargin(new Insets(130,20,180,20));
					          
					    	m.setEditable(false);
					    	m.setCursor(null);*/
					    	//d.add(m);
					    	d.setSize(400, 400);
					    	//d.setTitle("Apertura de archivo");
					    	d.setLocationRelativeTo(jContentPane);
					    	icon = new ImageIcon("pets1.png");

					    	JOptionPane.showMessageDialog(d, "Se eligio el archivo \n" + chooser.getSelectedFile().getName() + " \n \n" + ingresarPlanesPrepago(chooser.getSelectedFile()),"Clientes Ingresados", JOptionPane.INFORMATION_MESSAGE,icon);
					    	//d.setVisible(true);
					    	}
				}
			});
		}
		return BCargarPlPre;
	}

	/**
	 * This method initializes BRegresar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBRegresar() {
		if (BRegresar == null) {
			BRegresar = new JButton();
			BRegresar.setText("Regresar");
			BRegresar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getServiciosPane().setSelectedIndex(0);
					reset();
					
				}
			});
		}
		return BRegresar;
	}

	/**
	 * This method initializes PanelRegresar	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRegresar() {
		if (PanelRegresar == null) {
			GridLayout gridLayout4 = new GridLayout();
			gridLayout4.setRows(1);
			gridLayout4.setColumns(3);
			PanelRegresar = new JPanel();
			PanelRegresar.setLayout(gridLayout4);
		
			PanelRegresar.add(getBRegresar(),null);
			
			
		}
		return PanelRegresar;
	}



	

	/**
	 * This method initializes PanelCrearCuenta	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelCrearCuenta() {
		if (PanelCrearCuenta == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setVgap(41);
			borderLayout.setHgap(0);
			TituloCuenta = new JLabel();
			TituloCuenta.setText("Nueva Cuenta");
			TituloCuenta.setHorizontalAlignment(SwingConstants.CENTER);
			PanelCrearCuenta = new JPanel();
			PanelCrearCuenta.setLayout(borderLayout);
			PanelCrearCuenta.add(TituloCuenta, BorderLayout.NORTH);
			PanelCrearCuenta.add(getPanelCuentaRegresar(), BorderLayout.SOUTH);
			PanelCrearCuenta.add(getPanelOpcionesCuentaNueva(), BorderLayout.CENTER);
		}
		return PanelCrearCuenta;
	}

	/**
	 * This method initializes PanelOpcionesCuentaNueva	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelOpcionesCuentaNueva() {
		if (PanelOpcionesCuentaNueva == null) {
			LabelCuentaTipo = new JLabel();
			LabelCuentaTipo.setText("Tipo:");
			LabelCuentaPlan = new JLabel();
			LabelCuentaPlan.setText("Plan:");
			LabelCuentaCliente = new JLabel();
			LabelCuentaCliente.setText("Cliente:");
			LabelCuentaNumero = new JLabel();
			LabelCuentaNumero.setText("Numero:");
			
			GridLayout gridLayout5 = new GridLayout();
			gridLayout5.setRows(4);
			gridLayout5.setHgap(30);
			gridLayout5.setVgap(20);
			gridLayout5.setColumns(2);
			PanelOpcionesCuentaNueva = new JPanel();
			PanelOpcionesCuentaNueva.setLayout(gridLayout5);
			
			PanelOpcionesCuentaNueva.add(LabelCuentaTipo, null);
			
			PanelOpcionesCuentaNueva.add(getComboCuentaTipo(), null);
			
			PanelOpcionesCuentaNueva.add(LabelCuentaPlan, null);
			PanelOpcionesCuentaNueva.add(getComboCuentaPlan(), null);
			
			
			
			PanelOpcionesCuentaNueva.add(LabelCuentaCliente, null);
			PanelOpcionesCuentaNueva.add(getComboCuentaCliente(), null);
			
			
			
			
			
			PanelOpcionesCuentaNueva.add(LabelCuentaNumero, null);
			PanelOpcionesCuentaNueva.add(getTextCuentaNumero(), null);
		
			
			
		}
		return PanelOpcionesCuentaNueva;
	}

	/**
	 * This method initializes TextCuentaNumero	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTextCuentaNumero() {
		if (TextCuentaNumero == null) {
			TextCuentaNumero = new JTextField();
		}
		return TextCuentaNumero;
	}

	/**
	 * This method initializes ComboCuentaCliente	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboCuentaCliente() {
		if (ComboCuentaCliente == null) {
			ComboCuentaCliente = new JComboBox();
		}
		return ComboCuentaCliente;
	}

	/**
	 * This method initializes ComboCuentaPlan	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboCuentaPlan() {
		if (ComboCuentaPlan == null) {
			ComboCuentaPlan = new JComboBox();
		}
		return ComboCuentaPlan;
	}

	/**
	 * This method initializes ComboCuentaTipo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboCuentaTipo() {
		if (ComboCuentaTipo == null) {
			ComboCuentaTipo = new JComboBox();
			ComboCuentaTipo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					String s = (String) ComboCuentaTipo.getSelectedItem();
					if (s.equalsIgnoreCase("prepago"))
					{

						getComboCuentaPlan().removeAllItems();
						getComboCuentaCliente().removeAllItems();
						
						if(! JM.getPlanes().isEmpty()){
							for(Plan p: JM.mostrarPlanesPre()){
								getComboCuentaPlan().addItem(p.getNombre() + " (valor minuto " + p.getValorMinuto() + ")");
							}
						}

						if(!JM.getClientes().isEmpty()){
							for(Cliente c: JM.mostrarClientes()){
								getComboCuentaCliente().addItem(c.getCedula() +" - " + c.getNombre());
							}
						}
						
						
					}
					if (s.equalsIgnoreCase("postpago"))
					{
						getComboCuentaPlan().removeAllItems();
						getComboCuentaCliente().removeAllItems();
						if(!JM.getPlanes().isEmpty()){
							for(Plan p: JM.mostrarPlanesPost())
							{
								getComboCuentaPlan().addItem(p.getNombre()  + " (valor minuto " + p.getValorMinuto() + ")");
							}
						}
						
						if(!JM.getClientes().isEmpty()){
							for(Cliente c: JM.mostrarClientes()){
								getComboCuentaCliente().addItem(c.getCedula() +" - " + c.getNombre());
							}
						}
					}
					
					
					
				}
			});
			ComboCuentaTipo.addItem("");
			ComboCuentaTipo.addItem("Prepago");
			ComboCuentaTipo.addItem("Postpago");
		}
		return ComboCuentaTipo;
	}

	/**
	 * This method initializes PanelCuentaRegresar	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelCuentaRegresar() {
		if (PanelCuentaRegresar == null) {
		
			GridLayout gridLayout6 = new GridLayout();
			gridLayout6.setRows(1);
			gridLayout6.setColumns(3);
			PanelCuentaRegresar = new JPanel();
			PanelCuentaRegresar.setLayout(gridLayout6);
			PanelCuentaRegresar.add(getBCuentaCrear(), null);
			PanelCuentaRegresar.add(getBCuentaRegresar(), null);
			

		}
		return PanelCuentaRegresar;
	}

	/**
	 * This method initializes BCuentaCrear	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBCuentaCrear() {
		if (BCuentaCrear == null) {
			BCuentaCrear = new JButton();
			BCuentaCrear.setText("Crear Cuenta");
			BCuentaCrear.setFont(new Font("Chalkduster", Font.BOLD, 18));
			BCuentaCrear.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String t,p,c,n;
					t =  (String)getComboCuentaTipo().getSelectedItem();
					p =  (String)getComboCuentaPlan().getSelectedItem();
					c =  (String)getComboCuentaCliente().getSelectedItem();
					n =  (String)getTextCuentaNumero().getText();

					if(n.isEmpty() || p.isEmpty() || t.isEmpty() || c.isEmpty() )
					{
						getTextCuentaNumero().setText("");
						getComboCuentaTipo().setSelectedItem(0);
						getComboCuentaPlan().removeAllItems();
						getComboCuentaCliente().removeAllItems();

						JDialog d = new JDialog();
						d.setSize(400, 400);
						d.setLocationRelativeTo(jContentPane);

						String m = "No se han ingresado todos los datos!";
						icon = new ImageIcon("fish8.png");
						JOptionPane.showMessageDialog(d, m, "Error", JOptionPane.INFORMATION_MESSAGE,icon);

					}
					else
					{
						if(!Utils.isNumeric(n))
						{
							JDialog d = new JDialog();
							d.setSize(400, 400);
							d.setLocationRelativeTo(jContentPane);
							icon = new ImageIcon("fish8.png");
							JOptionPane.showMessageDialog(d, "No se admiten letras en el campo [Numero]", "Error", JOptionPane.ERROR_MESSAGE, icon);

						}
						else
						{
							try{


								String s = JM.agregarCuenta(t, p.split("\\(")[0].trim(), c.split("-")[0].trim(), n);

								JDialog d = new JDialog();

								d.setSize(400, 400);

								d.setLocationRelativeTo(jContentPane);
								icon = new ImageIcon("gecko2.png");
								JOptionPane.showMessageDialog(d, s, "Cuenta Agregada", JOptionPane.INFORMATION_MESSAGE, icon);

							}
							catch(Exception ee)
							{
								JDialog d = new JDialog();


								d.setSize(400, 400);

								d.setLocationRelativeTo(jContentPane);
								icon = new ImageIcon("fish8.png");
								JOptionPane.showMessageDialog(d, ee, "Error", JOptionPane.ERROR_MESSAGE, icon);
							}
						}
					}

				}
			});
		}
		return BCuentaCrear;
	}

	/**
	 * This method initializes PanelRegistrarLLamada	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRegistrarLLamada() {
		if (PanelRegistrarLLamada == null) {
			LabelTituloLlamada = new JLabel();
			LabelTituloLlamada.setText("Registrar LLamada");
			LabelTituloLlamada.setHorizontalAlignment(SwingConstants.CENTER);
			PanelRegistrarLLamada = new JPanel();
			PanelRegistrarLLamada.setLayout(new BorderLayout());
			PanelRegistrarLLamada.add(LabelTituloLlamada, BorderLayout.NORTH);
			PanelRegistrarLLamada.add(getPanelLLamadaRegresar(), BorderLayout.SOUTH);
			PanelRegistrarLLamada.add(getPanelLLamadaOpciones(), BorderLayout.CENTER);
		}
		return PanelRegistrarLLamada;
	}

	/**
	 * This method initializes PanelLLamadaOpciones	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelLLamadaOpciones() {
		if (PanelLLamadaOpciones == null) {
			LabelLLamadaDuracion = new JLabel();
			LabelLLamadaDuracion.setText("Duracion (min):");
			LabelLLamadaDestino = new JLabel();
			LabelLLamadaDestino.setText("Destino:");
			LabelLLamadaCuenta = new JLabel();
			LabelLLamadaCuenta.setText("Cuenta:");
			LabelLLamadaTipo = new JLabel();
			LabelLLamadaTipo.setText("Tipo:");
			LabelLLamadaPaisDestino = new JLabel();
			LabelLLamadaPaisDestino.setText("Pais destino:");
			LabelLLamadaFecha = new JLabel();
			LabelLLamadaFecha.setText("Fecha Llamada:");
			GridLayout gridLayout7 = new GridLayout();
			gridLayout7.setRows(6);
			gridLayout7.setVgap(20);
			gridLayout7.setHgap(30);
			gridLayout7.setColumns(2);
			PanelLLamadaOpciones = new JPanel();
			PanelLLamadaOpciones.setLayout(gridLayout7);
			
			PanelLLamadaOpciones.add(LabelLLamadaCuenta, null);
			PanelLLamadaOpciones.add(getComboLLamadaCuenta(), null);
			PanelLLamadaOpciones.add(LabelLLamadaTipo, null);
			PanelLLamadaOpciones.add(getComboLLamadaTipo(), null);
			PanelLLamadaOpciones.add(LabelLLamadaFecha, null);
			PanelLLamadaOpciones.add(getPanelLLamadaFecha(), null);
			PanelLLamadaOpciones.add(LabelLLamadaPaisDestino, null);
			PanelLLamadaOpciones.add(getComboLLamadaPaisDestino(), null);
			PanelLLamadaOpciones.add(LabelLLamadaDestino, null);
			PanelLLamadaOpciones.add(getTextLLamadaDestino(), null);
			PanelLLamadaOpciones.add(LabelLLamadaDuracion, null);
			PanelLLamadaOpciones.add(getTextLLamadaDuracion(), null);
			
			
			
			
			
		}
		return PanelLLamadaOpciones;
	}

	/**
	 * This method initializes TextLLamadaDuracion	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTextLLamadaDuracion() {
		if (TextLLamadaDuracion == null) {
			TextLLamadaDuracion = new JTextField();
		}
		return TextLLamadaDuracion;
	}

	/**
	 * This method initializes TextLLamadaDestino	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTextLLamadaDestino() {
		if (TextLLamadaDestino == null) {
			TextLLamadaDestino = new JTextField();
		}
		return TextLLamadaDestino;
	}

	/**
	 * This method initializes PanelLLamadaFecha	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelLLamadaFecha() {
		if (PanelLLamadaFecha == null) {
			
			GridLayout gridLayout8 = new GridLayout();
			gridLayout8.setRows(1);
			gridLayout8.setVgap(9);
			gridLayout8.setHgap(10);
			gridLayout8.setColumns(3);
			PanelLLamadaFecha = new JPanel();
			PanelLLamadaFecha.setLayout(gridLayout8);
			PanelLLamadaFecha.add(getComboLlamadaAno(), null);
			PanelLLamadaFecha.add(getComboLlamadaMes(), null);

			PanelLLamadaFecha.add(getComboLlamadaDia(), null);
		}
		return PanelLLamadaFecha;
	}

	/**
	 * This method initializes ComboLlamadaDia	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboLlamadaDia() {
		if (ComboLlamadaDia == null) {
			ComboLlamadaDia = new JComboBox();
			ComboLlamadaDia.addItem("");
			ComboLlamadaDia.setEnabled(false);


		}
		return ComboLlamadaDia;
	}

	/**
	 * This method initializes ComboLlamadaMes	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboLlamadaMes() {
		if (ComboLlamadaMes == null) {
			ComboLlamadaMes = new JComboBox();
			
			ComboLlamadaMes.addItem("");

			ComboLlamadaMes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					if(ComboLlamadaMes.getItemCount() != 0)
					{
						if(!((String)ComboLlamadaMes.getSelectedItem()).equalsIgnoreCase(""))
						{
							ComboLlamadaDia.setEnabled(true);
							ComboLlamadaDia.removeAllItems();
						}

						String m = (String)ComboLlamadaMes.getSelectedItem();
						int l =1;
						if(m.equalsIgnoreCase("Enero") || m.equalsIgnoreCase("Marzo") || m.equalsIgnoreCase("Mayo") || m.equalsIgnoreCase("Julio") || m.equalsIgnoreCase("Agosto") || m.equalsIgnoreCase("Octubre") || m.equalsIgnoreCase("Diciembre"))
						{
							l=32;
						}
						else
						{
							if(m.equalsIgnoreCase("Febrero"))
							{

								GregorianCalendar g = Utils.convertirCadenaFecha((String)getComboLlamadaAno().getSelectedItem() + "-00-00");
								if(g.isLeapYear(Integer.parseInt((String)getComboLlamadaAno().getSelectedItem()))){

									l=30;
								}
								else
								{
									l=29;
								}
							}
							else
							{
								l=31;
							}
						}


						ComboLlamadaDia.addItem("");
						for(int i = 1; i< l; i++)
						{
							ComboLlamadaDia.addItem(String.valueOf(i));
						}
					}

				}
			});

			
			ComboLlamadaMes.setEnabled(false);
		}
		return ComboLlamadaMes;
	}

	/**
	 * This method initializes ComboLlamadaAno	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboLlamadaAno() {
		if (ComboLlamadaAno == null) {
			ComboLlamadaAno = new JComboBox();
			ComboLlamadaAno.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(!((String)ComboLlamadaAno.getSelectedItem()).equalsIgnoreCase(""))
					{
						ComboLlamadaMes.setEnabled(true);
						ComboLlamadaMes.removeAllItems();
						
						ComboLlamadaMes.addItem("");
						for(int i = 0; i< 12; i++)
						{
							ComboLlamadaMes.addItem(Utils.darMes(i));
						}
						ComboLlamadaDia.removeAllItems();
						
					}
						
				}
			});
			ComboLlamadaAno.addItem("");
			for(int i = 2000; i< 2021; i++)
			{
				ComboLlamadaAno.addItem(String.valueOf(i));
			}
		}
		return ComboLlamadaAno;
	}

	/**
	 * This method initializes ComboLLamadaPaisDestino	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboLLamadaPaisDestino() {
		if (ComboLLamadaPaisDestino == null) {
			ComboLLamadaPaisDestino = new JComboBox();
		
			ComboLLamadaPaisDestino.addItem("");
			String[] val = new String[Indicativo.values().length];
			int c = 0;
			for(Indicativo i: Indicativo.values())
			{
				val[c] = i.name();
				c++;
			}
			Collections.sort(Arrays.asList(val));
			
			for(int k = 0; k<val.length; k++)
				ComboLLamadaPaisDestino.addItem(val[k]);
			ComboLLamadaPaisDestino.setEnabled(false);
			
			
		}
		return ComboLLamadaPaisDestino;
	}

	/**
	 * This method initializes ComboLLamadaTipo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboLLamadaTipo() {
		if (ComboLLamadaTipo == null) {
			ComboLLamadaTipo = new JComboBox();
			ComboLLamadaTipo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String s = (String)ComboLLamadaTipo.getSelectedItem();
					if(s.equalsIgnoreCase("Internacional"))
					{
						getComboLLamadaPaisDestino().setEnabled(true);
					}
					else
					{
						getComboLLamadaPaisDestino().setSelectedIndex(0);
						getComboLLamadaPaisDestino().setEnabled(false);
					}

				}
			});
			ComboLLamadaTipo.addItem("");
			ComboLLamadaTipo.addItem("INTERNACIONAL");
			ComboLLamadaTipo.addItem("NACIONAL");
		}
		return ComboLLamadaTipo;
	}

	/**
	 * This method initializes ComboLLamadaCuenta	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboLLamadaCuenta() {
		if (ComboLLamadaCuenta == null) {
			ComboLLamadaCuenta = new JComboBox();
			ComboLLamadaCuenta.addItem("");
			
		}

		
		return ComboLLamadaCuenta;
	}

	/**
	 * This method initializes PanelLLamadaRegresar	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelLLamadaRegresar() {
		if (PanelLLamadaRegresar == null) {
			GridLayout gridLayout9 = new GridLayout();
			gridLayout9.setRows(1);
			gridLayout9.setColumns(3);
			PanelLLamadaRegresar = new JPanel();
			PanelLLamadaRegresar.setLayout(gridLayout9);
			PanelLLamadaRegresar.add(getBRegLLamada(), null);
			PanelLLamadaRegresar.add(getBRegresarLLamada(), null);
			
		}
		return PanelLLamadaRegresar;
	}

	/**
	 * This method initializes BRegLLamada	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBRegLLamada() {
		if (BRegLLamada == null) {
			BRegLLamada = new JButton();
			BRegLLamada.setText("Registrar LLamada");
			BRegLLamada.setFont(new Font("Chalkduster", Font.BOLD, 18));
			BRegLLamada.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String t,p,c,de, du, a, me, di;
					try{
					t =  (String)getComboLLamadaTipo().getSelectedItem();
					a = (String)getComboLlamadaAno().getSelectedItem();
					me = (String)getComboLlamadaMes().getSelectedItem();
					di = (String)getComboLlamadaDia().getSelectedItem();
					p =  (String)getComboLLamadaPaisDestino().getSelectedItem();
					c =  (String)getComboLLamadaCuenta().getSelectedItem();
					de =  (String)getTextLLamadaDestino().getText();
					du =  (String)getTextLLamadaDuracion().getText();
					JDialog d = new JDialog();
					d.setSize(400, 400);
					d.setLocationRelativeTo(jContentPane);
					String m = new String();

					
					if( (a.isEmpty()  || t.isEmpty()  || c.isEmpty() || me.isEmpty() || di.isEmpty() || de.isEmpty() || du.isEmpty()))
					{
						
						getComboLLamadaTipo().setSelectedIndex(0);
						getComboLlamadaAno().setSelectedIndex(0);
						//getComboLlamadaMes().setSelectedIndex(0);
						if(getComboLlamadaMes().getItemCount() != 0)
							getComboLlamadaMes().removeAllItems();
						//getComboLlamadaDia().setSelectedIndex(0);
						if(getComboLlamadaDia().getItemCount() != 0)
							getComboLlamadaDia().removeAllItems();
						getComboLLamadaPaisDestino().setSelectedIndex(0);
						//getComboLLamadaCuenta().setSelectedIndex(0);
						getTextLLamadaDestino().setText("");
						getTextLLamadaDuracion().setText("");



						m = "No se han ingresado todos los datos!";
						icon = new ImageIcon("fish8.png");
						JOptionPane.showMessageDialog(d, m, "Error", JOptionPane.INFORMATION_MESSAGE,icon);

					}
					else
					{
						if(!Utils.isNumeric(du) || !Utils.isNumeric(de))
						{

							icon = new ImageIcon("fish8.png");
							JOptionPane.showMessageDialog(d, "No se admiten letras en los campos [Destino] o [Duracion]", "Error", JOptionPane.ERROR_MESSAGE, icon);					
							getTextLLamadaDestino().setText("");
							getTextLLamadaDuracion().setText("");
							
							
						}
						else
						{
							if(t.equalsIgnoreCase("Internacional") && p.isEmpty())
							{
								getComboLLamadaTipo().setSelectedIndex(0);
								getComboLlamadaAno().setSelectedIndex(0);
								getComboLlamadaMes().setSelectedIndex(0);
								getComboLlamadaDia().setSelectedIndex(0);
								getComboLLamadaPaisDestino().setSelectedIndex(0);
								getComboLLamadaCuenta().setSelectedIndex(0);
								getTextLLamadaDestino().setText("");
								getTextLLamadaDuracion().setText("");



								m = "No se han ingresado todos los datos!";
								icon = new ImageIcon("fish8.png");
								JOptionPane.showMessageDialog(d, m, "Error", JOptionPane.INFORMATION_MESSAGE,icon);
							}
							else
							{
								try{


									String s = JM.registrarLLamada(t, c.split("\\s+")[1].trim(), Utils.convertirCadenaFecha(a + "-" + String.valueOf(Utils.darNumMes(me) + 1) + "-" + di), de, du, Indicativo.darIndicativo(p));
									icon = new ImageIcon("halloween276.png");
									JOptionPane.showMessageDialog(d, s, "LLamada Registrada", JOptionPane.INFORMATION_MESSAGE, icon);

								}
								catch(Exception ee)
								{

									icon = new ImageIcon("fish8.png");
									JOptionPane.showMessageDialog(d, ee, "Error", JOptionPane.ERROR_MESSAGE, icon);
								}
							}
						}
					}

					}
					catch(NullPointerException nu)
					{
						String m = "No se han ingresado todos los datos!";
						icon = new ImageIcon("fish8.png");
						
						JOptionPane.showMessageDialog(new JFrame(), m, "Error", JOptionPane.INFORMATION_MESSAGE,icon);
					}
				}



			});
		}
		return BRegLLamada;
	}

	/**
	 * This method initializes PanelAgregarRecarga	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelAgregarRecarga() {
		if (PanelAgregarRecarga == null) {
			LabelTituloRecarga = new JLabel();
			LabelTituloRecarga.setText("Agregar Recarga");
			LabelTituloRecarga.setHorizontalAlignment(SwingConstants.CENTER);
			PanelAgregarRecarga = new JPanel();
			PanelAgregarRecarga.setLayout(new BorderLayout());
			PanelAgregarRecarga.add(LabelTituloRecarga, BorderLayout.NORTH);
			PanelAgregarRecarga.add(getPanelRecargaRegresar(), BorderLayout.SOUTH);
			PanelAgregarRecarga.add(getPanelOpcionesRecarga(), BorderLayout.CENTER);
		}
		return PanelAgregarRecarga;
	}

	/**
	 * This method initializes PanelOpcionesRecarga	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelOpcionesRecarga() {
		if (PanelOpcionesRecarga == null) {
			LabelRecargaValor = new JLabel();
			LabelRecargaValor.setText("Valor:");
			LabelRecargaFecha = new JLabel();
			LabelRecargaFecha.setText("Fecha:");
			LabelRecargaCuenta = new JLabel();
			LabelRecargaCuenta.setText("Cuenta Prepago:");
			GridLayout gridLayout10 = new GridLayout();
			gridLayout10.setRows(3);
			gridLayout10.setHgap(40);
			gridLayout10.setVgap(84);
			gridLayout10.setColumns(2);
			PanelOpcionesRecarga = new JPanel();
			PanelOpcionesRecarga.setLayout(gridLayout10);
			PanelOpcionesRecarga.add(LabelRecargaCuenta, null);
			
			PanelOpcionesRecarga.add(getComboRecargaCuenta(), null);
			
			
			PanelOpcionesRecarga.add(LabelRecargaFecha, null);
			PanelOpcionesRecarga.add(getPanelRecargaFecha(), null);
			
			PanelOpcionesRecarga.add(LabelRecargaValor, null);
			PanelOpcionesRecarga.add(getTextRecargaValor(), null);
			
		}
		return PanelOpcionesRecarga;
	}

	/**
	 * This method initializes ComboRecargaCuenta	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboRecargaCuenta() {
		if (ComboRecargaCuenta == null) {
			ComboRecargaCuenta = new JComboBox();
			ComboRecargaCuenta.addItem("");
		}
		return ComboRecargaCuenta;
	}

	/**
	 * This method initializes TextRecargaValor	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTextRecargaValor() {
		if (TextRecargaValor == null) {
			TextRecargaValor = new JTextField();
		}
		return TextRecargaValor;
	}

	/**
	 * This method initializes PanelRecargaFecha	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRecargaFecha() {
		if (PanelRecargaFecha == null) {
			GridLayout gridLayout11 = new GridLayout();
			gridLayout11.setRows(1);
			gridLayout11.setColumns(3);
			PanelRecargaFecha = new JPanel();
			PanelRecargaFecha.setLayout(gridLayout11);
			PanelRecargaFecha.add(getComboRecargaAno(), null);
			PanelRecargaFecha.add(getComboRecargaMes(), null);
			PanelRecargaFecha.add(getComboRecargaDia(), null);
		}
		return PanelRecargaFecha;
	}

	/**
	 * This method initializes ComboRecargaDia	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboRecargaDia() {
		if (ComboRecargaDia == null) {
			ComboRecargaDia = new JComboBox();
			ComboRecargaDia.addItem("");
			ComboRecargaDia.setEnabled(false);
		}
		return ComboRecargaDia;
	}

	/**
	 * This method initializes ComboRecargaMes	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboRecargaMes() {
		if (ComboRecargaMes == null) {
			ComboRecargaMes = new JComboBox();
			
			ComboRecargaMes.addItem("");
			ComboRecargaMes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(ComboRecargaMes.getItemCount() != 0)
					{
						if(!((String)ComboRecargaMes.getSelectedItem()).equalsIgnoreCase(""))
						{
							ComboRecargaDia.setEnabled(true);
							ComboRecargaDia.removeAllItems();
						}

						String m = (String)ComboRecargaMes.getSelectedItem();
						int l =1;
						if(m.equalsIgnoreCase("Enero") || m.equalsIgnoreCase("Marzo") || m.equalsIgnoreCase("Mayo") || m.equalsIgnoreCase("Julio") || m.equalsIgnoreCase("Agosto") || m.equalsIgnoreCase("Octubre") || m.equalsIgnoreCase("Diciembre"))
						{
							l=32;
						}
						else
						{
							if(m.equalsIgnoreCase("Febrero"))
							{

								GregorianCalendar g = Utils.convertirCadenaFecha((String)getComboRecargaAno().getSelectedItem() + "-00-00");
								if(g.isLeapYear(Integer.parseInt((String)getComboRecargaAno().getSelectedItem()))){

									l=30;
								}
								else
								{
									l=29;
								}
							}
							else
							{
								l=31;
							}
						}


						ComboRecargaDia.addItem("");
						for(int i = 1; i< l; i++)
						{
							ComboRecargaDia.addItem(String.valueOf(i));
						}
					}

				}
			});




			ComboRecargaMes.setEnabled(false);
		}
		return ComboRecargaMes;
	}

	/**
	 * This method initializes ComboRecargaAno	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboRecargaAno() {
		if (ComboRecargaAno == null) {
			ComboRecargaAno = new JComboBox();
			ComboRecargaAno.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(!((String)ComboRecargaAno.getSelectedItem()).equalsIgnoreCase(""))
					{
						ComboRecargaMes.setEnabled(true);
						ComboRecargaMes.removeAllItems();
						
						ComboRecargaMes.addItem("");
						for(int i = 0; i< 12; i++)
						{
							ComboRecargaMes.addItem(Utils.darMes(i));
						}
						ComboRecargaDia.removeAllItems();
						
					}
						
				}

				
			});
			ComboRecargaAno.addItem("");
			
			for(int i = 2000; i< 2021; i++)
			{
				ComboRecargaAno.addItem(String.valueOf(i));
			}
		}
		return ComboRecargaAno;
	}

	/**
	 * This method initializes PanelRecargaRegresar	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRecargaRegresar() {
		if (PanelRecargaRegresar == null) {
			GridLayout gridLayout12 = new GridLayout();
			gridLayout12.setRows(1);
			gridLayout12.setColumns(3);
			PanelRecargaRegresar = new JPanel();
			PanelRecargaRegresar.setLayout(gridLayout12);
			PanelRecargaRegresar.add(getBRecargaAgregar(), null);
			PanelRecargaRegresar.add(getBRecargaRegresar(), null);
			
			
		}
		return PanelRecargaRegresar;
	}

	/**
	 * This method initializes BRecargaAgregar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBRecargaAgregar() {
		if (BRecargaAgregar == null) {
			BRecargaAgregar = new JButton();
			BRecargaAgregar.setText("Agregar Recarga");
			BRecargaAgregar.setFont(new Font("Chalkduster", Font.BOLD, 18));
			BRecargaAgregar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String c, a, me, di,v;
					
					try{
					a = (String)getComboRecargaAno().getSelectedItem();
					me = (String)getComboRecargaMes().getSelectedItem();
					di = (String)getComboRecargaDia().getSelectedItem();
					v =  (String)getTextRecargaValor().getText();
					c =  (String)getComboRecargaCuenta().getSelectedItem();
					
					
					
					JDialog d = new JDialog();
					d.setSize(400, 400);
					d.setLocationRelativeTo(jContentPane);
					String m = new String();

					
					if( a.isEmpty()  || c.isEmpty() || me.isEmpty() || di.isEmpty() || v.isEmpty() )
					{
						//getComboRecargaMes().setSelectedIndex(0);
						getComboRecargaAno().setSelectedIndex(0);
						
						//getComboRecargaDia().setSelectedIndex(0);
						if(getComboRecargaDia().getItemCount() != 0)
							getComboRecargaDia().removeAllItems();
						if(getComboRecargaMes().getItemCount() != 0)
							getComboRecargaMes().removeAllItems();
						
						
						//getComboRecargaCuenta().setSelectedIndex(0);
						
						getTextRecargaValor().setText("");



						m = "No se han ingresado todos los datos!";
						icon = new ImageIcon("fish8.png");
						JOptionPane.showMessageDialog(d, m, "Error", JOptionPane.INFORMATION_MESSAGE,icon);

					}
					else
					{
						if(!Utils.isNumeric(v))
						{

							icon = new ImageIcon("fish8.png");
							JOptionPane.showMessageDialog(d, "No se admiten letras en el campo [Valor]", "Error", JOptionPane.ERROR_MESSAGE, icon);					
							getTextLLamadaDestino().setText("");
							getTextLLamadaDuracion().setText("");
							
							
						}
						else
						{
							try{


								String s = JM.registrarRecarga( c.split("\\s+")[1].trim(), Utils.convertirCadenaFecha(a + "-" + String.valueOf(Utils.darNumMes(me) +1) + "-" + di), v);
								//String s = JM.registrarLLamada(t, c.split("\\s+")[1].trim(), Utils.convertirCadenaFecha(a + "-" + Utils.darNumMes(me) + "-" + di), de, du, Indicativo.darIndicativo(p));
								icon = new ImageIcon("halloween276.png");
								JOptionPane.showMessageDialog(d, s, "LLamada Registrada", JOptionPane.INFORMATION_MESSAGE, icon);

							}
							catch(Exception ee)
							{

								icon = new ImageIcon("fish8.png");
								JOptionPane.showMessageDialog(d, ee, "Error", JOptionPane.ERROR_MESSAGE, icon);
							}
						}
					}
					
					}
					catch(NullPointerException nu)
					{
						String m = "No se han ingresado todos los datos!";
						icon = new ImageIcon("fish8.png");
						
						JOptionPane.showMessageDialog(new JFrame(), m, "Error", JOptionPane.INFORMATION_MESSAGE,icon);
					}

				}
				
			});
		}
		return BRecargaAgregar;
	}

	/**
	 * This method initializes BCuentaRegresar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBCuentaRegresar() {
		if (BCuentaRegresar == null) {
			BCuentaRegresar = new JButton();
			BCuentaRegresar.setText("Regresar");
			BCuentaRegresar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					getServiciosPane().setSelectedIndex(0);
					reset();
				}
			});
		}
		return BCuentaRegresar;
	}

	/**
	 * This method initializes BRegresarLLamada	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBRegresarLLamada() {
		if (BRegresarLLamada == null) {
			BRegresarLLamada = new JButton();
			BRegresarLLamada.setText("Regresar");
			BRegresarLLamada.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getServiciosPane().setSelectedIndex(0);
					reset();
				}
			});
		}
		return BRegresarLLamada;
	}

	/**
	 * This method initializes BRecargaRegresar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBRecargaRegresar() {
		if (BRecargaRegresar == null) {
			BRecargaRegresar = new JButton();
			BRecargaRegresar.setText("Regresar");
			BRecargaRegresar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getServiciosPane().setSelectedIndex(0);
					reset();
				}
			});
		}
		return BRecargaRegresar;
	}

	/**
	 * This method initializes PanelReportePost	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelReportePost() {
		if (PanelReportePost == null) {
			PanelReportePost = new JPanel();
			PanelReportePost.setLayout(new BorderLayout());
			PanelReportePost.add(getPanelTituloRepPost(), BorderLayout.NORTH);
			PanelReportePost.add(getPanelRepPostRegresar(), BorderLayout.SOUTH);
			PanelReportePost.add(getPanelOpcionesRepPost(), BorderLayout.CENTER);
		}
		return PanelReportePost;
	}

	/**
	 * This method initializes PanelMesReporteRepPost	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelMesReporteRepPost() {
		if (PanelMesReporteRepPost == null) {
			
			GridLayout gridLayout13 = new GridLayout();
			gridLayout13.setRows(1);
			gridLayout13.setColumns(2);
			PanelMesReporteRepPost = new JPanel();
			PanelMesReporteRepPost.setLayout(gridLayout13);
			PanelMesReporteRepPost.add(getComboReportePostAno(), null);
			PanelMesReporteRepPost.add(getComboReportePostMes(), null);
		}
		return PanelMesReporteRepPost;
	}

	/**
	 * This method initializes ComboReportePostMes	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboReportePostMes() {
		if (ComboReportePostMes == null) {
			ComboReportePostMes = new JComboBox();
			ComboReportePostMes.addItem("");
			for(int i = 0; i< 12; i++)
			{
				ComboReportePostMes.addItem(Utils.darMes(i));
			}
		}
		return ComboReportePostMes;
	}

	/**
	 * This method initializes ComboReportePostAno	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboReportePostAno() {
		if (ComboReportePostAno == null) {
			ComboReportePostAno = new JComboBox();
             ComboReportePostAno.addItem("");
			
			for(int i = 2000; i< 2021; i++)
			{
				ComboReportePostAno.addItem(String.valueOf(i));
			}
			
		}
		return ComboReportePostAno;
	}

	/**
	 * This method initializes PanelTituloRepPost	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelTituloRepPost() {
		if (PanelTituloRepPost == null) {
			GridLayout gridLayout14 = new GridLayout();
			gridLayout14.setRows(1);
			gridLayout14.setColumns(2);
			LabelTituloRepPost = new JLabel();
			LabelTituloRepPost.setText("Reporte Postpago fin de mes");
			PanelTituloRepPost = new JPanel();
			PanelTituloRepPost.setLayout(gridLayout14);
			PanelTituloRepPost.add(LabelTituloRepPost, null);
			PanelTituloRepPost.add(getPanelMesReporteRepPost(), null);
			
		}
		return PanelTituloRepPost;
	}

	/**
	 * This method initializes PanelOpcionesRepPost	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelOpcionesRepPost() {
		if (PanelOpcionesRepPost == null) {
			GridLayout gridLayout16 = new GridLayout();
			gridLayout16.setRows(3);
			gridLayout16.setColumns(1);
			PanelOpcionesRepPost = new JPanel();
			PanelOpcionesRepPost.setLayout(gridLayout16);
			PanelOpcionesRepPost.add(getPanelRepPostOpcionesClientes(), null);
			PanelOpcionesRepPost.add(getPanelRepPostOpcionesCuentas(), null);		
			PanelOpcionesRepPost.add(getPanelRepPostOpcionesLLamadas(), null);
			
		}
		return PanelOpcionesRepPost;
	}

	/**
	 * This method initializes PanelRepPostRegresar	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRepPostRegresar() {
		if (PanelRepPostRegresar == null) {
			GridLayout gridLayout15 = new GridLayout();
			gridLayout15.setRows(1);
			PanelRepPostRegresar = new JPanel();
			PanelRepPostRegresar.setLayout(gridLayout15);
			PanelRepPostRegresar.add(getBRepPostRegresar(), null);
		}
		return PanelRepPostRegresar;
	}

	/**
	 * This method initializes BRepPostRegresar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBRepPostRegresar() {
		if (BRepPostRegresar == null) {
			BRepPostRegresar = new JButton();
			BRepPostRegresar.setText("Regresar");
			BRepPostRegresar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getServiciosPane().setSelectedIndex(0);
					reset();
				}
			});
		}
		return BRepPostRegresar;
	}

	/**
	 * This method initializes BRepPostMostrarClientes	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBRepPostMostrarClientes() {
		if (BRepPostMostrarClientes == null) {
			BRepPostMostrarClientes = new JButton();
			BRepPostMostrarClientes.setFont(new Font("Chalkduster", Font.BOLD, 18));
			BRepPostMostrarClientes.setText("Mostrar Clientes");
			BRepPostMostrarClientes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					String a = (String)getComboReportePostAno().getSelectedItem();
					String m = (String)getComboReportePostMes().getSelectedItem();
					if(!a.isEmpty() && !m.isEmpty())
					{
						//Reporte
						try{
						reporte("ReporteFinMesPostpago.txt", JM.reporteFinMesPost());
						}
						catch(Exception ee)
						{
							JOptionPane.showMessageDialog(new JFrame(), "Error con el reporte\n" + ee.toString(), "Error", JOptionPane.ERROR_MESSAGE);
						}
						long tot=0;

						GregorianCalendar fe = Utils.convertirCadenaFecha(a + "-" + Utils.darNumMes(m) + "-01");
						DefaultTableModel model = (DefaultTableModel)getTableRepPostClientes().getModel();
						//Borrar
						/*
						int mo = modell.getRowCount();
						if(mo > 0)
						{
							for(int i =0; i<mo; i++)
								modell.removeRow(i);
						}
						*/
						model.setRowCount(0);
						//-------
						if(!JM.getClientes().isEmpty()){
							
							Object[] o = new Object[5];
							List<Cliente> ord = new ArrayList<Cliente>();
							for(Cliente c: JM.mostrarClientes()){
								if(c.tienePost())
								{
									ord.add(c);
								}
							}
							Collections.sort(ord, new CompararCedulasClientes());
							for(Cliente c : ord)
							{
								o[0] = c.getNombre();
								o[1] = c.getTipo().name();
								o[2] = c.getCedula();
								o[3] = c.getDireccion();
								o[4] = "$ " +  c.darValorPagarPost(fe);
								tot += c.darValorPagarPost(fe);
								model.addRow(o);
							}
						}
						getScrollRepPostClientes().setVisible(true);
						getScrollRepPostClientes().setEnabled(true);
						getTableRepPostClientes().setVisible(true);
						getTableRepPostClientes().setEnabled(true);
						getTableRepPostClientes().setRowSelectionAllowed(true);
						//Sumar el valor de todos los clientes y mostrarlo en el label
						LabelRepPostOpcionesClientesValor.setText("Total Clientes: " + tot);
						LabelRepPostOpcionesClientesValor.setVisible(true);
					}
				}
			});
		}
		return BRepPostMostrarClientes;
	}

	/**
	 * This method initializes BRepPostMostrarCuentas	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBRepPostMostrarCuentas() {
		if (BRepPostMostrarCuentas == null) {
			BRepPostMostrarCuentas = new JButton();
			BRepPostMostrarCuentas.setFont(new Font("Chalkduster", Font.BOLD, 18));
			BRepPostMostrarCuentas.setText("Mostrar Cuentas Postpago");
			BRepPostMostrarCuentas.setActionCommand("Mostrar Cuentas Postpago");
			BRepPostMostrarCuentas.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					String a = (String)getComboReportePostAno().getSelectedItem();
					String m = (String)getComboReportePostMes().getSelectedItem();
					int fi = getTableRepPostClientes().getSelectedRow();
					if(fi != (-1))
					{
						
						String cli = (String)getTableRepPostClientes().getModel().getValueAt(fi, 2);
						Cliente c;
						if(JM.getClientes().containsKey(cli))
						{
							c = JM.getClientes().get(cli);
							if(!c.getCuentas().isEmpty())
							{
								GregorianCalendar fe = Utils.convertirCadenaFecha(a + "-" + Utils.darNumMes(m) + "-01");
								DefaultTableModel model = (DefaultTableModel)getTableRepPostCuentas().getModel();
								/*
								int mo = modell.getRowCount();
								if(mo > 0)
								{
									for(int i =0; i<mo; i++)
										modell.removeRow(i);
								}
								*/
								model.setRowCount(0);
								Object[] o = new Object[3];
								for(Cuenta cu: c.getCuentas())
								{
									if(cu instanceof CuentaPostpago)
									{
										o[0] = String.valueOf(cu.getId());
										o[1] = cu.getNumero();
										o[2] = cu.getPlan().getNombre();
										model.addRow(o);
									}
								}


							}

						}
					}
					getScrollRepPostCuentas().setVisible(true);
					getScrollRepPostCuentas().setEnabled(true);
					getTableRepPostCuentas().setVisible(true);
					getTableRepPostCuentas().setRowSelectionAllowed(true);
				}


			});
		}
		return BRepPostMostrarCuentas;
	}

	/**
	 * This method initializes BRepPostMostrarLlamadas	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBRepPostMostrarLlamadas() {
		if (BRepPostMostrarLlamadas == null) {
			BRepPostMostrarLlamadas = new JButton();
			BRepPostMostrarLlamadas.setFont(new Font("Chalkduster", Font.BOLD, 18));

			BRepPostMostrarLlamadas.setText("Mostrar LLamadas");
			BRepPostMostrarLlamadas.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					int fil = getTableRepPostCuentas().getSelectedRow();
					if(fil != (-1))
					{
						long tot=0;
						long totd=0;
						DefaultTableModel model = (DefaultTableModel)getTableRepPostCuentas().getModel();
						String id = (String)model.getValueAt(fil,0);
						Cuenta c = JM.buscarCuentaId(id.trim());
						GregorianCalendar h = Utils.convertirCadenaFecha((String)getComboReportePostAno().getSelectedItem() + "-" + String.valueOf(Utils.darNumMes((String)getComboReportePostMes().getSelectedItem()) + 1) + "-01");
						List<LLamada> llam = new ArrayList<LLamada>();
						for(LLamada l: c.getLlamadas())
						{
							if(l.getFecha().get(Calendar.YEAR) == h.get(Calendar.YEAR) && l.getFecha().get(Calendar.MONTH) == h.get(Calendar.MONTH))
								llam.add(l);
						}

						Collections.sort(llam, new CompararLLamadasFecha());
						DefaultTableModel modell = (DefaultTableModel)getTablerepPostLLamadas().getModel();
						//Borrar
						/*
						int mo = modell.getRowCount();
						if(mo > 0)
						{
							for(int i =0; i<mo; i++)
								modell.removeRow(i);
						}
						*/
						modell.setRowCount(0);
						//-------
						Object[] o = new Object[4];
						for(LLamada l : llam)
						{
							o[0] = Utils.convertirFechaCadena(l.getFecha());
							o[1] = l.getTelefonoDestinatario();
							o[2] = String.valueOf(l.getDuracion());
							o[3] = "$ " + String.valueOf(l.getValor());
							tot += l.getValor();
							totd += l.getDuracion();
							modell.addRow(o);
						}
						getScrollRepPostLLamadas().setEnabled(true);
						getScrollRepPostLLamadas().setVisible(true);
						LabelRepPostOpcionesLLamadasValor.setText("Total Cuenta-  Duracion: " + totd + ". Valor " + tot);
						LabelRepPostOpcionesLLamadasValor.setVisible(true);
						
					}
				}
			});
		}
		return BRepPostMostrarLlamadas;
	}

	/**
	 * This method initializes ScrollRepPostClientes	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrollRepPostClientes() {
		if (ScrollRepPostClientes == null) {
			ScrollRepPostClientes = new JScrollPane();
			
			ScrollRepPostClientes.setVisible(false);
			ScrollRepPostClientes.setViewportView(getTableRepPostClientes());
		}
		return ScrollRepPostClientes;
	}

	/**
	 * This method initializes TableRepPostClientes	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTableRepPostClientes() {
		if (TableRepPostClientes == null) {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Nombre");
			model.addColumn("Tipo Id");
			model.addColumn("Documento");
			model.addColumn("Direccion");
			model.addColumn("Valor a pagar");
			
			//LLenar las rows
			TableRepPostClientes = new JTable(model);
			TableRepPostClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		        public void valueChanged(ListSelectionEvent event) {
		            DefaultTableModel model = (DefaultTableModel)getTableRepPostCuentas().getModel();
		            model.setRowCount(0);
		            model = (DefaultTableModel)getTablerepPostLLamadas().getModel();
		            model.setRowCount(0);
		        }
		    });
		}
		return TableRepPostClientes;
	}

	/**
	 * This method initializes ScrollRepPostCuentas	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrollRepPostCuentas() {
		if (ScrollRepPostCuentas == null) {
			ScrollRepPostCuentas = new JScrollPane();
			ScrollRepPostCuentas.setVisible(false);
			ScrollRepPostCuentas.setViewportView(getTableRepPostCuentas());
		}
		return ScrollRepPostCuentas;
	}

	/**
	 * This method initializes TableRepPostCuentas	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTableRepPostCuentas() {
		if (TableRepPostCuentas == null) {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Id");
			model.addColumn("Numero");
			model.addColumn("Plan");
			TableRepPostCuentas = new JTable(model);
			TableRepPostCuentas.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		        public void valueChanged(ListSelectionEvent event) {
		            DefaultTableModel model;
		            
		            model = (DefaultTableModel)getTablerepPostLLamadas().getModel();
		            model.setRowCount(0);
		        }
		    });
		}
		return TableRepPostCuentas;
	}

	/**
	 * This method initializes ScrollRepPostLLamadas	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrollRepPostLLamadas() {
		if (ScrollRepPostLLamadas == null) {
			ScrollRepPostLLamadas = new JScrollPane();
			ScrollRepPostLLamadas.setName("");
			ScrollRepPostLLamadas.setVisible(false);
			ScrollRepPostLLamadas.setViewportView(getTablerepPostLLamadas());
		}
		return ScrollRepPostLLamadas;
	}

	/**
	 * This method initializes TablerepPostLLamadas	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTablerepPostLLamadas() {
		if (TablerepPostLLamadas == null) {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Fecha");
			model.addColumn("Destinatario");
			model.addColumn("Duracion");
			model.addColumn("Valor");
			//Filas
			TablerepPostLLamadas = new JTable(model);
		}
		return TablerepPostLLamadas;
	}

	/**
	 * This method initializes PanelReportePre	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelReportePre() {
		if (PanelReportePre == null) {
			PanelReportePre = new JPanel();
			
			PanelReportePre.setLayout(new BorderLayout());
			PanelReportePre.setSize(new Dimension(503, 271));
			PanelReportePre.add(getPanelTituloRepPre(), BorderLayout.NORTH);
			PanelReportePre.add(getPanelRepPreRegresar(), BorderLayout.SOUTH);
			PanelReportePre.add(getPanelOpcionesRepPre(), BorderLayout.CENTER);
			
		}
		return PanelReportePre;
	}

	/**
	 * This method initializes PanelTituloRepPre	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelTituloRepPre() {
		if (PanelTituloRepPre == null) {
			GridLayout gridLayout17 = new GridLayout();
			gridLayout17.setRows(1);
			gridLayout17.setColumns(2);
			PanelTituloRepPre = new JPanel();
			LabelTituloRepPre = new JLabel();
			LabelTituloRepPre.setText("Reporte Prepago fin de mes");
			PanelTituloRepPre.setLayout(gridLayout17);
			PanelTituloRepPre.add(LabelTituloRepPre, null);
			PanelTituloRepPre.add(getPanelMesReporteRepPre(), null);
			
		}
		return PanelTituloRepPre;
	}

	/**
	 * This method initializes PanelOpcionesRepPre	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelOpcionesRepPre() {
		if (PanelOpcionesRepPre == null) {
			GridLayout gridLayout20 = new GridLayout();
			gridLayout20.setRows(3);
			gridLayout20.setColumns(1);
			PanelOpcionesRepPre = new JPanel();
			PanelOpcionesRepPre.setLayout(gridLayout20);
			PanelOpcionesRepPre.setSize(new Dimension(122, 50));
			
			
			PanelOpcionesRepPre.add(getPanelRepPreOpcionesClientes(), null);
			PanelOpcionesRepPre.add(getPanelRepPreOpcionesCuentas(), null);
			PanelOpcionesRepPre.add(getPanelRepPreOpcionesDoble(), null);
		}
		return PanelOpcionesRepPre;
	}

	/**
	 * This method initializes PanelRepPreRegresar	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRepPreRegresar() {
		if (PanelRepPreRegresar == null) {
			GridLayout gridLayout19 = new GridLayout();
			gridLayout19.setRows(1);
			PanelRepPreRegresar = new JPanel();
			PanelRepPreRegresar.setLayout(gridLayout19);
			PanelRepPreRegresar.add(getBRepPreRegresar(), null);
		}
		return PanelRepPreRegresar;
	}

	/**
	 * This method initializes PanelMesReporteRepPre	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelMesReporteRepPre() {
		if (PanelMesReporteRepPre == null) {
			
			GridLayout gridLayout18 = new GridLayout();
			gridLayout18.setRows(1);
			gridLayout18.setColumns(2);
			PanelMesReporteRepPre = new JPanel();
			PanelMesReporteRepPre.setLayout(gridLayout18);
			PanelMesReporteRepPre.add(getComboReportePreAno(), null);
			PanelMesReporteRepPre.add(getComboReportePreMes(), null);
		}
		return PanelMesReporteRepPre;
	}

	/**
	 * This method initializes ComboReportePreAno	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboReportePreAno() {
		if (ComboReportePreAno == null) {
			ComboReportePreAno = new JComboBox();
			ComboReportePreAno.addItem("");

			for(int i = 2000; i< 2021; i++)
			{
				ComboReportePreAno.addItem(String.valueOf(i));
			}
		}
		return ComboReportePreAno;
	}

	/**
	 * This method initializes ComboReportePreMes	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboReportePreMes() {
		if (ComboReportePreMes == null) {
			ComboReportePreMes = new JComboBox();
			ComboReportePreMes.addItem("");

			for(int i = 0; i< 12; i++)
			{
				ComboReportePreMes.addItem(Utils.darMes(i));
			}
		}
		return ComboReportePreMes;
	}

	/**
	 * This method initializes BRepPreRegresar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBRepPreRegresar() {
		if (BRepPreRegresar == null) {
			BRepPreRegresar = new JButton();
			BRepPreRegresar.setText("Regresar");
			BRepPreRegresar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getServiciosPane().setSelectedIndex(0);
					reset();
				}
			});
		}
		return BRepPreRegresar;
	}

	/**
	 * This method initializes PanelRepPostOpcionesClientes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRepPostOpcionesClientes() {
		if (PanelRepPostOpcionesClientes == null) {
			LabelRepPostOpcionesClientesValor = new JLabel();
			LabelRepPostOpcionesClientesValor.setText("Valor a pagar:");
			LabelRepPostOpcionesClientesValor.setHorizontalTextPosition(SwingConstants.RIGHT);
			LabelRepPostOpcionesClientesValor.setHorizontalAlignment(SwingConstants.RIGHT);
			LabelRepPostOpcionesClientesValor.setVisible(false);
			LabelRepPostOpcionesClientes = new JLabel();
			LabelRepPostOpcionesClientes.setText("Clientes con cuentas postpago");
			LabelRepPostOpcionesClientes.setVisible(false);
			PanelRepPostOpcionesClientes = new JPanel();
			PanelRepPostOpcionesClientes.setLayout(new BorderLayout());
			PanelRepPostOpcionesClientes.setSize(new Dimension(126, 64));
			PanelRepPostOpcionesClientes.setVisible(true);
			PanelRepPostOpcionesClientes.add(LabelRepPostOpcionesClientesValor, BorderLayout.SOUTH);
			PanelRepPostOpcionesClientes.add(getScrollRepPostClientes(), BorderLayout.CENTER);
			PanelRepPostOpcionesClientes.add(getPanelRepPostClientesEncabezado(), BorderLayout.NORTH);
		}
		return PanelRepPostOpcionesClientes;
	}

	/**
	 * This method initializes PanelRepPostOpcionesCuentas	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRepPostOpcionesCuentas() {
		if (PanelRepPostOpcionesCuentas == null) {
			LabelRepPostOpcionesCuentas = new JLabel();
			LabelRepPostOpcionesCuentas.setText("Cuentas del cliente seleccionado");
			LabelRepPostOpcionesCuentas.setVisible(false);
			PanelRepPostOpcionesCuentas = new JPanel();
			PanelRepPostOpcionesCuentas.setLayout(new BorderLayout());
			PanelRepPostOpcionesCuentas.setSize(new Dimension(155, 96));
			PanelRepPostOpcionesCuentas.add(getScrollRepPostCuentas(), BorderLayout.CENTER);
			PanelRepPostOpcionesCuentas.add(getPanelRepPostCuentasEncabezado(), BorderLayout.NORTH);
		}
		return PanelRepPostOpcionesCuentas;
	}

	/**
	 * This method initializes PanelRepPostOpcionesLLamadas	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRepPostOpcionesLLamadas() {
		if (PanelRepPostOpcionesLLamadas == null) {
			LabelRepPostOpcionesLLamadasValor = new JLabel();
			LabelRepPostOpcionesLLamadasValor.setText("Total:");
			LabelRepPostOpcionesLLamadasValor.setHorizontalTextPosition(SwingConstants.RIGHT);
			LabelRepPostOpcionesLLamadasValor.setHorizontalAlignment(SwingConstants.RIGHT);
			LabelRepPostOpcionesLLamadasValor.setVisible(false);
			LabelRepPostOpcionesLLamadas = new JLabel();
			LabelRepPostOpcionesLLamadas.setText("LLamadas cuenta seleccionada");
			LabelRepPostOpcionesLLamadas.setVisible(false);
			PanelRepPostOpcionesLLamadas = new JPanel();
			PanelRepPostOpcionesLLamadas.setLayout(new BorderLayout());
			PanelRepPostOpcionesLLamadas.setSize(new Dimension(114, 61));
			PanelRepPostOpcionesLLamadas.add(LabelRepPostOpcionesLLamadasValor, BorderLayout.SOUTH);
			PanelRepPostOpcionesLLamadas.add(getScrollRepPostLLamadas(), BorderLayout.CENTER);
			PanelRepPostOpcionesLLamadas.add(getPanelRepPostLLamadasEncabezado(), BorderLayout.NORTH);
		}
		return PanelRepPostOpcionesLLamadas;
	}

	/**
	 * This method initializes PanelRepPreOpcionesClientes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRepPreOpcionesClientes() {
		if (PanelRepPreOpcionesClientes == null) {
			LabelRepPreOpcionesClienteTotal = new JLabel();
			LabelRepPreOpcionesClienteTotal.setText("Total");
			LabelRepPreOpcionesClienteTotal.setHorizontalAlignment(SwingConstants.RIGHT);
			LabelRepPreOpcionesClienteTotal.setHorizontalTextPosition(SwingConstants.RIGHT);
			LabelRepPreOpcionesClienteTotal.setVisible(false);
			LabelRepPreOpcionesClientes = new JLabel();
			LabelRepPreOpcionesClientes.setText("Clientes con cuenta prepago");
			LabelRepPreOpcionesClientes.setVisible(false);
			PanelRepPreOpcionesClientes = new JPanel();
			PanelRepPreOpcionesClientes.setLayout(new BorderLayout());
			PanelRepPreOpcionesClientes.add(getPanelRepPreClientesEncabezado(), BorderLayout.NORTH);
			PanelRepPreOpcionesClientes.add(LabelRepPreOpcionesClienteTotal, BorderLayout.SOUTH);
			PanelRepPreOpcionesClientes.add(getScrollRepPreClientes(), BorderLayout.CENTER);
		}
		return PanelRepPreOpcionesClientes;
	}

	/**
	 * This method initializes ScrollRepPreClientes	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrollRepPreClientes() {
		if (ScrollRepPreClientes == null) {
			ScrollRepPreClientes = new JScrollPane();
			ScrollRepPreClientes.setVisible(false);
			ScrollRepPreClientes.setViewportView(getTableRepPreClientes());
		}
		return ScrollRepPreClientes;
	}

	/**
	 * This method initializes TableRepPreClientes	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTableRepPreClientes() {
		if (TableRepPreClientes == null) {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Nombre");
			model.addColumn("Tipo Id");
			model.addColumn("Documento");
			model.addColumn("Direccion");
			model.addColumn("Valor a pagar");
			TableRepPreClientes = new JTable(model);
			TableRepPreClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		        public void valueChanged(ListSelectionEvent event) {
		            DefaultTableModel model = (DefaultTableModel)getTableRepPreCuentas().getModel();
		            model.setRowCount(0);
		            model = (DefaultTableModel)getTableRepPreLLamadas().getModel();
		            model.setRowCount(0);
		        }
		    });
		}
		return TableRepPreClientes;
	}

	/**
	 * This method initializes PanelRepPreOpcionesCuentas	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRepPreOpcionesCuentas() {
		if (PanelRepPreOpcionesCuentas == null) {
			LabelRepPreOpcionesCuentas = new JLabel();
			LabelRepPreOpcionesCuentas.setText("Cuentas cliente seleccionado");
			LabelRepPreOpcionesCuentas.setVisible(false);
			PanelRepPreOpcionesCuentas = new JPanel();
			PanelRepPreOpcionesCuentas.setLayout(new BorderLayout());
			PanelRepPreOpcionesCuentas.add(getPanelRepPreCuentasEncabezado(), BorderLayout.NORTH);
			PanelRepPreOpcionesCuentas.add(getScrollRepPreCuentas(), BorderLayout.CENTER);
		}
		return PanelRepPreOpcionesCuentas;
	}

	/**
	 * This method initializes ScrollRepPreCuentas	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrollRepPreCuentas() {
		if (ScrollRepPreCuentas == null) {
			ScrollRepPreCuentas = new JScrollPane();
			ScrollRepPreCuentas.setVisible(false);
			ScrollRepPreCuentas.setViewportView(getTableRepPreCuentas());
		}
		return ScrollRepPreCuentas;
	}

	/**
	 * This method initializes TableRepPreCuentas	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTableRepPreCuentas() {
		if (TableRepPreCuentas == null) {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Id");
			model.addColumn("Numero");
			model.addColumn("Plan");
			TableRepPreCuentas = new JTable(model);
			TableRepPreCuentas.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		        public void valueChanged(ListSelectionEvent event) {
		            DefaultTableModel model;
		            model = (DefaultTableModel)getTableRepPreLLamadas().getModel();
		            model.setRowCount(0);
		            model = (DefaultTableModel)getTableRepPreRecargas().getModel();
		            model.setRowCount(0);
		        }
		    });
		}
		return TableRepPreCuentas;
	}

	/**
	 * This method initializes PanelRepPreOpcionesDoble	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRepPreOpcionesDoble() {
		if (PanelRepPreOpcionesDoble == null) {
			GridLayout gridLayout22 = new GridLayout();
			gridLayout22.setRows(1);
			gridLayout22.setColumns(2);
			PanelRepPreOpcionesDoble = new JPanel();
			PanelRepPreOpcionesDoble.setLayout(gridLayout22);
			PanelRepPreOpcionesDoble.add(getPanelRepPreOpcionesRecargas(), null);
			PanelRepPreOpcionesDoble.add(getPanelRepPreOpcionesLlamadas(), null);
			
		}
		return PanelRepPreOpcionesDoble;
	}

	/**
	 * This method initializes PanelRepPreOpcionesRecargaEncabezado	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRepPreOpcionesRecargaEncabezado() {
		if (PanelRepPreOpcionesRecargaEncabezado == null) {
			LabelRepPreOpcionesRecargas = new JLabel();
			LabelRepPreOpcionesRecargas.setText("Recargas cuenta seleccionada");
			LabelRepPreOpcionesRecargas.setVisible(false);
			GridLayout gridLayout21 = new GridLayout();
			gridLayout21.setRows(2);
			gridLayout21.setColumns(1);
			PanelRepPreOpcionesRecargaEncabezado = new JPanel();
			PanelRepPreOpcionesRecargaEncabezado.setVisible(true);
			PanelRepPreOpcionesRecargaEncabezado.setLayout(gridLayout21);
			PanelRepPreOpcionesRecargaEncabezado.add(getBRepPreRecargas(), null);
			PanelRepPreOpcionesRecargaEncabezado.add(LabelRepPreOpcionesRecargas, null);
		}
		return PanelRepPreOpcionesRecargaEncabezado;
	}

	/**
	 * This method initializes BRepPreRecargas	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBRepPreRecargas() {
		if (BRepPreRecargas == null) {
			BRepPreRecargas = new JButton();
			BRepPreRecargas.setFont(new Font("Chalkduster", Font.BOLD, 18));

			BRepPreRecargas.setText("Mostrar Recargas");
			BRepPreRecargas.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					int fil = getTableRepPreCuentas().getSelectedRow();
					if(fil != (-1))
					{
						long tot=0;
						DefaultTableModel model = (DefaultTableModel)getTableRepPreCuentas().getModel();
						String id = (String)model.getValueAt(fil,0);
						Cuenta c = JM.buscarCuentaId(id.trim());
						GregorianCalendar h = Utils.convertirCadenaFecha((String)getComboReportePreAno().getSelectedItem() + "-" + String.valueOf(Utils.darNumMes((String)getComboReportePreMes().getSelectedItem())+1) + "-01");
						List<Recarga> llam = new ArrayList<Recarga>();
						if(c instanceof CuentaPrepago)
						{
							for(Recarga l: ((CuentaPrepago)c).getRecargas())
							{
								if(l.getFechaRecarga().get(Calendar.YEAR) == h.get(Calendar.YEAR) && l.getFechaRecarga().get(Calendar.MONTH) == h.get(Calendar.MONTH))
									llam.add(l);
							}

							Collections.sort(llam, new CompararRecargaFecha());
							DefaultTableModel modell = (DefaultTableModel)getTableRepPreRecargas().getModel();
							//Borrar
							/*
						int mo = modell.getRowCount();
						if(mo > 0)
						{
							for(int i =0; i<mo; i++)
								modell.removeRow(i);
						}
							 */
							modell.setRowCount(0);
							//-------
							Object[] o = new Object[2];
							for(Recarga l : llam)
							{
								o[0] = Utils.convertirFechaCadena(l.getFechaRecarga());
								o[1] = "$ " + String.valueOf(l.getValorRecarga());
								tot += l.getValorRecarga();
								
								modell.addRow(o);
							}
							getScrollRepPreRecargas().setEnabled(true);
							getScrollRepPreRecargas().setVisible(true);
							LabelRepPreOpcionesRecargasTotal.setText("Total Recargas: " + tot);
							LabelRepPreOpcionesRecargasTotal.setVisible(true);
						}
					}			


				}
			});
		}
		return BRepPreRecargas;
	}

	/**
	 * This method initializes PanelRepPreOpcionesRecargas	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRepPreOpcionesRecargas() {
		if (PanelRepPreOpcionesRecargas == null) {
			LabelRepPreOpcionesRecargasTotal = new JLabel();
			LabelRepPreOpcionesRecargasTotal.setText("Total");
			LabelRepPreOpcionesRecargasTotal.setHorizontalTextPosition(SwingConstants.RIGHT);
			LabelRepPreOpcionesRecargasTotal.setHorizontalAlignment(SwingConstants.RIGHT);
			LabelRepPreOpcionesRecargasTotal.setVisible(false);
			PanelRepPreOpcionesRecargas = new JPanel();
			PanelRepPreOpcionesRecargas.setLayout(new BorderLayout());
			PanelRepPreOpcionesRecargas.setSize(new Dimension(414, 296));
			PanelRepPreOpcionesRecargas.add(LabelRepPreOpcionesRecargasTotal, BorderLayout.SOUTH);
			PanelRepPreOpcionesRecargas.add(getPanelRepPreOpcionesRecargaEncabezado(), BorderLayout.NORTH);
			PanelRepPreOpcionesRecargas.add(getScrollRepPreRecargas(), BorderLayout.CENTER);
		}
		return PanelRepPreOpcionesRecargas;
	}

	/**
	 * This method initializes ScrollRepPreRecargas	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrollRepPreRecargas() {
		if (ScrollRepPreRecargas == null) {
			ScrollRepPreRecargas = new JScrollPane();
			ScrollRepPreRecargas.setVisible(false);
			ScrollRepPreRecargas.setViewportView(getTableRepPreRecargas());
		}
		return ScrollRepPreRecargas;
	}

	/**
	 * This method initializes TableRepPreRecargas	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTableRepPreRecargas() {
		if (TableRepPreRecargas == null) {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Fecha");
			model.addColumn("Valor");
			TableRepPreRecargas = new JTable(model);
		}
		return TableRepPreRecargas;
	}

	/**
	 * This method initializes PanelRepPreOpcionesLlamadas	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRepPreOpcionesLlamadas() {
		if (PanelRepPreOpcionesLlamadas == null) {
			LabelRepPreOpcionesLLamadasTotal = new JLabel();
			LabelRepPreOpcionesLLamadasTotal.setText("Total");
			LabelRepPreOpcionesLLamadasTotal.setHorizontalTextPosition(SwingConstants.RIGHT);
			LabelRepPreOpcionesLLamadasTotal.setHorizontalAlignment(SwingConstants.RIGHT);
			LabelRepPreOpcionesLLamadasTotal.setVisible(false);
			PanelRepPreOpcionesLlamadas = new JPanel();
			PanelRepPreOpcionesLlamadas.setLayout(new BorderLayout());
			PanelRepPreOpcionesLlamadas.add(getPanelRepPreOpcionesLLamadaEncabezado(), BorderLayout.NORTH);
			PanelRepPreOpcionesLlamadas.add(LabelRepPreOpcionesLLamadasTotal, BorderLayout.SOUTH);
			PanelRepPreOpcionesLlamadas.add(getScrollRepPreLLamadas(), BorderLayout.CENTER);
		}
		return PanelRepPreOpcionesLlamadas;
	}

	/**
	 * This method initializes PanelRepPreOpcionesLLamadaEncabezado	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRepPreOpcionesLLamadaEncabezado() {
		if (PanelRepPreOpcionesLLamadaEncabezado == null) {
			LabelRepPreOpcionesLLamadas = new JLabel();
			LabelRepPreOpcionesLLamadas.setText("LLamadas cuenta seleccionada");
			LabelRepPreOpcionesLLamadas.setVisible(false);
			GridLayout gridLayout23 = new GridLayout();
			gridLayout23.setRows(2);
			gridLayout23.setColumns(1);
			PanelRepPreOpcionesLLamadaEncabezado = new JPanel();
			PanelRepPreOpcionesLLamadaEncabezado.setLayout(gridLayout23);
			PanelRepPreOpcionesLLamadaEncabezado.add(getBRepPreLLamadas(), null);
			PanelRepPreOpcionesLLamadaEncabezado.add(LabelRepPreOpcionesLLamadas, null);
		}
		return PanelRepPreOpcionesLLamadaEncabezado;
	}

	/**
	 * This method initializes BRepPreLLamadas	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBRepPreLLamadas() {
		if (BRepPreLLamadas == null) {
			BRepPreLLamadas = new JButton();
			BRepPreLLamadas.setFont(new Font("Chalkduster", Font.BOLD, 18));

			BRepPreLLamadas.setText("Mostrar LLamadas");
			BRepPreLLamadas.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					int fil = getTableRepPreCuentas().getSelectedRow();
					if(fil != (-1))
					{
						long tot =0;
						long totd =0;
						DefaultTableModel model = (DefaultTableModel)getTableRepPreCuentas().getModel();
						String id = (String)model.getValueAt(fil,0);
						Cuenta c = JM.buscarCuentaId(id.trim());
						GregorianCalendar h = Utils.convertirCadenaFecha((String)getComboReportePreAno().getSelectedItem() + "-" + String.valueOf(Utils.darNumMes((String)getComboReportePreMes().getSelectedItem())+1) + "-01");
						List<LLamada> llam = new ArrayList<LLamada>();
						for(LLamada l: c.getLlamadas())
						{
							if(l.getFecha().get(Calendar.YEAR) == h.get(Calendar.YEAR) && l.getFecha().get(Calendar.MONTH) == h.get(Calendar.MONTH))
								llam.add(l);
						}

						Collections.sort(llam, new CompararLLamadasFecha());
						DefaultTableModel modell = (DefaultTableModel)getTableRepPreLLamadas().getModel();
						//Borrar
						/*
						int mo = modell.getRowCount();
						if(mo > 0)
						{
							for(int i =0; i<mo; i++)
								modell.removeRow(i);
						}
						 */
						modell.setRowCount(0);
						//-------
						Object[] o = new Object[4];
						for(LLamada l : llam)
						{
							o[0] = Utils.convertirFechaCadena(l.getFecha());
							o[1] = l.getTelefonoDestinatario();
							o[2] = String.valueOf(l.getDuracion());
							o[3] = "$ " + String.valueOf(l.getValor());
							tot += l.getValor();
							totd+= l.getDuracion();
							modell.addRow(o);
						}
						getScrollRepPreLLamadas().setEnabled(true);
						getScrollRepPreLLamadas().setVisible(true);
						LabelRepPreOpcionesLLamadasTotal.setText("Total Cuenta-  Duracion: " + totd + ". Valor " + tot);
						LabelRepPreOpcionesLLamadasTotal.setVisible(true);
					}			
				}
			});
		}
		return BRepPreLLamadas;
	}

	/**
	 * This method initializes ScrollRepPreLLamadas	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrollRepPreLLamadas() {
		if (ScrollRepPreLLamadas == null) {
			ScrollRepPreLLamadas = new JScrollPane();
			ScrollRepPreLLamadas.setVisible(false);
			ScrollRepPreLLamadas.setViewportView(getTableRepPreLLamadas());
		}
		return ScrollRepPreLLamadas;
	}

	/**
	 * This method initializes TableRepPreLLamadas	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTableRepPreLLamadas() {
		if (TableRepPreLLamadas == null) {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Fecha");
			model.addColumn("Destinatario");
			model.addColumn("Duracion");
			model.addColumn("Valor");
			TableRepPreLLamadas = new JTable(model);
		}
		return TableRepPreLLamadas;
	}

	/**
	 * This method initializes PanelRepPreClientesEncabezado	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRepPreClientesEncabezado() {
		if (PanelRepPreClientesEncabezado == null) {
			GridLayout gridLayout24 = new GridLayout();
			gridLayout24.setRows(2);
			gridLayout24.setColumns(1);
			PanelRepPreClientesEncabezado = new JPanel();
			PanelRepPreClientesEncabezado.setLayout(gridLayout24);
			PanelRepPreClientesEncabezado.setSize(new Dimension(163, 44));
			PanelRepPreClientesEncabezado.add(getBPreClientes(), null);
			PanelRepPreClientesEncabezado.add(LabelRepPreOpcionesClientes, null);
		}
		return PanelRepPreClientesEncabezado;
	}

	/**
	 * This method initializes BPreClientes	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBPreClientes() {
		if (BPreClientes == null) {
			BPreClientes = new JButton();
			BPreClientes.setFont(new Font("Chalkduster", Font.BOLD, 18));

			BPreClientes.setText("Mostrar Clientes");
			BPreClientes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					String a = (String)getComboReportePreAno().getSelectedItem();
					String m = (String)getComboReportePreMes().getSelectedItem();
					if(!a.isEmpty() && !m.isEmpty())
					{
						reporte("ReporteFinMesPrepago.txt", JM.reporteFinMesPre());
						long tot=0;
						long totd =0;
						GregorianCalendar fe = Utils.convertirCadenaFecha(a + "-" + Utils.darNumMes(m) + "-01");
						DefaultTableModel model = (DefaultTableModel)getTableRepPreClientes().getModel();
						//Borrar
						/*
						int mo = modell.getRowCount();
						if(mo > 0)
						{
							for(int i =0; i<mo; i++)
								modell.removeRow(i);
						}
						*/
						model.setRowCount(0);
						//-------
						if(!JM.getClientes().isEmpty()){
							Object[] o = new Object[5];
							List<Cliente> ord = new ArrayList<Cliente>();
							for(Cliente c: JM.mostrarClientes()){
								if(c.tienePre())
								{
									ord.add(c);
								}
							}
							Collections.sort(ord, new CompararCedulasClientes());
							for(Cliente c : ord)
							{
								o[0] = c.getNombre();
								o[1] = c.getTipo().name();
								o[2] = c.getCedula();
								o[3] = c.getDireccion();
								o[4] = "$ " + c.darValorPagarPre(fe);
								tot += c.darValorPagarPre(fe);
								totd += c.darMinutosPre(fe);
								model.addRow(o);
							}
						}
						getScrollRepPreClientes().setVisible(true);
						getScrollRepPreClientes().setEnabled(true);
						getTableRepPreClientes().setVisible(true);
						getTableRepPreClientes().setRowSelectionAllowed(true);
						LabelRepPreOpcionesClienteTotal.setText("Total Clientes: Valor:" + tot + ". Minutos LLamadas: " + totd);
						LabelRepPreOpcionesClienteTotal.setVisible(true);
					}
				}
				
			});
		}
		return BPreClientes;
	}

	/**
	 * This method initializes PanelRepPreCuentasEncabezado	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRepPreCuentasEncabezado() {
		if (PanelRepPreCuentasEncabezado == null) {
			GridLayout gridLayout25 = new GridLayout();
			gridLayout25.setRows(2);
			gridLayout25.setColumns(1);
			PanelRepPreCuentasEncabezado = new JPanel();
			PanelRepPreCuentasEncabezado.setLayout(gridLayout25);
			PanelRepPreCuentasEncabezado.setSize(new Dimension(127, 35));
			PanelRepPreCuentasEncabezado.add(getBPreCuentas(), null);
			PanelRepPreCuentasEncabezado.add(LabelRepPreOpcionesCuentas, null);
		}
		return PanelRepPreCuentasEncabezado;
	}

	/**
	 * This method initializes BPreCuentas	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBPreCuentas() {
		if (BPreCuentas == null) {
			BPreCuentas = new JButton();
			BPreCuentas.setFont(new Font("Chalkduster", Font.BOLD, 18));

			BPreCuentas.setText("Mostrar Cuentas");
			BPreCuentas.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					String a = (String)getComboReportePreAno().getSelectedItem();
					String m = (String)getComboReportePreMes().getSelectedItem();
					int fi = getTableRepPreClientes().getSelectedRow();
					if(fi != (-1))
					{
						String cli = (String)getTableRepPreClientes().getModel().getValueAt(fi, 2);
						Cliente c;
						if(JM.getClientes().containsKey(cli))
						{
							c = JM.getClientes().get(cli);
							if(!c.getCuentas().isEmpty())
							{
								GregorianCalendar fe = Utils.convertirCadenaFecha(a + "-" + Utils.darNumMes(m) + "-01");
								DefaultTableModel model = (DefaultTableModel)getTableRepPreCuentas().getModel();
								/*
								int mo = modell.getRowCount();
								if(mo > 0)
								{
									for(int i =0; i<mo; i++)
										modell.removeRow(i);
								}
								 */
								model.setRowCount(0);
								Object[] o = new Object[3];
								for(Cuenta cu: c.getCuentas())
								{
									if(cu instanceof CuentaPrepago)
									{
										o[0] = String.valueOf(cu.getId());
										o[1] = cu.getNumero();
										o[2] = cu.getPlan().getNombre();
										model.addRow(o);
									}
								}


							}

						}
					}
					getScrollRepPreCuentas().setVisible(true);
					getScrollRepPreCuentas().setEnabled(true);
					getTableRepPreCuentas().setVisible(true);
					getTableRepPreCuentas().setRowSelectionAllowed(true);
				}				
			});
		}
		return BPreCuentas;
	}

	/**
	 * This method initializes PanelRepPostClientesEncabezado	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRepPostClientesEncabezado() {
		if (PanelRepPostClientesEncabezado == null) {
			GridLayout gridLayout26 = new GridLayout();
			gridLayout26.setRows(2);
			gridLayout26.setColumns(1);
			PanelRepPostClientesEncabezado = new JPanel();
			PanelRepPostClientesEncabezado.setLayout(gridLayout26);
			PanelRepPostClientesEncabezado.setSize(new Dimension(133, 16));
			PanelRepPostClientesEncabezado.add(getBRepPostMostrarClientes(), null);
			PanelRepPostClientesEncabezado.add(LabelRepPostOpcionesClientes, null);
		}
		return PanelRepPostClientesEncabezado;
	}

	/**
	 * This method initializes PanelRepPostCuentasEncabezado	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRepPostCuentasEncabezado() {
		if (PanelRepPostCuentasEncabezado == null) {
			GridLayout gridLayout27 = new GridLayout();
			gridLayout27.setRows(2);
			gridLayout27.setColumns(1);
			PanelRepPostCuentasEncabezado = new JPanel();
			PanelRepPostCuentasEncabezado.setLayout(gridLayout27);
			PanelRepPostCuentasEncabezado.setSize(new Dimension(233, 25));
			PanelRepPostCuentasEncabezado.add(getBRepPostMostrarCuentas(), null);
			PanelRepPostCuentasEncabezado.add(LabelRepPostOpcionesCuentas, null);
		}
		return PanelRepPostCuentasEncabezado;
	}

	/**
	 * This method initializes PanelRepPostLLamadasEncabezado	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRepPostLLamadasEncabezado() {
		if (PanelRepPostLLamadasEncabezado == null) {
			GridLayout gridLayout28 = new GridLayout();
			gridLayout28.setRows(2);
			gridLayout28.setColumns(1);
			PanelRepPostLLamadasEncabezado = new JPanel();
			PanelRepPostLLamadasEncabezado.setLayout(gridLayout28);
			PanelRepPostLLamadasEncabezado.setSize(new Dimension(150, 20));
			PanelRepPostLLamadasEncabezado.add(getBRepPostMostrarLlamadas(), null);
			PanelRepPostLLamadasEncabezado.add(LabelRepPostOpcionesLLamadas, null);
		}
		return PanelRepPostLLamadasEncabezado;
	}

	public void reset()
	{
		List<Cuenta> lista = new ArrayList<Cuenta>();
		//Resetear todas las cosas
		getComboCuentaTipo().setSelectedIndex(0);
		getComboCuentaPlan().removeAllItems();
		getComboCuentaCliente().removeAllItems();
		getTextCuentaNumero().setText("");
		
		
		getComboLlamadaMes().removeAllItems();
		getComboLlamadaDia().removeAllItems();
		
		getComboLLamadaPaisDestino().setSelectedIndex(0);
		getComboLLamadaTipo().setSelectedIndex(0);
		
		getComboLlamadaMes().setEnabled(false);
		getComboLlamadaDia().setEnabled(false);
		getComboLlamadaAno().setSelectedIndex(0);
		TextLLamadaDestino.setText("");
		TextLLamadaDuracion.setText("");
		ComboLLamadaPaisDestino.setEnabled(false);
		
		getComboLLamadaCuenta().removeAllItems();
		lista =  JM.mostrarCuentas("prepost");
		if (!lista.isEmpty())
		{
			for(Cuenta c : lista)
			{
				ComboLLamadaCuenta.addItem("Id " + c.getId() + " - " + c.getNumero());
			}
		}
		
		
		
		
		getComboRecargaMes().removeAllItems();
		getComboRecargaDia().removeAllItems();
		
		
		getComboRecargaMes().setEnabled(false);
		getComboRecargaDia().setEnabled(false);
		getComboRecargaAno().setSelectedIndex(0);
		TextRecargaValor.setText("");
		
		
		getComboRecargaCuenta().removeAllItems();
		lista =  JM.mostrarCuentas("pre");
		if (!lista.isEmpty())
		{
			for(Cuenta c : lista)
			{
				ComboRecargaCuenta.addItem("Id " + c.getId() + " - " + c.getNumero());
			}
		}
		
		getComboReportePostAno().setSelectedIndex(0);
		getComboReportePostMes().setSelectedIndex(0);
	
		getScrollRepPostClientes().setVisible(false);
		getScrollRepPostCuentas().setVisible(false);
		getScrollRepPostLLamadas().setVisible(false);
		
		getComboReportePreAno().setSelectedIndex(0);
		getComboReportePreMes().setSelectedIndex(0);
	
		getScrollRepPreClientes().setVisible(false);
		getScrollRepPreCuentas().setVisible(false);
		getScrollRepPreLLamadas().setVisible(false);
		getScrollRepPreRecargas().setVisible(false);
		LabelRepPostOpcionesClientesValor.setVisible(false);
		LabelRepPostOpcionesLLamadasValor.setVisible(false);
		LabelRepPreOpcionesLLamadasTotal.setVisible(false);
		LabelRepPreOpcionesRecargasTotal.setVisible(false);
		LabelRepPreOpcionesClienteTotal.setVisible(false);
		
		//...
		
		
	}


	

}  //  @jve:decl-index=0:visual-constraint="10,10"

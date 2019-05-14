package view;

//VENTANA PRINCIPAL DE GESTIÓN DE LA GALERÍA, UNA VEZ CONFIRMADO EL ACCESO 
//TODO: terminar el menu

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import control.Controlador;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.BorderFactory;
import javax.swing.JSeparator;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.ComponentOrientation;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VPrincipal extends JFrame implements IVentanas {

	// *******ATRIBUTOS*********
	private JMenuBar menuBar;
	private JMenu menuArchivo;
	private JMenuItem mntmEdit;
	private JMenuItem mntmListadoEmple;
	private JMenuItem mntmGaleria;
	private JMenuItem mnSalir;
	private JMenu mnNuevo;
	private JMenuItem mntmNewAutor;
	private JMenuItem mntmNewObra;
	private JMenu mnBorrar;
	private JMenuItem mntmDeleteAutor;
	private JMenuItem mntmDeleteObra;
	private JSeparator separator;
	private JMenu mnAdminEmples;
	private JMenuItem mntmNewEmple;
	private JMenuItem mntmEditEmple;
	private JSeparator separator_1;
	private JMenuItem mntmCerrarSesion;
	private JMenu mnVentas;
	private JSeparator separator_2;
	private JMenu mnBuscar;
	private JMenuItem mntmSearchAutor;
	private JMenuItem mntmSearchObra;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaDe;
	private JMenuItem mntmCerrarSesion2;
	private JScrollPane spContenedor;
	private JPanel contenedor;
	private JLabel lblNewLabel;
	private JMenuItem mntmHelpBienvenida;
	private JSeparator separator_3;
	private JMenuItem mntmAyuda;

	// *******CONSTRUCTOR*********
	public VPrincipal(String title) throws HeadlessException {
		super(title);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/15.png")));
		inicializar();
	}

	// *******METODOS*********

	// metodo implementado por la interfaz IVentanas que inicializa componentes de
	// la ventana
	@Override
	public void inicializar() {
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			// asigno Theme (String themeName, String licenseKey, String logoString)
			com.jtattoo.plaf.hifi.HiFiLookAndFeel.setTheme("Large-Font", "INSERT YOUR LICENSE KEY HERE",
					"Gallery of Fantastic Puzzles");
			// Seleccionamos the Look and Feel
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Configuración del menú de la vista principal
		// ***Barra de menu
		menuBar = new JMenuBar();

		// ***Menu ARCHIVO
		menuArchivo = new JMenu("Archivo");
		menuArchivo.setPreferredSize(new Dimension(70, 22));
		menuArchivo.setMaximumSize(new Dimension(100, 32767));
		menuArchivo.setMnemonic('A'); // no lo marca

		// **Menu Nuevo
		mnNuevo = new JMenu("Nuevo");
		menuArchivo.add(mnNuevo);

		// *Item Nuevo Autor
		mntmNewAutor = new JMenuItem("Autor");
		mnNuevo.add(mntmNewAutor);

		// *Item Nueva Obra
		mntmNewObra = new JMenuItem("Obra");
		mnNuevo.add(mntmNewObra);

		// **Item Editar
		mntmEdit = new JMenuItem("Editar");
		menuArchivo.add(mntmEdit);

		// **Menu Borrar
		mnBorrar = new JMenu("Borrar");
		menuArchivo.add(mnBorrar);

		// *Item Borrar Autor
		mntmDeleteAutor = new JMenuItem("Autor");
		mnBorrar.add(mntmDeleteAutor);

		// *Item Borrar Obra
		mntmDeleteObra = new JMenuItem("Obra");
		mnBorrar.add(mntmDeleteObra);

		// *separador
		separator = new JSeparator();
		menuArchivo.add(separator);

		// **Menu Administrar Empleados
		mnAdminEmples = new JMenu("Administrar Empleados");
		menuArchivo.add(mnAdminEmples);

		// *Item Nuevo Empleado
		mntmNewEmple = new JMenuItem("Nuevo");
		mntmNewEmple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DialogRegistroUser().hacerVisible();
			}
		});
		mnAdminEmples.add(mntmNewEmple);

		// *Item Editar Empleado
		mntmEditEmple = new JMenuItem("Editar");
		mnAdminEmples.add(mntmEditEmple);

		// **Menu Listado Empleados
		mntmListadoEmple = new JMenuItem("Listado Empleados");
		mntmListadoEmple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelListaEmpleados plemple = new PanelListaEmpleados();
				VPrincipal.this.visualicePanel(plemple);
				plemple.cargarListaEmple();
			}
		});
		menuArchivo.add(mntmListadoEmple);

		// **Menu Nueva Galeria
		mntmGaleria = new JMenuItem("Administrar Galer\u00EDas...");
		menuArchivo.add(mntmGaleria);

		// **separador
		separator_1 = new JSeparator();
		menuArchivo.add(separator_1);

		// **Item Cerrar Sesión de empleado
		mntmCerrarSesion = new JMenuItem("Cerrar Sesión");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VPrincipal.reiniciarApp();
			}
		});
		mntmCerrarSesion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.CTRL_DOWN_MASK));
		menuArchivo.add(mntmCerrarSesion);

		//**separador
		separator_2 = new JSeparator();
		menuArchivo.add(separator_2);

		//**Item Salir de la aplicacion
		mnSalir = new JMenuItem("Salir");
		mnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas salir del programa?",
						"Confirmación de cierre de aplicación", JOptionPane.YES_NO_OPTION);
				if (opcion == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		mnSalir.setMnemonic('x');
		mnSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_MASK));
		mnSalir.addItemListener(null);
		menuArchivo.add(mnSalir);
		menuBar.add(menuArchivo);

		// ***Menu BUSCAR
		mnBuscar = new JMenu("Buscar");
		mnBuscar.setPreferredSize(new Dimension(70, 22));
		mnBuscar.setMaximumSize(new Dimension(100, 32767));
		menuBar.add(mnBuscar);

		//**Item Buscar Autor
		mntmSearchAutor = new JMenuItem("Autores");
		mntmSearchAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelBuscar pbus = new PanelBuscar();
				VPrincipal.this.visualicePanel(pbus);
				pbus.cargarTablaAutores();
			}
		});
		mnBuscar.add(mntmSearchAutor);

		//**Item Buscar Obra
		mntmSearchObra = new JMenuItem("Obras");
		mnBuscar.add(mntmSearchObra);

		// ***Menu VENTAS
		mnVentas = new JMenu("Ventas");
		mnVentas.setPreferredSize(new Dimension(70, 22));
		mnVentas.setMaximumSize(new Dimension(80, 32767));
		menuBar.add(mnVentas);

		// ***Menu AYUDA
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setPreferredSize(new Dimension(70, 22));
		mnAyuda.setMaximumSize(new Dimension(80, 32767));
		menuBar.add(mnAyuda);

		//**Item Bienvenida
		mntmHelpBienvenida = new JMenuItem("Le damos la bienvenida...");
		mntmHelpBienvenida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DialogBienve().hacerVisible();
			}
		});
		mnAyuda.add(mntmHelpBienvenida);
		
		//**Item Manual de ayuda
		mntmAyuda = new JMenuItem("Manual de Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File path = new File("Formatos_Proyecto_daM_EVERIS.pdf");
					Desktop.getDesktop().open(path);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		mnAyuda.add(mntmAyuda);

		//**separador
		separator_3 = new JSeparator();
		mnAyuda.add(separator_3);

		//**Item Acerca de
		mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DialogAcercaDe().hacerVisible();
			}
		});
		mnAyuda.add(mntmAcercaDe);

		// ***Item CERRAR SESIÓN
		mntmCerrarSesion2 = new JMenuItem("Cerrar Sesión");
		mntmCerrarSesion2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mntmCerrarSesion2.setHorizontalAlignment(SwingConstants.RIGHT);
		mntmCerrarSesion2.setHorizontalTextPosition(SwingConstants.RIGHT);
		mntmCerrarSesion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VPrincipal.reiniciarApp();
			}
		});
		menuBar.add(mntmCerrarSesion2);

		setJMenuBar(menuBar);


		contenedor = new JPanel(new BorderLayout());
		contenedor.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));
		setContentPane(contenedor);

		spContenedor = new JScrollPane();
		contenedor.add(spContenedor, BorderLayout.CENTER);

		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(VPrincipal.class.getResource("/images/usuario.png")));
		spContenedor.setViewportView(lblNewLabel);

		// añadimos un listener a la ventana
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// Configuración final de la pantalla
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(250, 250, 1200, 700);
		this.setLocationRelativeTo(null); // para que centre en pantalla

	}

	// metodo implementado por la interfaz que hemos creado para el control
	@Override
	public void setControlador(Controlador control) {

		/*
		 * PARA CUMPLIR CON BUENAS PRACTICAS EN CUANTO A LEGIBILIDAD DE CODIGO, LOS
		 * EVENTOS ASOCIADOS A LOS ITEMS DEL MENU ASOCIADOS A EVENTOS, DEBERÍAN ESTAR
		 * ASOCIADOS AL CONTROLADOR MEDIANTE ESTE METODO Y DETALLADOS EN EL PROPIO
		 * CONTROLADOR, PERO DE ESE MODO PIERDEN SU FUNCIONALIDAD. POR ELLO, SUS
		 * LISTENER ESTAN ESPECIFICADOS EN LA PROPIA CONFIGURACION DE CADA UNO DE ELLOS
		 * DIRECTAMENTE, Y TAMPOCO SE NECESITA SU CORRESPONDIENTE METODO GET DE ACCESO
		 */

		/*
		 * CON LOS PANELES NOS OCURRE LO MISMO, AL INVOCARLOS DESDE LA CLASE CONTROLADOR
		 * NO SE CARGAN, POR LO QUE TENEMOS QUE HACERLO DIRECTAMENTE AÑADIENDO SU
		 * CORRESPONDIENTE ESCUCHADOR EN EL METODO INICIALIZAR DE LA VENTANA PRINCIPAL
		 */

	}

	// metodos de acceso GETTERS para los botones asociados a eventos de usuario

	// metodo para hacer visible la ventana
	public void hacerVisible(boolean admin) {
		setVisible(true);

		// el menu de empleados estará disponible o no en funcion del user logado
		// lo mismo ocurre con administracion de galerias y el listado de empleados
		if (admin) { // si es user administrador estarán habilitados
			mnAdminEmples.setEnabled(true);
			mntmListadoEmple.setEnabled(true);
			mntmGaleria.setEnabled(true);
		} else { // si no es user administrador estarán deshabilitados
			mnAdminEmples.setEnabled(false);
			mntmListadoEmple.setEnabled(false);
			mntmGaleria.setEnabled(false);
		}
	}

	// metodo para hacer visible los diferentes paneles que aparecerán en esta
	// ventana principal
	public void visualicePanel(JPanel panel) { // cambio parámetro para que pueda servir para cualquier panel
		spContenedor.setViewportView(panel);
	}

	/*
	 * el siguiente metodo lo necesitamos para reiniciar la aplicacion cuando el
	 * usuario cierra sesión, ya que el metodo main está pensado para ser inicio y
	 * final de aplicacion unicamente, de esta forma repetiríamos el código si fuese
	 * necesario reiniciar la aplicación porque cambie el usuario. Es el mismo
	 * código que ejecuta la clase MAIN
	 */
	public static void reiniciarApp() {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				Login vl = new Login();
				VPrincipal vp = new VPrincipal("Gestión de Gallery Fantastic Puzzles");

				Controlador control = new Controlador(vl, vp);

				vl.setControlador(control);

				vl.hacerVisible();
			}
		});
	}
}

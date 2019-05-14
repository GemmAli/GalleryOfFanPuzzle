package view;

//PANEL QUE CARGARÁ EL LISTADO DE OBRAS O AUTORES DE LA BD EN FUNCION DEL MENUITEM SELECCIONADO 

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import accesoDB.AutorPersistencia;
import control.Controlador;
import model.AutorPojo;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelBuscar extends JPanel implements IVentanas {

	// *******ATRIBUTOS*********
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton btnImprimir;
	private JLabel lblBuscar;
	private JScrollPane spTabla;
	private JTable tabla;
	private DefaultTableModel dtm;

	// *******CONSTRUCTOR*********
	public PanelBuscar() {
		inicializar();
	}

	// *******METODOS*********

	// metodo implementado por la interfaz IVentanas que inicializa componentes de
	// la ventana
	@Override
	public void inicializar() {
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			com.jtattoo.plaf.hifi.HiFiLookAndFeel.setTheme("Large-Font", "INSERT YOUR LICENSE KEY HERE",
					"Gallery of Fantastic Puzzles");
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		setPreferredSize(new Dimension(1150, 630));
		setLayout(new BorderLayout(0, 0));

		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(contentPanel, BorderLayout.CENTER);

		lblBuscar = new JLabel("Listado de Obras y/o Autores");
		lblBuscar.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 17));
		contentPanel.add(lblBuscar);

		spTabla = new JScrollPane();
		spTabla.setPreferredSize(new Dimension(1130, 550));
		contentPanel.add(spTabla);

		tabla = new JTable();
		tabla.addMouseListener(new MouseAdapter() {
			// al hacer click sobre la tabla, se mostrará el autor seleccionado en nueva
			// ventana
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AutorPojo autorSel = obtenerAutorSel();
				if (autorSel != null) {
					new DialogFichaAutor(autorSel).hacerVisible();
				}
			}
		});
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		spTabla.setViewportView(tabla);

		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(buttonPane, BorderLayout.SOUTH);

		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Evento asociado al boton IMPRIMIR, que simula el envio del listado a la
				// impresora
				JOptionPane.showMessageDialog(null, "Se ha enviado a la impresora", "Imprimir Listado",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		buttonPane.add(btnImprimir);
	}

	// metodo implementado por la interfaz que hemos creado para el control
	@Override
	public void setControlador(Controlador control) {
		/*
		 * PARA CUMPLIR CON BUENAS PRACTICAS EN CUANTO A LEGIBILIDAD DE CODIGO, LOS
		 * EVENTOS ASOCIADOS A LOS ELEMENTOS DE LOS PANELES ASOCIADOS A EVENTOS,
		 * DEBERÍAN ESTAR ASOCIADOS AL CONTROLADOR MEDIANTE ESTE METODO Y DETALLADOS EN
		 * EL PROPIO CONTROLADOR, PERO DE ESE MODO PIERDEN SU FUNCIONALIDAD Y NO SE
		 * CARGAN EN LA VENTANA PRINCIPAL. POR LO QUE TENEMOS QUE HACERLO DIRECTAMENTE
		 * AÑADIENDO SU CORRESPONDIENTE ESCUCHADOR EN EL METODO INICIALIZAR DE LA
		 * VENTANA PRINCIPAL
		 */
	}

	// metodo de acceso GET del boton imprimir
	public JButton getBtnImprimir() {
		return btnImprimir;
	}

	// metodo de acceso GET de la tabla
	public JTable getTabla() {
		return tabla;
	}

	// este metodo cargará la tabla de autores de la BD en pantalla
	public void cargarTablaAutores() {
		// para cargarla, necesitaremos un defaultTableModel, igual que para el JList
		// lo declaramos como atributo y lo inicializamos a continuación:
		dtm = new DefaultTableModel() {
			public boolean isCellEditable(int fila, int columna) { // este metodo dice si las filas son editables o no
				return false; // si es false, ninguna celda es editable
			}
		};

		tabla.setModel(dtm); // una vez creado, añadimos el modelo a nuestra tabla

		// y a continuacion añadimos las columnas:
		dtm.addColumn("ID");
		dtm.addColumn("NOMBRE Y APELLIDOS");
		dtm.addColumn("NACIMIENTO");
		dtm.addColumn("NACIONALIDAD");
		dtm.addColumn("TELEFONO");
		dtm.addColumn("E-MAIL");
		dtm.addColumn("BIOGRAFIA");
		dtm.addColumn("DESTREZA");

		// asignar tamaño a las columnas
		tabla.getColumn("ID").setPreferredWidth(5);
		tabla.getColumn("NOMBRE Y APELLIDOS").setPreferredWidth(25);
		tabla.getColumn("NACIMIENTO").setPreferredWidth(5);
		tabla.getColumn("NACIONALIDAD").setPreferredWidth(5);
		tabla.getColumn("TELEFONO").setPreferredWidth(5);
		tabla.getColumn("E-MAIL").setPreferredWidth(5);
		tabla.getColumn("BIOGRAFIA").setPreferredWidth(40);
		tabla.getColumn("DESTREZA").setPreferredWidth(10);

		// añadir las filas que forman los datos de la tabla, creamos array deObjetos
		Object[] fila = new Object[8]; // el tamaño será el número de columnas

		// obtenemos los datos de la tabla para poder rellenar las filas del panel
		AutorPersistencia ap = new AutorPersistencia();
		ArrayList<AutorPojo> listaAutores = ap.consultarAutores();

		// creado el metodo consultar, damos forma a la tabla del panel: recorremos la
		// lista con un foreach y vamos dando forma a la fila del panel, indicando en
		// cada posición qué campo le asignamos
		for (AutorPojo autores : listaAutores) {
			fila[0] = autores.getIdAutor();
			fila[1] = autores.getApenomAutor();
			fila[2] = autores.getFechaNacAutor();
			fila[3] = autores.getNacionalidadAutor();
			fila[4] = autores.getTelfAutor();
			fila[5] = autores.getMailAutor();
			fila[6] = autores.getBiografiaAutor();
			fila[7] = autores.getDestrezaAutor();

			// y una vez asignados los campos añadimos la fila entera al DefaultTableModel
			dtm.addRow(fila);
		}
	}

	// este metodo se usará para obtener la fila seleccionada de la tabla
	public AutorPojo obtenerAutorSel() {

		int i = getTabla().getSelectedRow();

		// 1ºcontrolamos la excepcion por si no hay fila seleccionada que muestre
		// mensaje de error
		if (i == -1) {
			JOptionPane.showMessageDialog(getParent(), "Seleccionar un autor para abrir su ficha",
					"Error al seleccionar", JOptionPane.WARNING_MESSAGE);
			return null;
		} else { // en caso de que no sea -1 entonces continuamos el método
			// 2º recuperamos los campos de la fila seleccionada y creamos un objeto autor
			String idSel = (String) getTabla().getModel().getValueAt(i, 0);
			String apenom = (String) getTabla().getModel().getValueAt(i, 1);
			String fechaNac = (String) getTabla().getModel().getValueAt(i, 2);
			String nacionalidad = (String) getTabla().getModel().getValueAt(i, 3);
			int telf = (int) getTabla().getModel().getValueAt(i, 4);
			String mail = (String) getTabla().getModel().getValueAt(i, 5);
			String biografia = (String) getTabla().getModel().getValueAt(i, 6);
			String destreza = (String) getTabla().getModel().getValueAt(i, 7);

			// creamos un objeto autor con esos datos
			AutorPojo autorSel = new AutorPojo(idSel, apenom, fechaNac, nacionalidad, telf, mail, biografia, destreza);

			return autorSel;
		}
	}
	/*
	 * public void mostrarMensajeBorrar(String msg) {
	 * JOptionPane.showMessageDialog(getParent(), msg, "Resultado de Borrar Alumno",
	 * JOptionPane.INFORMATION_MESSAGE); cargarTabla(); }
	 */
}

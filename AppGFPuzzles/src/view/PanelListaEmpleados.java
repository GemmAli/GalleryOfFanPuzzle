package view;

//PANEL QUE CARGARÁ EL LISTADO DE EMPLEADOS DADOS DE ALTA EN EL SISTEMA 

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import accesoDB.UsuarioPersistencia;
import control.Controlador;
import model.UsuarioPojo;

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

public class PanelListaEmpleados extends JPanel implements IVentanas {

	// *******ATRIBUTOS*********
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton btnImprimir;
	private JLabel lblListaEmple;
	private JScrollPane spTabla;
	private JTable tabla;
	private DefaultTableModel dtm;

	// *******CONSTRUCTOR*********
	public PanelListaEmpleados() {
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

		lblListaEmple = new JLabel("Listado de empleados");
		lblListaEmple.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 17));
		contentPanel.add(lblListaEmple);

		spTabla = new JScrollPane();
		spTabla.setPreferredSize(new Dimension(1000, 550));
		contentPanel.add(spTabla);

		tabla = new JTable();
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
	public void cargarListaEmple() {
		// para cargarla, necesitaremos un defaultTableModel, igual que para el JList
		// lo declaramos como atributo y lo inicializamos a continuación:
		dtm = new DefaultTableModel() {
			public boolean isCellEditable(int fila, int columna) { // este metodo dice si las filas son editables o no
				return false; // si es false, ninguna celda es editable
			}
		};

		tabla.setModel(dtm); // una vez creado, añadimos el modelo a nuestra tabla

		// y a continuacion añadimos las columnas:
		dtm.addColumn("NOMBRE Y APELLIDOS");
		dtm.addColumn("Nº SEGURIDAD SOCIAL");
		dtm.addColumn("Nº CUENTA");
		dtm.addColumn("DNI");
		dtm.addColumn("E-MAIL");
		dtm.addColumn("ID");

		// asignar tamaño a las columnas
		tabla.getColumn("NOMBRE Y APELLIDOS").setPreferredWidth(25);
		tabla.getColumn("Nº SEGURIDAD SOCIAL").setPreferredWidth(5);
		tabla.getColumn("Nº CUENTA").setPreferredWidth(5);
		tabla.getColumn("DNI").setPreferredWidth(5);
		tabla.getColumn("E-MAIL").setPreferredWidth(5);
		tabla.getColumn("ID");

		// añadir las filas que forman los datos de la tabla, creamos array deObjetos
		Object[] fila = new Object[6]; // el tamaño será el número de columnas

		// obtenemos los datos de la tabla para poder rellenar las filas del panel
		UsuarioPersistencia up = new UsuarioPersistencia();
		ArrayList<UsuarioPojo> listaEmpleados = up.listarUser();

		// creado el metodo consultar, damos forma a la tabla del panel: recorremos la
		// lista con un foreach y vamos dando forma a la fila del panel, indicando en
		// cada posición qué campo le asignamos
		for (UsuarioPojo empleados : listaEmpleados) {
			fila[0] = empleados.getApe_nom_emple();
			fila[1] = empleados.getNum_ssocIal();
			fila[2] = empleados.getCuentaBancaria();
			fila[3] = empleados.getDni();
			fila[4] = empleados.getE_mail_emple();
			fila[5] = empleados.getId_empleado();
			
			// y una vez asignados los campos añadimos la fila entera al DefaultTableModel
			dtm.addRow(fila);
		}

	}

}

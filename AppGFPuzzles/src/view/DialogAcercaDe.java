package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class DialogAcercaDe extends JDialog {

	// *******ATRIBUTOS*********
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton okButton;
	private JLabel lblNewLabel;
	private JTabbedPane tabbedPane_1;
	private JLabel lblNewLabel_1;
	private JTextArea txtaAcerca;
	private JTextArea txtaAutores;

	// *******CONSTRUCTOR*********
	public DialogAcercaDe() {
		setTitle("Bienvenido a Gallery of Fantastic Puzzles");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/15.png")));
		inicializar();
	}

	// metodo implementado por la interfaz IVentanas que inicializa componentes de
	// la ventana
	private void inicializar() {
		try {
			setDefaultLookAndFeelDecorated(true);
			com.jtattoo.plaf.hifi.HiFiLookAndFeel.setTheme("Large-Font", "INSERT YOUR LICENSE KEY HERE",
					"Gallery of Fantastic Puzzles");
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//configuración del JDialog
		setBounds(100, 100, 550, 335);
		this.setLocationRelativeTo(null);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		//Componentes del JDialog
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel.setIcon(new ImageIcon(DialogBienve.class.getResource("/images/19-70x70.png")));
			contentPanel.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setPreferredSize(new Dimension(30, 0));
			lblNewLabel_1.setSize(new Dimension(30, 0));
			contentPanel.add(lblNewLabel_1);
		}
		{
			//PANEL DONDE MOSTRAMOS LAS DIFERENTES PESTAÑAS DE INFORMACION
			tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane_1.setPreferredSize(new Dimension(380, 230));
			tabbedPane_1.setMinimumSize(new Dimension(350, 50));
			contentPanel.add(tabbedPane_1);
			{
				//PRIMERA PESTAÑA
				txtaAcerca = new JTextArea();
				txtaAcerca.setEditable(false);
				txtaAcerca.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				txtaAcerca.setText("       Software: AppGFPuzzles                       Versión:  v1.0.1\r\n\r\nversión 1.0.1\r\nrevisión del 05/05/2019\r\nJava SE 1.8 \r\n\r\nAppGFPuzzles es una aplicación de gestión desarrollada por \r\nAlige Development S.L para la Gestión completa de galerías de \r\nArte. Distribuida con fines comerciales. \r\nProducto comercializado bajo licencia (Alige Development S.L) \r\n");
				tabbedPane_1.addTab("Acerca De", null, txtaAcerca, null);
			}
			{
				//SEGUNDA PESTAÑA
				txtaAutores = new JTextArea();
				txtaAutores.setEditable(false);
				txtaAutores.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				txtaAutores.setText("Estaremos muy agradecidos de que informen de cualquier \r\nerror o sugerencia por correo electrónico a \r\nalige_bugs@aligedev.com\r\n\r\nALICIA MARTÍN\r\nDesarrollador / Mantenimiento / Corrección (desde 2019)\r\n\r\nGEMA JIMÉNEZ\r\nDesarrollador / Mantenimiento / Corrección (desde 2019)");
				tabbedPane_1.addTab("Autores", null, txtaAutores, null);
			}
		}
		{
			// PANEL PARA BOTONES
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				//Boton OK
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						DialogAcercaDe.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

	// método para hacer visible la ventana de bienvenida
	public void hacerVisible() {
		setVisible(true);
	}
}

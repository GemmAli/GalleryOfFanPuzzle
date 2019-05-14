package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import javax.swing.JEditorPane;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class DialogBienve extends JDialog{

	// *******ATRIBUTOS*********
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton btnOkBienve;
	private JEditorPane dtrpnBienve;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	// *******CONSTRUCTOR*********
	public DialogBienve() {
		setTitle("Bienvenido a Gallery of Fantastic Puzzles");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/15.png")));
		inicializar();
	}

	// metodo implementado por la interfaz IVentanas que inicializa componentes de
	// la ventana
	public void inicializar() {
		try {
			setDefaultLookAndFeelDecorated(true);
			com.jtattoo.plaf.hifi.HiFiLookAndFeel.setTheme("Large-Font", "INSERT YOUR LICENSE KEY HERE",
					"Gallery of Fantastic Puzzles");
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		//Configuración del JDialog
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		//Componentes del JDialog
		{
			//TEXTO DE BIENVENIDA
			dtrpnBienve = new JEditorPane();
			dtrpnBienve.setOpaque(false);
			dtrpnBienve.setEditable(false);
			dtrpnBienve.setPreferredSize(new Dimension(400, 130));
			dtrpnBienve.setFont(new Font("Segoe UI", Font.BOLD, 15));
			dtrpnBienve.setText(
					"Bienvenido/a a GFPuzzles, la aplicación desarrollada por \r\nAlige Development para la Gestión de su Galería de Arte\r\n\r\nPara más información, consulte los siguientes \r\napartados del menú Ayuda.");
			contentPanel.add(dtrpnBienve);
		}
		{
			//ICONO CORPORATIVO
			lblNewLabel = new JLabel("");
			lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
			lblNewLabel.setIcon(new ImageIcon(DialogBienve.class.getResource("/images/19-70x70.png")));
			contentPanel.add(lblNewLabel);
		}
		{
			//PANEL DESTINADO PARA LOS BOTONES
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				//BOTON OK
				btnOkBienve = new JButton("OK");
				btnOkBienve.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						DialogBienve.this.dispose();
					}
				});
				btnOkBienve.setActionCommand("OK");
				buttonPane.add(btnOkBienve);
				getRootPane().setDefaultButton(btnOkBienve);
			}
			{
				//etiqueta utilizada para separar el icono del cuadro de texto
				lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setPreferredSize(new Dimension(30, 14));
				lblNewLabel_1.setMinimumSize(new Dimension(246, 14));
				lblNewLabel_1.setMaximumSize(new Dimension(246, 14));
				buttonPane.add(lblNewLabel_1);
			}
		}

	}

	// método para hacer visible la ventana de bienvenida
	public void hacerVisible() {
		setVisible(true);
	}
}

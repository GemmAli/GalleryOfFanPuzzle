package view;

// VENTANA INICIAL, CONTROL DE ACCESO A USUARIOS REGISTRADOS
//lblRegistrar.setToolTipText("Hacer click para registrar un nuevo usuario"); para texto alternativo

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import control.Controlador;
import model.JPasswordfieldHint;
import model.JTextfieldHint;
import model.UsuarioPojo;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements IVentanas {

	// *******ATRIBUTOS*********
	private LoginFondo fondo;
	private JTextField txtBienvenida;
	private JTextfieldHint txtUsuario;
	private JPasswordfieldHint pwdPass;
	private JLabel lblUsuario;
	private JLabel lblPass;
	private JButton btnAcceder;
	private JCheckBox chbxMostrarPass;

	// *******CONSTRUCTOR*********
	public Login() throws HeadlessException {
		setTitle("Acceso de Usuarios");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/15.png")));
		inicializar();
	}

	// *******MÉTODOS*********

	// metodo para hacer visible la ventana de login
	public void hacerVisible() {
		setVisible(true);
	}

	// metodo implementado por la interfaz que hemos creado para el control
	@Override
	public void setControlador(Controlador control) {
		btnAcceder.addActionListener(control);
	}

	// métodos get para los controles que escuchan eventos de usuario
	public JButton getBtnAcceder() {
		return btnAcceder;
	}

	// metodo implementado por la interfaz que hemos creado para inicializar
	// componentes de la ventana
	@Override
	public void inicializar() {
		try {
			// le damos un aspecto diferente mediante la librería JTattoo
			JFrame.setDefaultLookAndFeelDecorated(true);
			com.jtattoo.plaf.hifi.HiFiLookAndFeel.setTheme("Large-Font", "INSERT YOUR LICENSE KEY HERE", "Gallery of Fantastic Puzzles");
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 750, 550); //tamaño de la ventana
		this.setLocationRelativeTo(null); // para que centre en pantalla

		//añadimos la imagen de pieza de puzzle como fondo
		fondo = new LoginFondo();
		fondo.setBackground(new Color(169, 169, 169));
		getContentPane().add(fondo);

		//configuración del texto de la cabecera
		txtBienvenida = new JTextField();
		txtBienvenida.setDisabledTextColor(new Color(102, 0, 102));
		txtBienvenida.setEnabled(false);
		txtBienvenida.setForeground(new Color(102, 0, 102));
		txtBienvenida.setBorder(null);
		txtBienvenida.setOpaque(false);
		txtBienvenida.setEditable(false);
		txtBienvenida.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 31));
		txtBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		txtBienvenida.setText("Gallery of Fantastic Puzzles");
		txtBienvenida.setBounds(131, 134, 516, 46);
		fondo.add(txtBienvenida);
		txtBienvenida.setColumns(10);

		//configuración para el icono del correo electronico
		lblUsuario = new JLabel("");
		lblUsuario.setIcon(new ImageIcon(Login.class.getResource("/images/sobre1.jpg")));
		lblUsuario.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblUsuario.setBackground(Color.LIGHT_GRAY);
		lblUsuario.setBounds(206, 214, 59, 46);
		fondo.add(lblUsuario);

		//configuración para el icono de la contraseña
		lblPass = new JLabel("");
		lblPass.setIcon(new ImageIcon(Login.class.getResource("/images/candado.png")));
		lblPass.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblPass.setBackground(Color.LIGHT_GRAY);
		lblPass.setBounds(206, 259, 51, 47);
		fondo.add(lblPass);

		//configuración para el campo para introducir usuario
		txtUsuario = new JTextfieldHint("Introduce el usuario"); // clase creada en paquete model
		txtUsuario.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtUsuario.setOpaque(false);
		txtUsuario.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		txtUsuario.setForeground(new Color(102, 0, 102));
		txtUsuario.setBounds(275, 220, 240, 30);
		fondo.add(txtUsuario);
		txtUsuario.setColumns(10);

		//configuración para el campo para introducir contraseña
		pwdPass = new JPasswordfieldHint("Introduce la contraseña"); // clase creada en paquete model
		pwdPass.setEchoChar((char) 0); // hacemos visible el string hint
		pwdPass.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pwdPass.setForeground(new Color(102, 0, 102));
		pwdPass.setOpaque(false);
		pwdPass.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		pwdPass.setBounds(275, 275, 240, 30);
		fondo.add(pwdPass);

		//configuración del botón de acceso
		btnAcceder = new JButton("Acceder");
		btnAcceder.setBackground(new Color(102, 0, 102));
		btnAcceder.setForeground(new Color(255, 255, 204));
		btnAcceder.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		btnAcceder.setBounds(476, 369, 128, 45);
		fondo.add(btnAcceder);

		//configuración de la opción para mostrar contraseña
		chbxMostrarPass = new JCheckBox("Mostrar contraseña");
		chbxMostrarPass.setForeground(new Color(102, 0, 102));
		chbxMostrarPass.setFont(new Font("Tempus Sans ITC", Font.ITALIC, 14));
		chbxMostrarPass.setOpaque(false);
		chbxMostrarPass.setToolTipText("Marcar para visualizar la contraseña");
		// añadimos un listener para poder mostrar la contraseña como texto
		chbxMostrarPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chbxMostrarPass.isSelected()) {
					pwdPass.setEchoChar((char) 0);
				} else {
					pwdPass.setEchoChar('*');
				}
			}
		});
		chbxMostrarPass.setBounds(537, 275, 145, 30);
		fondo.add(chbxMostrarPass);
	}

	// metodo para obtener los datos de la ventana y devolver al controlador
	public UsuarioPojo getUser() {
		String usuario = txtUsuario.getText(); //mailUser
		String password = new String(pwdPass.getPassword()); // forma para pasar caracteres a String

		UsuarioPojo user = new UsuarioPojo(usuario, password);

		return user;
	}

	// metodo para que salga una ventana si el login no es correcto
	public void mostrarMensajeError() {
		JOptionPane.showMessageDialog(getContentPane(), "Usuario y/o contraseña incorrecto/s", "Información",
				JOptionPane.ERROR_MESSAGE);
	}

	// metodo para que salga una ventana si el login llega a 3 intentos fallidos
	public void mostrarMensajeIntentos() {
		JOptionPane.showMessageDialog(getContentPane(), "Tres intentos fallidos, contacte administrador ",
				"Cuenta Bloqueada", JOptionPane.WARNING_MESSAGE);
	}

	//metodo para cerrar la ventana de la aplicacion
	public void cerrarVentana() {
		System.exit(0); // similar a exitonclose
	}

	//metodo para mostrar y recoger nombre de user para la bienvenida
	public String mostrarUsername() {
		String nombre = txtUsuario.getText();
		return nombre;
	}

	public void limpiarCampos() {
		txtUsuario.setText("");
		pwdPass.setText("");
	}
}

package view;

//VENTANA DE REGISTRO DE NUEVOS EMPLEADOS = USUARIOS, QUE DEPENDE DE LA VENTANA LOGIN

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import accesoDB.UsuarioPersistencia;
import control.Controlador;
import model.UsuarioPojo;
import javax.swing.JCheckBox;

public class DialogRegistroUser extends JDialog{

	// *******ATRIBUTOS*********
	private JLabel lblUsuario;
	private JLabel lblPass;
	private JLabel lblConfPass;
	private JTextField txtUsuario;
	private JPasswordField pwdPass;
	private JPasswordField pwdConfPass;
	private JButton btnRegistrar;
	private JCheckBox chckbxMostrarPass1;
	private JCheckBox chckbxMostrarPass2;
	private JLabel lblApenom;
	private JTextField txtApenom;
	private JTextField txtSegSoc;
	private JLabel lblSegSoc;
	private JLabel lblCuenta;
	private JTextField txtCuenta;
	private JTextField txtDni;
	private JLabel lblDniUser;
	// private DialogRegistroUser dreg;
	// private UsuarioPersistencia up;

	// *******CONSTRUCTOR*********
	// creamos el constructor from superclass y escogemos opcion (Frame, boolean).
	// Como parametros del constructor y del super ponemos FRAME y MODAL
	public DialogRegistroUser(Login vl, boolean b) {
		super();
		inicializar();
	}

	public DialogRegistroUser() {
		super();
		inicializar();
		setTitle("Registrar Nuevo Empleado en el Sistema");
	}

	// *******METODOS*********

	// metodo que inicializa componentes de la ventana
	public void inicializar() {
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		getContentPane().setLayout(null);

		lblUsuario = new JLabel("Mail Empleado:");
		lblUsuario.setBounds(40, 40, 124, 20);
		getContentPane().add(lblUsuario);

		lblPass = new JLabel("Contraseña:");
		lblPass.setBounds(40, 72, 124, 20);
		getContentPane().add(lblPass);

		lblConfPass = new JLabel("Confirmación Contraseña:");
		lblConfPass.setBounds(40, 104, 220, 20);
		getContentPane().add(lblConfPass);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(275, 40, 138, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		pwdPass = new JPasswordField();
		pwdPass.setEchoChar('*'); // quitamos valor
		pwdPass.setBounds(275, 72, 138, 20);
		getContentPane().add(pwdPass);

		pwdConfPass = new JPasswordField();
		pwdConfPass.setEchoChar('*');
		pwdConfPass.setBounds(275, 104, 138, 20);
		getContentPane().add(pwdConfPass);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// recuperamos los datos introducidos y los volcamos en BD
				UsuarioPojo user = null;
				UsuarioPersistencia up = new UsuarioPersistencia();

				//int id = up.obtenerIdEmple();
				String usuarioMail = txtUsuario.getText();
				String password = new String(pwdPass.getPassword()); // DNI de momento
				String passwordC = new String(pwdConfPass.getPassword());
				String apenom = txtApenom.getText();
				String dni = txtDni.getText();
				int numSS = Integer.parseInt(txtSegSoc.getText());
				String cuenta = txtCuenta.getText();

				if (password.equals(passwordC)) {
					// creamos un objeto usuario si coinciden las contraseñas
					user = new UsuarioPojo(apenom, numSS, cuenta, dni, usuarioMail, password);
				}

				if (user != null) {
					// insertaremos el usuario si coinciden las contraseñas
					up = new UsuarioPersistencia();
					int res = up.insertarUser(user);

					if (res == 1) { // se habrá registrado al usuario
						System.out.println("Insertado correctamente");
						JOptionPane.showMessageDialog(null, "Registro insertado correctamente",
								"Resultado del Registro", JOptionPane.INFORMATION_MESSAGE);
						dispose(); // dispose cierra ventana actual, System.exit(0) sale del programa
					}
				} else {
					// mostramos msg si no coinciden las contraseñas, manteniendo el control en dreg
					System.out.println("No insertado");
					JOptionPane.showMessageDialog(null, "Contraseñas introducidas no coinciden", "Error de contraseña",
							JOptionPane.WARNING_MESSAGE);
					// limpiamos campos de contraseña
				}
			}
		});
		btnRegistrar.setBounds(305, 285, 90, 23);
		getContentPane().add(btnRegistrar);

		chckbxMostrarPass1 = new JCheckBox("Mostrar contraseña");
		chckbxMostrarPass1.setBounds(470, 71, 175, 23);
		// añadimos un listener para poder mostrar la contraseña como texto
		chckbxMostrarPass1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxMostrarPass1.isSelected()) {
					pwdPass.setEchoChar((char) 0);
				} else {
					pwdPass.setEchoChar('*');
				}
			}
		});
		getContentPane().add(chckbxMostrarPass1);

		chckbxMostrarPass2 = new JCheckBox("Mostrar contraseña");
		chckbxMostrarPass2.setBounds(470, 103, 175, 23);
		chckbxMostrarPass2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxMostrarPass2.isSelected()) {
					pwdConfPass.setEchoChar((char) 0);
				} else {
					pwdConfPass.setEchoChar('*');
				}
			}
		});
		getContentPane().add(chckbxMostrarPass2);

		lblApenom = new JLabel("Nombre y Apellidos:");
		lblApenom.setBounds(40, 136, 220, 20);
		getContentPane().add(lblApenom);

		txtApenom = new JTextField();
		txtApenom.setBounds(275, 136, 270, 20);
		getContentPane().add(txtApenom);
		txtApenom.setColumns(10);

		lblSegSoc = new JLabel("Nº Seguridad Social:");
		lblSegSoc.setBounds(40, 200, 220, 20);
		getContentPane().add(lblSegSoc);

		txtSegSoc = new JTextField();
		txtSegSoc.setBounds(275, 200, 138, 20);
		getContentPane().add(txtSegSoc);
		txtSegSoc.setColumns(10);

		lblCuenta = new JLabel("Nº Cuenta Bancaria:");
		lblCuenta.setBounds(40, 232, 200, 20);
		getContentPane().add(lblCuenta);

		txtCuenta = new JTextField();
		txtCuenta.setBounds(275, 232, 138, 20);
		getContentPane().add(txtCuenta);
		txtCuenta.setColumns(10);

		lblDniUser = new JLabel("DNI:");
		lblDniUser.setBounds(40, 168, 124, 20);
		getContentPane().add(lblDniUser);

		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(275, 168, 138, 20);
		getContentPane().add(txtDni);

		// cambiamos EXIT por DISPOSE, porque solo queremos que cierre esta ventana, no
		// que me salga del programa definitivamente
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(250, 250, 700, 380);
		this.setLocationRelativeTo(null); // para que centre en pantalla
	}

	// método para hacer visible la ventana de registro
	public void hacerVisible() {
		setVisible(true);
	}
}

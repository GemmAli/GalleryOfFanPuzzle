package control;

//GESTIONADOR DE EVENTOS, CON LA LÓGICA DE LA APLICACIÓN

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import accesoDB.UsuarioPersistencia;
import model.UsuarioPojo;
import view.Login;
import view.VPrincipal;
import view.DialogRegistroUser;

public class Controlador extends MouseAdapter implements ActionListener {

	// *******ATRIBUTOS*********
	/*
	 * Como atributos se declaran tanto las ventanas como los paneles, como las
	 * clases persistencia que darán la lógica de manejo de los datos con respecto a
	 * la base de datos, así como las variables que necesite la propia clase para su
	 * correcto funcionamiento
	 */
	private Login vl;
	private VPrincipal vPpal;
	private UsuarioPersistencia up; // la lógica de manejar los datos de users
	private int intentos; // variable global para contabilizar los intentos, inicializamos en constructor
	String nombreUser; // variable global para almacenar el nombre de usuario

	// *******CONSTRUCTOR*********
	/*
	 * En el constructor inicializamos las ventanas y las clases persistencia, los
	 * paneles los asignaremos mediante los metodos setter de cada uno de ellos en
	 * esta misma clase
	 */
	public Controlador(Login vl, VPrincipal vp) {
		super();
		this.vl = vl;
		this.vPpal = vp;
		up = new UsuarioPersistencia(); // asi inicializamos los datos para cuando necesitemos establecer la conexion
		intentos = 0;
	}

	// *******METODOS DE ACCESO SET PARA LOS PANELES*********

	// *******METODO IMPLEMENTADO POR LA INTERFAZ*********
	@Override
	public void actionPerformed(ActionEvent ev) {
		/*
		 * Se diferneciarán los eventos según el tipo de componente que lo haya
		 * provocado, en esta aplicación esto será posible mediante JButton o JMenuItem,
		 * será la primera diferenciación
		 */
		Object fuente = ev.getSource();

		if (fuente instanceof JButton) { // BOTONES

			if (fuente.equals(vl.getBtnAcceder())) {
				// comprobar datos del usuario si son correctos, creamos metodo en ventana vl
				UsuarioPojo user = vl.getUser();
				boolean usuarioOK = up.comprobarUser(user);

				if (usuarioOK) { // cerrara la ventana login y abrirá la principal, que hacemos visible
					vl.dispose();
					vPpal.hacerVisible(true);

					// mostrar bienvenida al user
					nombreUser = vl.mostrarUsername();
					String msg = String.format("Bienvenid@ '%s'", nombreUser);
					JOptionPane.showMessageDialog(vl, msg);

					// comprobar si user es administrador
					if (nombreUser.equals("admin")) {
						vPpal.hacerVisible(true);
					} else {
						vPpal.hacerVisible(false);
					}
				} else {
					intentos++;
					vl.mostrarMensajeError();
					vl.limpiarCampos();
				}

				// control de intentos para el login
				if (intentos == 3) { // si llega a tres intentos, bloquea y cierra ventana
					vl.mostrarMensajeIntentos();
					vl.cerrarVentana();
				}

			}
			/*
			 * PARA CUMPLIR CON BUENAS PRACTICAS EN CUANTO A LEGIBILIDAD DE CODIGO, LOS
			 * EVENTOS ASOCIADOS A LOS BOTONES ASOCIADOS A EVENTOS DE VENTANAS Y PANELES
			 * DEBERÍAN ESTAR ASOCIADOS AL CONTROLADOR EN ESTE APARTADO DE IGUAL FORMA QUE
			 * EL BOTON ACCEDER, PERO DE ESTE MODO PIERDEN SU FUNCIONALIDAD. POR ELLO, SUS
			 * LISTENER ESTAN ESPECIFICADOS EN LA PROPIA CONFIGURACION DE CADA UNO DE ELLOS
			 * DIRECTAMENTE EN SU VISTA CORRESPONDIENTE.
			 */

		} else if (fuente instanceof JMenuItem) { // MENUITEMs
			/*
			 * PARA CUMPLIR CON BUENAS PRACTICAS EN CUANTO A LEGIBILIDAD DE CODIGO, LOS
			 * EVENTOS ASOCIADOS A LOS ITEMS DEL MENU ASOCIADOS A EVENTOS DE LA VENTANA
			 * PRINCIPAL, DEBERÍAN ESTAR ASOCIADOS AL CONTROLADOR EN ESTE APARTADO DE IGUAL
			 * FORMA QUE LOS BOTONES, PERO DE ESTE MODO PIERDEN SU FUNCIONALIDAD. POR ELLO,
			 * SUS LISTENER ESTAN ESPECIFICADOS EN LA PROPIA CONFIGURACION DE CADA UNO DE
			 * ELLOS DIRECTAMENTE AL IGUAL QUE SU CORRESPONDIENTE METODO GET DE ACCESO. SU
			 * ACTIONLISTENER ESTÁ DESARROLLADO EN LA CLASE VPRINCIPAL.
			 * 
			 * CON LOS COMPONENTES DE LOS PANELES OCURRE LO MISMO, POR LO QUE SU
			 * FUNCIONALIDAD SE ESPECIFICARÁ EN CADA UNA DE SUS CLASES PARA SUS VISTAS
			 */
		}
	}
}

import java.awt.EventQueue;

import control.Controlador;
import view.Login;
import view.VPrincipal;
import view.DialogRegistroUser;

//CLASE EJECUTABLE CON EL METODO MAIN

//para probar tenemos admin y admin
//para probar tenemos alicia@gfp.com y 123456
//para probar tenemos gema@gfp.com y 123456

public class AppGFPuzzles {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {				
				Login vl = new Login();
				VPrincipal vp = new VPrincipal("Gestión de Gallery Fantastic Puzzles");

				Controlador control = new Controlador(vl, vp);

				//asignamos controlador a las ventanas q tienen botones y tendremos que gestionar su evento
				vl.setControlador(control);

				//hacemos visible la primera ventana que se muestra
				vl.hacerVisible();
			}
		});
	}
}

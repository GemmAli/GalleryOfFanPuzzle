package view;

// CLASE QUE CREAMOS PARA ESTABLECER EL FONDO A LA PANTALLA DE LOGIN

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

public class LoginFondo extends JDesktopPane {

	// *******ATRIBUTOS*********
	Image imagen;

	// *******CONSTRUCTOR*********
	public LoginFondo() {
		this.setLayout(null);
		// this.setToolTipText("Ventana Principal"); texto alt como pista de la ventana
		this.setBounds(0, 0, 600, 400);

		try {
			imagen = ImageIO.read(getClass().getResource("/images/19.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// *******MÉTODOS*********
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
	}
}

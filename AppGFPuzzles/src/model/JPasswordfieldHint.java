package model;

//CLASE PARA PODER MOSTRAR UN HINT EN LOS JPASSWORDFIELD

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;

public class JPasswordfieldHint extends JPasswordField implements FocusListener {
	
	// *******ATRIBUTOS*********
	
	// *******CONSTRUCTOR*********
	public JPasswordfieldHint(String hint) {
		super(hint);
	    super.addFocusListener(this);
	}

	// *******METODOS*********
	
	@Override
	public void focusGained(FocusEvent ev) {
		//Si gana el foco el textfield con su valor inicial, vacía su contenido
		if (this.getText().equalsIgnoreCase("Introduce la contraseña")) {
			this.setText("");
			this.setEchoChar('*'); //codificamos lo que el usuario escriba
			//this.setForeground(Color.black);
			this.setForeground(new Color(102, 0, 102));
			this.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		}		
	}

	@Override
	public void focusLost(FocusEvent ev) {
		//si pierde el foco y el user no ha escrito nada, volverá a mostrar el hint
		if (this.getText().equalsIgnoreCase("")) {
			this.setText("Introduce la contraseña");
			this.setEchoChar((char) 0); //mostramos el texto como string, no char
			this.setForeground(new Color(102, 0, 102));
			this.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		}	
	}
	
}

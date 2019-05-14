package model;

// CLASE PARA PODER MOSTRAR UN HINT EN LOS JTEXTFIELD

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class JTextfieldHint extends JTextField implements FocusListener {
	
	// *******ATRIBUTOS*********
	private final String hint;

	// *******CONSTRUCTOR*********
	public JTextfieldHint(final String hint) {
		super(hint);
	    this.hint = hint;
	    super.addFocusListener(this);
	}

	// *******METODOS*********
	
	@Override
	public void focusGained(FocusEvent ev) {
		//Si gana el foco el textfield con su valor inicial, vacía su contenido
		if (JTextfieldHint.this.getText().equalsIgnoreCase(hint)) {
			this.setText("");
			//this.setForeground(Color.black);
			this.setForeground(new Color(102, 0, 102));
			this.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		}
	}

	@Override
	public void focusLost(FocusEvent ev) {
		//si pierde el foco y el user no ha escrito nada, volverá a mostrar el hint
		if (this.getText().equalsIgnoreCase("")) {
			this.setText(hint);
			this.setForeground(new Color(102, 0, 102));
			this.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		}
	}
}
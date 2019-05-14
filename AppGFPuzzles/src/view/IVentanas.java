package view;

import control.Controlador;

public interface IVentanas {

	//metodo para inicializar cada ventana
	public void inicializar(); 

	//metodo para asignar el controlador de la ventana con la lógica
	public void setControlador(Controlador control);

	// el metodo hacerVisible no lo ponemos aqui porque es exclusivo de JFrame y
	// nosotros tendremos tambien paneles que no lo llevan, asi que se pondria en el
	// JFrame
}

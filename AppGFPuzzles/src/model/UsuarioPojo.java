package model;

//modelo de los objetos Usuario que corresponde a la tabla empleados

public class UsuarioPojo {

	// *******ATRIBUTOS*********
	private int id_empleado;
	private String ape_nom_emple;
	private int num_ssocIal;
	private String cuentaBancaria;
	private String dni;
	private String e_mail_emple;
	private String password_emple;

	// *******CONSTRUCTORES*********
	public UsuarioPojo(int id_empleado, String ape_nom_emple, int num_ssocIal, String cuentaBancaria, String dni, String e_mail_emple, String password_emple) {
		super();
		this.id_empleado = id_empleado;
		this.ape_nom_emple = ape_nom_emple;
		this.num_ssocIal = num_ssocIal;
		this.cuentaBancaria = cuentaBancaria;
		this.dni = dni;
		this.e_mail_emple = e_mail_emple;
		this.password_emple = password_emple;
	}

	public UsuarioPojo(String e_mail_emple, String password_emple) {
		super();
		this.e_mail_emple = e_mail_emple;
		this.password_emple = password_emple;
	}

	public UsuarioPojo(String ape_nom_emple, int num_ssocIal, String cuentaBancaria, String dni, String e_mail_emple, String password_emple) {
		super();
		this.ape_nom_emple = ape_nom_emple;
		this.num_ssocIal = num_ssocIal;
		this.cuentaBancaria = cuentaBancaria;
		this.dni = dni;
		this.e_mail_emple = e_mail_emple;
		this.password_emple = password_emple;
	}

	// *******METODOS DE ACCESO GET*********
	public int getId_empleado() {
		return id_empleado;
	}

	public String getApe_nom_emple() {
		return ape_nom_emple;
	}

	public int getNum_ssocIal() {
		return num_ssocIal;
	}

	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	public String getDni() {
		return dni;
	}

	public String getE_mail_emple() {
		return e_mail_emple;
	}

	public String getPassword_emple() {
		return password_emple;
	}

}

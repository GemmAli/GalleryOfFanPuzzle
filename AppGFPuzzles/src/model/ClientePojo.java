package model;

//modelo de los objetos Cliente que corresponde a la tabla clientes

public class ClientePojo {

	// *******ATRIBUTOS*********
	private String idCli;
	private String apenomCli;
	private String dniCli;
	private String mailCli;
	
	// *******CONSTRUCTOR*********
	public ClientePojo(String idCli, String apenomCli, String dniCli, String mailCli) {
		super();
		this.idCli = idCli;
		this.apenomCli = apenomCli;
		this.dniCli = dniCli;
		this.mailCli = mailCli;
	}

	// *******METODOS DE ACCESO GET*********	
	public String getIdCli() {
		return idCli;
	}

	public String getApenomCli() {
		return apenomCli;
	}

	public String getDniCli() {
		return dniCli;
	}

	public String getMailCli() {
		return mailCli;
	}

}

package model;

//modelo de los objetos Autor que corresponde a la tabla autores

public class AutorPojo {

	// *******ATRIBUTOS*********
	private String idAutor;
	private String apenomAutor;
	private String fechaNacAutor;
	private String nacionalidadAutor;
	private int telfAutor;
	private String mailAutor;
	private String biografiaAutor;
	private String destrezaAutor;
	
	// *******CONSTRUCTOR*********
	public AutorPojo(String idAutor, String apenomAutor, String fechaNacAutor, String nacionalidadAutor, int telfAutor,
			String mailAutor, String biografiaAutor, String destrezaAutor) {
		super();
		this.idAutor = idAutor;
		this.apenomAutor = apenomAutor;
		this.fechaNacAutor = fechaNacAutor;
		this.nacionalidadAutor = nacionalidadAutor;
		this.telfAutor = telfAutor;
		this.mailAutor = mailAutor;
		this.biografiaAutor = biografiaAutor;
		this.destrezaAutor = destrezaAutor;
	}

	// *******METODOS DE ACCESO GET*********
	public String getIdAutor() {
		return idAutor;
	}

	public String getApenomAutor() {
		return apenomAutor;
	}

	public String getFechaNacAutor() {
		return fechaNacAutor;
	}

	public String getNacionalidadAutor() {
		return nacionalidadAutor;
	}

	public int getTelfAutor() {
		return telfAutor;
	}

	public String getMailAutor() {
		return mailAutor;
	}

	public String getBiografiaAutor() {
		return biografiaAutor;
	}

	public String getDestrezaAutor() {
		return destrezaAutor;
	}
	
	
	
	
}

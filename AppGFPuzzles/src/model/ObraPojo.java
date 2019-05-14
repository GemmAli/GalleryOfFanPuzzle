package model;

//modelo de los objetos Obra que corresponde a la tabla obras

public class ObraPojo {

	// *******ATRIBUTOS*********
	private String idObra;
	private String tituloObra;
	private String tipoObra;
	private String tamObra;
	private String matObra;
	private String descObra;
	private int pvpObra;
	private String idAutor; //no se si la usaremos, por si acaso
	
	// *******CONSTRUCTOR*********
	public ObraPojo(String idObra, String tituloObra, String tipoObra, String tamObra, String matObra, String descObra,
			int pvpObra, String idAutor) {
		super();
		this.idObra = idObra;
		this.tituloObra = tituloObra;
		this.tipoObra = tipoObra;
		this.tamObra = tamObra;
		this.matObra = matObra;
		this.descObra = descObra;
		this.pvpObra = pvpObra;
		this.idAutor = idAutor;
	}
	
	// *******METODOS DE ACCESO GET*********
	public String getIdObra() {
		return idObra;
	}

	public String getTituloObra() {
		return tituloObra;
	}

	public String getTipoObra() {
		return tipoObra;
	}

	public String getTamObra() {
		return tamObra;
	}

	public String getMatObra() {
		return matObra;
	}

	public String getDescObra() {
		return descObra;
	}

	public int getPvpObra() {
		return pvpObra;
	}

	public String getIdAutor() {
		return idAutor;
	}
	
	
	
}

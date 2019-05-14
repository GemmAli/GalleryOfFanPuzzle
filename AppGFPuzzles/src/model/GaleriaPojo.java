package model;

//modelo de los objetos Galeria que corresponde a la tabla galerias

public class GaleriaPojo {

	// *******ATRIBUTOS*********
	private String cifGal;
	private String nomGal;
	private String direcGal;
	private String telfGal;
	
	// *******CONSTRUCTOR*********
	public GaleriaPojo(String cifGal, String nomGal, String direcGal, String telfGal) {
		super();
		this.cifGal = cifGal;
		this.nomGal = nomGal;
		this.direcGal = direcGal;
		this.telfGal = telfGal;
	}

	// *******METODOS DE ACCESO GET*********
	public String getCifGal() {
		return cifGal;
	}

	public String getNomGal() {
		return nomGal;
	}

	public String getDirecGal() {
		return direcGal;
	}

	public String getTelfGal() {
		return telfGal;
	}
	
	
}

package model;

import java.util.Date;

//modelo de los objetos Venta que corresponde a la tabla ventas

public class VentaPojo {

	// *******ATRIBUTOS*********
	private int numAlbaran;
	private String idObra;
	private String idCli;
	private String idEmple;
	private Date fechaFact;
	private String cifGal;
	private int pvpObra;
	
	// *******CONSTRUCTOR*********
	public VentaPojo(int numAlbaran, String idObra, String idCli, String idEmple, Date fechaFact, String cifGal,
			int pvpObra) {
		super();
		this.numAlbaran = numAlbaran;
		this.idObra = idObra;
		this.idCli = idCli;
		this.idEmple = idEmple;
		this.fechaFact = fechaFact;
		this.cifGal = cifGal;
		this.pvpObra = pvpObra;
	}

	// *******METODOS DE ACCESO GET*********
	public int getNumAlbaran() {
		return numAlbaran;
	}

	public String getIdObra() {
		return idObra;
	}

	public String getIdCli() {
		return idCli;
	}

	public String getIdEmple() {
		return idEmple;
	}

	public Date getFechaFact() {
		return fechaFact;
	}

	public String getCifGal() {
		return cifGal;
	}

	public int getPvpObra() {
		return pvpObra;
	}

	
}

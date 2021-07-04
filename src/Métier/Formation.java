package Métier;
import java.util.Arrays;



import Métier.User;

public class Formation {
	private int id;
	private Integer numSemestre;
	private Double chargeHoraire;
	private String libelle;
	
	public Formation() {
		super();
	}
	
	public Formation(int numSemestre, Double chargeHoraire, String libelle) {
		super();
		this.numSemestre = numSemestre;
		this.chargeHoraire = chargeHoraire;
		this.libelle = libelle;
	}
	public Integer getNumSemestre() {
		return numSemestre;
	}
	public void setNumSemestre(Integer numSemestre) {
		this.numSemestre = numSemestre;
	}
	public Double getChargeHoraire() {
		return chargeHoraire;
	}
	public void setChargeHoraire(Double chargeHoraire) {
		this.chargeHoraire = chargeHoraire;
	}

	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}



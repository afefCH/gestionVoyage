package model;

public class Vol {
	private int numeroV;
	private String villeDest;
	private String villeDepart;
	private double prix;
	private int nbPlace;

	public Vol() {

	}

	public Vol(int numeroV, String villeDest, String villeDepart, double prix,
			int nbPlace) {
		super();
		this.numeroV = numeroV;
		this.villeDest = villeDest;
		this.villeDepart = villeDepart;
		this.prix = prix;
		this.nbPlace = nbPlace;
	}

	public int getNumeroV() {
		return numeroV;
	}

	public String getVilleDest() {
		return villeDest;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public double getPrix() {
		return prix;
	}

	public void setNumeroV(int n) {
		numeroV = n;
	}

	public void setVilleDest(String d) {
		villeDest = d;
	}

	public void setVilleDepart(String a) {
		villeDepart = a;
	}

	public void setPrix(double p) {
		prix = p;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public void affiche(int nombrePlaceReserve) {

		String vol = "|";
		vol += String.format("%-14s", numeroV) + "|";
		vol += String.format("%-14s", villeDepart) + "|";
		vol += String.format("%-19s", villeDest) + "|";
		vol += String.format("%-12s", prix) + "|";
		vol += String.format("%-19s", nbPlace) + "|";
		vol += String.format("%-26s", nbPlace - nombrePlaceReserve) + "|";

		System.out.println(vol);
	}
}

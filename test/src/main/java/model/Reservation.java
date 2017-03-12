package model;

import gestion.GestionDesVols;

public class Reservation {
	private Client client;
	private int numeroVol;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getNumeroVol() {
		return numeroVol;
	}

	public void setNumeroVol(int numeroVol) {
		this.numeroVol = numeroVol;
	}

	public void affiche() {
		
		GestionDesVols gestionDesVols = new GestionDesVols();
		Vol vol = gestionDesVols.getVol(numeroVol);
		
		String reservation ="|";
		reservation += String.format("%-18s", numeroVol)+"|";
		reservation += String.format("%-19s", client.getPrenom())+"|";
		reservation += String.format("%-22s", client.getPrenom())+"|";
		reservation += String.format("%-20s", vol.getVilleDepart()) + "|";
		reservation += String.format("%-19s", vol.getVilleDest())  + "|";
		reservation += String.format("%-12s", String.valueOf(vol.getPrix())) + "|";
		
		System.out.println(reservation);
		
	}

}

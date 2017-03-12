package gestion;

import java.util.Vector;

import console.ConsoleOutil;
import model.Vol;

public class GestionDesVols {
	private static Vector<Vol> vols = new Vector<Vol>();
	
	static {
		vols.add(new Vol(1, "SFAX", "PARIS", 500, 300));
		vols.add(new Vol(2, "SFAX", "MADRID", 250, 250));
	}

	public void creerVol() {
		
		boolean continuerLectureNumVol = true;
		
		Vol v1 = new Vol();
		ConsoleOutil console = new ConsoleOutil();
		int numVol;
		
		do{
			numVol = console.lire("Num Vol \t\t:", 1, 99999);
			
			if( !numeroVolNonUtilise(numVol) ){
				System.out.println("NUMERO VOL EXISTE DEJA !");
				continuerLectureNumVol = true;
			}else{
				continuerLectureNumVol = false;
			}
		}while(continuerLectureNumVol == true);
		
		
		String villeDepart = console.lire("Ville Depart \t:");
		String villeArrive = console.lire("Ville Arrivée \t: ");
		double prix = console.lire("Prix \t :", 0, 10000);
		int nombrePlace = console.lire("Nombre Place \t:", 1, 500);
		
		v1.setNumeroV(numVol);
		v1.setVilleDepart(villeDepart);
		v1.setVilleDest(villeArrive);
		v1.setPrix(prix);
		v1.setNbPlace(nombrePlace);
		
		vols.add(v1);
	}

	private boolean numeroVolNonUtilise(int numVol) {
		for(int i=0; i< vols.size(); i++){
			if( vols.get(i).getNumeroV() == numVol ){
				return false;
			}
		}
		
		return true;
	}

	public void creerVols() {
		System.out.println("\tCREATION VOLS\n");
		boolean continuerCreerVol = false;
		String decision;

		do {
			creerVol();
			ConsoleOutil console = new ConsoleOutil();
			decision = console.lire("ENCORE (o/n)");
			if (decision.equals("o") || decision.equals("O")) {
				continuerCreerVol = true;
			}else{
				continuerCreerVol = false;
			}
		} while (continuerCreerVol);
	}

	public void afficheVols() {
		GestionDesReservations gestionDesReservations = new GestionDesReservations();
		String enteteTableau = "";
		enteteTableau = " -------------------------------------------------------------------------------------------------------------\n";
		enteteTableau+= "|    Numero    |    Depart    |    Destination    |    Prix    |    Total Place    |    Nombre Place Dispo    |\n";
		enteteTableau+= "|--------------|--------------|-------------------|------------|-------------------|--------------------------|";
		System.out.println(enteteTableau);
		
		for (int i = 0; i < vols.size(); i++) {
			int nombrePlaceReserve = gestionDesReservations.getNombrePlaceReserves(vols.elementAt(i).getNumeroV());
			
			vols.elementAt(i).affiche(nombrePlaceReserve);
		}
	}

	public Vol getVol(int numeroVol) {
		for(int i=0; i< vols.size(); i++){
			if( vols.get(i).getNumeroV() == numeroVol ){
				return vols.get(i);
			}
		}
		
		return null;
	}

}

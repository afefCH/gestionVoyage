package gestion;

import java.util.Vector;

import console.ConsoleOutil;
import model.Client;
import model.Reservation;
import model.Vol;

public class GestionDesReservations {
	private static Vector<Reservation> reservations = new Vector<Reservation>() ;

	public GestionDesReservations() {
	}

	public void creeReservation() {

		GestionDesVols gestionDesVols = new GestionDesVols();
		boolean continuerCreationReservation = false;
		Reservation r1 = new Reservation();
		ConsoleOutil console = new ConsoleOutil();
		int numVol;

		do {

			numVol = console.lire("Num Vol \t\t:", 1, 99999);

			Vol vol = gestionDesVols.getVol(numVol);

			if (vol == null) {
				System.out.println("VOL INCONNU REASSAYEZ !");
				continuerCreationReservation = true;
			} else {
				
				int nombrePlaceReserve = getNombrePlaceReserves(numVol);
				
				if(nombrePlaceReserve == vol.getNbPlace()){
					System.out.println("IL N'Y A PLUS DE PLACES LIBRE SUR CE VOL.");
					return;
				}
				
				continuerCreationReservation = false;
			}

		} while (continuerCreationReservation);

		String nom = console.lire("Nom \t:");
		String prenom = console.lire("Prénom \t: ");
		String numeroPassport = console.lire("Num Passport \t :");

		Client client = new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setNumeroPassort(numeroPassport);

		r1.setClient(client);
		r1.setNumeroVol(numVol);

		reservations.add(r1);
	}

	public void creerReservations() {
		System.out.println("\tCREATION RESERVATION\n");
		boolean continuerCreerReservation = false;
		String decision;

		do {
			creeReservation();
			ConsoleOutil console = new ConsoleOutil();
			decision = console.lire("ENCORE (o/n)");
			if (decision.equals("o") || decision.equals("O")) {
				continuerCreerReservation = true;
			} else {
				continuerCreerReservation = false;
			}
		} while (continuerCreerReservation);
	}

	public void afficheReservations() {
		String enteteTableau = "";
		enteteTableau = " -------------------------------------------------------------------------------------------------------------------\n";
		enteteTableau += "|    Numero Vol    |        Nom        |        Prenom        |    Ville Depart    |    Destination    |    Prix    |\n";
		enteteTableau += "|------------------|-------------------|----------------------|--------------------|-------------------|------------|";
		System.out.println(enteteTableau);

		if (reservations.size() == 0) {
			System.out.println("VIDE...");
		}

		for (int i = 0; i < reservations.size(); i++) {
			reservations.elementAt(i).affiche();
		}
	}

	public int getNombrePlaceReserves(int numeroVol) {
		int total = 0;
		for (int i = 0; i < reservations.size(); i++) {
			if (reservations.get(i).getNumeroVol() == numeroVol)
				total = total + 1;
		}

		return total;
	}
}

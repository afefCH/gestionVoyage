package gestion;

import console.ConsoleOutil;

public class GestionAgenceVoyage 
{
	
	public static String getMenuPrincipale()
	{
		String menu = "";
		menu += "\tGESTION AGENCE VOYAGE\n";
		menu += "\t\t AFFICHER VOLS \t\t\t\t\t 1 \n";
		menu += "\t\t CREER UN VOLS \t\t\t\t\t 2 \n";
		menu += "\t\t AFFICHER RESERVATION \t\t\t\t 3 \n";
		menu += "\t\t CREER RESERVATION \t\t\t\t 4 \n";
		menu += "\t\t QUITTER \t\t\t\t\t 0 \n";
		menu += "\t\t\t\t VOTRE CHOIX : ";
		
		return menu;
	}
	
	public static void main(String[] args) {
		int tache=-1;
		ConsoleOutil consoleOutil= new ConsoleOutil();
		GestionDesVols gestionDesVols = new GestionDesVols();
		GestionDesReservations gestionDesReservations = new GestionDesReservations();
		
		while(tache!=0){
			String menuPrincipal = getMenuPrincipale();
			tache=consoleOutil.lire(menuPrincipal, 0, 4);
			
			switch (tache)
			{
				case 1:
					gestionDesVols.afficheVols();
					break;
				case 2:
					gestionDesVols.creerVols();
					break;
				case 3:
					gestionDesReservations.afficheReservations();
					break;
				case 4:
					gestionDesReservations.creeReservation();
					break;
				default:
					System.out.println("FIN DU PROGRAMME!");
			}
		}
	}
}



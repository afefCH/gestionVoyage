package console;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleOutil {
	public int lire(String msg, int min, int max) {
		int nombre = 0;
		boolean valide = false;
		System.out.print(msg);

		while (!valide) {
			try {
				Scanner sc = new Scanner(System.in);
				nombre = sc.nextInt();

				if (nombre >= min && nombre <= max) {
					valide = true;
				}else{
					System.out.println("VALEUR N'EST PAS DANS L'INTERVALLE ["+min+"-"+max+"]");
				}
			} catch (InputMismatchException e) {
				System.out.println("VALEUR SAISIE NON NUMERIQUE , REASSAYEZ :");
				valide = false;
			}
		}
		return nombre;
	}
	
	public double lire(String msg, double min, double max) {
		double nombre = 0;
		boolean valide = false;
		System.out.print(msg);

		while (!valide) {
			try {
				Scanner sc = new Scanner(System.in);
				nombre = sc.nextDouble();

				if (nombre >= min && nombre <= max) {
					valide = true;
				}else{
					System.out.println("VALEUR N'EST PAS DANS L'INTERVALLE ["+min+"-"+max+"]");
				}
			} catch (InputMismatchException e) {
				System.out.println("VALEUR SAISIE NON NUMERIQUE , REASSAYEZ :");
				valide = false;
			}
		}
		return nombre;
	}

	public String lire(String message) {
		String saisie;
		System.out.print(message);
		Scanner sc = new Scanner(System.in);
		saisie = sc.nextLine();

		return saisie;
	}
}

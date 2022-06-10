package demo001.simgame;

import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

public class BusinessSimulation001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Wirtschaftssimulation Programmierung II");

		//Niederlassung niederlassungEinbeck = new Niederlassung("Einbeck", Warenart.BIER, 10, 2);
		//Niederlassung niederlassungWien = new Niederlassung("Wien", Warenart.WEIN, 10, 2);

		Lager lagerAugsburg = new Lager("Augsburg", 5, 1);

		Scanner myScanner = new Scanner(System.in);

		int gesamterloes = 0;
		
		ArrayList<Niederlassung> listeNiederlassung = new ArrayList<Niederlassung>();
	    
		listeNiederlassung.add(new Niederlassung("Einbeck", Warenart.BIER, 10, 2));
	    listeNiederlassung.add(new Niederlassung("Wien", Warenart.WEIN, 10, 2));
	    listeNiederlassung.add(new Niederlassung("Nordhausen", Warenart.KORN,7,2));
	    
		while (true) {

			System.out.println("Soll produziert werden? [j/n]");
			String userInput = myScanner.nextLine();

			if (userInput.equals("j")) {
				
				for(int i = 0; i < listeNiederlassung.size();i++) {
					listeNiederlassung.get(i).anfordern();
					listeNiederlassung.get(i).produzieren();
				}
				/*niederlassungEinbeck.anfordern();
				niederlassungWien.anfordern();

				niederlassungEinbeck.produzieren();
				niederlassungWien.produzieren();*/
			}

			for(int j = 0; j < listeNiederlassung.size(); j++) {
				int produzierteMenge = listeNiederlassung.get(j).abholen();
				
				Warenart produzierteWarenart = listeNiederlassung.get(j).getWarenart();
				
				System.out.println("Ort: " + listeNiederlassung.get(j).getOrt() + "\tWare: "
						+ listeNiederlassung.get(j).getWarenartString() + "\tMenge: " + produzierteMenge);
				
				lagerAugsburg.einlagern(produzierteWarenart, produzierteMenge);
			}
			
			
			/*int produzierteMengeEinbeck = niederlassungEinbeck.abholen();
			int produzierteMengeWien = niederlassungWien.abholen();

			Warenart produzierteWarenart = niederlassungEinbeck.getWarenart();
			Warenart produzierteWarenartWien = niederlassungWien.getWarenart();

			System.out.println("Ort: " + niederlassungEinbeck.getOrt() + "\tWare: "
					+ niederlassungEinbeck.getWarenartString() + "\tMenge: " + produzierteMengeEinbeck);

			System.out.println("Ort: " + niederlassungWien.getOrt() + "\tWare: " + niederlassungWien.getWarenartString()
					+ "\tMenge: " + produzierteMengeWien);

			lagerAugsburg.einlagern(produzierteWarenart, produzierteMengeEinbeck);
			lagerAugsburg.einlagern(produzierteWarenartWien, produzierteMengeWien);
*/
			System.out.println("Aktueller Bestand im Lager:");
			for (Iterator<Warenart> warenartIterator = lagerAugsburg.getEingelagerteWaren().iterator(); warenartIterator
					.hasNext();) {
				Warenart warenart = (Warenart) warenartIterator.next();
				System.out.println(Util.convertWarenartToString(warenart) + ": " + lagerAugsburg.getBestand(warenart));
			}

			int preis = 10;
			int GesErl = 0;
			
			for (Iterator<Warenart> warenartIterator = lagerAugsburg.getEingelagerteWaren().iterator(); warenartIterator
					.hasNext();) {
				Warenart warenart = (Warenart) warenartIterator.next();
				//System.out.println(Util.convertWarenartToString(warenart) + ": " + lagerAugsburg.getBestand(warenart));
				
				System.out.println(
						"Wie viel "+Util.convertWarenartToString(warenart) +" soll verkauft werden? [0.." + lagerAugsburg.getBestand(warenart) + "]");
				
				int mengeZuVerkaufend = Integer.parseInt(myScanner.nextLine());
			
				int erloes = lagerAugsburg.verkaufen(warenart, mengeZuVerkaufend, preis);
				GesErl = GesErl + erloes;
				
				System.out.println("Erloes durch Verkauf von " +Util.convertWarenartToString(warenart) + ": " + erloes);
				}
			
			/*System.out.println(
					"Wie viel Bier soll verkauft werden? [0.." + lagerAugsburg.getBestand(Warenart.BIER) + "]");
			int mengeZuVerkaufendenBieres = Integer.parseInt(myScanner.nextLine());

			System.out.println(
					"Wie viel Wein soll verkauft werden? [0.." + lagerAugsburg.getBestand(Warenart.WEIN) + "]");
			int mengeZuVerkaufendenWeines = Integer.parseInt(myScanner.nextLine());

			int erloesBier = lagerAugsburg.verkaufen(produzierteWarenart, mengeZuVerkaufendenBieres, preis);
			int erloesWein = lagerAugsburg.verkaufen(produzierteWarenartWien, mengeZuVerkaufendenWeines, preis);
			*/
			
			int MitarbeiterKosten = 0;
			
			for(int l = 0; l < listeNiederlassung.size(); l++) {
				
				MitarbeiterKosten = MitarbeiterKosten + listeNiederlassung.get(l).getGesamtlohn();
				}
			
			//int MAKEinbeck = niederlassungEinbeck.getGesamtlohn();
			//int MAKWien = niederlassungWien.getGesamtlohn();
			
			int MAKAugsburg = lagerAugsburg.getGesamtlohn();

			gesamterloes += GesErl - (MitarbeiterKosten + MAKAugsburg);

			
			//gesamterloes += erloesBier + erloesWein - (MAKEinbeck + MAKWien + MAKAugsburg);

			
			
			//System.out.println("Erloes durch Verkauf von Bier: " + erloesBier);
			//System.out.println("Erloes durch Verkauf von Wein: " + erloesWein);
			System.out.println("Kosten durch Loehne: " + (MitarbeiterKosten + MAKAugsburg));
			System.out.println("Gesamterloes: " + gesamterloes);

			System.out.println("Aktueller Bestand im Lager:");
			for (Iterator<Warenart> warenartIterator = lagerAugsburg.getEingelagerteWaren().iterator(); warenartIterator
					.hasNext();) {
				Warenart warenart = (Warenart) warenartIterator.next();
				System.out.println(Util.convertWarenartToString(warenart) + ": " + lagerAugsburg.getBestand(warenart));
			}
			
			
			for (int n = 0; n < listeNiederlassung.size(); n++) {
				
				System.out.println("aktuelle Mitarbeiter in "+ listeNiederlassung.get(n).getOrt() +  ":" + listeNiederlassung.get(n).getAnzahlArbeiter());
				
				System.out.println("Soll die Mitarbeiteranzahl angepasst werden?");
				
				String userInput2 = myScanner.nextLine();

					if (userInput2.equals("j")) {		
					
					System.out.println("Einstellen oder Entlassen");
					String userInput3 = myScanner.nextLine();
					
					if (userInput3.equals("Einstellen")) {
					System.out.println("neue Mitarbeiter: ");
					int neueMitarbeiter = Integer.parseInt(myScanner.nextLine());
					listeNiederlassung.get(n).ArbeiterEinstellen(neueMitarbeiter);
					
					}
					
					else {
						
						System.out.println("zu entlassende Mitarbeiter : [0..." + listeNiederlassung.get(n).getAnzahlArbeiter() + "]");
						int freigesetzteMitarbeiter = Integer.parseInt(myScanner.nextLine());
						
						listeNiederlassung.get(n).arbeiterEntlassen(freigesetzteMitarbeiter);
					
			}
		//	System.out.println("aktuelle Mitarbeiter in Einbeck:" + niederlassungEinbeck.getAnzahlArbeiter());
		//	System.out.println("aktuelle Mitarbeiter in Wien:" + niederlassungWien.getAnzahlArbeiter());
			
			/*System.out.println("Soll die Mitarbeiteranzahl angepasst werden?");
			
			String userInput2 = myScanner.nextLine();

			if (userInput2.equals("j")) {		
					
					System.out.println("Einstellen oder Entlassen");
					String userInput3 = myScanner.nextLine();
					
					if (userInput3.equals("Einstellen")) {
						
						System.out.println("neue Mitarbeiter in Einbeck: ");
						int neueMitarbeiterEinbeck = Integer.parseInt(myScanner.nextLine());
						
						System.out.println("neue Mitarbeiter in Wien: ");
						int neueMitarbeiterWien = Integer.parseInt(myScanner.nextLine());
						
						niederlassungEinbeck.ArbeiterEinstellen(neueMitarbeiterEinbeck);
						niederlassungWien.ArbeiterEinstellen(neueMitarbeiterWien);
					}
					
					else {
						
						System.out.println("zu entlassende Mitarbeiter in Einbeck: [0..." + niederlassungEinbeck.getAnzahlArbeiter() + "]");
						int freigesetzteMitarbeiterEinbeck = Integer.parseInt(myScanner.nextLine());
						System.out.println("zu entlassende Mitarbeiter in Wien: [0..." + niederlassungWien.getAnzahlArbeiter() + "]");
						int freigesetzteMitarbeiterWien = Integer.parseInt(myScanner.nextLine());	
						
						niederlassungEinbeck.arbeiterEntlassen(freigesetzteMitarbeiterEinbeck);
						niederlassungWien.arbeiterEntlassen(freigesetzteMitarbeiterWien);
					}*/
			}		
		  }		
	   }
	}
}

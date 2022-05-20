package demo001.simgame;

import java.util.Iterator;
import java.util.Scanner;

public class BusinessSimulation001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Wirtschaftssimulation Programmierung II");

		Niederlassung niederlassungEinbeck = new Niederlassung("Einbeck", Warenart.BIER, 1);
		Niederlassung niederlassungWien = new Niederlassung("Wien", Warenart.WEIN, 1);

		Lager lagerAugsburg = new Lager("Augsburg", 5);

		Scanner myScanner = new Scanner(System.in);
		
		int gesamterloes = 0;
		
		while(true) {
			
			System.out.println("Soll produziert werden? [j/n]");
			String userInput = myScanner.nextLine();
			
			if(userInput.equals("j")) {
			
				niederlassungEinbeck.anfordern();
				niederlassungWien.anfordern();

				niederlassungEinbeck.produzieren();
				niederlassungWien.produzieren();
				
			}

			

			int produzierteMengeEinbeck = niederlassungEinbeck.abholen();
			int produzierteMengeWien = niederlassungWien.abholen();

			Warenart produzierteWarenart = niederlassungEinbeck.getWarenart();
			Warenart produzierteWarenartWien = niederlassungWien.getWarenart();

			System.out.println("Ort: "+niederlassungEinbeck.getOrt()+"\tWare: "
					+niederlassungEinbeck.getWarenartString()+"\tMenge: "+produzierteMengeEinbeck);

			System.out.println("Ort: "+niederlassungWien.getOrt()+"\tWare: "
					+niederlassungWien.getWarenartString()+"\tMenge: "+produzierteMengeWien);


			lagerAugsburg.einlagern(produzierteWarenart, produzierteMengeEinbeck);
			lagerAugsburg.einlagern(produzierteWarenartWien, produzierteMengeWien);

			System.out.println("Aktueller Bestand im Lager:");
			for (Iterator<Warenart> warenartIterator = lagerAugsburg.getEingelagerteWaren().iterator(); warenartIterator.hasNext();) {
				Warenart warenart = (Warenart) warenartIterator.next();
				System.out.println(Util.convertWarenartToString(warenart)+": "+lagerAugsburg.getBestand(warenart));
			}

			int preis = 10;

			System.out.println("Wie viel Bier soll verkauft werden? [0.." + lagerAugsburg.getBestand(Warenart.BIER) + "]");
			int mengeZuVerkaufendenBieres = Integer.parseInt(myScanner.nextLine());
			
						
			System.out.println("Wie viel Wein soll verkauft werden? [0.." + lagerAugsburg.getBestand(Warenart.WEIN) + "]");
			int mengeZuVerkaufendenWeines = Integer.parseInt(myScanner.nextLine());
			
			int erloesBier = lagerAugsburg.verkaufen(produzierteWarenart, mengeZuVerkaufendenBieres, preis);
			int erloesWein = lagerAugsburg.verkaufen(produzierteWarenartWien, mengeZuVerkaufendenWeines, preis);

			gesamterloes += erloesBier + erloesWein;
			
			System.out.println("Erloes durch Verkauf von Bier: "+erloesBier);
			System.out.println("Erloes durch Verkauf von Wein: "+erloesWein);
			System.out.println("Gesamterloes: "+gesamterloes);
			
			System.out.println("Aktueller Bestand im Lager:");
			for (Iterator<Warenart> warenartIterator = lagerAugsburg.getEingelagerteWaren().iterator(); warenartIterator.hasNext();) {
				Warenart warenart = (Warenart) warenartIterator.next();
				System.out.println(Util.convertWarenartToString(warenart)+": "+lagerAugsburg.getBestand(warenart));
			}


		}




	}



}
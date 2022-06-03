package demo001;

import java.util.*;

public class Raum {

	private int raumnummer;
	private int raumgroesse;
	private int belegung = 0;
	private Gebaeude gebaeude;

	public Raum(int raumnummer, Gebaeude gebaeude) {

		this.raumnummer = raumnummer;
		this.gebaeude = gebaeude;
	}

	public String RaumBelegen(int RNR) {

		String a = "Der Raum wurde von Ihnen erfolgreich belegt";
		String b = "Der Raum war bereits belegt";
		if (this.belegung == 0) {
			this.belegung++;
			return a;
		} else {
			return b;
		}
	}

	public String RaumFreigeben(int RNR) {

		String c = "Der Raum wurde nun freigegeben";
		String d = "Der Raum war nicht belegt";

		if (this.belegung > 0) {
			this.belegung--;
			return c;
		} else {
			return d;
		}
	}

	public void raumnummerAendern(int neueRaumnummer) {

		this.raumnummer = neueRaumnummer;
	}

	public void gebaeudeZuweisen(Gebaeude zugewiesenesGebaeude) {

		this.gebaeude = zugewiesenesGebaeude;
	}
}

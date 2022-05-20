package demo001;

import java.util.ArrayList;

public class VerwaltungGebaeude {
			
	public static void main(String[] args) {
		
		Gebaeude g1 = new Gebaeude("Postplatz 1", 10);
		Gebaeude g2 = new Gebaeude("Hauptstrasse 13", 5);
	
		Raum r1 = new Raum(1, g1);
		Raum r2 = new Raum(2, g2);
		Raum r3 = new Raum(3, g1);
		
		r1.raumnummerAendern(101);
		r2.gebaeudeZuweisen(g1);
	
		g1.raumHinzufuegen(r1);
	}
}

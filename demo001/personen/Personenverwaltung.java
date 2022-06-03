package demo001.personen;

import java.time.LocalDate;

public class Personenverwaltung {

	public static void main(String[] args) {
		
		Person b1 = new Besucher(801, "Meier", "Erich", (LocalDate.of(2022, 06, 01)));
		Person b2 = new Besucher(802, "Heine", "Maik", (LocalDate.of(2022, 05, 03)));
		
		Person ma1 = new Mitarbeiter(101, "Schulze", "Max", "Mathematik/Informatik");
		Person ma2 = new Mitarbeiter(102, "Mayer", "Uwe", "Design");
		
		Person st1 = new Student(301, "Mustermann", "Max", "042-021-1");		
		Person st2 = new Student(302, "Graupe", "Ralf", "042-019-3");		
		
	}	
	
	
}

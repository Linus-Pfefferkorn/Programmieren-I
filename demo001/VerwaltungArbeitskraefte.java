package demo001;

public class VerwaltungArbeitskraefte {

	public static void main(String[] args) {

		Arbeitskraft a1 = new Arbeitskraft("001", "Müller", 1000);
		Arbeitskraft a2 = new Arbeitskraft("002", "Schulz", 1000);

		Fuehrungskraft f1 = new Fuehrungskraft(101, "Leiter-Forschung", 4500);

		a1.versetzeInAbteilung("Entwicklung");
		a2.versetzeInAbteilung("Vertrieb");

		System.out.println(a1.druckeAusweis());
		System.out.println(a2.druckeAusweis());

		f1.arbeitskraftUnterstellen(a1);
		f1.einerabteilungZuweisen("Entwicklung");
	}

}

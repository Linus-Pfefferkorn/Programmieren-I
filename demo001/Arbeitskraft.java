package demo001;

public class Arbeitskraft {

	private String personalnr;
	private String name;
	private int gehalt;
	private String abteilung;
	private Fuehrungskraft leiter;

	public Arbeitskraft(String nr, String name, int gehalt) {

		this.personalnr = nr;
		this.name = name;
		this.gehalt = gehalt;
	}

	public void erhoeheGehalt(int gehaltserhoehung) {

		this.gehalt = this.gehalt + gehaltserhoehung;
	}

	public void versetzeInAbteilung(String neueAbteilung) {

		this.abteilung = neueAbteilung;
	}

	public String druckeAusweis() {

		String ausgabeString = this.personalnr + ", " + this.name + ", " + this.abteilung;
		return ausgabeString;
	}

	public void leiterZuweisen(Fuehrungskraft chef) {

		this.leiter = chef;
	}

}

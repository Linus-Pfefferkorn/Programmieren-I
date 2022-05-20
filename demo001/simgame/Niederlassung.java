package demo001.simgame;

public class Niederlassung extends Arbeitsstelle {

	/**
	 * Ort, an dem die Niederlassung steht
	 */
	//private String ort; --> bereits in Oberklasse
	
	/**
	 * Warenart, die in der Produktion hergestellt wird
	 */
	private Warenart warenartProduktion;
	
	/**
	 * Anzahl der Arbeitenden, die in der Produktion arbeiten
	 */
	//private int arbeitende; --> bereits in Oberklasse
	
	/**
	 * Gibt an, ob die Produktion ausgeloest wurde (true) oder nicht (false)
	 */
	private boolean produktionAngefordert;
	
	/**
	 * Anzahl der Einheiten der Warenart, die nach der Produktion zur Abholung bereit stehen.
	 */
	private int produzierteMenge=0;
	
	/**
	 * interner Parameter, der angibt, wieviele Einheiten der Ware pro Arbeitender produziert werden koennen 
	 */
	private int faktorArbeiterZuMenge=10;
	
	/**
	 * Konstruktor
	 * @param ort 		Ort, in dem sich die Niederlassung befinden soll
	 * @param warenart	die Warenart, welche in der Niederlassung produziert werden soll
	 * @param arbeitende	die Anzahl der Arbeiter, die bei Beginn in dieser Niederlassung angestellt sind
	 */
	public Niederlassung(String ort, Warenart warenart, int arbeitende) {
		super(ort, arbeitende);
		this.warenartProduktion=warenart;
	}

	/**
	 * Mit dieser Methode wird die Produktion der Warenart in der Niederlassung angefordert.
	 * Anschliessend muss mit der Methode produzieren() die Produktion ausgeloest werden. 
	 */
	public void anfordern() {
		this.produktionAngefordert=true;
	}
	
	/**
	 * Diese Methode loest die Produktion aus. Es wird allerdings nur dann Ware produziert, wenn
	 * vorher auch mit der Methode anfordern() die Produktion ausgeloest wurde. Ansonsten
	 * wird nichts produziert.
	 * Die Menge der produzierten Ware ist von der Anzahl der vorhandenen Arbeiter abhaengig. 
	 * Ausserdem unterliegt die Produktion einer zufaelligen Schwankung.
	 */
	public void produzieren() {
		int zufaelligeSchwankungInProzent = (int)Math.round( Math.random() * 60.0)-30;
		if(this.produktionAngefordert) {
			this.produzierteMenge=this.getAnzahlArbeiter() * this.faktorArbeiterZuMenge * (100-zufaelligeSchwankungInProzent)/100;
		} else {
			this.produzierteMenge=0;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int abholen() {
		int mengeAuslieferung = this.produzierteMenge;
		this.produzierteMenge=0;
		this.produktionAngefordert=false;
		return mengeAuslieferung;
	}
	
	/**
	 * Es koennen Arbeitende eingestellt werden.
	 * 
	 * @param anzahlEinzustellende Anzahl der neu einzustellenden Arbeitenden
	 */
	//public void einstellen(int anzahlEinzustellende) {
	//	this.arbeitende=this.arbeitende+anzahlEinzustellende;
	//}

	/**
	 * Es koennen Arbeitende entlassen werden.
	 * 
	 * @param anzahlEinzustellende Anzahl der neu einzustellenden Arbeitenden
	 */
	//public void entlassen(int anzahlZuentlassender) {
	//	this.ArbeiterEinstellen() = this.getAnzahlArbeiter - anzahlZuentlassender;
	//}

	
	/**
	 * Jede Niederlassung steht in einem Ort. Die Methode gibt den Ort der Niederlassung zurueck.
	 * @return Ort, in dem die Niederlassung steht.
	 */
	//public String getOrt() {
	//	return ort;
	//}
	
	/**
	 * In der Klasse ist die Warenart gespeichert. Methode gibt die Warenart vom Datentyp Warenart zurueck.
	 * @return Warenart vom Datentyp Warenart
	 */
	public Warenart getWarenart() {
		return this.warenartProduktion;
	}
	
	/**
	 * In der Klasse ist die Warenart gespeichert. Methode gibt den passenden String der Warenart zurueck.
	 * @return String der Warenart
	 */
	public String getWarenartString() {
		return Util.convertWarenartToString(this.warenartProduktion);
	}
	
}
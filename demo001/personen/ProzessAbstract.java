package demo001.personen;

public abstract class ProzessAbstract {
	public void process() {
        einVerarbeitungsschritt();
        aktion();
        weitererSchritt();
    }

    public void einVerarbeitungsschritt() {
        // Implementierung hier in Oberklasse
    	// hier ist Realisierung schon bekannt
    }

    // wird in Unterklasse implementiert, weil
    // hier die Realisierung nicht bekannt ist
    public abstract void aktion();

    public void weitererSchritt() {
        // Implementierung hier in Oberklasse
    	// hier ist Realisierung schon bekannt
    }
}
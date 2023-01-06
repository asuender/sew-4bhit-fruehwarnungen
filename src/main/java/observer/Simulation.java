package observer;

/**
 * Simuliert einen Ablauf der am Observer-Pattern beteiligten Klassen
 * @author Lisa Vittori
 *
 */
public class Simulation {
	public static void main(String[] args) {
		Fruehwarnungen fws = new Fruehwarnungen();
		Benachrichtigung b1 = new Benachrichtigung("bbeispiel");
		Benachrichtigung b2 = new Benachrichtigung("mmuster");
		
		// Registrieren des 1. Benachrichtigungsservice (b1)
		fws.attach("bbeispiel", b1);
		fws.addFruehwarnung("bbeispiel", "D"); // eine Benachrichtigung sollte automatisch geschickt werden
		fws.addFruehwarnung("mmuster", "RK"); // keine Benachrichtigung
		
		// Registrieren des 2. Benachrichtigungsservice (b2)
		fws.attach("mmuster", b2);
		fws.addFruehwarnung("bbeispiel", "AM"); // eine Benachrichtigung sollte automatisch geschickt werden
		fws.addFruehwarnung("mmuster", "BSPK"); // eine Benachrichtigung sollte automatisch geschickt werden
		fws.deleteFruehwarnung("bbeispiel", "AM"); // eine Benachrichtigung sollte automatisch geschickt werden
		fws.deleteFruehwarnung("mmuster", "BSPK"); // eine Benachrichtigung sollte automatisch geschickt werden
		
	  	// Abmelden des 1. Benachrichtigungsservice (b1)
		fws.detach("bbeispiel");
		fws.deleteFruehwarnung("bbeispiel", "D"); // keine Benachrichtigung
		fws.deleteFruehwarnung("mmuster", "RK"); // eine Benachrichtigung sollte automatisch geschickt werden
		
	  	//Abmelden des 2. Benachrichtigungsservice (b2)
		fws.detach("mmuster");
		fws.addFruehwarnung("bbeispiel", "E"); // keine Benachrichtigung
		fws.addFruehwarnung("mmuster", "NW2"); // keine Benachrichtigung

	}

}

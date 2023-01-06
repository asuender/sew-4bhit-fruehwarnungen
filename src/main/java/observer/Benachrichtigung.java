package observer;

/**
 * Eine einfache Benachrichtigung, die mittels Konsolenausgabe simuliert wird.
 * @author Lisa Vittori
 * @version 2021-02-22
 */
public class Benachrichtigung implements Observer {
	private String login;

	/**
	 * Erstellt eine neue Benachrichtigung für den angegebenen Benutzer
	 * @param login Der Login-Name als eindeutige Kennzeichnung des Benutzers/der Benutzerin
	 */
	public Benachrichtigung(String login) {
		super();
		this.login = login;
	}
	
	/**
	 * "Simuliert" den Versand einer Nachricht durch Konsolenausgabe
	 * @param gegenstand Der Gegenstand für den eine Benachrichtigung erfolgt
	 * @param stat Die Status-Information der Änderung
	 */
	@Override
	public void sendeNachricht(String gegenstand, StatusInformation stat) {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Sende Email an " + this.login + "@student.tgm.ac.at");
		System.out.println("Es wurde eine Frühwarnung im Gegenstand " + gegenstand + " " + 
				stat.getText());
		System.out.println("--------------------------------------------------------------------------");
	}
}

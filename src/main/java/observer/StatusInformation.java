package observer;

/**
 * Dient zur Mitteilung, welche Änderung stattgefunden hat.
 * @author Lisa Vittori
 * @version 2021-02-22
 */
public enum StatusInformation {
	DELETED("gelöscht"),
	ADDED("hinzugefügt");
	
	private String text;
	
	private StatusInformation(String text) {
		this.text = text;
	}
	
	/**
	 * Liefert einen zur Status-Information passenden Text, der für
	 * eine Ausgabe verwendet werden kann
	 * @return Ausgabetext zur Status-Information
	 */
	public String getText() {
		return this.text;
	}
}

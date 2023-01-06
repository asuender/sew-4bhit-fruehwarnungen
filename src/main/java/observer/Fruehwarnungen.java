package observer;

import java.util.*;
/**
 * Verwaltet eine Liste an Frühwarnungen. Jede Frühwarnung wird zum betreffenden Login-
 * Namen gespeichert, wobei es auch möglich ist, einem Login-Namen mehrere Frühwarnungen
 * zuzuornden.
 * 
 * @author Lisa Vittori
 * @version 2021-02-22
 */
public class Fruehwarnungen extends Subject {
	private Map<String, Set<String>> fw;
	
	/**
	 * Erstellt ein neues leeres Objekt zur Verwaltung von Frühwarnungen
	 */
	public Fruehwarnungen() {
		super();
		fw = new HashMap<>();
	}
	
	/**
	 * Fügt eine neue Frühwarnung zum angegebenen Login-Namen hinzu.
	 * @param login Der Login-Name als eindeutige Kennzeichnung des Schülers/der Schülerin
	 * @param gegenstand Der entsprechende Gegenstand zur Frühwarnung
	 * @return true, wenn die Frühwarnung neu angelegt wurde; false, falls die Frühwarnung
	 * 		bereits im System gespeichert war.
	 */
	public boolean addFruehwarnung(String login, String gegenstand) {
		Set<String> s = fw.get(login);

		if(s == null) {
			s = new TreeSet<String>();
			fw.put(login, s);
		}

		if (s.add(gegenstand)) {
			super.notifyObservers(login, gegenstand, StatusInformation.ADDED);
			return true;
		}

		return false;
	}
	
	/**
	 * Löscht die Frühwarnung des übergebenen Gegenstandes zum angegebenen Login-Namen.
	 * @param login Der Login-Name als eindeutige Kennzeichnung des Schülers/der Schülerin
	 * @param gegenstand Der entsprechende Gegenstand zur Frühwarnung
	 * @return true, wenn die Frühwarnung gelöscht wurde; false, falls die Frühwarnung
	 * 		nicht im System gespeichert war.
	 */
	public boolean deleteFruehwarnung(String login, String gegenstand) {
		Set<String> s = fw.get(login);
		if(s == null) {
			return false;
		}
		boolean result = s.remove(gegenstand);

		if (result) {
			super.notifyObservers(login, gegenstand, StatusInformation.DELETED);
		}

		if(s.size()== 0) {
			fw.remove(login);
		}
		return result;
	}
	
	/**
	 * Liefert die zu einem Schüler gespeicherten Frühwarnungen als Kopie
	 * @param login als eindeutige Kennzeichnung des Schülers/der Schülerin
	 * @return eine Kopie der intern gespeicherten Frühwarnungen bzw. null, wenn keine
	 * 	Frühwarnungen zu dem angegebenen Login gespeichert sind.
	 */
	public Set<String> getFruehwarnungen(String login) {
		Set<String> s = fw.get(login);
		if(s == null)
			return null;
		return new TreeSet<>(s);
	}
}

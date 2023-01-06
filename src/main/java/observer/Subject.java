package observer;

import java.util.Map;
import java.util.HashMap;

/**
 * @author Andreas Suender
 * @version 12-22-2022
 */
public abstract class Subject {
    private Map<String, Observer> observers;

    public Subject() {
        this.observers = new HashMap<>();
    }

    public void attach(String login, Observer o) {
        this.observers.put(login, o);
    }

    public void detach(String login) {
        this.observers.remove(login);
    }

    public void notifyObservers(String login, String gegenstand, StatusInformation stat) {
        Observer o = this.observers.get(login);

        if (o != null) {
            o.sendeNachricht(gegenstand, stat);
        }
    }
}

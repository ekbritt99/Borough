package main.java.interfaces;

/**
 * Interface which defines how subjects interact with observers
 * @author Ethan Brittain
 *
 */
public interface Subject {
	public void registerObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObservers(String notification);
}

package main.java.accounts;
import java.util.ArrayList;
import main.java.interfaces.*;
import main.java.listings.Listing;

/**
 * Class which allows student account to link to make roommate groups
 * @author Ethan Brittain
 *
 */
public class RoommateGroup implements Subject{
	private String internalID;
	private ArrayList<String> memberIDs;
	private ArrayList<String> watchListIDs;
	private ArrayList<Observer> observers;
	
	public RoommateGroup(String internalID) {
		
		this.internalID = internalID;
		memberIDs = new ArrayList<String>();
		watchListIDs = new ArrayList<String>();
		observers = new ArrayList<Observer>();
	}
	
	/**
	 * Adds a roommate to the group
	 * 
	 * @param student The student to be added to the group
	 */
	public void addRoommate(Student student) {
		
		memberIDs.add(student.getInternalId());
	}
	
	/**
	 * Removes student from the group
	 * 
	 * @param student Student to be removed from group
	 */
	public void removeRoomate(Student student) {
		
		memberIDs.remove(student.getInternalId());
	}
	
	/**
	 * Adds listing to group
	 * 
	 * @param listing Listing to be added by internal id
	 */
	public void addListing(Listing listing) {
		watchListIDs.add(listing.getInternalId());
	}
	
	/**
	 * Removes listing from the group
	 * 
	 * @param listing Listing to be removed by internal id
	 */
	public void removeListing(Listing listing) {
		watchListIDs.remove(listing.getInternalId());
	}
	
	/**
	 * Adds a an observer
	 * 
	 * @param observer Account to watch this group
	 */
	public void registerObserver(Observer observer) {
		if (!observers.contains(observer)) {
		      observers.add(observer);
		    }
	}
	
	/**
	 * Removes an observer
	 * 
	 * @param observer Account to no longer watch this group
	 */
	public void removeObserver(Observer observer) {
		if (observers.contains(observer)) {
		      observers.remove(observer);
		    }
	}
	
	/**
	 * Notify all observers of any notification due to changes
	 * 
	 * @param notifications String message to alert observers of new info/changes
	 */
	public void notifyObservers(String notifications) {
		for (Observer observer : observers) {
		      observer.update(notifications);
		    }
	}
	
	/**
	 * Returns a string with info summarizing the group
	 */
	public String toString() {
		//Form a single string from all students in the group using their toString
		String memberNames = "";
		for (Observer student : observers) {
			memberNames += student.toString() + "\n";
		}
		return memberNames;
	}
}

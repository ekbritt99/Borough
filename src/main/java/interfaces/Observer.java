package main.java.interfaces;

import java.util.ArrayList;

/**
 * Interface which defines how observers "watch" subjects (listings,accounts) and are notified of their changes and updates
 * @author Ethan Brittain
 *
 */
public interface Observer {
	public void update(String notification);
	public ArrayList<String> getNotifications();
}

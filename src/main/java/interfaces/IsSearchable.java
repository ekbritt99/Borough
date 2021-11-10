package main.java.interfaces;

/**
 * Interface which defines how accounts and listings can be searched for 
 * @author Ethan Brittain
 *
 */
public interface IsSearchable {
	public int getWeight(String metadata);
}

package main.java.database;

import java.util.ArrayList;
import java.util.Iterator;
import main.java.listings.Listing;

/**
 * Parses JSON data on initialization and holds a list of all Listings
 *
 * <p>Operates as a singleton, only one instance exists, so use method getInstance() to obtain it
 *
 * @author Elijah Burke
 */
public class Listings implements Iterable<Saveable> {

  private static ArrayList<Saveable> listings;
  private static Listings listingsInstance;

  /**
   * Listings is a singleton, therefore the constructor is private Use getInstance() to get the
   * single instance
   */
  private Listings() {

    listings = new ArrayList<Saveable>();
  }

  /**
   * Returns THE instance of the list of listings
   *
   * @return the instance of Listings
   */
  public static Listings getInstance() {

    // Actually create the listings list if it does not exist already
    if (listingsInstance == null) {

      listingsInstance = new Listings();
    }

    return listingsInstance;
  }

  /**
   * Adds a new listing to the list of listings found in Listings
   *
   * <p>Listings with null value will be skipped
   *
   * @param listing the Listing to be added
   */
  public void addListing(Listing listing) {

    if (listing != null) {

      listings.add(listing);
    }
  }

  /**
   * Removes a listing from the list of listings in Listings
   *
   * <p>Listings with null value will be skipped
   *
   * @param listing the Listing to be removed
   */
  public void removeListing(Listing listing) {

    if (listing != null) {

      listings.remove(listing);
    }
  }

  /**
   * Retrieves the Listing at the specified index
   *
   * @param index location of the Listing to retrieve
   * @return the instance of Listing at the specified index
   */
  public static Listing getListing(int index) {

    return (Listing) listings.get(index);
  }

  /**
   * Returns an int that is the size of the ArrayList of listings contained within this class
   *
   * @return size of the list of listings
   */
  public static int size() {

    return listings.size();
  }

  @Override
  /**
   * Implementation of Iterable, returns the iterator
   *
   * @return a Listing Iterator
   */
  public Iterator<Saveable> iterator() {

    return listings.iterator();
  }
}

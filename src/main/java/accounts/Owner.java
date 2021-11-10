package main.java.accounts;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import main.java.database.Listings;
import main.java.interfaces.HasReviews;
import main.java.interfaces.IsSearchable;
import main.java.interfaces.Observer;
import main.java.listings.Listing;
import java.util.Iterator;
import main.java.database.*;

/**
 * Owner of a property, can post and edit listings and review previous tenants
 *
 * @author Elijah Burke
 */
public class Owner extends Account implements IsSearchable, HasReviews, Observer {

  private String internalId;
  private String name;
  private String manager;
  private String email;
  private ArrayList<String> listingIds;
  private ArrayList<String> notifications;
  private ArrayList<Listing> listings;
  private ArrayList<Review> reviews;

  /**
   * Creates a new owner from its unique ID, name, manager, and the lists of its listings' and
   * reviews' IDs
   *
   * @param internalId the unique ID of this owner
   * @param name the name of this owner, could be an individual or a company
   * @param manager the manager of this owner's properties, could be the same as name
   * @param listingIds the list of this owner's listings' IDs
   * @param reviewIds the list of this owner's reviews' IDs
   */
  public Owner(
      String internalId,
      String name,
      String manager,
      String email,
      ArrayList<String> listingIds,
      ArrayList<String> notifications) {

    super(internalId, name, name);
    this.setInternalId(internalId);
    this.setName(name);
    this.setManager(manager);
    this.setEmail(email);
    this.setListingIds(listingIds);
    this.setNotifications(notifications);
  }

  /** Initialize listings by retrieving from the database listings that match the listing IDs */
  public void initializeListings() {
	  listings = new ArrayList<Listing>();
	  Listings listingsToStore = Listings.getInstance();
	  Iterator<Saveable> listingIterator = listingsToStore.iterator();
	
	  int counter = 0;
	  while (listingIterator.hasNext()) {
		  Listing currentListing = listingsToStore.getListing(counter);
		  for (int i = 0; i < listingIds.size(); i++) {
			  
			  if (currentListing.getInternalId() == listingIds.get(i)) {
				  
				  listings.add(currentListing);
			  }
		  }
		  counter++;
		  listingIterator.next();
	  }
	  
  }

  /** Initialize reviews by retrieving from the database reviews that match the review IDs */
  public void addReview(Review review) {
	  if (review != null) {
		  reviews.add(review);
	  }
  }

  /**
   * Retrieves this Owner's internal ID
   *
   * @return this Owner's unique ID
   */
  public String getInternalId() {

    return this.internalId;
  }

  /**
   * Retrieves this Owner's name
   *
   * @return this Owner's name
   */
  public String getName() {
	  
	  return this.name;
  }
 

  /**
   * Retrieves this Owner's manager
   *
   * @return this Owner's manager
   */
  public String getManager() {

    return this.manager;
  }

  
  public String getEmail() {
	  return this.email;
  }
  
  /**
   * Retrieves this Owner's listings' IDs
   * 
   * @return ArrayList of ID Strings
   */
  public ArrayList<String> getListingIds() {
	  
	  return this.listingIds;
  }
  
  /**
   * Retrieves the Listings owned by this Ower
   *
   * @return the ArrayList of Listings owned by this
   */
  public ArrayList<Listing> getListings() {

    return this.listings;
  }

  /**
   * Sets the unique ID of this Owner
   *
   * <p>TODO perhaps this should be private?
   *
   * @param internalId the String to become this Owner's unique ID
   */
  public void setInternalId(String internalId) {

    if (internalId.isEmpty()) {

      /**
       * If Owner ID is ever an empty String, a NullPointerException will be thrown when the
       * listings are loaded in from the JSON file. I believe this is because the JSON parser we're
       * using stores empty Strings as "null" in the .json file. TODO this fix is fine for now, but
       * I want to make it safer in the future.
       */
      this.internalId = " ";
    } else {

      this.internalId = internalId;
    }
  }

  /**
   * Sets the name of this Owner
   *
   * @param name the String to become this Owner's name
   */
  public void setName(String name) {

    if (name.isEmpty()) {

      System.out.println("Owner name must not be empty");
      /**
       * If Owner name is ever an empty String, a NullPointerException will be thrown when the
       * listings are loaded in from the JSON file. I believe this is because the JSON parser we're
       * using stores empty Strings as "null" in the .json file. TODO this fix is fine for now, but
       * I want to make it safer in the future.
       */
      this.name = " ";
    } else {

      this.name = name;
    }
  }

  /**
   * Sets the manager of this Owner
   *
   * @param manager the String to become this Owner's manager
   */
  public void setManager(String manager) {

    if (manager.isEmpty()) {

      System.out.println("Manager must not be empty");
      /**
       * If Owner manager is ever an empty String, a NullPointerException will be thrown when the
       * listings are loaded in from the JSON file. I believe this is because the JSON parser we're
       * using stores empty Strings as "null" in the .json file. TODO this fix is fine for now, but
       * I want to make it safer in the future.
       */
      this.manager = " ";
    } else {

      this.manager = manager;
    }
  }
  
  public void setEmail(String email) {
	  if (email.isEmpty()) {
		  System.out.println("Email must not be empty");
		  this.email = " ";
	  } else {
		  this.email = email;
	  }
  }

  /**
   * Sets the list of Listing IDs of this Owner
   *
   * @param listingIds the ArrayList of Strings to become this Owner's listing IDs
   */
  public void setListingIds(ArrayList<String> listingIds) {

    this.listingIds = listingIds;
  }
  
  /**
   * Sets the list of notifications
   * 
   * @param notifications an ArrayList of notification Strings
   */
  public void setNotifications(ArrayList<String> notifications) {
	  
	  this.notifications = notifications;
  }

  @Override
  /**
   * Updates this Observer from its Subject
   *
   * @param notification the String notification provided by the Subject
   */
  public void update(String notification) {
	  notifications.add(notification);
  }

  @Override
  /**
   * Retrieves all notifications as a String
   *
   * @return a String containing all current notifications
   */
  public ArrayList<String> getNotifications() {

    return notifications;
  }

  @Override
  /**
   * Retrieves all Reviews as a String
   *
   * @return a String containing all Reviews
   */
  public String getReviews() {

    return reviews.toString();
  }

  @Override
  /**
   * Returns the weight of this Owner compared to the metadata passed in from a search
   *
   * @return weight of this Owner in the search
   */
  public int getWeight(String metadata) {

    return 0;
  }

  /**
   * Returns a String representation of this Owner
   *
   * @return a String representation of this Owner
   */
  public String toString() {
	String formattedString = "Owner Name: " + this.name + "\n" + "Listings: ";
	for (Listing listing : listings) {
		formattedString += listing.getName() + "\n";
	}
	return formattedString;
  }

  /**
   * Determines if two Owners are equal
   *
   * @param owner the Owner to compare the calling instance to
   * @return true if the Owners are equal
   * @return false if the Owners are not equal
   */
  public boolean equals(Owner owner) {

    return (this.name == owner.getFirstName() && this.manager == owner.getManager());
  }
  
  @Override
  /**
   * Converts this to a JSONObject
   *
   * @return a JSONObject representation of this
   */
  public JSONObject toJSONObject() {

    JSONObject ownerJSON = new JSONObject();
    // Assign class members to JSON entries
    ownerJSON.put("internalId", this.getInternalId());
    ownerJSON.put("name", this.getName());
    ownerJSON.put("manager", this.getManager());
    ownerJSON.put("email", this.getEmail());

    // Convert ArrayList of listing IDs to a JSONArray and add to the final object
    JSONArray jsonListingIds = new JSONArray();
    if(this.getListingIds() != null) {
    jsonListingIds.addAll(this.getListingIds());
    }
    ownerJSON.put("listingIds", jsonListingIds);

    // Convert ArrayList of notifications to a JSONArray and add to the final object
    JSONArray jsonNotifications = new JSONArray();
    if(this.getNotifications() != null) {
    jsonNotifications.addAll(this.getNotifications());
    }
    ownerJSON.put("notifications", jsonNotifications);

    return ownerJSON;
  }

public void addReview(String author, String review) {
		Review addReview = new Review(author, review);
		reviews.add(addReview);
}
}

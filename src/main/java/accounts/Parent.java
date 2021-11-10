package main.java.accounts;

import java.util.ArrayList;
import main.java.interfaces.Observer;
import main.java.listings.Listing;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Parent of one or more students
 *
 * @author Elijah Burke
 */
public class Parent extends Account implements Observer {

  private String internalId;
  private String firstName;
  private String lastName;
  private String dateOfBirth;
  private String address;
  private String phoneNumber;
  private String email;
  private ArrayList<String> childrenIds;
  private ArrayList<String> watchListIds;
  private ArrayList<String> notifications;
  private ArrayList<Student> children;
  private ArrayList<Listing> watchList;

  /**
   * Creates a new parent from its unique ID, first name, last name, date of birth, address, phone
   * number, email, and lists of its children's and watchlist's IDs
   *
   * @param internalId the unique ID of this Parent
   * @param firstName the first name of this Parent
   * @param lastName the last name of this Parent
   * @param dateOfBirth this Parent's date of birth
   * @param address this Parent's address
   * @param phoneNumber this Parent's phone number
   * @param childrenIds the IDs of this Parent's children
   * @param watchListIds the IDs of this Parent's watchlist
   */
  public Parent(
      String internalId,
      String firstName,
      String lastName,
      String dateOfBirth,
      String address,
      String phoneNumber,
      String email,
      ArrayList<String> childrenIds,
      ArrayList<String> watchListIds,
      ArrayList<String> notifications) {

    super(internalId, firstName, lastName);
    this.setInternalId(internalId);
    this.setFirstName(firstName);
    this.setLastName(lastName);
    this.setDateOfBirth(dateOfBirth);
    this.setAddress(address);
    this.setPhoneNumber(phoneNumber);
    this.setEmail(email);
    this.setChildrenIds(childrenIds);
    this.setWatchListIds(watchListIds);
    this.setNotifications(notifications);
  }

  /**
   * Retrieves this Parent's internal ID
   *
   * @return this Parent's unique ID
   */
  public String getInternalId() {

    return this.internalId;
  }

  /**
   * Retrieves this Parent's first name
   *
   * @return this Parent's first name
   */
  public String getFirstName() {

    return this.firstName;
  }

  /**
   * Retrieves this Parent's last name
   *
   * @return this Parent's last name
   */
  public String getLastName() {

    return this.lastName;
  }

  /**
   * Retrieve's this Parent's date of birth
   *
   * @return this Parent's date of birth
   */
  public String getDateOfBirth() {

    return this.dateOfBirth;
  }

  /**
   * Retrieves this Parent's address
   *
   * @return this Parent's address
   */
  public String getAddress() {

    return this.address;
  }

  /**
   * Retrieve's this Parent's phone number
   *
   * @return this Parent's phone number
   */
  public String getPhoneNumber() {

    return this.phoneNumber;
  }

  /**
   * Retrieves this Parent's email
   *
   * @return this Parent's email
   */
  public String getEmail() {

    return this.email;
  }
  
  /**
   * Retrieves this Parent's children's IDs
   * 
   * @return an ArrayList of ID Strings
   */
  public ArrayList<String> getChildrenIds() {
	  
	  return this.childrenIds;
  }
  
  public ArrayList<String> getWatchListIds() {
	  
	  return this.watchListIds;
  }

  /**
   * Returns a list of this Parent's children
   *
   * @return an ArrayList of Students
   */
  public ArrayList<Student> getChildren() {

    return this.children;
  }

  /**
   * Returns a list of this Parent's watched listings
   *
   * @return an ArrayList of Listings
   */
  public ArrayList<Listing> getWatchList() {

    return this.watchList;
  }

  /**
   * Sets the unique ID of this Parent
   *
   * <p>TODO perhaps this should be private?
   *
   * @param internalId the String to become this Parent's unique ID
   */
  public void setInternalId(String internalId) {

    if (internalId.isEmpty()) {

      /**
       * For why this line is here, @see Faq, Fee, or anything else that loads Strings in from a
       * JSON file
       */
      this.internalId = " ";
    } else {

      this.internalId = internalId;
    }
  }

  /**
   * Sets the first name of this Parent
   *
   * @param firstName the String to become this Parent's first name
   */
  public void setFirstName(String firstName) {

    if (firstName.isEmpty()) {

      System.out.println("Parent first name must not be empty");
      /**
       * For why this line is here, @see Faq, Fee, or anything else that loads Strings in from a
       * JSON file
       */
      this.firstName = " ";
    } else {

      this.firstName = firstName;
    }
  }

  /**
   * Sets the last name of this Parent
   *
   * @param lastName the String to become this Parent's last name
   */
  public void setLastName(String lastName) {

    if (lastName.isEmpty()) {

      System.out.println("Parent last name must not be empty");
      /**
       * For why this line is here, @see Faq, Fee, or anything else that loads Strings in from a
       * JSON file
       */
      this.lastName = " ";
    } else {

      this.lastName = lastName;
    }
  }

  /**
   * Sets the date of birth of this Parent
   *
   * @param dateOfBirth the String to become this Parent's date of birth
   */
  public void setDateOfBirth(String dateOfBirth) {

    if (dateOfBirth.isEmpty()) {

      System.out.println("Parent date of birth must not be empty");
      /**
       * For why this line is here, @see Faq, Fee, or anything else that loads Strings in from a
       * JSON file
       */
      this.dateOfBirth = " ";
    } else {

      this.dateOfBirth = dateOfBirth;
    }
  }

  /**
   * Sets the address of this Parent
   *
   * @param address the String to become this Parent's address
   */
  public void setAddress(String address) {

    if (address.isEmpty()) {

      System.out.println("Parent address must not be empty");
      /**
       * For why this line is here, @see Faq, Fee, or anything else that loads Strings in from a
       * JSON file
       */
      this.address = " ";
    } else {

      this.address = address;
    }
  }

  /**
   * Sets the phone number of this Parent
   *
   * @param phoneNumber the String to become this Parent's phone number
   */
  public void setPhoneNumber(String phoneNumber) {

    if (phoneNumber.isEmpty()) {

      System.out.println("Parent phone number must not be empty");
      /**
       * For why this line is here, @see Faq, Fee, or anything else that loads Strings in from a
       * JSON file
       */
      this.phoneNumber = " ";
    } else {

      this.phoneNumber = phoneNumber;
    }
  }

  /**
   * Sets the email of this Parent
   *
   * @param email the String to become this Parent's email
   */
  public void setEmail(String email) {

    if (email.isEmpty()) {

      System.out.println("Parent email must not be empty");
      /**
       * For why this line is here, @see Faq, Fee, or anything else that loads Strings in from a
       * JSON file
       */
      this.email = " ";
    } else {

      this.email = email;
    }
  }

  /**
   * Sets the list of this Parent's children's IDs
   *
   * @param childrenIds the ArrayList of Strings holding the children's IDs
   */
  public void setChildrenIds(ArrayList<String> childrenIds) {

    this.childrenIds = childrenIds;
  }

  /**
   * Sets the list of this Parent's listing watchlist IDs
   *
   * @param watchListIds the ArrayList of Strings holding the listing's IDs
   */
  public void setWatchListIds(ArrayList<String> watchListIds) {

    this.watchListIds = watchListIds;
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
	  this.notifications = new ArrayList<String>();
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

  /**
   * Returns a String representation of this Parent
   *
   * @return a String representing this Parent
   */
  public String toString() {

    String sentence = "Parent Name: "+this.firstName+" "+this.lastName+" Parent ID: "+this.internalId+"\n"+
    		"DOB: "+this.dateOfBirth+"\n"+
    		"Phone Number: "+this.phoneNumber+"\n"+
    		"Email: "+this.email;
    return sentence;
  }

  /**
   * Determines if two parents are equal
   *
   * @param parent the Parent to compare the calling instance to
   * @return true if the Parents are equal
   * @return false if the Parents are not equal
   */
  public boolean equals(Parent parent) {

    return true;
  }

  @Override
  /**
   * Converts this to a JSONObject
   *
   * @return a JSONObject representation of this
   */
  public JSONObject toJSONObject() {

    JSONObject parentJSON = new JSONObject();
    // Assign class members to JSON entries
    parentJSON.put("internalId", this.getInternalId());
    parentJSON.put("firstName", this.getFirstName());
    parentJSON.put("lastName", this.getLastName());
    parentJSON.put("dateOfBirth", this.getDateOfBirth());
    parentJSON.put("address", this.getAddress());
    parentJSON.put("phoneNumber", this.getPhoneNumber());
    parentJSON.put("email", this.getEmail());

    // Convert ArrayList of children IDs to a JSONArray and add to the final object
    JSONArray jsonChildrenIds = new JSONArray();
    if(this.getChildrenIds() != null) {
    jsonChildrenIds.addAll(this.getChildrenIds());
    }
    parentJSON.put("childrenIds", jsonChildrenIds);

    // Convert ArrayList of watchlist IDs to a JSONArray and add to the final object
    JSONArray jsonWatchListIds = new JSONArray();
    if(this.getWatchListIds() != null) {
    jsonWatchListIds.addAll(this.getWatchListIds());
    }
    parentJSON.put("watchListIds", jsonWatchListIds);

    // Convert ArrayList of notifications to a JSONArray and add to the final object
    JSONArray jsonNotifications = new JSONArray();
    if(this.getNotifications() != null) {
    jsonNotifications.addAll(this.getNotifications());
    }
    parentJSON.put("notifications", jsonNotifications);

    return parentJSON;
  }

public String presentable() {
		// TODO Auto-generated method stub
		return null;
}
}

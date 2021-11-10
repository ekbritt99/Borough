package main.java.accounts;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import main.java.interfaces.HasReviews;
import main.java.interfaces.IsSearchable;
import main.java.interfaces.Observer;
import main.java.interfaces.Subject;
import main.java.listings.Listing;

public class Student extends Account implements IsSearchable, HasReviews, Observer, Subject {

  private String dateOfBirth;
  private String address;
  private String phoneNumber;
  private String email;
  private ArrayList<String> parentIds;
  private ArrayList<String> watchListIds;
  private String roommateGroupId;
  private ArrayList<String> notifications;
  private ArrayList<Parent> parents; // TODO can this double as a list of Observers?
  private ArrayList<Listing> watchList;
  private ArrayList<Observer> observers;
  private ArrayList<Review> reviews;
  // private RoommateGrouop roommateGroup;

  /**
   * Creates a new Student from its unique ID, first name, last name, date of birth, address, phone
   * number, email, lists of parents' and watchlist IDs, and its roommate group ID
   *
   * @param internalId the unique ID of this Student
   * @param firstName the first name of this Student
   * @param lastName the last name of this Student
   * @param dateOfBirth this Student's date of birth
   * @param address this Student's address
   * @param phoneNumber this Student's phone number
   * @param email this Student's email
   * @param parentIds the IDs of this Student's Parents
   * @param watchListIds the IDs of the listings in this Student's watchlist
   * @param roommateGroupId the ID of this Student's roommate group
   */
  public Student(
      String internalId,
      String firstName,
      String lastName,
      String dateOfBirth,
      String address,
      String phoneNumber,
      String email,
      ArrayList<String> parentIds,
      ArrayList<String> watchListIds,
      String roommateGroupId,
      ArrayList<String> notifications) {

    super(internalId, firstName, lastName);
    this.setInternalId(internalId);
    this.setDateOfBirth(dateOfBirth);
    this.setAddress(address);
    this.setPhoneNumber(phoneNumber);
    this.setEmail(email);
    this.setParnetIds(parentIds);
    this.setWatchListIds(watchListIds);
    this.setRoommateGroupId(roommateGroupId);
    this.setNotifications(notifications);
  }

  /**
   * Retrieves this Student's internal ID
   *
   * @return this Student's unique ID
   */
  public String getInternalId() {

    return super.getInternalId();
  }

  /**
   * Retrieves this Student's first name
   *
   * @return this Student's first name
   */
  public String getFirstName() {

    return super.getFirstName();
  }

  /**
   * Retrieves this Student's last name
   *
   * @return this Student's last name
   */
  public String getLastName() {

    return super.getLastName();
  }

  /**
   * Retrieve's this Student's date of birth
   *
   * @return this Student's date of birth
   */
  public String getDateOfBirth() {

    return this.dateOfBirth;
  }

  /**
   * Retrieves this Student's address
   *
   * @return this Student's address
   */
  public String getAddress() {

    return this.address;
  }

  /**
   * Retrieve's this Student's phone number
   *
   * @return this Student's phone number
   */
  public String getPhoneNumber() {

    return this.phoneNumber;
  }

  /**
   * Retrieves this Student's email
   *
   * @return this Student's email
   */
  public String getEmail() {

    return this.email;
  }
  
  /**
   * Retrieves this Student's Parents' IDs
   * 
   * @return ArrayList of ID Strings
   */
  public ArrayList<String> getParentIds() {
	  
	  return this.parentIds;
  }
  
  /**
   * Retrieves this Student's watchlist IDs
   * 
   * @return
   */
  public ArrayList<String> getWatchListIds() {
	  
	  return this.watchListIds;
  }

  /**
   * Returns a list of this Sutdent's parents
   *
   * @return an ArrayList of Parents
   */
  public ArrayList<Parent> getParents() {

    return this.parents;
  }

  /**
   * Returns a list of this Student's watched listings
   *
   * @return an ArrayList of Listings
   */
  public ArrayList<Listing> getWatchList() {

    return this.watchList;
  }

  /**
   * Returns the ID of this Student's roommate group
   *
   * @return this Student's roommate group's unique ID
   */
  public String getRoommateGroupId() {

    return this.roommateGroupId;
  }

  /**
   * Sets the unique ID of this Student
   *
   * <p>TODO perhaps this should be private?
   *
   * @param internalId the String to become this Student's unique ID
   */
//  public void setInternalId(String internalId) {
//
//    if (internalId.isEmpty()) {
//
//      /**
//       * For why this line is here, @see Faq, Fee, or anything else that loads Strings in from a
//       * JSON file
//       */
//      this.internalId = " ";
//    }
//    else {
//      this.internalId = internalId;
//    }
//  }
//
//  /**
//   * Sets the first name of this Student
//   *
//   * @param firstName the String to become this Student's first name
//   */
//  public void setFirstName(String firstName) {
//
//    if (firstName.isEmpty()) {
//
//      System.out.println("Student first name must not be empty");
//      /**
//       * For why this line is here, @see Faq, Fee, or anything else that loads Strings in from a
//       * JSON file
//       */
//      this.firstName = " ";
//    }
//    else {
//      this.firstName = firstName;
//    }
//  }
//
//  /**
//   * Sets the last name of this Student
//   *
//   * @param lastName the String to become this Student's last name
//   */
//  public void setLastName(String lastName) {
//
//    if (lastName.isEmpty()) {
//
//      System.out.println("Student last name must not be empty");
//      /**
//       * For why this line is here, @see Faq, Fee, or anything else that loads Strings in from a
//       * JSON file
//       */
//      this.lastName = " ";
//    }
//    else {
//      this.lastName = lastName;
//    }
//  }

  /**
   * Sets the date of birth of this Student
   *
   * @param dateOfBirth the String to become this Student's date of birth
   */
  public void setDateOfBirth(String dateOfBirth) {

    if (dateOfBirth.isEmpty()) {

      System.out.println("Student date of birth must not be empty");
      /**
       * For why this line is here, @see Faq, Fee, or anything else that loads Strings in from a
       * JSON file
       */
      this.dateOfBirth = " ";
    }
    else {
      this.dateOfBirth = dateOfBirth;
    }
  }

  /**
   * Sets the address of this Student
   *
   * @param address the String to become this Student's address
   */
  public void setAddress(String address) {

    if (address.isEmpty()) {

      System.out.println("Student address must not be empty");
      /**
       * For why this line is here, @see Faq, Fee, or anything else that loads Strings in from a
       * JSON file
       */
      this.address = " ";
    }
    else {
      this.address = address;
    }
  }

  /**
   * Sets the phone number of this Student
   *
   * @param phoneNumber the String to become this Student's phone number
   */
  public void setPhoneNumber(String phoneNumber) {

    if (phoneNumber.isEmpty()) {

      System.out.println("Student phone number must not be empty");
      /**
       * For why this line is here, @see Faq, Fee, or anything else that loads Strings in from a
       * JSON file
       */
      this.phoneNumber = " ";
    }
    else {
      this.phoneNumber = phoneNumber;
    }
  }

  /**
   * Sets the email of this Student
   *
   * @param email the String to become this Student's email
   */
  public void setEmail(String email) {

    if (email.isEmpty()) {

      System.out.println("Student email must not be empty");
      /**
       * For why this line is here, @see Faq, Fee, or anything else that loads Strings in from a
       * JSON file
       */
      this.email = " ";
    }
    else {
      this.email = email;
    }
  }

  /**
   * Sets the list of this Student's parent's IDs
   *
   * @param parentIds the ArrayList of Strings holding the parent's IDs
   */
  public void setParnetIds(ArrayList<String> parentIds) {
  	    		this.parentIds = parentIds;
  }

  /**
   * Sets the list of this Student's listing watchlist IDs
   *
   * @param watchListIds the ArrayList of Strings holding the listing's IDs
   */
  public void setWatchListIds(ArrayList<String> watchListIds) {
  	    		this.watchListIds = watchListIds;
  }

  /**
   * Set this Student's roommate group's ID
   *
   * <p>TODO look into error handling, not every student has a roommate group
   *
   * @param roommateGroupId the String containing the group's ID
   */
  public void setRoommateGroupId(String roommateGroupId) {
  	    		this.roommateGroupId = roommateGroupId;
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
  /** Registers an Observer to this Student, is always a Parent */
  public void registerObserver(Observer observer) {
	  if (!observers.contains(observer)) {
	      observers.add(observer);
	    }
  }

  @Override
  /** Removes an Observer */
  public void removeObserver(Observer observer) {
	  if(observers.contains(observer))
      {
          observers.remove(observer);
      }
  }

  @Override
  /** Sends notifications to this Student's Observers (Parents) */
  public void notifyObservers(String notification) {
	  for(Observer observer : observers)
		{
			observer.update(notification);
		}
  }

  @Override
  /** Receives notifications from Subjects */
  public void update(String notification) {
	  notifications.add(notification);
  }

  @Override
  /** Retrieves all notifications as a String */
  public ArrayList<String> getNotifications() {
	  return notifications;
  }

  @Override
  /** Retrieves all of this Student's reviews as a String */
  public String getReviews() {
    return null;
  }

  @Override
  /**
   * Returns the weight of this Student compared to the metadata passed in from a search
   *
   * @return the weight of this Student in the search
   */
  public int getWeight(String metadata) {

    return 0;
  }

  /**
   * Returns a String representation of this Student
   *
   * @return a String representing this Student
   */
  public String toString() {

    return super.toString()//+"Student Name: "+super.firstName+" "+lastName+" Internal ID: "+this.internalId+"\n"+
    		+"DOB: "+this.dateOfBirth+"\n"+
    		"Phone Number: "+this.phoneNumber+"\n"+
    		"Email: "+this.email;
  }
 

  /**
   * Determines if two Students are equal
   *
   * @param student the Student to compare the calling instance to
   * @return true if the Students are equal
   * @reutnr false if hte Students are not equal
   */
  public boolean equals(Student student) {

    return true;
  }
  
  @Override
  /**
   * Converts this to a JSONObject
   *
   * @return a JSONObject representation of this
   */
  public JSONObject toJSONObject() {

    JSONObject studentJSON = new JSONObject();
    // Assign class members to JSON entries
    studentJSON.put("internalId", this.getInternalId());
    studentJSON.put("firstName", this.getFirstName());
    studentJSON.put("lastName", this.getLastName());
    studentJSON.put("dateOfBirth", this.getDateOfBirth());
    studentJSON.put("address", this.getAddress());
    studentJSON.put("phoneNumber", this.getPhoneNumber());
    studentJSON.put("email", this.getEmail());

    // Convert ArrayList of parent IDs to a JSONArray and add to the final object
    JSONArray jsonParentIds = new JSONArray();
    if(this.getParentIds() != null) {
    jsonParentIds.addAll(this.getParentIds());
    }
    studentJSON.put("parentIds", jsonParentIds);

    // Convert ArrayList of watchlist IDs to a JSONArray and add to the final object
    JSONArray jsonWatchListIds = new JSONArray();
    if(this.getWatchListIds() != null) {
    jsonWatchListIds.addAll(this.getWatchListIds());
    }
    studentJSON.put("watchListIds", this.getWatchListIds());

    studentJSON.put("roommateGroupId", this.getRoommateGroupId());

    // Convert ArrayList of notifications to a JSONArray and add to the final object
    JSONArray jsonNotifications = new JSONArray();
    if(this.getNotifications() != null) {
    jsonNotifications.addAll(this.getNotifications());
    }
    studentJSON.put("notifications", jsonNotifications);

    return studentJSON;
  }

public void addToWatchList(String listingId) {
		watchListIds.add(listingId);
}

public void removeFromWatchList(String listingId) {
		watchListIds.remove(listingId);
		
}

public void addReview(String author, String review) {
		Review addReview = new Review(author, review);
		reviews.add(addReview);
		
}

public String presentable() {
		String[] parts = this.address.split(",");
		String stateandzip = parts[1];
		String[] parts2 = stateandzip.split(" ");
		String state = parts[0];
		String firstPart = super.toString() //"Account ID: " + this.internalId + "\n"
						 //" Name: " + this.firstName + " " + this.lastName + "\n"
						+ " From: " + state + "\n"
						+ " Reviews: ";
		String review = "";
		if(reviews.toString() == null) {
				review = "None";
		} else {
				for(Review review1 : reviews) {
						review = review1.getDescription();
						firstPart = firstPart + review;
				}
		}
		return firstPart;
}
}

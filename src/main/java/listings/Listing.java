package main.java.listings;

import java.util.ArrayList;
import main.java.accounts.Review;
import main.java.database.Saveable;
import main.java.interfaces.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Listing implements Saveable, Subject {
  private String internalId;
  private String ownerId;
  private String name;
  private String description;
  private double rentPerMonth;
  private String phoneNumber;
  private String email;
  private String landlord;
  private String address;
  private String zip;
  private double damagesCost;
  private int availability;
  private ArrayList<Fee> additionalFees;
  private ArrayList<Faq> faq;
  private ArrayList<Review> reviews;
  private int numBedrooms;
  private double numBathrooms;
  private boolean washerDryer;
  private boolean petFriendly;
  private boolean pool;
  private boolean Walk2Campus;
  private boolean gym;
  private boolean freeWifi;
  private boolean furnished;
  private ArrayList<Observer> observers;

  public Listing(
      String internalId,
      String ownerId,
      String name,
      String description,
      double rentPerMonth,
      String phoneNumber,
      String email,
      String landlord,
      String address,
      String zip,
      double damagesCost,
      int availability,
      int numBedrooms,
      double numBathrooms,
      boolean washerDryer,
      boolean petFriendly,
      boolean pool,
      boolean Walk2Campus,
      boolean gym,
      boolean freeWifi,
      boolean furnished) {
    this.internalId = internalId;
    this.ownerId = ownerId;
    this.name = name;
    this.description = description;
    this.rentPerMonth = rentPerMonth;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.landlord = landlord;
    this.address = address;
    this.zip = zip;
    this.damagesCost = damagesCost;
    this.availability = availability;
    this.numBedrooms = numBedrooms;
    this.numBathrooms = numBathrooms;
    this.washerDryer = washerDryer;
    this.petFriendly = petFriendly;
    this.pool = pool;
    this.Walk2Campus = Walk2Campus;
    this.gym = gym;
    this.freeWifi = freeWifi;
    this.furnished = furnished;
    
    additionalFees = new ArrayList<Fee>();
    faq = new ArrayList<Faq>();
    reviews = new ArrayList<Review>();
  }

  /**
   * retrieves the internal ID
   *
   * @return ID as a String
   */
  public String getInternalId() {

    return this.internalId;
  }

  /**
   * retrieves the owner's internal ID
   *
   * @return owner's ID as a String
   */
  public String getOwnerId() {

    return this.ownerId;
  }

  /**
   * retrieves this listing's name
   *
   * @return name as a String
   */
  public String getName() {

    return this.name;
  }

  /**
   * retrieves this listing's description
   *
   * @return description as a String
   */
  public String getDescription() {

    return this.description;
  }

  /**
   * retrieves this listing's monthly rent
   *
   * @return monthly rent as a double
   */
  public double getRentPerMonth() {

    return this.rentPerMonth;
  }

  /**
   * retrieves this listing's contact phone number
   *
   * @return phone number as a String
   */
  public String getPhoneNumber() {

    return this.phoneNumber;
  }

  /**
   * retrieves this listing's contact email
   *
   * @return email as a String
   */
  public String getEmail() {

    return this.email;
  }
  
  /**
   * retrieves this listing's landlord
   * 
   * @return landlord as a String
   */
  public String getLandLord() {
	  
	  return this.landlord;
  }
  
  /**
   * retrieves this listing's address
   * 
   * @return address as a String
   */
  public String getAddress() {
	  
	  return this.address;
  }
  
  /**
   * retrieves this listing's zip code
   * 
   * @return zip as a String
   */
  public String getZipCode() {
	  
	  return this.zip;
  }
  
  /**
   * retrieves this listing's damages cost
   * 
   * @return damages cost as a double
   */
  public double getDamagesCost() {
	  
	  return this.damagesCost;
  }

  /**
   * retrieves this listing's additional fees
   *
   * @return fees as an ArrayList of Fee
   */
  public ArrayList<Fee> getFees() {

    return this.additionalFees;
  }

  /**
   * retrieves this listing's FAQ
   *
   * @return an ArrayList of Faqs
   */
  public ArrayList<Faq> getFaq() {

    return this.faq;
  }

  /**
   * Rtrieves this listing's reviews
   *
   * @return an ArrayList of Reviews
   */
  public ArrayList<Review> getReviews() {

    return this.reviews;
  }

  public int getNumBedrooms() {
    return this.numBedrooms;
  }

  public double getNumBathrooms() {
    return this.numBathrooms;
  }

  public boolean getWasherDryer() {
    return this.washerDryer;
  }

  public boolean getPetFriendly() {
    return this.petFriendly;
  }

  public boolean getPool() {
    return this.pool;
  }

  public boolean getWalk2Campus() {
    return this.Walk2Campus;
  }

  public boolean getGym() {
    return this.gym;
  }

  public boolean getFreeWifi() {
    return this.freeWifi;
  }

  public boolean getFurnished() {
    return this.furnished;
  }

  public void updateInternalID(String internalID) {
    this.internalId = internalID;
  }

  public void updateOwnerID(String ownerID) {
    this.ownerId = ownerID;
  }

  public void updateName(String name) {
    this.name = name;
  }

  public void updateDescription(String description) {
    this.description = description;
  }

  public void updateRent(double rent) {
    this.rentPerMonth = rent;
  }

  public void updatePhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void updateEmail(String email) {
    this.email = email;
  }

  public void addFee(String feeName, double feeCost) {
    additionalFees.add(new Fee(feeName, feeCost));
  }

  public void updateNumBedrooms(int numBedrooms) {
    if (numBedrooms > 0) {
      this.numBedrooms = numBedrooms;
    } else {
      this.numBedrooms = 0;
    }
  }

  public void numBathrooms(int numBathrooms) {
    this.numBathrooms = numBathrooms;
  }

  public void washerDryer(boolean washDryer) {
    this.washerDryer = washerDryer;
  }

  public void petFriendly(boolean petFriendly) {
    this.petFriendly = petFriendly;
  }

  public void pool(boolean pool) {
    this.pool = pool;
  }

  public void Walk2Campus(boolean Walk2Campus) {
    this.Walk2Campus = Walk2Campus;
  }

  public void gym(boolean gym) {
    this.gym = gym;
  }

  public void freeWifi(boolean freeWifi) {
    this.freeWifi = freeWifi;
  }

  public void furnished(boolean furnished) {
    this.furnished = furnished;
  }

  // listing will remove fee if it is taken down
  public void removeFee(String feeName) {
    // TODO implement
    additionalFees.remove(feeName);
  }

  public void addFaq(String faqQuestion, String faqAnswer) {
    faq.add(new Faq(faqQuestion, faqAnswer));
  }

  public void removeFaq(String faqName) {
    // TODO implement
    faq.remove(faqName);
  }

  /**
   * Adds a new review to this Listing
   *
   * @param author the String of the author's name
   * @param description the String of the review text
   */
  public void addReview(String author, String description) {

    reviews.add(new Review(author, description));
  }

  public void registerObserver(Observer observer) {
    if (!observers.contains(observer)) {
      observers.add(observer);
    }
  }

  public void removeObserver(Observer observer) {
    if (observers.contains(observer)) {
      observers.remove(observer);
    }
  }

  public void notifyObservers(String notification) {
    for (Observer observer : observers) {
      observer.update(notification);
    }
  }

  public String toString() {
    return 
        "\nName:\t"
        + this.getName()
        + "\nDescription:\t"
        + this.getDescription()
        + "\nMonthly Rent:\t"
        + this.getRentPerMonth()
        + "\nPhone Number:\t"
        + this.getPhoneNumber()
        + "\nEmail:\t"
        + this.getEmail()
        + "\nAdditional Fees:\t"
        + additionalFees.toString()
        + "\nFrequently Asked Questions:\t"
        + faq.toString()
        + "\n"
        + "\nBedrooms:\t" 
        + this.numBedrooms
        + "\nBathrooms:\t"
        + this.numBathrooms
        + "\nWasher and Dryer:\t"
        + this.washerDryer
        + "\nPet Friendly:\t" 
        + this.petFriendly
        + "\nPool:\t"
        + this.pool
        + "\nWalk2Campus:\t"
        + this.Walk2Campus
        + "\nGym:\t"
        + this.gym
        + "\nFree Wifi:\t"
        + this.freeWifi
        + "\nFurnished:\t"
        + this.furnished;
    
  }

  public boolean equals(Listing listing) {
    return false;
  }

  @Override
  /**
   * Converts this to a JSONObject
   *
   * @return a JSONObject representation of this
   */
  public JSONObject toJSONObject() {

    JSONObject listingJSON = new JSONObject();
    listingJSON.put("internalId", this.getInternalId());
    listingJSON.put("ownerId", this.getOwnerId());
    listingJSON.put("name", this.getName());
    listingJSON.put("description", this.getDescription());
    listingJSON.put("rentPerMonth", this.getRentPerMonth());
    listingJSON.put("phoneNumber", this.getPhoneNumber());
    listingJSON.put("email", this.getEmail());
    listingJSON.put("landlord", this.landlord);
    listingJSON.put("address", this.address);
    listingJSON.put("zip", this.zip);
    listingJSON.put("damagesCost", this.damagesCost);
    listingJSON.put("availability", this.availability);
    listingJSON.put("numBedrooms", this.getNumBedrooms());
    listingJSON.put("numBathrooms", this.getNumBathrooms());
    listingJSON.put("washerDryer", this.getWasherDryer());
    listingJSON.put("petFriendly", this.getPetFriendly());
    listingJSON.put("pool", this.getPool());
    listingJSON.put("walkToCampus", this.getWalk2Campus());
    listingJSON.put("gym", this.getGym());
    listingJSON.put("freeWifi", this.getFreeWifi());
    listingJSON.put("furnished", this.getFurnished());

    ArrayList<Fee> fees = this.getFees();
    ArrayList<Faq> faqs = this.getFaq();
    ArrayList<Review> reviews = this.getReviews();

    // Convert the ArrayList of fees into a JSONArray
    JSONArray jsonFees = new JSONArray();
    for (Fee fee : fees) {

      JSONObject jsonFee = new JSONObject();
      jsonFee.put("feeName", fee.getName());
      jsonFee.put("feeCost", fee.getCost());
      jsonFees.add(jsonFee);
    }
    // Add the fee array to the listingJSON
    listingJSON.put("fees", jsonFees);

    // Do it all again for the FAQ
    JSONArray jsonFaqs = new JSONArray();
    for (Faq faq : faqs) {

      JSONObject jsonFaq = new JSONObject();
      jsonFaq.put("faqQuestion", faq.getQuestion());
      jsonFaq.put("faqAnswer", faq.getAnswer());
      jsonFaqs.add(jsonFaq);
    }
    // Add the faq array to the listingJSON
    listingJSON.put("faqs", jsonFaqs);

    // Convert reviews to JSONArray
    JSONArray jsonReviews = new JSONArray();
    for (Review review : reviews) {

      JSONObject jsonReview = new JSONObject();
      jsonReview.put("author", review.getAuthor());
      jsonReview.put("description", review.getDescription());
      jsonReviews.add(jsonReview);
    }
    listingJSON.put("reviews", jsonReviews);

    // Finally, return the JSONObject representation of this listing
    return listingJSON;
  }
}

package main.java.database;

import main.java.listings.Listing;
import main.java.util.Constants;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * This class inherits from DataLoader, using its functionality to directly initialize the list of
 * listings, found in Listings
 *
 * <p>TODO Refactor to merge this and AccountLoader directly into DataLoader
 *
 * @author Elijah Burke
 */
public class ListingLoader extends DataLoader {

  /** Loads data from listings.json into the list of listings in class Listings */
  public static void load() {

    // Get JSONArray from listings.json
    JSONArray fileInput = DataLoader.load(Constants.LISTINGS_FILE);
    // Get the singleton instance of Listings
    Listings listings = Listings.getInstance();

    // Parsing the JSONArray
    for (int x = 0; x < fileInput.size(); ++x) {

      // Get a single item from the JSONArray as a JSONObject
      JSONObject listing = (JSONObject) fileInput.get(x);

      // Parse JSONObject data into data usable for the Listing constructor
      String internalId = (String) listing.get("internalId");
      String ownerId = (String) listing.get("ownerId");
      String name = (String) listing.get("name");
      String description = (String) listing.get("description");

      // numbers from JSON can only be parsed as an instance of Number, which has methods to convert
      // to primitive datatypes (the method doubleValue() is one)
      double rentPerMonth = ((Number) listing.get("rentPerMonth")).doubleValue();

      String phoneNumber = (String) listing.get("phoneNumber");
      String email = (String) listing.get("email");
      String landlord = (String) listing.get("landlord");
      String address = (String) listing.get("address");
      String zip = (String) listing.get("zip");
      double damagesCost = ((Number) listing.get("damagesCost")).doubleValue();
      int availability = ((Number) listing.get("availability")).intValue();

      int numBedrooms = ((Number) listing.get("numBedrooms")).intValue();
      double numBathrooms = ((Number) listing.get("numBathrooms")).doubleValue();
      boolean washerDryer = (boolean) listing.get("washerDryer");
      boolean petFriendly = (boolean) listing.get("petFriendly");
      boolean pool = (boolean) listing.get("pool");
      boolean walkToCampus = (boolean) listing.get("walkToCampus");
      boolean gym = (boolean) listing.get("gym");
      boolean freeWifi = (boolean) listing.get("freeWifi");
      boolean furnished = (boolean) listing.get("furnished");

      listings.addListing(
          new Listing(
              internalId,
              ownerId,
              name,
              description,
              rentPerMonth,
              phoneNumber,
              email,
              landlord,
              address,
              zip,
              damagesCost,
              availability,
              numBedrooms,
              numBathrooms,
              washerDryer,
              petFriendly,
              pool,
              walkToCampus,
              gym,
              freeWifi,
              furnished));

      // Faqs, Fees, and Reviews are JSONArrays themselves and must be parsed as such, and the
      // JSONObjects
      // within them parsed
      // Begin parsing fees here
      JSONArray fees = (JSONArray) listing.get("fees");

      for (int y = 0; y < fees.size(); ++y) {

        JSONObject fee = (JSONObject) fees.get(y);
        String feeName = (String) fee.get("feeName");
        double feeCost = ((Number) fee.get("feeCost")).doubleValue();

        // Add this fee to the Listing at position x
        listings.getListing(x).addFee(feeName, feeCost);
      }

      // Begin parsing faqs here
      JSONArray faqs = (JSONArray) listing.get("faqs");

      for (int y = 0; y < faqs.size(); ++y) {

        JSONObject faq = (JSONObject) faqs.get(y);
        String faqQuestion = (String) faq.get("faqQuestion");
        String faqAnswer = (String) faq.get("faqAnswer");

        // Add this faq to the listing at position x
        listings.getListing(x).addFaq(faqQuestion, faqAnswer);
      }

      // Begin parsing reviews here
      JSONArray reviews = (JSONArray) listing.get("faqs");

      for (int y = 0; y < reviews.size(); ++y) {

        JSONObject review = (JSONObject) reviews.get(y);
        String reviewAuthor = (String) review.get("author");
        String reviewDescription = (String) review.get("description");

        listings.getListing(x).addReview(reviewAuthor, reviewDescription);
      }
    }
  }
}

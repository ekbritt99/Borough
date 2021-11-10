package test.java.database_test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import main.java.database.DataLoader;
import main.java.database.DataWriter;
import main.java.database.Listings;
import main.java.listings.Listing;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;

/**
 * Test of ListingLoader class
 *
 * @author Elijah Burke
 */
class ListingLoaderTest {

  @AfterClass
  final void afterWrite() {

    DataWriter.save(null, TestConstants.TEST_LISTINGS_FILE);
  }

  @Test
  /** Tests whether or not the DataWriter can correctly write listings */
  final void testSaveListings() {
    // Introduce Listings singleton
    Listings listings = Listings.getInstance();

    // Create new listings and add them to Listings
    Listing listingOne =
        new Listing(
            "00-00000001",
            "11-00000001",
            "Cayce Cove",
            "Loud, falling apart, bad internet",
            534.0,
            "(803) 244-9541",
            "manager@caycecove.com",
            "Seymore Butz",
            "215 Spencer Place",
            "29033",
            500.0,
            7,
            1,
            1.0,
            true,
            true,
            true,
            true,
            false,
            false,
            false);
    Listing listingTwo =
        new Listing(
            "00-00000002",
            "11-00000002",
            "The Lofts at USC",
            "Our one-, two-, three-, and four- bedroom floor plans are the most unique in Columbia"
                + " blah blah blah",
            729.0,
            "(803) 937-4438",
            "\"The Lofts' Email Address\"",
            "Mr. Loft",
            "Main Street",
            "29402",
            500.0,
            4,
            1,
            1.0,
            true,
            true,
            false,
            false,
            false,
            true,
            false);
    Listing listingThree =
        new Listing(
            "00-00000003",
            "11-00000003",
            "Riverside",
            "RIVERSIDE is a high quality apartment community designed around University of South"
                + " Carolina students.",
            3.5,
            "(803) 772-2200",
            "none of the apartments have their email address on their webpage",
            "the guy",
            "the road",
            "the zip",
            1000.0,
            39,
            1,
            1.0,
            true,
            true,
            false,
            false,
            false,
            false,
            false);

    listings.addListing(listingOne);
    listings.addListing(listingTwo);
    listings.addListing(listingThree);

    DataWriter.save(listings, TestConstants.TEST_LISTINGS_FILE);
    assertEquals(listings, this.listingLoadTest(), "Listings are unchanged between write and read");
  }

  /**
   * This is copy-pasted from ListingLoader, since filename was not an argument in the original
   * method, which is my fault, sorry
   *
   * <p>other than refactoring, a big change is that Listings are loaded into a local ArrayList, not
   * the listing singleton; and this method now returns that ArrayList
   */
  public ArrayList<Listing> listingLoadTest() {

    // Get JSONArray from listings.json
    JSONArray fileInput = DataLoader.load(TestConstants.TEST_LISTINGS_FILE);
    // Get the singleton instance of Listings
    ArrayList<Listing> listings = new ArrayList<Listing>();

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

      listings.add(
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
        listings.get(x).addFee(feeName, feeCost);
      }

      // Begin parsing faqs here
      JSONArray faqs = (JSONArray) listing.get("faqs");

      for (int y = 0; y < faqs.size(); ++y) {

        JSONObject faq = (JSONObject) faqs.get(y);
        String faqQuestion = (String) faq.get("faqQuestion");
        String faqAnswer = (String) faq.get("faqAnswer");

        // Add this faq to the listing at position x
        listings.get(x).addFaq(faqQuestion, faqAnswer);
      }

      // Begin parsing reviews here
      JSONArray reviews = (JSONArray) listing.get("faqs");

      for (int y = 0; y < reviews.size(); ++y) {

        JSONObject review = (JSONObject) reviews.get(y);
        String reviewAuthor = (String) review.get("author");
        String reviewDescription = (String) review.get("description");

        listings.get(x).addReview(reviewAuthor, reviewDescription);
      }
    }

    return listings;
  }
}

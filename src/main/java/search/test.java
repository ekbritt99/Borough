package main.java.search;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import main.java.accounts.Account;
import main.java.accounts.Owner;
import main.java.accounts.Student;
import main.java.listings.Listing;

public class test {

	
	public static void main(String[] args) {
		
		SearchEngine searchEngine = new SearchEngine();
		//Arrays to search through
	      ArrayList<Listing> listingsToSearch = new ArrayList<Listing>();
	      ArrayList<Account> accountsToSearch = new ArrayList<Account>();
	    
	    //search result arrays
	      ArrayList<Listing> searchResultsName = new ArrayList<Listing>();
	      ArrayList<Listing> searchResultsPositiveBedrooms = new ArrayList<Listing>();
	      ArrayList<Listing> searchResultsPositiveBathrooms = new ArrayList<Listing>();
	      ArrayList<Listing> searchResultsHasPool = new ArrayList<Listing>();
	      ArrayList<Listing> searchResultsPetFriendly = new ArrayList<Listing>();
	      ArrayList<Listing> searchResultsWithWasherDryer = new ArrayList<Listing>();
	      ArrayList<Listing> searchResultsWithFreeWifi = new ArrayList<Listing>();
	      ArrayList<Listing> searchResultswithWalk2Campus = new ArrayList<Listing>();
	      ArrayList<Listing> searchResultsWithGym = new ArrayList<Listing>();
	      ArrayList<Listing> searchResultsFurnished = new ArrayList<Listing>();
	      ArrayList<Listing> searchResultsAllParameters = new ArrayList<Listing>();
	      ArrayList<Account> searchResultsFirstAndLastName = new ArrayList<Account>();
	      ArrayList<Account> searchResultOwnerAccount = new ArrayList<Account>();
	      ArrayList<Listing> searchResultsEmpty = new ArrayList<Listing>();
	      ArrayList<Account> ownerAccountsToSearch = new ArrayList<Account>();
	      
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
			
			Listing listingFour =
		            new Listing(
		                "00-00000004",
		                "11-00000004",
		                "The Retreat",
		                "The Retreat is a high quality apartment community designed around University of South"
		                    + " Carolina students.",
		                3.5,
		                "(803) 752-2500",
		                "email@email.com",
		                "person",
		                "location",
		                "zipcode",
		                1000.0,
		                39,
		                4,
		                4.0,
		                true,
		                true,
		                true,
		                true,
		                true,
		                true,
		                true);
		    
		    Listing listingFive =
		            new Listing(
		                "00-00000005",
		                "11-00000005",
		                "YOUnion",
		                "YOUnion is a high quality apartment community designed around University of South"
		                    + " Carolina students.",
		                3.5,
		                "(803) 747-4500",
		                "email@email.com",
		                "person",
		                "location",
		                "zipcode",
		                1000.0,
		                39,
		                2,
		                1.0,
		                true,
		                true,
		                false,
		                true,
		                false,
		                true,
		                false);

		   Listing listingSix =
		            new Listing(
		                "00-00000006",
		                "11-00000006",
		                "21 Oaks",
		                "21 oaks is a high quality apartment community designed around University of South"
		                    + " Carolina students.",
		                3.5,
		                "(803) 560-5987",
		                "email@email.com",
		                "person",
		                "location",
		                "zipcode",
		                1000.0,
		                39,
		                1,
		                1.0,
		                true,
		                false,
		                false,
		                false,
		                false,
		                true,
		                true);
		    
		    Listing listingSeven =
		            new Listing(
		                "00-00000007",
		                "11-00000007",
		                "650 Lincoln",
		                "650 Lincoln is a high quality apartment community designed around University of South"
		                    + " Carolina students.",
		                3.5,
		                "(803) 554-2435",
		                "email@email.com",
		                "person",
		                "location",
		                "zipcode",
		                1000.0,
		                39,
		                2,
		                1.0,
		                true,
		                true,
		                false,
		                false,
		                true,
		                false,
		                false);
		    
		    Listing listingEight =
		            new Listing(
		                "00-00000008",
		                "11-00000008",
		                "Redtail on the River",
		                "Redtail on the River is a high quality apartment community designed around University of South"
		                    + " Carolina students.",
		                3.5,
		                "(803) 752-2450",
		                "email@email.com",
		                "person",
		                "location",
		                "zipcode",
		                1000.0,
		                39,
		                2,
		                2.0,
		                true,
		                true,
		                true,
		                true,
		                true,
		                true,
		                true);
		    
		    Listing listingNine =
		            new Listing(
		                "00-00000009",
		                "11-00000009",
		                "Cliff Apartments",
		                "Cliff Apartments is a high quality apartment community designed around University of South"
		                    + " Carolina students.",
		                3.5,
		                "(803) 352-2250",
		                "email@email.com",
		                "person",
		                "location",
		                "zipcode",
		                1000.0,
		                39,
		                1,
		                1.0,
		                true,
		                true,
		                false,
		                true,
		                true,
		                false,
		                true);
		    
		    Listing listingTen =
		            new Listing(
		                "00-00000010",
		                "11-00000010",
		                "The Station",
		                "The Station is a high quality apartment community designed around University of South"
		                    + " Carolina students.",
		                3.5,
		                "(803) 772-2255",
		                "email@email.com",
		                "person",
		                "location",
		                "zipcode",
		                1000.0,
		                39,
		                4,
		                4.0,
		                true,
		                true,
		                false,
		                true,
		                true,
		                false,
		                true);
		    
		    Listing listingEleven =
		            new Listing(
		                "00-00000020",
		                "11-00000020",
		                "Vista Commons",
		                "Vista Commons is a high quality apartment community designed around University of South"
		                    + " Carolina students.",
		                3.5,
		                "(803) 879-3300",
		                "email@email.com",
		                "person",
		                "location",
		                "zipcode",
		                1000.0,
		                39,
		                2,
		                2.0,
		                true,
		                true,
		                true,
		                true,
		                true,
		                true,
		                true);
		    
		    listingsToSearch.add(listingOne);
		    listingsToSearch.add(listingTwo);
		    listingsToSearch.add(listingThree);
		    listingsToSearch.add(listingFour);
		    listingsToSearch.add(listingFive);
		    listingsToSearch.add(listingSix);
		    listingsToSearch.add(listingSeven);
		    listingsToSearch.add(listingEight);
		    listingsToSearch.add(listingNine);
		    listingsToSearch.add(listingTen);
		    listingsToSearch.add(listingEleven);
		  
		    
		    //search results for search with name "The Retreat"
		    
		    searchResultsName.add(listingFour);
		    
		    //search results for search with positive number (2) of bedrooms
		    searchResultsPositiveBedrooms.add(listingFive);
		    searchResultsPositiveBedrooms.add(listingSeven);
		    searchResultsPositiveBedrooms.add(listingEight);
		    searchResultsPositiveBedrooms.add(listingEleven);
		    
		    //search results for search with positive number (1) of bathrooms
		    searchResultsPositiveBathrooms.add(listingOne);
		    searchResultsPositiveBathrooms.add(listingTwo);
		    searchResultsPositiveBathrooms.add(listingThree);
		    searchResultsPositiveBathrooms.add(listingFive);
		    searchResultsPositiveBathrooms.add(listingSix);
		    searchResultsPositiveBathrooms.add(listingSeven);
		    searchResultsPositiveBathrooms.add(listingNine);
		    
		    //Search results for search with only search parameter as having pool
		    searchResultsHasPool.add(listingOne);
		    searchResultsHasPool.add(listingFour);
		    searchResultsHasPool.add(listingEight);
		    searchResultsHasPool.add(listingEleven);
		    
		    //Search results for search for pet friendly places
		    searchResultsPetFriendly.add(listingOne);
		    searchResultsPetFriendly.add(listingTwo);
		    searchResultsPetFriendly.add(listingThree);
		    searchResultsPetFriendly.add(listingFour);
		    searchResultsPetFriendly.add(listingFive);
		    searchResultsPetFriendly.add(listingSeven);
		    searchResultsPetFriendly.add(listingEight);
		    searchResultsPetFriendly.add(listingNine);
		    searchResultsPetFriendly.add(listingTen);
		    searchResultsPetFriendly.add(listingEleven);
		    
		    //search results for search for places with a washer and dryer
		    searchResultsWithWasherDryer.add(listingOne);
		    searchResultsWithWasherDryer.add(listingTwo);
		    searchResultsWithWasherDryer.add(listingThree);
		    searchResultsWithWasherDryer.add(listingFour);
		    searchResultsWithWasherDryer.add(listingFive);
		    searchResultsWithWasherDryer.add(listingSix);
		    searchResultsWithWasherDryer.add(listingSeven);
		    searchResultsWithWasherDryer.add(listingEight);
		    searchResultsWithWasherDryer.add(listingNine);
		    searchResultsWithWasherDryer.add(listingTen);
		    searchResultsWithWasherDryer.add(listingEleven);
		    
		    //search results for search for places with free wifi
		    searchResultsWithFreeWifi.add(listingTwo);
		    searchResultsWithFreeWifi.add(listingFour);
		    searchResultsWithFreeWifi.add(listingFive);
		    searchResultsWithFreeWifi.add(listingSix);
		    searchResultsWithFreeWifi.add(listingEight);
		    searchResultsWithFreeWifi.add(listingEleven);
		    
		    //search results for search for places with Walk2Campus
		    searchResultswithWalk2Campus.add(listingOne);
		    searchResultswithWalk2Campus.add(listingFour);
		    searchResultswithWalk2Campus.add(listingFive);
		    searchResultswithWalk2Campus.add(listingEight);
		    searchResultswithWalk2Campus.add(listingNine);
		    searchResultswithWalk2Campus.add(listingTen);
		    searchResultswithWalk2Campus.add(listingEleven);
		    
		    //search results for search for places with gym
		    searchResultsWithGym.add(listingThree);
		    searchResultsWithGym.add(listingFour);
		    searchResultsWithGym.add(listingSeven);
		    searchResultsWithGym.add(listingEight);
		    searchResultsWithGym.add(listingNine);
		    searchResultsWithGym.add(listingTen);
		    searchResultsWithGym.add(listingEleven);
		    
		    //Search results for search for places which are furnished
		    searchResultsFurnished.add(listingFour);
		    searchResultsFurnished.add(listingSix);
		    searchResultsFurnished.add(listingEight);
		    searchResultsFurnished.add(listingNine);
		    searchResultsFurnished.add(listingTen);
		    searchResultsFurnished.add(listingEleven);
		    
		    //search results for all parameters having been chosen
		    searchResultsAllParameters.add(listingEleven);
		    
		    //make same accounts to search through and add them to the arraylist to search
		    ArrayList<String> parentIds = new ArrayList<String>();
		    parentIds.add("12-00000001");
		    
		    ArrayList<String> studentWatchListIds = new ArrayList<String>();
		    studentWatchListIds.add("00-00000001");
		    studentWatchListIds.add("00-00000002");

		    ArrayList<String> studentNotifications = new ArrayList<String>();
		    studentNotifications.add("You are out of money");
		    studentNotifications.add("Get back to work");
		    
		    Student studentAccount = new Student("11-00000001",
		            "Elijah",
		            "Burke",
		            "02/06/2000",
		            "215 Spencer Place\nUnit 334\nCayce, SC 29033",
		            "8644041861",
		            "ehburke@email.sc.edu",
		            parentIds,
		            studentWatchListIds,
		            "20-00000001",
		            studentNotifications);
		    
		    Owner ownerAccount = new Owner("11-00000000", "PropertyOwner", "manager", "email@email.com", null, null);
		    
		    ownerAccountsToSearch.add(ownerAccount);
		    accountsToSearch.add(studentAccount);
		    
		    //search result for account with first name, last name, first and last name
		    searchResultsFirstAndLastName.add(studentAccount);
		 
		    //search result for owner account
		    searchResultOwnerAccount.add(ownerAccount);
		    
		    	//name
				ArrayList<Listing> searchResults = searchEngine.searchListings(listingsToSearch, "The Retreat", 0, 0.0, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				if (searchResults.equals(searchResultsName)) {
					System.out.println("listing name success");
				}
				
			
			
			//pos baths
				ArrayList<Listing> searchResults2 = searchEngine.searchListings(listingsToSearch, "", 0, 1.0, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				if (searchResults2.equals(searchResultsPositiveBathrooms)) {
					System.out.println("pos baths success");
				}
			
			
			//neg baths
				ArrayList<Listing> searchResults4 = searchEngine.searchListings(listingsToSearch, "", 0, -1.0, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				if (searchResults4.equals(searchResultsEmpty)) {
					System.out.println("neg baths success");
				}
			
			
			//pos bed
				ArrayList<Listing> searchResults5 = searchEngine.searchListings(listingsToSearch, "", 2, 0.0, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				if (searchResults5.equals(searchResultsPositiveBedrooms)) {
					System.out.println("pos beds success");
				}
			
			
			//neg bed
				ArrayList<Listing> searchResults6 = searchEngine.searchListings(listingsToSearch, "", -2, 0.0, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				if (searchResults6.equals(searchResultsEmpty)) {
					System.out.println("pos neg bed");
				}
			
			
			//pool
				ArrayList<Listing> searchResults7 = searchEngine.searchListings(listingsToSearch, "", 0, 0.0, false, false, true, false, false, false, false, false, false, false, false, false, false, false);
				if (searchResults7.equals(searchResultsHasPool)) {
					System.out.println("pos pool success");
				}
			
			
			//pet
				ArrayList<Listing> searchResults8 = searchEngine.searchListings(listingsToSearch, "", 0, 0.0, false, true, false, false, false, false, false, false, false, false, false, false, false, false);
				if (searchResults8.equals(searchResultsPetFriendly)) {
					System.out.println("pet");
				}
			
			
			//wifi
				ArrayList<Listing> searchResults9 = searchEngine.searchListings(listingsToSearch, "", 0, 0.0, false, false, false, false, false, false, false, false, false, false, false, false, true, false);
				if (searchResults9.equals(searchResultsWithFreeWifi)) {
					System.out.println("wifi");
				}
			
			
			//washer
				ArrayList<Listing> searchResults10 = searchEngine.searchListings(listingsToSearch, "", 0, 0.0, true, false, false, false, false, false, false, false, false, false, false, false, false, false);
				if (searchResults10.equals(searchResultsWithWasherDryer)) {
					System.out.println("washer");
				}
			

			//walk to campus
				ArrayList<Listing> searchResults11 = searchEngine.searchListings(listingsToSearch, "", 0, 0.0, false, false, false, true, false, false, false, false, false, false, false, false, false, false);
				if (searchResults11.equals(searchResultswithWalk2Campus)) {
					System.out.println("walk2");
				}
			
			
			//gym
				ArrayList<Listing> searchResults12 = searchEngine.searchListings(listingsToSearch, "", 0, 0.0, false, false, false, false, false, false, false, false, false, false, false, true, false, false);
				if (searchResults12.equals(searchResultsWithGym)) {
					System.out.println("gym");
				}
			
		
			//furnished
				ArrayList<Listing> searchResults13 = searchEngine.searchListings(listingsToSearch, "", 0, 0.0, false, false, false, false, false, false, false, false, false, false, false, false, false, true);
				if (searchResults13.equals(searchResultsFurnished)) {
					System.out.println("furnished");
				}
			
			
			//no param
				ArrayList<Listing> searchResults14 = searchEngine.searchListings(listingsToSearch, "", 0, 0.0, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				if (searchResults14.equals(listingsToSearch)) {
					System.out.println("no param listing");
				}
			
			
			//all param
				ArrayList<Listing> searchResults15 = searchEngine.searchListings(listingsToSearch, "Vista Commons", 2, 2.0, true, true, true, true, true, true, true, true, true, true, true, true, true, true);
				if (searchResults15.equals(searchResultsAllParameters)) {
					System.out.println("all params");
				}
			
			
			//first name
				ArrayList<Account> searchResults16 = searchEngine.searchAccounts(accountsToSearch,"Elijah", "");
				if (searchResults16.equals(searchResultsFirstAndLastName)) {
					System.out.println("first name");
				}
			
			
			//last name
				ArrayList<Account> searchResults17 = searchEngine.searchAccounts(accountsToSearch,"", "Burke");
				if (searchResults17.equals(searchResultsFirstAndLastName)) {
					System.out.println("last name");
				}
			
			
			//first and last
				ArrayList<Account> searchResults18 = searchEngine.searchAccounts(accountsToSearch,"Elijah", "Burke");
				if (searchResults18.equals(searchResultsFirstAndLastName)) {
					System.out.println("first+last name");
				}
			
			
			//no name
				ArrayList<Account> searchResults19 = searchEngine.searchAccounts(accountsToSearch,"", "");
				if (searchResults19.equals(accountsToSearch)) {
					System.out.println("no name");
				}
			
			
			//invalid name
				ArrayList<Account> searchResults20 = searchEngine.searchAccounts(accountsToSearch,"asdf", "xcv");
				if (searchResults20.equals(searchResultsEmpty)) {
					System.out.println("invalid name");
				}
			
			
			//owner name
				ArrayList<Account> searchResults21 = searchEngine.searchOwnerAccounts(ownerAccountsToSearch,"PropertyOwner");
				if (searchResults21.equals(ownerAccountsToSearch)) {
					System.out.println("owner name");
				}
			
		
			//owner no name
				ArrayList<Account> searchResults22 = searchEngine.searchOwnerAccounts(accountsToSearch,"");
				
			
			
			//owner invalid name
				ArrayList<Account> searchResults23 = searchEngine.searchOwnerAccounts(accountsToSearch,"asdf");
				
				System.out.println("Done");
			
			

	}

}

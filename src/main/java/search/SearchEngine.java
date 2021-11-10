package main.java.search;
import java.util.ArrayList;
import main.java.accounts.*;
import main.java.listings.*;
import java.util.Iterator;
import main.java.database.*;

/**
 * Class which allows users to search through accounts and listings
 * @author Ethan Brittain
 *
 */
public class SearchEngine {
	private static ArrayList<Listing> listings;
	private static ArrayList<Account> accounts;
	private Accounts accountsToLoad;
	private Listings listingsToLoad;
	private static SearchEngine searchEngine;
	
	SearchEngine() {
		listings = new ArrayList<Listing>();
		accounts = new ArrayList<Account>();
	}

	public static SearchEngine getInstance() {
		return searchEngine;
	}
	
	public static ArrayList<Account> searchAccounts(ArrayList<Account> aAccounts, String firstName, String lastName){
		accounts = aAccounts;
		ArrayList<Account> searchResults = new ArrayList<Account>();
		
		for (int i = 0; i < accounts.size(); i++) {
			
			if (firstName.isEmpty() != true && lastName.isEmpty() != true) {
				
				if (accounts.get(i).getFirstName().equals(firstName) && accounts.get(i).getLastName().equals(lastName)) {
					
					searchResults.add(accounts.get(i));
				}
			}
			
			if (firstName.isEmpty() != true && lastName.isEmpty() == true) {
				
				if (accounts.get(i).getFirstName().equals(firstName)) {
					
					searchResults.add(accounts.get(i));
				}
			}
			
			if (firstName.isEmpty() == true && lastName.isEmpty() != true) {
				
				if (accounts.get(i).getLastName().equals(lastName)) {
					
					searchResults.add(accounts.get(i));
				}
			}
		}
		return searchResults;
	}
	
	public ArrayList<Account> searchOwnerAccounts(ArrayList<Account> accounts, String name) {
		
		this.accounts = accounts;
		ArrayList<Account> searchResults = new ArrayList<Account>();
		
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getFirstName() == name) {
				searchResults.add(accounts.get(i));
			}
		}
		
		return searchResults;
	}
	
	
	public static ArrayList<Listing> searchListings(ArrayList<Listing> aListings, String listingName,
			int numBedrooms, double numBathrooms, boolean washerDryer, boolean washerDryerYN,boolean petFriendly, 
			boolean petFriendlyYN, boolean pool, boolean poolYN,boolean Walk2Campus, boolean Walk2CampusYN,
			boolean gym, boolean gymYN, boolean freeWifi, boolean freeWifiYN, boolean furnished, boolean furnishedYN){
		
		listings = aListings;
		ArrayList<Listing> searchResults = new ArrayList<Listing>();
		
		for (int i = 0; i < listings.size(); i++) {
			if ((listingName.isEmpty() == true || listings.get(i).getName().equals(listingName)) && 
				(numBedrooms == 0 || listings.get(i).getNumBedrooms() == numBedrooms) && 
				(numBathrooms == 0|| listings.get(i).getNumBathrooms() == numBathrooms) &&
				(washerDryerYN == false  || listings.get(i).getWasherDryer() == washerDryer) &&
				(petFriendlyYN == false  || listings.get(i).getPetFriendly() == petFriendly) &&
				(poolYN == false  || listings.get(i).getPool() == pool) &&
				(Walk2CampusYN == false  || listings.get(i).getWalk2Campus() == Walk2Campus) &&
				(gymYN == false  || listings.get(i).getGym() == gym) &&
				(freeWifiYN == false  || listings.get(i).getFreeWifi() == freeWifi) &&
				(furnishedYN == false  || listings.get(i).getFurnished() == furnished)){
				
				searchResults.add(listings.get(i));
			}
		}
		return searchResults;
	}
	
	
}

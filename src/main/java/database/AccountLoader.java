package main.java.database;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import main.java.accounts.Owner;
import main.java.accounts.Parent;
import main.java.accounts.Student;
import main.java.util.Constants;

/**
 * This class inherits from DataLoader, using its functionality to directly initialize the list of
 * accounts, found in Accounts
 * 
 * <p>TODO Refactor to merge this and ListingLoader directly into DataLoader
 *
 * @author Elijah Burke
 */
public class AccountLoader extends DataLoader {

  /** Loads data from accounts.json into the list of accounts in class Accounts */
  public static void load() {

    // Get JSON Array from accounts.json
    JSONArray fileInput = DataLoader.load(Constants.ACCOUNTS_FILE);
    if(fileInput == null) {
    		return;
    }
    // Get the singleton instance of Accounts
    Accounts accounts = Accounts.getInstance();

    for (Object object : fileInput) {
    	
    	JSONObject json = (JSONObject) object;
    	
    	// Get string and create object based on the type of account
    	String internalId = (String) json.get("internalId");
    	String[] parts = internalId.split("-");
    	String part1 = parts[0];
    	switch (part1) {
    	
    	case ("11"):
    		accounts.addAccount(newOwner(internalId, json));
    		break;
    	
    	case ("12"):
    		accounts.addAccount(newStudent(internalId, json));
    		break;
    		
    	case ("13"):
    		accounts.addAccount(newParent(internalId, json));
    	}
    }
  }
  
  private static Owner newOwner(String internalId, JSONObject json) {
	  
	  String name = (String) json.get("name");
	  String manager = (String) json.get("manager");
	  String email = (String) json.get("email");
	  ArrayList<String> listingIds = (ArrayList<String>) json.get("listingIds");
	  ArrayList<String> notifications = (ArrayList<String>) json.get("notifications");
	  
	  return new Owner(internalId, name, manager, email, listingIds, notifications);
  }
  
  private static Student newStudent(String internalId, JSONObject json) {
	
	  String firstName = (String) json.get("firstName");
	  String lastName = (String) json.get("lastName");
	  String dateOfBirth = (String) json.get("dateOfBirth");
	  String address = (String) json.get("address");
	  String phoneNumber = (String) json.get("phoneNumber");
	  String email = (String) json.get("email");
	  ArrayList<String> parentIds = (ArrayList<String>) json.get("parentIds");
	  ArrayList<String> watchListIds = (ArrayList<String>) json.get("watchListIds");
	  String roommateGroupId = (String) json.get("roommateGroupId");
	  ArrayList<String> notifications = (ArrayList<String>) json.get("notificatins");
	  
	  return new Student(internalId, firstName, lastName, dateOfBirth, address, phoneNumber, email, parentIds, watchListIds, roommateGroupId, notifications);
  }
  
  private static Parent newParent(String internalId, JSONObject json) {
	  
	  String firstName = (String) json.get("firstName");
	  String lastName = (String) json.get("lastName");
	  String dateOfBirth = (String) json.get("dateOfBirth");
	  String address = (String) json.get("address");
	  String phoneNumber = (String) json.get("phoneNumber");
	  String email = (String) json.get("email");
	  ArrayList<String> childrenIds = (ArrayList<String>) json.get("childrenIds");
	  ArrayList<String> watchListIds = (ArrayList<String>) json.get("watchListIds");
	  ArrayList<String> notifications = (ArrayList<String>) json.get("notificatins");
	  
	  return new Parent(internalId, firstName, lastName, dateOfBirth, address, phoneNumber, email, childrenIds, watchListIds, notifications);
  }
}

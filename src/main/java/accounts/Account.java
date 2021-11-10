package main.java.accounts;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import main.java.database.Accounts;
import main.java.database.Saveable;
import main.java.listings.Faq;
import main.java.listings.Fee;

/**
 * This class is the parent class to student, parent, and owner.
 * Is on the receiving end of a multiplicable relation with AccountIterator.
 * @author josephbrancker
 *
 */
public abstract class Account implements Saveable {
		
		private String internalId;
		private String firstName;
		private String lastName;
		
		/**
		 * takes in the parameter and sets it equal to internalId
		 * @param internalId //the Id of the account
		 */
		public Account(String internalId, String firstName, String lastName) {
				this.internalId = internalId;
				this.firstName = firstName;
				this.lastName = lastName;
		}
		
		/**
		 * this method get the internalId
		 * @return this.internalId //the Id of the account
		 */
		public String getInternalId() {
				return internalId;
				
		}
		
		
		public String getFirstName() {
			return this.firstName;
		}
		
		public String getLastName() {
			return this.lastName;
		}
		
		/**
		 * this method sets the parameter equal to the attribute
		 * based on its mutation, if needed
		 * @param internalId // the Id of the account
		 */
		public void setInternalId(String internalId) {
				this.internalId = internalId;
		}
		/**
		 * this method returns the internalId.
		 * @return the string plus internalId
		 */
		public String toString() {
				return "Account ID: " + this.internalId + "\n"
								+ " Name: " + this.firstName + " "+ this.lastName +"\n";
		}
		
		/**
		 * this method takes in an account and gets its internalId
		 * it checks to see if it is equal to the current one
		 * and returns true or false based on that result.
		 * @param account
		 * @return true
		 * @return false
		 */
		public boolean equals(Account account) {
				return false;
				
		}
		
		public JSONObject toJSONObject() {
				
				JSONObject accountJSON = new JSONObject();
		    
		    ArrayList<Accounts> accountss = new ArrayList<Accounts>();
		    int i = 0;
		    for(Accounts accounts: accountss) {
		    Account account = accounts.getAccount(i);
		    i++;
		    internalId = account.getInternalId();
		    String[] parts = internalId.split("-");
		    String type = parts[0];
		    if(type.equals("11")) {
		    		JSONObject JSONOwner = new JSONObject();
		    		
		    		JSONOwner.put("internalId", ((Owner)account).getInternalId());
		    		JSONOwner.put("manager", ((Owner)account).getManager());
		    		JSONOwner.put("listingIds", ((Owner)account).getListings());
		    		JSONOwner.put("name", ((Owner)account).getFirstName());
		    		JSONOwner.put("email", ((Owner)account).getEmail());
		    		JSONOwner.put("notifications", ((Owner)account).getNotifications());
		    		JSONOwner.put("reviews", ((Owner)account).getReviews());
		    		
		    		accountJSON.put("", JSONOwner);
		    }
		    if(type.equals("12")) {
		    		JSONObject JSONStudent = new JSONObject();
		    		
		    		JSONStudent.put("internalId", ((Student)account).getInternalId());
		    		JSONStudent.put("firstName", ((Student)account).getFirstName());
		    		JSONStudent.put("lastName", ((Student)account).getLastName());
		    		JSONStudent.put("address", ((Student)account).getAddress());
		    		JSONStudent.put("phoneNumber", ((Student)account).getPhoneNumber());
		    		JSONStudent.put("parentIds", ((Student)account).getParents());
		    		JSONStudent.put("dateOfBirth", ((Student)account).getDateOfBirth());
		    		JSONStudent.put("email", ((Student)account).getEmail());
		    		JSONStudent.put("notifications", ((Student)account).getNotifications());
		    		JSONStudent.put("watchListIds", ((Student)account).getWatchList());
		    		JSONStudent.put("roommateGroupId", ((Student)account).getRoommateGroupId());
		   
		    		accountJSON.put("", JSONStudent);
		    }
		    if(type.contentEquals("13")) {
		    		JSONObject JSONParent = new JSONObject();
		    		JSONParent.put("internalId", ((Parent)account).getInternalId());
		    		JSONParent.put("firstName", ((Parent)account).getFirstName());
		    		JSONParent.put("lastName", ((Parent)account).getLastName());
		    		JSONParent.put("address", ((Parent)account).getAddress());
		    		JSONParent.put("phoneNumber", ((Parent)account).getPhoneNumber());
		    		JSONParent.put("childrenIds", ((Parent)account).getChildren());
		    		JSONParent.put("dateOfBirth", ((Parent)account).getDateOfBirth());
		    		JSONParent.put("email", ((Parent)account).getEmail());
		    		JSONParent.put("watchListIds", ((Parent)account).getWatchList());
		   
		    		accountJSON.put("", JSONParent);
		    }
		    }
				return accountJSON;
		}
}

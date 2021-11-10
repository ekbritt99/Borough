package main.java.database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import main.java.accounts.Account;
import main.java.accounts.Owner;
import main.java.accounts.Parent;
import main.java.accounts.RoommateGroup;
import main.java.accounts.Student;
import main.java.listings.Listing;
import main.java.search.SearchEngine;
import main.java.util.Constants;
import main.java.database.*;

/**
 * This class runs the entirety of the program
 * @author josephbrancker
 *
 */
public class BoroughUI {
		private static final String WELCOME_MESSAGE = "Welcome to Borough!";
		private static final String LOG_IN = "Please Log In with your email, create an account (create), or hit enter to continue as guest.";
		private static final String LOG_OUT = "Logging out";
		private static final String PROFILE = "\nCurrently viewing your Profile";
		private static final String NAME= "Please enter your your first and last name!";
		private static final String EMAIL = "Please enter your Email";
		private static final String BOROUGH_SEARCH_ENGINE = "*** Borough Search Engine ***\nEnter 'a' to search for accounts, 'o' to search for owner accounts, or 'l' to search for listings!";
		private String[] mainMenuParent = {"View Profile", "Search", "Logout"};
		private String[] mainMenuStudent = {"View Profile", "Search", "Join a Roommate Group", "Leave a Roommate Group", "Add to Watch List", "Remove from Watch List", "Leave a Review", "Logout"};
		private String[] mainMenuOwner = {"View Profile", "Search", "Create Listing", "Logout"};
		private String[] ownerViewProfile = {"View Listing", "Update Name", "Update Manager", "Update Email"};
		private String[] studentViewProfile = {"Add Parent", "Remove Parent", "Update Address", "Update Email", "Update Phone Number", "Update Notifications"};
		private String[] parentViewProfile = {"Add Student", "Remove Student", "Update Address", "Update Email", "Update Phone Number", "Update Notifications"};
		private String[] viewListing = {"Update Name", "Update Description", "Update Email", "Update Phone Number", "Update Rent", "Add Fee", "Remove Fee", "Add FAQ", "Remove FAQ" };
		private String[] searchMenu = {"Name", "# Bathrooms", "# Bedrooms", "Pool (Y/N)", "Pet Friendly (Y/N)", "Free Wifi (Y/N)", "Washer and Dryer (Y/N)","Walk to Campus (Y/N)", "Gym (Y/N)", "Furnished (Y/N)", "Search"};
		private String login = "n"
				+ "";
		private String type;
		private boolean guest;
		private String[] menu;
		private String internalId;
		private Scanner scanner;
		private Student student;
	  private Owner owner;
		private String[] accountsList;
	  private Account currentaccount;
	  private Account[] account;
	  private String[] internalIds;
		private ArrayList<Account> accounts2;
		private ArrayList<Listing> listings2;
		private Accounts accounts;
		private Listing listing;
		private Listings listings;
		private RoommateGroup roommateGroup;
		private SearchEngine searchEngine;
		private boolean pool = false;
		private boolean wifi = false;
		private boolean gym = false;
		private boolean walk = false;
		private boolean furnished = false;
		private boolean washer = false;
		private boolean pet = false;
		private boolean furnishedtf = false;
		private boolean gymtf = false;
		private boolean walkcampus = false;
		private boolean washerDryer = false;
		private boolean pooltf = false;
		private boolean freeWifi  = false;
		private boolean petFriendly = false;
		private String[] leaseNames = new String[10];
		
		/**
		 * This method creates a new instance of scanner
		 */
		BoroughUI(){
				scanner = new Scanner(System.in);
				accounts2 = new ArrayList<Account>();
				accountsList = new String[1000];
				internalIds = new String[1000];
				account = new Account[1000];
				menu = new String[1000];
				listings2 = new ArrayList<Listing>();
		}
		
		/**
		 * Thid method runs the program. It outputs a welcome message and promps
		 * the user to enter their email for login. After the user logs in it throws
		 * the correct menu based on user type. If user hits 'enter' instead of login
		 * it takes them to createaccount.
		 */
		public void run() {
				Accounts accounts = Accounts.getInstance();
				Listings listings = Listings.getInstance();
				AccountLoader.load();
				
				accounts = Accounts.getInstance();
				for(int i = 0; i < accounts.size(); i++) {
						accounts2.add(accounts.getAccount(i));
				}
				accounts2.iterator();
				listings = Listings.getInstance();
				for(int i = 0; i < listings.size(); i++) {
						listings2.add(listings.getListing(i));
				}
				
				System.out.println(WELCOME_MESSAGE);
				System.out.println(LOG_IN);
				String email = scanner.nextLine();
				if(email.toLowerCase().equals("create")) {
						createAccount();
				} else if(!email.equals("")){
						boolean flag = logIn(email);
				
						while(flag) {
						
								if(type.equals("12"))
										menu = mainMenuStudent;
						
								if(type.equals("13"))
										menu = mainMenuParent;
						
								if(type.equals("11"))
  								menu = mainMenuOwner;
  						
								displayMenu(menu);
						
								int command = getCommand(menu.length);
						
								if(command == -1) {
										System.out.println("Not a valid command");
										continue;
								}
						
								if(command == menu.length)
										break;
						
								if(menu == mainMenuParent) {
								
										switch(command) {
										case(0):
												viewProfile();
												flag = true;
												break;
										case(1):
												System.out.println(BOROUGH_SEARCH_ENGINE);
										    String search = scanner.nextLine();
												search(search.toLowerCase());
												break;
										case(2):
												System.out.println(LOG_OUT);
												flag = true;
												run();
										}
										
								}
						
								if(menu == mainMenuStudent) {
								
										switch(command) {
										case(1):
												viewProfile();
												flag = true;
												break;
										case(2):
												System.out.println(BOROUGH_SEARCH_ENGINE);
								    String search = scanner.nextLine();
										search(search.toLowerCase());
												break;
										case(3):
												joinRoommateGroup();
												break;
										case(4):
												leaveRoommateGroup();
												break;
										case(5):
												addToWatchList();
												break;
										case(6):
												removeFromWatchList();
												break;
										case(7):
												leaveAReview();
												break;
										case(8):
												System.out.println(LOG_OUT);
												flag = true;
												run();
										}
										
								}
						
								if(menu == mainMenuOwner) {
								
										switch(command) {
											case(1):
													viewProfile();
													flag = true;
													break;
											case(2):
													System.out.println(BOROUGH_SEARCH_ENGINE);
									    String search = scanner.nextLine();
											search(search.toLowerCase());
												break;
											case(3):
													createListing();
													flag = true;
													break;
											case(4):
													System.out.println(LOG_OUT);
													flag = true;
													run();
										}
										
								}
						}
				} else {
						while(true) {
						guest = true;
						System.out.println(BOROUGH_SEARCH_ENGINE);
				    String search = scanner.nextLine();
						search(search.toLowerCase());;
						System.out.println("Would you like to search for 'a', 'o', or 'l', again? 'y' or 'n'");
						String again = scanner.nextLine();
						if(again.toLowerCase().equals("y")) {
								continue;
						} else {
								break;
						}
						}
						System.out.println("Did you enjoy using burrow? You can create an account for free to access more features! Enter 'create' to create an account.");
						String create = scanner.nextLine();
						if(create.toLowerCase().equals("create")) {
						createAccount();
				    } else {
				    		System.out.println("Goodbye!");
				    }}
				if(this.login.toLowerCase().equals("y")) {
				DataWriter.save(accounts, Constants.ACCOUNTS_FILE);
				DataWriter.save(listings, Constants.LISTINGS_FILE);
				this.login = "n";
				run();
				} else {
						DataWriter.save(accounts, Constants.ACCOUNTS_FILE);
						DataWriter.save(listings, Constants.LISTINGS_FILE);
				}
		}
		
		/**
		 * 
		 * @param email
		 * @return
		 */
		private boolean logIn(String email) {
				
				for(int i = 0; i < accounts.size(); i++) {
						
						currentaccount = accounts.getAccount(i);
						internalId = currentaccount.getInternalId();
						String[] parts = internalId.split("-");
						type = parts[0];
						if(type.equals("11")) {
								 if(email.equals(((Owner) currentaccount).getEmail())) {
										 owner = ((Owner) currentaccount);
										 return true; 
								 }
								 
						}
						if(type.equals("12")) {
									if(email.equals(((Student) currentaccount).getEmail())) {
											student = ((Student) currentaccount);
											return true;
									}
						}
						if(type.equals("13")) {
									if(email.equals(((Parent) currentaccount).getEmail())) {
											return true;
									}		
						}
				}
				System.out.println("Account not found");
				return false;
		}
		
		/**
		 * 
		 */
		private void createAccount() {
				System.out.println("Creating Account");
				System.out.println("Are you a Student, Parent, or Owner?");
				type = scanner.nextLine();
				
				if(type.toLowerCase().equals("student")) {
						String id = assignID();
						System.out.println(NAME);
						String name = scanner.nextLine();
						System.out.println(EMAIL);
						String email = scanner.nextLine();
						System.out.println("Please enter your phone number");
						String phone = scanner.nextLine();
						System.out.println("Please enter your DOB in the form mm\\/dd\\/yyyy");
						String dob = scanner.nextLine();
						System.out.println("Please enter your address");
						String address = scanner.nextLine();
						String[] names = name.split(" ");
						String firstname = names[0];
						String lastname = names[1];
					  Accounts.addAccount(new Student(id, firstname, lastname, dob, address, phone, email, null, null, null, null));
				}
				
				if(type.toLowerCase().equals("parent")) {
						String id = assignID();
						System.out.println(NAME);
						String name = scanner.nextLine();
						System.out.println(EMAIL);
						String email = scanner.nextLine();
						System.out.println("Please enter your phone number");
						String phone = scanner.nextLine();
						System.out.println("Please enter your DOB in the form mm\\/dd\\/yyyy");
						String dob = scanner.nextLine();
						System.out.println("Please enter your address");
						String address = scanner.nextLine();
						String[] names = name.split(" ");
						String firstname = names[0];
						String lastname = names[1];
						Accounts.addAccount(new Parent(id, firstname, lastname, dob, address, phone, email, null, null, null));
				}
				
				if(type.toLowerCase().equals("owner")) {
						String id = assignID();
						System.out.println(NAME);
						String name = scanner.nextLine();
						System.out.println(EMAIL);
						String email = scanner.nextLine();
						System.out.println("Please enter your manager name");
						String manager = scanner.nextLine();
						Accounts.addAccount(new Owner(id, name, manager, email, null, null));
				}
				System.out.println("Thank you for creating an account, would you like to login? 'y' or 'n'");
				this.login = scanner.nextLine();
		}

		/**
		 * 
		 * @return
		 */
		private String assignID() {
				
				if(type.equals("00")) {
						
						for(int i = listings.size(); i > 0; i--) {
								
								listing = listings.getListing(i);
								String[] parts = listing.getInternalId().split("-");
								String idtype2 = parts[0];
								
								if(type == idtype2) {
										
										String rest = parts[1];
										int rest2 = Integer.parseInt(rest);
										rest2++;
										rest = String.valueOf(rest2);
										String internalId = type + "-" + rest;
										return internalId;
								}
						}	
				}		
				
				String idtype = "";
				
				if(type.toLowerCase().equals("owner")) {
						idtype = "11";
				}
				
				if(type.toLowerCase().equals("student")) {
						idtype = "12";
				}
				
				if(type.toLowerCase().equals("parent")) {
						idtype = "13";
				}
				
				if(accounts.size() == 0) {
						String internalId = idtype + "-" + "00000000";
						return internalId;
				}
				for(int i = accounts.size()-1; i > -1; i--) {
						
						currentaccount = accounts.getAccount(i);
						String[] parts = currentaccount.getInternalId().split("-");
						String idtype2 = parts[0];
						
						if(idtype == idtype2) {
								
								String rest = parts[1];
								int rest2 = Integer.parseInt(rest);
								rest2++;
								rest = String.valueOf(rest2);
								String internalId = idtype + "-" + rest;
								return internalId;
						}
				}
				if(idtype.equals("11")) {
						String internalId = idtype + "-" + "00000000";
						return internalId;
				}
				if(idtype.equals("12")) {
						String internalId = idtype + "-" + "00000000";
						return internalId;
				}
				if(idtype.equals("13")) {
						String internalId = idtype + "-" + "00000000";
						return internalId;
				}
				return "";
		}
		
		/**
		 * 
		 */
		private void viewProfile() {
				
				if(type.equals("11")) {
						
						boolean flag = true; 
						
						while(flag) {
								System.out.println(PROFILE);
								System.out.println(((Owner) currentaccount).toString());
								System.out.println("Type 'edit' if you want to edit your profile. Hit enter to return to main menu");
								String edit = scanner.nextLine();
								if(edit.toLowerCase().equals("edit")) {
								displayMenu(ownerViewProfile);
								int command = getCommand(ownerViewProfile.length);
						
    						if(command == -1) {
    								System.out.println("Not a valid command");
    								continue;
    						}
    						
    						if(command == ownerViewProfile.length -1)
    								break;
    						
    						switch(command) {
    						case(0):
    								viewListing();
    								flag = true;
    								break;
    						case(1):
    								System.out.println("Please enter your new name.");
    								String name = scanner.nextLine();
    								((Owner) currentaccount).setName(name);
    								break;
    						case(2):
    								System.out.println("Please enter your new manager");
    								String manager = scanner.nextLine();
    								((Owner) currentaccount).setManager(manager);
    								break;
    						case(3):
    								System.out.println("Please enter your new email address!");
    								String email = scanner.nextLine();
    								((Owner) currentaccount).setEmail(email);
    								break;
    						}
    						System.out.println("Do you wish to return to main menu? 'y' or 'n'?");
    						String main = scanner.nextLine();
    						if(main == "y") {
    								flag = false;
    						} else {
    								flag = true;
    						}
						} else {
								return;
						}
								}
				}
				
				if(type.equals("12")) {
						
						boolean flag = true;
						
						while(flag) {
    						
								System.out.println(PROFILE);
								System.out.println(((Student) currentaccount).toString());
    						
								System.out.println("Type 'edit' if you want to edit your profile. Hit enter to return to main menu");
								String edit = scanner.nextLine();
								if(edit.toLowerCase().equals("edit")) {
    						displayMenu(studentViewProfile);
    						int command = getCommand(studentViewProfile.length);
    						
    						if(command == -1) {
    								System.out.println("Not a valid command");
    								continue;
    						}
    						
    						if(command == studentViewProfile.length -1)
    								break;
    						
    						ArrayList<String> parentIds = new ArrayList<String>();
    						String parent = "";
    						
    						switch(command) {
    						case(0):
    								System.out.println("To add a parent enter their account ID. They can find their account ID on their profile!");
    								parent = scanner.nextLine();
    								parentIds.add(parent);
    								((Student) currentaccount).setParnetIds(parentIds);
    								break;
    						case(1):
    								System.out.println("To remove a parent enter their account ID.");
    								parent = scanner.nextLine();
    								parentIds.remove(parent);
    								((Student) currentaccount).setParnetIds(parentIds);
    								break;
    						case(2):
    								System.out.println("Enter the new address");
    								String address = scanner.nextLine();
    								((Student) currentaccount).setAddress(address);
    								break;
    						case(3):
    								System.out.println("Enter the new email address!");
    								String email = scanner.nextLine();
    								((Student) currentaccount).setEmail(email);
    								break;
    						case(4):
    								System.out.println("Enter the new phone number!");
    								String phone = scanner.nextLine();
    								((Student) currentaccount).setPhoneNumber(phone);
    								break;
    						case(5):
    								System.out.println("Updating Notifications");
    								((Student) currentaccount).getNotifications();
    								break;
    						}
    						
    						System.out.println("Do you wish to return to main menu? 'y' or 'n'?");
    						String main = scanner.nextLine();
    						if(main.equals("y")) {
    								flag = false;
    						} else {
    								flag = true;
    						}
								} else {
										return;
								}
						}
				}
				
				if(type.equals("13")) {
						
						boolean flag = true;
						while(flag) {
								
								System.out.println(PROFILE);
								System.out.println(((Parent) currentaccount).toString());
								System.out.println("Type 'edit' if you want to edit your profile. Hit enter to return to main menu");
								String edit = scanner.nextLine();
								if(edit.toLowerCase().equals("edit")) {
								displayMenu(parentViewProfile);
								int command = getCommand(parentViewProfile.length);
								
								if(command == -1) {
										System.out.println("Not a valid command");
										continue;
								}
								
								if(command == parentViewProfile.length -1)
										break;
								
								ArrayList<String> studentIds = new ArrayList<String>();
								String student = "";
								
								switch(command) {
								case(0):
										System.out.println("To add a student enter their account ID. They can find their account ID on their profile!");
										student = scanner.nextLine();
										studentIds.add(student);
										((Parent) currentaccount).setChildrenIds(studentIds);
										break;
								case(1):
										System.out.println("To remove a student enter their account ID.");
										student = scanner.nextLine();
										studentIds.remove(student);
										((Parent) currentaccount).setChildrenIds(studentIds);
										break;
								case(2):
										System.out.println("Enter the new address");
										String address = scanner.nextLine();
										((Parent) currentaccount).setAddress(address);
										break;
								case(3):
										System.out.println("Enter the new email address!");
										String email = scanner.nextLine();
										((Parent) currentaccount).setEmail(email);
										break;
								case(4):
										System.out.println("Enter the new phone number!");
										String phone = scanner.nextLine();
										((Parent) currentaccount).setPhoneNumber(phone);
										break;
								case(5):
										System.out.println("Updating Notifications");
										((Parent) currentaccount).getNotifications();
										break;
								}
								System.out.println("Do you wish to return to main menu? 'y' or 'n'?");
    						String main = scanner.nextLine();
    						if(main.equals("y")) {
    								flag = false;
    						} else {
    								flag = true;
    						}
						} else {
								return;
						}
						}
				}
		}
		
		/**
		 * 
		 */
		private void viewListing() {
				
				boolean flag = true;
				
				while(flag) {
				System.out.println("Please enter the Listing Id of the listing you'd like to view");
				String property = scanner.nextLine();
								
						for(int i = 0; i <listings.size(); i++) {
									listing = listings.getListing(i);
									String listingId = listing.getInternalId();
									
									if(property == listingId) {
											
											displayMenu(viewListing);
						
											int command = getCommand(viewListing.length);
						
											if(command == -1) {
													System.out.println("Not a valid command");
											}
						
											if(command == viewListing.length -1)
													return;
						
          						switch(command) {
          						case(0):
          								System.out.println("Enter the new Property name");
          								String name = scanner.nextLine();
          								listing.updateName(name);
          								break;
          						case(1):
          								System.out.println("Enter the new description");
          								String description = scanner.nextLine();
          								listing.updateDescription(description);
          								break;
          						case(2):
          								System.out.println("Enter the new email address for the property");
          								String email = scanner.nextLine();
          								listing.updateEmail(email);
          								break;
          						case(3):
          								System.out.println("Enter the new phone number for the property");
          								String phone = scanner.nextLine();
          								listing.updatePhoneNumber(phone);
          								break;
          						case(4):
          								System.out.println("Enter the new rent");
          								double rent = scanner.nextDouble();
          								listing.updateRent(rent);
          								break;
          						case(5):
          								System.out.println("Enter the fee name");
          								String feename = scanner.nextLine();
          								System.out.println("Enter the fee cost");
          								double cost = scanner.nextDouble();
          								listing.addFee(feename, cost);
          								break;
          						case(6):
          								System.out.println("Enter the fee name to remove.");
          								String feename2 = scanner.nextLine();
          								listing.removeFee(feename2);
          								break;
          						case(7):
          								System.out.println("Enter the question");
          								String question = scanner.nextLine();
          								System.out.println("Enter the answer");
          								String answer = scanner.nextLine();
          								listing.addFaq(question, answer);
          								break;
          						case(8):
          								System.out.println("Enter the question to be removed");
          								String question2 = scanner.nextLine();
          								listing.removeFaq(question2);
          					}
								}	else {
										System.out.println("Property you entered is not found.");
										return;
								}
						}
						System.out.println("Do you wish to return to your profile? 'y' or 'n'?");
						String main = scanner.nextLine();
						if(main.equals("y")) {
								flag = false;
						} else {
								flag = true;
						}
					}
		}
		
		/**
		 * 
		 */
		private void createRoommateGroup() {
				
				System.out.println("Please enter your roommates name!");
				String roommate = scanner.nextLine();
				search("a");
		}
		
		/**
		 * 
		 */
		private void joinRoommateGroup() {
			
				System.out.println("Please enter the group ID");
				String group = scanner.nextLine();
		}
		
		/**
		 * 
		 */
		private void leaveRoommateGroup() {
				
				System.out.println("Please enter the group ID");
				String group = scanner.nextLine();
		}
		
		/**
		 * 
		 */
		private void addToWatchList() {
				
				System.out.println("Enter the properties ID");
				String property = scanner.nextLine();
				
				for(int i = 0; i <listings.size(); i++) {
						
						listing = listings.getListing(i);
						String listingId = listing.getInternalId();
						
						if(property == listingId) {
								student.addToWatchList(listingId);
								return;
						}
				}
				System.out.println("Property not found.");
		}
		
		/**
		 * 
		 */
		private void removeFromWatchList() {
				
				System.out.println("Enter the properties ID");
				String property = scanner.nextLine();
				
				for(int i = 0; i <listings.size(); i++) {
						
						listing = listings.getListing(i);
						String listingId = listing.getInternalId();
						
						if(property == listingId) {
								student.removeFromWatchList(listingId);
								return;
						}
				}
				System.out.println("Property not found.");
		}
		
		
		/**
		 * 
		 */
		private void leaveAReview() {
				
				if(type.equals("12")) {
						
						System.out.println("Would you like to review a property or owner?");
						String choice = scanner.nextLine();
						
						if(choice.toLowerCase().equals("property")) {
    						System.out.println("Enter the property ID you'd like to review!");
    						String property = scanner.nextLine();
    						
    						for(int i = 0; i <listings.size(); i++) {
    								
    								listing = listings.getListing(i);
    								String listingId = listing.getInternalId();
    								
    								if(property == listingId) {
    										
    										String review = scanner.nextLine();
    										String firstname = student.getFirstName();
    										String lastname = student.getLastName();
    										String author = firstname + lastname;
    										listing.addReview(author, review);
    										return;
    								}
    						}
    						System.out.println("Property not found.");
						
						} else if(choice.toLowerCase().equals("owner")) {
						  
  							System.out.println("Enter the owner's email so you can review them!");
  							String ownerreview = scanner.nextLine();
  							
  							for(int i = 0; i <accounts.size(); i++) {
  									
  									currentaccount = accounts.getAccount(i);
  									String email = ((Owner) currentaccount).getEmail();
  									owner  = (Owner) currentaccount;
  									
  									if(ownerreview == email) {
  											
  											String authorfirst = student.getFirstName();
  											String authorlast = student.getLastName();
  											String author = authorfirst + authorlast;
  											String review = scanner.nextLine();
  											
  											owner.addReview(author, review);
  											return;
  									}
  							}
						}	
				}
				
				if(type.equals("11")) {
						
						System.out.println("Enter the account ID of the Student you'd like to review!");
						String studentId = scanner.nextLine();
						
						for(int i = 0; i <accounts.size(); i++) {
								
								currentaccount = accounts.getAccount(i);
								String accountId = currentaccount.getInternalId();
								
								if(studentId == accountId) {
										String firstname = owner.getFirstName();
										String lastname = owner.getLastName();
										String author = firstname + lastname;
										String review = scanner.nextLine();
										student.addReview(author, review);
										return;
								}
						}
						
						System.out.println("Student not found.");
				}
		}
		
		/**
		 * 
		 */
		private void createListing() {
				
				String listingId = assignID();
				String ownerId = owner.getInternalId();
				System.out.println("Please enter the property's name.");
				String name = scanner.nextLine();
				System.out.println("Please enter the property's phone number for contact");
				String phone = scanner.nextLine();
				System.out.println("Please enter the property's email for contact");
				String email = scanner.nextLine();
				System.out.println("Please enter the property's landlord");
				String landlord = scanner.nextLine();
				System.out.println("Please enter the property's address");
				String address = scanner.nextLine();
				System.out.println("Please enter the property's zip code");
				String zip = scanner.nextLine();
				System.out.println("Please enter the maximum damages deposit");
				double damagesCost = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Please enter the property's availability");
				int availability = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Please enter the property's rent");
				double rent = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Please enter a description about the property");
				String description = scanner.nextLine();
				System.out.println("How many bedrooms does the listing have");
				int bedrooms = scanner.nextInt();
				scanner.nextLine();
				System.out.println("How many bathrooms does the listing have");
				double bathrooms = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Does the listing have a washer and dryer? 'y' or 'n'?");
				String washer = scanner.nextLine();
				boolean boolwasher;
				if(washer.equals("y")) {
						boolwasher = true;
				} else {
						boolwasher = false;
				}
				System.out.println("Is the listing have pet friendly? 'y' or 'n'?");
				String petfriendly = scanner.nextLine();
				boolean boolpetfriendly;
				if(petfriendly.equals("y")) {
						boolpetfriendly = true;
				} else {
						boolpetfriendly = false;
				}
				System.out.println("Does the listing have a pool? 'y' or 'n'?");
				String pool = scanner.nextLine();
				boolean boolpool;
				if(pool.equals("y")) {
						boolpool = true;
				} else {
						boolpool = false;
				}
				System.out.println("Does the listing have a short walk to campus? 'y' or 'n'?");
				String walk = scanner.nextLine();
				boolean boolwalk;
				if(walk.equals("y")) {
						boolwalk = true;
				} else {
						boolwalk = false;
				}
				System.out.println("Does the listing have a gym? 'y' or 'n'?");
				String gym = scanner.nextLine();
				boolean boolgym;
				if(gym.equals("y")) {
						boolgym = true;
				} else {
						boolgym = false;
				}
				System.out.println("Does the listing have free WiFi? 'y' or 'n'?");
				String wifi = scanner.nextLine();
				boolean boolwifi;
				if(wifi.equals("y")) {
						boolwifi = true;
				} else {
						boolwifi = false;
				}
				System.out.println("Is the listing well furnished? 'y' or 'n'?");
				String furnished = scanner.nextLine();
				boolean boolfurnished;
				if(furnished.equals("y")) {
						boolfurnished = true;
				} else {
						boolfurnished = false;
				}
				
				Listing thisListing = new Listing(listingId, ownerId, name, description, rent, phone, email, landlord, address, zip, damagesCost, availability, bedrooms, bathrooms, boolwasher, boolpetfriendly, boolpool, boolwalk, boolgym, boolwifi, boolfurnished);
				Listings.getInstance().addListing(thisListing);
				
				boolean flag = true;
				while(flag) {
						
						System.out.println("Are there any extra fees? 'y' or 'n'?");
						String fees = scanner.nextLine();
				
						if(fees.equals("y")) {
								System.out.println("Please enter the fee name");
								String feename = scanner.nextLine();
								System.out.println("Please enter the fee cost");
								double cost = scanner.nextDouble();
								listing.addFee(feename, cost);
						} else {
								flag = false;
						}
				}
				
				boolean flag2 = true;
				while(flag2) {
						
				System.out.println("Is there any FAQ? 'y' or 'n'?");
				String faq = scanner.nextLine();
				
						if(faq.equals("y")) {
								System.out.println("Please enter the Question");
								String qeustion = scanner.nextLine();
								System.out.println("Please enter the Answer");
								String answer = scanner.nextLine();
								listing.addFaq(qeustion, answer);
						} else {
								flag2 = false;
						}
				}
				
				System.out.println("Listing created successfully!\n");
				System.out.println(thisListing); 
		}
		
		private void viewPartialProfile(String internalId, Account account) {
				String[] parts = internalId.split("-");
				String type = parts[0];
				if(type.equals("12")) {
						System.out.println(((Student) account).presentable());
						if(guest == true) {
								System.out.println("You must create an account to do this!");
								return;
						}
						System.out.println("Like this fellow Student? Type 'add' to add them to a roommate group! Hit enter to return to the list of profiles!");
						String add = scanner.nextLine();
						if(add.toLowerCase().equals("add")) {
								if(((Student) currentaccount).getRoommateGroupId() == null) {
										System.out.println("You need to create a roommate group before can add this person! Would you like to do this now? 'y' or 'n'");
										String create = scanner.nextLine();
										if(create.toLowerCase().equals("y")) {
										createRoommateGroup();
										} else {
												return;
										}
								} else {
										roommateGroup.addRoommate((Student) account);
								}
						} else {
								return;
						}
				}
				
		}
		
		private void results(ArrayList<Account> aFullSearch) {
				ArrayList<Account> fullSearch = aFullSearch;
				if(fullSearch.size() != 0) {
						for(int i = 0; i < fullSearch.size(); i++){
								if(fullSearch.get(i) == null) {
										break;
								}
								accountsList[i] = fullSearch.get(i).toString();
								internalIds[i] = fullSearch.get(i).getInternalId();
								account[i] = fullSearch.get(i);
						}
				} else {
						System.out.println("No results found!");
						return;
				}
				if(guest == true) {
						this.type = "12";
				}
				if(type.equals("12") || type.equals("11")) {
						System.out.println("Here are the accounts that matched your result!");
				displayMenu(accountsList);
				
				}
				}
		/**
		 * 
		 */
		private void search(String aSearch) {
				ArrayList<Account> fullSearch = null;
				if(aSearch.toLowerCase().equals("a")){
						System.out.println("Enter the first name and last name of the user. If you know one of the names but not the other one enter it anyways.");
						String name = scanner.nextLine();
						if(!name.contains(" ")) {
								System.out.println("Is this the 'first' or 'last' name?");
								String firstlast = scanner.nextLine();
								if(firstlast.toLowerCase().equals("first")) {
								fullSearch = SearchEngine.searchAccounts(accounts2, name, "");
								results(fullSearch);

								} else {
								fullSearch = SearchEngine.searchAccounts(accounts2, "", name);
								results(fullSearch);

								}
						} else {
						String[] parts = name.split(" ");
						String firstname = parts[0];
						String lastname = parts[1];
						fullSearch = SearchEngine.searchAccounts(accounts2, firstname, lastname);
						results(fullSearch);
						
						}
							} 
				if(aSearch.toLowerCase().equals("o")) {
						System.out.println("Enter the first name of the owner");
						String name = scanner.nextLine();
						fullSearch = searchEngine.searchOwnerAccounts(accounts2, name);
						results(fullSearch);
				}
				if(aSearch.toLowerCase().equals("l")) {
						System.out.println("---Listing Search! Press 11 to perform Search!---");
						String name = "";
						double bathrooms = 0;
						int bedrooms = 0;
						while(true) {
						displayMenu(searchMenu);
						int command = getCommand(searchMenu.length);
				
						if(command == -1) {
								System.out.println("Not a valid command");
								continue;
						}
						
						if(command == searchMenu.length -1)
								break;
						
						switch(command) {
						case 1:
								System.out.println("Enter the name of the Listing");
								name = scanner.nextLine();
								break;
						case 2:
								System.out.println("Enter the number of Bathrooms");
								bathrooms = scanner.nextDouble();
								scanner.nextLine();
								break;
						case 3:
								System.out.println("Enter the number of Bedrooms");
								bedrooms = scanner.nextInt();
								scanner.nextLine();
								break;
						case 4:
								System.out.println("Do you want a pool? (Y/N)");
								this.pooltf = true;
								String poolyn = scanner.nextLine();
								if(poolyn.toLowerCase().equals("y")) {
										this.pool = true;
								} else {
										this.pool = false;
								}
								break;
						case 5:
								System.out.println("Pet friendly? (Y/N)");
								this.petFriendly = true;
								String petyn = scanner.nextLine();
								if(petyn.toLowerCase().equals("y")) {
										this.pet = true;
								} else {
										this.pet = false;
								}
								break;
						case 6:
								System.out.println("Do you want free wifi? (Y/N)");
								this.freeWifi = true;
								String wifiyn = scanner.nextLine();
								if(wifiyn.toLowerCase().equals("y")) {
										this.wifi = true;
								} else {
										this.wifi = false;
								}
								break;
						case 7:
								System.out.println("Do you want a washer and dryer? (Y/N)");
								this.washerDryer = true;
								String washeryn = scanner.nextLine();
								if(washeryn.toLowerCase().equals("y")) {
										this.washer = true;
								} else {
										this.washer = false;
								}
								break;
						case 8:
								System.out.println("Do you want to be within a walking distance of campus? (Y/N)");
								this.walkcampus = true;
								String walkyn = scanner.nextLine();
								if(walkyn.toLowerCase().equals("y")) {
										this.walk = true;
								} else {
										this.walk = false;
								}
								break;
						case 9:
								System.out.println("Do you want a gym? (Y/N)");
								this.gymtf = true;
								String gymyn = scanner.nextLine();
								if(gymyn.toLowerCase().equals("y")) {
										this.gym = true;
								} else {
										this.gym = false;
								}
								break;
						case 10:
								System.out.println("Do you want a furnished building? (Y/N)");
								this.furnishedtf = true;
								String furnishedyn = scanner.nextLine();
								if(furnishedyn.toLowerCase().equals("y")) {
										this.furnished = true;
								} else {
										this.furnished = false;
								}break;
						case 11:
							//ListingLoader.load();
							ArrayList<Listing>listingsToSearch = new ArrayList<Listing>();
							  Listings listingsToStore = Listings.getInstance();
							  Iterator<Saveable> listingIterator = listingsToStore.iterator();
							
							  int counter = 0;
							  while (listingIterator.hasNext()) {
								  Listing currentListing = listingsToStore.getListing(counter);
								  listingsToSearch.add(currentListing);
								  listingIterator.next();
								  counter++;
							  }
								ArrayList<Listing> listingSearchResults = new ArrayList<Listing>();
								listingSearchResults = searchEngine.searchListings(listingsToSearch, name, bedrooms, bathrooms, washerDryer, washer, petFriendly, pet, pooltf, pool, walkcampus, walk, gymtf, gym, freeWifi, wifi, furnishedtf, furnished);
								
								if (listingSearchResults.size() > 0) {
									
									for (int i = 0; i < listingSearchResults.size(); i++) {
										
										System.out.println("-----Listing #" + (i+1) + "-----------------------------------");
										System.out.println(listingSearchResults.get(i).toString());
									}
									System.out.println("Would you like to sign a lease with any of these results? (Y/N)");
									String leaseYN = scanner.nextLine().toLowerCase();
									
									if (leaseYN.equals("y")) {
										
										System.out.println("Which listing would you like to sign a lease with? (Enter in the number)");
										int leaseNumber = scanner.nextInt()-1;
										scanner.nextLine();
										
										if (guest == true) {
											System.out.println("You must be a registered user in order to sign a lease" + "\n");
											return;
										}
										
										createLeaseAgreement(listingSearchResults.get(leaseNumber));
										

										listingSearchResults = new ArrayList<Listing>();
										
										return;
										
										
									} 
									if (leaseYN.equals("n")) {
										listingSearchResults = new ArrayList<Listing>();
										
										return;
									}
									
								} else {
									System.out.println("There were not results for your search.");
								}
								
								
								
								
								listingSearchResults = new ArrayList<Listing>();
								
								return;
						}
				}
				}
				}
		
		private void createLeaseAgreement(Listing listing) {
			// TODO Auto-generated method stub
							String landlord =listing.getLandLord();
							String firstName = currentaccount.getFirstName();
							String lastName = currentaccount.getLastName();
							String name = firstName + " " + lastName;
							System.out.println("Do you want to add another student to lease? 'y' or 'n'");
							String add = scanner.nextLine();
							if(add.toLowerCase().equals("y")) {
									System.out.println("Enter the number of students to add on the lease");
									int students = scanner.nextInt();
									scanner.nextLine();
									for(int i = 1; i < students+1; i++) {
											System.out.println("Enter in the name of student " + i);
											leaseNames[i] = scanner.nextLine();
									}
							}
							leaseNames[0] = name;
							int numOfBeds = listing.getNumBedrooms();
							double numOfBaths = listing.getNumBathrooms();
							String address = listing.getAddress();
							String zipCode = listing.getZipCode();
							System.out.println("Enter start date of lease");
							String startdate = scanner.nextLine();
							System.out.println("Enter end date of lease");
							String enddate = scanner.nextLine();
							double rentpermonth = listing.getRentPerMonth();
							double damagescost = listing.getDamagesCost();
							LeaseGenerator generator = new LeaseGenerator();
							generator.fillLeaseTemplate(landlord, leaseNames, numOfBeds, numOfBaths, address, zipCode, startdate, enddate, rentpermonth, damagescost);
								
					
					return;
					}				
		
		/**
		 * 
		 */
		private void viewRoomateGroup() {
				System.out.println("Enter the roommate group ID to view your members!");
				student.getRoommateGroupId();
		}
		
		/**
		 * 
		 * @param a
		 */
		private void displayMenu(String[] a) {
				if(a == mainMenuStudent || a == mainMenuParent || a == mainMenuOwner) {
						System.out.println("\n***** Main Menu *****");
				} else {
						System.out.println("");
				}
				int numOfElements = 0;
				for(int j = 0; j < a.length; j++) {
						if(a[j] != null) {
								numOfElements++;
						} else {
								break;
						}
				}
				for(int i = 0; i < numOfElements; i++) {
						System.out.println((i+1) + ". " + a[i]);
				}
				System.out.println("\n");
		}
		
		/**
		 * 
		 * @param numOfItems
		 * @return
		 */
		private int getCommand(int numOfItems) {
				
				System.out.println("What would you like to do?: ");
				String input = scanner.nextLine();
				int command = Integer.parseInt(input);
				
				if(command >= 0 && command <= numOfItems) {
						return command;
				}
				return -1;
		}
		
		/**
		 * 
		 * @param args
		 */
		public static void main(String[] args) {
				// TODO Auto-generated method stub
				BoroughUI borough = new BoroughUI();
				ListingLoader.load();
				borough.run();
				
		}

}
package main.java.database;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.accounts.Account;
import main.java.accounts.Owner;
import main.java.accounts.Parent;
import main.java.accounts.Student;

class AccountLoaderTest {
	AccountLoader al = new AccountLoader();
	private Accounts accountsList = Accounts.getInstance();
	private ArrayList<Saveable> accounts = accountsList.getAccount();
	ArrayList<String> notification = new ArrayList<String>();
	ArrayList<String> listingId = new ArrayList<String>();
	ArrayList<String> childrenId = new ArrayList<String>();
	ArrayList<String> parentId = new ArrayList<String>();
	ArrayList<String> watchList = new ArrayList<String>();
	

	@BeforeEach
	void setUp() throws Exception {
		accounts.clear();
		notification.add("This is a notification");
		listingId.add("This is the listin iD");
		childrenId.add("This is the children's iD");
		parentId.add("This is the parent's iD");
		watchList.add("This is the watchList");
		accounts.add(new Student("12-00000001", "first","last", "01/01/2000", "1234 Street", "843-240-1234", "student@email.com", parentId, watchList, "roommateGroupId", notification));
		accounts.add(new Parent("13-00000002", "first","last", "01/01/1970", "5678 Street", "843-240-5678", "parent@email.com", childrenId, watchList, notification));
		accounts.add(new Owner("11-00000003", "name", "manager", "owner@email.com", listingId, notification));
		DataWriter.save(accounts, "src/main/resources/accounts.json");
		al.load();
	}

	@AfterEach
	void tearDown() throws Exception {
		Accounts.getInstance().getAccount().clear();
		DataWriter.save(accounts, "src/main/resources/accounts.json");
	}

	@Test
	void testGetUsersSizeZero() {
		Accounts.getInstance().getAccount().clear();
		DataWriter.save(accounts, "src/main/resources/accounts.json");
		assertEquals(0, accounts.size());
	}
	
	@Test
	void testGetUsersSize() {
		assertEquals(6, accounts.size());
	}
	
	@Test
	void testAccountInternalId() {
		assertEquals("12-00000001", ((Student) accounts.get(0)).getInternalId());
		assertEquals("13-00000002", ((Parent) accounts.get(1)).getInternalId());
		assertEquals("11-00000003", ((Owner) accounts.get(2)).getInternalId());
	}
	
	@Test
	void testAccountFirstName() {
		assertEquals("first", ((Student) accounts.get(0)).getFirstName());
		assertEquals("first", ((Parent) accounts.get(1)).getFirstName());
	}
	
	@Test
	void testAccountName() {
		assertEquals("name", ((Owner) accounts.get(2)).getName());
	}
	
	@Test
	void testAccountDateOfBirth() {
		assertEquals("01/01/2000", ((Student) accounts.get(0)).getDateOfBirth());
		assertEquals("01/01/1970", ((Parent) accounts.get(1)).getDateOfBirth());
	}
	
	@Test
	void testAccountAddress() {
		assertEquals("1234 Street", ((Student) accounts.get(0)).getAddress());
		assertEquals("5678 Street", ((Parent) accounts.get(1)).getAddress());
	}
	
	@Test
	void testAccountPhoneNumber() {
		assertEquals("843-240-1234", ((Student) accounts.get(0)).getPhoneNumber());
		assertEquals("843-240-5678", ((Parent) accounts.get(1)).getPhoneNumber());
	}
	
	@Test
	void testAccountEmail() {
		assertEquals("student@email.com", ((Student) accounts.get(0)).getEmail());
		assertEquals("parent@email.com", ((Parent) accounts.get(1)).getEmail());
		assertEquals("owner@email.com", ((Owner) accounts.get(2)).getEmail());
	}
	
	@Test
	void testAccountId() {
		assertEquals(parentId, ((Student) accounts.get(0)).getParentIds());
		assertEquals(childrenId, ((Parent) accounts.get(1)).getChildrenIds());
		assertEquals(listingId, ((Owner) accounts.get(2)).getListingIds());
	}
	
	@Test
	void testAccountWatchList() {
		assertEquals(watchList, ((Student) accounts.get(0)).getWatchListIds());
		assertEquals(watchList, ((Parent) accounts.get(1)).getWatchListIds());
	}
	
	@Test
	void testAccountRoommateGroupId() {
		assertEquals("roommateGroupId", ((Student) accounts.get(0)).getRoommateGroupId());
	}
	
	@Test
	void testAccountNotification() {
		assertEquals(notification, ((Student) accounts.get(0)).getNotifications());
		assertEquals(notification, ((Parent) accounts.get(1)).getNotifications());
		assertEquals(notification, ((Owner) accounts.get(2)).getNotifications());
	}
}

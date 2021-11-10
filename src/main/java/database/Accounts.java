package main.java.database;

import java.util.ArrayList;
import java.util.Iterator;
import main.java.accounts.Account;

/**
 * Parses JSON data on initialization and holds a list of all Accounts
 *
 * <p>Operates as a singleton, only one instance exists, so use method getInstance() to obtain it
 *
 * @author Elijah Burke
 */
public class Accounts implements Iterable<Saveable> {

  private static ArrayList<Saveable> accounts;
  private static Accounts accountsList;

  /**
   * Accounts is a singleton, therefore the constructor is private Use getInstance() to get the
   * single instance
   */
  private Accounts() {

    accounts = new ArrayList<Saveable>();
  }

  /**
   * Returns THE instance of the list of accounts
   *
   * @return the instance of Accounts
   */
  public static Accounts getInstance() {

    // Actually create the accounts list if it does not exist already
    if (accountsList == null) {

      accountsList = new Accounts();
    }

    return accountsList;
  }

  public static void addAccount(Account account) {
    accounts.add(account);
  }
  
public static void removeAccount(Account account) {
	  accounts.remove(account);
  }

  /**
   * Retrieves the Account at the specified index
   *
   * @param index location of the Account to retrieve
   * @return the instance of Account at the specified index
   */
  public static Account getAccount(int index) {

    return (Account) accounts.get(index);
  }
  

  /**
   * Returns an int that is the size of the ArrayList of accounts contained within this class
   *
   * @return size of the list of accounts
   */
  public static int size() {

    return accounts.size();
  }

  @Override
  /**
   * Implementation of Iterable, returns the iterator
   *
   * @return an ACcount Iterator
   */
  public Iterator<Saveable> iterator() {

    return accounts.iterator();
  }
  
  public ArrayList<Saveable> getAccount() {
	  return accounts;
  }
}

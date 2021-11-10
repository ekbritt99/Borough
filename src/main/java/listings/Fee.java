package main.java.listings;

/**
 * Class to represent an entry in a listing's additional fees section, comprised of a fee and its
 * cost
 *
 * @author Elijah Burke
 */
public class Fee {

  private String name;
  private double cost;

  /**
   * Creates a new fee from a from a name and cost
   *
   * @param name the String representing the name, cannot be empty
   * @param cost the String representing the cost, must be greater than 0
   */
  protected Fee(String name, double cost) {

    this.setName(name);
    this.setCost(cost);
  }

  /**
   * Retrieves this fee's name
   *
   * @return the String representing this fee's name
   */
  public String getName() {

    return this.name;
  }

  /**
   * Retrieves this fee's cost
   *
   * @return the String representing this fee's cost
   */
  public double getCost() {

    return this.cost;
  }

  /**
   * Sets name to argument, unless argument is an empty string, in which case an error message is
   * returned
   *
   * @param name the String to set the name to
   */
  protected void setName(String name) {

    if (name.isEmpty()) {

      System.out.println("Fee name must not be empty");
      /**
       * If Fee name is ever an empty String, a NullPointerException will be thrown when the
       * listings are loaded in from the JSON file. I believe this is because the JSON parser we're
       * using stores empty Strings as "null" in the .json file. TODO this fix is fine for now, but
       * I want to make it safer in the future.
       */
      this.name = " ";
    } else {

      this.name = name;
    }
  }

  /**
   * Sets cost to argument, unless argument is less than or equal to 0, in which case an error
   * message is returned
   *
   * @param cost the double to set the cost to
   */
  protected void setCost(double cost) {

    if (cost > 0) {

      this.cost = cost;
    } else {

      System.out.println("Fee cost must be greater than 0");
    }
  }

  /**
   * Returns a String representation of the fee
   *
   * @return a formatted String with the fee's name and cost
   */
  public String toString() {

    return this.getName() + ":\t$" + this.getCost() + "\n";
  }

  /**
   * Determines if two fees are equal
   *
   * @param fee the fee to compare the calling instance against
   * @return true if the fees are equal
   * @return false if the fees are not equal
   */
  public boolean equals(Fee fee) {

    return this.getName().equals(fee.getName()) && (this.getCost() == fee.getCost());
  }
}

package main.java.listings;

/**
 * Class to represent an entry in a listing's FAQ section, comprised of a question and its answer
 *
 * @author Elijah Burke
 */
public class Faq {

  private String question;
  private String answer;

  /**
   * Creates a new FAQ from a question and its answer
   *
   * @param question the String representing the question, cannot be empty
   * @param answer the String representing the answer, cannot be empty
   */
  protected Faq(String question, String answer) {

    this.setQuestion(question);
    this.setAnswer(answer);
  }

  /**
   * Retrieves this FAQ's question
   *
   * @return the String representing this FAQ's question
   */
  public String getQuestion() {

    return this.question;
  }

  /**
   * Retrieves this FAQ's question
   *
   * @return the String representing this FAQ's answer
   */
  public String getAnswer() {

    return this.answer;
  }

  /**
   * Sets question to argument, unless argument is an empty string, in which case an error message
   * is returned
   *
   * @param question the String to set the question to
   */
  protected void setQuestion(String question) {

    if (question.isEmpty()) {

      System.out.println("FAQ question must not be empty");
      /**
       * If Faq question is ever an empty String, a NullPointerException will be thrown when the
       * listings are loaded in from the JSON file. I believe this is because the JSON parser we're
       * using stores empty Strings as "null" in the .json file. TODO this fix is fine for now, but
       * I want to make it safer in the future.
       */
      this.question = " ";
    } else {

      this.question = question;
    }
  }

  /**
   * Sets answer to argument, unless argument is an empty string, in which case an error message is
   * returned
   *
   * @param answer the String to set the answer to
   */
  protected void setAnswer(String answer) {

    if (answer.isEmpty()) {

      System.out.println("FAQ answer must not be empty");
      /**
       * If Faq answer is ever an empty String, a NullPointerException will be thrown when the
       * listings are loaded in from the JSON file. I believe this is because the JSON parser we're
       * using stores empty Strings as "null" in the .json file. TODO this fix is fine for now, but
       * I want to make it safer in the future.
       */
      this.answer = " ";
    } else {

      this.answer = answer;
    }
  }

  /**
   * Returns a String representation of the FAQ
   *
   * @return A formatted String with the FAQ's question and answer
   */
  public String toString() {

    return "Q:\t" + this.getQuestion() + "\nA:\t" + this.getAnswer() + "\n";
  }

  /**
   * Determines if two FAQs are equal
   *
   * @param faq the FAQ to compare the calling instance against
   * @return true if the two FAQs are equal
   * @return false if the two FAQs are not equal
   */
  public boolean equals(Faq faq) {

    return this.getQuestion().equals(faq.getQuestion()) && this.getAnswer().equals(faq.getAnswer());
  }
}

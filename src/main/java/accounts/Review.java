package main.java.accounts;

import main.java.listings.Listing;

/**
 * 
 * @author josephbrancker
 *
 */
public class Review {
		
		private String author;
		private String description;

		public Review(String author, String description) {
			this.setAuthor(author);
			this.setDescription(description);
		}
		
		public String getAuthor() {
				return this.author;
		}
		
		public String getDescription() {
			 return this.description;
		}
		
		public void setAuthor(String author) {
			 this.author = author;
		}
		
		public void setDescription(String description) {
			 this.description = description;
		}
		
		public String toString() {
			String formattedString = "Author: " + this.author + "\n";
			formattedString += "Description: " + this.description;
			return formattedString;
		}
}

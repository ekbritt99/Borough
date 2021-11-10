package main.java.database;
import java.io.File;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class LeaseGenerator {
	
	private static final String DELIM = " ";

		//method to read from a text file
		public void fillLeaseTemplate(String landLoard, String[] tenantNames, int numBed, 
				double numBath, String address, String zipCode, String startDate, String endDate,
				double rentPerMonth, double damageCost) {
			
			//setup necessary components to retrieve the current date
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		    Date dateobj = new Date();
		    
			
			try
			{
				//create a scanner to read a text file which is specified by the user
				Scanner fileScanner = new Scanner(new File("./src/main/resources/lease_agreement_template.txt"));
				//variables for current line and it's split up form
				String fileLine;
				String[] splitLines;
				
				//get all the tenant names in a string for the file name
				String allTenantNames = "";
				for (int l = 0; l < tenantNames.length; l++) {
					if (tenantNames[l] != null) {
						allTenantNames += tenantNames[l];
						if (l < tenantNames.length-1) {
						allTenantNames += "_";
						}
					} else {
						break;
					}
					
				}
				
				//create printWriter to write the lease to a text file
				PrintWriter fileWriter = new PrintWriter(new FileOutputStream("./src/main/resources/Lease-" + allTenantNames + ".txt"));
				
				//read the body
				while (fileScanner.hasNextLine())
				{
					//get the next line in the file
					fileLine = fileScanner.nextLine();
					//split the line into individual words
					splitLines = fileLine.split(DELIM);
					//iterate through all of the words and replace placeholders with corresponding information
					for (int i = 0; i < splitLines.length; i++) {
						
						if (splitLines[i].equals("<DATE>")) {
							
							splitLines [i] = dateFormat.format(dateobj);
						}
						
						if (splitLines[i].equals("<LANDLOARD>")) {
							
							splitLines[i] = landLoard;
						}
						
						if (splitLines[i].equals("<TENANT(s)>.")) {
							
							String allTenantNamesLease = "";
							for (int j = 0; j < tenantNames.length; j++) {
								if (tenantNames[j] != null) {
									allTenantNamesLease += tenantNames[j];
									if (j < tenantNames.length-1 && tenantNames[j+1] != null) {
										allTenantNamesLease += ", ";
									}
								} else {
									break;
								}
								
							
							}
							
							splitLines[i] = allTenantNamesLease;
						}
						
						if (splitLines[i].equals("<NUM_BED>")) {
							
							splitLines[i] = Integer.toString(numBed);
						}
						
						if (splitLines[i].equals("<NUM_BATH>")) {
							
							splitLines[i] = Double.toString(numBath);
						}
						
						if (splitLines[i].equals("<PROPERTY_ADDRESS>,")) {
							
							splitLines[i] = address;
						}
						
						
						if (splitLines[i].equals("<ZIP>.")) {
							
							splitLines[i] = zipCode;
						}
						
						
						if (splitLines[i].equals("<START_DATE>")) {
							
							splitLines[i] = startDate;
						}
						
						if (splitLines[i].equals("<END_DATE>.")) {
							
							splitLines[i] = endDate;
						}
						
						if (splitLines[i].equals("<RENT>")) {
							
							splitLines[i] = Double.toString(rentPerMonth);
						}
						
						
						if (splitLines[i].equals("<DAMAGE_COST>.")) {
							
							splitLines[i] = Double.toString(damageCost);
						}
						
						if (splitLines[i].equals("<TENANT_1>")) {
							
							splitLines[i] = tenantNames[0];
						}
						
						if (splitLines[i].equals("<TENANT_X,_this_will_only_appear_if_applicable>")) {
							
							if (tenantNames.length <= 1) {
								
								splitLines[i] = "";
							} else {
								
								String restOfTenants = "";
								
								for (int n = 1; n < tenantNames.length; n++) {
									
									if (tenantNames[n] != null) {
										
										restOfTenants += tenantNames[n];
										if (n < tenantNames.length-1 && (tenantNames[n + 1] != null)) {
								
											restOfTenants += ", ";
										}
									} else {
										break;
									}
								}
								splitLines[i] = restOfTenants;
							}
						}
			
					}
					
					String lineToWrite = "";
					
					for (int k = 0; k < splitLines.length; k++) {
						lineToWrite += splitLines[k] + DELIM;
					}
					
					fileWriter.println(lineToWrite);
					
				}
				
				//close the file scanner
				fileScanner.close();
				fileWriter.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}

package main.java.database;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

/**
 * A class to load data from a JSON file into a JSON array, borrowed heavily (basically copied) from
 * the example provided by Portia :) https://github.com/portiaportia/JsonParser
 *
 * <p>If you're trying to load listings or accounts from their respective JSON files, use this
 * class's children, ListingLoader or AccountLoader, respectively
 *
 * <p>This class is remaining instantiable (TODO check if "instantiable" is a word) for now, this is
 * because a time could come when data needs to be read that isn't Account or Listing. However,
 * should that happen, such a class would most likely be such an essential part of the system that
 * it would be worth it to extend this class. Whatever, I'll hear arguments for both sides.
 *
 * @author Elijah Burke
 */
public class DataLoader {

  /**
   * Loads a list of save data from a JSON file
   *
   * <p>The file should exist at the top level as a single array, anything else is currently unsupported
   *
   * @param fileName a String specifying the path of the JSON file to load from
   * @return A JSONArray to be parsed
   */
  public static JSONArray load(String fileName) {

    try {

      FileReader reader = new FileReader(fileName);
      JSONParser parser = new JSONParser();
      Scanner fileScanner = new Scanner(new File(fileName));
      if(fileScanner.hasNext() == false) {
      		return null;
      }
      JSONArray saveJSON = (JSONArray) new JSONParser().parse(reader);

      return saveJSON;

    } catch (Exception e) {
    	
      e.printStackTrace();
      
    }

    return null;
  }
}

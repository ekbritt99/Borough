package main.java.database;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;

/**
 * A class to write data to a JSON file through a JSON array, borrowed heavily (basically copied)
 * from the example provided by Portia :) https://github.com/portiaportia/JsonParser
 *
 * @author Elijah Burke
 */
public class DataWriter {

  /**
   * Saves a JSONArray to the .json file specified by fileName
   *
   * @param jsonData a JSONArray to be saved
   * @param fileName the path to the .json file where the data will be saved
   */
  public static void save(Iterable<Saveable> collection, String fileName) {

    // Create a JSONArray to hold the JSONObjects
    JSONArray jsonData = new JSONArray();

    // Loops through every listing in the passed-in array and adds it to jsonListings
    for (Saveable item : collection) {

      // Convert this listing to a JSONObject and add it to the array
      jsonData.add(item.toJSONObject());
    }

    // Create a new FileWriter from fileName
    try (FileWriter file = new FileWriter(fileName)) {

      // Write the JSONArray to the file
      file.write(jsonData.toJSONString());
      file.flush();

    } catch (IOException e) {

      e.printStackTrace();
    }
  }
}

package main.java.database;

import org.json.simple.JSONObject;

/**
 * An interface that defines objects as saveable, characterized by the ability to convert itself to
 * a JSONObject
 *
 * @author Elijah Burke
 */
public interface Saveable {

  public JSONObject toJSONObject();
}

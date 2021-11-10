package main.java.database;

import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.util.Constants;

class DataLoaderTest {
		public static final String TestJSON_FILE = "src/main/resources/TestJSON.json";
		private String JSONArrayContents;
		DataLoader dl = new DataLoader();
		JSONArray ja = new JSONArray();
		
		@BeforeEach
		void setUp() throws Exception {
		  JSONArrayContents = "[{\"firstName\":\"Joseph\"},{\"firstName\":\"Ethan\"},{\"firstName\":\"Alfred\"}]";
		}
		
		
		@AfterEach
		void tearDown() throws Exception {
			// nothing to tear down
		}
		
		@Test
		//tests the dataloader for TestJSON_FILE
		void testJSONLoad() {
				JSONArray ja2 = dl.load(TestJSON_FILE);
				assertEquals(JSONArrayContents, ja2.toString());
		}
		
		@Test
		//tests the dataloader for file that doesn't exist
		void testIncorrectJSONLoad() {
				JSONArray ja3 = dl.load("ThisIsNotAFile");
				assertEquals(null, ja3);
		}
}

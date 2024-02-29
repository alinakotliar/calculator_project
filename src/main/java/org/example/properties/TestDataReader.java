package org.example.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDataReader {
    private static final String TEST_DATA_FILE = "/test-data.properties";

    private static Properties properties = new Properties();

    static {
        try (InputStream input = TestDataReader.class.getResourceAsStream(TEST_DATA_FILE)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception appropriately based on your needs
        }
    }

    public static String getNumberOfInstances() {
        return properties.getProperty("number.of.instances");
    }

    public static String getPurposeOfInstances() {
        return properties.getProperty("purpose.of.instances");
    }
}

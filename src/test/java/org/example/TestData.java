package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestData {

        private static Properties properties = new Properties();

        static {
            try (InputStream input = TestData.class.getClassLoader().getResourceAsStream("test-data.properties")) {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace(); // Handle exception appropriately based on your needs
            }
        }

        public static String getSearchKeyword() {
            return properties.getProperty("search.keyword");
        }
    public static String getNumberOfInstances() {
        return properties.getProperty("number.of.instances");
    }

    public static String getPurposeOfInstances() {
        return properties.getProperty("purpose.of.instances");
    }
    }

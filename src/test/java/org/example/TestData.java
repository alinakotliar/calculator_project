package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestData {

    private static TestData instance;
    private Properties properties = new Properties();

    private TestData() {
        try (InputStream input = TestData.class.getClassLoader().getResourceAsStream("test-data.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized TestData getInstance() {
        if (instance == null) {
            instance = new TestData();
        }
        return instance;
    }

    public String getSearchKeyword() {
        return properties.getProperty("search.keyword");
    }

    public String getNumberOfInstances() {
        return properties.getProperty("number.of.instances");
    }

    public String getPurposeOfInstances() {
        return properties.getProperty("purpose.of.instances");
    }
    }

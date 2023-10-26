package org.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.example.stepdefinitions"},
        plugin = {"pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

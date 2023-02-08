package com.vmarquezv.dev.calculateShipping.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"},
		features = {"src/test/resources/features"},
        glue = {"com.vmarquezv.dev.calculateShipping.cucumber.cucumberglue"}
		)
public class CucumberRunnerTest {
}

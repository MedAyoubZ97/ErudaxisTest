package com.erudaxisplanificationtests.automation;

import org.junit.runner.RunWith;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/spec/features"},
		plugin = {"pretty",
				"html:target/cucumber-report.html",
				"json:target/cucumber-report.json",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
		tags = ("@ajoutConfig"),
		monochrome = true,
		snippets = CAMELCASE
		)

public class TestRunner {
	

}

package com.StepsDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"./Features/CountriesList.feature","./Features/Slidetesting.feature"},glue = "com.StepsDefinition")

public class TestRunner {

}

package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\amalr\\amal\\Cucumber\\src\\test\\java\\com\\feature\\nykaa.feature",
glue ="com.StepDefinition",monochrome = true)
public class Runner_Class {

}

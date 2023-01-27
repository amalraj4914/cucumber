package com.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	@Given("user can enter in to the  home page")
	public void user_can_enter_in_to_the_home_page() {
		System.out.println("user_can_enter_in_to_the_home_page");
	}
	@When("user can enter the valid email address")
	public void user_can_enter_the_valid_email_address() {
		System.out.println("user_can_enter_the_valid_email_address");
	}
	@When("user can enter the valid name and valid mobile number in field")
	public void user_can_enter_the_valid_name_and_valid_mobile_number_in_field() {
	System.out.println("user_can_enter_the_valid_name_and_valid_mobile_number_in_field");
	}
	@When("user can enter your password")
	public void user_can_enter_your_password() {
		System.out.println("user_can_enter_your_password");
	}
	@Then("take screenshot and quit the browser")
	public void take_screenshot_and_quit_the_browser() {
		System.out.println("take_screenshot_and_quit_the_browser");
	}




}

package sd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

import actionsFiles.MobileActions;

public class MobileStepDefin {

// create objects from other used classes
	MobileActions mobileActions = new MobileActions();
	
	@Given("I successfully connected to the mobile app")
	public void i_successfully_connected_to_the_mobile_app()  throws MalformedURLException, InterruptedException { 
		mobileActions.OpenApp();		
	}

	@When("I need to add {string} and {string}")
	public void i_need_to_add_and(String username, String password) {
		mobileActions.AddUsername(username);
		mobileActions.AddPassword(password);
	}

	@When("I Click on Login button")
	public void i_click_on_login_button() {
		mobileActions.ClickLogin();
	}

	@Then("I assert the Home Page with finding items")
	public void i_assert_the_home_page_with_finding_items() {
		mobileActions.CheckItems();
	}

	@Then("I assert Not going to the Home Page without finding items")
	public void i_assert_not_going_to_the_home_page_without_finding_items() {
		mobileActions.CheckNOItems();
	}
}

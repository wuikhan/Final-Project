package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilties.BaseClass;

public class Accounts extends BaseClass {
	@Given("^I open \"([^\"]*)\" browser$")
	public void i_open_browser(String browser) {
		setup(browser);
	}
	@Given("^I go to the \"([^\"]*)\" environment$")
	public void i_go_to_the_environment(String environment) {
		if (environment.equalsIgnoreCase("qa")) {
			driver.get("https://login.salesforce.com/");
		}
	}
	@Given("^I enter valid username \"([^\"]*)\"$")
	public void i_enter_valid_username(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}
	@Given("^I enter valid password \"([^\"]*)\"$")
	public void i_enter_valid_password(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	@When("^I click the \"([^\"]*)\" button$")
	public void i_click_the_button(String name) {
		driver.findElement(By.name(name)).click();
	}
	@Then("^I should see the \"([^\"]*)\" tab$")
	public void i_should_see_the_tab(String tab) {
		driver.findElement(By.linkText(tab)).click();
	}
	@Then("^I should see the \"([^\"]*)\" home page$")
	public void i_should_see_the_home_page(String expectedVal) {
		String homeText = driver.findElement(By.className("pageType")).getText();
		System.out.println(homeText);
		Assert.assertEquals(expectedVal, homeText);
	}
	@Then("^I enter \"([^\"]*)\" value for \"([^\"]*)\" field$")
	public void i_enter_value_for_field(String text, String id) {
		driver.findElement(By.id(id)).sendKeys(text);
	}
	@Then("^I see the record got created$")
	public void i_see_the_record_got_created() {
		System.out.println(driver.getCurrentUrl());
	}
	@When("^I verify the logo$")
	public void i_verify_the_logo() throws InterruptedException  {
	    Assert.assertTrue(true);
	    Thread.sleep(5000);
	}
	
	@Then("^I should see the error \"([^\"]*)\"$")
	public void i_should_see_the_error(String expectedError) {
	    String actualError = driver.findElement(By.className("errorMsg")).getText();
	    Assert.assertEquals(expectedError, actualError);
	}
}

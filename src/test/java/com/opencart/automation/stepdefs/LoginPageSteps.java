package com.opencart.automation.stepdefs;

import com.opencart.automation.pages.LoginPage;
import com.opencart.automation.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class LoginPageSteps {

  private final LoginPage loginPage;

  public LoginPageSteps() {
    loginPage = PagesFactory.getInstance().getLoginPage();
  }

  @Given("the user is on the login page")
  public void theUserLoggedIn() {
    loginPage.navigateTo(LoginPage.PAGE_URL);
  }

  @And("the user enter the email {string} and password {string}")
  public void theUserEnterData(String email, String password) {
    loginPage.enterEmail(email);
    loginPage.enterPassword(password);
  }

  @When("the user clicks the login button")
  public void theUserClicksTheLoginButton() {
    loginPage.clickLogin();
  }

  @Then("the user is logged successfully")
  public void theUserIsLoggedSuccessfully() {
    String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
    Assert.assertEquals("The user is not logged in", "https://opencart.abstracta.us/index.php?route=account/account", currentUrl);
  }

  @Then("an error message appears")
  public void theUserShouldBeShownAnInvalidMessage() {
   Assert.assertTrue("No error message is displayed",loginPage.hasEmailPasswordError());
  }
}

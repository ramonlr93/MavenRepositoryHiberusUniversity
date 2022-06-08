package com.opencart.automation.stepdefs;

import com.opencart.automation.pages.HomePage;
import com.opencart.automation.pages.PagesFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@Slf4j
public class AddToCartSteps {

    private final PagesFactory pf = PagesFactory.getInstance();
    private static HomePage homePage;
    private final WebDriver driver = pf.getDriver();

    public AddToCartSteps() {
        homePage = PagesFactory.getInstance().getHomePage();
    }


    @Given("the user is on the home page")
    public void isOnHomePage(){
        homePage.navigateTo(HomePage.PAGE_URL);
    }

    @When("the user adds a MacBook from the home page to the cart")
    public void theUserAddsAMacBookFromTheHomePageToTheCart() throws InterruptedException {
        homePage.clickAddToCart();
        Thread.sleep(1000);
    }


    @Then("Item is successfully added to the cart")
    public void itemIsSuccessfullyAddedToTheCart() {
        String cartText = homePage.getTextCart();
        log.info(cartText);
        String empty = " 0 item(s) - $0.00";
        assertNotEquals("The product is not in the cart", cartText, empty);
    }
}
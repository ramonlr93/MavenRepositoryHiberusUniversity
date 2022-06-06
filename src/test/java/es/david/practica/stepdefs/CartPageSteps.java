package es.david.practica.stepdefs;

import es.david.practica.pages.CartPage;
import es.david.practica.pages.PagesFactory;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class CartPageSteps {

    PagesFactory pf = PagesFactory.getInstance();
    CartPage cp = pf.getCartPage();

    @Then("the total price should be the sum of all product prices")
    public void checkTotalPrice() {
        Assert.assertEquals("Total price isnt the sum of all product prices", cp.getTotalPrice(), cp.getTotalCalculatedPrice());
    }
}

package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends AbstractPage{
    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=common/home";

    @FindBy(id = "cart")
    private WebElement cartButton;

    InventoryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement(){
        return cartButton;
    }

    public void clickOnCart(){
        cartButton.click();
    }
}

package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/* MI CÓDIGO
@Slf4j
public class InventoryPage extends AbstractPage {
    public static final String PAGE_URL = "https://www.saucedemo.com";

    @FindBy(xpath = "//div[@class='inventory_item_description']")
    private List<WebElement> inventoryItems;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sortProductBtn;


//    @FindBy(id = "react-burger-menu-btn")
//    private WebElement menuBtn;

    InventoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void clickAddToCartButton(String itemName) {
        for (WebElement elm : inventoryItems) {
            elm.findElement(By.xpath("//button[contains(@id='add-"+itemName+"')]")).click();
        }
    }

    public void clickRemoveCartButton(String itemName) {
        for (WebElement elm : inventoryItems) {
            elm.findElement(By.xpath("//button[contains(@id='remove-"+itemName+"')]")).click();
        }
    }

    public void sortItemsBy(String order) {
        sortProductBtn.click();
        sortProductBtn.findElement(By.xpath("//option[@value='"+order+"']")).click();
    }

} */

// SOLUCIÓN JONATAN

public class InventoryPage extends AbstractPage {
  public static final String PAGE_URL = "https://www.saucedemo.com/inventory.html";

  @FindBy(xpath = "//button[text()='Open Menu']")
  private WebElement hamburgerElem;

  @FindBy(id = "shopping_cart_container")
  private WebElement shoppingCart;

  @FindBy(css = "#inventory_list")
  private WebElement inventoryContainer;

  @FindBy(xpath = "//select[@data-test='product_sort_container']")
  private WebElement selectOptions;

  public InventoryPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return inventoryContainer;
  }

  public void addItemToCartByName(String itemName) {
    String xpath = getButton(itemName);
    WebElement itemElem = getDriver().findElement(By.xpath(xpath));
    itemElem.click();
  }

  public void removeItemToCartByName(String itemName) {
    String xpath = getButton(itemName);
    WebElement itemElem = getDriver().findElement(By.xpath(xpath));
    itemElem.click();
  }

  private String getButton(String itemName) {
    return "//div[contains(., '" + itemName + "')]/parent::a/parent::div/following-sibling::div/button";
  }

  public void clickOnShoppingCart() {
    shoppingCart.click();
  }

  public void selectOption(String option) {
    Select selectOption = new Select(selectOptions);
    selectOption.selectByValue(option);
  }
}



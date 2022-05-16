package com.hiberus.university.selenium.pages.login;


import com.hiberus.university.selenium.pages.pages.LoginPage;
import com.hiberus.university.selenium.pages.pages.PagesFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class LoginSuiteTest {

    public static WebDriver driver;

    public static WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 500);
        PagesFactory.start(driver);
    }

    @Test
    public void loginTest() {
        driver.get(LoginPage.PAGE_URL);
        PagesFactory pf = PagesFactory.getInstance();
        LoginPage loginPage = pf.getLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

    }
}
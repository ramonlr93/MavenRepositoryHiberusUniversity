package com.hiberus.university.selenium.runner;

import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        plugin = {"pretty",
                "json:target/surefire-reports/cucumber.json",
                "html:target/cucumber-html-report.html"},
        glue = {"com.hiberus.university.selenium.stepdefs",
                "com.hiberus.university.selenium.support"},
        features = {"src/test/resources/"}
)
public class CucumberRunnerTest {

}

package com.hiberus.university.selenium.Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LoginIncorrect {

    public static WebDriver driver;
    private static final String URL = "https://www.saucedemo.com/";

    public void test() throws InterruptedException{
        // Validar Login Incorrecto

        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Ir a la página
        driver.get(URL);
        Thread.sleep(500);

        // Escribir el username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_use");
        Thread.sleep(500);

        // Escribir la contraseña
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(500);

        // Pulsar submit
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        Thread.sleep(500);

        // Comprobar si existe el error
        Boolean visualizaError = driver.findElement(By.xpath("//div[@class='error-message-container error']")).isDisplayed();
        System.out.println(driver.findElement(By.xpath("//div[@class='error-message-container error']")).isDisplayed()?
                "Se visualiza el mensaje de error":
                "No se visualiza el mensaje de error, prueba erronea");
        Thread.sleep(2000);

        // Cerrar
        driver.close();
    }

}

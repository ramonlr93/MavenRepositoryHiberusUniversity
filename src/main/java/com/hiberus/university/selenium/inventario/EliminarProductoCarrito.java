package com.hiberus.university.selenium.inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class EliminarProductoCarrito {

    public static WebDriver driver;
    public static void main( String[] args ) throws InterruptedException {

        //Paso 0
        //Inicie un nuevo navegador Chrome
        String userProfile= "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso 1
        //Ir a la página https://www.saucedemo.com
        driver.get("https:/www.saucedemo.com/");

        //Paso 2
        //Escribir el username standard_user
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        Thread.sleep(1000);

        //Paso 3
        //Escribir el password secret_sauce
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        Thread.sleep(1000);

        //Paso 4
        //Pulsar en el botón del Login.
        WebElement clickButton = driver.findElement(By.id("login-button"));
        clickButton.click();

        Thread.sleep(1000);

        //Paso 5
        //Agregar al carrito el producto Sauce Labs Onesie
        WebElement addItem = driver.findElement(By.xpath("//button[@name ='add-to-cart-sauce-labs-onesie']"));
        addItem.click();
        Thread.sleep(1000);

        //Paso 6
        //Eliminar producto carrito
        driver.findElement(By.xpath("//button[@name ='remove-sauce-labs-onesie']")).click();
        Thread.sleep(2000);

        //Paso 7
        //Validar que en el icono del carrito se ha eliminado el producto.
        String shoppingCartEmpty = driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).getText();
        System.out.println(shoppingCartEmpty.equals("")?"Se ha puesto el carrito a 0":"No se ha puesto el carrito a 0");
        Thread.sleep(2000);

        driver.quit();
    }
}

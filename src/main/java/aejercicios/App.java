package aejercicios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App {

    public static WebDriver driver;

    public static void main( String[] args ) {

        String userProfile= "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); //cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);

        driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.hiberus.com/");

        /* String title = driver.getTitle(); */

        /* String url = driver.getCurrentUrl(); */

        String url = driver.getPageSource();

        /* System.out.println( title); */

        /* driver.close(); */

        /* driver.quit(); */

        System.out.println( "/n" + "/n" + "Este es el valor que devuelve: " + url );


        //System.out.println( "Jose Terres" );
    }
}

package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;


    static // boyle yaparsak metodu direk çalıştırır ilk basta
            //bunun sartı extends olması ve başta yer alması
   // public static void DriverBaslat ()
    {

        //selenium chrome güncel versiyon uyarısını kaldırmak için
        Logger logger = Logger.getLogger(""); // output yapılan tüm logları al
        logger.setLevel(Level.SEVERE); // sadece errorları gosterir


        driver = new ChromeDriver();
        driver.manage().window().maximize(); //tam ekran yapar
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void BekleVeKapat (){
        MyFunc.Wait(3);
        driver.quit();
    }

}

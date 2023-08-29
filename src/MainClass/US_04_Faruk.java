package MainClass;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class US_04_Faruk extends BaseDriver {

    @Test
    public void Test_0401(){
        driver.get("https://demowebshop.tricentis.com/]");

        WebElement login = driver.findElement(By.xpath("//a[@class='ico-login']"));
        login.click();
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("cek@example.com");
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("far123");
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginButton.click();

        WebElement kisiselMenu = driver.findElement(By.xpath("(//a[@href='/customer/info'])[1]"));
        Assert.assertTrue("Hatalı kullanıcı email bilgisi",kisiselMenu.getText().contains("cek@example.com"));
        BekleVeKapat();
    }
}

package MainClass;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class us_02_Ihs extends BaseDriver {

    @Test

    public void TestUS02 () {

        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Wait(2);

        String cinsiyetSec = "Male";

        WebElement register= driver.findElement(By.cssSelector("a.ico-register[href=\"/register\"]"));
        register.click();
        MyFunc.Wait(2);

        switch (cinsiyetSec) {
            case "Male":
                WebElement erkekOption = driver.findElement(By.id("gender-male"));
                erkekOption.click();
                break;
            case "Female":
                WebElement kadinOption = driver.findElement(By.id("gender-female"));
                kadinOption.click();
                break;
            default:
                System.out.println("Hatalı seçim!!!");
                break;
        }
        MyFunc.Wait(3);

        WebElement firstName = driver.findElement(By.cssSelector("[id='FirstName']"));
        firstName.sendKeys("Ihs Ahm");
        MyFunc.Wait(2);

        WebElement lastName = driver.findElement(By.cssSelector("[id='LastName']"));
        lastName.sendKeys("USM");
        MyFunc.Wait(2);

        WebElement email = driver.findElement(By.cssSelector("[id='Email']"));
        email.sendKeys("usm@gmail.com");
        MyFunc.Wait(2);

        WebElement password = driver.findElement(By.cssSelector("[id='Password']"));
        password.sendKeys("Password123A@");
        MyFunc.Wait(2);

        WebElement confirmPassword = driver.findElement(By.cssSelector("[id='ConfirmPassword']"));
        confirmPassword.sendKeys("Password123A@");
        MyFunc.Wait(2);

        WebElement registerBtn = driver.findElement(By.cssSelector("[id='register-button']"));
        registerBtn.click();
        MyFunc.Wait(2);

        WebElement messageError = driver.findElement(By.xpath("//*[contains(text(), 'The specified email already exists')]"));
        String emailHataMesaji = messageError.getText();
        MyFunc.Wait(2);


        Assert.assertTrue("Email güvenlik denemesi başarısız", emailHataMesaji.contains("The specified email already exists"));

        BekleVeKapat();
    }

}

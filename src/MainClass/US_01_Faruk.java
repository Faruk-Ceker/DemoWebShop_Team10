package MainClass;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*
1. Kullanıcı https://demowebshop.tricentis.com/ sitesini tarayıcıda açar.
2. Ana sayfada "Register" seçeneğine tıklar.
3. Kullanıcı gerekli bilgileri eksiksiz doldurur.
4. "Register" butonuna tıklar.
 */
public class US_01_Faruk extends BaseDriver {
    @Test
    public void Test_0101 (){
        driver.get("https://demowebshop.tricentis.com/]");
        WebElement register= driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();

        WebElement genderFemale= driver.findElement(By.id("gender-female"));
        genderFemale.click();
        WebElement firstName= driver.findElement(By.id("FirstName"));
        firstName.sendKeys("far");
        WebElement lastName= driver.findElement(By.id("LastName"));
        lastName.sendKeys("far");
        WebElement email= driver.findElement(By.id("Email"));
        email.sendKeys("cek@example.com");
        WebElement password= driver.findElement(By.id("Password"));
        password.sendKeys("far123");
        WebElement confirmPassword= driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("far123");
        WebElement registerButton= driver.findElement(By.id("register-button"));
        registerButton.click();

        WebElement completedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='result']")));

        Assert.assertTrue("Hesap oluşturma tamamlandı yazısı görünmedi",completedText.getText().contains("Your registration completed"));



        BekleVeKapat();
    }
}

package MainClass;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class US_05_cansu extends BaseDriver {

    @Test
    public void Test_05_01(){
        /* 1. Kullanıcı https://demowebshop.tricentis.com/ sitesini tarayıcıda açar.
           2. Kullanıcı ana sayfada "Log in" seçeneğine tıklar.
           3. "Log in" butonuna tekrar tıklar. */
        driver.get("https://demowebshop.tricentis.com/");

        WebElement logInButton= driver.findElement(By.xpath("//a[text()='Log in']"));
        logInButton.click();
        MyFunc.Wait(2);

        WebElement logInButton2= driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        logInButton2.click();
        MyFunc.Wait(2);

        WebElement uyari= driver.findElement(By.xpath("//div[@class='validation-summary-errors']/span"));

        wait.until(ExpectedConditions.visibilityOf(uyari));

        Assert.assertTrue("beklenen yazı yok",uyari.getText().equals("Login was unsuccessful. Please correct the errors and try again."));

        BekleVeKapat();
    }

    @Test
    public void Test_05_02(){
        /*1. Kullanıcı https://demowebshop.tricentis.com/ sitesini tarayıcıda açar.
          2. Kullanıcı ana sayfada "Log in" seçeneğine tıklar.
          3. Kullanıcı, test datada verilen bilgileri girer. (email doğru girilsin, password null(pas geç) )
          4."Log in" butonuna tekrar tıklar. */

        driver=new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Wait(2);

        WebElement logInButton= driver.findElement(By.xpath("//a[text()='Log in']"));
        logInButton.click();
        MyFunc.Wait(2);

        WebElement email= driver.findElement(By.xpath("//input[@autofocus='autofocus' and @class='email']"));
        email.sendKeys("florida@gmail.com");
        MyFunc.Wait(2);

        WebElement logInButton2= driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        logInButton2.click();
        MyFunc.Wait(2);

        WebElement uyari= driver.findElement(By.xpath("//div[@class='validation-summary-errors']/span"));

        wait.until(ExpectedConditions.visibilityOf(uyari));

        Assert.assertTrue("beklenen yazı yok",uyari.getText().equals("Login was unsuccessful. Please correct the errors and try again."));

        BekleVeKapat();
    }

    @Test
    public void Test_05_03(){
        /*1. Kullanıcı https://demowebshop.tricentis.com/ sitesini tarayıcıda açar.
          2. Kullanıcı ana sayfada "Log in" seçeneğine tıklar.
          3. Kullanıcı, test datada verilen bilgileri girer. ( email null pas geç, password doğru girilsin)
          4."Log in" butonuna tekrar tıklar.  */

        driver=new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Wait(2);

        WebElement logInButton= driver.findElement(By.xpath("//a[text()='Log in']"));
        logInButton.click();
        MyFunc.Wait(2);

        WebElement password= driver.findElement(By.xpath("//input[@class='password' and @id='Password']"));
        password.sendKeys("123456Aa");
        MyFunc.Wait(2);

        WebElement logInButton2= driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        logInButton2.click();
        MyFunc.Wait(2);

        WebElement uyari= driver.findElement(By.xpath("//div[@class='validation-summary-errors']/span"));

        wait.until(ExpectedConditions.visibilityOf(uyari));

        Assert.assertTrue("beklenen yazı yok",uyari.getText().equals("Login was unsuccessful. Please correct the errors and try again."));


        BekleVeKapat();
    }

    @Test
    public void Test_05_04(){
          /*1. Kullanıcı https://demowebshop.tricentis.com/ sitesini tarayıcıda açar.
            2. Kullanıcı ana sayfada "Log in" seçeneğine tıklar.
            3. Kullanıcı, test datada verilen bilgileri girer. ( geçersiz email ve geçersiz password)
            4."Log in" butonuna tekrar tıklar.  */

        driver=new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Wait(2);

        WebElement logInButton= driver.findElement(By.xpath("//a[text()='Log in']"));
        logInButton.click();
        MyFunc.Wait(2);

        WebElement email= driver.findElement(By.xpath("//input[@autofocus='autofocus' and @class='email']"));
        email.sendKeys("abc@gmail.com");
        MyFunc.Wait(2);

        WebElement password= driver.findElement(By.xpath("//input[@class='password' and @id='Password']"));
        password.sendKeys("abc123");
        MyFunc.Wait(2);

        WebElement logInButton2= driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        logInButton2.click();
        MyFunc.Wait(2);

        WebElement uyari= driver.findElement(By.xpath("//div[@class='validation-summary-errors']/span"));

        wait.until(ExpectedConditions.visibilityOf(uyari));

        Assert.assertTrue("beklenen yazı yok",uyari.getText().equals("Login was unsuccessful. Please correct the errors and try again."));


        BekleVeKapat();
    }

}
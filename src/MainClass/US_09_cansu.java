package MainClass;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public class US_09_cansu extends BaseDriver {
    /*1. Kullanıcı https://demowebshop.tricentis.com/ sitesini tarayıcıda açar.
      2. Kullanıcı ana sayfada "Log in" seçeneğine tıklar.
      3. Kullanıcı, test datada verilen bilgileri girer.
      4."Log in" butonuna tekrar tıklar, giriş yapar.
      5.Mail adresine tıklar.
      6.Orders'a tıklar.
      7.Details'e tıklar.
      8.PDF Invoice'e tıklar.    */
    @Test
    public void Test() throws AWTException {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement logInButton= driver.findElement(By.xpath("//a[text()='Log in']"));
        logInButton.click();
        MyFunc.Wait(2);

        WebElement email= driver.findElement(By.xpath("//input[@autofocus='autofocus' and @class='email']"));
        email.sendKeys("florida@gmail.com");
        MyFunc.Wait(2);

        WebElement password= driver.findElement(By.xpath("//input[@class='password' and @id='Password']"));
        password.sendKeys("123456Aa");
        MyFunc.Wait(2);

        WebElement logInButton2= driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        logInButton2.click();
        MyFunc.Wait(2);

        WebElement mail= driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        mail.click();
        MyFunc.Wait(2);

        WebElement orders= driver.findElement(By.xpath("//div[@class='listbox']//a[text()='Orders']"));
        orders.click();
        MyFunc.Wait(2);

        WebElement details= driver.findElement(By.xpath("//input[@class='button-2 order-details-button']"));
        details.click();
        MyFunc.Wait(2);

        WebElement no1= driver.findElement(By.xpath("//strong[starts-with(text(),'Order')]"));
        System.out.println(no1.getText());

        // String Url= driver.getCurrentUrl();

        String anaSayfaWindowID= driver.getWindowHandle(); // anasayfanın idsini aldım
        MyFunc.Wait(2);

        WebElement printClick= driver.findElement(By.xpath("//a[@class='button-2 print-order-button' and text()='Print']"));
        printClick.click();
        MyFunc.Wait(2);

        String anaSayfaWindowID2= driver.getWindowHandle(); // 2.sayfanın idsini aldım
        driver.switchTo().window(anaSayfaWindowID2);

        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);

        WebElement no2= driver.findElement(By.xpath("//strong[starts-with(text(),'Order')]"));
        System.out.println(no2.getText());

        Assert.assertTrue("sipariş numaraları aynı değil",no1.getText().equals(no2.getText()));

        BekleVeKapat();

    }

}

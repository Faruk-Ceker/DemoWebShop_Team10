package MainClass;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class US_03 extends BaseDriver {
    @Test
    public void Test3()
    {

        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Wait(3);

        WebElement logInBtn=driver.findElement(By.xpath("//a[text()='Log in']"));

        logInBtn.click();
        MyFunc.Wait(3);

        WebElement eMail=driver.findElement(By.id("Email"));
        eMail.sendKeys("ahmt123@gmail.com");

        MyFunc.Wait(3);
        WebElement pass=driver.findElement(By.id("Password"));
        pass.sendKeys("123456Vs@");


        MyFunc.Wait(3);
        WebElement logInSubmit=driver.findElement(By.xpath("//input[@value='Log in']"));
        logInSubmit.click();

        MyFunc.Wait(3);
        WebElement logOutBtn=driver.findElement(By.xpath("//a[text()='Log out']"));
        logOutBtn.click();

        MyFunc.Wait(3);
        WebElement logInBtnText=driver.findElement(By.xpath("//a[text()='Log in']"));
        Assert.assertTrue("Basarili bir sekilde cikis yapilamadi",logInBtnText.getText().contains("Log in"));













        BekleVeKapat();
    }

}

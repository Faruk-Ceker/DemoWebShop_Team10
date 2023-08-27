package MainClass;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class us_07_Ihs extends BaseDriver {

    @Test

    public void TestUS07Pozitif () {

        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Wait(2);

        WebElement login = driver.findElement(By.xpath("//a[contains(text(), 'Log in')]"));
        login.click();
        MyFunc.Wait(2);

        WebElement email = driver.findElement(By.cssSelector("[id='Email']"));
        email.sendKeys("usm@gmail.com");
        MyFunc.Wait(2);

        WebElement password = driver.findElement(By.cssSelector("[id='Password']"));
        password.sendKeys("Password123A@");
        MyFunc.Wait(2);

        WebElement logInBtn = driver.findElement(By.cssSelector("input.button-1.login-button[type=\"submit\"][value=\"Log in\"]"));
        logInBtn.click();
        MyFunc.Wait(2);



        BekleVeKapat();
    }

    @Test

    public void TestUS07Negatif() {

        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Wait(2);




        BekleVeKapat();
    }


}

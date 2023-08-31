package MainClass;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class us_07_Ihs extends BaseDriver {

    @Test

    public void TestUS07Pozitif () {

        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Wait(2);

        String anketTercih = "Excellent"; // Anket menu: Excellent, Good, Poor, Very bad

        WebElement login = driver.findElement(By.xpath("//a[contains(text(), 'Log in')]"));
        login.click();
        MyFunc.Wait(2);

        WebElement email = driver.findElement(By.cssSelector("[id='Email']"));
        email.sendKeys("cek1@example.com");
        MyFunc.Wait(2);

        WebElement password = driver.findElement(By.cssSelector("[id='Password']"));
        password.sendKeys("far123");
        MyFunc.Wait(2);

        WebElement logInBtn = driver.findElement(By.cssSelector("input.button-1.login-button[type=\"submit\"][value=\"Log in\"]"));
        logInBtn.click();
        MyFunc.Wait(2);

        WebElement communityPoll = driver.findElement(By.xpath("//input[@type='radio' and following-sibling::label[contains(text(), '"+anketTercih+"')]]"));
        communityPoll.click();
        MyFunc.Wait(2);

        WebElement voteBtn = driver.findElement(By.id("vote-poll-1"));
        voteBtn.click();
        MyFunc.Wait(2);

        WebElement anketSonuc = driver.findElement(By.xpath("//div[@id='poll-block-1']//ul[@class='poll-results']"));
        String sonucMesaji = anketSonuc.getText();
        System.out.println("sonucMesaji = " + sonucMesaji);
        MyFunc.Wait(2);

        Assert.assertTrue("Anket sonucu gözükmedi",sonucMesaji != null && !sonucMesaji.isEmpty());

        BekleVeKapat();
    }

    @Test

    public void TestUS07Negatif() {

        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Wait(2);

        String anketTercih = "Excellent"; // Anket menu: Excellent, Good, Poor, Very bad

        WebElement communityPoll = driver.findElement(By.xpath("//input[@type='radio' and following-sibling::label[contains(text(), '"+anketTercih+"')]]"));
        communityPoll.click();
        MyFunc.Wait(2);

        WebElement voteBtn = driver.findElement(By.id("vote-poll-1"));
        voteBtn.click();
        MyFunc.Wait(2);

        WebElement anketSonuc = driver.findElement(By.id("block-poll-vote-error-1"));
        String sonucMesaji = anketSonuc.getText();
        System.out.println("sonucMesaji = " + sonucMesaji);
        MyFunc.Wait(2);

        Assert.assertTrue("Login yapmadan anket doldurma testi başarısız", sonucMesaji.contains("Only registered users can vote"));




        BekleVeKapat();
    }


}

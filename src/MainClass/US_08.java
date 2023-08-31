package MainClass;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/*US8  Kullanıcı olarak, web mağazamızdan alışveriş yaparken kupon ve hediye kartim olmadigi halde kullanmak istersem nasil bir uyari mesaji alacagimi goruntuleyebilmeliyim. Boylece daha iyi bir musteri deneyimi yasamis olurum.
AC_08
Anasayfada "Computers" kategorisinden bir ürünü seçebilmeliyim.
 Seçtiğim ürünü "Add to Cart" butonuna tıklayarak sepete ekleyebilmeliyim.
  Sepetime giderek seçtiğim ürünün görüntülendiğini doğrulayabilmeliyim.
   Sepetimdeki ürün için "Apply Coupon" butonuna tıkladigimda kullanilabilecek bir kupon kodu olmadigi mesajini alabilmeiyim
   "Add Gift Card" butonuna tıkladigimda, kullanilabilecek  bir hediye kartı olmadigi mesajini alabilmeliyim.
"Checkout" butonuna tıklayarak ödeme işlemine başlayabilmeliyim.
  Ödeme bilgilerini girerek siparişi onaylayabilmeliyim.
 "Your order has been successfully processed!" mesajını görüntüleyerek siparişin başarıyla tamamlandığını doğrulayabilmeliyim.*/

public class US_08 extends BaseDriver {

    @Test

    public void Test8() {
        driver.get("https://demowebshop.tricentis.com/");

        MyFunc.Wait(3);

        WebElement logInBtn = driver.findElement(By.xpath("//a[text()='Log in']"));

        logInBtn.click();
        MyFunc.Wait(3);

        WebElement eMail = driver.findElement(By.id("Email"));
        eMail.sendKeys("cek1@example.com");

        MyFunc.Wait(3);
        WebElement pass = driver.findElement(By.id("Password"));
        pass.sendKeys("far123");


        MyFunc.Wait(3);
        WebElement logInSubmit = driver.findElement(By.xpath("//input[@value='Log in']"));
        logInSubmit.click();


        WebElement computers = driver.findElement(By.xpath("//div[@class='listbox'] /ul/li[2] //a [@href='/computers']"));

        computers.click();
        MyFunc.Wait(2);

        WebElement desktop=driver.findElement(By.xpath("//ul[@class='sublist']/li[1]//a[@href='/desktops']"));
        desktop.click();
        MyFunc.Wait(2);


        WebElement firstPc=driver.findElement(By.linkText("Build your own cheap computer"));

        firstPc.click();
        MyFunc.Wait(2);


        WebElement addToCart=driver.findElement(By.xpath("//input[@id='add-to-cart-button-72']"));
      addToCart.click();
        MyFunc.Wait(2);

        WebElement shopCart=driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        shopCart.click();

        MyFunc.Wait(2);

        WebElement applyCoupon=driver.findElement(By.name("applydiscountcouponcode"));
        applyCoupon.click();

        MyFunc.Wait(2);
        WebElement warning=driver.findElement(By.cssSelector("[class='message']"));
        Assert.assertTrue("Uyari mesaji goruntulenemedi",warning.getText().equals("The coupon code you entered couldn't be applied to your order"));

        MyFunc.Wait(2);
        WebElement applyGiftCard=driver.findElement(By.name("applygiftcardcouponcode"));
        applyGiftCard.click();

        MyFunc.Wait(2);

        WebElement warning2=driver.findElement(By.cssSelector("[class='message']"));

        Assert.assertTrue("Hata Mesaji gozukmedi",warning2.getText().equals("The coupon code you entered couldn't be applied to your order"));

       WebElement checkBox=driver.findElement(By.id("termsofservice"));

       checkBox.click();

       MyFunc.Wait(2);
       WebElement checkOutBtn=driver.findElement(By.cssSelector("[id='checkout']"));
       checkOutBtn.click();

        MyFunc.Wait(2);

       WebElement countryMenu=driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select menu=new Select(countryMenu);
        menu.selectByVisibleText("United States");

        MyFunc.Wait(2);
        WebElement city=driver.findElement(By.id("BillingNewAddress_City"));
        city.sendKeys("Boston");
        MyFunc.Wait(2);

        WebElement add1=driver.findElement(By.id("BillingNewAddress_Address1"));
        add1.sendKeys("belmont");
        MyFunc.Wait(2);
        WebElement zip=driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        zip.sendKeys("02151");
        MyFunc.Wait(2);

        WebElement phone=driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        phone.sendKeys("123456789");

        MyFunc.Wait(2);

        WebElement countinue=driver.findElement(By.xpath("//div[@id='billing-buttons-container']//input[@title='Continue']"));

        countinue.click();
        MyFunc.Wait(2);
        WebElement count2=driver.findElement(By.cssSelector("[onclick='Shipping.save()']"));
        count2.click();
        MyFunc.Wait(2);

        WebElement count3=driver.findElement(By.cssSelector("[class='button-1 shipping-method-next-step-button']"));
        count3.click();
        MyFunc.Wait(2);

        WebElement paymentMethod=driver.findElement(By.cssSelector("[id='paymentmethod_0']"));
        paymentMethod.click();

        WebElement paymentCont=driver.findElement(By.cssSelector("[onclick='PaymentMethod.save()']"));
        paymentCont.click();
        MyFunc.Wait(2);
        WebElement paymnetInfoSave=driver.findElement(By.cssSelector("[onclick='PaymentInfo.save()']"));
           paymnetInfoSave.click();

        MyFunc.Wait(2);

        WebElement confirm=driver.findElement(By.cssSelector("[onclick='ConfirmOrder.save()']"));
        confirm.click();

        MyFunc.Wait(2);

        WebElement message=driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']"));
        Assert.assertTrue("Siparisiniz olusturalamadi",message.getText().equals("Your order has been successfully processed!"));

        MyFunc.Wait(2);



        BekleVeKapat();

    }
}

package MainClass;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/*
1. Kullanıcı https://demowebshop.tricentis.com/ sitesini tarayıcıda açar.
2. Kullanıcı ana sayfada "Log in" veya benzer bir seçeneği bulur ve tıklar.
3. Kullanıcı, aşağıdaki geçerli bilgileri girer:
4. Geçerli kullanıcı adı ve şifre bilgileri girilir ve "Log in" butonuna tıklar.
5. Kullanıcı hesabına başarılı bir şekilde giriş yapar ve Anasayfada bulunan bir ürüne tıklayarak Add to Card butonuna tıklar.
6. Kullanıcı "Shopping Card" seçeneğine tıklayarak sepetindeki ürünlerin listesine yönlendirilir.
7. Kullanıcı satın almak istediği ürün veya ürünleri seçerek, ülkve, zip kodu gibi seçenekleri doldurarak terms of servise
check box ı işaretleyerek Checkout butonuna tıklayarak fatura bilgilerini gireceği sayfaya yönlendirilir.
8. Kullanıcı doldurulması zorun olan alanlara gerekli bilgileri girerek "Continue" butonuna tıklar ve Shipping adress seçeneğine yönlendirilir.
9. Kullanıcı Shipping Adress seçeneğinde In-Store Pickup check box ını seçer ve adres bilgilerinin kaybolduğunu görür.
10. Kullanıcı Continue butonuna tıklayarak ödeme metodu sayfasına yönlendirilir.
11. Kullanıcı ödeme metodunu seçip Continue butonuna tıkladıktan sonra ödeme ile ilgili uyarılar sayfasına yönlendirilir ve
yine continue butonuna tıklayarak ödeme onay sayfasına yönlendirilir.
12. Kullanıcı ödeme onay sayfasında sipariş ettiği ürünün fiyatı, ödeme yöntemi vasıtasıyla çıkan ek ödemelerin vs doğru bir
şekilde fiyata yansıtıldığından emin olur ve "Confirm" butonuna tıklar.
13. Kullanıcı yönlendirilen sayfada "Your order has been successfully processed!" mesajını görür ve Continue butonuna tıklayarak Ana sayfaya yönlendirilir.
 */
public class US_06_Faruk extends BaseDriver {
    @Test
    public void Test_0601 (){
        driver.get("https://demowebshop.tricentis.com/]");

        WebElement login = driver.findElement(By.xpath("//a[@class='ico-login']"));
        login.click();
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("cek@example.com");
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("far123");
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginButton.click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/141-inch-laptop']")));
        WebElement laptop = driver.findElement(By.xpath("//h2[@class='product-title']/a[text()='14.1-inch Laptop']"));
        laptop.click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button-31']")));
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button-31"));
        addToCart.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='bar-notification']/p[text()='The product has been added to your ']")));
        WebElement addCartOnayText = driver.findElement(By.xpath("//div[@id='bar-notification']/p[text()='The product has been added to your ']"));
        Assert.assertTrue("onay mesajı gorunmedi",addCartOnayText.getText().contains("The product has been added to your"));

        WebElement shoppingCartMenu = driver.findElement(By.xpath("//a[@class='ico-cart']"));
        shoppingCartMenu.click();
        WebElement urunSecmeCheckBox = driver.findElement(By.name("removefromcart"));
        urunSecmeCheckBox.click();

        WebElement countrySecim = driver.findElement(By.id("CountryId"));
        Select countryDropdown = new Select(countrySecim);
        countryDropdown.selectByValue("1");

        //wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//select[@id='StateProvinceId']//"),"Florida"));
        WebElement stateSecim = driver.findElement(By.id("StateProvinceId"));
        Select stateDropdown = new Select(stateSecim);
        stateDropdown.selectByValue("15");

        WebElement zipInput = driver.findElement(By.id("ZipPostalCode"));
        zipInput.sendKeys("33484");

        WebElement agreeCheckBox = driver.findElement(By.id("termsofservice"));
        agreeCheckBox.click();
        WebElement checkOutButton = driver.findElement(By.id("checkout"));
        checkOutButton.click();
//        WebElement billinContinue = driver.findElement(By.xpath("//input[@onclick='Billing.save()']"));
//        billinContinue.click();

        WebElement address = driver.findElement(By.id("billing-address-select"));
        address.click();
        WebElement newAddress = driver.findElement(By.xpath("//option[text()='New Address']"));
        newAddress.click();

        WebElement billingCountrySecim = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select billingCountryDropdown = new Select(billingCountrySecim);
        billingCountryDropdown.selectByValue("1");

       // wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']/option"),"Florida"));
        WebElement billingStateSecim = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
        Select billingStateDropdown = new Select(billingStateSecim);
        billingStateDropdown.selectByValue("15");

        WebElement cityInput= driver.findElement(By.id("BillingNewAddress_City"));
        cityInput.sendKeys("miami");
        WebElement address1Input= driver.findElement(By.id("BillingNewAddress_Address1"));
        address1Input.sendKeys("delray beach");
        WebElement billingZipInput= driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        billingZipInput.sendKeys("33484");
        WebElement phoneNumInput= driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        phoneNumInput.sendKeys("+145687870");

        WebElement continueButton = driver.findElement(By.xpath("//div[@id='billing-buttons-container']/input[@class='button-1 new-address-next-step-button']"));
        continueButton.click();

        WebElement pickupCheckBox = driver.findElement(By.id("PickUpInStore"));
        pickupCheckBox.click();

        WebElement continueButton2 = driver.findElement(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[2]"));
        continueButton2.click();

        WebElement paymentCheckBox = driver.findElement(By.id("paymentmethod_1"));
        paymentCheckBox.click();

        WebElement continueButton3 = driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']"));
        continueButton3.click();

        WebElement continueButton4 = driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']"));
        continueButton4.click();

        WebElement productPrice = driver.findElement(By.xpath("(//span[@class='nobr']/span[@class='product-price'])[1]"));
        double urunFiyat = Double.parseDouble(productPrice.getText());
        WebElement shippingPrice = driver.findElement(By.xpath("(//span[@class='nobr']/span[@class='product-price'])[2]"));
        double kargoFiyat = Double.parseDouble(shippingPrice.getText());
        WebElement payMethodPrice = driver.findElement(By.xpath("(//span[@class='nobr']/span[@class='product-price'])[3]"));
        double odemeMetodFiyat = Double.parseDouble(payMethodPrice.getText());
        WebElement taxPrice = driver.findElement(By.xpath("(//span[@class='nobr']/span[@class='product-price'])[4]"));
        double vergiFiyat = Double.parseDouble(taxPrice.getText());
        WebElement totalPrice = driver.findElement(By.xpath("//span[@class='nobr']/span[@class='product-price order-total']"));
        double toplamFiyat = Double.parseDouble(totalPrice.getText());

        Assert.assertTrue("toplam tutar hatalı",(toplamFiyat==urunFiyat+kargoFiyat+odemeMetodFiyat+vergiFiyat));

        WebElement confirmButton = driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']"));
        confirmButton.click();

        wait.until(ExpectedConditions.textToBe(By.xpath("//strong[text()='Your order has been successfully processed!']"),"Your order has been successfully processed!"));
        WebElement onayText = driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));

        Assert.assertTrue("sipariş oluşturma başarısız",onayText.getText().contains("Your order has been successfully processed"));


        BekleVeKapat();
    }
}

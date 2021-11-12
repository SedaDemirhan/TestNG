package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class EnableTest extends TestBase {
    @Test public void isEnabled (){
        //1. Bir class olusturun : EnableTest
        //2. Bir metod olusturun : isEnabled()
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls ");
        //4.Textbox’in etkin olmadigini(enabled) dogrulayın

        WebElement textBox= driver.findElement(By.xpath("//input[@type='text']"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertFalse(textBox.isEnabled(),"textbox enabled");

       //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebElement enableButon= driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enableButon.click();
        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        WebDriverWait wait=new WebDriverWait(driver,20);
        WebElement ıtsEnabled=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        softAssert.assertTrue(ıtsEnabled.isDisplayed());

        //7. Textbox’in etkin ol dugunu (enabled)
         softAssert.assertTrue(textBox.isEnabled(),"Textbox not enabled");
         softAssert.assertAll();
    }

}

package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class ExplicitlyWaitTest extends TestBase {

    @Test
    public void enableTest() {
        //1. Bir class olusturun : ExplicitlyWaitTest
        //2. Bir metod olusturun :enableTest
        //3. https://demoqa.com/dynamic-properties adresine gidin.
        driver.get("https://demoqa.com/dynamic-properties");

        //4. Will enable 5 seconds’in etkin olmadigini(enabled) test edin
        WebElement willEnable = driver.findElement(By.id("enableAfter"));
        Assert.assertFalse(willEnable.isEnabled(), "will enabled etkin");

        //5.Will enable 5 seconds etkin oluncaya kadar bekleyin ve enabled oldugunu test edin
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(willEnable));
        Assert.assertTrue(willEnable.isEnabled(), "will enabled etkin değil");
    }

        @Test
        public void visibleTest(){
        //6. Bir metod olusturun :visibleTest
        //7. Ayni sayfaya tekrar gidin, Visible After 5 Seconds butonunun gorunmesini bekleyin,ve gorunur oldugunu test edin
            driver.get("https://demoqa.com/dynamic-properties");

            WebDriverWait wait=new WebDriverWait(driver,10);
            WebElement visibleAfter=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
            Assert.assertTrue(visibleAfter.isDisplayed());


    }
}

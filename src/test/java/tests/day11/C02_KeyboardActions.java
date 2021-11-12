package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_KeyboardActions extends TestBase {

    @Test
    public void test(){
        //1- Bir Class olusturalim
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //4- videoyu izlemek icin Play tusuna basin
        WebElement iFrame=driver.findElement(By.className("lazy-loaded"));
        driver.switchTo().frame(iFrame);
        WebElement playTuşu=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        actions.click(playTuşu).perform();

        //5- videoyu calistirdiginizi test edin
        Assert.assertFalse(playTuşu.isDisplayed());



    }
}

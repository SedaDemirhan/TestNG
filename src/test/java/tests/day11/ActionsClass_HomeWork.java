package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class ActionsClass_HomeWork extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //1--"http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2-"Hover over Me First" kutusunun ustune gelin
        WebElement hoverKutusu=driver.findElement(By.xpath("//button[@class='dropbtn']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(hoverKutusu).perform();
        Thread.sleep(2000);

        //3-Link 1" e tiklayin
        driver.findElement(By.xpath("//a[@class='list-alert']")).click();
        Thread.sleep(2000);

        //4-Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(2000);

        //5-Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6--“Click and hold" kutusuna basili tutun
        WebElement clickButonu= driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickButonu).perform();

        //7--“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickButonu.getText());

        //8--“Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.xpath("//div[@id='double-click']"))).perform();

    }
}

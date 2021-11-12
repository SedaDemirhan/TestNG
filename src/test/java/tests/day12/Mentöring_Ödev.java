package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class Mentöring_Ödev extends TestBase {

    @Test public void test() throws InterruptedException {


    //      go to url :http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");

    //      get the first window
        String firstWindowHandle= driver.getWindowHandle();
        System.out.println("first window handle :"+firstWindowHandle);

    //  clicking on click here button
        driver.findElement(By.linkText("Click Here")).click();

    //      get all the window in the set
        Set<String>windowHandles=driver.getWindowHandles();
        String secondWindowHandle="";
        for (String w:windowHandles) {
            if (!w.equals(firstWindowHandle)){
                secondWindowHandle=w;
            }

        }

    // switch to window
        driver.switchTo().window(secondWindowHandle);
        Thread.sleep(2000);

    //input email id (somepne@gmail.com) and type something in that input
      driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("somepne@gmail.com"+Keys.ENTER);


    //      Clicking on the submit button

    //      verify title as expected
        SoftAssert softAssert=new SoftAssert();

        String actualText=driver.findElement(By.tagName("h3")).getText();
        String expectedText="This access is valid only for 20 days.";
        softAssert.assertEquals(actualText,expectedText,"Actual text does not equals expected text");
        softAssert.assertAll();

    //      switch to first window
        driver.switchTo().window(firstWindowHandle);

}}

package tests.day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mentör_Ödev extends TestBase {
    /*
         //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
       //maximize the web site
       //click on second emoji
       //click all second emoji's element
       //go back parent iframe
       //fill out the form,(Fill the form with the texts you want)
       //click on apply button
     */


    @Test
    public void test()  {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        driver.switchTo().frame("emoojis");
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        List<WebElement>tümEmojiler=driver.findElements(By.xpath("//div[@id='nature']/div/img"));

        for (WebElement each:tümEmojiler) {
            each.click();

        }
        driver.switchTo().defaultContent();

        List<WebElement>formList=driver.findElements(By.xpath("//div[@data-upgraded=',MaterialTextfield']/input"));
        List<String>formText=new ArrayList<>(Arrays.asList("live","sweet","Turkey","doner","hiking","home","flower","lkıo","Turk","efdr","abcd"));

        for (int i = 0; i < formList.size() ; i++) {
            formList.get(i).sendKeys(formText.get(i));

        }

        driver.findElement(By.xpath("//button[@id='send']")).click();
    }

}


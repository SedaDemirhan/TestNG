package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Drag_drop_Mentör extends TestBase {

    @Test
    public void test() throws InterruptedException {

        //Go to http://demo.guru99.com/test/drag_drop.html url
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        //     Drag and drop the BANK button to the Account section in DEBIT SIDE
        Actions actions=new Actions(driver);

        WebElement bankButton= driver.findElement(By.xpath("//li[@class='block13 ui-draggable'] "));
        WebElement accountButton= driver.findElement(By.id("bank"));
        actions.dragAndDrop(bankButton,accountButton).perform();

        Thread.sleep(3000);

        //     Drag and drop the SALES button to the Account section in CREDIT SIDE
        WebElement salesButton= driver.findElement(By.xpath("//li[@class='block15 ui-draggable']"));
        WebElement credıtSıdeButton= driver.findElement(By.id("loan"));
        actions.dragAndDrop(salesButton,credıtSıdeButton).perform();

        //     Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        Thread.sleep(3000);
        WebElement fiveThousandButton= driver.findElement(By.xpath("//li[@class='block13 ui-draggable']"));
        WebElement debıtSıdeButton= driver.findElement(By.id("amt7"));
        actions.dragAndDrop(fiveThousandButton,debıtSıdeButton).perform();

        //     Drag and drop the second 5000 button to the Amount section in CREDIT SIDE

        Thread.sleep(3000);
        WebElement secondfiveThousandButton= driver.findElement(By.xpath("//li[@class='block13 ui-draggable']"));
        WebElement credıtSıdeButton2= driver.findElement(By.id("amt8"));
        actions.dragAndDrop(secondfiveThousandButton,credıtSıdeButton2).perform();
    }
}

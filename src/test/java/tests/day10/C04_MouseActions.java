package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_MouseActions extends TestBase {

    @Test
    public void test(){
        //1-https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable ");

        //2--“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        Actions actions=new Actions(driver);

        WebElement dragMeButonu= driver.findElement(By.xpath("(//div[@id='draggable'])[1]"));
        WebElement dropHereButonu=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(dragMeButonu,dropHereButonu).perform();


        //3--“Drop here” yazisi yerine “Dropped!” oldugunu test edin

        WebElement droppedYazısı=driver.findElement(By.xpath("//*[text()='Dropped!']"));

        String actualDropYazısı= droppedYazısı.getText();
        String expectedDropYazısı="Dropped!";

        Assert.assertEquals(actualDropYazısı,expectedDropYazısı,"dropped yazısı beklenenden farklı");


    }

}

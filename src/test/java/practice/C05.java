package practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05 extends TestBase {
    // "http://automationpractice.com/" ADRESiNE GiDiP UYE OL.

  @Test
  public void
  test(){
      driver.get("http://automationpractice.com/");
      driver.findElement(By.xpath("//a[@class='login']")).click();

      driver.findElement(By.id("email_create")).sendKeys("deneme2345@gmail.com"+ Keys.ENTER);

      driver.findElement(By.cssSelector("#id_gender2")).click();

      Faker faker=new Faker();
      Actions actions=new Actions(driver);
      actions.sendKeys(Keys.TAB)
              .sendKeys(faker.name().firstName())
              .sendKeys(Keys.TAB)
              .sendKeys(faker.name().lastName())
              .sendKeys(Keys.TAB)
              .sendKeys(Keys.TAB)
              .sendKeys(faker.internet().password())
              .sendKeys(Keys.TAB)
              .sendKeys(String.valueOf(faker.number().numberBetween(1,31)))
              .sendKeys(Keys.TAB)
              .sendKeys("May")
              .sendKeys(Keys.TAB)
              .sendKeys(String.valueOf(faker.number().numberBetween(1950,2003)))
              .sendKeys(Keys.TAB)
              .sendKeys(Keys.TAB)
              .sendKeys(Keys.TAB)
              .sendKeys(Keys.TAB)
              .sendKeys(Keys.TAB)
              .sendKeys(faker.company().name())
              .sendKeys(Keys.TAB)
              .sendKeys(faker.address().fullAddress())
              .sendKeys(Keys.TAB)
              .sendKeys(Keys.TAB)
              .sendKeys(faker.address().state())
              .sendKeys(Keys.TAB)
              .sendKeys(faker.address().zipCode())
              .sendKeys(Keys.TAB)
              .sendKeys(Keys.TAB)
              .sendKeys(Keys.TAB)
              .sendKeys(faker.phoneNumber().cellPhone())
              .sendKeys(Keys.TAB)
              .sendKeys(faker.internet().emailAddress())
              .sendKeys(Keys.ENTER).perform();



  }

}

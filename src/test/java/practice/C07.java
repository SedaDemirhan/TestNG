package practice;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import utilities.TestBase;

public class C07 extends TestBase {

    @Test
    public void test(){
        driver.get("www.facebook.com");

        JavascriptExecutor js = (JavascriptExecutor)  driver;

        js.executeScript("document.getElementById('email').value='deneme@abc.com';");
    }
}

package projekaDemoQA.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekaDemoQA.base.BasePage;
import projekaDemoQA.pages.TextBox;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TextBoxTest extends BasePage {



    @BeforeMethod
    public void setUp(){
        driver.navigate().to(tb.url);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testFullName(){
        tb.inputName("Frida Kahlo");

        String actual = tb.getFullName().getAttribute("value");
        String expected = "Frida Kahlo";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testEmailInput(){
        tb.inputEmail("frida@google.com");

        String actual = tb.getEmail().getAttribute("value");
        String expected = "frida@google.com";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCurrAddress(){
        tb.inputCurrAddress("Blue house");

        String actual = tb.getCurrentAdress().getAttribute("value");
        String expected = "Blue house";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testPerAddress(){
        tb.inputPerAddress("Mexico City");

        String actual = tb.getPermanentAddress().getAttribute("value");
        String expected = "Mexico City";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSubmit(){
        js.executeScript("window.scrollTo(0, 500)");
        tb.clickSubmit(driver);

        List<WebElement> actual = tb.clickSubmit(driver);
        List<WebElement> expected = tb.getData();

        List<WebElement> a = tb.getData();
        for(WebElement w : a)
        System.out.println(w);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCompleteTBox(){
        String fullName = "Mike Paton";
        String email = "mike@gmail.com";
        String currAddress = "Abby road";
        String perAddress = "Via apia";

        List<String> actual = tb.completeTBox(driver, fullName, email, currAddress, perAddress);
        List<String> expected = new ArrayList<>();
        expected.add("Name:" + fullName);
        expected.add("Email:" + email);
        expected.add("Current Address :" + currAddress);
        expected.add("Permananet Address :" + perAddress);


        Assert.assertEquals(actual, expected);
    }

}

package projekaDemoQA.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
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
import projekaDemoQA.pages.Forms;
import projekaDemoQA.pages.TextBox;

import java.time.Duration;
import java.util.List;

public class FormTest extends BasePage {



    @BeforeMethod
    public void setUp(){
        driver.navigate().to(forms.url);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testForm() {
        forms.fillForm();
        Assert.assertTrue(true);
    }

    @Test
    public void testFirstName(){
        forms.inputFirstName("Frida");
        String actual = forms.getFirstName().getAttribute("value");
        String expected = "Frida";
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void testLastName(){
        forms.inputLastName("Kahlo");
        String actual = forms.getLastName().getAttribute("value");
        String expected = "Kahlo";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testEmail(){
        forms.inputEmail("Frida@kahlo.com");
        String actual = forms.getEmail().getAttribute("value");
        String expected = "Frida@kahlo.com";
        Assert.assertEquals(actual, expected);
        forms.inputSubjects("Subject");
    }

    @Test
    public void testRadioButtons(){
        int i = 1;
        for(WebElement w : forms.getRadioButtons()) {
            w.click();
            Assert.assertTrue(driver.findElement(By.id("gender-radio-"+(i))).isSelected());
            i++;
        }

    }

    @Test
    public void testMobile(){
        forms.inputMobile("0601234567");
        String actual = forms.getMobile().getAttribute("value");
        String expected = "0601234567";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testDateOfbirth(){
        forms.clickDateOfBirth();
        Assert.assertTrue(true);
    }

    @Test
    public void testSubjects(){
        forms.inputSubjects("Subject");
        String actual = forms.getSubjectsInput().getAttribute("value");
        String expected = "Subject";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testHobbies(){
        List<WebElement> hobbies = forms.getHobbies();
        js.executeScript("window.scrollTo(0, 500)");
        for(WebElement w : hobbies) {
            w.click();
        }
        WebElement checkbox1 = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement checkbox2 = driver.findElement(By.id("hobbies-checkbox-2"));
        WebElement checkbox3 = driver.findElement(By.id("hobbies-checkbox-3"));

        Assert.assertTrue(checkbox1.isSelected()
                && checkbox2.isSelected()
                && checkbox3.isSelected());
    }

    @Test
    public void testInputPic(){
        forms.uploadPic();
        Assert.assertTrue(forms.getPictureInput().getAttribute("value").contains("2022-06-08 at 18.15.59.png"));
    }

    public void testCurrentAddress(){
        forms.inputCurrAddress("Blue House");
        String actual = forms.getSubjectsInput().getAttribute("value");
        String expected = "Blue House";
        Assert.assertEquals(actual, expected);
    }

}

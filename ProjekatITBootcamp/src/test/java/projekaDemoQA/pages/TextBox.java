package projekaDemoQA.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TextBox {

    public final String url = "https://demoqa.com/text-box";

    public WebDriverManager wdm;
    public WebDriver driver;
    public JavascriptExecutor js;

    By fullName = By.id("userName");
    By email = By.id("userEmail");
    By currentAddress = By.id("currentAddress");
    By permanentAddress = By.id("permanentAddress");
    By submit = By.id("submit");

    public TextBox(WebDriverManager wdm, WebDriver driver, JavascriptExecutor js) {
        this.wdm = wdm;
        this.driver = driver;
        this.js = js;
    }

    public WebElement getFullName(){
        return driver.findElement(fullName);
    }

    public WebElement getEmail(){
        return driver.findElement(email);
    }

    public WebElement getCurrentAdress(){
        return driver.findElement(currentAddress);
    }

    public WebElement getPermanentAddress(){
        return driver.findElement(permanentAddress);
    }

    public WebElement getSubmit(){
        return driver.findElement(submit);
    }

    public List<WebElement> getData(){
        return driver.findElements(By.className("mb-1"));
    }


    public void inputName(String name){
        getFullName().sendKeys(name);
    }

    public void inputEmail(String email){
        getEmail().sendKeys(email);
    }

    public void inputCurrAddress(String address){
        getCurrentAdress().sendKeys(address);
    }

    public void inputPerAddress(String address){
        getPermanentAddress().sendKeys(address);
    }

    public List<WebElement> clickSubmit(WebDriver driver){
     //   js.executeScript("window.scrollTo(0, 500)");
        getSubmit().click();
        return getData();
    }

    public List<String> completeTBox(WebDriver driver, String fullName, String email, String currAddress, String perAddress){
        getFullName().sendKeys("Mike Paton");
        getEmail().sendKeys("mike@gmail.com");
        getCurrentAdress().sendKeys("Abby road");
        getPermanentAddress().sendKeys("Via apia");
        js.executeScript("window.scrollTo(0,500)");
        getSubmit().click();
        List<String> result = new ArrayList<>();
        for(WebElement w : getData())
            result.add(w.getText());

        return result;
    }

}

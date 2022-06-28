package projekaDemoQA.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginBookStore {

    public final String url = "https://demoqa.com/login";
    public WebDriverManager wdm;
    public WebDriver driver;
    JavascriptExecutor js;

    public LoginBookStore(WebDriverManager wdm, WebDriver driver, JavascriptExecutor js) {
        this.wdm = wdm;
        this.driver = driver;
        this.js = js;
    }

    By username = By.id("userName");
    By password = By.id("password");
    By loginBtn = By.id("login");


    public WebElement getUsername(){
        return driver.findElement(username);
    }

    public WebElement getPassword(){
        return driver.findElement(password);
    }

    public WebElement getLogin(){
        return driver.findElement(loginBtn);
    }

    public void login(){
       // driver.navigate().to("url");
        getUsername().sendKeys("RadeP");
        getPassword().sendKeys("Rade1#petrovic");
        js.executeScript("window.scrollTo(0,300)");
        getLogin().click();
    }

}

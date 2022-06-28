package projekaDemoQA.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Alerts {

    public final String url = "https://demoqa.com/alerts";
    public WebDriverManager wdm;
    public WebDriver driver;

    public Alerts(WebDriverManager wdm, WebDriver driver) {
        this.wdm = wdm;
        this.driver = driver;
    }

    By alertBtn = By.id("alertButton");
    By timerBtn = By.id("timerAlertButton");
    By confirmBtn = By.id("confirmButton");
    By promtBtn = By.id("promtButton");

    public WebElement getAlertBtn(){
        return driver.findElement(alertBtn);
    }

    public WebElement getTimerBtn(){
        return driver.findElement(timerBtn);
    }

    public WebElement getConfirmBtn(){
        return driver.findElement(confirmBtn);
    }

    public WebElement getPromtBtn(){
        return driver.findElement(promtBtn);
    }

    public void clickAlertBtn(){
        getAlertBtn().click();
    }

    public void clickTimerBtn(){
        getTimerBtn().click();
    }

    public void clickConfirmBtn(){
        getConfirmBtn().click();
    }

    public void clickPromtBtn(){
        getPromtBtn().click();
    }

}

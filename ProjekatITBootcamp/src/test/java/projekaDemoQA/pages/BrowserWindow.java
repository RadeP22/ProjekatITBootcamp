package projekaDemoQA.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserWindow {

    public final String url = "https://demoqa.com/browser-windows";
    public WebDriverManager wdm;
    public WebDriver driver;

    public BrowserWindow(WebDriverManager wdm, WebDriver driver) {
        this.wdm = wdm;
        this.driver = driver;
    }

    By tabBtn = By.id("tabButton");
    By windowBtn = By.id("windowButton");
    By msgWindowBtn = By.id("messageWindowButton");

    public WebElement getTabBtn(){
        return driver.findElement(tabBtn);
    }

    public WebElement getWindowBtn(){
        return driver.findElement(windowBtn);
    }

    public WebElement getmsgWindowBtn(){
        return driver.findElement(msgWindowBtn);
    }

    public void clickTabBtn(){
        getTabBtn().click();
    }

    public void clickWindowBtn(){
        getWindowBtn().click();
    }

    public void clickMsgWindowBtn(){
        getmsgWindowBtn().click();
    }

}

package projekaDemoQA.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Modals {

    public final String url = "https://demoqa.com/modal-dialogs";
    public WebDriverManager wdm;
    public WebDriver driver;

    public Modals(WebDriverManager wdm, WebDriver driver) {
        this.wdm = wdm;
        this.driver = driver;
    }

    By smallModal = By.id("showSmallModal");
    By largeModal = By.id("showLargeModal");
    By modal = By.cssSelector("div[class = \"modal-content\"]");

    public WebElement getSmallModal(){
        return driver.findElement(smallModal);
    }

    public WebElement getLargeModal(){
        return driver.findElement(largeModal);
    }

    public WebElement getModal(){
        return driver.findElement(modal);
    }

    public void clickSmallModal(){
        getSmallModal().click();
    }

    public void clickLargeModal(){
        getLargeModal().click();
    }

}

package projekaDemoQA.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OtherElements {

    public final String brkLinksURL = "https://demoqa.com/broken";
    public final String downloadURL = "https://demoqa.com/upload-download";
    public WebDriverManager wdm;
    public WebDriver driver;

    public OtherElements(WebDriverManager wdm, WebDriver driver) {
        this.wdm = wdm;
        this.driver = driver;
    }

    By validLink = By.cssSelector("a[href = \"http://demoqa.com\"]");
    By brokenLink = By.cssSelector("a[href = \"http://the-internet.herokuapp.com/status_codes/500\"]");
    By download = By.id("downloadButton");
    By upload = By.id("uploadFile");
    By uploadFile = By.id("uploadFile");


    public WebElement getValidLink(){
        return driver.findElement(validLink);
    }

    public WebElement getBrokenLink(){
        return driver.findElement(brokenLink);
    }

    public WebElement getUpload(){
        return driver.findElement(upload);
    }

    public WebElement getFileInput(){
        return driver.findElement(uploadFile);
    }


    public void clickValidLink(){
        getValidLink().click();
    }

    public void clickBrokenLink(){
        getBrokenLink().click();
    }

    public void clickUpload(){
        getUpload().click();
    }

    public void uploadFile(){
        getFileInput().sendKeys("/Users/rade/Desktop/Screenshot 2022-06-08 at 18.15.59.png");
    }

}

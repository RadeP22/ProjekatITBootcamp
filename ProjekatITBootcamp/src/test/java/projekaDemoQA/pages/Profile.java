package projekaDemoQA.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Profile {

    public final String url = "https://demoqa.com/profile";
    public WebDriverManager wdm;
    public WebDriver driver;
    private WebElement deleteAll;

    public Profile(WebDriverManager wdm, WebDriver driver) {
        this.wdm = wdm;
        this.driver = driver;
    }

    By backToStore = By.id("gotoStore");
    By tableRows = By.className("-odd");
    By deleteIcon = By.id("delete-record-undefined");
    By closeModalBtn = By.id("closeSmallModal-ok");

    By deleteAllBooks = By.id("submit");

    public WebElement getBackToStore(){
        return driver.findElement(backToStore);
    }

    //VECINA DUGMICA IMA SUBMIT ID

    public List<WebElement> getTableRows(){
        List<WebElement> rows = driver.findElements(tableRows);
        return rows;
    }

    public WebElement getDeleteIcon(){
        return driver.findElement(deleteIcon);
    }

    public WebElement getCloseModalBtn(){
        return driver.findElement(closeModalBtn);
    }

    public WebElement getDeleteAll(){
        List<WebElement> buttons = driver.findElements(deleteAllBooks);
        for(WebElement w : buttons){
           if(w.getText().contains("Delete All Books"))
               deleteAll = w;
        }
        return deleteAll;
    }


}

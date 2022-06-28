package projekaDemoQA.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddBook {

    public final String url = "https://demoqa.com/books?book=9781449325862";
    public WebDriverManager wdm;
    public WebDriver driver;
    private WebElement profBtn;

    public AddBook(WebDriverManager wdm, WebDriver driver) {
        this.wdm = wdm;
        this.driver = driver;
    }

    By addNewRecord = By.id("addNewRecordButton");

    public List<WebElement> getButtons(){
        return driver.findElements(addNewRecord);
    }

    public WebElement getBackToBookstore(){
        return getButtons().get(0);
    }

    public WebElement getAddToColection(){
        return getButtons().get(1);
    }

    public WebElement getProfileBtn(){
        List<WebElement> span = driver.findElements(By.tagName("span"));
        for(WebElement w : span){
            if(w.getText().equals("Profile"))
                profBtn = w;
        }
        return profBtn;
    }

}

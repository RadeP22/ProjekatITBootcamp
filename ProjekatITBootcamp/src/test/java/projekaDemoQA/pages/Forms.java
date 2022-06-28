package projekaDemoQA.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class Forms {

    public final String url = "https://demoqa.com/automation-practice-form";
    public WebDriverManager wdm;
    public WebDriver driver;
    public WebDriverWait wdw;
    JavascriptExecutor js;


    public Forms(WebDriverManager wdm, WebDriver driver, WebDriverWait wdw, JavascriptExecutor js) {
        this.wdm = wdm;
        this.driver = driver;
        this.wdw = wdw;
        this.js = js;
    }

    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By mobile = By.id("userNumber");
    By dateOfBirth = By.id("dateOfBirthInput");
    By subjects = By.id("subjectsInput");
    By chooseButton = By.className("form-file-label");
    By pictureInput = By.id("uploadPicture");
    By currentAddress = By.id("currentAddress");




    public WebElement getFirstName(){
         return driver.findElement(firstName);
    }

    public WebElement getLastName(){
        return driver.findElement(lastName);
    }

    public WebElement getEmail(){
        return driver.findElement(email);
    }

    public List<WebElement> getRadioButtons(){
        List<WebElement> radioButtons = driver.findElements(By.className("custom-control-label"));
        radioButtons.remove(5);
        radioButtons.remove(4);
        radioButtons.remove(3);
        return radioButtons;
    }

    public WebElement getMobile(){
        return driver.findElement(mobile);
    }

    public WebElement getDateOfBirth(){
        return driver.findElement(dateOfBirth);
    }


    public List<WebElement> getHobbies(){
        List<WebElement> hobbies = driver.findElements(By.className("custom-control-label"));
        hobbies.remove(0);
        hobbies.remove(0);
        hobbies.remove(0);
        return hobbies;
    }

    public WebElement getSubjectsInput(){
        return driver.findElement(subjects);
    }

    public WebElement getChooseFileButton(){
        return driver.findElement(chooseButton);
    }

    public WebElement getPictureInput(){
        return driver.findElement(pictureInput);
    }

    public WebElement getCurrentAdress(){
        return driver.findElement(currentAddress);
    }


    public void inputFirstName(String name){
        getFirstName().sendKeys(name);
    }

    public void inputLastName(String lastName){
        getLastName().sendKeys(lastName);
    }

    public void inputEmail(String email){
        getEmail().sendKeys(email);
    }

    public void inputMobile(String number){
        getMobile().sendKeys(number);
    }

    public void clickDateOfBirth(){
        getDateOfBirth().click();
    }

    public void inputSubjects(String subject){
        getSubjectsInput().sendKeys(subject);
    }

    public void uploadPic(){
        js.executeScript("window.scrollTo(0,500)");
        getChooseFileButton().click();
        getPictureInput().sendKeys("/Users/rade/Desktop/Screenshot 2022-06-08 at 18.15.59.png");
    }

    public void inputCurrAddress(String address){
        getCurrentAdress().sendKeys(address);
    }

    public void fillForm(){
        inputFirstName("Frida");
        inputLastName("Kahlo");
        inputEmail("Frida@kahlo.com");
        getRadioButtons().get(0).click();
        inputMobile("0601234567");
        js.executeScript("window.scrollTo(0, 500)");
        inputSubjects("Subject");
        getHobbies().get(0).click();
        uploadPic();
        inputCurrAddress("Blue House");
    }

}

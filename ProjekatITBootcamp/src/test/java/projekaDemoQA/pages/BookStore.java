package projekaDemoQA.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BookStore {

    public final String url = "https://demoqa.com/books";
    public WebDriverManager wdm;
    public WebDriver driver;
    public WebDriverWait wdw;
    JavascriptExecutor js;
    public AddBook addBook;
    public Profile profile;

    public BookStore(WebDriverManager wdm, WebDriver driver, WebDriverWait wdw, JavascriptExecutor js, AddBook addBook, Profile profile) {
        this.wdm = wdm;
        this.driver = driver;
        this.wdw = wdw;
        this.js = js;
        this.addBook = addBook;
        this.profile = profile;
    }

    By searchBox = By.id("searchBox");
    By headerRow = By.className("rt-resizable-header-content");
    By submit = By.id("submit");
    By books = By.className("-odd");

    public WebElement getSearchBox(){
        return driver.findElement(searchBox);
    }

    public List<WebElement> getHeaderRow(){
        return driver.findElements(headerRow);
    }

    public WebElement getSubmit(){
        return driver.findElement(submit);
    }

    public List<WebElement> getBooks(){
        return driver.findElements(books);
    }


    public void addNewBook() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/login");
        Thread.sleep(1000);
        new LoginBookStore(wdm,driver,js).login();
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0,500)");
        profile.getBackToStore().click();
        Thread.sleep(1000);
        getBooks().get(0).findElement(By.linkText("Git Pocket Guide")).click();
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0,500)");
        Thread.sleep(1000);
        addBook.getAddToColection().click();
        wdw.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.navigate().to(profile.url);
    }

    public void deleteBook() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/login");
        Thread.sleep(1000);
        new LoginBookStore(wdm,driver,js).login();
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0,500)");
        profile.getBackToStore().click();
        Thread.sleep(1000);
        getBooks().get(0).findElement(By.linkText("Git Pocket Guide")).click();
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0,500)");
        Thread.sleep(1000);
        addBook.getAddToColection().click();
        wdw.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.navigate().to(profile.url);
        profile.getDeleteIcon().click();
        profile.getCloseModalBtn().click();
        wdw.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void addRemoveBooks() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/login");
        Thread.sleep(1000);
        new LoginBookStore(wdm,driver,js).login();
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0,500)");
        profile.getBackToStore().click();
        for (int i = 0; i < getBooks().size(); i++) {

        }

    }

    public void filterBooks(String book){
        getSearchBox().sendKeys(book);
    }

    public void deleteAll() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/login");
        Thread.sleep(1000);
        new LoginBookStore(wdm,driver,js).login();
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0,500)");
        Thread.sleep(1000);
        profile.getBackToStore().click();
        Thread.sleep(1000);
        getBooks().get(0).findElement(By.linkText("Git Pocket Guide")).click();
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0,500)");
        Thread.sleep(1000);
        addBook.getAddToColection().click();
        wdw.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.navigate().to(profile.url);
        js.executeScript("window.scrollTo(0,500)");
        profile.getDeleteAll().click();
        driver.findElement(By.id("closeSmallModal-ok")).click();
        wdw.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

}

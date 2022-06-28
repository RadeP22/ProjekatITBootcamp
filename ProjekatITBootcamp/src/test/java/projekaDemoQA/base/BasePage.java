package projekaDemoQA.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import projekaDemoQA.pages.*;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

public class BasePage {

    public WebDriverManager wdm;
    public WebDriver driver;
    public WebDriverWait wdw;
    public Actions act;
    public JavascriptExecutor js;
    public AddBook addBook;
    public Profile profile;
    public BookStore bookSt;
    public Buttons btn;
    public CheckBox cb;
    public Links links;
    public LoginBookStore lbs;
    public OtherElements othEl;
    public TextBox tb;
    public WebTables wt;
    public Forms forms;
    public Alerts alerts;
    public BrowserWindow brWin;
    public Modals modals;
    public Accordian acord;
    public Tabs tabs;
    public Menu menu;
    public Droppable drop;

    @BeforeMethod
    public void preparation(){
        wdm = new ChromeDriverManager();
        wdm.setup();

      /*  ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("src/main/resources/addblockplus.crx"));
        driver = new ChromeDriver(options);
        wdw = new WebDriverWait(driver, Duration.ofSeconds(5));
        ArrayList<String> tab = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        wdw.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("h1"))));
        driver.close();
        driver.switchTo().window(tab.get(0)); */

        driver = new ChromeDriver();
        wdw = new WebDriverWait(driver, Duration.ofSeconds(10));
        act = new Actions(driver);
        js = (JavascriptExecutor)driver;
        addBook = new AddBook(wdm, driver);
        profile = new Profile(wdm, driver);
        bookSt = new BookStore(wdm, driver, wdw, js, addBook, profile);
        btn = new Buttons(wdm, driver, wdw, act, js);
        cb = new CheckBox(wdm,driver);
        links = new Links(wdm,driver);
        lbs = new LoginBookStore(wdm, driver, js);
        othEl = new OtherElements(wdm, driver);
        tb = new TextBox(wdm,driver,js);
        wt = new WebTables(wdm,driver,act);
        forms = new Forms(wdm,driver,wdw,js);
        alerts = new Alerts(wdm,driver);
        brWin = new BrowserWindow(wdm,driver);
        modals = new Modals(wdm,driver);
        acord = new Accordian(wdm,driver,wdw,js);
        tabs = new Tabs(wdm,driver,wdw,js);
        menu = new Menu(wdm,driver,wdw,js);
        drop = new Droppable(wdm,driver,wdw,act);
        driver.manage().window().maximize();
    }

}

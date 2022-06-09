package TestCase.cart;

import Config.env_target;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;


public class EL001 extends env_target {
    protected String url = tfile.getProperty("url");
    protected WebDriver driver;

    @Given("user go to homepage elevenia and search")
    public void user_go_to_homepage() throws Throwable {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
//        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-setuid-sandbox");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(url);

    }

    @When("^user pick produk Terlaris$")
    public void user_pick_produk() throws InterruptedException  {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/a[1]")).click();
        driver.findElement(By.xpath("//div[@class='header-big']/div[1]/div[2]/form[1]/div[1]/input[1]")).sendKeys("komputer");
        driver.findElement(By.xpath("//div[@class='header-big']/div[1]/div[2]/form[1]/div[1]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='card listInfo']/div[1]/ul[1]/li[2]/a[1]")).click();

    }
    @And("^user pick produk paling pertama$")
    public void user_pick_produk_paling_pertama() throws InterruptedException  {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='product_listing']/ul[1]/ul[1]/li[1]")).click();

    }
    @And("^user add quantity 3 and add to cart$")
    public void user_add_quantity() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='productOrder optionArea']/div[1]/ul[2]/li[1]/div[1]/div[1]/input[1]")).click();
        driver.findElement(By.xpath("//div[@class='productOrder optionArea']/div[1]/ul[2]/li[1]/div[1]/div[1]/input[1]")).sendKeys(Keys.DELETE);
        driver.findElement(By.xpath("//div[@class='productOrder optionArea']/div[1]/ul[2]/li[1]/div[1]/div[1]/input[1]")).sendKeys("3");

    }
    @And("^if any question on that popup pick yes$")
    public void any_question_on_that_popup_pick_yes() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='gridC']/div[@class='btnArea']/a[1]")).click();
        driver.findElement(By.xpath("//div[@class='layPopWrap popCart1']/div[2]/a[1]")).click();


    }
    @And("^user pick ubah curir$")
    public void user_pick_ubah_curir() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//table[@class='tableDefault tableRow tableRowLine tableTopLine shoppingList']/tbody/tr/td[6]/a[1]")).click();
        Thread.sleep(1000);

    }

    @And("^user pick batal$")
    public void user_pick_batal() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().frame(driver.findElement(By.id("ifrLayer")));
        driver.findElement(By.xpath("//form[@id='frm']/article[1]/p[3]/a[2]")).click();
        driver.switchTo().defaultContent();

    }

    @Then("user klik hapus ok")
    public void user_klik_hapus_and_ok() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//table[@class='tableDefault tableRow tableRowLine tableTopLine shoppingList']/tbody/tr/td[7]/a[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='alertPopUpLayer4']//section[@class='openPopup smallPop']//article//span[2]")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}

package org.example;

import com.inflectra.spiratest.addons.junitextension.SpiraTestCase;
import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpiraTestConfiguration(
//following are REQUIRED
        url = "https://rmit.spiraservice.net",
        login = "s3881257",
        rssToken = "{37E1C8E6-08B8-485E-8133-6219CB7D3C5D}",
        projectId = 98
)

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class updateStockTest {

    //Shared Webdriver instance for tests
    WebDriver driver;

    @BeforeAll
    void setup(){
        //Setup chrome Webdriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\OneDrive\\Documents\\RMIT\\ST\\s3881257-SeleniumTest\\chromedriver.exe");
        //Create an instance of our driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterAll
    void teardown() {
        driver.quit();
    }

    private String beforeCheckoutStock;

    @Test
    @SpiraTestCase(testCaseId = 6976)
    @Order(1)
    public void getStockDetails() {
        //Navigate to the given website in the canvas
        driver.get("https://petstore.octoperf.com/");

        //Go to the directed external link where the main functionalities exist
        WebElement EnterTheStore = driver.findElement(By.linkText("Enter the Store"));
        EnterTheStore.click();

        //Go to the sign-in link to sign in if you are a user or to see the register link if you are a new user
        WebElement SignIn = driver.findElement(By.linkText("Sign In"));
        SignIn.click();

        WebElement loginID = driver.findElement(By.name("username"));
        loginID.clear();  // Clear any pre-filled text
        loginID.sendKeys("s3881257");

        WebElement loginPassword = driver.findElement(By.name("password"));
        loginPassword.clear();  // Clear any pre-filled text
        loginPassword.sendKeys("RMIT1");

        WebElement loginSubmit = driver.findElement(By.name("signon"));
        loginSubmit.click();

        WebElement Dog = driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[2]"));
        Dog.click();

        WebElement LabRetreiver = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[6]/td[1]/a"));
        LabRetreiver.click();

        WebElement AdultMaleLR = driver.findElement(By.linkText("EST-24"));
        AdultMaleLR.click();

        WebElement stockElement = driver.findElement(By.xpath("//td[contains(text(), 'in stock') or contains(text(), 'back ordered')]"));

        //Get the stock details now
        WebElement stockElementBefore = driver.findElement(By.xpath("//td[contains(text(), 'in stock') or contains(text(), 'back ordered')]"));
        String stockTextBefore = stockElementBefore.getText();
        if (stockTextBefore.contains("in stock")) {
            beforeCheckoutStock = stockTextBefore.split(" ")[0]; // Extracting the number
        } else {
            beforeCheckoutStock = "back ordered";
        }
        System.out.println("Stock before checkout: " + beforeCheckoutStock);

        //Add to cart
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[7]/td/a"));
        addToCart.click();

        //Change the quantity
        WebElement quantity = driver.findElement(By.name("EST-24"));
        String qty = "2000";
        quantity.clear();
        quantity.sendKeys(qty);

        //update the cart
        WebElement updateCart = driver.findElement(By.name("updateCartQuantities"));
        updateCart.click();

        //Proceed to checkout
        WebElement checkout = driver.findElement(By.xpath("//*[@id=\"Cart\"]/a"));
        checkout.click();

        //click continue
        WebElement clickContinue = driver.findElement(By.name("newOrder"));
        clickContinue.click();

        //clickConfirm
        WebElement clickConfirm = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/a"));
        clickConfirm.click();
    }

    @Test
    @SpiraTestCase(testCaseId = 6977)
    @Order(2)
    public void confirmStockChange(){
        //search for product again
        WebElement searchBar = driver.findElement(By.name("keyword"));
        searchBar.sendKeys("Labrador");
        //Click on search button
        WebElement searchButton = driver.findElement(By.name("searchProducts"));
        searchButton.click();

        //Click the text description "Great hunting Dog"
        WebElement linkDes = driver.findElement(By.linkText("Great hunting dog"));
        linkDes.click();

        //Click the product again
        WebElement AdultMaleLR = driver.findElement(By.linkText("EST-24"));
        AdultMaleLR.click();

        //Get the stock details now
        WebElement stockElementAfter = driver.findElement(By.xpath("//td[contains(text(), 'in stock') or contains(text(), 'back ordered')]"));
        String stockTextAfter = stockElementAfter.getText();
        String afterCheckoutStock;
        if (stockTextAfter.contains("in stock")) {
            afterCheckoutStock = stockTextAfter.split(" ")[0]; // Extracting the number
        } else {
            afterCheckoutStock = "back ordered";
        }
        System.out.println("Stock after checkout: " + afterCheckoutStock);

        // Check if the stock has decreased or if both are "back ordered"
        if (beforeCheckoutStock.equals("back ordered") && afterCheckoutStock.equals("back ordered")) {
            assertEquals("back ordered", afterCheckoutStock, "Expected both stocks to be 'back ordered'");
        } else {
            assertTrue(Integer.parseInt(afterCheckoutStock) < Integer.parseInt(beforeCheckoutStock), "Expected stock after checkout to be less than stock before checkout");
        }
    }
}
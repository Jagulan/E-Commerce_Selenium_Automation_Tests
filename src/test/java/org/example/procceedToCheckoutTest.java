package org.example;

import com.inflectra.spiratest.addons.junitextension.SpiraTestCase;
import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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
class procceedToCheckoutTest {

    //Shared Webdriver instance for tests
    WebDriver driver;
    private String latestOrderNumber;

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

    @Test
    @SpiraTestCase(testCaseId = 5313)
    @Order(1)
    public void checkoutPersian() {
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

        //Chose the pet you want
        WebElement pet = driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[3]")); // I am going cats
        pet.click();

        //Chose Persian
        WebElement persian = driver.findElement(By.linkText("FL-DLH-02"));
        persian.click();

        //Chose Adult male Persian product ID to view details
        WebElement viewProduct = driver.findElement(By.linkText("EST-17"));
        viewProduct.click();

        //Add to cart
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[7]/td/a"));
        addToCart.click();

        //Proceed to checkout
        WebElement checkout = driver.findElement(By.xpath("//*[@id=\"Cart\"]/a"));
        checkout.click();

        //click continue
        WebElement clickContinue = driver.findElement(By.name("newOrder"));
        clickContinue.click();

        //clickConfirm
        WebElement clickConfirm = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/a"));
        clickConfirm.click();

        // Fetch the order number from the confirmation page
        WebElement orderConfirmationElement = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[1]/th"));
        String confirmationText = orderConfirmationElement.getText();

        // Use regex to extract the order number
        Pattern pattern = Pattern.compile("Order #(\\d+)");
        Matcher matcher = pattern.matcher(confirmationText);
        if (matcher.find()) {
            this.latestOrderNumber = matcher.group(1); // This will extract "20862" from the given string
        }

        // Print the fetched order number
        System.out.println("Fetched Order Number: " + this.latestOrderNumber);

        //click My account to confirm the order
        WebElement myAccount = driver.findElement(By.linkText("My Account"));
        myAccount.click();



    }

    @Test
    @SpiraTestCase(testCaseId = 5314)
    @Order(2)
    public void viewOrder() {

        // Check if you can see your order for confirmation
        WebElement myOrders = driver.findElement(By.linkText("My Orders"));
        myOrders.click();

        // Check if the table is present
        WebElement ordersTable = driver.findElement(By.tagName("table"));
        assertNotNull(ordersTable, "Orders table is not present.");

        // Fetch all order numbers from the "My Orders" table
        List<WebElement> orderNumberElements = ordersTable.findElements(By.xpath(".//tr/td[1]")); // Assuming the order number is in the first column

        // Fetch the last order number from the "My Orders" table
        WebElement lastOrderNumberElement = orderNumberElements.get(orderNumberElements.size() - 1);
        String lastOrderNumber = lastOrderNumberElement.getText();

        // Print the last order number from the table
        System.out.println("Last Order Number in the Table: " + lastOrderNumber);

        // Assert that the fetched order number and the last order number in the table are the same
        assertEquals(this.latestOrderNumber, lastOrderNumber, "The fetched order number does not match the last order number in the table.");
    }


}
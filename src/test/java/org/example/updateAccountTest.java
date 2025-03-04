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
class updateAccountTest {

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

    @Test
    @SpiraTestCase(testCaseId = 5315)
    @Order(1)
    public void testUpdateAccount() {
        //This file is for second scenario: which is to sign in and then order/checkout a pet
        //Setup chrome Webdriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\OneDrive\\Documents\\RMIT\\ST\\s3881257-SeleniumTest\\chromedriver.exe");

        //Create an instance of our driver
        WebDriver driver = new ChromeDriver();

        //Set up an implicit wait in case of slow connections.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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

        //click My account to change the details of the user's account
        WebElement myAccount = driver.findElement(By.linkText("My Account"));
        myAccount.click();

        //Change the email
        WebElement emailField = driver.findElement(By.name("account.email"));
        emailField.clear(); // delete the current email provided in the field
        emailField.sendKeys("RMIT@gmail.com");

        //Change the phone number
        WebElement phoneNo = driver.findElement(By.name("account.phone"));
        phoneNo.clear();
        phoneNo.sendKeys("0123456789");

        //save the Information
        WebElement saveInformation = driver.findElement(By.name("editAccount"));
        saveInformation.click();

        //Go back to the main page and go back to Account to see if the details are still changed
        WebElement mainPage = driver.findElement(By.xpath("//*[@id=\"LogoContent\"]/a"));
        mainPage.click();
        myAccount = driver.findElement(By.linkText("My Account"));
        myAccount.click();

        //Sign out and Sign in to check again
        WebElement signOut = driver.findElement(By.xpath("//*[@id=\"MenuContent\"]/a[2]"));
        signOut.click();

        SignIn = driver.findElement(By.linkText("Sign In"));
        SignIn.click();

        loginID = driver.findElement(By.name("username"));
        loginID.clear();  // Clear any pre-filled text
        loginID.sendKeys("s3881257");

        loginPassword = driver.findElement(By.name("password"));
        loginPassword.clear();  // Clear any pre-filled text
        loginPassword.sendKeys("RMIT1");

        loginSubmit = driver.findElement(By.name("signon"));
        loginSubmit.click();

        //click My account to change the details of the user's accounts
        myAccount = driver.findElement(By.linkText("My Account"));
        myAccount.click();


    }

    @Test
    @SpiraTestCase(testCaseId = 6274 )
    @Order(2)
    public void finalConfirmation(){

        // After updating the email and phone number, check if the changes are reflected
        WebElement updatedEmail = driver.findElement(By.name("account.email"));
        String actualEmail = updatedEmail.getAttribute("value");
        assertEquals("RMIT@gmail.com", actualEmail, "Expected email to be updated!");

        WebElement updatedPhone = driver.findElement(By.name("account.phone"));
        String actualPhone = updatedPhone.getAttribute("value");
        assertEquals("0123456789", actualPhone, "Expected phone number to be updated!");


        // After signing in again, validate if the changes are still there
        WebElement recheckedEmail = driver.findElement(By.name("account.email"));
        String recheckedEmailValue = recheckedEmail.getAttribute("value");
        assertEquals("RMIT@gmail.com", recheckedEmailValue, "Expected email to remain updated after re-login!");

        WebElement recheckedPhone = driver.findElement(By.name("account.phone"));
        String recheckedPhoneValue = recheckedPhone.getAttribute("value");
        assertEquals("0123456789", recheckedPhoneValue, "Expected phone number to remain updated after re-login!");

        driver.quit(); // Close the browser after the test
    }
}






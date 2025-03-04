package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ProcceedToCheckout {


    public static void main(String[] args) {

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

        //click My account to confirm the order
        WebElement myAccount = driver.findElement(By.linkText("My Account"));
        myAccount.click();

        //Check if you can see your order for confirmation
        WebElement myOrders = driver.findElement(By.linkText("My Orders"));
        myOrders.click();

    }

}
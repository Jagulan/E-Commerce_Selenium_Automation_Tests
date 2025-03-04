package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        //This file is for one scenario: which is to Register a new user
        //Setup chrome Webdriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\OneDrive\\Documents\\RMIT\\ST\\s3881257-SeleniumTest\\chromedriver.exe");

        //Create an instance of our driver
        WebDriver driver = new ChromeDriver();

        //Set up an implicit wait in case of slow connections.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Navigate to the given website in the canvas
        driver.get("https://petstore.octoperf.com/");

        //Go to the directed external link where the main functionalities exist
        WebElement EnterTheStore = driver.findElement(By.linkText("Enter the Store"));
        EnterTheStore.click();

        //Go to the sign-in link to sign in if you are a user or to see the register link if you are a new user
        WebElement SignIn = driver.findElement(By.linkText("Sign In"));
        SignIn.click();

        //Click the "Register Now!" if you are new user
        WebElement RegisterNow = driver.findElement(By.linkText("Register Now!"));
        RegisterNow.click();

        //Fill all the user's details to Register
        //User ID: James
        WebElement UserID = driver.findElement(By.name("username"));
        UserID.sendKeys("James");

        //New password: RMIT1
        WebElement NewPassword = driver.findElement(By.name("password"));
        NewPassword.sendKeys("RMIT1");
        //Repeat password: RMIT1
        WebElement RepeatPassword = driver.findElement(By.name("repeatedPassword"));
        RepeatPassword.sendKeys("RMIT1");
        //First Name: James
        WebElement FirstName = driver.findElement(By.name("account.firstName"));
        FirstName.sendKeys("James");
        //Last Name: Rodrick
        WebElement LastName = driver.findElement(By.name("account.lastName"));
        LastName.sendKeys("Rodric");
        //Email: s3881257@student.rmit.edu.au
        WebElement Email = driver.findElement(By.name("account.email"));
        Email.sendKeys("s3881257@student.rmit.edu.au");
        //Phone: 0493123456
        WebElement Phone = driver.findElement(By.name("account.phone"));
        Phone.sendKeys("0493123456");
        //Address 1: RMIT Melbourne City Campus
        WebElement Address_1 = driver.findElement(By.name("account.address1"));
        Address_1.sendKeys("RMIT Melbourne City Campus");
        //Address 2: La Trobe Street
        WebElement Address_2 = driver.findElement(By.name("account.address2"));
        Address_2.sendKeys("La Trobe Street");
        //City: Melbourne
        WebElement City = driver.findElement(By.name("account.city"));
        City.sendKeys("Melbourne");
        //State: Victoria
        WebElement State = driver.findElement(By.name("account.state"));
        State.sendKeys("Victoria");
        //Zip: 3000
        WebElement Zip = driver.findElement(By.name("account.zip"));
        Zip.sendKeys("3000");
        //Country: Australia
        WebElement Country = driver.findElement(By.name("account.country"));
        Country.sendKeys("Australia");
        // To select English as the preferred language
        WebElement languagePreferenceDropdown = driver.findElement(By.name("account.languagePreference"));
        Select languageSelect = new Select(languagePreferenceDropdown);
        languageSelect.selectByVisibleText("japanese");
        //To select CATS as Favourite Category
        WebElement FavoriteCategory = driver.findElement(By.name("account.favouriteCategoryId"));
        Select FavoriteCategoryDropdown = new Select(FavoriteCategory);
        FavoriteCategoryDropdown.selectByVisibleText("CATS");
        //to select "Enable MyList"
        WebElement MyList = driver.findElement(By.name("account.listOption"));
        MyList.click();
        //to select "Enable my banner"
        WebElement MyBanner = driver.findElement(By.name("account.bannerOption"));
        MyBanner.click();

        //to select "Save Account Information"
        WebElement SaveInformation = driver.findElement(By.name("newAccount"));
        SaveInformation.click();


    }
}
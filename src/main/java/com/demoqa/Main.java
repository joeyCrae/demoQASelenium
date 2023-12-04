package com.demoqa;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    @Test
    public void main() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        System.out.println("Demoqa website opened successfully");

        //Getting the Elements tab and clicking it
        WebElement elements = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]"));

        //Assert that the Elements tab is visible
        Assert.assertTrue(elements.isDisplayed(), "This is not visible");

        //Clicking the elements tab
        elements.click();

        //Text Box
        WebElement item1 = driver.findElement(By.id("item-0"));

        //Assert that item 1 is visible
        Assert.assertTrue(item1.isDisplayed(),"Item is not Displayed");

        //Clicking item 1
        item1.click();

        //Fill Form
        //Full Name field
        WebElement fullnameLabel = driver.findElement(By.id("userName-label"));
        Assert.assertTrue(fullnameLabel.isDisplayed());
        WebElement fullnameField = driver.findElement(By.id("userName"));
        fullnameField.sendKeys("Joel Bamfo");
        Assert.assertTrue(fullnameField.isDisplayed());

        //Email
        WebElement emailLabel = driver.findElement(By.id("userEmail-label"));
        Assert.assertTrue(emailLabel.isDisplayed());
        WebElement emailField = driver.findElement(By.id("userEmail"));
        emailField.sendKeys("bameybamford10@gmail.com");

        //Current Address
        WebElement addressLabel = driver.findElement(By.id("currentAddress-label"));
        Assert.assertTrue(addressLabel.isDisplayed());
        WebElement addressField = driver.findElement(By.id("currentAddress"));
        addressField.sendKeys("Somewhere in Sekondi");

        //Permanent Address
        WebElement permanentLabel = driver.findElement(By.id("permanentAddress-label"));
        Assert.assertTrue(permanentLabel.isDisplayed());
        WebElement permanentField = driver.findElement(By.id("permanentAddress"));
        permanentField.sendKeys("Somewhere in Sekondi");
        Thread.sleep(3000);

        //Submit button and assertions
        //Scroll to button command
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scroll(0, 600)");
        Thread.sleep(3000);
        executor.executeScript("document.querySelector('#submit').scrollTop=500");
        WebElement submit = driver.findElement(By.cssSelector("#submit"));
        submit.click();




        //sleep();
        driver.quit();
    }
    @Test
    public void main1() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        System.out.println("Demoqa website opened successfully");

        //Getting the Elements tab and clicking it
        WebElement elements = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]"));

        //Assert that the Elements tab is visible
        Assert.assertTrue(elements.isDisplayed(), "This is not visible");

        //Clicking the elements tab
        elements.click();

        //Text Box
        WebElement item1 = driver.findElement(By.id("item-0"));

        //Assert that item 1 is visible
        Assert.assertTrue(item1.isDisplayed(),"Item is not Displayed");

        //Clicking item 1
        item1.click();

        //Fill Form
        //Full Name field
        WebElement fullnameLabel = driver.findElement(By.id("userName-label"));
        Assert.assertTrue(fullnameLabel.isDisplayed());
        WebElement fullnameField = driver.findElement(By.id("userName"));
        fullnameField.sendKeys("Joel Bamfo");
        Assert.assertTrue(fullnameField.isDisplayed());

        //Email
        WebElement emailLabel = driver.findElement(By.id("userEmail-label"));
        Assert.assertTrue(emailLabel.isDisplayed());
        WebElement emailField = driver.findElement(By.id("userEmail"));
        emailField.sendKeys("bameybamford10@gmail.com");

        //Current Address
        WebElement addressLabel = driver.findElement(By.id("currentAddress-label"));
        Assert.assertTrue(addressLabel.isDisplayed());
        WebElement addressField = driver.findElement(By.id("currentAddress"));
        addressField.sendKeys("Somewhere in Sekondi");

        //

        sleep();
        driver.quit();
    }


    private static void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}


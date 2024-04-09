package com.demoqa;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.



public class Main {
    WebDriver driver = new ChromeDriver();
    @BeforeTest
    public void Elements() throws InterruptedException{
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        System.out.println("Demoqa website opened successfully");

        //Getting the Elements tab and clicking it
        WebElement elements = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]"));

        //Assert that the Elements tab is visible
        Assert.assertTrue(elements.isDisplayed(), "This is not visible");

        //Clicking the elements tab
        elements.click();
    }

    @Test(priority = 1)
    public void TextBox() throws InterruptedException{
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
        fullnameField.sendKeys("John Damadah");
        Assert.assertTrue(fullnameField.isDisplayed());

        //Email
        WebElement emailLabel = driver.findElement(By.id("userEmail-label"));
        Assert.assertTrue(emailLabel.isDisplayed());
        WebElement emailField = driver.findElement(By.id("userEmail"));
        emailField.sendKeys("jondoe@gmail.com");

        //Current Address
        WebElement addressLabel = driver.findElement(By.id("currentAddress-label"));
        Assert.assertTrue(addressLabel.isDisplayed());
        WebElement addressField = driver.findElement(By.id("currentAddress"));
        addressField.sendKeys("currentAddress");

        //Permanent Address
        WebElement permanentLabel = driver.findElement(By.id("permanentAddress-label"));
        Assert.assertTrue(permanentLabel.isDisplayed());
        WebElement permanentField = driver.findElement(By.id("permanentAddress"));
        permanentField.sendKeys("permanentAddress");
        Thread.sleep(3000);

        //Submit button and assertions
        //Scroll to button command
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scroll(0, 600)");
        Thread.sleep(3000);
        executor.executeScript("document.querySelector('#submit').scrollTop=500");
        WebElement submit = driver.findElement(By.cssSelector("#submit"));
        submit.click();


        sleep();
//        driver.quit();
    }

    @Test(priority = 2, groups = { "elemnetsTests", "mainPriority"})
    public void CheckBox(){
        sleep();
        //Check Box
        WebElement item2 = driver.findElement(By.id("item-1"));

        //Assert that item 2 is visible
        Assert.assertTrue(item2.isDisplayed(),"Item is not Displayed");

        //Click item 2
        item2.click();

        //Get the dropdown svg
        WebElement dropdown = driver.findElement(By.xpath("//button[@title='Toggle']//*[name()='svg']"));
        Assert.assertTrue(dropdown.isDisplayed());

        //Click the svg
        dropdown.click();

        //Select the Downloads Check Box
        sleep();
        WebElement downloads = driver.findElement(By.cssSelector("[for='tree-node-downloads']"));

        //Click Download check box
        downloads.click();

        //Assert that the success message
        WebElement successMsg = driver.findElement(By.id("result"));
        String expectedMsg = "You have selected :\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile";
        String actualMsg = successMsg.getText();
        Assert.assertTrue(actualMsg.contains(expectedMsg),"Actual message and expected message are not equal");

        sleep();
    }

    @Test(priority = 3, groups = { "elemnetsTests"})
    public void RadioButton() throws InterruptedException{
        sleep();
        //Radio Button
        WebElement item3 = driver.findElement(By.id("item-2"));

        //Assert that item 3 is visible
        Assert.assertTrue(item3.isDisplayed(),"Item is not Displayed");

        //Click item 3
        item3.click();

        //Assert that the question is visible
        WebElement question = driver.findElement(By.className("mb-3"));
        String expectedQuestion = "Do you like the site?";
        String actualQuestion = question.getText();
        Assert.assertTrue(actualQuestion.contains(expectedQuestion), "Expected, 'Do you like the site?' to be found but couldn't find it");

        //Selecting yes
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        executor.executeScript("document.querySelector('#yesRadio')");
        WebElement yesRadio = driver.findElement(By.cssSelector("label[for='yesRadio']"));
        yesRadio.click();

        //Get the labeled that is displayed
        WebElement pTags = driver.findElement(By.cssSelector("p.mt-3"));

        String expectedMsg = "You have selected Yes";
        String actualMsg = pTags.getText();

        //Asserting that the radio button is selected
        Assert.assertTrue(actualMsg.contains(expectedMsg), "Actual Message does not match the Expected Message");
        System.out.println("This assertion passed");

        sleep();
    }

    @Test
    public void  WebTables() throws InterruptedException{
        sleep();
        //Web Tables
        WebElement item4 = driver.findElement(By.id("item-3"));

        //Assert that item 4 is visible
        Assert.assertTrue(item4.isDisplayed(),"Item is not Displayed");

        //Click item 4
        item4.click();

        //Selecting Header rows
        WebElement headerRow = driver.findElement(By.className("rt-tr"));
        Assert.assertTrue(headerRow.isDisplayed());

        //Locating the first parent row
        WebElement firstParentRow = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div"));
        Assert.assertTrue(firstParentRow.isDisplayed());

        //Locating the child element Cierra and Vega
        WebElement childOne = firstParentRow.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[1]"));
        String childOneText = childOne.getText();
        System.out.println(childOneText);
        Assert.assertTrue(childOne.isDisplayed());


        WebElement childTwo = firstParentRow.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[2]"));
        String childTwoText = childTwo.getText();
        System.out.println(childTwoText);
        Assert.assertTrue(childTwo.isDisplayed());

        //Editing the first Parent row and changing the name text of Cierra to Andrade
        WebElement edit = driver.findElement(By.id("edit-record-1"));
        WebElement searchBar = driver.findElement(By.id("searchBox"));
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(searchBar);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 200)
                .perform();
        edit.click();

        //Assert that the modal appears
        WebElement modal = driver.findElement(By.className("modal-content"));
        Assert.assertTrue(modal.isDisplayed());

        //Locate the First Name a field and change the value to Andrade and save
        WebElement firstName = modal.findElement(By.id("firstName"));

        //Clear the content first
        firstName.clear();

        //Type in Andrade (new name text)
        firstName.sendKeys("Andrade");
        WebElement submit = modal.findElement(By.id("submit"));
        Assert.assertTrue(submit.isEnabled());
        Thread.sleep(2000);
        submit.click();

        String expectedText = "Andrade";
        String childOneNewText = childOne.getText();
        Assert.assertTrue(childOneNewText.contains(expectedText),"The new text Andrade was not updated");
        System.out.println(childOneNewText);

        //Locating the item 3 and deleting it
        //Assert that item 4 is visible
        Assert.assertTrue(item4.isDisplayed(),"Item is not Displayed");

        //Click item 4
        item4.click();

        //Selecting Header rows
        Assert.assertTrue(headerRow.isDisplayed());
        List<WebElement> rowGroup = driver.findElements(By.cssSelector("[role=\"row\"]"));
        System.out.println(rowGroup.size());
        for(WebElement e : rowGroup){
            System.out.println(e.getText());

            if(e.getText().equalsIgnoreCase("Alden")){
                driver.findElement(By.cssSelector("id='delete-record-3']")).click();

            }


        }

    }

    private static void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}



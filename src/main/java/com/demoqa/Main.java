package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    @Test
    public void main() {
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

//        driver.quit();
    }



}
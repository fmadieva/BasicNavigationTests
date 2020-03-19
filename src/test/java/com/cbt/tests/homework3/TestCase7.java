package com.cbt.tests.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TestCase7 {
    private WebDriver driver;
    private String URL = "https://practice-cybertekschool.herokuapp.com/";

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void test7(){
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("/Users/user/Desktop/Automation/notes/march7.txt");
        driver.findElement(By.id("file-submit")).click();
        String expectedMessage = "File Uploaded!";
        String actual = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actual,expectedMessage);
        WebElement fileName = driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(fileName.isDisplayed());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

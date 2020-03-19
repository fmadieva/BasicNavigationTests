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

public class TestCase9to12 {
    private WebDriver driver;
    private String URL = "https://practice-cybertekschool.herokuapp.com/";


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);
        driver.findElement(By.linkText("Status Codes")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test9(){
        driver.findElement(By.linkText("200")).click();
        String expected = "This page returned a 200 status code.";
        WebElement message = driver.findElement(By.xpath("//p[contains(text(),'200')]"));
        Assert.assertTrue(message.getText().contains(expected));
    }

    @Test
    public void test10(){
        driver.findElement(By.linkText("301")).click();
        String expected = "This page returned a 301 status code.";
        WebElement message = driver.findElement(By.xpath("//p[contains(text(),'301')]"));
        Assert.assertTrue(message.getText().contains(expected));
    }

    @Test
    public void test11(){
        driver.findElement(By.linkText("404")).click();
        String expected = "This page returned a 404 status code.";
        WebElement message = driver.findElement(By.xpath("//p[contains(text(),'404')]"));
        Assert.assertTrue(message.getText().contains(expected));
    }

    @Test
    public void test12(){
        driver.findElement(By.linkText("500")).click();
        String expected = "This page returned a 500 status code.";
        WebElement message = driver.findElement(By.xpath("//p[contains(text(),'500')]"));
        Assert.assertTrue(message.getText().contains(expected));
    }
}

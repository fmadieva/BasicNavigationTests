package com.cbt.tests.homework3;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class TestCase1to5 {
    private WebDriver driver;
    private String URL = "https://practice-cybertekschool.herokuapp.com/";
    private By registrationFormBy = By.linkText("Registration Form");

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(registrationFormBy).click();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void testCase1(){

        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        WebElement warningMessage = driver.findElement(By.xpath("//*[text()='The date of birth is not valid']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }



    @Test
    public void testCase2(){

        WebElement cplusplus = driver.findElement(By.xpath("//input[@id='inlineCheckbox1']/following-sibling::label"));
        WebElement java = driver.findElement(By.xpath("//label[text()='Java']"));
        WebElement javaScript = driver.findElement(By.cssSelector("label[for='inlineCheckbox3']"));
        Assert.assertTrue(cplusplus.isDisplayed());
        Assert.assertTrue(java.isDisplayed());
        Assert.assertTrue(javaScript.isDisplayed());
    }



    @Test
    public void testCase3(){
        driver.findElement(By.name("firstname")).sendKeys("a");
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }



    @Test
    public void testCase4(){
        driver.findElement(By.name("lastname")).sendKeys("a");
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }



    @Test
    public void testCase5(){
        driver.findElement(By.name("firstname")).sendKeys("Fariza");
        driver.findElement(By.name("lastname")).sendKeys("Madieva");
        driver.findElement(By.name("username")).sendKeys("fmadieva");
        driver.findElement(By.name("email")).sendKeys("fariza.madieva@gmail.com");
        driver.findElement(By.name("password")).sendKeys("supersecretpassword2020");
        driver.findElement(By.name("phone")).sendKeys("575-230-2030");
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.name("birthday")).sendKeys("05/30/1993");
        Select departmentSelect = new Select(driver.findElement(By.name("department")));
        departmentSelect.selectByVisibleText("Department of Engineering");
        Select jobTitleSelect = new Select(driver.findElement(By.name("job_title")));
        jobTitleSelect.selectByVisibleText("SDET");
        driver.findElement(By.xpath("//label[text()='Java']")).click();
        driver.findElement(By.id("wooden_spoon")).click();
        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(actual,expected);
    }

}

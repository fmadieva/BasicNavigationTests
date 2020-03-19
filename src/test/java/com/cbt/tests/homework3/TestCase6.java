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

public class TestCase6 {
    WebDriver driver;
    String URL = "https://www.tempmailaddress.com/";

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);
        driver.manage().window().maximize();
    }

  @Test
   public void Testcase6(){

      driver.get("https://www.tempmailaddress.com/");
      String email = driver.findElement(By.id("email")).getText();
      driver.get("https://practice-cybertekschool.herokuapp.com/");
      driver.findElement(By.linkText("Sign Up For Mailing List")).click();
      driver.findElement(By.name("full_name")).sendKeys("Tom Smith");
      driver.findElement(By.name("email")).sendKeys(email);
      driver.findElement(By.name("wooden_spoon")).click();
      WebElement message = driver.findElement(By.tagName("h3"));
      Assert.assertTrue(message.isDisplayed());
      driver.navigate().to("https://www.tempmailaddress.com");
      WebElement emailFrom = driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[1]/td[1]"));
      Assert.assertTrue(emailFrom.isDisplayed());
      emailFrom.click();
      String expectedEmailFrom = "do-not-reply@practice.cybertekschool.com";
      String actualEmailFrom = driver.findElement(By.id("odesilatel")).getText();
      Assert.assertEquals(actualEmailFrom,expectedEmailFrom);
      String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
      String actualSubject = driver.findElement(By.id("predmet")).getText();
      Assert.assertEquals(actualSubject,expectedSubject);

  }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

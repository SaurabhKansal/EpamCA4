package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 */
public class AppTest
{
    ChromeDriver driver;
    @BeforeClass
    void setupDriver () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://webdriveruniversity.com/.well-known/captcha/?r=%2FDropdown-Checkboxes-RadioButtons%2Findex.html");
        driver.manage().window().maximize();
    }
    @Test
    void websiteLogin() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"dropdowm-menu-1\"]/option[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"dropdowm-menu-2\"]/option[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"dropdowm-menu-3\"]/option[3]")).click();

        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[2]/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[3]/input")).click();

        driver.findElement(By.xpath("//*[@id=\"radio-buttons\"]/input[3]")).click();
        Thread.sleep(2000);
    }

    @AfterClass
    void closeDriver () {
        driver.close();
    }

}

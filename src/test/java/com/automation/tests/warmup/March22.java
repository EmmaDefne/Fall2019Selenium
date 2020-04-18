package com.automation.tests.warmup;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class March22 {


    @Test
    public void test(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekshool.com/tables");
        driver.findElement(By.xpath("//table[1]//*[text()='Last Name']")).click();
        BrowserUtils.wait(6);

        List<WebElement> column= driver.findElements(By.xpath("//table[1]//tbody//td[1]"));

        for(int i=0;i<column.size()-1;i++){
            String value=column.get(i).getText();
            String nextValue = column.get(i+1).getText();

            Assert.assertTrue(value.compareTo(nextValue)<=0);
        }
        driver.quit();
    }
}

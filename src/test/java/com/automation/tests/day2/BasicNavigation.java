package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://google.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        String title=driver.getTitle();
        String expected = "Google";
        System.out.println("The title is "+title);
        if(expected.equals(title)   ){
            System.out.println("TEST PASSED...");
        }else{
            System.out.println("TEST FAILED");
        }

        driver.navigate().to("http://amazon.com");
        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("TEST PASSED...");
        }else{
            System.out.println("TEST FAILED");

        }
        driver.navigate().back();
        verifyEqual(driver.getTitle(),"Google");
        driver.navigate().forward();

        System.out.println("The title is...."+driver.getTitle());
        System.out.println("URL====>"+driver.getCurrentUrl());
        driver.navigate().refresh();
        driver.close();
    }
    public static void verifyEqual(String arg1,String arg2){
        if(arg1.equals(arg2)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }
    }
}

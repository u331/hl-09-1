package com.automationpractice;

//Lesson 9
//Home work 1
//Открыть главную страницу automationpractice.com
//Открыть форму регистрации нового клиента (Sign in )
//В секции Create an account ввести корректный емейл
//Нажать Create an account
//На форме регистрации заполнить ВСЕ ОБЯЗАТЕЛЬНЫЕ поля , КРОМЕ выпадающих списков
//Нажать Register
//Проверить что сообщение валидации содержит текст ,
//  например “There are 3 errors”

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Task01Test {
    private final String MAIN_PAGE_URL ="http://automationpractice.com";
    private EmailGenerator gen = new EmailGenerator("ukr.net", 8);

    private String myTest(WebDriver driver){
        driver.navigate().to(MAIN_PAGE_URL);
        driver.findElement(By.cssSelector("#header div.header_user_info a")).click();
//        driver.findElement(By.id("email_create")).sendKeys("463463w46@ukr.net");
        driver.findElement(By.id("email_create")).sendKeys(gen.getEmail());
        driver.findElement(By.id("SubmitCreate")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("John Joseph");
        driver.findElement(By.id("customer_lastname")).sendKeys("Travolta");
        driver.findElement(By.id("passwd")).sendKeys("swordfish");
        driver.findElement(By.id("firstname")).sendKeys("John Joseph");
        driver.findElement(By.id("lastname")).sendKeys("Travolta");
        driver.findElement(By.id("address1")).sendKeys("Hollywood, CA, USA");
        driver.findElement(By.id("city")).sendKeys("Los Angeles");
        driver.findElement(By.id("postcode")).sendKeys("12345");
//        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("12345");
//        driver.findElement(By.cssSelector("label[for='postcode']+input")).sendKeys("12345");
        driver.findElement(By.id("phone_mobile")).sendKeys("(310) 359-6034");
        driver.findElement(By.id("submitAccount")).click();
        return driver.findElement(By.cssSelector("#center_column .alert.alert-danger p")).getText();
    }

    @Test
    public void myTestChrome(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        Assert.assertTrue( myTest(chromeDriver).equalsIgnoreCase("There is 1 error"));
    }

    @Test
    public void myTestFF(){
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        WebDriver ffDriver = new FirefoxDriver();
        ffDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        ffDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        ffDriver.manage().window().maximize();
        Assert.assertTrue( myTest(ffDriver).equalsIgnoreCase("There is 1 error"));
    }

}

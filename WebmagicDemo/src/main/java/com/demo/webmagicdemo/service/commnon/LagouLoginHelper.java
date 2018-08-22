package com.demo.webmagicdemo.service.commnon;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

/**
 * @Author wb-hx347246
 * @Date 2018/8/22 下午3:48
 */
@UtilityClass
public class LagouLoginHelper {

    public Set<Cookie> login(){
        String os = System.getProperty("os.name").toLowerCase();
        System.setProperty("webdriver.chrome.driver","/usr/local/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless","--disable-gpu");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://passport.lagou.com/login/login.html");

        driver.findElement(By.xpath("//input[@placeholder='请输入常用手机号/邮箱']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='请输入常用手机号/邮箱']")).sendKeys("17665241003");

        driver.findElement(By.xpath("//input[@placeholder='请输入密码']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='请输入密码']")).sendKeys("Hekeyi1113");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println();

        return driver.manage().getCookies();
    }

    public Set<Cookie> generateCookie(){
        System.setProperty("webdriver.chrome.driver","/usr/local/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless","--disable-gpu");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.lagou.com");

        driver.findElement(By.id("search_input")).clear();
        driver.findElement(By.id("search_input")).sendKeys("java");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return driver.manage().getCookies();

    }

}

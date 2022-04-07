import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class seleniumwebdrivertester {
    public static void main(String[] args)  throws InterruptedException{

        // ДЕКЛАРАЦИЯ О НАМЕРЕНИИ
        //pageObject - задает струтуру страницы, которую тестируют
        // заголовок
        // адресс страницы
        // скрин экрана
        // навигация
        //элементы для ввода найдены ()

        // наслдеование конткретной старинцы сайт LoginPage

        System.setProperty("webdriver.chrome.driver","C:\\MyData\\WebDrivers\\chromedriver.exe"); // Setting system properties of FirefoxDriver
        WebDriver driver = new ChromeDriver(); //Creating an object of FirefoxDriver
        LoginPage loginPage = new LoginPage("LOGIN MINFIN",
                "https://developers.minfin.com.ua/login/",
                driver);
        loginPage.printScreenToFile();
        loginPage.navigateToLoginPage();
        if (loginPage.canUseElements()) {
            System.out.println("Заголовок 1 " + loginPage.getTitle());
            System.out.println("Адрес 1 " + loginPage.getAddress());
            loginPage.printScreenToFile();
            loginPage = loginPage.login();
            String actualAddress = loginPage.currentDriver().getCurrentUrl();
            String expectedAddress = "https://developers.minfin.com.ua/";
            System.out.println("actualAddress = "+actualAddress);
            System.out.println("expectedAddress = "+expectedAddress);
        }
        else
        {
            System.out.println("Ошибка навигации");
        }


        Thread.sleep(5000);// пауза в 5 секунд = время отдыха JVM
        driver.quit();

    }
    public static void main_local(String[] args) {

        System.setProperty("webdriver.chrome.driver","D:\\WebDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("file:///C:/MyData/home.html");

        System.out.println("Заголовок " + driver.getTitle());
        System.out.println("Загруженный адрес " + driver.getCurrentUrl());




        WebElement input = driver.findElement(By.xpath("//input[@name=\"idpass\"]"));
        if (input != null)
        {
            input.sendKeys("Hello world");
        }

        WebElement secondInput = driver.findElement(By.id("fistname"));
        if (secondInput != null) {

            secondInput.sendKeys("Bohdan");
        }

        WebElement button = driver.findElement(By.name("btnClick"));
        if (button != null) {
            button.click();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

    }


}

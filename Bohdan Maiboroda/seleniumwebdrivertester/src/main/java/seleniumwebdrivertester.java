import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumwebdrivertester {
    public static void main(String[] args) {

        // дЕКЛАРАЦИЯ О НАМЕРЕНИИ
        //pageObject - задает струтуру страницы, которую тестируют
        // заголовок
        // адресс страницы
        // скрин экрана
        // навигация
        //элементы для ввода найдены ()

        // наслдеование конткретной старинцы сайт LoginPage

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

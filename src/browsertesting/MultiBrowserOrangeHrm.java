package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Scanner;
//multibrowser testing for orangehrmlive.com
public class MultiBrowserOrangeHrm {
    static WebDriver driver;
    static String browser;
    static String baseUrl;

    public static void main(String[] args) {
        // accepting input to choose a browser
        System.out.println("Enter your Browser");
        Scanner sc = new Scanner(System.in);
        browser = sc.nextLine();
        //Using if - else  to open the website in selected browser
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {

            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("Please choose one of the following browsers: Chrome,Edge,Firefox ");
        }

        baseUrl = "https://opensource-demo.orangehrmlive.com/";
        //launches the URL in the browser chosen
        driver.get(baseUrl);
        driver.manage().window().maximize();
        //displays the browser with entered username and password fields
        WebElement emailField = driver.findElement(By.id("txtUsername"));
        emailField.sendKeys("Admin");

        WebElement passwordField = driver.findElement(By.name("txtPassword"));
        passwordField.sendKeys("admin123");
        //close the driver
        driver.close();

    }
}
package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {
        // Path ke chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\ToolsQA\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://practicetestautomation.com/practice-test-login/");

            // Isi username
            WebElement username = driver.findElement(By.id("username"));
            username.sendKeys("student");

            // Isi password
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("Password123");

            // Klik login
            WebElement loginButton = driver.findElement(By.id("submit"));
            loginButton.click();

            // tunggu 2 detik
            Thread.sleep(2000); 

            // Cek hasil login
            String successText = driver.findElement(By.tagName("h1")).getText();
            System.out.println("Login result: " + successText);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // tutup browser
        }
    }
}

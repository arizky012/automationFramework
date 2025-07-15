package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginTest {
	// menunggu semua elemen di load
	public static WebElement waitVisible(WebDriver driver, By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
    public static void main(String[] args) {
        // Path ke chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\ToolsQA\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://practicetestautomation.com/practice-test-login/");
            
            // Isi username
            WebElement username = waitVisible(driver,By.id("username"));
            username.sendKeys("student");

            // Isi password
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("Password123");

            // Klik login
            WebElement loginButton = driver.findElement(By.id("submit"));
            loginButton.click();


            // Cek hasil login
            String successText = waitVisible(driver,By.tagName("h1")).getText();
            
            if (successText.equals("Logged In Successfully")) {
                System.out.println("Login Success ✅");
          
                // langsung logout setelah login berhasil
                WebElement logoutButton = driver.findElement(By.linkText("Log out"));
                
                logoutButton.click();
                System.out.println("Logout After login : Success");
            } else {
                System.out.println("Login gagal ❌");
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	// tutup browser
            driver.quit(); 
        }
    }
}

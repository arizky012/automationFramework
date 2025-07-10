package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {
	public static void main(String[] args) {
		// Set the system property for ChromeDriver (path to chromedriver executable)
		System.setProperty("webdriver.chrome.driver", "C:\\ToolsQA\\chromedriver-win64\\chromedriver.exe");

		// Create an instance of ChromeDriver (launch the Chrome browser)
		WebDriver driver = new ChromeDriver();

		try {
			// Navigate to the desired website ()
			driver.get("https://practicetestautomation.com");
			// Get and print the page title
			String pageTitle = driver.getTitle();
			System.out.println("Page Title: " + pageTitle);

			// Wait for a few seconds (for demonstration purposes only)
			Thread.sleep(3000);
			System.out.println("Execution complete");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}
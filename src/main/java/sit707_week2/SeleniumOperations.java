package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.apache.commons.io.FileUtils;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void officeworks_registration_page(String url) {
        // Step 1: Locate chrome driver folder in the local drive.
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64/chromedriver.exe");

        // Step 2: Use above chrome driver to open up a chromium browser.
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();

        System.out.println("Driver info: " + driver);

        sleep(2);

        // Load a webpage in chromium browser.
        driver.get(url);

        // Find first input field which is firstname
        WebElement element = driver.findElement(By.id("firstname"));
        System.out.println("Found element: " + element);
        // Send first name
        element.sendKeys("Seth");

        // Find following input fields and populate with values
        WebElement element1 = driver.findElement(By.id("lastname"));
        System.out.println("Found element: " + element1);
        // Send last name
        element1.sendKeys("Johnson");

        WebElement element2 = driver.findElement(By.id("phoneNumber"));
        System.out.println("Found element: " + element2);
        // Send phone number
        element2.sendKeys("0481511082");

        WebElement element3 = driver.findElement(By.id("email"));
        System.out.println("Found element: " + element3);
        // Send email address
        element3.sendKeys("sethj4774@gmail.com");

        WebElement element4 = driver.findElement(By.id("password"));
        System.out.println("Found element: " + element4);
        // Send password
        element4.sendKeys("sui");

        WebElement element5 = driver.findElement(By.id("confirmPassword"));
        System.out.println("Found element: " + element5);
        // Send password confirmation
        element5.sendKeys("sui");

        // Identify button 'Create account' and click to submit using Selenium API.
        WebElement createAccountButton = driver.findElement(By.cssSelector(".ActionButton__StyledButton-r7njn9-0.iJIqgV"));
        createAccountButton.click();

        // Take screenshot using selenium API and save it as a file
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("screenshot.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Sleep a while
        sleep(5);

        // close chrome driver
        driver.close();
    }
}

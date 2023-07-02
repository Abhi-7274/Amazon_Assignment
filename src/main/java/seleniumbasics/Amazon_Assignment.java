package seleniumbasics;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon_Assignment {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");

        // Search for the desired wrist watch
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Wrist Watches");

        // Click the search button
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        // Apply filters for Display, Brands Material, Brand, and Discount
        WebElement displayFilter = driver.findElement(By.xpath("//span[contains(text(), 'Analogue')]"));
        displayFilter.click();

        WebElement materialFilter = driver.findElement(By.xpath("//span[contains(text(), 'Leather')]"));
        materialFilter.click();

        WebElement brandFilter = driver.findElement(By.xpath("//span[contains(text(), 'Titan')]"));
        brandFilter.click();

        WebElement discountFilter = driver.findElement(By.xpath("//span[contains(text(), '25% Off or more')]"));
        discountFilter.click();


	  // Wait for the search results to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[data-index]")));

        // Get the fifth element from the search results
        WebElement fifthElement = driver.findElements(By.cssSelector("div[data-index]")).get(4);
        String fifthElementText = fifthElement.getText();
        System.out.println("Fifth element: " + fifthElementText);

        // Close the browser
       driver.quit();
    }
}


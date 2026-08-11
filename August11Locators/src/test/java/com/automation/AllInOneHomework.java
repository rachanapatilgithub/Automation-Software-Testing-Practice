package com.automation;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AllInOneHomework {
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("--- STARTING ALL-IN-ONE HOMEWORK TEST ---");
        
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");
        
        System.out.println("\n--- CSS SELECTOR STRATEGIES ---");
        System.out.println("1. CSS Starts-With (^):");
        driver.findElement(By.cssSelector("input[name^='mobi']")).sendKeys("11111");
        
        System.out.println("2. CSS Ends-With ($):");
        driver.findElement(By.cssSelector("input[name$='ile']")).clear();
        driver.findElement(By.cssSelector("input[name$='ile']")).sendKeys("22222");
        
        System.out.println("3. CSS By Class (.):");
        driver.findElement(By.cssSelector(".form-control")).click();

        System.out.println("\n--- XPATH STRATEGIES ---");
        System.out.println("4. XPath Exact Attribute:");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test@xpath.com");
        
        System.out.println("5. XPath Contains:");
        driver.findElement(By.xpath("//input[contains(@name,'mob')]")).clear();
        driver.findElement(By.xpath("//input[contains(@name,'mob')]")).sendKeys("33333");
        
        System.out.println("6. XPath Starts-With:");
        driver.findElement(By.xpath("//input[starts-with(@name,'mobi')]")).clear();
        driver.findElement(By.xpath("//input[starts-with(@name,'mobi')]")).sendKeys("44444");
        
        System.out.println("7. XPath Multiple Attributes (AND):");
        driver.findElement(By.xpath("//input[@placeholder='Password' and @id='password']")).sendKeys("Secret123");
        
        System.out.println("8. XPath By Index [1]:");
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("First Box Index");
        
        System.out.println("9. Absolute XPath:");
        driver.findElement(By.xpath("/html/body/div/div[2]/form/div[1]/input")).clear();
        driver.findElement(By.xpath("/html/body/div/div[2]/form/div[1]/input")).sendKeys("Absolute Path");
        
        System.out.println("10. Relative XPath with Asterisk (*):");
        driver.findElement(By.xpath("//*[@id='name']")).clear();
        driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Asterisk User");

        System.out.println("\n--- BASIC LOCATORS & TEXT CLICKS ---");
        System.out.println("11. Basic ID:");
        driver.findElement(By.id("mobile")).clear();
        driver.findElement(By.id("mobile")).sendKeys("55555");
        
        System.out.println("12. XPath By Text (Clicking link):");
        driver.findElement(By.xpath("//a[text()='I already have a membership']")).click();
        
        System.out.println("Waiting 2 seconds and navigating back...");
        Thread.sleep(2000);
        driver.navigate().back();
        
        System.out.println("13. Basic Partial Link Text (Clicking link):");
        driver.findElement(By.partialLinkText("already have a")).click();
        
        System.out.println("\n--- ALL-IN-ONE TEST COMPLETED SUCESSFULLY! ---");
    }
}
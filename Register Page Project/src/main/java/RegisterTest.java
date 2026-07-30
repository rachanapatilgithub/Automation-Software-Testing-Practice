import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    public static void main(String[] args) throws InterruptedException {

        // 1. Open Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Open the login page of the live project
        driver.get("https://javabykiran.com/liveproject/index.html");

        // 3. Click on "Register a new membership" link
        driver.findElement(By.linkText("Register a new membership")).click();

        // 4. Fill the registration form
        driver.findElement(By.id("name")).sendKeys("Sumesh Patil");
        driver.findElement(By.id("mobile")).sendKeys("9876543210");
        driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");

        // 5. Click on Register button
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Thread.sleep(3000);

        System.out.println("Step 1 : Registration completed");

        // 6. Go back to login page and login with same credentials
        driver.findElement(By.linkText("I already have a membership")).click();

        driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Thread.sleep(3000);

        System.out.println("Step 2 : Login completed, Dashboard opened");

        // 7. Click through all the menu links in the sidebar (do NOT click Logout yet)
        driver.findElement(By.linkText("Dashboard")).click();
        Thread.sleep(1000);

        driver.findElement(By.linkText("Users")).click();
        Thread.sleep(1000);

        driver.findElement(By.linkText("Operators")).click();
        Thread.sleep(1000);

        driver.findElement(By.linkText("Useful Links")).click();
        Thread.sleep(1000);

        driver.findElement(By.linkText("Downloads")).click();
        Thread.sleep(1000);

        System.out.println("Step 3 : Visited Dashboard, Users, Operators, Useful Links, Downloads");

        // 8. Go to Users page again and click "Add User"
        driver.findElement(By.linkText("Users")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[contains(text(),'Add User')]")).click();
        Thread.sleep(1000);

        // 9. Fill the Add User form
        driver.findElement(By.id("username")).sendKeys("Sumesh Patil");
        driver.findElement(By.id("mobile")).sendKeys("9876543210");
        driver.findElement(By.id("email")).sendKeys("sumesh@gmail.com");
        driver.findElement(By.id("course")).sendKeys("Selenium");
        driver.findElement(By.id("Male")).click();
        driver.findElement(By.cssSelector("select.form-control")).sendKeys("Maharashtra");
        driver.findElement(By.id("password")).sendKeys("123456");

        // 10. Click Submit (this page shows a JavaScript alert on submit)
        driver.findElement(By.id("submit")).click();

        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        System.out.println("Step 4 : New user added");

        Thread.sleep(2000);

        // 11. Finally click Logout
        driver.findElement(By.linkText("LOGOUT")).click();

        Thread.sleep(2000);

        System.out.println("Step 5 : Logout completed. Project flow finished");

        // 12. Close the browser
        driver.quit();
    }
}

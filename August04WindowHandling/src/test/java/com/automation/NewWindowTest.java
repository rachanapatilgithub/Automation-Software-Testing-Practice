package com.automation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.Set;

public class NewWindowTest {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        
        String Parent = driver.getWindowHandle();
        System.out.println("Parent window ID - " +Parent);
        System.out.println("Parent Window Title - "+driver.getTitle());
        
        WebElement newwindowbutton = driver.findElement(By.id("newWindowBtn"));
        
        newwindowbutton.click();
        
        newwindowbutton.click();
        
        newwindowbutton.click();
        
        Set<String> allwin = driver.getWindowHandles();
        
        for(String w : allwin) {
            if(!w.equals(Parent)) {
                // Code continues below but is cut off in the screenshot
            }
        }
    }
}
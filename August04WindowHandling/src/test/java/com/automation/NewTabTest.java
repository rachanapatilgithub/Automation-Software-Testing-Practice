package com.automation; 


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.Set;

public class NewTabTest {
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/window-operations/");
        
        String parentwindow = driver.getWindowHandle();
        System.out.println("Parent window ID - " + parentwindow);
        System.out.println(driver.getTitle());
        
        WebElement newtab = driver.findElement(By.xpath("//*[@id=\"post-1147\"]/div/p[3]/button"));
        newtab.click();  // to check traversing clicked the new tab button first time
        newtab.click();  // to check traversing clicked the new tab button 2nd time  so that multiple tabs will open
        
        Set<String> windows = driver.getWindowHandles();
        
        for (String ww : windows) {
            
            if (!ww.equals(parentwindow)) {     // this condition is checks that window should not be parent window
                
                driver.switchTo().window(ww);
                
                Thread.sleep(1000);
                System.out.println("Window ID - " + ww);
                
                //driver.switchTo().window(parentwindow);
                
                // driver.close();
            }
        }
    }
}
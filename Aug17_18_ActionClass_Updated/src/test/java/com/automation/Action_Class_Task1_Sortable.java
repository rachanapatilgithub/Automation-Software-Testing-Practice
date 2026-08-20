package com.automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_Class_Task1_Sortable {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.tutorialspoint.com/selenium/practice/sortable.php");

        Actions act = new Actions(driver);

        List<WebElement> rows = driver.findElements(By.cssSelector("table.table-sortable tbody tr"));
        System.out.println("List row 1 before: " + rows.get(0).getText());

        drag(act, rows.get(0), rows.get(2));

        Thread.sleep(2000);

        rows = driver.findElements(By.cssSelector("table.table-sortable tbody tr"));
        System.out.println("List row 1 after: " + rows.get(0).getText());

        driver.findElement(By.id("nav-profile-tab")).click();

        Thread.sleep(2000);

        List<WebElement> cards = driver.findElements(By.cssSelector(".thumbnail-sortable > div"));
        System.out.println("Grid card 1 before: " + cards.get(0).findElement(By.tagName("h3")).getText());

        drag(act, cards.get(0), cards.get(2));

        Thread.sleep(2000);

        cards = driver.findElements(By.cssSelector(".thumbnail-sortable > div"));
        System.out.println("Grid card 1 after: " + cards.get(0).findElement(By.tagName("h3")).getText());

        driver.quit();
    }

    private static void drag(Actions act, WebElement source, WebElement target) {
        act.clickAndHold(source)
           .moveByOffset(1, 1)
           .pause(Duration.ofMillis(200))
           .moveToElement(target)
           .pause(Duration.ofMillis(200))
           .release()
           .perform();
    }
}

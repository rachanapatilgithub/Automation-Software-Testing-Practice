package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_Class_Task2_DragDrop {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://qaplayground.com/practice/drag-drop");

        Actions act = new Actions(driver);

        //Scenario 1 - drag the item into the drop zone
        WebElement item = driver.findElement(By.cssSelector("[data-testid='dd-item']"));
        WebElement dropZone = driver.findElement(By.cssSelector("[data-testid='dd-drop-zone']"));
        act.dragAndDrop(item, dropZone).perform();
        System.out.println(driver.findElement(By.cssSelector("[data-testid='result-s01']")).getText());

        //Scenario 2 - drag each card to its matching zone
        WebElement alpha = driver.findElement(By.cssSelector("[data-card-id='card-1']"));
        WebElement beta = driver.findElement(By.cssSelector("[data-card-id='card-2']"));
        WebElement gamma = driver.findElement(By.cssSelector("[data-card-id='card-3']"));
        WebElement zoneA = driver.findElement(By.cssSelector("[data-zone-id='zone-a']"));
        WebElement zoneB = driver.findElement(By.cssSelector("[data-zone-id='zone-b']"));
        WebElement zoneC = driver.findElement(By.cssSelector("[data-zone-id='zone-c']"));
        act.dragAndDrop(alpha, zoneA)
           .dragAndDrop(beta, zoneB)
           .dragAndDrop(gamma, zoneC)
           .perform();
        System.out.println(driver.findElement(By.cssSelector("[data-testid='result-s02']")).getText());

        //Scenario 3 - reorder the sortable list
        WebElement item1 = driver.findElement(By.cssSelector("[data-item-id='item-1']"));
        WebElement item3 = driver.findElement(By.cssSelector("[data-item-id='item-3']"));
        act.dragAndDrop(item1, item3).perform();
        System.out.println(driver.findElement(By.cssSelector("[data-testid='result-s03']")).getText());

        //Scenario 4 - move a task from Todo to Done
        WebElement task = driver.findElement(By.cssSelector("[data-task-id='task-2']"));
        WebElement doneColumn = driver.findElement(By.cssSelector("[data-column-id='done']"));
        act.dragAndDrop(task, doneColumn).perform();
        System.out.println(driver.findElement(By.cssSelector("[data-testid='result-s04']")).getText());

        //Scenario 5 - drop the circle shape into its matching zone
        WebElement circle = driver.findElement(By.cssSelector("[data-item-type='shape-circle']"));
        WebElement circleZone = driver.findElement(By.cssSelector("[data-accepts='shape-circle']"));
        act.dragAndDrop(circle, circleZone).perform();
        System.out.println(driver.findElement(By.cssSelector("[data-testid='result-s05']")).getText());

        //Scenario 6 - move a card from Backlog to In Progress
        WebElement card = driver.findElement(By.cssSelector("[aria-label='Board card: Write API tests']"));
        WebElement inProgressColumn = driver.findElement(By.cssSelector("[data-column-id='in-progress']"));
        act.dragAndDrop(card, inProgressColumn).perform();
        System.out.println(driver.findElement(By.cssSelector("[data-testid='result-s06']")).getText());

        driver.quit();
    }
}

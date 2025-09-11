package ApiDemos_AppTests;

import ApiDemos_App.PagesLocators;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Collections;

public class DragDropTest extends TestBase
{
    PagesLocators pageLocators;

    public void dragAndDrop(AndroidDriver driver, WebElement source, WebElement target)
    {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragAndDrop = new Sequence(finger, 1);

        // Calculate center of source element
        int startX = source.getLocation().getX() + source.getSize().getWidth() / 2;
        int startY = source.getLocation().getY() + source.getSize().getHeight() / 2;

        // Calculate center of target element
        int endX = target.getLocation().getX() + target.getSize().getWidth() / 2;
        int endY = target.getLocation().getY() + target.getSize().getHeight() / 2;

        // Move finger to the start point
        dragAndDrop.addAction(finger.createPointerMove
                (Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // Move finger to the end point (with a delay to simulate real drag)
        dragAndDrop.addAction(finger.createPointerMove
                (Duration.ofSeconds(5), PointerInput.Origin.viewport(), endX, endY));

        // Release
        dragAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the sequence
        driver.perform(Collections.singletonList(dragAndDrop));
    }




    public void Drag(AndroidDriver driver, WebElement source)
    {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence drag = new Sequence(finger, 1);

        // Calculate center of source element
        int startX = source.getLocation().getX() + source.getSize().getWidth() / 2;
        int startY = source.getLocation().getY() + source.getSize().getHeight() / 2;

        // Move finger to the start point
        drag.addAction(finger.createPointerMove
                (Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        drag.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the sequence
        driver.perform(Collections.singletonList(drag));
    }



    public void Drop(AndroidDriver driver, WebElement target)
    {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence drop = new Sequence(finger, 1);

        // Calculate center of target element
        int endX = target.getLocation().getX() + target.getSize().getWidth() / 2;
        int endY = target.getLocation().getY() + target.getSize().getHeight() / 2;

        // Move finger to the end point (with a delay to simulate real drag)
        drop.addAction(finger.createPointerMove
                (Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, endY));

        // Release
        drop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the sequence
        driver.perform(Collections.singletonList(drop));
    }



    public void dragAndDropWithHiddenTarget(AndroidDriver driver, WebElement source, WebElement target)
    {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragAndDrop = new Sequence(finger, 1);

        // Step 1: Get center of the source element
        int startX = source.getLocation().getX() + source.getSize().getWidth() / 2;
        int startY = source.getLocation().getY() + source.getSize().getHeight() / 2;

        // Step 2: Long press and hold on source element
        dragAndDrop.addAction(finger.createPointerMove
                (Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // Step 3: Wait (simulate long-press)
        dragAndDrop.addAction(new Pause(finger, Duration.ofSeconds(1))); // 1 sec hold

        // Step 4: Perform initial long press (before drop target appears)
        driver.perform(Collections.singletonList(dragAndDrop));

        // Step 5: Wait for the drop target to become visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(target));

        // Step 6: Get center of the now-visible target element
        int endX = target.getLocation().getX() + target.getSize().getWidth() / 2;
        int endY = target.getLocation().getY() + target.getSize().getHeight() / 2;

        // Step 7: Continue drag from source to target
        Sequence moveAndDrop = new Sequence(finger, 1);
        moveAndDrop.addAction(finger.createPointerMove
                (Duration.ofSeconds(5), PointerInput.Origin.viewport(), endX, endY));
        moveAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Step 8: Perform the final drag to drop
        driver.perform(Collections.singletonList(moveAndDrop));
    }




    @Test
    public void Drag_and_Drop() throws MalformedURLException
    {
        Android_setUp();
        pageLocators = new PagesLocators(driver);

        pageLocators.clickViews();

        pageLocators.clickDragDrop();

        // Drag and Drop to visible position
        dragAndDrop((AndroidDriver) driver, pageLocators.dragPosition, pageLocators.dropPosition);

        System.out.println(pageLocators.getDragResult());
        Assert.assertTrue(pageLocators.getDragResult().contains("Dropped!"));

        // Drag and Drop to Hidden Position
        Drag((AndroidDriver) driver, pageLocators.dragPosition);
        Drop((AndroidDriver) driver, pageLocators.dropHiddenPosition);

        System.out.println(pageLocators.getDragResult());
        Assert.assertTrue(pageLocators.getDragResult().contains("Dropped!"));

        tearDown();
    }
}

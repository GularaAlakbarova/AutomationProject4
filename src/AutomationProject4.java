import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AutomationProject4 {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gular\\OneDrive\\Документы\\Eduction\\I Programmer\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //1. Navigate to carmax.com website

        driver.get("https://www.carmax.com/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        //2. On the bottom of the page in the appraisal form, choose VIN and fill out the form with
        //the below info and click get started:
        //VIN: 4T1BE46K67U162207
        //Zipcode:22182

        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1750)");
        driver.findElement(By.id("button-VIN")).click();

        driver.findElement(By.id("ico-form-vin")).sendKeys("4T1BE46K67U162207");
        driver.findElement(By.id("ico-form-zipcode")).sendKeys("22182");
        driver.findElement(By.xpath("//*[@id=\"online-offer\"]/div/div[1]/div[2]/div/form/button")).click();

        //3. On the next page select LE 4D Sedan 2.4L
        // Enter: 4WD/AWD

        Thread.sleep(5000);


        WebElement radioButton = driver.findElement(By.xpath("//label[.='LE 4D Sedan 2.4L'] "));
        radioButton.click();

        Thread.sleep(1000);

        Select transmission = new Select(driver.findElement(By.name("transmission")));
        transmission.selectByValue("Automatic");

        Select carDrive = new Select(driver.findElement(By.name("drive")));
        carDrive.selectByValue("4WD/AWD");

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

        Thread.sleep(2000);

        //4. For Features, select all options.

        driver.findElement(By.id("checkbox-ico-cb-feature-9550")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("checkbox-ico-cb-feature-1610")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("checkbox-ico-cb-feature-6010")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("checkbox-ico-cb-feature-6310")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("checkbox-ico-cb-feature-6160")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("checkbox-ico-cb-feature-9008")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("checkbox-ico-cb-feature-3030")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("checkbox-ico-cb-feature-3101")).click();
        Thread.sleep(1000);

//        driver.findElement(By.id("checkbox-ico-cb-feature-3040")).click();
//        Thread.sleep(1000);

        driver.findElement(By.id("checkbox-ico-cb-feature-9137")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("checkbox-ico-cb-feature-1031")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("checkbox-ico-cb-feature-6270")).click();
        Thread.sleep(1000);

        //5. Enter mileage (60,000) and chose the options.

        driver.findElement(By.id("ico-step-Mileage_and_Condition-btn")).click();

        Thread.sleep(2000);

        driver.findElement(By.name("currentMileage")).sendKeys("60,000");

       driver.findElement(By.id("radio-ico-r-100-1")).click();

       driver.findElement(By.id("radio-ico-r-910-1")).click();

       driver.findElement(By.id("radio-ico-r-920-1")).click();

       driver.findElement(By.id("radio-ico-r-200-1")).click();


        Actions at = new Actions(driver);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(2000);

       driver.findElement(By.id("radio-ico-r-1000-1")).click();

       driver.findElement(By.id("radio-ico-r-300-1")).click();

       driver.findElement(By.id("checkbox-ico-yn-310-1")).click();

       driver.findElement(By.id("radio-ico-r-410-1")).click();

        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(2000);

       driver.findElement(By.id("radio-ico-r-420-1")).click();

       driver.findElement(By.id("radio-ico-r-500-1")).click();

       driver.findElement(By.id("radio-ico-r-600-1")).click();

       driver.findElement(By.id("radio-ico-r-700-1")).click();

       driver.findElement(By.id("radio-ico-r-800-1")).click();

       Thread.sleep(1000);

//        String actualYearMakeModel = driver.findElement(By.xpath("//*[@id=\"icoVehicleBody\"]/div/div[2]/table/tbody/tr[1]/td[1]/p")).getText();
//        String actualDrive = driver.findElement(By.xpath("//*[@id=\"icoVehicleBody\"]/div/div[2]/table/tbody/tr[2]/td[1]/p")).getText();
//        String actualTransmission = driver.findElement(By.xpath("//*[@id=\"icoVehicleBody\"]/div/div[2]/table/tbody/tr[3]/td[1]/p")).getText();
//        String actualVin = driver.findElement(By.xpath("//*[@id=\"icoVehicleBody\"]/div/div[2]/table/tbody/tr[4]/td[1]/p")).getText();
//        String actualMileage = driver.findElement(By.xpath("//*[@id=\"icoVehicleBody\"]/div/div[2]/table/tbody/tr[5]/td[1]/p")).getText();
//
//        String expectedYearMakeModel = "Year, Make, and Model";
//        String expectedDrive = "Drive";
//        String expectedTransmission = "Transmission";
//        String expectedVin = "VIN";
//        String expectedMileage = "Mileage";

        List<String> expectedResult = Arrays.asList("Year, Make, and Model", "2007 Toyota Camry", "Drive", "4WD/AWD", "Transmission", "Automatic", "VIN",
                "4T1BE46K67U162207", "Mileage", "60,000");


       List<String> actualResult = new ArrayList<String>();

        List<WebElement> allElementsOfTable = driver.findElements(By.xpath("//*[@id=\"icoVehicleBody\"]/div/div[2]/table/tbody//p"));
        for(int i = 0; i < allElementsOfTable.size(); i++){
            actualResult.add(allElementsOfTable.get(i).getText());
        }

        Assert.assertEquals(actualResult, expectedResult);


        //7. Click continue
        js.executeScript("arguments[0].click();", driver.findElement(By.id("ico-continue-button")));

       //8. On the next page, verify that the appraisal amount is 6600 - This was not available, because they cannot provide the estimate, and rather sending
        //request to schedule an appoinment
        //Clicl "Schedule My Offer

        String parentWindow = driver.getWindowHandle(); //store parent window handle

        WebElement scheduleButton =  driver.findElement(By.xpath("//*[@id=\"icoIneligible\"]/div[2]/button"));

        Actions action = new Actions(driver);
        action.moveToElement(scheduleButton).perform();
        action.click().build().perform();

        //9. On the next page that will be opened schedule an in-person offer

        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {

            if(!windowHandle.equals(parentWindow)){
                driver.switchTo().window(windowHandle);
            }
        }

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("appt-fname")));
        driver.findElement(By.id("appt-fname")).sendKeys("Adam");
        driver.findElement(By.id("appt-lname")).sendKeys("Young");
        driver.findElement(By.id("appt-phone")).sendKeys("8325456454");
        driver.findElement(By.id("appt-email")).sendKeys("adam.young78458@gmail.com");
        driver.findElement(By.id("appt-personal__next")).click();

        //10. What else would you like to do during your visit? Mark all checkmarks and click next

        driver.findElement(By.xpath("//*[@id='browselot-check']")).click();
        driver.findElement(By.id("testdrive-check")).click();
        driver.findElement(By.id("financing-check")).click();

        driver.findElement(By.id("appt-location__next")).click();


























    }
}

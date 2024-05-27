import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class Activity10 {

    public static List<List<Object>> readExcel(String filepath) throws IOException {
        List<List<Object>> data = new ArrayList<>();
        FileInputStream file = new FileInputStream(filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        for(Row cells: sheet){
            List<Object> rowData = new ArrayList<>();
            for(Cell cell: cells){
                if(cell!=null){
                    switch (cell.getCellType()){
                        case STRING -> rowData.add(cell.getStringCellValue());
                        case NUMERIC -> rowData.add(cell.getNumericCellValue());
                        case BOOLEAN -> rowData.add(cell.getBooleanCellValue());
                    }
                }
            }
            data.add(rowData);
        }
        file.close();
        workbook.close();
        return data;
    }

    @DataProvider(name ="testData")
    public static Object[][] userInfo() throws IOException {
        String filepath = "C:/Users/Srilu/myLearnings/Java/M1-TestNG/src/data/testdata.xlsx";
        List<List<Object>> data = readExcel(filepath);
        return new Object[][]{
                {data.get(1)}, {data.get(2)}, {data.get(3)},
        };
    }

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://v1.training-support.net/selenium/simple-form");
        Reporter.log("Starting Test |");
        Reporter.log("Page Title :" + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Simple Form");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        Reporter.log("Ending Test |");
        driver.quit();
    }

    @Test(dataProvider = "testData")
    public void registrationTest(List<Object> rows) {
        System.out.println("Test data from excel : "+rows.get(0).toString());
        System.out.println("Test data from excel : "+rows.get(1).toString());
        System.out.println("Test data from excel : "+rows.get(2).toString());
        System.out.println("Test data from excel : "+rows.get(3).toString());
        System.out.println("Test data from excel : "+rows.get(4).toString());
        driver.findElement(By.id("firstName")).sendKeys(rows.get(1).toString());
        driver.findElement(By.id("lastName")).sendKeys(rows.get(2).toString());
        driver.findElement(By.id("email")).sendKeys(rows.get(3).toString());
        driver.findElement(By.id("number")).sendKeys(rows.get(4).toString());
        driver.findElement(By.tagName("textarea")).sendKeys("Test Automation");
        //Click on Submit
        driver.findElement(By.xpath("//input[contains(@class,'green')]")).click();
        //wait.until(ExpectedConditions.alertIsPresent());
        //Switch to Alert
        Alert alertMeg = driver.switchTo().alert();
        Reporter.log("Alter Text message : "+alertMeg.getText());
        System.out.println("Alter Text message : "+alertMeg.getText());
        alertMeg.accept();
        driver.navigate().refresh();
    }
}
package test2;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;



public class TestBaidu {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  String driverPath ="C:\\Users\\11026\\Desktop\\dad\\软件测试\\test2\\geckodriver.exe";
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  driver = new FirefoxDriver();
	  baseUrl = "http://121.193.130.195:8800";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void Test2() throws Exception {
	  String id= new String();
	  String password= new String();
	  String name=new String();
	  String git=new String();
	  
//	  //用流的方式先读取到你想要的excel的文件
//      FileInputStream fis=new FileInputStream(new File("C:\\Users\\11026\\Desktop\\dad\\软件测试\\test2\\NameList.xlsx"));
//      //解析excel
//      POIFSFileSystem pSystem=new POIFSFileSystem(fis);
//      //获取整个excel
//      HSSFWorkbook hb=new HSSFWorkbook(pSystem);
//      System.out.println(hb.getNumCellStyles());
//      //获取第一个表单sheet
//      HSSFSheet sheet=hb.getSheetAt(0);
//      //获取第一行
//  int firstrow=    sheet.getFirstRowNum();
//  //获取最后一行
//  int lastrow=    sheet.getLastRowNum();
	  Workbook book=Workbook.getWorkbook(new File("C:\\Users\\11026\\Desktop\\dad\\软件测试\\test2\\NameList.xls"));
	  Sheet sheet = book.getSheet(0);
	  int rownumber= sheet.getRows();
	  driver.get(baseUrl + "/");
      WebElement we = driver.findElement(By.name("id"));
      we.click();
	  for(int i=2;i<rownumber;i++) 
	  {
		   id= sheet.getCell(1,i).getContents();
      name= sheet.getCell(2,i).getContents();
      git= sheet.getCell(3,i).getContents();
      //System.out.println(id);
     
        //    driver.findElement(By.id("kw")).click();
      driver.findElement(By.name("id")).clear();
      driver.findElement(By.name("id")).sendKeys(id);
      driver.findElement(By.name("password")).clear();
      driver.findElement(By.name("password")).sendKeys(id.substring(4,10));
      driver.findElement(By.id("btn_login")).click();
      //System.out.println(driver.findElement(By.name("student-id")).getText());
      assertEquals(id, driver.findElement(By.id("student-id")).getText());
      assertEquals(name, driver.findElement(By.id("student-name")).getText());
      assertEquals(git, driver.findElement(By.id("student-git")).getText());
      driver.findElement(By.id("btn_logout")).click();
      driver.findElement(By.id("btn_return")).click();
      
	  }
      //Cell cell=null;
     
      
    
	  }
//	  jxl.Workbook readwb = null;
//	  InputStream instream = new FileInputStream("C:\\Users\\11026\\Desktop\\dad\\软件测试\\test2\\NameList.xls");
//	  readwb = Workbook.getWorkbook(instream);
//	  Sheet readsheet = (Sheet) readwb.getSheet(1);
//	  int rsColumns = ((jxl.Sheet) readsheet).getColumns();
//	  int rsRows = ((jxl.Sheet) readsheet).getRows();
//	  for(int i=0;i<rsRows;i++)
//	  {
//		  driver.get(baseUrl);
//		  Cell cell=((jxl.Sheet) readsheet).getCell(0,i);
//		  String username = cell.getContents();
//		  String password = username.substring(4,10);
//		  WebElement element = driver.findElement(By.id("name"));
//		  WebElement element1 = driver.findElement(By.id("pwd"));
//		  element.sendKeys(username);
//		  element1.sendKeys(password);
//		  element.submit();
//		  WebElement element2 = driver.findElement(By.xpath("//td[2]"));
//		  String mailByWeb = element2.getText();
//		  String mailByInfo = ((jxl.Sheet) readsheet).getCell(1,i).getContents();
//		  assertEquals(mailByInfo,mailByWeb);
//		  
//	  }
//	  readwb.close();
	  
  

  @After
  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}


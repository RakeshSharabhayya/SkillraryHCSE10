package genaricLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import POMclass.ContactUs;
import POMclass.SeleniumTrainingPage;
import POMclass.SkillraryDemoAppPage;
import POMclass.SkillraryHomepage;
import POMclass.TestingPage;

public class BaseClass {
	
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected WebDriver driver;
	
	protected SkillraryHomepage home;
	protected SkillraryDemoAppPage demoApp;
	protected SeleniumTrainingPage selenium;
	protected TestingPage Testing;
	protected ContactUs contact;
	
//@BeforeSuit
	//@BeforeTest
	
	@BeforeClass
	
	public void classConfig() {
		property=new PropertiesUtility();
		excel=new ExcelUtility();
		jutil=new JavaUtility();
		web=new WebDriverUtility ();
		
		property.propertiesInit(IConstantPath.PROPERTIES_PATH);
		excel.excelInit(IConstantPath.EXCEL_PATH);
		
		
	}
	
	@BeforeMethod
	
	public void methodConfig() {
		driver=web.launchBrowser(property.readDataFromProperties("browser"));
		web.maximizeBrowser();
		web.navigateToApp(property.readDataFromProperties("url"));
		web.waitUntilElementFound(Long.parseLong(property.readDataFromProperties("time")));
		
		home=new SkillraryHomepage(driver);
		demoApp=new SkillraryDemoAppPage(driver);
		selenium=new SeleniumTrainingPage(driver);
		Testing=new TestingPage(driver);
		contact=new ContactUs(driver);
				
	}
	@AfterMethod
	public void methodTearDown() {
		web.quitAllWindows();
		
	}
	
	@AfterClass
	public void classTearDown() {
		excel.Closeexcel();
		
	}
	
	//AfterTest
	//AfterSuite
}

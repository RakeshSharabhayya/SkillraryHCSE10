package POMclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genaricLibraries.WebDriverUtility;

public class SkillraryDemoAppPage {
	

		//Declaration
		@FindBy(xpath="//a[@class='navbar-brand']")
		private WebElement pageHeader;
		
		@FindBy(xpath="//a[@id='course']")
		private WebElement courseTab;
		@FindBy(xpath=" //span/a[text()='Selenium Training'] ")
		private WebElement seleniumTrainingLink;
		
		@FindBy(xpath="//select[@name='addresstype'] ")
		private WebElement  categoryDD;
		
		@FindBy(xpath="//a[text()='Contact Us']")
		private WebElement contactUsLink;
		
		//Initialization
		public SkillraryDemoAppPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//utilization
		/**
		 * This method returns page header text
		 * @return
		 */
		public String getPageHeader()
		{
			return pageHeader.getText();
		}
		/**
		 * This method is used to mouseHover to course tab
		 * @param web
		 */
		public void mouseHoverToCourse(WebDriverUtility web)
		{
			web.mouseHover(courseTab);
		}
		/**
		 * This method is used to click on selenium training
		 */
		
		public void clickSeleniumTraining()
		{
			
		seleniumTrainingLink.click();
		}
		/**
		 * This method is used to select category
		 * @param web
		 * @param index
		 */
		
		public void selectCategory(WebDriverUtility web, int index)
		{
			web.dropdown(categoryDD,index);
			
		}
		/**
		 * This method is returns contact us link
		 * @return
		 */
		
		public WebElement getContactUsLink()
		{
			return contactUsLink;
		}
		/**
		 * This method is used to click on contact us link
		 */
		public void clickContactUs() {
			contactUsLink.click();
		}
		
		
	}


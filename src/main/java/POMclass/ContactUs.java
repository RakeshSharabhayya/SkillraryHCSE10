package POMclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs {
	
		/**
		 * this class contains elements locators and respective buisness libraries of testing page
		 * @author admin
		 */

		//Declaration
		@FindBy(xpath="//img[contains(@src,'contactus')]")
		private WebElement logo;
		
		@FindBy(name="name")
		private WebElement fullNameTF;
		
		@FindBy(name="sender")
		private WebElement emailTF;
		
		@FindBy(name="subject")
		private WebElement subjectTF;
		
		@FindBy(name="message")
		private WebElement messageBox;
		
		@FindBy(xpath="//button[text()=\'Send us mail\']")
		private WebElement sendUsMailButton;
		
		//Initialization
		public ContactUs(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		//Utilization
		/**
		 * this method returns logo
		 * @return
		 */
		public WebElement getlogo() {
			return logo;
			
		}
		/**
		 * this method is used to send the contact details
		 * @param name
		 * @param email
		 * @param subject
		 * @param message
		 */
		
		public void sendDetails(String name, String email, String subject, String message) {
			fullNameTF.sendKeys(name);
			emailTF.sendKeys(email);
			subjectTF.sendKeys(subject);
			messageBox.sendKeys(message);
			sendUsMailButton.click();
		}
		
	}


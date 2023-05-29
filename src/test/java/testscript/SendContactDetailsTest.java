package testscript;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genaricLibraries.BaseClass;

public class SendContactDetailsTest extends BaseClass {
	
	
		
		@Test
		public void sendContactDetailsTest() {
			SoftAssert soft=new SoftAssert();
			
			home.clickGearsTab();
			home.clickSkillraryDemoAppLink();
			web.switchToChildBrowser();
			
			soft.assertTrue(demoApp.getPageHeader().contains("ECommerce"));
			
			web.scrollTillElement(demoApp.getContactUsLink());
			demoApp.clickContactUs();
			
			soft.assertTrue(contact.getlogo().isDisplayed());
			
			Map<String, String>map=excel.getDataFromExcel("Sheet1");
			contact.sendDetails(map.get("FullName"),map.get("Email"),map.get("Subject"),
			map.get("Message"));
			
			soft.assertAll();
		}
	}



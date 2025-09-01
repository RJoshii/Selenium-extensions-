package com.orangehrm.test;
 
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.orangehrm.base.Base;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.ExcelUtilities;
import com.orangehrm.utilities.ScreenShotUtilities;
 
public class Login_OrangeHrm extends Base{
	
	 static String projectpath=System.getProperty("user.dir")  ;
	@Test(dataProvider="logindata")
	public void verifylogin(String username, String password) throws IOException, ParserConfigurationException, SAXException
	
	{    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		test=extent.createTest("login with the user:"+username);
		LoginPage obj=new LoginPage(driver);
		obj.enterusername(username);
		obj.enterpassword(password);
		obj.clickonbutton();
		
		if(obj.dashisdisplayed())
		
		{
			test.pass("Login is sucess for user:"+username);
			
		}
		else
			test.fail(" login unsuccess for the user:"+username).addScreenCaptureFromPath(ScreenShotUtilities.capturescreen(driver, "Verify login"));
	
	
	if((driver.getTitle()).equals("orange"))
	{
		test.pass("title is matched");
	}
	else
		test.fail("title is not matched").addScreenCaptureFromPath(ScreenShotUtilities.capturescreen(driver, "Verify login"));
 
	}
	@DataProvider
	public Object[][] logindata() throws IOException
	{
		return ExcelUtilities.getdata(projectpath+"/src/main/resources/Orangehrm_Testdata/data.xlsx", "Sheet1");
	}
 
}
package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import page.RegisterPage;
import utils.ExcelUtils;

@Listeners(test.ListenerTest.class)

public class RegisterPageTest extends AbstractClass {
	boolean checkTestCase;
	private WebDriver driver;
	public RegisterPage registerPage;
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
		new ExcelUtils();
	}
	
	@Test(priority = 1)
	public void checkEmptyRegister() throws Exception {
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Register.xlsx", "InputData");
		registerPage = new RegisterPage(driver);
		registerPage.Register(ExcelUtils.getCellData(1,2), ExcelUtils.getCellData(1,3),  ExcelUtils.getCellData(1,4));
		String text = registerPage.getErrorFullname();
		String text1 = registerPage.getErrorEmail();
		String text2 = registerPage.getErrorPassword();
		String altertext = "Vui lòng cho biết họ tên.";
		String altertext1 = "Địa chỉ mail hoặc định dạng không đúng.";
		String altertext2 = "Mật khẩu không được để trống.";
//		if (altertext.equals(text) == true && altertext1.equals(text1) == true && altertext2.equals(text2) == true) {
//			this.checkTestCase = true;
//			if (checkTestCase) {
//				Assert.assertTrue(true);
//				System.out.print("Test case is passed! \r" );
//			}
//			else {
//				Assert.assertTrue(false);
//				System.out.print("Test case is failed! \r" );
//			}
//		}
		if(altertext.equals(text) == true && altertext1.equals(text1) && altertext2.equals(text2)) {
			System.out.println("passed! \r");
			ExcelUtils.setCellData(1, 6, "Passed");
		}
		else {
			System.out.print("failed! \r" );
			ExcelUtils.setCellData(1, 6, "Failed");
		}
		ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Register.xlsx");
		
	}
	@Test(priority = 2)
	public void checkEmptyEmailRegister() throws Exception {
//		beforeTest();
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Register.xlsx", "InputData");
		registerPage = new RegisterPage(driver);
		registerPage.Register(ExcelUtils.getCellData(2,2), ExcelUtils.getCellData(2,3),  ExcelUtils.getCellData(2,4));
		String text = registerPage.getErrorEmail();
		String text1 = registerPage.getErrorPassword();
		String altertext = "Địa chỉ mail hoặc định dạng không đúng.";
		String altertext1 = "Mật khẩu không được để trống.";
//		if (altertext.equals(text) == true && altertext1.equals(text1) == true) {
//			this.checkTestCase = true;
//			if (checkTestCase) {
//				Assert.assertTrue(true);
//				System.out.print("Test case is passed! \r" );
//			}
//			else {
//				Assert.assertTrue(false);
//				System.out.print("Test case is failed! \r" );
//			}
//		}
		if(altertext.equals(text) == true && altertext1.equals(text1)) {
			System.out.println("passed! \r");
			ExcelUtils.setCellData(2, 6, "Passed");
		}
		else {
			System.out.print("failed! \r" );
			ExcelUtils.setCellData(2, 6, "Failed");
		}
		ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Register.xlsx");	
	}
	
	@Test(priority = 3)
	public void checkEmptyPassRegister() throws Exception {
//		beforeTest();
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Register.xlsx", "InputData");
		registerPage = new RegisterPage(driver);
		registerPage.Register(ExcelUtils.getCellData(3,2), ExcelUtils.getCellData(3,3),  ExcelUtils.getCellData(3,4));
		String text = registerPage.getErrorPassword();
		String altertext = "Mật khẩu không được để trống.";
//		if ( altertext.equals(text) == true) {
//			this.checkTestCase = true;
//			if (checkTestCase) {
//				Assert.assertTrue(true);
//				System.out.print("Test case is passed! \r" );
//			}
//			else {
//				Assert.assertTrue(false);
//				System.out.print("Test case is failed! \r" );
//			}
//		}
		if(altertext.equals(text) == true) {
			System.out.println("passed! \r");
			ExcelUtils.setCellData(3, 6, "Passed");
		}
		else {
			System.out.print("failed! \r" );
			ExcelUtils.setCellData(3, 6, "Failed");
		}
		ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Register.xlsx");	
	}
	
	@Test(priority = 4)
	public void checkWrongFormatEmailRegister() throws Exception {
//		beforeTest();
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Register.xlsx", "InputData");
		registerPage = new RegisterPage(driver);
		registerPage.Register(ExcelUtils.getCellData(4,2), ExcelUtils.getCellData(4,3),  ExcelUtils.getCellData(4,4));
		Thread.sleep(2000);
		String text = registerPage.getSuccessMessage();
		
		String altertext = "Địa chỉ mail hoặc định dạng không đúng.";
//		if (altertext.equals(text) == true) {
//			this.checkTestCase = true;
//			if (checkTestCase) {
//				Assert.assertTrue(true);
//				System.out.print("Test case is passed! \r" );
//			}
//			else {
//				Assert.assertTrue(false);
//				System.out.print("Test case is failed! \r" );
//			}
//		}
		if(altertext.equals(text) == true) {
			System.out.println("passed! \r");
			ExcelUtils.setCellData(4, 6, "Passed");
		}
		else {
			System.out.print("failed! \r" );
			ExcelUtils.setCellData(4, 6, "Failed");
		}
		ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Register.xlsx");	
	}
	
	@Test(priority = 5)
	public void checkExsitEmailRegister() throws Exception {
//		beforeTest();
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Register.xlsx", "InputData");
		registerPage = new RegisterPage(driver);
		registerPage.Register(ExcelUtils.getCellData(5,2), ExcelUtils.getCellData(5,3),  ExcelUtils.getCellData(5,4));
		Thread.sleep(2000);
		String text = registerPage.getErrorMessage();
		String altertext = "Địa chỉ mail này đã được sử dụng, xin vui lòng đăng ký địa chỉ mail khác !";
//		if (altertext.equals(text) == true) {
//			this.checkTestCase = true;
//			if (checkTestCase) {
//				Assert.assertTrue(true);
//				System.out.print("Test case is passed! \r" );
//			}
//			else {
//				Assert.assertTrue(false);
//				System.out.print("Test case is failed! \r" );
//			}
//		}
		if(altertext.equals(text) == true) {
			System.out.println("passed! \r");
			ExcelUtils.setCellData(5, 6, "Passed");
		}
		else {
			System.out.print("failed! \r" );
			ExcelUtils.setCellData(5, 6, "Failed");
		}
		ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Register.xlsx");	
	}
	
	@Test(priority = 6)
	public void checkSuccessLogin() throws Exception {
//		beforeTest();
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Register.xlsx", "InputData");
		registerPage = new RegisterPage(driver);
		registerPage.Register(ExcelUtils.getCellData(6,2), ExcelUtils.getCellData(6,3),  ExcelUtils.getCellData(6,4));
		Thread.sleep(2000);
		String text = registerPage.getSuccessMessage();
		String altertext = "Đăng ký thành công, chào mừng bạn đến với hệ thống Bobapop.";
//		if (altertext.equals(text) == true) {
//			this.checkTestCase = true;
//			if (checkTestCase) {
//				Assert.assertTrue(true);
//				System.out.print("Test case is passed! \r" );
//			}
//			else {
//				Assert.assertTrue(false);
//				System.out.print("Test case is failed! \r" );
//			}
//		}
		if(altertext.equals(text) == true) {
			System.out.println("passed! \r");
			ExcelUtils.setCellData(6, 6, "Passed");
		}
		else {
			System.out.print("failed! \r" );
			ExcelUtils.setCellData(6, 6, "Failed");
		}
		ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Register.xlsx");

	}
}

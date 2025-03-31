package TestScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.QuestionPage;

public class CreateGameTestCases extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private QuestionPage questionPage;

    @BeforeMethod
    public void setUpTest() {
    	setUp();
    	 loginPage = new LoginPage(page);
    	 loginPage.navigateToLoginPage();
         loginPage.login("manish.deligence@gmail.com", "manish100");
    	
       
        dashboardPage = new DashboardPage(page);
        questionPage = new QuestionPage(page);
        
    }

    @Test
    public void VerifyUpload_Ques_By_CsvFile() throws InterruptedException {
       
        
        dashboardPage.clickEditButton();
        dashboardPage.uploadCSVFile();
     
    }
    
    
    @Test
    public void Verify_Upload_Image_For_A_Question() throws InterruptedException {
    	questionPage.navigateToEditQuestion();
    	questionPage.uploadQuestionImage();
    
    	
    }
    
    

	/*
	 * @AfterClass public void tearDownTest() { close(); }
	 */
}


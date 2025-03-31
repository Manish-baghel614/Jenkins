package Pages;

import java.nio.file.Paths;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import Base.BaseTest;

public class DashboardPage extends BaseTest {
	
	 private Page page;

	    public DashboardPage(Page page) {
	        this.page = page;
	    }
	    
    public void clickEditButton() {
        page.locator("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/div/a[2]").click();
    }
    
    public void uploadCSVFile() {
      page.locator("//*[@id=\"gameEditPage\"]/div/div[1]/span[2]/span/span[2]/span[1]/span").click();
      page.locator("//*[@id=\"uploadCsv\"]").setInputFiles(Paths.get(".\\src\\test\\resources\\File\\example (2).csv"));
      page.locator("//*[@id=\"questionsUploader\"]/div/div[3]/button[2]").click();
      page.locator("//*[@id=\"categoryWrapper-list\"]/div[2]/div/label").click();
      page.locator("//*[@id=\"editSave\"]").click();
      page.locator("/html/body/div[6]/div/div[3]/button[3]").click();
      
    }
}


package Pages;

import java.nio.file.Paths;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import Base.BaseTest;

public class QuestionPage extends BaseTest {
	Page page;
    public QuestionPage(Page page) {
        this.page = page;
    }

    public void navigateToEditQuestion() {
        page.getByRole(com.microsoft.playwright.options.AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit")).nth(2).click();
    }

    public void uploadQuestionImage() throws InterruptedException {
        page.locator(".gameQuestionBlock").first().click();
        page.locator("//*[@id=\"question\"]/div[2]/div[2]/div[1]/div").click();
        page.locator("//*[@id=\"question1\"]/div[2]/div[1]/div/div/p/strong[1]").click();
        
        Thread.sleep(30000);
    
        
        
        
        
        
    }
}


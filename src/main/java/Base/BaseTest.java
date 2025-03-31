package Base;

// BasePage for common setup

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest{
	
	
    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    protected static Page page;

    public static void  setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1200, 700));
        page = context.newPage();
    }

    public static  void navigateTo(String url) {
        page.navigate(url);
    }

    public static void close() {
        browser.close();
        playwright.close();
    }
    
    
    
    
    
    
    
    
    
    
}


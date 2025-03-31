package TestScripts;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class SoundUpload {

	@Test(priority = 1)
	public void test__Upload_Image_In_QA() throws IOException, InterruptedException {
		
		
		 try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
		      page.navigate("https://awspf.com/signin");
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Id or Username")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Id or Username")).fill("manish.deligence@gmail.com");
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("manish100");
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Game")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter a descriptive title for")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter a descriptive title for")).fill("sound Upload");
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create")).click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Create Manually Add you own")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Category-1 Title")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Category-1 Title")).fill("Tricky q");
		      page.locator(".gamePointsBlock").first().click();
		      page.locator("#question").getByRole(AriaRole.PARAGRAPH).click();
		      page.locator("#question div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Type Something\\.\\.\\.$"))).locator("div").fill("What is your Name?");
		      page.locator("#question").getByRole(AriaRole.IMG, new Locator.GetByRoleOptions().setName("Upload Sound")).click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Drag & Drop your files here,")).click();
		      
		       try {
		            // File path to upload
		            String filePath = "C:\\Users\\hp\\Downloads\\sound-design-elements-sfx-ps-022-302865.mp3";

		            // Copy file path to clipboard
		            StringSelection selection = new StringSelection(filePath);
		            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		            // Create Robot instance
		            Robot robot = new Robot();

		            // Small delay to ensure the file dialog is open
		            Thread.sleep(2000);

		            // Press Ctrl+V to paste the file path
		            robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);

		            // Press Enter to confirm
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
		            
		            Thread.sleep(10000);

		            System.out.println("File uploaded successfully!");

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		      
		      
		    }
		/*
		 * Thread.sleep(4000);
		 * 
		 * page.navigate(properties.getProperty("rootUrl"));
		 * page.getByRole(AriaRole.MAIN).getByRole(AriaRole.LINK, new
		 * Locator.GetByRoleOptions().setName("Log In")) .click(); Thread.sleep(4000);
		 * page.getByPlaceholder("Email Id or username").fill(
		 * "sunita1.deligence@gmail.com"); page.getByPlaceholder("Password").click();
		 * page.getByPlaceholder("Password").fill("123456");
		 * page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName("Log In")).click();
		 * page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName("Create Game")).click();
		 * page.getByPlaceholder("Enter a descriptive title for").fill("SoundUpload");
		 * page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName("Create")).click();
		 * page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName(" Create Manually Add you own")).click();
		 * page.getByPlaceholder("Category-1 Title").click();
		 * 
		 * page.getByPlaceholder("Category-1 Title").fill("trick question");
		 * 
		 * page.locator(".gamePointsBlock").first().click();
		 * page.locator("#question").getByRole(AriaRole.PARAGRAPH).click();
		 * page.locator("#question div") .filter(new
		 * Locator.FilterOptions().setHasText(Pattern.
		 * compile("^Type Something\\.\\.\\.$")))
		 * .locator("div").fill("What is your name?"); Thread.sleep(2000);
		 * 
		 * //page.locator("#question").getByText("Upload ImageUpload VideoEnter").click(
		 * ); Thread.sleep(2000); page.locator("#question").getByRole(AriaRole.IMG, new
		 * Locator.GetByRoleOptions().setName("Upload Sound")).click();
		 * Thread.sleep(4000); // Upload image using file input in question
		 * page.setInputFiles("input[type='file']",
		 * Paths.get("./src/main/java/Resource/akubahagia.mp3")); Thread.sleep(3000);
		 * System.out.println("sound is getting uploaded in question");
		 * page.locator("#question div").filter(new
		 * Locator.FilterOptions().setHasText(Pattern.compile("^Upload Sound$"))).
		 * locator("div").click();
		 * page.locator("#answer").getByRole(AriaRole.PARAGRAPH).click();
		 * page.locator("#answer div").filter(new
		 * Locator.FilterOptions().setHasText(Pattern.
		 * compile("^Type Something\\.\\.\\.$"))).locator("div").fill("sandy");
		 * Thread.sleep(2000);
		 * page.locator("//*[@id=\"answer\"]/div[2]/div[2]/div[4]").click();
		 * Thread.sleep(5000);
		 * 
		 * page.setInputFiles("input[type='file']",
		 * Paths.get("./src/main/java/Resource/gaddivichplaykare.mp3"));
		 * 
		 * Thread.sleep(4000);
		 * 
		 * System.out.println("sound uploaded successfully in the answer");
		 * page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName("SAVE")).click();
		 * System.out.println("Now the game getting saved"); //
		 * page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Factile //
		 * Logo My Games")).click(); page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName(" Preview")).click();
		 * 
		 * page.locator("span").filter(new
		 * Locator.FilterOptions().setHasText("$")).first().click();
		 * assertThat(page.getByRole(AriaRole.IMG, new
		 * Page.GetByRoleOptions().setName("67909f5b5922f0e4bae4943d/img-")))
		 * .isVisible(); assertThat(page.locator("#responsive-question")).
		 * containsText("What is your name?"); page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName("See Answer")).click();
		 * assertThat(page.getByRole(AriaRole.IMG, new
		 * Page.GetByRoleOptions().setName("67909f5b5922f0e4bae4943d/img-")))
		 * .isVisible(); assertThat(page.getByText("test")).isVisible();
		 * page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName("Close")).click();
		 * page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName("Exit")).click();
		 * page.getByRole(AriaRole.LINK, new
		 * Page.GetByRoleOptions().setName("Factile Logo My Games")).click();
		 * Thread.sleep(2000);
		 * 
		 * page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName("profile")).click(); Thread.sleep(2000);
		 * page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName("Logout")).click(); //
		 * page1.locator("//*[@id=\"navbar-list-2\"]/ul/li[6]/div/ul/li[2]/span").click(
		 * ); Thread.sleep(3000);
		 */
	}

}

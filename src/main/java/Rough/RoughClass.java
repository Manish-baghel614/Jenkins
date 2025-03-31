package Rough;




import java.io.IOException;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;


public class RoughClass {
	

	@Test
	public void test__Upload_Image_In_QA() throws IOException, InterruptedException {
		Thread.sleep(4000);
		
		 try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();

		      page.navigate("https://awspf.com/signin");
		
		Thread.sleep(4000);
		page.getByPlaceholder("Email Id or username").fill("sunita1.deligence@gmail.com");
		page.getByPlaceholder("Password").click();
		page.getByPlaceholder("Password").fill("123456");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Game")).click();
		page.getByPlaceholder("Enter a descriptive title for").fill("ImageUpload");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create")).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Create Manually Add you own")).click();
		page.getByPlaceholder("Category-1 Title").click();

		page.getByPlaceholder("Category-1 Title").fill("trick question");

		page.locator(".gamePointsBlock").first().click();
		page.locator("#question").getByRole(AriaRole.PARAGRAPH).click();
		page.locator("#question div")
				.filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Type Something\\.\\.\\.$")))
				.locator("div").fill("What is your name?");
		Thread.sleep(2000);
		page.locator("#question").getByText("Upload ImageUpload VideoEnter").click();
		Thread.sleep(2000);
		page.locator("#question").getByRole(AriaRole.IMG, new Locator.GetByRoleOptions().setName("Add_Image")).click();
		Thread.sleep(4000);
		// Upload image using file input in question
		page.setInputFiles("input[type='file']", Paths.get("./src/main/java/Resource/img.jpg"));
		Thread.sleep(3000);
		System.out.println("Image is getting uploaded in question");
		page.locator("#question div")
				.filter(new Locator.FilterOptions()
						.setHasText(Pattern.compile("^Upload ImageUpload VideoEnter EquationUpload Sound$")))
				.locator("i").click();

		page.locator("#answer").getByRole(AriaRole.PARAGRAPH).click();

		page.locator("#answer div")
				.filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Type Something\\.\\.\\.$")))
				.locator("div").fill("test");
		Thread.sleep(2000);
		page.locator("//*[@id=\"answer\"]/div[2]/div[2]/div[1]").click();
		Thread.sleep(5000);

		page.setInputFiles("input[type='file']", Paths.get("./src/main/resources/img.jpg"));

		Thread.sleep(4000);
		
		System.out.println("Image uploaded successfully in the answer");
		/*
		 * page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName("SAVE")).click();
		 * System.out.println("Now the game getting saved"); //
		 * page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Factile //
		 * Logo My Games")).click(); page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName(" Preview")).click();
		 * page.locator("span").filter(new
		 * Locator.FilterOptions().setHasText("$")).first().click(); boolean flag =
		 * page.getByRole(AriaRole.IMG, new
		 * Page.GetByRoleOptions().setName("67909f5b5922f0e4bae4943d/img-"))
		 * .isVisible(); //assertThat(flag,true);
		 * 
		 * //assertThat(page.locator("#responsive-question")).
		 * containsText("What is your name?"); page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName("See Answer")).click();
		 * //assertThat(page.getByRole(AriaRole.IMG, new
		 * Page.GetByRoleOptions().setName("67909f5b5922f0e4bae4943d/img-"))) //
		 * .isVisible(); //assertThat(page.getByText("test")).isVisible();
		 * page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName("Close")).click();
		 * page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName("Exit")).click();
		 * page.getByRole(AriaRole.LINK, new
		 * Page.GetByRoleOptions().setName("Factile Logo My Games")).click();
		 * Thread.sleep(2000); System.out.println("Image upload is working fine");
		 * page.getByPlaceholder("Search in All My Games").fill("ImageUpload");
		 * page.locator("form").getByRole(AriaRole.BUTTON).first().click();
		 * page.getByRole(AriaRole.LINK, new
		 * Page.GetByRoleOptions().setName("Edit")).first().click();
		 * page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName(" Delete")).click();
		 * page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName("Yes, Delete it!")).click();
		 * page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName("OK")).click();
		 * page.getByRole(AriaRole.BUTTON, new
		 * Page.GetByRoleOptions().setName("Clear")).click();
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

}

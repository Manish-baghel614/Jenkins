package HomePage_TestScripts;



import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class Home_TestCases {

	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	BrowserContext context = browser.newContext();
	Page page = context.newPage();
	
	
	@Test
	public void Verify_feature_Button1() throws InterruptedException {//pass

		Thread.sleep(4000);
		page.navigate("https://awspf.com/");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Features")).click();
	
		
		
	      assertThat(page.getByRole(AriaRole.MAIN)).containsText("Looking for Jeopardy games online that spark excitement and make learning stick? Look no further than Factile! Factile is the ultimate Jeopardy game maker for the classroom with features like an Advanced Editor, Question Bank and AutoGen for fast and easy game creation, fun customizations like Jeopardy board colors and your own Team Mascots, and endless options for playing such as Buzzer Mode, Daily Double, Final Factile and much more. Read on to learn how Factile is Easy, Fun and Engaging.");
	      assertThat(page.getByRole(AriaRole.MAIN)).containsText("Are you looking to make your Factile Jeopardy game even more engaging? Let students BUZZ IN via their laptops, phones or tablets! Remote or In-Classroom. Create the games how vibe and friendly competition as players race to hit the buzzer.");
	      assertThat(page.getByRole(AriaRole.MAIN)).containsText("Question Bank");
	      assertThat(page.getByRole(AriaRole.MAIN)).containsText("Create up to 10 customizable Question Banks with 30 categories and 10 questions each - that's 300 thought-provoking questions with which to challenge your students! Generate Jeopardy or Multiple Choice style games.");
	      assertThat(page.getByRole(AriaRole.MAIN)).containsText("AutoGen");
	      assertThat(page.getByRole(AriaRole.MAIN)).containsText("AutoGenAutoGen uses generative Artificial Intelligence (AI) to help quickly create engaging Jeopardy-style quiz games. You provide the topic and let AutoGen create Jeopardy or Multiple Choice questions and answers. AutoGenLearn More");
	 
		//boolean flag = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Factile Jeopardy Game"))
			//	.isVisible();
		//Assert.assertTrue(flag);
System.out.println("Feature page is visible >> Pass");
page.goBack();
	}

	@Test
	public void Verify_feature_Button() throws InterruptedException {//pass

		page.navigate("https://awspf.com/");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Features")).click();
		Thread.sleep(3000);
		boolean flag = page.locator("//h1[@class='hero__heading hero__heading--h1']").first().isVisible();
		Assert.assertTrue(flag);
		System.out.println("Feature page is visible >> Pass");
		

	}

	@Test
	public void Verify_Plans_Button() {//pass

		page.navigate("https://awspf.com/");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Plans")).click();
		assertThat(page.getByRole(AriaRole.MAIN)).containsText("Flexible and affordable Factile Jeopardy Game Maker plans ");
		System.out.println("Plans page is visible >> Pass");
		

	}

	@Test
	public void Verify_Blogs_Button() {//pass

		page.navigate("https://awspf.com/");
		page.locator("#navbar-list-2").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Blogs"))
				.click();
		assertThat(page.getByRole(AriaRole.MAIN)).containsText("Factile - Blogs, Tips, and Resources");
		System.out.println("Blogs page is visible >> Pass");

	}

	
	  @Test 
	  public void Verify_Support_Button() throws InterruptedException {//pass
	  
	  page.navigate("https://awspf.com/"); page.getByRole(AriaRole.LINK, new
	  Page.GetByRoleOptions().setName("Support")).click();
	  Thread.sleep(2000);
	  Assert.assertTrue(page.locator("//a[normalize-space()='Documentation']").isVisible());
	  System.out.println("Support page is visible >> Pass");
	  
	  }
	 

	@Test
	public void Verify_Join_Game_Button() throws InterruptedException {//pass

		page.navigate("https://awspf.com/");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Join Game")).click();
	    Thread.sleep(2000);
	    Assert.assertTrue(page.locator("//h2[normalize-space()='Welcome to Factile!']").isVisible());
	    System.out.println("Join Game page is visible >> Pass");
		/*
		 * assertThat(page.getByRole(AriaRole.MAIN)).containsText("Welcome to Factile!"
		 * ); System.out.println("Join Game page is visible >> Pass");
		 */
	
	}

	@Test
	public void Verify_Math_Game_Button() throws InterruptedException {//pass

		page.navigate("https://awspf.com/");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Math Games")).click();
		Thread.sleep(2000);
		Assert.assertTrue(page.locator("//h1[normalize-space()='Games matching \"math\"']").isVisible());
		System.out.println("Math Game page is visible >> Pass");
		
	}

	@Test
	public void Verify_Science_Game_Button() throws InterruptedException { //pass

		page.navigate("https://awspf.com/");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Science Games")).click();
		
		Thread.sleep(2000);
		Assert.assertTrue(page.locator("//h1[normalize-space()='Games matching \"science\"']").isVisible());
		System.out.println("Science game  page is visible >> Pass");
		

	}

	@Test
	public void Verify_History_Game_Button() throws InterruptedException {

		page.navigate("https://awspf.com/");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("History Games")).click();

		boolean flag = page
				.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Games matching \"history\""))
				.isVisible();
		Assert.assertTrue(flag);

	}

	@Test
	public void Verify_English_Game_Button() {
		page.navigate("https://awspf.com/");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("English Games")).click();
		boolean flag = page
				.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Games matching \"english\""))
				.isVisible();
		Assert.assertTrue(flag);
	}
	
	
	@Test 
	public void Verify_PlayDemoGame_button() throws InterruptedException {
		
		
			Thread.sleep(4000);
			// page.navigate(properties.getProperty("rootUrl"));
			page.navigate("https://www.playfactile.com/");
			
			Page page1 = page.waitForPopup(() -> {
		        page.locator("a").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Play Demo Game$"))).click();
		      });
		     
	Thread.sleep(6000);
	page1.reload();
	    // Get the current URL
	    String currentURL = page1.url();
	    
	   // Verify if the page is 404
	    if (page1.locator("//*[@id=\"not-found\"]/div[3]/p/span").isVisible()) {
	    	
	        System.out.println("Test Failed: Landing on 404 Page");
	       
	        throw new AssertionError("Test Failed: Navigated to a 404 Page ");
	     
	    
	    } else {
	        //System.out.println("Test Passed: Correct Game Page Loaded, Game name is WORLD GEOGRAPHY- " + currentURL);
	        assertThat(page1.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("WORLD GEOGRAPHY"))).isVisible();
	        assertThat(page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Factile Jeopardy-style    "))).isVisible();
	        assertThat(page1.getByTestId("wrapper")).containsText("FlashcardsSelf-Paced Review");
	        assertThat(page1.getByTestId("wrapper")).containsText("ChoiceJeopardy-style Multiple Choice");
	        assertThat(page1.getByTestId("wrapper")).containsText("Quiz BowlCollege Bowl-style with Bonus Questions");
	        System.out.println("Test Passed: Correct Game Page Loaded, Game name is WORLD GEOGRAPHY- " + currentURL);
	        
	    
	    }
		
		

	}
	
	@Test
	public void Verify_BuzzerMode_Button() {
		 page.navigate("https://awspf.com/");
	     page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Now with Buzzer Mode – for in")).getByRole(AriaRole.LINK).click();
	    boolean flag1 =  page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Introducing the all new PRO")).isVisible();
		boolean flag2 = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Buzz!")).isVisible();
		Assert.assertTrue(flag1);
		Assert.assertTrue(flag2);
		
	}
	
	@Test
	public void Verify_Get_Started_For_Free_Button() {
		page.navigate("https://awspf.com/");
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get started for free")).nth(1).click();
	    boolean flag =   page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Signup for Free to Make a")).isVisible();
	    boolean flag1 = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign Up")).isVisible();
	    Assert.assertTrue(flag);
	    Assert.assertTrue(flag1);
	    
		
		
		
	}
	
	@Test
	public void Verify_Make_a_Jeopardy_Game_Button() {
		page.navigate("https://awspf.com/");
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Make a Jeopardy Game Get")).click();
	     boolean flag =  page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Signup for Free to Make a")).isVisible();
	    boolean flag1 = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign Up")).isVisible();
		Assert.assertTrue(flag);
		Assert.assertTrue(flag1);
		
		
		
		
		
	}
	
	@Test
	public void Verify_BuzzerMode_learnMore_Button() {
		page.navigate("https://awspf.com/");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Buzzer Mode Learn More")).click();
	    boolean flag=  page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Introducing the all new PRO")).isVisible();
	    boolean flag1 =  page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("How it Works")).isVisible();
		Assert.assertTrue(flag);
		Assert.assertTrue(flag1);
		
		
		
		
		
	}
	
	
	@Test
	public void Verify_QuestionBank_learnMore_Button() {
		page.navigate("https://awspf.com/");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Question Bank Learn More")).click();
	    boolean flag =   page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Simplify multiple game")).isVisible();
	     boolean flag1 = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Go Pro Now")).isVisible();
		Assert.assertTrue(flag);
		Assert.assertTrue(flag1);
		
		
		
		
		
	}
	
	@Test
	public void Verify_AutoGen_LearnMore_button(){
		page.navigate("https://awspf.com/");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Question Bank Learn More")).click();
	   boolean flag =   page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Simplify multiple game")).isVisible();
	    boolean flag1 =  page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Go Pro Now")).isVisible();
	    Assert.assertTrue(flag);
		Assert.assertTrue(flag1);
		
		
		
		
		
		
	}
	
	@Test
	public void Verify_Multiple_choice_button(){
	page.navigate("https://awspf.com/");
    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Multiple Choice")).click();
    boolean flag = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Play Jeopardy games in")).isVisible();
    boolean flag1 = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Learn about Making and")).isVisible();	
    
	Assert.assertTrue(flag);
	Assert.assertTrue(flag1);
	
	}
	
	@Test
	public void Verify_Memory_Style_button(){
		page.navigate("https://awspf.com/");
	 page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Memory Style")).click();
    boolean flag =  page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Challenge students to match")).isVisible();
    boolean flag1 =  page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Go Pro Now")).isVisible();
     Assert.assertTrue(flag);
     Assert.assertTrue(flag1);
     
     
     
	}

	
	@Test
	public void Verify_BuzzerMode_Image_Visible() {
		page.navigate("https://awspf.com/");
		boolean flag = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("A Fox playing the jeopardy")).isVisible();
		Assert.assertTrue(flag);
		
		
		
		
		
		
		
	}
	
	@Test
	public void Verify_QuestionBank_Image_Visible() {
		page.navigate("https://awspf.com/");
	
	boolean flag = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("A screen displaying several")).isVisible();
	Assert.assertTrue(flag);
	
	

	
}	
	@Test
	public void Verify_AutoGen_Image_Visible() {
		page.navigate("https://awspf.com/");
		
	boolean flag =	page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Giraffe mascot using Factile'")).isVisible();
	Assert.assertTrue(flag); 
	}
	
	
	
	@Test
	public void Verify_IntractiveChoice_Image_Visible() {
		page.navigate("https://awspf.com/");
	
	boolean flag =page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Giraffe mascot using Factile'")).isVisible();
	Assert.assertTrue(flag);
	
	}
	

	@Test
	public void Verify_FAQ_Button() {
		page.navigate("https://awspf.com/");
	page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("FAQ")).click();
   boolean flag = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Frequently Asked Questions")).isVisible();
   System.out.println(flag);
   Assert.assertTrue(flag);
	
	
	}
	
	
	
	
	
	
	
	

}
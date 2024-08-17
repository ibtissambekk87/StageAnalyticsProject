package step_def;


import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.BrowserUtils;
import utilities.Driver;

/*
in this class we will be able to create "pre" and "post" condition
for all the SCENARIOS and even STEPS
 */

public class Hooks {



/*
    // IMPORT THE @Before coming from io.cucumber.java

  // @Before
    public void setUpScenarios(){
        System.out.println("---> @Before: RUNNING BEFORE EACH SCENARIO ");
    }

   // @Before(value = "@db")
    public void setUpDBScenarios(){
        System.out.println("It comes from @Before annotation for database testing");

    }
*/
    @After
    public void tearDownScenarios(Scenario scenario){
       // System.out.println("It comes from @After annotation");

       if (scenario.isFailed()) {
           byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
           scenario.attach(screenshot, "image/png", scenario.getName());
       }

        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }

 /*   @BeforeStep
    public void setupSteps(){
        System.out.println("It comes from @BeforStep annotation");
    }

    @AfterStep
    public void teardownSteps(){
        System.out.println("It comes from @AfterStep annotation");
    }
*/

}

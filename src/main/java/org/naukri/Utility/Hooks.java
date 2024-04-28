package org.naukri.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
public class Hooks {
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> featureTest = new ThreadLocal<>();
    private static ThreadLocal<ExtentTest> scenarioTest = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentTest test = featureTest.get().createNode(scenario.getName());
        scenarioTest.set(test);
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            scenarioTest.get().fail("Test Case Failed: " + scenario.getName());
            scenarioTest.get().fail(scenario.getName() + " failed with exception: " + scenario.getStatus());
        } else {
            scenarioTest.get().pass("Test Case Passed: " + scenario.getName());
        }
        extent.flush();
    }

    @Before
    public void beforeFeature(cucumber.api.java.Before scenario) {
        ExtentTest test = extent.createTest(scenario.toString());
        featureTest.set(test);
    }


}

package org.naukri.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
    public ExtentReports extent;

    public  ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports();
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }
}

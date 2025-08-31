package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;
    private static ExtentTest test;
    private static ExtentSparkReporter sparkReporter;

    public static ExtentReports getInstance() {
        if (extent == null) {
            sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Tester", "Aritra Mondal");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }

    public static ExtentTest createTest(String testName, String description) {
        test = getInstance().createTest(testName, description);
        return test;
    }
}

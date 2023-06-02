package BasePackage;

import Reports.ExtentTestManager;
import com.aventstack.extentreports.Status;
import freemarker.template.utility.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;

import java.io.PrintWriter;
import java.io.StringWriter;

public class BaseClassConfig extends Constants {
    public WebDriver driver;

    public void testResultCapture(ITestResult result) {
        System.out.println("Check status " + result.getStatus());

        if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentTestManager.getExtentTest().log(Status.PASS, result.getMethod().getMethodName() + " Passed");
        }
        if (result.getStatus() == ITestResult.FAILURE) {
            if (result.getThrowable().getMessage().contains("Skipped By Retry")) {
                ExtentTestManager.getExtentTest().getExtent().removeTest(ExtentTestManager.getExtentTest());
            } else {
                StringWriter exceptionInfo = new StringWriter();
                result.getThrowable().printStackTrace(new PrintWriter(exceptionInfo));

                String methodClassName = result.getThrowable().getMessage();
                for (StackTraceElement stack : result.getThrowable().getStackTrace()) {
                    if (stack.getClassName().contains("Pages")) {
                        methodClassName = methodClassName + " failed in Class: " + stack.getClassName() +
                                ", in Method: " + stack.getMethodName() +
                                ", and Line: " + stack.getLineNumber();
                        break;
                    }
                }
                ExtentTestManager.getExtentTest().fail(methodClassName);
                ExtentTestManager.getExtentTest().addScreenCaptureFromBase64String(getBase64());
            }
        }
    }

    public String getBase64() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
}

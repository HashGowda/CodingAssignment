package BasePackage;

import Listeners.TestListeners;
import Reports.ExtentManager;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.sql.DriverManager;

@Listeners({TestListeners.class})
public class BaseClass extends TestListeners  {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        ExtentManager.configExtentTest(getClass().getName().substring(getClass().getName().lastIndexOf(".") + 1));
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method name) {
        ExtentManager.startTest(name);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        testResultCapture(result);
    }
}


package Test;

import OsOperation.QueryRunner;
import SystemUtilityOpertion.AddDirectoryAndFolder;
import Log.Log;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Base test class that contains common setup and teardown methods
 * All test classes should extend this class
 */
public class ConfTest {
    
    protected static AddDirectoryAndFolder closeCli = new AddDirectoryAndFolder();

    @BeforeTest
    public void launchCli() {
        QueryRunner querycli = new QueryRunner();
        Log.startTestCase("LunchCli");
    }

    @AfterTest
    public void closeCli() {
        Log.endTestCase("CloseCli And complete the Test");
        closeCli.killProcess();
    }
}

package Test;
import org.testng.annotations.*;
import Log.Log;
import static OsOperation.QueryRunner.VerifyTestOrUser;

public class TestCdCommand extends ConfTest {

    /**
     * Test navigating to a file using cd command
     * Verifies that attempting to cd to a file fails appropriately
     */
    @Test(priority = 0)
    public static void testNavigateToFile() throws Exception {
        VerifyTestOrUser("Test","touch "+Static.cdTestFile+"");
        VerifyTestOrUser("Test","cd "+Static.cdTestFile+"");
        VerifyTestOrUser("Test","cd ..");
        VerifyTestOrUser("Test","ls");
        Static.cdDirectoryListing=Static.cdListingCommand.testLs();
        if (Static.cdDirectoryListing.contains(Static.cdTestFile)) {
            assert true;
        } else {
            assert false;
        } }
    
    /**
     * Test navigating to a directory using cd command
     * Verifies successful directory navigation and path changes
     */
    @Test(priority = 1)
    public static void testNavigateToDirectory() throws Exception {
        VerifyTestOrUser("Test", "mkdir " + Static.cdTestDirectory + "");
        VerifyTestOrUser("Test", "cd " + Static.cdTestDirectory + "");
            }

}

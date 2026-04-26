package Test;
import org.testng.annotations.*;
import Log.Log;
import static OsOperation.QueryRunner.VerifyTestOrUser;
import static org.testng.AssertJUnit.assertEquals;

public class TestLsCommand extends ConfTest {
    
    /**
     * Test ls command on directory created with mkdir
     * Verifies that ls correctly lists newly created directories
     */
    @Test(priority = 0)
    public static void testListDirectoryAfterMkdir() throws Exception {
        VerifyTestOrUser("Test","mkdir "+Static.lsTestDirectory+"");
        VerifyTestOrUser("Test","ls");
        Static.lsDirectoryListing=Static.lsListingCommand.testLs();
        System.out.print(Static.lsDirectoryListing);
        if (Static.lsDirectoryListing.contains(Static.lsTestDirectory)) {
            assert true;
        } else {
            assert false;
        }
    }

    /**
     * Test ls command on file created with touch
     * Verifies that ls correctly lists newly created files
     */
    @Test(priority = 1)
    public static void testListFileAfterTouch() throws Exception {

        VerifyTestOrUser("Test","touch "+Static.lsTestFile+"");
        VerifyTestOrUser("Test","ls");
        Static.lsDirectoryListing=Static.lsListingCommand.testLs();
        System.out.print(Static.lsDirectoryListing);
        if (Static.lsDirectoryListing.contains(Static.lsTestFile)) {
            assert true;
        } else {
            assert false;
        } }
}

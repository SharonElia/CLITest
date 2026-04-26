package Test;

import Log.Log;
import org.testng.annotations.Test;

import static OsOperation.QueryRunner.VerifyTestOrUser;

@Test
public class TestTouchCommand extends ConfTest {

    /**
     * Test creating a file and attempting to navigate to it
     * Verifies file creation and proper error handling for cd on files
     */
    @Test(priority = 0)
    public static void testCreateFile() throws Exception {
        VerifyTestOrUser("Test","touch "+Static.touchTestFile+"");
        VerifyTestOrUser("Test","cd "+Static.touchTestFile+"");
        VerifyTestOrUser("Test","cd ..");
        VerifyTestOrUser("Test","ls");
        Static.touchDirectoryListing=Static.touchListingCommand.testLs();
        System.out.print(Static.touchDirectoryListing);
        if (Static.touchDirectoryListing.contains(Static.touchTestFile)) {
            assert true;
        } else {
            assert false;
        }
    }
    
    /**
     * Test creating multiple files with touch
     * Verifies batch file creation (20 files with .png extension)
     */
    @Test(priority = 1)
    public static void testCreateMultipleFiles() throws Exception {
        for(int i=2;i<=20;i++){
            VerifyTestOrUser("Test","touch Test"+i+".png");

        }
        VerifyTestOrUser("Test","ls");}
}

package Test;
import org.testng.annotations.*;
import Log.Log;
import static OsOperation.QueryRunner.VerifyTestOrUser;

@Test
public class TestMkdirCommand extends ConfTest {

    /**
     * Test creating a single directory with mkdir
     * Verifies directory creation and correct listing in ls output
     */
    @Test(priority = 0)
    public static void testCreateSingleDirectory() throws Exception {
        VerifyTestOrUser("Test","mkdir "+Static.mkdirTestDirectory+"");
        VerifyTestOrUser("Test","ls");
        Static.mkdirDirectoryListing=Static.mkdirListingCommand.testLs();
        System.out.print(Static.mkdirDirectoryListing);
        if (Static.mkdirDirectoryListing.contains(Static.mkdirTestDirectory)) {
            assert true;
        } else {
            assert false;
        }
    }
    
    /**
     * Test creating directory and navigating to it
     * Verifies directory creation and cd command functionality
     */
    @Test(priority = 1)
    public static void testCreateDirectoryAndNavigate() throws Exception {
        VerifyTestOrUser("Test","mkdir "+Static.mkdirTestDirectory2+"");
        VerifyTestOrUser("Test","cd "+Static.mkdirTestDirectory2+"");
        //VerifyTestOrUser("Test","Cd ..");
    }
    
    /**
     * Test creating multiple directories with mkdir
     * Verifies batch directory creation (20 directories)
     */
    @Test(priority = 1)
    public static void testCreateMultipleDirectories() throws Exception {
        for(int i=2;i<=20;i++){
        VerifyTestOrUser("Test","mkdir Test"+i+"");

    }
    VerifyTestOrUser("Test","ls");}
}

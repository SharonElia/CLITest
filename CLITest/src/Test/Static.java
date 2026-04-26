package Test;

import OsClasses.Ls;
import java.util.ArrayList;
import java.util.List;

/**
 * Centralized container for all static variables used across test classes
 * Provides a single point for managing test data and utilities
 */
public class Static {
    
    // ==================== TestCd Variables ====================
    /** Directory name for CD navigation tests */
    public static String cdTestDirectory = "TestCd";
    /** File name for CD navigation tests */
    public static String cdTestFile = "TestCd.txt";
    /** Ls command utility for CD tests */
    public static Ls cdListingCommand = new Ls();
    /** Directory listing results for CD tests */
    public static List<String> cdDirectoryListing = new ArrayList<String>();
    
    // ==================== TestLs Variables ====================
    /** Directory name for LS list verification tests */
    public static String lsTestDirectory = "TestLs";
    /** File name for LS list verification tests */
    public static String lsTestFile = "Testls.png";
    /** Ls command utility for LS tests */
    public static Ls lsListingCommand = new Ls();
    /** Directory listing results for LS tests */
    public static List<String> lsDirectoryListing = new ArrayList<String>();
    
    // ==================== TestMkdir Variables ====================
    /** Primary directory name for MKDIR creation tests */
    public static String mkdirTestDirectory = "TestMkdir";
    /** Secondary directory name for MKDIR creation tests */
    public static String mkdirTestDirectory2 = "TestMkdir1";
    /** Ls command utility for MKDIR tests */
    public static Ls mkdirListingCommand = new Ls();
    /** Directory listing results for MKDIR tests */
    public static List<String> mkdirDirectoryListing = new ArrayList<String>();
    /** Additional Ls instance for MKDIR tests */
    public static Ls mkdirListingInstance = new Ls();
    
    // ==================== TestTouch Variables ====================
    /** File name for TOUCH creation tests */
    public static String touchTestFile = "TestTouch.xml";
    /** Ls command utility for TOUCH tests */
    public static Ls touchListingCommand = new Ls();
    /** Directory listing results for TOUCH tests */
    public static List<String> touchDirectoryListing = new ArrayList<String>();
    /** Additional Ls instance for TOUCH tests */
    public static Ls touchListingInstance = new Ls();
}

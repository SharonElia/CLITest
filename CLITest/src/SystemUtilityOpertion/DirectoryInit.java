package SystemUtilityOpertion;

// Represents a directory node in the virtual file system.
public class DirectoryInit extends FileInitialization {

    // Creates the root directory.
    public DirectoryInit() {
        super("root", (DirectoryInit) null);
    }

    // Creates a child directory with a given parent.
    public DirectoryInit(String name, DirectoryInit parent) {
        super(name, parent);
    }

}

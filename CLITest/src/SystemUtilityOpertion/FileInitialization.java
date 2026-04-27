package SystemUtilityOpertion;

// Represents a file-system entry (file or directory metadata).
public class FileInitialization {
    protected String name;
    protected DirectoryInit parent;
    public String content;

    public FileInitialization(String name, DirectoryInit parent) {
        this.name = name;
        this.parent = parent;
    }

    // Returns file or directory name.
    public String getName() {
        return this.name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public DirectoryInit getParent() {
        return this.parent;
    }

    public void setParent(DirectoryInit p) {
        this.parent = p;
    }

    public FileInitialization(String name, DirectoryInit parent, String content) {
        this.name = name;
        this.parent = parent;
        this.content = content;
    }

    public FileInitialization(String name, String content) {
        this(name, AddDirectoryAndFolder.getCurrent(), content);
    }
}

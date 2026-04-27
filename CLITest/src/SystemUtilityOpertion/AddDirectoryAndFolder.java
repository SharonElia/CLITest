package SystemUtilityOpertion;

import java.util.ArrayList;

// Manages current directory context and path navigation in the virtual tree.
public class AddDirectoryAndFolder {

    private static AddDirectoryAndFolder self;
    private static DirectoryInit current;
    private static DirectoryInit root;
    private static DirectoryInit virtualCurrent;

    // Initializes directory context and creates the backing tree.
    public AddDirectoryAndFolder(DirectoryInit root) {
        AddDirectoryAndFolder.current = root;
        AddDirectoryAndFolder.virtualCurrent = root;
        AddDirectoryAndFolder.root = root;
        // Add root directory to the in-memory tree.
        CreateListAndTree.create(root);
    }

    public AddDirectoryAndFolder() {

    }

    // Creates the directory tree singleton when needed.
    public static AddDirectoryAndFolder createDirectoryTree(DirectoryInit root) {
        if (!(self instanceof AddDirectoryAndFolder)) {
            self = new AddDirectoryAndFolder(root);
        }

        return self;
    }

    // Updates both virtual and actual current directory pointers.
    public static void setCurrent(DirectoryInit directory) {
        virtualCurrent = directory;
        current = directory;
    }

    public static DirectoryInit getCurrent() {
        return AddDirectoryAndFolder.current;
    }

    public static void setVirtualCurrent(DirectoryInit directory) {
        virtualCurrent = directory;
    }

    public static DirectoryInit getVirtualCurrent() {
        return AddDirectoryAndFolder.virtualCurrent;
    }

    public static ArrayList<DirectoryInit> getFoldersOn(DirectoryInit target) {
        ArrayList<DirectoryInit> directories = new ArrayList<>();
        for (DirectoryInit directory : CreateListAndTree.getTree()) {
            if (directory.getParent() == target) {
                directories.add(directory);
            }
        }

        return directories;
    }

    // Returns folders under the current directory.
    public static ArrayList<DirectoryInit> getFoldersOnCurrent() {
        return getFoldersOn(current);
    }

    // Finds a directory by name under the provided current directory.
    public static DirectoryInit findDirOn(DirectoryInit current, String directoryName) {
        for (FileInitialization d : CreateListAndTree.getFilesOf(current)) {
            if (d.getName().equals(directoryName)) {
                return (DirectoryInit) d;
            }
        }
        return null;
    }

    // Sets current directory if the provided path exists.
    public static boolean setPath(String path) {
        DirectoryInit directory = AddDirectoryAndFolder.getDirectory(path);

        if (directory != null) {
            AddDirectoryAndFolder.setCurrent(directory);

            return true;
        }

        return false;
    }

    // Resolves and returns a directory from a path.
    public static DirectoryInit getDirectory(String path) {
        if (path == null || path.isEmpty()) {
            return null;
        }

        DirectoryInit originalVirtualCurrent = AddDirectoryAndFolder.getVirtualCurrent();

        if (path.charAt(0) == '/') {
            AddDirectoryAndFolder.setVirtualCurrent(root);
            path = path.substring(1);
        }

        String[] directories = path.split("/");

        for (String directory : directories) {
            if (directory.isEmpty() || directory.equals(".")) {
                continue;
            }

            DirectoryInit virtual = AddDirectoryAndFolder.getVirtualCurrent();
            DirectoryInit parent = virtual.getParent();

            if (directory.equals("..")) {

                if (parent == null) {
                    AddDirectoryAndFolder.setVirtualCurrent(originalVirtualCurrent);
                    return null;
                }

                AddDirectoryAndFolder.setVirtualCurrent(parent);
            } else {
                DirectoryInit currentDirectory;
                currentDirectory = AddDirectoryAndFolder.findDirOn(virtual, directory);

                if (currentDirectory == null) {
                    AddDirectoryAndFolder.setVirtualCurrent(originalVirtualCurrent);
                    return null;
                }

                AddDirectoryAndFolder.setVirtualCurrent(currentDirectory);
            }

        }

        DirectoryInit directoryFound = AddDirectoryAndFolder.getVirtualCurrent();
        AddDirectoryAndFolder.setVirtualCurrent(originalVirtualCurrent);

        return directoryFound;
    }

    // Checks whether a path exists using virtual traversal only.
    public static boolean pathExists(String path) {
        if (path == null || path.isEmpty()) {
            return false;
        }

        DirectoryInit originalVirtualCurrent = AddDirectoryAndFolder.getVirtualCurrent();

        if (path.charAt(0) == '/') {
            AddDirectoryAndFolder.setVirtualCurrent(root);
            path = path.substring(1);
        }

        String[] directories = path.split("/");

        for (String directory : directories) {
            if (directory.isEmpty() || directory.equals(".")) {
                continue;
            }

            DirectoryInit virtual = AddDirectoryAndFolder.getVirtualCurrent();
            DirectoryInit parent = virtual.getParent();

            if (directory.equals("..")) {

                if (parent == null) {
                    AddDirectoryAndFolder.setVirtualCurrent(originalVirtualCurrent);
                    return false;
                }

                AddDirectoryAndFolder.setVirtualCurrent(parent);
            } else {
                DirectoryInit currentDirectory;
                currentDirectory = AddDirectoryAndFolder.findDirOn(virtual, directory);

                if (currentDirectory == null) {
                    AddDirectoryAndFolder.setVirtualCurrent(originalVirtualCurrent);
                    return false;
                }

                AddDirectoryAndFolder.setVirtualCurrent(currentDirectory);
            }

        }

        AddDirectoryAndFolder.setVirtualCurrent(originalVirtualCurrent);
        return true;
    }

    // Resets static process state.
    public static void killProcess() {
        self = null;
        current = null;
        root = null;
        virtualCurrent = null;
    }

}

package SystemUtilityOpertion;

import java.util.ArrayList;

// Maintains the in-memory directory tree and directory-to-file mappings.
public class CreateListAndTree {
    private static ArrayList<DirectoryInit> tree = new ArrayList<>();
    private static CreateListAndTree self;

    public CreateListAndTree(DirectoryInit root) {
        tree = new ArrayList<>();
    }

    public CreateListAndTree() {

    }

    public static CreateListAndTree create(DirectoryInit root) {
        if (!(self instanceof CreateListAndTree)) {
            self = new CreateListAndTree(root);
        }
        return self;
    }

    public static ArrayList<DirectoryInit> getTree() {
        return tree;
    }

    public static boolean addDirectory(DirectoryInit newDir) {
        if (newDir == null || newDir.getParent() == null) {
            return false;
        }

        for (FileInitialization file : getFilesOf(newDir.getParent())) {
            if (file.getName().equals(newDir.getName())) {
                return false;
            }
        }
        return tree.add(newDir);
    }

    // Returns files/directories that belong to the given parent directory.
    public static ArrayList<FileInitialization> getFilesOf(DirectoryInit parent) {
        ArrayList<FileInitialization> files = new ArrayList<>();
        if (parent == null) {
            return files;
        }

        for (DirectoryInit d : getTree()) {
            DirectoryInit dParent = d.getParent();
            if (dParent == null) {
                continue;
            }

            if (dParent == parent) {
                files.add(d);
            }
        }
        return files;
    }
}

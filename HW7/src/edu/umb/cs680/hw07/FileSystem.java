package edu.umb.cs680.hw07;

import java.util.LinkedList;

public class FileSystem {
    public FileSystem() {};
    private static FileSystem instance = null;
    private LinkedList<Directory> rootDirectories = new LinkedList<>();

    public static FileSystem getInstance() {
        if (instance == null) {
            instance = new FileSystem();
        }

        return instance;
    }

    public LinkedList<Directory> getRootDirs() {
        return rootDirectories;
    }

    public void appendRootDirectories(Directory root) {
        rootDirectories.add(root);
    }

    public void clearFileSystem() {
        rootDirectories.clear();
    }
}

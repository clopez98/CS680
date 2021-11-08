package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {
    private LinkedList<FSElement> children = new LinkedList<>();
    private LinkedList<Directory> subDirectories = new LinkedList<>();
    private LinkedList<File> files = new LinkedList<>();

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    public void appendChild(FSElement child) {
        if (this.children == null) {
            this.children = new LinkedList<FSElement>();
        }
        this.children.add(child);
    }

    public int countChildren() {
        return children.size();
    }
    
    public LinkedList<FSElement> getChildren() {
        return children;
    }

    public LinkedList<Directory> getSubDirectories() {
        return subDirectories;
    }

    public boolean isDirectory() {
        return true;
    }

    public LinkedList<File> getFiles() {
        for (FSElement child : this.getChildren()) {
            if (child.getClass() == File.class) {
                files.add((File) child);
            }
        }
        return files;
    }

    public int getTotalSize() {
        int size = 0;

        for (FSElement element : getChildren()) {
            size += element.getTotalSize();
        }

        return size;
    }

}

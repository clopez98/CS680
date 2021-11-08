package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class DirectoryTest {
    private static FileSystem fileSystem;
    private static LocalDateTime currentTime = LocalDateTime.now();
    private static Directory root = new Directory(null, "root", 0, currentTime);
    private static Directory applications = new Directory(root, "applications", 0, currentTime);
    private static Directory home = new Directory(root, "home", 0, currentTime);
    private static Directory code = new Directory(home, "code", 0, currentTime);
    private static File a = new File(applications, "a", 10, currentTime);
    private static File b = new File(home, "b", 20, currentTime);
    private static File c = new File(home, "c", 30, currentTime);
    private static File d = new File(home, "d", 40, currentTime);
    

    @BeforeAll
    public static void setUpFileSystem() {
        fileSystem = FileSystem.getInstance();
        fileSystem.clearFileSystem();
        fileSystem.appendRootDirectories(root);
        root.appendChild(applications);
        applications.appendChild(a);
        root.appendChild(home);
        home.appendChild(code);
        home.appendChild(b);
        code.appendChild(c);
        code.appendChild(d);
    }

    private String[] directoryToStringArray(Directory directory) {
        return new String[] {String.valueOf(directory.getParent()), directory.getName(), String.valueOf(directory.getSize())};
    }

    private String[] directoryChildrenArray(Directory directory) {
        ArrayList<String> childrenList = new ArrayList<>();
        LinkedList<FSElement> childrenElements = directory.getChildren();

        for (FSElement child : childrenElements) {
            childrenList.add(child.getName());
        }

        String[] childrenArray = {};
        childrenArray = childrenList.toArray(childrenArray);

        return childrenArray;
    }
    
    private String[] fileLinkedListToArray(LinkedList<File> fileList) {
        ArrayList<String> fileArrayList = new ArrayList<>();

        for (File file : fileList) {
            fileArrayList.add(file.getName());
        }

        String[] fileArray = {};
        fileArray = fileArrayList.toArray(fileArray);

        return fileArray;
    }

    private String[] directoryLinkedListToArray(LinkedList<Directory> directoryList) {
        ArrayList<String> directoryArrayList = new ArrayList<>();

        for (Directory directory : directoryList) {
            directoryArrayList.add(directory.getName());
        }

        String[] directoryArray = {};
        directoryArray = directoryArrayList.toArray(directoryArray);
        return directoryArray;
    }

    @Test
    public void testCanCreateDirectory() {
        Directory actual = new Directory(applications, "actual", 10, currentTime);
        String[] expected = { String.valueOf(applications), "actual", "10" };
        assertArrayEquals(expected, directoryToStringArray(actual));
    }

    @Test
    public void testCanGetSubDirectories() {
        LinkedList<Directory> subDirectory = home.getSubDirectories();
        String[] actual = directoryLinkedListToArray(subDirectory);
        String[] expected = {"code"};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testIsDirectory() {
        assertTrue(applications.isDirectory());
    }

    @Test
    public void testCanAppendChildren() {
        File file = new File(applications, "file", 1, currentTime);
        applications.appendChild(file);
        String[] expected = {"a", "file"};
        assertArrayEquals(expected, directoryChildrenArray(applications));
    }

    @Test
    public void testCanCountChildren() {
        int actual = code.countChildren();
        assertEquals(2, actual);
    }

    @Test
    public void testCanGetFiles() {
        LinkedList<File> files = code.getFiles();
        String[] actual = fileLinkedListToArray(files);
        String[] expected = {"c", "d"};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testCanGetSized() {
        assertEquals(100, root.getTotalSize());
    }
}

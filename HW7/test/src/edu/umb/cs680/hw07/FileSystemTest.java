package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class FileSystemTest {
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

    private String[] rootLinkedListToArray(LinkedList<Directory> root) {
        ArrayList<String> arrayList = new ArrayList<>();

        for (Directory directory : root) {
            arrayList.add(directory.getName());
        }
        String[] array = {};
        return arrayList.toArray(array);
    }

    @Test
    public void testCanGetRootDirectories() {
        LinkedList<Directory> rootList = fileSystem.getRootDirs();
        String[] actual = rootLinkedListToArray(rootList);
        String[] expected = { "root" };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testCanAppendToRootDirectory() {
        Directory expected = new Directory(null, "expected", 100, currentTime);
        fileSystem.appendRootDirectories(expected);
        Directory actual = fileSystem.getRootDirs().getLast();
        assertEquals(actual, expected);
    }

    @Test
    public void testCanClearFileSystem() {
        fileSystem.clearFileSystem();
        assertEquals(new LinkedList<>(), fileSystem.getRootDirs());
    }
}

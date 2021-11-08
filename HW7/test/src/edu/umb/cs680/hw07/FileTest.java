package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class FileTest {
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

    private String[] fileToStringArray(File file) {
        return new String[] { String.valueOf(file.getParent()), file.getName(), String.valueOf(file.getSize()) };
    }

    @Test
    public void testCanCreateFile() {
        String[] actual = fileToStringArray(new File(applications, "actual", 100, currentTime));
        String[] expected = { String.valueOf(applications), "actual", "100" };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testCanGetTOtalSize() {
        assertEquals(a.getSize(), a.getTotalSize());
    }
}

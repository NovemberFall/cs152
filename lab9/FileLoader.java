import java.io.File;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static java.lang.System.out;

public class FileLoader {
    /**
     * List out all subdirectories of the specified directory.
     * Use a lambda rather than a FileFilter
     */
    public static void listSubdirectoriesLambda(String dirName) {
        out.println("List subdirectories, using a lambda (instead of FileFilter");
        File myDir = new File(dirName);
        
        File[] subDirs = myDir.listFiles((file) -> {return file.isDirectory();});
        for(File file : subDirs) {
            out.println(file.getName());
        }
    }

    /**
     * List out all subdirectories of the specified directory.
     * For this version, use a method reference.
     */
    public static void listSubdirectoriesMethodRef(String dirName) {
        out.println("List subdirectories using a method reference");
        File myDir = new File(dirName);
        //
        // YOUR CODE HERE
        //
    }

    /**
     * List out all files in the specified directory that have the specified extension.
     * Use a lambda rather than a FilenameFilter.
     */
    public static void listFiles(String dirName, String extension) {
        out.println("Listing all " + extension + " files");
        File dir = new File(dirName);
        //
        // YOUR CODE HERE
        //
    }

    public static void main(String[] args) {
        listSubdirectoriesLambda(".");
        // listSubdirectoriesMethodRef(".");
        // listFiles("src", "java");
    }

}
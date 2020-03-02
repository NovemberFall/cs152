## How do I use a FileFilter to display only the directories within a directory?
```java
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class DirectoryContents {

	public static void main(String[] args) throws IOException {

		File f = new File("."); // current directory

		FileFilter directoryFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};

		File[] files = f.listFiles(directoryFilter);
		for (File file : files) {
			if (file.isDirectory()) {
				System.out.print("directory:");
			} else {
				System.out.print("     file:");
			}
			System.out.println(file.getCanonicalPath());
		}

	}

}
```
---

## Java 8 - FileFilter example using Lambda expression
```java
import java.io.File;
import java.io.FileFilter;

/**
 * @author imssbora
 */
public class LambdaFileFilterExample {
	public static void main(String[] args) {
		File dir = new File("C:/Program Files/Java/jdk1.8.0_71");

		// Filter sub-directories using anonymous class
		File[] subDirs1 = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		});

		System.out.println("-------------Using anonymous class------------");
		for (File file : subDirs1) {
			System.out.println(file.getName());
		}

		// Filter sub-directories using Lambda expression
		File[] subDirs2 = dir.listFiles((file)->{return file.isDirectory();});
		System.out.println("-------------Using Lambda Expression------------");
		for (File file : subDirs2) {
			System.out.println(file.getName());
		}
	}
}
```
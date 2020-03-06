import java.io.File;
import java.io.FileFilter;

/**
 * @author imssbora
 */
public class LambdaFileFilterExample {
	public static void main(String[] args) {
		File dir = new File("/Users/Git/cs152/lab9/LambdaFileFilterExample.class");

		File[] subDir = dir.listFiles((file) -> {    // lambda expression
			  return file.isDirectory();
		   }
		);
		for(File file : subDir) {
		   System.out.println(file.getName());
		}
	 }
	
}
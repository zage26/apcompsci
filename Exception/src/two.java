import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class two {

	//Note: The parameter was given as a File,
	//however I changed it so that I could test the code
	
	public static void compile(String file) {
	    RandomAccessFile input = null;
	    String line = null;

	    try {
	        input = new RandomAccessFile(file, "r");
	        while ((line = input.readLine()) != null) {
	            System.out.println(line);
	        }
	        return;
	    } catch(FileNotFoundException fnf) {
	        System.err.format("File: %s not found%n", file);
	    } catch(IOException e) {
	        System.err.println(e.toString());
	    } finally {
	        if (input != null) {
	            try {
	                input.close();
	            } catch(IOException io) {
	            }
	        }
	    }
	}
	
	public static void main(String[] args) {
		compile("test.txt");
	}
	
}

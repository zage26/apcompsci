import java.io.*;
import java.util.Vector;

public class one {
    private Vector<Integer> vector;
    private static final int SIZE = 10;

    public one() {
        vector = new Vector<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++)
            vector.addElement(new Integer(i));

        this.readList("test.txt");
        this.writeList();
    }

    public void readList(String fileName) {
        String line = null;
        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "r");
            while ((line = raf.readLine()) != null) {
                Integer i = new Integer(Integer.parseInt(line));
                System.out.println(i);
                vector.addElement(i);
            }
        } catch(FileNotFoundException fnf) {
            System.err.println("File: " + fileName + " not found.");
        } catch (IOException io) {
            System.err.println(io.toString());
        }
    }

    public void writeList() {
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter("outfile.txt"));
            for (int i = 0; i < vector.size(); i++)
                out.println("Value at: " + i + " = " + vector.elementAt(i));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Caught ArrayIndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }

    public static void main(String[] args) {
        new one();
    }
}

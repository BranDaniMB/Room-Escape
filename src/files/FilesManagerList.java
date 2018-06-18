package files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeSet;
import objects.Team;

/**
 * Binary file team
 * It is responsible for saving the list of equipment
 * @author Jermy
 */
public class FilesManagerList {

    private ObjectInputStream reader;
    private ObjectOutputStream writer;

    /**
     * Open the file
     * It is responsible for opening the file where the list of equipment is located.
     * @param fileName
     * @throws IOException 
     */
    private void openReader(String fileName) throws IOException {
        reader = new ObjectInputStream(new FileInputStream(fileName));
    }

    /**
     * Read list
     * reads each item individually from the file
     * @return TreeSet
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    private TreeSet<Team> read() throws IOException, ClassNotFoundException {
        return (TreeSet<Team>) reader.readObject();
    }

    /**
     * Close read
     * Close the file reading
     * @throws IOException 
     */
    private void closeReader() throws IOException {
        reader.close();
    }

    /**
     * Open write
     * This method opens the writing to the file, that is, it allows the incorporation of new elements to the file
     * @param fileName
     * @throws IOException 
     */
    private void openWriter(String fileName) throws IOException {
        writer = new ObjectOutputStream(new FileOutputStream(fileName));
    }

    /**
     * Write
     * Allows writing new items to the list and saves them
     * @param element
     * @throws IOException 
     */
    private void write(TreeSet<Team> element) throws IOException {
        writer.writeObject(element);
    }

    /**
     * Close write
     * Close the writing of elements in the file.
     * @throws IOException 
     */
    private void closeWriter() throws IOException {
        writer.close();
    }

    /**
     * Readings of all the elements
     * This method is responsible for opening, reading the elements to the file and closing it
     * @param fileName
     * @return list team
     */
    public TreeSet<Team> readFile(String fileName) {
        TreeSet<Team> teams = new TreeSet<>();
        try {
            openReader(fileName);
            teams = read();
            closeReader();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return teams;
    }

    /**
     * Writing the elements
     * Open the file, write the new elements and close it
     * @param fileName
     * @param teams 
     */
    public void writeFile(String fileName, TreeSet<Team> teams) {
        try {
            openWriter(fileName);
            write(teams);
            closeWriter();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}

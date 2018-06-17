/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import gui.rooms.Rooms;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

/**
 *
 * @author Jermy
 */
public class FileManagerRooms {

    private ObjectInputStream reader;
    private ObjectOutputStream writer;

    public FileManagerRooms() {
    }

    private void openReader(String fileName) throws IOException {
        reader = new ObjectInputStream(new FileInputStream(fileName));
    }

    private TreeMap<String, Rooms> read() throws IOException, ClassNotFoundException {
        return (TreeMap<String, Rooms>) reader.readObject();
    }

    private void closeReader() throws IOException {
        reader.close();
    }

    private void openWriter(String fileName) throws IOException {
        writer = new ObjectOutputStream(new FileOutputStream(fileName));
    }

    private void write(TreeMap<String, Rooms> element) throws IOException {
        writer.writeObject(element);
    }

    private void closeWriter() throws IOException {
        writer.close();
    }

    public TreeMap<String, Rooms> readFile(String fileName) {
       TreeMap<String, Rooms> rooms = new TreeMap<>();
        try {
            openReader(fileName);
            rooms = read();
            closeReader();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return rooms;
    }

    public void writeFile(String fileName, TreeMap<String, Rooms> rooms) {
        try {
            openWriter(fileName);
            write(rooms);
            closeWriter();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}

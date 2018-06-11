/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import listManager.ListRiddle;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *
 * @author Jermy
 */
public class FilesManagerListRiddles {

    private ObjectInputStream reader;
    private ObjectOutputStream writer;

    private void openReader(String fileName) throws IOException {
        reader = new ObjectInputStream(new FileInputStream(fileName));
    }

    private ListRiddle read() throws IOException, ClassNotFoundException {
        return (ListRiddle) reader.readObject();
    }

    private void closeReader() throws IOException {
        reader.close();
    }

    private void openWriter(String fileName) throws IOException {
        writer = new ObjectOutputStream(new FileOutputStream(fileName));
    }

    private void write(ListRiddle element) throws IOException {
        writer.writeObject(element);
    }

    private void closeWriter() throws IOException {
        writer.close();
    }

    public ListRiddle readFile(String fileName) {
        ListRiddle listRiddle = null;
        try {
            openReader(fileName);
            listRiddle = read();
            closeReader();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return listRiddle;
    }

    public void writeFile(String fileName, ListRiddle listRiddle) {
        try {
            openWriter(fileName);
            write(listRiddle);
            closeWriter();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}

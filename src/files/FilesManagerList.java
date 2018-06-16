/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.TreeSet;
import listManager.TeamList;
import objects.Team;

/**
 *
 * @author Jermy
 */
public class FilesManagerList {

    private ObjectInputStream reader;
    private ObjectOutputStream writer;

    private void openReader(String fileName) throws IOException {
        reader = new ObjectInputStream(new FileInputStream(fileName));
    }

    private TreeSet<Team> read() throws IOException, ClassNotFoundException {
        return (TreeSet<Team>) reader.readObject();
    }

    private void closeReader() throws IOException {
        reader.close();
    }

    private void openWriter(String fileName) throws IOException {
        writer = new ObjectOutputStream(new FileOutputStream(fileName));
    }

    private void write(TreeSet<Team> element) throws IOException {
        writer.writeObject(element);
    }

    private void closeWriter() throws IOException {
        writer.close();
    }

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

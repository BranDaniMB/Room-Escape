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
import listManager.TeamList;

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

    private TeamList read() throws IOException, ClassNotFoundException {
        return (TeamList) reader.readObject();
    }

    private void closeReader() throws IOException {
        reader.close();
    }

    private void openWriter(String fileName) throws IOException {
        writer = new ObjectOutputStream(new FileOutputStream(fileName));
    }

    private void write(TeamList element) throws IOException {
        writer.writeObject(element);
    }

    private void closeWriter() throws IOException {
        writer.close();
    }

    public TeamList readFile(String fileName) {
        TeamList teamList = null;
        try {
            openReader(fileName);
            teamList = read();
            closeReader();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return teamList;
    }

    public void writeFile(String fileName, TeamList teamList) {
        try {
            openWriter(fileName);
            write(teamList);
            closeWriter();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}

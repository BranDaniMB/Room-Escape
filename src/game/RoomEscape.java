/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import files.FilesManagerList;
import files.FilesManagerListRiddles;
import files.PropertiesConfig;

/**
 *
 * @author Jermy
 */
public class RoomEscape {

    final static FilesManagerList FILES_MANAGER_LIST = new FilesManagerList();
    final static FilesManagerListRiddles FILES_MANAGER_LIST_RIDDLES = new FilesManagerListRiddles();

    public static void main(String[] args) {
        FILES_MANAGER_LIST.readFile("Files/TeamList.ser");
        FILES_MANAGER_LIST_RIDDLES.readFile("Files/RiddlesList.ser");
        PropertiesConfig.getInstance().readConfig();
        new Menu();
    }
}

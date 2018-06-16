package game;

import files.FilesManagerList;
import files.FilesManagerListRiddles;
import files.PropertiesConfig;
import listManager.ListRoomRiddle;
import listManager.TeamList;

/**
 *
 * @author Jermy
 */
public class RoomEscape extends Thread {

    final static FilesManagerList FILES_MANAGER_LIST = new FilesManagerList();
    final static FilesManagerListRiddles FILES_MANAGER_LIST_RIDDLES = new FilesManagerListRiddles();

    public static void main(String[] args) {
        TeamList.getInstance().setTeamsList(FILES_MANAGER_LIST.readFile("Files/TeamList.ser"));
        ListRoomRiddle.getInstance().setListRiddle(FILES_MANAGER_LIST_RIDDLES.readFile("Files/RiddlesList.ser"));
        PropertiesConfig.getInstance().readConfig();
        new Menu().runGui();
    }
}

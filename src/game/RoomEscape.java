package game;

import files.FilesManagerList;
import files.FilesManagerListRiddles;
import files.PropertiesConfig;
import gui.rooms.Room1;
import java.util.ArrayList;
import listManager.ListRoomRiddle;
import listManager.TeamList;
import objects.Riddle;
import objects.RoomRiddle;

/**
 *
 * @author Jermy
 */
public class RoomEscape {

    final static FilesManagerList FILES_MANAGER_LIST = new FilesManagerList();
    final static FilesManagerListRiddles FILES_MANAGER_LIST_RIDDLES = new FilesManagerListRiddles();

    public static void main(String[] args) {
        TeamList.getInstance().setTeamsList(FILES_MANAGER_LIST.readFile("Files/TeamList.ser"));
        ListRoomRiddle.getInstance().setListRiddle(FILES_MANAGER_LIST_RIDDLES.readFile("Files/RiddlesList.ser"));
        PropertiesConfig.getInstance().readConfig();
        new Menu().runGui();
    }

    private void chargeRiddles() {
        ArrayList<Riddle> riddles = new ArrayList<>();
        ArrayList<String> riddle = new ArrayList<>();
        riddles.add(new Riddle(question, answer, riddles, new TrackLocked));
        ListRoomRiddle.getInstance().addRiddle(new RoomRiddle(, new Room1()));
    }
}

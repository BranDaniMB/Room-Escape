package game;

<<<<<<< HEAD
import gui.main.FXMLMainWindowsController;
import javafx.fxml.FXMLLoader;
=======
import files.FilesManagerList;
import files.FilesManagerListRiddles;
import files.PropertiesConfig;
import listManager.ListRoomRiddle;
import listManager.TeamList;
>>>>>>> 22601f09fe5445617e90b2231770eee5ddacbfb9

/**
 *
 * @author Jermy
 */
public class RoomEscape extends Thread {

    @Override
    public void run() {
        load l = new load();
        l.getController().makeEmptyRegister();
    }

    private class load {

        private final FXMLLoader loader;

        public load() {
            this.loader = new FXMLLoader(getClass().getResource("FXMLMainWindows.fxml"));
        }

<<<<<<< HEAD
        public FXMLMainWindowsController getController() {
            return this.loader.getController();
        }
=======
    final static FilesManagerList FILES_MANAGER_LIST = new FilesManagerList();
    final static FilesManagerListRiddles FILES_MANAGER_LIST_RIDDLES = new FilesManagerListRiddles();

    public static void main(String[] args) {
        TeamList.getInstance().setTeamsList(FILES_MANAGER_LIST.readFile("Files/TeamList.ser"));
        ListRoomRiddle.getInstance().setListRiddle(FILES_MANAGER_LIST_RIDDLES.readFile("Files/RiddlesList.ser"));
        PropertiesConfig.getInstance().readConfig();
        new Menu().saveAllData();
>>>>>>> 22601f09fe5445617e90b2231770eee5ddacbfb9
    }
}

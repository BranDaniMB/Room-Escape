package game;

import gui.main.FXMLMainWindowsController;
import javafx.fxml.FXMLLoader;

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

        public FXMLMainWindowsController getController() {
            return this.loader.getController();
        }
    }

}

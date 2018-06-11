package gui.rooms;

import game.Game;
import game.GameRoom;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author BranDaniMB
 */
public class ManagerGameWindows extends Application {

    public static final String ROOM_1 = "FXMLRoom1.fxml";
    public static final String ROOM_2 = "FXMLRoom2.fxml";
    public static final String ROOM_3 = "FXMLRoom3.fxml";
    public static final String ROOM_4 = "FXMLRoom4.fxml";
    public static final String ROOM_5 = "FXMLRoom5.fxml";
    public static final String ROOM_6 = "FXMLRoom6.fxml";

    private String id;
    private String currentRoom;

    @Override
    public void start(Stage stage) throws Exception {
        Parameters params = getParameters();
        List<String> list = params.getRaw();
        this.id = list.get(0);

        GameRoom gameRoom = new GameRoom(new Game());
        this.currentRoom = gameRoom.getCurrentRoom();

        Parent root = FXMLLoader.load(getClass().getResource(currentRoom));

        Scene scene = new Scene(root);
        stage.setTitle("Room Escape");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

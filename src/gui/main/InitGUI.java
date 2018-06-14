package gui.main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author BranDaniMB
 */
public class InitGUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainWindows.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Menú");
        stage.setScene(scene);
        stage.show();
    }

    private void displaySelectionTeam() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLSelectionTeam.fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Panel de selección");
        stage.show();
    }

}

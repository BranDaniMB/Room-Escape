package gui.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author BranDaniMB
 */
public class InitSelectionGUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLSelectionTeam.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Menú de selección");
        stage.setScene(scene);
        stage.show();
    }

}

package gui.game;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author BranDaniMB
 */
public class FXMLSelectionTeamController implements Initializable {

    @FXML
    private Pane selectionPane;
    @FXML
    private Pane instructionsPane;

    //Instructions
    @FXML
    private TextArea instructionsText;
    @FXML
    private Button initGame;

    //selection
    @FXML
    private Button nextInstructions;

    @FXML
    private void displayInstructions() {
        selectionPane.setVisible(false);
        instructionsText.setText("El objetivo de este juego es salir de la habitación en un tiempo menor a los 30 minutos."
                + "\nBusque las pistas ocultas dentro de la habitación del juego, que te ayudarán a descubrir la respuesta al acertijo de cada candado."
                + "\nAl abrir los 4 candados se gana el juego, en caso de no abrirlos en 30 minutos, pierden el juego.");
        instructionsPane.setVisible(true);
    }

    @FXML
    private void runGame() {
        System.out.println("Run game");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

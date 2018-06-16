package gui.main;

import gui.main.ControllerGUI;
import gui.main.InitGUI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author BranDaniMB
 */
public class FXMLSelectionTeamController implements Initializable, ControllerGUI {

    private InitGUI root;

    @FXML
    private Pane selectionPane;
    @FXML
    private Pane instructionsPane;
    @FXML
    private TextArea selectableTeams;
    @FXML
    private TextField teamToPlayField;
    @FXML
    private TextArea listTeamsToPlay;
    @FXML
    private Label instructionsText;
    @FXML
    private Button initGame;
    @FXML
    private SplitMenuButton listTeams;
    @FXML
    private Button next;
    @FXML
    private Button back;

    @Override
    public void setMainGUI(InitGUI gui) {
        this.root = gui;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectableTeams.setText(root.getMenu().listSelectableTeams());
    }

    @FXML
    private void next() {
        selectionPane.setVisible(false);
        instructionsText.setText("El objetivo de este juego es salir de la habitación en un tiempo menor a los 30 minutos."
                + "\nBusque las pistas ocultas dentro de la habitación del juego, que te ayudarán a descubrir la respuesta al acertijo de cada candado."
                + "\nAl abrir los 4 candados se gana el juego, en caso de no abrirlos en 30 minutos, pierden el juego.");
        instructionsPane.setVisible(true);
    }

    @FXML
    private void addTeamToPlay() {

    }

    @FXML
    private void back() {

    }

    @FXML
    private void runGame() {

    }
}

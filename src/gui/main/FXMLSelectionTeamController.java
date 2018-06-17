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
import objects.Team;

/**
 * FXML Controller class
 *
 * @author BranDaniMB
 */
public class FXMLSelectionTeamController implements Initializable, ControllerGUI {

    private InitGUI root;

    @FXML
    private Pane selectionTeamsPane;
    @FXML
    private Pane selectionPlayersPane;
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
    private Label teamName;
    @FXML
    private TextArea selectablePlayerByTeam;
    @FXML
    private TextField playerToPlayField;
    @FXML
    private TextArea listPlayersToPlayByTeam;
    @FXML
    private Button back;

    @Override
    public void setMainGUI(InitGUI gui) {
        this.root = gui;
    }

    public void init() {
        selectableTeams.setText(root.getMenu().getSelectableTeams());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void next() {
        if (selectionTeamsPane.isVisible()) {
            root.getMenu().addsTeamsToPlay(listTeamsToPlay.getText());
            listTeamsToPlay.setText("");
            selectionTeamsPane.setVisible(false);
            selectionPlayersPane.setVisible(true);
            root.getMenu().getNextTeam();
            selectablePlayerByTeam.setText(root.getMenu().getSelectablePlayers());
            teamName.setText("Equipo " + root.getMenu().getCurrentSelectionTeam().getTeamName());
        } else if (root.getMenu().getTeamsToPlaySize() > 0) {
            if (!listPlayersToPlayByTeam.getText().equals("")) {
                root.getMenu().AddToList(listPlayersToPlayByTeam.getText());
                playerToPlayField.clear();
                listPlayersToPlayByTeam.clear();
            }
            root.getMenu().getNextTeam();
            selectablePlayerByTeam.setText(root.getMenu().getSelectablePlayers());
            teamName.setText("Equipo " + root.getMenu().getCurrentSelectionTeam().getTeamName());
        } else {
            selectionTeamsPane.setVisible(false);
            selectionPlayersPane.setVisible(false);
            instructionsText.setText("El objetivo de este juego es salir de la habitación en un tiempo menor a los 30 minutos."
                    + "\nBusque las pistas ocultas dentro de la habitación del juego, que te ayudarán a descubrir la respuesta al acertijo de cada candado."
                    + "\nAl abrir los 4 candados se gana el juego, en caso de no abrirlos en 30 minutos, pierden el juego.");
            instructionsPane.setVisible(true);
        }
    }

    @FXML
    private void addTeamToPlay() {
        if (!teamToPlayField.getText().equals("") && root.getMenu().getSelectableTeams().contains(teamToPlayField.getText())) {
            listTeamsToPlay.setText(listTeamsToPlay.getText() + teamToPlayField.getText() + "-");
        }
        teamToPlayField.clear();
    }

    @FXML
    private void addPlayerToPlay() {
        if (!playerToPlayField.getText().equals("") && root.getMenu().getSelectablePlayers().contains(playerToPlayField.getText())) {
            listPlayersToPlayByTeam.setText(listPlayersToPlayByTeam.getText() + playerToPlayField.getText() + "-");
        }
        playerToPlayField.clear();
    }

    @FXML
    private void back() {

    }

    @FXML
    private void runGame() {

    }
}

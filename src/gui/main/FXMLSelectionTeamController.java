package gui.main;

import builderteam.InvalidDataException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author BranDaniMB
 */
public class FXMLSelectionTeamController implements Initializable {

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
    @FXML
    private Label statusSelectionTeams;
    @FXML
    private Label statusSelectionPlayers;

    public void setMainGUI(InitGUI gui) {
        this.root = gui;
    }

    public void init() {
        selectableTeams.setText(root.getMenu().getSelectableTeams());
        root.getMenu().finalizeSelection();
        instructionsPane.setVisible(false);
        selectionPlayersPane.setVisible(false);
        selectionTeamsPane.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void displaySelectedPlayers() {
        try {
            root.getMenu().addsTeamsToPlay(listTeamsToPlay.getText());
            nextTeam();
            listTeamsToPlay.setText("");
            instructionsPane.setVisible(false);
            selectionTeamsPane.setVisible(false);
            selectionPlayersPane.setVisible(true);
        } catch (InvalidDataException ex) {
            statusSelectionTeams.setText(ex.getMessage());
        }
    }

    private void nextTeam() throws InvalidDataException {
        root.getMenu().getNextTeam();
        if (root.getMenu().getCurrentSelectionTeam() == null) {
            throw new InvalidDataException("No haz seleccionado ningún equipo.");
        }
        teamName.setText("Equipo " + root.getMenu().getCurrentSelectionTeam().getTeamName());
        selectablePlayerByTeam.setText(root.getMenu().getSelectablePlayers());
        listPlayersToPlayByTeam.clear();
        statusSelectionPlayers.setText("Estado: Sin cambios");
    }

    @FXML
    private void next() {
        if (root.getMenu().getCurrentSelectionTeam() != null) {
            try {
                root.getMenu().AddToList(listPlayersToPlayByTeam.getText());
                nextTeam();
            } catch (InvalidDataException ex) {
                statusSelectionPlayers.setText(ex.getMessage());
            }
        }

        if (root.getMenu().getCurrentSelectionTeam() == null) {
            displayInstructions();
        }
    }

    private void displayInstructions() {
        selectionTeamsPane.setVisible(false);
        selectionPlayersPane.setVisible(false);
        instructionsText.setText("El objetivo de este juego es salir de la habitación en un tiempo menor a los 30 minutos."
                + "\nBusque las pistas ocultas dentro de la habitación del juego, que te ayudarán a descubrir la respuesta al acertijo de cada candado."
                + "\nAl abrir los 4 candados se gana el juego, en caso de no abrirlos en 30 minutos, pierden el juego.");
        instructionsPane.setVisible(true);
    }

    @FXML
    private void addTeamToPlay() {
        if (!teamToPlayField.getText().equals("") && root.getMenu().getSelectableTeams().contains(teamToPlayField.getText())) {
            listTeamsToPlay.setText(listTeamsToPlay.getText() + teamToPlayField.getText() + "-");
        } else {
            statusSelectionTeams.setText("Equipo no existe o no es seleccionable.");
        }
        teamToPlayField.clear();
    }

    @FXML
    private void addPlayerToPlay() {
        if (!playerToPlayField.getText().equals("") && root.getMenu().getSelectablePlayers().contains(playerToPlayField.getText())) {
            listPlayersToPlayByTeam.setText(listPlayersToPlayByTeam.getText() + playerToPlayField.getText() + "-");
        } else {
            statusSelectionTeams.setText("Jugador no existe o no es seleccionable.");
        }
        playerToPlayField.clear();
    }

    @FXML
    private void back(Event event) {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void runGame() {

    }

    @FXML
    private void reload(Event event) {
        String mode = root.getMenu().getMode();

        root.getMenu().finalizeSelection();
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.close();
        try {
            root.displaySelectionWindows();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        root.getMenu().setMode(mode);
    }
}

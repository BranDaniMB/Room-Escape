package gui.main;

import builderteam.InvalidDataException;
import builderteam.ModifyTeam;
import objects.PseudoTeam;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 *
 * @author BranDaniMB
 */
public class FXMLMainWindowsController implements Initializable {

    private final ModifyTeam modifyTeam = new ModifyTeam();

    private InitGUI root;

    // Pane
    @FXML
    private Pane mainWindows;
    @FXML
    private Pane registerWindows;
    @FXML
    private Pane rankingWindows;
    @FXML
    private Pane modifyWindows;

    // Register
    @FXML
    private TextField registerTeamName;
    @FXML
    private TextField registerTeamPlayers;
    @FXML
    private TextArea listPlayers;
    @FXML
    private DatePicker registerTeamDatePicker;
    @FXML
    private Label registerStatus;

    // Modify
    @FXML
    private Label modifyStatus;
    @FXML
    private TextArea teamData;
    @FXML
    private TextField TFGetName;
    @FXML
    private TextField TFChangeName;
    @FXML
    private TextField TFChangeCurrentPlayerName;
    @FXML
    private TextField TFChangeNewPlayerName;
    @FXML
    private TextField TFChangeAddNewPlayer;

    // Rankings
    // By Name
    @FXML
    private TableView<PseudoTeam> tableByName;
    @FXML
    private TableColumn<PseudoTeam, String> tableByName_name;
    @FXML
    private TableColumn<PseudoTeam, String> tableByName_players;
    @FXML
    private TableColumn<PseudoTeam, String> tableByName_time;
    @FXML
    private TableColumn<PseudoTeam, String> tableByName_date;
    // By Inscription
    @FXML
    private TableView<PseudoTeam> tableByInscription;
    @FXML
    private TableColumn<PseudoTeam, String> tableByInscription_name;
    @FXML
    private TableColumn<PseudoTeam, String> tableByInscription_players;
    @FXML
    private TableColumn<PseudoTeam, String> tableByInscription_time;
    @FXML
    private TableColumn<PseudoTeam, String> tableByInscription_date;
    // By Time
    @FXML
    private TableView<PseudoTeam> tableByTime;
    @FXML
    private TableColumn<PseudoTeam, String> tableByTime_name;
    @FXML
    private TableColumn<PseudoTeam, String> tableByTime_players;
    @FXML
    private TableColumn<PseudoTeam, String> tableByTime_time;
    @FXML
    private TableColumn<PseudoTeam, String> tableByTime_date;

    public void setMainGUI(InitGUI gui) {
        this.root = gui;
    }

    @FXML
    private void displayMain() {
        rankingWindows.setVisible(false);
        registerWindows.setVisible(false);
        modifyWindows.setVisible(false);
        mainWindows.setVisible(true);
    }

    @FXML
    private void displayRegister() {
        makeEmptyRegister();
        rankingWindows.setVisible(false);
        mainWindows.setVisible(false);
        modifyWindows.setVisible(false);
        registerWindows.setVisible(true);
    }

    @FXML
    private void displayRanking() {
        getRankings();
        registerWindows.setVisible(false);
        mainWindows.setVisible(false);
        modifyWindows.setVisible(false);
        rankingWindows.setVisible(true);
    }

    @FXML
    private void displayModify() {
        finalizeChange();
        registerWindows.setVisible(false);
        mainWindows.setVisible(false);
        rankingWindows.setVisible(false);
        modifyWindows.setVisible(true);
    }

    private void getRankings() {
        ObservableList<PseudoTeam> listByName = FXCollections.observableArrayList(root.getMenu().listByName()
        );

        tableByName_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableByName_players.setCellValueFactory(new PropertyValueFactory<>("players"));
        tableByName_time.setCellValueFactory(new PropertyValueFactory<>("time"));
        tableByName_date.setCellValueFactory(new PropertyValueFactory<>("inscription"));
        tableByName.setItems(listByName);

        ObservableList<PseudoTeam> listByInscription = FXCollections.observableArrayList(root.getMenu().listByInscription());

        tableByInscription_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableByInscription_players.setCellValueFactory(new PropertyValueFactory<>("players"));
        tableByInscription_time.setCellValueFactory(new PropertyValueFactory<>("time"));
        tableByInscription_date.setCellValueFactory(new PropertyValueFactory<>("inscription"));
        tableByInscription.setItems(listByInscription);

        ObservableList<PseudoTeam> listByTime = FXCollections.observableArrayList(root.getMenu().listByTime());

        tableByTime_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableByTime_players.setCellValueFactory(new PropertyValueFactory<>("players"));
        tableByTime_time.setCellValueFactory(new PropertyValueFactory<>("time"));
        tableByTime_date.setCellValueFactory(new PropertyValueFactory<>("inscription"));
        tableByTime.setItems(listByTime);
    }

    @FXML
    private void registerTeam() {
        boolean isRegister = true;
        try {
            root.getMenu().registerTeamProcess(registerTeamName.getText(), listPlayers.getText(), registerTeamDatePicker.getValue());
        } catch (InvalidDataException ex) {
            isRegister = false;
            registerStatus.getStyleClass().clear();
            registerStatus.getStyleClass().add("status-err");
            registerStatus.setText("Estado: " + ex.getMessage());
        } finally {
            if (isRegister) {
                registerStatus.getStyleClass().clear();
                registerStatus.getStyleClass().add("status-success");
                registerStatus.setText("Estado: Registrado");
                root.getMenu().saveAllData();
            }
        }
    }

    @FXML
    private void addListPlayer() {
        listPlayers.setText(listPlayers.getText() + registerTeamPlayers.getText() + "-");
        registerTeamPlayers.clear();
    }

    @FXML
    public void makeEmptyRegister() {
        registerStatus.setText("Estado: Sin acciones");
        registerStatus.getStyleClass().clear();
        registerStatus.getStyleClass().add("status");
        registerTeamName.clear();
        registerTeamPlayers.clear();
        listPlayers.clear();
        registerTeamDatePicker.setValue(null);
    }

    @FXML
    private void getTeamData() {
        boolean success = true;
        try {
            teamData.setText(modifyTeam.ModifyTeam(TFGetName.getText()).toString());
        } catch (InvalidDataException ex) {
            success = false;
            teamData.getStyleClass().clear();
            teamData.getStyleClass().add("status-err");
            teamData.setText(ex.getMessage());
            modifyStatus.getStyleClass().clear();
            modifyStatus.getStyleClass().add("status-err");
            modifyStatus.setText(ex.getMessage());
        }

        if (success) {
            teamData.getStyleClass().clear();
            teamData.getStyleClass().add("status");
            modifyStatus.getStyleClass().clear();
            modifyStatus.getStyleClass().add("status-success");
            modifyStatus.setText("Equipo encontrado.");
        }
    }

    @FXML
    private void changeName() {
        boolean success = true;
        try {
            modifyTeam.changeName(TFChangeName.getText());
        } catch (InvalidDataException ex) {
            success = false;
            modifyStatus.getStyleClass().clear();
            modifyStatus.getStyleClass().add("status-err");
            modifyStatus.setText(ex.getMessage());
        }

        if (success) {
            modifyStatus.getStyleClass().clear();
            modifyStatus.getStyleClass().add("status-success");
            modifyStatus.setText("Cambio de nombre efectivo.");
        }
    }

    @FXML
    private void changePlayer() {
        boolean success = true;
        try {
            modifyTeam.changePlayerId(TFChangeCurrentPlayerName.getText(), TFChangeNewPlayerName.getText());
        } catch (InvalidDataException ex) {
            success = false;
            modifyStatus.getStyleClass().clear();
            modifyStatus.getStyleClass().add("status-err");
            modifyStatus.setText(ex.getMessage());
        }

        if (success) {
            modifyStatus.getStyleClass().clear();
            modifyStatus.getStyleClass().add("status-success");
            modifyStatus.setText("Cambio de nombre de jugador efectivo.");
        }
    }

    @FXML
    private void changeAddPlayer() {
        boolean success = true;
        try {
            modifyTeam.addPlayers(TFChangeAddNewPlayer.getText());
        } catch (InvalidDataException ex) {
            success = false;
            modifyStatus.getStyleClass().clear();
            modifyStatus.getStyleClass().add("status-err");
            modifyStatus.setText(ex.getMessage());
        }

        if (success) {
            modifyStatus.getStyleClass().clear();
            modifyStatus.getStyleClass().add("status-success");
            modifyStatus.setText("Jugador agregado con exito.");
        }
    }

    private void makeEmptyModifyTeam() {
        TFChangeAddNewPlayer.clear();
        TFChangeCurrentPlayerName.clear();
        TFChangeName.clear();
        TFChangeNewPlayerName.clear();
        TFGetName.clear();
        teamData.setText("Sin equipo");
        teamData.getStyleClass().clear();
        teamData.getStyleClass().add("status");
        modifyStatus.setText("Estado sin acciones");
        modifyStatus.getStyleClass().clear();
        modifyStatus.getStyleClass().add("status");
    }

    @FXML
    private void finalizeChange() {
        modifyTeam.finalizeChange();
        makeEmptyModifyTeam();
    }

    @FXML
    private void IndividualGame() {
        try {
            this.root.displaySelectionWindows();
            this.root.getMenu().setMode(game.GameRoom.TYPE_GAME_SINGLE);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    private void multiplayerGame() {
        try {
            this.root.displaySelectionWindows();
            this.root.getMenu().setMode(game.GameRoom.TYPE_GAME_MULTIPLAYER);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    private void close() {
        try {
            this.root.close();
        } catch (Exception ex) {
            Logger.getLogger(FXMLMainWindowsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

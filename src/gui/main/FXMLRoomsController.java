/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author BranDaniMB
 */
public class FXMLRoomsController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private Button objectButton1;
    @FXML
    private Button objectButton2;
    @FXML
    private Button objectButton3;
    @FXML
    private Button objectButton4;
    @FXML
    private Button objectButton5;
    @FXML
    private Button objectButton6;
    @FXML
    private Button objectButton7;
    @FXML
    private Button objectButton8;
    @FXML
    private Button objectButton9;
    @FXML
    private Button objectButton10;
    @FXML
    private Button objectButton11;
    @FXML
    private Button objectButton12;

    @FXML
    private Button padlock1;
    @FXML
    private Button padlock2;
    @FXML
    private Button padlock3;
    @FXML
    private Button padlock4;

    @FXML
    private TextArea tracksText;

    @FXML
    private void pressObject(Event event) {
        Button button = (Button) event.getSource();
        System.out.println(button.getId());
    }

    @FXML
    private void pressPadlock(Event event) {
        Button button = (Button) event.getSource();
        System.out.println(button.getId());
    }

    private void disablePadlock(Button button) {

    }
}

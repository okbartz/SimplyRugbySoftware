package com.example.simplyrugbysoftware;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CoachSessionsMenuController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private int CurrentUserID;
    @FXML
    private TextField idField;
//    @FXML
//    private Button sessionBtn;
//    @FXML
//    private Button fixtureBtn;
//    @FXML
//    private Button backBtn;
    @FXML
    private Text RemoveORViewText;

    @FXML
    private Text errorText;

    @FXML
    private TextArea lstBox;

    @FXML
    private Pane AddSessionPane;
    @FXML
    private Pane ViewSessionPane1;
    @FXML
    private Pane EditSessionPane;
    @FXML
    private Pane RemoveSessionPane;



    //Remove Member Variables
    @FXML
    private TextField RemoveSessionInput;


    //View Member Variables
    @FXML
    private TextField ViewSessionInput;

// Adding Members


    @FXML private TextField InputTeamId;
    @FXML private TextField InputTimeLimit;
    @FXML private ChoiceBox InputActivity;

    private String[] options = {"Passing","Catching","Running","Tackling","Rucking"};

    @FXML private DatePicker InputDate;

    // >>>

    // Editing Members


    @FXML private TextField InputTeamId1;
    @FXML private TextField InputTimeLimit1;
    @FXML private TextField SessionID1;
    @FXML private ChoiceBox InputActivity1;


    @FXML private DatePicker InputDate1;

    // >>>


    DatabaseController databaseController = new DatabaseController();


    public void SwitchSceneMain(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Coach1.fxml"));
        root = loader.load();

        CoachController coachController = loader.getController();

        coachController.setUser(CurrentUserID);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void setUser(int UserID) {
        CurrentUserID = UserID;
        InputActivity.getItems().addAll(options);

    }


    public void openViewSession(ActionEvent event) throws IOException {
        AddSessionPane.setVisible(false);
        ViewSessionPane1.setVisible(true);
        RemoveSessionPane.setVisible(false);

    }
    public void openAddSession(ActionEvent event) throws IOException {
        AddSessionPane.setVisible(true);
        ViewSessionPane1.setVisible(false);
        RemoveSessionPane.setVisible(false);


    }

    public void openRemoveSession(ActionEvent event) throws IOException {
        AddSessionPane.setVisible(false);
        ViewSessionPane1.setVisible(false);
        RemoveSessionPane.setVisible(true);


    }


    public void AddSession(ActionEvent event) throws IOException {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate selectedDate = InputDate.getValue();
            String DateValues = selectedDate.format(formatter);


            Session session = new Session(Integer.parseInt(InputTeamId.getText()), 1, Integer.parseInt(InputTimeLimit.getText()), DateValues, String.valueOf(InputActivity.getValue()));

            System.out.println(session);
            databaseController.AddSession(session);
            AddSessionPane.setVisible(false);
        }catch (Exception e){

            errorText.setText("Make sure that fields are correct");

        }


    }

    public void ViewSession(ActionEvent event) throws IOException {

        try{
        String SessionIdtext = String.valueOf(databaseController.ViewSession(Integer.parseInt(ViewSessionInput.getText())));
        System.out.println(SessionIdtext);
        lstBox.setText(SessionIdtext);
        errorText.setText("");

        }catch (Exception e){

        errorText.setText("Make sure that the ID is a number ex: 0,1,2");

        }

    }

    public void RemoveSessions(ActionEvent event) throws IOException {
        try{
        databaseController.DeleteSession(Integer.parseInt(RemoveSessionInput.getText()));
        RemoveSessionPane.setVisible(false);
        errorText.setText("");

        }catch (Exception e){

        errorText.setText("Make sure that the ID is a number ex: 0,1,2");

        }
    }






}
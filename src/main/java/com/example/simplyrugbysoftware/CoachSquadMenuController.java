package com.example.simplyrugbysoftware;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CoachSquadMenuController {
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
    private Pane AddSquadPane;
    @FXML
    private Pane ViewSquadPane1;
    @FXML
    private Pane EditSquadPane;
    @FXML
    private Pane RemoveSquadPane;



    //Remove Squad Variables
    @FXML
    private TextField RemoveSquadInput;


    //View Member Variables
    @FXML
    private TextField ViewSquadInput;

// Adding Squads


    @FXML private TextField InputTeamID;

    @FXML private ChoiceBox InputAgegrade;

    // >>>

    // Editing Squads

    @FXML private TextField InputTeamID1;

    @FXML private ChoiceBox InputAgegrade1;


    // >>>

    private String[] ageGrades = {"U9","U10"};

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
        InputAgegrade1.getItems().addAll(ageGrades);
        InputAgegrade.getItems().addAll(ageGrades);

    }


    public void openViewSquad(ActionEvent event) throws IOException {
        AddSquadPane.setVisible(false);
        ViewSquadPane1.setVisible(true);
        RemoveSquadPane.setVisible(false);
        EditSquadPane.setVisible(false);
    }
    public void openAddSquad(ActionEvent event) throws IOException {
        AddSquadPane.setVisible(true);
        ViewSquadPane1.setVisible(false);
        RemoveSquadPane.setVisible(false);
        EditSquadPane.setVisible(false);

    }
    public void openEditSquad(ActionEvent event) throws IOException {
        AddSquadPane.setVisible(false);
        ViewSquadPane1.setVisible(false);
        RemoveSquadPane.setVisible(false);
        EditSquadPane.setVisible(true);


    }
    public void openRemoveSquad(ActionEvent event) throws IOException {
        AddSquadPane.setVisible(false);
        ViewSquadPane1.setVisible(false);
        RemoveSquadPane.setVisible(true);
        EditSquadPane.setVisible(false);


    }





    public void AddSquad(ActionEvent event) throws IOException {

        try {




            Squad Squad = new Squad(Integer.parseInt(String.valueOf(InputTeamID.getText())),String.valueOf(InputAgegrade.getValue()));
            System.out.println(Squad);
            databaseController.AddSquad(Squad);
            AddSquadPane.setVisible(false);
            errorText.setText("");
        }catch (Exception e){

            errorText.setText(e.getMessage());

        }


    }
    public void EditSquad(ActionEvent event) throws IOException {

        try {

            Squad Squad = new Squad(Integer.parseInt(String.valueOf(InputTeamID1.getText())),String.valueOf(InputAgegrade1.getValue()));
            System.out.println(Squad);
            databaseController.EditSquad(Integer.parseInt(InputTeamID1.getText()), Squad);
            EditSquadPane.setVisible(false);
            errorText.setText("");
        }catch (Exception e){

        errorText.setText(e.getMessage());

        }

    }
    public void ViewSquad(ActionEvent event) throws IOException {

        try{
        String SquadIdtext = String.valueOf(databaseController.ViewOneSquad(Integer.parseInt(ViewSquadInput.getText())));
        System.out.println(SquadIdtext);
        lstBox.setText(SquadIdtext);
        errorText.setText("");

        }catch (Exception e){

        errorText.setText("Make sure that the ID is a number ex: 0,1,2");

        }

    }

    public void ViewAll(ActionEvent event) throws IOException {


        try{
            String AllText = String.valueOf(databaseController.ViewAllSquad());
            System.out.println(AllText);
            lstBox.setText(AllText);
            errorText.setText("");

        }catch (Exception e){

            errorText.setText("There is no members");

        }


    }

    public void RemoveSquad(ActionEvent event) throws IOException {
        try{
            databaseController.DeleteSquad(Integer.parseInt(RemoveSquadInput.getText()));
            RemoveSquadPane.setVisible(false);
            errorText.setText("");

        }catch (Exception e){

            errorText.setText("Make sure that the ID is a number ex: 0,1,2");

        }
    }








}
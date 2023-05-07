package com.example.simplyrugbysoftware;

/*

07/05/2023
Simply Rugby Software
Bartlomiej Klich

*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CoachController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField idField;
//    @FXML
//    private Button sessionBtn;
//    @FXML
//    private Button fixtureBtn;
//    @FXML
//    private Button backBtn;
    @FXML
    private Text welcomeText;

    @FXML
    private Text errorText;

    @FXML
    private TextArea lstBox;

    @FXML
    private Pane consentPane;

    private int CurrentUserID;

    private Member Currentmember;

    DatabaseController databaseController = new DatabaseController();

    //method for setting the user

    public void setUser(int UserID) {
        CurrentUserID = UserID;
        welcomeText.setText("Welcome, " + databaseController.ViewMember(CurrentUserID).getFname());
        Currentmember = databaseController.ViewMember(CurrentUserID);
    }




//method for switching to the main menu scene
    public void SwitchSceneMain(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    //method for switching to the member menu scene
    public void SwitchSceneMember(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CoachMemberMenu.fxml"));
        root = loader.load();

        CoachMemberMenuController coachMemberMenuController = loader.getController();

        coachMemberMenuController.setUser(CurrentUserID);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    //method for switching to the coach menu scene
    public void SwitchSceneCoach(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CoachCoachMenu.fxml"));
        root = loader.load();

        CoachCoachMenuController coachCoachMenuController = loader.getController();

        coachCoachMenuController.setUser(CurrentUserID);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    //method for switching to the session menu scene
    public void SwitchSceneSession(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CoachSessionsMenu.fxml"));
        root = loader.load();

        CoachSessionsMenuController coachSessionsMenuController = loader.getController();

        coachSessionsMenuController.setUser(CurrentUserID);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    //method for switching to the squad menu scene
    public void SwitchSceneSquad(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CoachSquadMenu.fxml"));
        root = loader.load();

        CoachSquadMenuController coachSquadMenuController = loader.getController();

        coachSquadMenuController.setUser(CurrentUserID);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    //method for switching to the fixture menu scene
    public void SwitchSceneFixture(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CoachFixturesMenu.fxml"));
        root = loader.load();

        CoachFixturesMenuController coachFixturesMenuController = loader.getController();

        coachFixturesMenuController.setUser(CurrentUserID);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    //method for switching to the player menu scene
    public void SwitchScenePlayer(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CoachPlayerMenu.fxml"));
        root = loader.load();

        CoachPlayerMenuController coachPlayerMenuController = loader.getController();

        coachPlayerMenuController.setUser(CurrentUserID);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

}
package com.example.simplyrugbysoftware;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MemberController {
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


    public void setUser(int UserID) {
        CurrentUserID = UserID;
        welcomeText.setText("Welcome, " + databaseController.ViewMember(CurrentUserID).getFname());
        Currentmember = databaseController.ViewMember(CurrentUserID);
    }

    public void SwitchSceneMain(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void ViewSesh(ActionEvent event) throws IOException {


            System.out.println("current memberid = " + CurrentUserID);
            int PlayerID = databaseController.ViewPlayer(CurrentUserID).getTeamID();
            System.out.println(PlayerID);
            String seshText = (databaseController.ViewPlayersSession(PlayerID));
            System.out.println(seshText);
            lstBox.setText(seshText);



    }
    public void ViewFixt(ActionEvent event) throws IOException {

        System.out.println("current memberid = " + CurrentUserID);
        int PlayerID = databaseController.ViewPlayer(CurrentUserID).getTeamID();
        System.out.println(PlayerID);
        String fixtText = (databaseController.ViewPlayerFixtures(PlayerID));
        System.out.println(fixtText);
        lstBox.setText(fixtText);



    }

    public void openConsent(ActionEvent event) throws IOException {

        consentPane.setVisible(true);



    }

    public void setConsent(ActionEvent event) throws IOException {

       Player playerconsent = databaseController.ViewPlayer(CurrentUserID);
       playerconsent.setConsent(true);
       databaseController.EditPlayer(CurrentUserID,playerconsent);
        System.out.println(databaseController.ViewPlayer(CurrentUserID));
        consentPane.setVisible(false);

    }



}
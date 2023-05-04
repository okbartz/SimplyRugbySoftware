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
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CoachFixturesMenuController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private int CurrentUserID;
    @FXML
    private TextField idField;
    @FXML
    private TextField viewFixtureInput;

    @FXML
    private Text RemoveORViewText;

    @FXML
    private Text errorText;

    @FXML
    private TextArea lstBox;


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


    }



    public void ViewFixture(ActionEvent event) throws IOException {

        try{
        String FixtureIdtext = String.valueOf(databaseController.ViewPlayerFixtures(Integer.parseInt(viewFixtureInput.getText())));
        System.out.println(FixtureIdtext);
        lstBox.setText(FixtureIdtext);
        errorText.setText("");

        }catch (Exception e){

        errorText.setText("Make sure that the ID is a number ex: 0,1,2");

        }

    }






}
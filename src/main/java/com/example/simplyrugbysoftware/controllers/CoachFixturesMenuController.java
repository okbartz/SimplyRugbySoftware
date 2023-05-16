package com.example.simplyrugbysoftware.controllers;
/*

07/05/2023
Simply Rugby Software
Bartlomiej Klich

*/
import com.example.simplyrugbysoftware.DatabaseController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 * Coach Fixture controller class, the class that controls the CoachFixturesMenu scene.
 * @author Bartlomiej Klich
 * @version
 *
 *
 */
public class CoachFixturesMenuController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    //variables
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

    //initializing the databasecontroller
    DatabaseController databaseController = new DatabaseController();

    //method for switching back to the coach choice menu
    /**
     *
     * Method for switching scenes to the main scene.
     * @author Bartlomiej Klich
     * @version
     *
     *
     */
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
    //method for setting the user
    /**
     *
     * Method for setting current users, user id.
     * @author Bartlomiej Klich
     * @version
     * @param UserID the variable used for holding the user id.
     *
     *
     */
    public void setUser(int UserID) {
        CurrentUserID = UserID;


    }


    //method for viewing fixtures
    /**
     *
     * Method for viewing fixtures using a team ID.
     * @author Bartlomiej Klich
     * @version
     *
     */
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
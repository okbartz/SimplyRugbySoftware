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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
/**
 *
 * Coach Squad controller class, the class that controls the CoachSquadMenu scene.
 * @author Bartlomiej Klich
 * @version
 *
 *
 */
public class CoachSquadMenuController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    //variables
    private int CurrentUserID;
    @FXML
    private TextField idField;

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

    private String[] ageGrades = {"U9","U10"};

    //Remove Squad Variables
    @FXML
    private TextField RemoveSquadInput;


    //View Squad Variables
    @FXML
    private TextField ViewSquadInput;

// Adding Squads variables


    @FXML private TextField InputTeamID;

    @FXML private ChoiceBox InputAgegrade;



    // Editing Squads variables

    @FXML private TextField InputTeamID1;

    @FXML private ChoiceBox InputAgegrade1;


    //initializing the databasecontroller
    DatabaseController databaseController = new DatabaseController();

    //method for switching to the coach choice menu scene.
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
        InputAgegrade1.getItems().addAll(ageGrades);
        InputAgegrade.getItems().addAll(ageGrades);

    }

    //methods for opening the different panes
    /**
     *
     * Method for opening the view squad pane(making the view squad pane visible and the other panes to invisible).
     * @author Bartlomiej Klich
     * @version
     */
    public void openViewSquad(ActionEvent event) throws IOException {
        AddSquadPane.setVisible(false);
        ViewSquadPane1.setVisible(true);
        RemoveSquadPane.setVisible(false);
        EditSquadPane.setVisible(false);
    }
    /**
     *
     * Method for opening the add squad pane(making the add squad pane visible and the other panes to invisible).
     * @author Bartlomiej Klich
     * @version
     */
    public void openAddSquad(ActionEvent event) throws IOException {
        AddSquadPane.setVisible(true);
        ViewSquadPane1.setVisible(false);
        RemoveSquadPane.setVisible(false);
        EditSquadPane.setVisible(false);

    }
    /**
     *
     * Method for opening the edit squad pane(making the edit squad pane visible and the other panes to invisible).
     * @author Bartlomiej Klich
     * @version
     */
    public void openEditSquad(ActionEvent event) throws IOException {
        AddSquadPane.setVisible(false);
        ViewSquadPane1.setVisible(false);
        RemoveSquadPane.setVisible(false);
        EditSquadPane.setVisible(true);


    }
    /**
     *
     * Method for opening the remove squad pane(making the remove squad pane visible and the other panes to invisible).
     * @author Bartlomiej Klich
     * @version
     */
    public void openRemoveSquad(ActionEvent event) throws IOException {
        AddSquadPane.setVisible(false);
        ViewSquadPane1.setVisible(false);
        RemoveSquadPane.setVisible(true);
        EditSquadPane.setVisible(false);


    }




//method for adding a squad
    /**
     *
     * Method for adding squads to the squad table.
     * @author Bartlomiej Klich
     * @version
     */
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
    //method for editing a squad
    /**
     *
     * Method for editing squads from the squad table.
     * @author Bartlomiej Klich
     * @version
     */
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
    //method for viewing a squad
    /**
     *
     * Method for viewing squads from the squad table.
     * @author Bartlomiej Klich
     * @version
     */
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
    //method for viewing all squad
    /**
     *
     * Method for viewing all squads from the squad table.
     * @author Bartlomiej Klich
     * @version
     */
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
    //method for removing a squad
    /**
     *
     * Method for removing squads from the squad table.
     * @author Bartlomiej Klich
     * @version
     */
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
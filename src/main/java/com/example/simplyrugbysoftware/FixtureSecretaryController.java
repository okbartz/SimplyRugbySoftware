package com.example.simplyrugbysoftware;

import com.example.simplyrugbysoftware.DatabaseController;
import com.example.simplyrugbysoftware.Fixture;
import com.example.simplyrugbysoftware.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



/**
 *
 * Fixture controller class, the class that controls the Fixture scene.
 * @author Bartlomiej Klich
 * @version
 *
 *
 */
public class FixtureSecretaryController {
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
    private Pane fixturesPane;
    @FXML
    private Pane MemberPane1;
    @FXML
    private Pane AddFixturePane;

    @FXML
    private Pane RemoveFixturePane;


    //View Fixture Variables
    @FXML
    private TextField fixtureTeamID;


    //View Member Variables
    @FXML
    private TextField playerID1;

// Adding Fixtures variables


    @FXML private TextField fixtureTeamIdInput;
    @FXML private TextField fixtureFixtureIDInput;
    @FXML private TextField fixturePlayingFieldInput;
    @FXML private TextField fixtureSkillsInput;
    @FXML private TextField fixtureTimelimitInput;
    @FXML private DatePicker fixtureDateInput1;

    //removing fixtures variables

    @FXML private TextField removeFixtureInput;

    private int CurrentUserID;

    private Member Currentmember;

    //initiating the database controller
    DatabaseController databaseController = new DatabaseController();

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
        welcomeText.setText("Welcome, " + databaseController.ViewMember(CurrentUserID).getFname());
        Currentmember = databaseController.ViewMember(CurrentUserID);
    }

    //method for switching scenes to the main menu
    /**
     *
     * Method for switching scenes to the main scene.
     * @author Bartlomiej Klich
     * @version
     *
     *
     */
    public void SwitchSceneMain(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //methods for opening the different panes
    /**
     *
     * Method for opening the fixture pane(making the fixture pane visible and the other panes to invisible).
     * @author Bartlomiej Klich
     * @version
     *
     *
     *
     */
    public void openFixtures(ActionEvent event) throws IOException {
        fixturesPane.setVisible(true);
        MemberPane1.setVisible(false);
        AddFixturePane.setVisible(false);
        RemoveFixturePane.setVisible(false);
    }
    /**
     *
     * Method for opening the add fixture pane(making the add fixture pane visible and the other panes to invisible).
     * @author Bartlomiej Klich
     * @version
     *
     *
     *
     */
    public void openAddFixtures(ActionEvent event) throws IOException {
        fixturesPane.setVisible(false);
        MemberPane1.setVisible(false);
        AddFixturePane.setVisible(true);
        RemoveFixturePane.setVisible(false);
    }
    /**
     *
     * Method for opening the view members pane(making the view members pane visible and the other panes to invisible).
     * @author Bartlomiej Klich
     * @version
     *
     *
     *
     */
    public void openViewMembers(ActionEvent event) throws IOException {
        fixturesPane.setVisible(false);
        MemberPane1.setVisible(true);
        AddFixturePane.setVisible(false);
        RemoveFixturePane.setVisible(false);
    }

    /**
     *
     * Method for opening the remove fixtures pane(making the remove fixtures pane visible and the other panes to invisible).
     * @author Bartlomiej Klich
     * @version
     *
     *
     *
     */
    public void openRemoveFixtures(ActionEvent event) throws IOException {
        fixturesPane.setVisible(false);
        MemberPane1.setVisible(false);
        AddFixturePane.setVisible(false);
        RemoveFixturePane.setVisible(true);
    }

    //method for viewing the fixtures

    /**
     *
     * Method for viewing fixtures using a team ID.
     * @author Bartlomiej Klich
     * @version
     *
     */
    public void ViewFixtures(ActionEvent event) throws IOException {

    try {
    String FixtId = (databaseController.ViewPlayerFixtures(Integer.parseInt(fixtureTeamID.getText())));
    System.out.println(FixtId);
    lstBox.setText(FixtId);
    errorText.setText("");
    }catch (Exception e){

        errorText.setText("Make sure that the ID is a number ex: 0,1,2");

    }



    }
    //method for adding the fixtures
    /**
     *
     * Method for adding fixtures to the fixtures table.
     * @author Bartlomiej Klich
     * @version
     *
     */
    public void AddFixtures(ActionEvent event) throws IOException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate selectedDate = fixtureDateInput1.getValue();
        String DateValues = selectedDate.format(formatter);

        try {


            Fixture fixture = new Fixture(Integer.parseInt(fixtureTeamIdInput.getText()),1,Integer.parseInt(fixtureTimelimitInput.getText()),String.valueOf(fixturePlayingFieldInput.getText()),DateValues,String.valueOf(fixtureSkillsInput.getText()));
            System.out.println(fixture);
            databaseController.AddFixture(fixture);
            AddFixturePane.setVisible(false);
            errorText.setText("");
        }
        catch (Exception e){
            errorText.setText(e.getMessage());
        }

    }
    //method for viewing the members
    /**
     *
     * Method for viewing members.
     * @author Bartlomiej Klich
     * @version
     *
     */
    public void ViewMembers(ActionEvent event) throws IOException {

        try {

            String MemberIdtext = String.valueOf(databaseController.ViewMember(Integer.parseInt(playerID1.getText())));
            System.out.println(MemberIdtext);
            lstBox.setText(MemberIdtext);
            errorText.setText("");

        }catch (Exception e){

            errorText.setText("Make sure that the ID is a number ex: 0,1,2");

        }
    }
    //method for removing the fixtures
    /**
     *
     * Method for removing fixtures from the fixtures table.
     * @author Bartlomiej Klich
     * @version
     *
     */
    public void RemoveFixture(ActionEvent event) throws IOException {
        try{
            databaseController.DeleteFixture(Integer.parseInt(removeFixtureInput.getText()));
            RemoveFixturePane.setVisible(false);
            errorText.setText("");

        }catch (Exception e){

            errorText.setText("Make sure that the ID is a number ex: 0,1,2");

        }
    }




}
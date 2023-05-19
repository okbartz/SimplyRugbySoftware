package com.example.simplyrugbysoftware;
/*

07/05/2023
Simply Rugby Software
Bartlomiej Klich

*/
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 * Coach Player controller class, the class that controls the CoachPlayerMenu scene.
 * @author Bartlomiej Klich
 * @version
 *
 *
 */
public class CoachPlayerMenuController {
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
    private Pane AddPlayerPane;
    @FXML
    private Pane ViewPlayerPane1;
    @FXML
    private Pane EditPlayerPane;
    @FXML
    private Pane RemovePlayerPane;
    @FXML
    private PieChart PlayerDataPie;




    //Remove Player Variables
    @FXML
    private TextField RemovePlayerInput;


    //View Player Variables
    @FXML
    private TextField ViewPlayerInput;

// Adding Players variables


    @FXML private TextField InputFieldPosition;
    @FXML private TextField InputMemberID;
    @FXML private TextField InputTeamID;






    // Editing Players variables

    @FXML private TextField InputFieldPosition1;
    @FXML private TextField InputMemberID1;
    @FXML private TextField InputTeamID1;
    @FXML private TextField InputPassing;
    @FXML private TextField InputCatching;
    @FXML private TextField InputRunning;
    @FXML private TextField InputTackling;
    @FXML private TextField InputRucking;
    @FXML private TextField InputConsent;




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

    }

//methods for opening the different panes
    /**
     *
     * Method for opening the view player pane(making the view player pane visible and the other panes to invisible).
     * @author Bartlomiej Klich
     * @version
     */
    public void openViewPlayer(ActionEvent event) throws IOException {
        AddPlayerPane.setVisible(false);
        ViewPlayerPane1.setVisible(true);

        EditPlayerPane.setVisible(false);
    }
    /**
     *
     * Method for opening the add player pane(making the add player pane visible and the other panes to invisible).
     * @author Bartlomiej Klich
     * @version
     */
    public void openAddPlayer(ActionEvent event) throws IOException {
        AddPlayerPane.setVisible(true);
        ViewPlayerPane1.setVisible(false);

        EditPlayerPane.setVisible(false);

    }
    /**
     *
     * Method for opening the edit player pane(making the edit player pane visible and the other panes to invisible).
     * @author Bartlomiej Klich
     * @version
     */
    public void openEditPlayer(ActionEvent event) throws IOException {
        AddPlayerPane.setVisible(false);
        ViewPlayerPane1.setVisible(false);

        EditPlayerPane.setVisible(true);

    }




//method for setting the edit inputs for the edit pane
    /**
     *
     * Method for setting the edit inputs for the edit pane.
     * @author Bartlomiej Klich
     * @version
     */
    public void SetEditInputs(KeyEvent event) throws IOException {

        System.out.println("inputing the Players details");

        try {

            if (InputMemberID1.getText() != "") {

                Player player = new Player();

                try {
                    player = (databaseController.ViewPlayer(Integer.parseInt(InputMemberID1.getText())));
                } catch (Exception e){
                    System.out.println("the entry was invalid");
                }


                InputFieldPosition1.setText(player.getFieldPosition());

                InputTeamID1.setText(String.valueOf(player.getTeamID()));
                InputPassing.setText(String.valueOf(player.getPassing()));
                InputCatching.setText(String.valueOf(player.getCatching()));
                InputRunning.setText(String.valueOf(player.getRunning()));
                InputTackling.setText(String.valueOf(player.getTackling()));
                InputRucking.setText(String.valueOf(player.getRucking()));
                InputConsent.setText(String.valueOf(player.getConsent()));


            } else {

                InputFieldPosition1.setText("");

                InputTeamID1.setText("");
                InputPassing.setText("");
                InputCatching.setText("");
                InputRunning.setText("");
                InputTackling.setText("");
                InputRucking.setText("");
                InputConsent.setText("");

            }

        } catch (NumberFormatException e) {

            throw new RuntimeException(e);

        }


    }

//method for adding players
    /**
     *
     * Method for adding players to the player table.
     * @author Bartlomiej Klich
     * @version
     */
    public void AddPlayer(ActionEvent event) throws IOException {

        try {

            Player Player = new Player(String.valueOf(InputFieldPosition.getText()), Integer.parseInt(InputMemberID.getText()), Integer.parseInt(InputTeamID.getText()),0,0,0,0,0,false);

            System.out.println(Player);
            databaseController.AddPlayer(Player);
            AddPlayerPane.setVisible(false);
        }catch (Exception e){

            errorText.setText(e.getMessage());

        }


    }
    //method for editing players
    /**
     *
     * Method for editing players from the player table.
     * @author Bartlomiej Klich
     * @version
     */
    public void EditPlayer(ActionEvent event) throws IOException {

        try {



            Player Player = new Player(String.valueOf(InputFieldPosition1.getText()), Integer.parseInt(InputMemberID1.getText()), Integer.parseInt(InputTeamID1.getText()),Integer.parseInt(InputPassing.getText()),Integer.parseInt(InputCatching.getText()),Integer.parseInt(InputRunning.getText()),Integer.parseInt(InputTackling.getText()),Integer.parseInt(InputRucking.getText()),false);

            System.out.println(Player);
            databaseController.EditPlayer(Integer.parseInt(InputMemberID1.getText()), Player);
            EditPlayerPane.setVisible(false);
            errorText.setText("");
        }catch (Exception e){

        errorText.setText(e.getMessage());

        }

    }
    //method for viewing players
    /**
     *
     * Method for viewing players from the player table.
     * @author Bartlomiej Klich
     * @version
     */
    public void ViewPlayers(ActionEvent event) throws IOException {

        try{

        Player crnPly = (databaseController.ViewPlayer(Integer.parseInt(ViewPlayerInput.getText())));



        ObservableList<PieChart.Data> PlayerpieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Passing" + " [" + crnPly.getPassing() + "]" , crnPly.getPassing()),
                        new PieChart.Data("Catching" + " [" + crnPly.getCatching() + "]" , crnPly.getCatching()),
                        new PieChart.Data("Running" + " [" + crnPly.getRunning() + "]" , crnPly.getRunning()),
                        new PieChart.Data("Tackling" + " [" + crnPly.getTackling() + "]" , crnPly.getTackling()),
                        new PieChart.Data("Rucking" + " [" + crnPly.getRucking() + "]" , crnPly.getRucking()));

        final PieChart chart = new PieChart(PlayerpieChartData);


        PlayerDataPie.setData(PlayerpieChartData);


        PlayerDataPie.setTitle("Player Skills");
        PlayerDataPie.setLegendVisible(false);


            String MemberIdtext = String.valueOf(crnPly);
            System.out.println(MemberIdtext);
            lstBox.setText(MemberIdtext);
            errorText.setText("");

        }catch (Exception e){

        errorText.setText("Make sure that the ID is a number ex: 0,1,2");

        }

    }
    //method for viewing all players
    /**
     *
     * Method for viewing all players from the player table.
     * @author Bartlomiej Klich
     * @version
     */
    public void ViewAll(ActionEvent event) throws IOException {


        try{
            String AllText = String.valueOf(databaseController.ViewAllPlayers());
            System.out.println(AllText);
            lstBox.setText(AllText);
            errorText.setText("");

            AddPlayerPane.setVisible(false);
            ViewPlayerPane1.setVisible(false);
            EditPlayerPane.setVisible(false);

        }catch (Exception e){

            errorText.setText("There is no players");

        }


    }






}
package com.example.simplyrugbysoftware;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Camera;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.Chart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CoachPlayerMenuController {
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

// Adding Players


    @FXML private TextField InputFieldPosition;
    @FXML private TextField InputMemberID;
    @FXML private TextField InputTeamID;





    // >>>

    // Editing Players

    @FXML private TextField InputFieldPosition1;
    @FXML private TextField InputMemberID1;
    @FXML private TextField InputTeamID1;
    @FXML private TextField InputPassing;
    @FXML private TextField InputCatching;
    @FXML private TextField InputRunning;
    @FXML private TextField InputTackling;
    @FXML private TextField InputRucking;
    @FXML private TextField InputConsent;


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

    }


    public void openViewPlayer(ActionEvent event) throws IOException {
        AddPlayerPane.setVisible(false);
        ViewPlayerPane1.setVisible(true);

        EditPlayerPane.setVisible(false);
    }
    public void openAddPlayer(ActionEvent event) throws IOException {
        AddPlayerPane.setVisible(true);
        ViewPlayerPane1.setVisible(false);

        EditPlayerPane.setVisible(false);

    }
    public void openEditPlayer(ActionEvent event) throws IOException {
        AddPlayerPane.setVisible(false);
        ViewPlayerPane1.setVisible(false);

        EditPlayerPane.setVisible(true);

    }
    public void openRemovePlayer(ActionEvent event) throws IOException {
        AddPlayerPane.setVisible(false);
        ViewPlayerPane1.setVisible(false);

        EditPlayerPane.setVisible(false);

    }




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
    public void ViewMembers(ActionEvent event) throws IOException {

        try{

        Player crnPly = (databaseController.ViewPlayer(Integer.parseInt(ViewPlayerInput.getText())));

// This is pretty cool

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

    public void ViewAll(ActionEvent event) throws IOException {


        try{
            String AllText = String.valueOf(databaseController.ViewAllPlayers());
            System.out.println(AllText);
            lstBox.setText(AllText);
            errorText.setText("");

        }catch (Exception e){

            errorText.setText("There is no players");

        }


    }






}
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

public class CoachCoachMenuController {
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
    private Pane AddCoachPane;
    @FXML
    private Pane ViewCoachPane1;
    @FXML
    private Pane EditCoachPane;
    @FXML
    private Pane RemoveCoachPane;



    //Remove Member Variables
    @FXML
    private TextField RemoveCoachInput;


    //View Member Variables
    @FXML
    private TextField ViewCoachInput;

// Adding Members


    @FXML private TextField InputMemberID;
    @FXML private TextField InputTeamAssigned;
    @FXML private TextField InputCoachID;


    // >>>

    // Editing Members

    @FXML private TextField InputMemberID1;
    @FXML private TextField InputTeamAssigned1;
    @FXML private TextField InputCoachID1;


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


    public void openViewCoach(ActionEvent event) throws IOException {
        AddCoachPane.setVisible(false);
        ViewCoachPane1.setVisible(true);
//        RemoveCoachPane.setVisible(false);
        EditCoachPane.setVisible(false);
    }
    public void openAddCoach(ActionEvent event) throws IOException {
        AddCoachPane.setVisible(true);
        ViewCoachPane1.setVisible(false);
//        RemoveCoachPane.setVisible(false);
        EditCoachPane.setVisible(false);

    }
    public void openEditCoach(ActionEvent event) throws IOException {
        AddCoachPane.setVisible(false);
        ViewCoachPane1.setVisible(false);
//        RemoveCoachPane.setVisible(false);
        EditCoachPane.setVisible(true);


    }
    public void openRemoveCoach(ActionEvent event) throws IOException {
        AddCoachPane.setVisible(false);
        ViewCoachPane1.setVisible(false);
        RemoveCoachPane.setVisible(true);
        EditCoachPane.setVisible(false);


    }




    public void SetEditInputs(KeyEvent event) throws IOException {

        System.out.println("inputing the members details");

        try {

            if (InputMemberID1.getText() != "") {

                Coach coach = new Coach();

                try {
                    coach = (databaseController.ViewCoach(Integer.parseInt(InputMemberID1.getText())));
                } catch (Exception e){
                    System.out.println("the entry was invalid");
                }



                InputTeamAssigned1.setText(String.valueOf(coach.getTeamAssigned()));
                InputCoachID1.setText(String.valueOf(coach.getCoachID()));
            } else {

                InputTeamAssigned1.setText("");
                InputCoachID1.setText("");
            }

        } catch (NumberFormatException e) {

            throw new RuntimeException(e);

        }


    }

    public void ViewAll(ActionEvent event) throws IOException {


            try{
                String AllText = String.valueOf(databaseController.ViewAllCoaches());
                System.out.println(AllText);
                lstBox.setText(AllText);
                errorText.setText("");

            }catch (Exception e){

                errorText.setText("There is no coaches");

            }


    }



    public void AddCoach(ActionEvent event) throws IOException {

        try {




            Coach coach = new Coach(Integer.parseInt(String.valueOf(InputMemberID.getText())),Integer.parseInt(String.valueOf(InputTeamAssigned.getText())),1);
            System.out.println(coach);
            databaseController.AddCoach(coach);
            AddCoachPane.setVisible(false);
            errorText.setText("");
        }catch (Exception e){

            errorText.setText(e.getMessage());

        }


    }
    public void EditCoach(ActionEvent event) throws IOException {

        try {

            Coach coach = new Coach(Integer.parseInt(String.valueOf(InputMemberID1.getText())),Integer.parseInt(String.valueOf(InputTeamAssigned1.getText())),Integer.parseInt(String.valueOf(InputCoachID1.getText())));
            System.out.println(coach);
            databaseController.EditCoach(Integer.parseInt(InputMemberID1.getText()), coach);
            EditCoachPane.setVisible(false);
            errorText.setText("");
        }catch (Exception e){

        errorText.setText(e.getMessage());

        }

    }
    public void ViewCoach(ActionEvent event) throws IOException {

        try{
        String CoachIdtext = String.valueOf(databaseController.ViewCoach(Integer.parseInt(ViewCoachInput.getText())));
        System.out.println(CoachIdtext);
        lstBox.setText(CoachIdtext);
        errorText.setText("");

        }catch (Exception e){

        errorText.setText("Make sure that the ID is a number ex: 0,1,2");

        }

    }








}
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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 * CoachCoachMenuController class, the class that is used to interact with the coach database table.
 * @author Bartlomiej Klich
 * @version
 *
 */
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



    //Remove Coach Variables
    @FXML
    private TextField RemoveCoachInput;


    //View Coach Variables
    @FXML
    private TextField ViewCoachInput;

// Adding Coaches variables


    @FXML private TextField InputMemberID;
    @FXML private TextField InputTeamAssigned;
    @FXML private TextField InputCoachID;




    // Editing Coaches variables

    @FXML private TextField InputMemberID1;
    @FXML private TextField InputTeamAssigned1;
    @FXML private TextField InputCoachID1;




//initialize databasecontroller
    DatabaseController databaseController = new DatabaseController();

// method for switching scenes to the coach choice menu
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

//methods for opening different panes
    /**
     *
     * Method for opening the view coach pane(making the view coach pane visible and the other panes to invisible).
     * @author Bartlomiej Klich
     * @version
     */
    public void openViewCoach(ActionEvent event) throws IOException {
        AddCoachPane.setVisible(false);
        ViewCoachPane1.setVisible(true);
//        RemoveCoachPane.setVisible(false);
        EditCoachPane.setVisible(false);
    }
    /**
     *
     * Method for opening the add coach pane(making the add coach pane visible and the other panes to invisible).
     * @author Bartlomiej Klich
     * @version
     */
    public void openAddCoach(ActionEvent event) throws IOException {
        AddCoachPane.setVisible(true);
        ViewCoachPane1.setVisible(false);
//        RemoveCoachPane.setVisible(false);
        EditCoachPane.setVisible(false);

    }
    /**
     *
     * Method for opening the edit coach pane(making the edit coach pane visible and the other panes to invisible).
     * @author Bartlomiej Klich
     * @version
     */
    public void openEditCoach(ActionEvent event) throws IOException {
        AddCoachPane.setVisible(false);
        ViewCoachPane1.setVisible(false);
//        RemoveCoachPane.setVisible(false);
        EditCoachPane.setVisible(true);


    }



//method for setting the inputs for the edit pane
    /**
     *
     * Method for setting the edit inputs for the edit pane.
     * @author Bartlomiej Klich
     * @version
     */
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
//method for viewing all coaches
    /**
     *
     * Method for viewing all coaches from the coaches table.
     * @author Bartlomiej Klich
     * @version
     */
    public void ViewAll(ActionEvent event) throws IOException {


            try{
                String AllText = String.valueOf(databaseController.ViewAllCoaches());
                System.out.println(AllText);
                lstBox.setText(AllText);
                errorText.setText("");

                AddCoachPane.setVisible(false);
                ViewCoachPane1.setVisible(false);
                EditCoachPane.setVisible(false);

            }catch (Exception e){

                errorText.setText("There is no coaches");

            }


    }


    //method for adding coaches
    /**
     *
     * Method for adding coaches to the coaches table.
     * @author Bartlomiej Klich
     * @version
     */
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
    //method for editing coaches
    /**
     *
     * Method for editing coaches from the coaches table.
     * @author Bartlomiej Klich
     * @version
     */
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
    //method for viewing coaches
    /**
     *
     * Method for viewing coaches from the coaches table.
     * @author Bartlomiej Klich
     * @version
     */
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
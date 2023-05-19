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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
/**
 *
 * MainController class, the class that is used to select scenes and hold the memberID.
 * @author Bartlomiej Klich
 * @version
 *
 */

public class MainController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField idField;

    @FXML
    private Text errorText;

    //initiating the database controller

    DatabaseController databaseController = new DatabaseController();

    //method for switching the scene to the coach scene
    /**
     *
     * The method that is used to switch scenes to the coach scene.
     * @author Bartlomiej Klich
     * @version
     *
     *
     */
    public void SwitchSceneCoach(ActionEvent event) throws IOException {

        DatabaseController databaseController = new DatabaseController();

        int MemberID;

        try {

            Coach coach = new Coach();
            Member member = new Member();

            try {
                coach = databaseController.ViewCoach(Integer.parseInt(idField.getText()));
            } catch (Exception e){
                errorText.setText("this member is not a coach");
            }

            try {
            member = databaseController.ViewMember(Integer.parseInt(idField.getText()));
            } catch (Exception e){
            errorText.setText("The id you entered doesnt exist");
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Coach1.fxml"));
            root = loader.load();

            CoachController coachController = loader.getController();


            if (coach.getMemberID() != 0) {
                MemberID = member.getMemberID();

                coachController.setUser(MemberID);

//        root = FXMLLoader.load(getClass().getResource("Member.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

        } catch (Exception e){

            errorText.setText("Make sure that the ID is a number ex: 0,1,2");

        }


    }
    /**
     *
     * The method that is used to switch scenes to the secretary scene.
     * @author Bartlomiej Klich
     * @version
     *
     *
     */
    //method for switching the scene to the secretary scene
    public void SwitchSceneSecretary(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FixtureSecretary.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    //method for switching the scene to the member scene
    /**
     *
     * The method that is used to switch scenes to the member scene.
     * @author Bartlomiej Klich
     * @version
     *
     *
     */
    public void SwitchSceneMember(ActionEvent event) throws IOException {

        DatabaseController databaseController = new DatabaseController();

        int MemberID;

        try {

            Member member = new Member();

            try {
                member = databaseController.ViewMember(Integer.parseInt(idField.getText()));
            }catch (Exception e){

                errorText.setText("The id you entered doesnt exist");
            }


            FXMLLoader loader = new FXMLLoader(getClass().getResource("Member.fxml"));
            root = loader.load();

            MemberController memberController = loader.getController();


            if (member.getFname() != null) {
                MemberID = member.getMemberID();

                memberController.setUser(MemberID);

//        root = FXMLLoader.load(getClass().getResource("Member.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

        }catch (Exception e){

                errorText.setText("Make sure that the ID is a number ex: 0,1,2");

            }


    }


}
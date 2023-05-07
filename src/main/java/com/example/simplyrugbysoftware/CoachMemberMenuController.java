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

public class CoachMemberMenuController {
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
    private Pane AddMemberPane;
    @FXML
    private Pane ViewMemberPane1;
    @FXML
    private Pane EditMemberPane;
    @FXML
    private Pane RemoveMemberPane;



    //Remove Member Variables
    @FXML
    private TextField RemoveMemberInput;


    //View Member Variables
    @FXML
    private TextField ViewMemberInput;

// Adding Members variables


    @FXML private TextField InputFirstName;
    @FXML private TextField InputSurname;
    @FXML private ChoiceBox InputSex;

    private String[] sexes = {"M","F"};
    @FXML private TextField InputEmail;
    @FXML private TextField InputHomeAddress;
    @FXML private DatePicker InputAge;



    // Editing Members variables


    @FXML private TextField InputFirstName1;
    @FXML private TextField InputSurname1;
    @FXML private ChoiceBox InputSex1;
    @FXML private TextField InputEmail1;
    @FXML private TextField InputHomeAddress1;
    @FXML private DatePicker InputAge1;
    @FXML private TextField InputMemberID1;



// databasecontroller initialization
    DatabaseController databaseController = new DatabaseController();

//method for switching scenes to the coach choice menu
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
    public void setUser(int UserID) {
        CurrentUserID = UserID;
        InputSex.getItems().addAll(sexes);
        InputSex1.getItems().addAll(sexes);
    }

//methods for opening the different panes
    public void openViewMember(ActionEvent event) throws IOException {
        AddMemberPane.setVisible(false);
        ViewMemberPane1.setVisible(true);
        RemoveMemberPane.setVisible(false);
        EditMemberPane.setVisible(false);
    }
    public void openAddMember(ActionEvent event) throws IOException {
        AddMemberPane.setVisible(true);
        ViewMemberPane1.setVisible(false);
        RemoveMemberPane.setVisible(false);
        EditMemberPane.setVisible(false);

    }
    public void openEditMember(ActionEvent event) throws IOException {
        AddMemberPane.setVisible(false);
        ViewMemberPane1.setVisible(false);
        RemoveMemberPane.setVisible(false);
        EditMemberPane.setVisible(true);

    }
    public void openRemoveMember(ActionEvent event) throws IOException {
        AddMemberPane.setVisible(false);
        ViewMemberPane1.setVisible(false);
        RemoveMemberPane.setVisible(true);
        EditMemberPane.setVisible(false);

    }



//method for setting the edit pane inputs
    public void SetEditInputs(KeyEvent event) throws IOException {

        System.out.println("inputing the members details");

        try {

            if (InputMemberID1.getText() != "") {

                Member member = new Member();

                try {
                    member = (databaseController.ViewMember(Integer.parseInt(InputMemberID1.getText())));
                } catch (Exception e){
                    System.out.println("the entry was invalid");
                }


                InputFirstName1.setText(member.getFname());
                InputSurname1.setText(member.getSname());
                InputSex1.setValue(member.getSex());
                InputEmail1.setText(member.getEmail());
                InputHomeAddress1.setText(member.getHomeAddress());
                InputAge1.setPromptText(member.getDob());
                errorText.setText("");
            } else {

                InputFirstName1.setText("");
                InputSurname1.setText("");
                InputSex1.setValue("");
                InputEmail1.setText("");
                InputHomeAddress1.setText("");
                InputAge1.setPromptText("");
                InputAge1.setValue(null);
                errorText.setText("");

            }

        } catch (NumberFormatException e) {

            errorText.setText(e.getMessage());
            throw new RuntimeException(e);

        }


    }

    //method for adding members
    public void AddMember(ActionEvent event) throws IOException {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate selectedDate = InputAge.getValue();
            String DateValues = selectedDate.format(formatter);


            Member member = new Member(String.valueOf(InputFirstName.getText()), String.valueOf(InputSurname.getText()), String.valueOf(InputSex.getValue()), String.valueOf(InputEmail.getText()), String.valueOf(InputHomeAddress.getText()), 0, DateValues);

            System.out.println(member);
            databaseController.AddMember(member);
            AddMemberPane.setVisible(false);

            errorText.setText("");
        }catch (Exception e){

            errorText.setText(e.getMessage());

        }


    }
    //method for editing members
    public void EditMember(ActionEvent event) throws IOException {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate selectedDate = InputAge1.getValue();
            String DateValues = selectedDate.format(formatter);


            Member member = new Member(String.valueOf(InputFirstName1.getText()), String.valueOf(InputSurname1.getText()), String.valueOf(InputSex1.getValue()), String.valueOf(InputEmail1.getText()), String.valueOf(InputHomeAddress1.getText()), 0, DateValues);
            System.out.println(member);
            databaseController.EditMember(Integer.parseInt(InputMemberID1.getText()), member);
            EditMemberPane.setVisible(false);
            errorText.setText("");
        }catch (Exception e){

        errorText.setText(e.getMessage());

        }

    }
    //method for viewing all members
    public void ViewAll(ActionEvent event) throws IOException {


        try{
            String AllText = String.valueOf(databaseController.ViewAllMembers());
            System.out.println(AllText);
            lstBox.setText(AllText);
            errorText.setText("");

        }catch (Exception e){

            errorText.setText("There is no members");

        }


    }

    //method for viewing members
    public void ViewMembers(ActionEvent event) throws IOException {

        try{
        String MemberIdtext = String.valueOf(databaseController.ViewMember(Integer.parseInt(ViewMemberInput.getText())));
        System.out.println(MemberIdtext);
        lstBox.setText(MemberIdtext);
        errorText.setText("");

        }catch (Exception e){

        errorText.setText("Make sure that the ID is a number ex: 0,1,2");

        }

    }
    //method for removing members
    public void RemoveMembers(ActionEvent event) throws IOException {
        try{
        databaseController.RemoveMember(Integer.parseInt(RemoveMemberInput.getText()));
        RemoveMemberPane.setVisible(false);
        errorText.setText("");

        }catch (Exception e){

        errorText.setText("Make sure that the ID is a number ex: 0,1,2");

        }
    }






}
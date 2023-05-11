package com.example.simplyrugbysoftware;

/*

07/05/2023
Simply Rugby Software
Bartlomiej Klich

*/

public class Player {

    // player variables
    private String FieldPosition;
    static int NextID = 0;
    private int MemberID;
    private int TeamID;
    private int Passing;
    private int Catching;
    private int Running;
    private int Tackling;
    private int Rucking;
    private Boolean Consent;

    //player constructor
    public Player(String fieldPosition, int memberID, int teamID, int passing, int catching, int running, int tackling, int rucking, Boolean consent) {

        try{
        setFieldPosition(fieldPosition);
        setMemberID(memberID);
        setTeamID(teamID);
        setPassing(passing);
        setCatching(catching);
        setRunning(running);
        setTackling(tackling);
        setRucking(rucking);
        setConsent(consent);
        }
        catch (Exception e) {
        throw new RuntimeException(e);
        }

    }

    //empty player constructor
    public Player() {

    }



    //empty getters and setters
    public String getFieldPosition() {
        return FieldPosition;
    }

    public void setFieldPosition(String fieldPosition) throws Exception {

        try {

            fieldPosition.toUpperCase();
            if (fieldPosition.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")){
                FieldPosition = fieldPosition;} else {throw new Exception();}
        }catch (Exception e){

            throw new Exception("the Field Position can only be letters!!");
        }


    }

    public int getMemberID() {
        return MemberID;
    }

    public void setMemberID(int memberID) throws Exception{
        try {
            if (memberID >= 0){
                MemberID = memberID;
            } else {

                throw new Exception();
            }
        }catch (Exception e){

            throw new Exception("the member id cannot be less than 1");
        }
    }

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) throws Exception {
        try {
            if (teamID > 0){
                TeamID = teamID;
            } else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception("the team id cannot be less than 1");
        }

    }


    public int getPassing() {
        return Passing;
    }

    public void setPassing(int passing)throws Exception {


        try {
            if (passing <= 20 && passing >= 0){
                Passing = passing;
            } else {

                throw new Exception();
            }
        }catch (Exception e){

            throw new Exception("the skill cannot be less than 0 and greater than 20");
        }


    }

    public int getCatching() {
        return Catching;
    }

    public void setCatching(int catching)throws Exception {

        try {
            if (catching <= 20 && catching >= 0){
                Catching = catching;
            } else {

                throw new Exception();
            }
        }catch (Exception e){

            throw new Exception("the skill cannot be less than 0 and greater than 20");
        }


    }

    public int getRunning() {
        return Running;
    }

    public void setRunning(int running)throws Exception {

        try {
            if (running <= 20 && running >= 0){
                Running = running;
            } else {

                throw new Exception();
            }
        }catch (Exception e){

            throw new Exception("the skill cannot be less than 0 and greater than 20");
        }


    }

    public int getTackling() {
        return Tackling;
    }

    public void setTackling(int tackling) throws Exception{

        try {
            if (tackling <= 20 && tackling >= 0){
                Tackling = tackling;
            } else {

                throw new Exception();
            }
        }catch (Exception e){

            throw new Exception("the skill cannot be less than 0 and greater than 20");
        }


    }

    public int getRucking() {
        return Rucking;
    }

    public void setRucking(int rucking) throws Exception{

        try {
            if (rucking <= 20 && rucking >= 0){
                Rucking = rucking;
            } else {

                throw new Exception();
            }
        }catch (Exception e){

            throw new Exception("the skill cannot be less than 0 and greater than 20");
        }

    }

    public Boolean getConsent() {
        return Consent;
    }

    public void setConsent(Boolean consent){

        Consent = consent;


    }

    // tostring method
    @Override
    public String toString() {
        return "Player{" +
                "FieldPosition='" + FieldPosition + '\'' +
                ", MemberID=" + MemberID +
                ", TeamID=" + TeamID +
                ", Passing=" + Passing +
                ", Catching=" + Catching +
                ", Running=" + Running +
                ", Tackling=" + Tackling +
                ", Rucking=" + Rucking +
                ", Consent=" + Consent +
                '}';
    }
}




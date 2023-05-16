package com.example.simplyrugbysoftware;

/**
 *
 * Player class, the class that holds player details.
 * @author Bartlomiej Klich
 * @version
 *
 *
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
    /**
     *
     * Player constructor ensures that all the details are validated through the use of setters.
     * @author Bartlomiej Klich
     * @version
     * @param fieldPosition the variable used for holding the field position of the player.
     * @param memberID the variable used for holding the member id of the player.
     * @param teamID the variable used for holding the team id of the player.
     * @param passing the variable used for holding the passing skill of the player.
     * @param catching the variable used for holding the catching skill of the player.
     * @param running the variable used for holding the running skill of the player.
     * @param tackling the variable used for holding the tackling skill of the player.
     * @param rucking the variable used for holding the rucking skill of the player.
     * @param consent the variable used for holding the consent value of the player.
     *
     */
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
    /**
     *
     * Empty Player constructor.
     * @author Bartlomiej Klich
     * @version
     *
     */
    public Player() {

    }



    //getters and setters
    /**
     *
     * Method for getting the fieldPosition.
     * @author Bartlomiej Klich
     * @version
     * @return FieldPosition the variable used for holding the field position of the player.
     */
    public String getFieldPosition() {
        return FieldPosition;
    }
    /**
     *
     * Method for setting the fieldPosition.
     * @author Bartlomiej Klich
     * @version
     * @param fieldPosition the variable used for holding the field position of the player.
     */
    public void setFieldPosition(String fieldPosition) throws Exception {

        try {

            fieldPosition.toUpperCase();
            if (fieldPosition.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")){
                FieldPosition = fieldPosition;} else {throw new Exception();}
        }catch (Exception e){

            throw new Exception("the Field Position can only be letters!!");
        }


    }
    /**
     *
     * Method for getting the memberID.
     * @author Bartlomiej Klich
     * @version
     * @return MemberID the variable used for holding the member id of the player.
     */
    public int getMemberID() {
        return MemberID;
    }
    /**
     *
     * Method for setting the memberID.
     * @author Bartlomiej Klich
     * @version
     * @param memberID the variable used for holding the member id of the player.
     */
    public void setMemberID(int memberID) throws Exception{
        try {
            if (memberID >= 0){
                MemberID = memberID;
            } else {

                throw new Exception();
            }
        }catch (Exception e){

            throw new Exception("the member id cannot be less than 0");
        }
    }
    /**
     *
     * Method for getting the teamID.
     * @author Bartlomiej Klich
     * @version
     * @return TeamID the variable used for holding the team id of the player.
     */
    public int getTeamID() {
        return TeamID;
    }
    /**
     *
     * Method for setting the teamID.
     * @author Bartlomiej Klich
     * @version
     * @param teamID the variable used for holding the team id of the player.
     */
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
    /**
     *
     * Method for getting the passing skill of the player.
     * @author Bartlomiej Klich
     * @version
     * @return Passing the variable used for holding the passing skill of the player.
     */

    public int getPassing() {
        return Passing;
    }
    /**
     *
     * Method for setting the passing skill of the player.
     * @author Bartlomiej Klich
     * @version
     * @param passing the variable used for holding the passing skill of the player.
     */
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
    /**
     *
     * Method for setting the catching skill of the player.
     * @author Bartlomiej Klich
     * @version
     * @return Catching the variable used for holding the catching skill of the player.
     */
    public int getCatching() {
        return Catching;
    }
    /**
     *
     * Method for setting the catching skill of the player.
     * @author Bartlomiej Klich
     * @version
     * @param catching the variable used for holding the catching skill of the player.
     */
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
    /**
     *
     * Method for getting the running skill of the player.
     * @author Bartlomiej Klich
     * @version
     * @return Running the variable used for holding the running skill of the player.
     */
    public int getRunning() {
        return Running;
    }
    /**
     *
     * Method for setting the running skill of the player.
     * @author Bartlomiej Klich
     * @version
     * @param running the variable used for holding the running skill of the player.
     */
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
    /**
     *
     * Method for setting the tackling skill of the player.
     * @author Bartlomiej Klich
     * @version
     * @return Tackling the variable used for holding the tackling skill of the player.
     */
    public int getTackling() {
        return Tackling;
    }
    /**
     *
     * Method for setting the tackling skill of the player.
     * @author Bartlomiej Klich
     * @version
     * @param tackling the variable used for holding the tackling skill of the player.
     */
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
    /**
     *
     * Method for getting the rucking skill of the player.
     * @author Bartlomiej Klich
     * @version
     * @return Rucking the variable used for holding the rucking skill of the player.
     */
    public int getRucking() {
        return Rucking;
    }
    /**
     *
     * Method for setting the rucking skill of the player.
     * @author Bartlomiej Klich
     * @version
     * @param rucking the variable used for holding the rucking skill of the player.
     */
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
    /**
     *
     * Method for getting the consent value of the player.
     * @author Bartlomiej Klich
     * @version
     * @return Consent the variable used for holding the consent value of the player.
     */
    public Boolean getConsent() {
        return Consent;
    }
    /**
     *
     * Method for setting the consent value of the player.
     * @author Bartlomiej Klich
     * @version
     * @param consent the variable used for holding the consent value of the player.
     */
    public void setConsent(Boolean consent){

        Consent = consent;


    }

    // tostring method
    /**
     *
     * Method for converting the player to a string to be displayed.
     * @author Bartlomiej Klich
     * @version
     * @return toString string.
     */
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




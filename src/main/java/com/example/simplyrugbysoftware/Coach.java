package com.example.simplyrugbysoftware;
/**
 *
 * Coach class, the class that holds coach details.
 * @author Bartlomiej Klich
 * @version
 *
 *
 */

public class Coach {

    //variables for coach
    static int NextID = 0;
    private int MemberID;
    private int TeamAssigned;
    private int CoachID;

    //coach constructor
    /**
     *
     * Coach constructor ensures that all the details are validated through the use of setters.
     * @author Bartlomiej Klich
     * @version
     * @param memberID the variable used for holding the member id of the coach.
     * @param teamAssigned the variable used for holding the team assigned to the coach.
     * @param coachID the variable used for holding coach id.
     *
     */
    public Coach(int memberID, int teamAssigned, int coachID) {
        try{
            setMemberID(memberID);
            setTeamAssigned(teamAssigned);
            setCoachID(coachID);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //empty coach constructor
    /**
     *
     * Empty Coach constructor.
     * @author Bartlomiej Klich
     * @version
     *
     */
    public Coach() {

    }

    /**
     *
     * Method for getting the member id.
     * @author Bartlomiej Klich
     * @version
     * @return MemberID the variable used for holding the member id of the coach.
     *
     *
     */
    //getters and setters
    public int getMemberID() {
        return MemberID;
    }
    /**
     *
     * Method for setting the member id.
     * @author Bartlomiej Klich
     * @version
     * @param memberID the variable used for holding the member id of the coach.
     *
     *
     */
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
    /**
     *
     * Method for getting the team assigned to the coach.
     * @author Bartlomiej Klich
     * @version
     * @return TeamAssigned the variable used for holding the team assigned to the coach.
     *
     *
     */
    public int getTeamAssigned() {
        return TeamAssigned;
    }
    /**
     *
     * Method for setting the team assigned to the coach.
     * @author Bartlomiej Klich
     * @version
     * @param teamAssigned the variable used for holding the team assigned to the coach.
     *
     */
    public void setTeamAssigned(int teamAssigned) throws Exception{


        try {
            if (teamAssigned > 0){
                TeamAssigned = teamAssigned;
            } else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception("the team id cannot be less than 1");
        }

    }
    /**
     *
     * Method for getting the variable used for holding coach id.
     * @author Bartlomiej Klich
     * @version
     * @return CoachID the variable used for holding coach id.
     *
     *
     */
    public int getCoachID() {
        return CoachID;
    }
    /**
     *
     * Method for setting the variable used for holding coach id.
     * @author Bartlomiej Klich
     * @version
     * @param coachID the variable used for holding coach id.
     *
     *
     */
    public void setCoachID(int coachID) throws Exception{

        try {
            if (coachID >= 0){
                CoachID = coachID;
            } else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception("the coach id cannot be less than 1");
        }
    }

    //tostring method
    /**
     *
     * Method for converting the coach to a string to be displayed.
     * @author Bartlomiej Klich
     * @version
     * @return toString string.
     */
    @Override
    public String toString() {
        return "Coach{" +
                "MemberID=" + MemberID +
                ", TeamAssigned=" + TeamAssigned +
                ", CoachID=" + CoachID +
                '}';
    }
}

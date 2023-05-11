package com.example.simplyrugbysoftware;
/**
 *
 * Squad class, the class that holds squad details.
 * @author Bartlomiej Klich
 * @version
 *
 *
 */

public class Squad {

    //variables
    static int NextID = 0;
    private int TeamID;
    private String AgeGrade;

    //squad constructor
    /**
     *
     * Squad constructor ensures that all the details are validated through the use of setters.
     * @author Bartlomiej Klich
     * @version
     * @param teamID the variable used for holding the team id of the squad.
     * @param ageGrade the variable used for the agegrade of the squad.
     *
     *
     */
    public Squad(int teamID, String ageGrade) {
       try{
           setTeamID(teamID);
           setAgeGrade(ageGrade);
       }
       catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    //empty squad constructor
    /**
     *
     * Empty Squad constructor.
     * @author Bartlomiej Klich
     * @version
     *
     */
    public Squad() {

    }


    //getters and setters
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
    public void setTeamID(int teamID) throws Exception{
        try {
            if (teamID >= 0){
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
     * Method for getting the agegrade.
     * @author Bartlomiej Klich
     * @version
     * @return AgeGrade the variable used for the agegrade of the squad.
     */
    public String getAgeGrade() {
        return AgeGrade;
    }
    /**
     *
     * Method for setting the agegrade.
     * @author Bartlomiej Klich
     * @version
     * @param ageGrade the variable used for the agegrade of the squad.
     */
    public void setAgeGrade(String ageGrade) {




        AgeGrade = ageGrade;
    }

    //tostring method
    /**
     *
     * Method for converting the Squad to a string to be displayed.
     * @author Bartlomiej Klich
     * @version
     * @return toString string.
     */
    @Override
    public String toString() {
        return "Squad{" +
                "TeamID=" + TeamID +
                ", AgeGrade='" + AgeGrade + '\'' +
                '}';
    }
}



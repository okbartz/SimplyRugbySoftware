package com.example.simplyrugbysoftware;

/**
 *
 * Session class, the class that holds session details.
 * @author Bartlomiej Klich
 * @version
 *
 *
 */

public class Session {

    //date regex
    private String DateRegex = ("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");

    //session variables
    private int TeamID;
    private int SessionID;
    private int TimeLimit;
    private String Date;
    private String Activity;
    static int NextID = 0;

    // Constructor for session
    /**
     *
     * Session constructor ensures that all the details are validated through the use of setters.
     * @author Bartlomiej Klich
     * @version
     * @param teamID the variable used for holding the team id.
     * @param sessionID the variable used for holding the session id.
     * @param timeLimit the variable used for holding the time limit of the session.
     * @param date the variable used for holding the date of the session.
     * @param activity the variable used for holding the activity performed during the session.
     *
     *
     */
    public Session(int teamID, int sessionID, int timeLimit, String date, String activity) {
        try{
        setTeamID(teamID);
        setSessionID(sessionID);
        setTimeLimit(timeLimit);
        setDate(date);
        setActivity(activity);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //getters and setters
    /**
     *
     * Method for getting the team id.
     * @author Bartlomiej Klich
     * @version
     * @return TeamID the variable used for holding the team id.
     *
     *
     */
    public int getTeamID() {
        return TeamID;
    }
    /**
     *
     * Method for setting the team id.
     * @author Bartlomiej Klich
     * @version
     * @param teamID the variable used for holding the team id.
     *
     *
     */
    public void setTeamID(int teamID) throws Exception{

        try {
            if (teamID > 0) {
                TeamID = teamID;
            } else {throw new Exception(); }
        }catch (Exception e){
            throw new Exception("the team id was not valid!");
        }


    }
    /**
     *
     * Method for getting the session id.
     * @author Bartlomiej Klich
     * @version
     * @return SessionID the variable used for holding the session id.
     *
     *
     */
    public int getSessionID() {
        return SessionID;
    }
    /**
     *
     * Method for setting the session id.
     * @author Bartlomiej Klich
     * @version
     * @param sessionID the variable used for holding the session id.
     *
     *
     */
    public void setSessionID(int sessionID) throws Exception{


        try {
            if (sessionID > 0) {
                SessionID = sessionID;
            } else {throw new Exception(); }
        }catch (Exception e){
            throw new Exception("the session id was not valid!");
        }


    }
    /**
     *
     * Method for getting the time limit of the session.
     * @author Bartlomiej Klich
     * @version
     * @return TimeLimit the variable used for the time limit of the session.
     *
     *
     */
    public int getTimeLimit() {
        return TimeLimit;
    }
    /**
     *
     * Method for setting the time limit of the session.
     * @author Bartlomiej Klich
     * @version
     * @param timeLimit the variable used for the time limit of the session.
     *
     *
     */
    public void setTimeLimit(int timeLimit) throws Exception{

        try {

            if (timeLimit <= 120 && timeLimit >= 30){
                TimeLimit = timeLimit;
            }
            else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception("the time limit is between 30 to 120");
        }


    }
    /**
     *
     * Method for getting the date of the session.
     * @author Bartlomiej Klich
     * @version
     * @return Date the variable used for holding the date of the session.
     *
     *
     */
    public String getDate() {
        return Date;
    }
    /**
     *
     * Method for setting the date of the session.
     * @author Bartlomiej Klich
     * @version
     * @param date the variable used for holding the date of the session.
     *
     *
     */
    public void setDate(String date) throws Exception{

        try {

            if (date.matches(DateRegex)){
                Date = date;} else{ new Exception();}
        }catch (Exception e){
            throw new Exception("the date is formatted incorrectly");
        }

    }
    /**
     *
     * Method for getting the activity performed during the session.
     * @author Bartlomiej Klich
     * @version
     * @return Activity the variable used for holding the activity performed during the session.
     *
     *
     */
    public String getActivity() {
        return Activity;
    }
    /**
     *
     * Method for setting the activity performed during the session.
     * @author Bartlomiej Klich
     * @version
     * @param activity the variable used for holding the activity performed during the session.
     *
     *
     */
    public void setActivity(String activity) throws Exception{


        try {

            activity.toUpperCase();
            if (activity.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")){
                Activity = activity;} else {throw new Exception();}
        }catch (Exception e){

            throw new Exception("the activity field has to be only letters");
        }
    }

    //tostring method
    /**
     *
     * Method for converting the session to a string to be displayed.
     * @author Bartlomiej Klich
     * @version
     * @return toString string.
     */
    @Override
    public String toString() {
        return "Session{" +
                "TeamID=" + TeamID +
                ", SessionID=" + SessionID +
                ", TimeLimit=" + TimeLimit +
                ", Date='" + Date + '\'' +
                ", Activity='" + Activity + '\'' +
                '}';
    }
}

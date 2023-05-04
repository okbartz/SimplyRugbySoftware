package com.example.simplyrugbysoftware;

public class Session {

    private String DateRegex = ("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");

    private int TeamID;
    private int SessionID;
    private int TimeLimit;
    private String Date;
    private String Activity;
    static int NextID = 0;

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

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) throws Exception{

        try {
            if (teamID > 0) {
                TeamID = teamID;
            } else {throw new Exception("the team id was not valid!"); }
        }catch (Exception e){
            throw new Exception("the team id was not a integer!!");
        }


    }

    public int getSessionID() {
        return SessionID;
    }

    public void setSessionID(int sessionID) throws Exception{


        try {
            if (sessionID > 0) {
                SessionID = sessionID;
            } else {throw new Exception("the session id was not valid!"); }
        }catch (Exception e){
            throw new Exception("the session id was not a integer!!");
        }


    }

    public int getTimeLimit() {
        return TimeLimit;
    }

    public void setTimeLimit(int timeLimit) throws Exception{

        try {

            if (timeLimit <= 120 && timeLimit >= 30){
                TimeLimit = timeLimit;
            }
            else {
                throw new Exception("the time limit is between 30 to 120");
            }
        }catch (Exception e){
            throw new Exception("the time was not a integer!!");
        }


    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) throws Exception{

        try {

            if (date.matches(DateRegex)){
                Date = date;} else{ new Exception("the date did not match!!");}
        }catch (Exception e){
            throw new Exception("the date field was not a string!!");
        }

    }

    public String getActivity() {
        return Activity;
    }

    public void setActivity(String activity) throws Exception{


        try {

            activity.toUpperCase();
            if (activity.matches("\\D*")){
                Activity = activity;} else {throw new Exception("the activity field did not match!!");}
        }catch (Exception e){

            throw new Exception("the Activity field was not a string!!");
        }
    }

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

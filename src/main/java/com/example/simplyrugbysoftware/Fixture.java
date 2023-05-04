package com.example.simplyrugbysoftware;

public class Fixture {


    private String DateRegex = ("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
    private int TeamID;
    private int FixtureID;
    private int TimeLimit;
    private String PlayingField;
    private String Date;
    private String Skills;
    static int NextID = 0;

    public Fixture(int teamID, int fixtureID, int timeLimit, String playingField, String date, String skills) {
        try {
        setTeamID(teamID);
        setFixtureID(fixtureID);
        setTimeLimit(timeLimit);
        setPlayingField(playingField);
        setDate(date);
        setSkills(skills);
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
            if (teamID > 0){
            TeamID = teamID;
            } else {
                throw new Exception("the id cannot be less than 1");
            }
        }catch (Exception e){
            throw new Exception("the team id was not a integer!!");
        }

    }

    public int getFixtureID() {
        return FixtureID;
    }

    public void setFixtureID(int fixtureID) throws Exception{
        try {
            if (fixtureID > 0) {
                FixtureID = fixtureID;
            } else { throw new Exception("the fixture id was not valid"); }
        }catch (Exception e){
            throw new Exception("the fixture id was not a integer!!");
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

    public String getPlayingField() {
        return PlayingField;
    }

    public void setPlayingField(String playingField) throws Exception{

        try {

            if (playingField.matches("\\D*")){


            PlayingField = playingField.toUpperCase();}
        }catch (Exception e){
            throw new Exception("the Playing Field was not a string!!");
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

    public String getSkills() {
        return Skills;
    }

    public void setSkills(String skills) throws Exception{
        try {

            skills.toUpperCase();
            if (skills.matches("\\D*")){
            Skills = skills;} else {throw new Exception("the activity field did not match!!");}
        }catch (Exception e){

            throw new Exception("the Skills field was not a string!!");
        }


    }


    @Override
    public String toString() {
        return "Fixture{" +
                "TeamID=" + TeamID +
                ", FixtureID=" + FixtureID +
                ", TimeLimit=" + TimeLimit +
                ", PlayingField='" + PlayingField + '\'' +
                ", Date='" + Date + '\'' +
                ", Skills='" + Skills + '\'' +
                '}';
    }
}
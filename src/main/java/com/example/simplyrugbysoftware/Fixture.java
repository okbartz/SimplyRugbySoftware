package com.example.simplyrugbysoftware;

/**
 *
 * Fixture class, the class that holds fixture details.
 * @author Bartlomiej Klich
 * @version
 *
 *
 */

public class Fixture {


    //date regex
    private String DateRegex = ("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");

    //variables for fixture
    private int TeamID;
    private int FixtureID;
    private int TimeLimit;
    private String PlayingField;
    private String Date;
    private String Skills;
    static int NextID = 0;

    //fixture constructor
    /**
     *
     * Squad constructor ensures that all the details are validated through the use of setters.
     * @author Bartlomiej Klich
     * @version
     * @param teamID the variable used for holding the team id.
     * @param fixtureID the variable used for holding the fixture id.
     * @param timeLimit the variable used for holding the time limit of the fixture.
     * @param date the variable used for holding the date of the fixture.
     * @param playingField the variable used for holding the playing field of the fixture.
     * @param skills the variable used for holding the skills performed during the fixture.
     *
     *
     */
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
     * Method for getting the fixture id.
     * @author Bartlomiej Klich
     * @version
     * @return FixtureID the variable used for holding the fixture id.
     *
     *
     */
    public int getFixtureID() {
        return FixtureID;
    }
    /**
     *
     * Method for setting the fixture id.
     * @author Bartlomiej Klich
     * @version
     * @param fixtureID the variable used for holding the fixture id.
     *
     *
     */
    public void setFixtureID(int fixtureID) throws Exception{
        try {
            if (fixtureID > 0) {
                FixtureID = fixtureID;
            } else { throw new Exception(); }
        }catch (Exception e){
            throw new Exception("the fixture id was not valid");
        }


    }
    /**
     *
     * Method for getting the time limit of the fixture.
     * @author Bartlomiej Klich
     * @version
     * @return TimeLimit the variable used for the time limit of the fixture.
     *
     *
     */
    public int getTimeLimit() {
        return TimeLimit;
    }
    /**
     *
     * Method for setting the time limit of the fixture.
     * @author Bartlomiej Klich
     * @version
     * @param timeLimit the variable used for the time limit of the fixture.
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
            throw new Exception("the time limit has to be between 30 to 120");
        }

    }
    /**
     *
     * Method for getting the playing field of the fixture.
     * @author Bartlomiej Klich
     * @version
     * @return PlayingField the variable used for the playing field of the fixture.
     *
     *
     */
    public String getPlayingField() {
        return PlayingField;
    }
    /**
     *
     * Method for setting the playing field of the fixture.
     * @author Bartlomiej Klich
     * @version
     * @param playingField the variable used for the playing field of the fixture.
     *
     *
     */
    public void setPlayingField(String playingField) throws Exception{

        try {

            if (playingField.matches("\\D*")){
            PlayingField = playingField.toUpperCase();}
            else {throw new Exception();}

        }catch (Exception e){
            throw new Exception("the Playing Field has to be only letters");
        }

    }
    /**
     *
     * Method for getting the date of the fixture.
     * @author Bartlomiej Klich
     * @version
     * @return Date the variable used for holding the date of the fixture.
     *
     *
     */
    public String getDate() {
        return Date;
    }
    /**
     *
     * Method for setting the date of the fixture.
     * @author Bartlomiej Klich
     * @version
     * @param date the variable used for holding the date of the fixture.
     *
     *
     */
    public void setDate(String date) throws Exception{

        try {

            if (date.matches(DateRegex)){
                Date = date;} else{ throw new Exception();}
        }catch (Exception e){
            throw new Exception("the date is formatted incorrectly");
        }


    }
    /**
     *
     * Method for getting the skills performed during the fixture.
     * @author Bartlomiej Klich
     * @version
     * @return Skills the variable used for holding the skills performed during the fixture.
     *
     *
     */
    public String getSkills() {
        return Skills;
    }
    /**
     *
     * Method for setting the skills performed during the fixture.
     * @author Bartlomiej Klich
     * @version
     * @param skills the variable used for holding the skills performed during the fixture.
     *
     *
     */
    public void setSkills(String skills) throws Exception{
        try {

            skills.toUpperCase();
            if (skills.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")){
            Skills = skills;} else {throw new Exception();}
        }catch (Exception e){

            throw new Exception("the skills field has to be only letters");
        }


    }

// to string method
    /**
     *
     * Method for converting the fixture to a string to be displayed.
     * @author Bartlomiej Klich
     * @version
     * @return toString string.
     */
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

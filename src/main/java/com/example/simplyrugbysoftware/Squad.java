package com.example.simplyrugbysoftware;

public class Squad {

    static int NextID = 0;
    private int TeamID;
    private String AgeGrade;

    public Squad(int teamID, String ageGrade) {
       try{
           setTeamID(teamID);
           setAgeGrade(ageGrade);
       }
       catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    public Squad() {

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

    public String getAgeGrade() {
        return AgeGrade;
    }

    public void setAgeGrade(String ageGrade) {




        AgeGrade = ageGrade;
    }

    @Override
    public String toString() {
        return "Squad{" +
                "TeamID=" + TeamID +
                ", AgeGrade='" + AgeGrade + '\'' +
                '}';
    }
}



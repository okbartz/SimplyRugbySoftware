package com.example.simplyrugbysoftware;

public class Coach {
    static int NextID = 0;
    private int MemberID;
    private int TeamAssigned;
    private int CoachID;

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

    public Coach() {

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

    public int getTeamAssigned() {
        return TeamAssigned;
    }

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

    public int getCoachID() {
        return CoachID;
    }

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

    @Override
    public String toString() {
        return "Coach{" +
                "MemberID=" + MemberID +
                ", TeamAssigned=" + TeamAssigned +
                ", CoachID=" + CoachID +
                '}';
    }
}

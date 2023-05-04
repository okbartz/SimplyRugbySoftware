package com.example.simplyrugbysoftware;

import java.sql.*;

public class DatabaseController {


//initiating the database


    public DatabaseController() {
        try{
            Class.forName("org.sqlite.JDBC").newInstance();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Member (fname VARCHAR(64), sname VARCHAR(64), sex VARCHAR(64), email VARCHAR(64), homeaddress VARCHAR(64), memberid INTEGER PRIMARY KEY AUTOINCREMENT, dob VARCHAR(64))");

            try {
                statement.executeUpdate();
                statement.close();

                PreparedStatement playerTable = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Player (fieldposition VARCHAR(64), memberid INTEGER(64), teamid INTEGER(64), passing INTEGER(64), catching INTEGER(64), running INTEGER(64), tackling INTEGER(64), rucking INTEGER(64), consent INTEGER(1))");
                playerTable.executeUpdate();
                playerTable.close();

                PreparedStatement coachTable = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Coach (coachid INTEGER PRIMARY KEY AUTOINCREMENT , memberid INTEGER(64), teamid INTEGER(64))");
                coachTable.executeUpdate();
                coachTable.close();

                PreparedStatement squadTable = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Squad (agegrade VARCHAR(64), teamid INTEGER PRIMARY KEY AUTOINCREMENT)");
                squadTable.executeUpdate();
                squadTable.close();

                PreparedStatement fixtureTable = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Fixture (teamid INTEGER(64), fixtureid INTEGER PRIMARY KEY AUTOINCREMENT, playingfield VARCHAR(64), skills VARCHAR(64), timelimit INTEGER(64), date VARCHAR(64))");
                fixtureTable.executeUpdate();
                fixtureTable.close();

                PreparedStatement sessionTable = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Session (teamid INTEGER(64), activity VARCHAR(64), timelimit INTEGER(64), date VARCHAR(64), sessionid INTEGER PRIMARY KEY AUTOINCREMENT)");
                sessionTable.executeUpdate();
                sessionTable.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void AddMember(Member member) {
    try {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

        PreparedStatement statement = connection.prepareStatement("DELETE FROM Member");

        try {



//            statement = connection.prepareStatement("INSERT INTO Member(fname,sname,sex,email,homeaddress,memberid,age) VALUES(?,?,?,?,?,?,?)");
            statement = connection.prepareStatement("INSERT INTO Member(fname,sname,sex,email,homeaddress,dob) VALUES(?,?,?,?,?,?)");
            statement.setString(1,member.getFname());
            statement.setString(2,member.getSname());
            statement.setString(3,member.getSex());
            statement.setString(4,member.getEmail());
            statement.setString(5,member.getHomeAddress());
//            statement.setInt(6,member.getMemberID());
            statement.setString(6,member.getDob());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
    } finally {
        statement.close();
        connection.close();
    }


    } catch (SQLException e) {
        e.printStackTrace();
    }


    }

    public Member ViewMember(int MemberID){
        Member member = new Member();

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement(("SELECT * FROM Member WHERE memberid = " + MemberID));


            try {
                ResultSet Memberset = statement.executeQuery();


                    try {

                        member = new Member(Memberset.getString("fname"), Memberset.getString("sname"), Memberset.getString("sex"), Memberset.getString("email"), Memberset.getString("homeaddress"), Memberset.getInt("memberid"), Memberset.getString("dob"));

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }



            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return member;
    }

    public void RemoveMember(int MemberID){


        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement("DELETE FROM Member WHERE memberid = " + MemberID);

            try {
                statement.executeUpdate();
                statement.close();

                PreparedStatement deletePlayer = connection.prepareStatement("DELETE FROM Player WHERE memberid = " + MemberID);

                deletePlayer.executeUpdate();
                deletePlayer.close();

                PreparedStatement deleteCoach = connection.prepareStatement("DELETE FROM Coach WHERE memberid = " + MemberID);

                deleteCoach.executeUpdate();
                deleteCoach.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void EditMember(int MemberID, Member member){


        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement("DELETE FROM Member");
            try {
                statement = connection.prepareStatement("UPDATE Member SET fname = ? , sname = ? , sex = ? , email = ? , homeaddress = ? , dob = ? WHERE memberid = ?");
                statement.setString(1,member.getFname());
                statement.setString(2,member.getSname());
                statement.setString(3,member.getSex());
                statement.setString(4,member.getEmail());
                statement.setString(5,member.getHomeAddress());

                statement.setString(6,member.getDob());
                statement.setInt(7,MemberID);

                statement.executeUpdate();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

//    The following sections is for the methods relating to the player table

    public void AddPlayer(Player player) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement("DELETE FROM Player");

            try {


                PreparedStatement statement2 = connection.prepareStatement(("SELECT * FROM Member WHERE memberid = " + player.getMemberID()));
                ResultSet Memberset = statement2.executeQuery();
                if (Memberset.getInt("memberid") == player.getMemberID()){

                statement = connection.prepareStatement("INSERT INTO Player(fieldposition, memberid, teamid, passing, catching, running, tackling, rucking, consent) VALUES(?,?,?,?,?,?,?,?,?)");

                statement.setString(1, player.getFieldPosition());
                statement.setInt(2, player.getMemberID());
                statement.setInt(3, player.getTeamID());
                statement.setInt(4, player.getPassing());
                statement.setInt(5, player.getCatching());
                statement.setInt(6, player.getRunning());
                statement.setInt(7, player.getTackling());
                statement.setInt(8, player.getRucking());

                int myInt = player.getConsent() ? 1 : 0;
                statement.setInt(9, myInt);



                statement.executeUpdate();
                statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void EditPlayer(int MemberID, Player player){


        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement("DELETE FROM Player");
            try {
                statement = connection.prepareStatement("UPDATE Player SET fieldposition = ?, teamid = ?, passing = ?, catching = ?, running = ?, tackling = ?, rucking = ?, consent = ? WHERE memberid = ?");
                statement.setString(1, player.getFieldPosition());

                statement.setInt(2, player.getTeamID());
                statement.setInt(3, player.getPassing());
                statement.setInt(4, player.getCatching());
                statement.setInt(5, player.getRunning());
                statement.setInt(6, player.getTackling());
                statement.setInt(7, player.getRucking());

                int myInt = player.getConsent() ? 1 : 0;
                statement.setInt(8, myInt);

                statement.setInt(9,MemberID);

                statement.executeUpdate();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Player ViewPlayer(int MemberID){
        Player player = new Player();

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement(("SELECT * FROM Player WHERE memberid = " + MemberID));


            try {
                ResultSet Playerset = statement.executeQuery();


                try {
                    boolean myBool = false;
                    if (Playerset.getInt("consent") == 1){
                        myBool = true;
                    }


                    player = new Player(Playerset.getString("fieldposition"), Playerset.getInt("memberid"), Playerset.getInt("teamid"), Playerset.getInt("passing"), Playerset.getInt("catching"), Playerset.getInt("running"), Playerset.getInt("tackling"), Playerset.getInt("rucking"), myBool);




                } catch (SQLException e) {
                    e.printStackTrace();
                }



            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return player;
    }

    //Coach methods section
    public void AddCoach(Coach coach) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement("DELETE FROM Coach");

            try {


                PreparedStatement statement2 = connection.prepareStatement(("SELECT * FROM Member WHERE memberid = " + coach.getMemberID()));
                ResultSet Memberset = statement2.executeQuery();
                if (Memberset.getInt("memberid") == coach.getMemberID()){

                    statement = connection.prepareStatement("INSERT INTO Coach(memberid, teamid) VALUES(?,?)");


                    statement.setInt(1, coach.getMemberID());
                    statement.setInt(2, coach.getTeamAssigned());


                    statement.executeUpdate();
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Coach ViewCoach(int MemberID){
        Coach coach = new Coach();

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement(("SELECT * FROM Coach WHERE memberid = " + MemberID));


            try {
                ResultSet Coachset = statement.executeQuery();

                    coach = new Coach(Coachset.getInt("memberid"),Coachset.getInt("teamid"),Coachset.getInt("coachid"));








            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return coach;
    }

    public void EditCoach(int MemberID, Coach coach){


        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement("DELETE FROM Coach");
            try {
                statement = connection.prepareStatement("UPDATE Coach SET memberid = ? , teamid = ? WHERE memberid = ?");
                statement.setInt(1,coach.getMemberID());
                statement.setInt(2,coach.getTeamAssigned());
                statement.setInt(3,MemberID);



                statement.executeUpdate();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



//    Section for the squads

    public void AddSquad(Squad squad) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement("DELETE FROM Squad");

            try {




                    statement = connection.prepareStatement("INSERT INTO Squad(agegrade) VALUES(?)");

                    statement.setString(1, squad.getAgeGrade());



                    statement.executeUpdate();
                    statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void EditSquad(int SquadID, Squad squad){


        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement("DELETE FROM Squad");
            try {
                statement = connection.prepareStatement("UPDATE Squad SET agegrade = ? WHERE teamid = ?");
                statement.setString(1, squad.getAgeGrade());

                statement.setInt(2, SquadID);

                statement.executeUpdate();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public String ViewSquad(int SquadID){
        ResultSet Playerset;
        String Playersett ="";

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement(("SELECT * FROM Player WHERE teamid = " + SquadID));


            try {
                Playerset = statement.executeQuery();

                boolean myBool = false;
                if (Playerset.getInt("consent") == 1){
                    myBool = true;
                }

                Player player1 = new Player();

                while (Playerset.next()) {

                    player1 = new Player(Playerset.getString("fieldposition"), Playerset.getInt("memberid"), Playerset.getInt("teamid"), Playerset.getInt("passing"), Playerset.getInt("catching"), Playerset.getInt("running"), Playerset.getInt("tackling"), Playerset.getInt("rucking"),myBool );

                    Playersett = Playersett + " || " +player1;
                }



            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Playersett;
    }

    public Squad ViewOneSquad(int SquadID){
        Squad squad = new Squad();

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement(("SELECT * FROM Squad WHERE teamid = " + SquadID));


            try {
                ResultSet Squadset = statement.executeQuery();

                squad = new Squad(Squadset.getInt("teamid"),Squadset.getString("agegrade"));








            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return squad;
    }
    public void DeleteSquad(int SquadID){


        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement("DELETE FROM Squad WHERE teamid = " + SquadID);

            try {
                statement.executeUpdate();
                statement.close();

                PreparedStatement statement2 = connection.prepareStatement("DELETE FROM Session WHERE teamid = " + SquadID);
                statement2.executeUpdate();
                statement2.close();

                PreparedStatement statement3 = connection.prepareStatement("DELETE FROM Fixture WHERE teamid = " + SquadID);
                statement3.executeUpdate();
                statement3.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Section for the fixture methods

    public void AddFixture(Fixture fixture) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement("DELETE FROM Fixture");

            try {

                    statement = connection.prepareStatement("INSERT INTO Fixture(teamid, playingfield, skills, timelimit, date) VALUES(?,?,?,?,?)");

                    statement.setInt(1, fixture.getTeamID());

                    statement.setString(2, fixture.getPlayingField());
                    statement.setString(3, fixture.getSkills());
                    statement.setInt(4, fixture.getTimeLimit());
                    statement.setString(5, fixture.getDate());


                    statement.executeUpdate();
                    statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public String ViewFixture(int FixtureID){
        ResultSet FixtureSet;
        String FixtureSetty ="";

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement(("SELECT * FROM Fixture WHERE fixtureid = " + FixtureID));


            try {
                FixtureSet = statement.executeQuery();

                while (FixtureSet.next()) {

                    Fixture fixture = new Fixture(FixtureSet.getInt("teamid"), FixtureSet.getInt("fixtureid"), FixtureSet.getInt("timelimit"), FixtureSet.getString("playingfield"), FixtureSet.getString("date"), FixtureSet.getString("skills"));

                    FixtureSetty = FixtureSetty +"\n"+ fixture;
                }



            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return FixtureSetty;
    }

    public String ViewPlayerFixtures(int TeamID){
        ResultSet FixtureSet;
        String FixtureSetty ="";

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement(("SELECT * FROM Fixture WHERE teamID = " + TeamID));


            try {
                FixtureSet = statement.executeQuery();

                while (FixtureSet.next()) {

                    Fixture fixture = new Fixture(FixtureSet.getInt("teamid"), FixtureSet.getInt("fixtureid"), FixtureSet.getInt("timelimit"), FixtureSet.getString("playingfield"), FixtureSet.getString("date"), FixtureSet.getString("skills"));

                    FixtureSetty = FixtureSetty + "\n" + fixture;
                }



            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return FixtureSetty;
    }


    public void DeleteFixture(int FixtureID){


        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement("DELETE FROM Fixture WHERE fixtureid = " + FixtureID);

            try {
                statement.executeUpdate();
                statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Section for the session methods

    public void AddSession(Session session) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement("DELETE FROM Session");

            try {

                statement = connection.prepareStatement("INSERT INTO Session(teamid, activity, timelimit, date) VALUES(?,?,?,?)");

                statement.setInt(1, session.getTeamID());
                statement.setString(2, session.getActivity());
                statement.setInt(3, session.getTimeLimit());
                statement.setString(4, session.getDate());




                statement.executeUpdate();
                statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public String ViewSession(int SessionID){
        ResultSet SessionSet;
        String SessionSett ="";

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement(("SELECT * FROM Session WHERE sessionid = " + SessionID));


            try {
                SessionSet = statement.executeQuery();

                while (SessionSet.next()) {

                    Session session = new Session(SessionSet.getInt("teamid"), SessionSet.getInt("sessionid"), SessionSet.getInt("timelimit"), SessionSet.getString("date"), SessionSet.getString("activity"));

                    SessionSett = SessionSett +"\n"+ session;
                }



            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return SessionSett;
    }

    public String ViewPlayersSession(int TeamID){
        ResultSet SessionSet;
        String SessionSett ="";

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement(("SELECT * FROM Session WHERE teamid = " + TeamID));


            try {
                SessionSet = statement.executeQuery();

                while (SessionSet.next()) {

                    Session session = new Session(SessionSet.getInt("teamid"), SessionSet.getInt("sessionid"), SessionSet.getInt("timelimit"), SessionSet.getString("date"), SessionSet.getString("activity"));

                    SessionSett = SessionSett +"\n"+ session;
                }



            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return SessionSett;
    }


    public void DeleteSession(int SessionId){


        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:simplyrugby.sqlite");

            PreparedStatement statement = connection.prepareStatement("DELETE FROM Session WHERE sessionid = " + SessionId);

            try {
                statement.executeUpdate();
                statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}



package com.example.simplyrugbysoftware;
/**
 *
 * TestDatabase class, class that was used to test the database originally.
 * @author Bartlomiej Klich
 * @version
 *
 */

public class TestDatabase {

    public static void main(String[] args) {
        Member member = new Member("jim","jones","male","donkey@21","g2",1,"13");
        Member member2 = new Member("jones","jones","male","donkey@21","g2",2,"13");
        Member member3 = new Member("donkey","jones","adadad","donkey@212","g2",2,"13");
        Member member4 = new Member("dunkkey","aawwa","fe","donkey@212","g2",3,"13");
        Player player1 = new Player("Rear",1,1,10,10,10,10,10,true);
        Player player2 = new Player("Front",2,1,10,10,10,10,10,true);
        Player player3 = new Player("backkk",3,1,10,10,10,10,10,true);
        Coach coach1 = new Coach(2,1,1);
        Squad squad = new Squad(1,"a");
        Squad squad1 = new Squad(1,"b");

        DatabaseController databaseController = new DatabaseController();

        databaseController.AddMember(member);
        databaseController.AddMember(member2);

        System.out.println(databaseController.ViewMember(1).toString());
        System.out.println(databaseController.ViewMember(2).toString());

        System.out.println("checking if the member is a player");
        databaseController.AddPlayer(player1);
        System.out.println(databaseController.ViewPlayer(1).toString());
        databaseController.EditPlayer(1,player2);
        System.out.println(databaseController.ViewPlayer(1).toString());
        databaseController.AddMember(member4);
        databaseController.AddPlayer(player3);



        System.out.println("_________________________________");
        System.out.println("checking if the member is a coach");
        databaseController.AddCoach(coach1);
        System.out.println(databaseController.ViewCoach(2).toString());
        System.out.println("_________________________________");

        System.out.println("_________________________________");
        System.out.println("checking if the team exists");
        databaseController.AddSquad(squad);
        System.out.println(databaseController.ViewSquad(1));
        databaseController.EditSquad(1,squad1);
        System.out.println("_________________________________");


        databaseController.RemoveMember(1);
        System.out.println(databaseController.ViewMember(1).toString());
        System.out.println(databaseController.ViewMember(2).toString());

        System.out.println("Updating member id 2");
        databaseController.EditMember(2,member3);
        System.out.println(databaseController.ViewMember(2).toString());

        databaseController.RemoveMember(2);
        databaseController.RemoveMember(3);
        System.out.println(databaseController.ViewMember(1).toString());
        System.out.println(databaseController.ViewMember(2).toString());
        System.out.println(databaseController.ViewPlayer(1).toString());
        System.out.println(databaseController.ViewCoach(2).toString());

        System.out.println("testing fixtures");
        Fixture fixture = new Fixture(1,1,60,"away","19/12/2023","Dribbling");
        databaseController.AddFixture(fixture);
        System.out.println(databaseController.ViewPlayerFixtures(1));

        Fixture fixture2 = new Fixture(1,2,60,"home","20/12/2023","Dribbling");
        databaseController.AddFixture(fixture2);
        System.out.println(databaseController.ViewPlayerFixtures(1));


        databaseController.DeleteFixture(1);
        System.out.println(databaseController.ViewPlayerFixtures(1));
        System.out.println(databaseController.ViewFixture(1));
        System.out.println("testing session");

        Session session = new Session(1,1,30,"11/06/2020","drible practice");
        databaseController.AddSession(session);
        System.out.println(databaseController.ViewPlayersSession(1));

        Session session1 = new Session(1,2,30,"12/06/2020","drible practice");
        databaseController.AddSession(session1);
        System.out.println(databaseController.ViewPlayersSession(1));



        databaseController.DeleteSession(1);
        System.out.println(databaseController.ViewPlayersSession(1));
        System.out.println(databaseController.ViewSession(1));
        databaseController.DeleteSquad(1);




    }


}

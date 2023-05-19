package com.example.simplyrugbysoftware;
/**
 *
 * TempMembers class that inserts members, players, coaches, fixtures and sessions when run.
 * @author Bartlomiej Klich
 * @version
 *
 *
 */
public class TempMembers {
    public static void main(String[] args) {

        Member member = new Member("jim","jones","M","donkey@21.com","g23 4dq",1,"11/06/2020");
        Player player1 = new Player("Rear",1,1,10,10,10,10,10,false);

        Squad squad = new Squad(1,"U9");

        Member member1 = new Member("jones","james","M","donkey@21.com","g23 4dq",0,"11/06/2020");
        Coach coach = new Coach(2,1,0);
        Coach coach1 = new Coach(2,2,0);


        DatabaseController databaseController = new DatabaseController();

        databaseController.AddSquad(squad);
        databaseController.AddMember(member);
        databaseController.AddPlayer(player1);

        databaseController.AddMember(member1);
        databaseController.AddCoach(coach);

        System.out.println(databaseController.ViewMember(1).toString());
        System.out.println(databaseController.ViewPlayer(1).toString());

        System.out.println(databaseController.ViewMember(2).toString());
        System.out.println(databaseController.ViewCoach(2).toString());


        System.out.println(databaseController.ViewMember(1).toString());
        System.out.println(databaseController.ViewPlayer(1).toString());

        Session session = new Session(1,1,30,"11/06/2020","drible practice");
        databaseController.AddSession(session);

        Session session1 = new Session(1,1,30,"12/06/2020","drible practice");
        databaseController.AddSession(session1);


        Fixture fixture = new Fixture(1,1,60,"away","19/12/2023","Dribbling");
        databaseController.AddFixture(fixture);


        Fixture fixture2 = new Fixture(1,1,60,"home","20/12/2023","Dribbling");
        databaseController.AddFixture(fixture2);
        System.out.println(databaseController.ViewPlayerFixtures(1));

        System.out.println(databaseController.ViewCoach(2));
        databaseController.EditCoach(2,coach1);
        System.out.println(databaseController.ViewCoach(2));



        System.out.println(databaseController.ViewPlayersSession(databaseController.ViewPlayer(1).getTeamID()));



    }
}

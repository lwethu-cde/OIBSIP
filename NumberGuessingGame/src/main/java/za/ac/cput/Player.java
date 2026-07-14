package za.ac.cput;

public class Player {

    //Stores the players name
    private String name;

    //Stores the players score
    private int totalscore;

    //Constructor for creating a players object
   public Player(String name){
       this.name = name;
       this.totalscore = 0;
   }

    public String getName() {
        return name;
    }

    public int getTotalscore() {
        return totalscore;
    }

    public void addScore(int score) {
        totalscore += score;
    }
}

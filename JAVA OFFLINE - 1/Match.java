import java.util.Random;

public class Match{
    private int matchNo;
    private Club homeTeam;
    private Club awayTeam;
    private boolean isPlayed;
    private int homeTeamScore;
    private int awayTeamScore;
    // add your variables here, if required

    // you are not allowed to write any more constructors
    public Match(int matchNo, Club homeTeam, Club awayTeam){
        this.matchNo = matchNo;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.isPlayed = false;
        this.homeTeamScore=0;
        this.awayTeamScore=0;
        this.homeTeam.point=0;
        this.awayTeam.point=0;
    }

    public void play(){
        Random random = new Random();
        this.homeTeamScore = random.nextInt(10);
        this.awayTeamScore = random.nextInt(10);
        this.isPlayed = true;
        // you can add your code here if required
        // a team gets 2 points for winning and 0 point for losing
        // both teams get 1 point each in case of a draw
        if(this.homeTeamScore>this.awayTeamScore) {
            this.homeTeam.point+=2;
        }
        else if(this.homeTeamScore==this.awayTeamScore) {
            this.homeTeam.point++;
            this.awayTeam.point++;
        }
        else {
            this.awayTeam.point+=2;
        }
    }

    public void showResult(){
        if (!isPlayed){
            System.out.println("Match " + matchNo + " between " + homeTeam.getName() + " and " + awayTeam.getName() + " is yet to be played.");
            return;
        }
        // exactly one of the following three print statements should be executed
        // add condition to check if the match is drawn, the home team won or the away team won
        if(this.homeTeamScore==this.awayTeamScore) {
            System.out.println("Match drawn. " + homeTeam.getName() + " " + homeTeamScore + "-" + awayTeamScore + " " + awayTeam.getName());
        }
        else if(this.homeTeamScore>this.awayTeamScore) {
            System.out.println(homeTeam.getName() + " wins. " + homeTeam.getName() + " " + homeTeamScore + "-" + awayTeamScore + " " + awayTeam.getName());
        }
        else {
            System.out.println(awayTeam.getName() + " wins. " + homeTeam.getName() + " " + homeTeamScore + "-" + awayTeamScore + " " + awayTeam.getName());
        }
    }

    // add your methods here, if required
}

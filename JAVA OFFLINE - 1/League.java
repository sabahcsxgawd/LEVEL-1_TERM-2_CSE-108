public class League {
    private Match[] matches;
    private int matchCount;
    private int clubCount;
    private Club[] clubs;
    private String name;
    // add your variables here, if required

    public League() {
        // assume a league can have at most 5 clubs, add code for initialization accordingly
        this.clubCount = 0;
        this.matchCount = 0;
        this.clubs=new Club[5];
    }

    public void printLeagueInfo(){
        System.out.println("League : " + name);
        printClubs();
    }

    public void printClubs(){
        System.out.println("Clubs:");
        // print the name of the clubs of this league, each one on a line
        for(int i=0;i<this.clubCount;i++) {
            System.out.println(this.clubs[i].getName());
        }
    }

    public void scheduleMatches(){
        this.matchCount = (clubCount*(clubCount-1));
        this.matches = new Match[matchCount];
        int matchNo = 0;
        for (int i=0; i<clubCount; i++){
            for (int j=0; j<clubCount; j++){
                // check the constructor of the Match class and add your code here
                // note that there will be two matches between club A and club B
                // in the first match, club A will play as the home team and in the second match, as the away team
                if(i!=j) {
                    this.matches[matchNo] = new Match(matchNo, this.clubs[i], this.clubs[j]);
                    matchNo++;
                }
            }
        }
    }

    public void simulateMatches(){
        for (int i=0; i<matchCount; i++){
            matches[i].play();
        }
    }

    public void showStandings(){
        // sort the clubs in descending order of points
        // note that, the sequence in which clubs were added to the league, should be unchanged
        // check the given sample output for clarification
        // (carefully observe the output of showStandings() followed by printLeagueInfo() method calls
        // you can use additional arrays if needed
        Club[] temp = new Club[this.clubCount];
        boolean[] used = new boolean[this.clubCount];
        int maxpoint=-1,index=0;
        for(int i=0;i<this.clubCount;i++) {
            for(int j=0;j<this.clubCount;j++) {
                if(this.clubs[j].point>maxpoint && used[j]==false) {
                    maxpoint = this.clubs[j].point;
                    index = j;
                }
            }
            used[index]=true;
            temp[i]=this.clubs[index];
            maxpoint=-1;
        }
        System.out.println("Sl. - Club - Points");
        // print the clubs in descending order of points
        for(int i=0;i<this.clubCount;i++) {
            System.out.println(i+1 + ". "+temp[i].getName()+" "+temp[i].point);
        }
    }

    public void setName(String leagueName) {
        this.name=leagueName;
    }

    public void addClub(Club club) {
        this.clubs[clubCount]=club;
        clubCount++;
    }

    public void printMatches() {
        System.out.println("Matches:");
        for(int i=0;i<matchCount;i++) {
            this.matches[i].showResult();
        }
    }

    public void removeClub(Club club) {
        int index=-1;
        for(int i=0;i<this.clubCount;i++) {
            if(club==this.clubs[i]) { index=i; break; }
        }
        for(int i=index+1;i<this.clubCount;i++) {
            this.clubs[i-1]=this.clubs[i];
        }
        this.clubCount--;
    }
    // add your methods here, if required
}


public class Club {
    private int id;
    private String name;
    private Player[] players;
    private int playerCount;
    public int point;
    // add your code here

	// you are not allowed to write any other constructor
    public Club() {
        this.players = new Player[11];
        this.id=0;
        this.name="";
        this.playerCount=0;
        this.point=0;
    }

	public double getSalary() {
        double total = 0;
        for (int i = 0; i < playerCount; i++) {
            total += players[i].getSalary();
        }
        return total;
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void addPlayer(Player player) {
        this.players[playerCount]=player;
        this.playerCount++;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Player getMaxSalaryPlayer() {
        int temp=0;
        for(int i=1;i<playerCount;i++) {
            if(this.players[i].getSalary()>this.players[temp].getSalary()) { temp=i; }
        }
        return this.players[temp];
    }


    // add your code here
}
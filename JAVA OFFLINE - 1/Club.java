public class Club {
    private int id;
    private String name;
    public int point;

    public Club() {
        this.id=0;
        this.name="";
        this.point=0;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

}
public class Player {
    private int number;
    private String name;
    private double salary;

	// you are not allowed to write any other constructor
    public Player(int number, String name) {
        setNumber(number);
        setName(name);
        this.salary=0;
    }
    // add your code here
    public void setSalary(double salary) {
        this.salary=salary;
    }
    public double getSalary() {
        return this.salary;
    }
    public void setNumber(int number) {
        this.number=number;
    }
    public void setName(String name) {
        this.name=name;
    }

    public String getName() {
        return this.name;
    }
}

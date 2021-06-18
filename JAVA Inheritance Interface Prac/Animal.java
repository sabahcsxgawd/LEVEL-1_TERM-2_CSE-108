public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + " is a " + this.getClass().getName() + ", " + "aged " + this.age;
    }
}
public class EasternBrownSnake extends Reptile implements Venomous {
    public EasternBrownSnake(String steph, int i) {
        super(steph,i);
    }

    public boolean isLethalToAdultHumans() {
        return true;
    }
}

/**
 * Created by falyanguzov on 09.11.2016.
 */
public class Computer extends Player {

    private String name;
    static String[] names = {"Coward", "Stupid", "Stager"};

    public Computer(Intellect intellect) {
        super(intellect, names[(int)Math.random() * names.length]); // от 0 до 3
        super.setMoney(500); // TODO: доделать
    }


}

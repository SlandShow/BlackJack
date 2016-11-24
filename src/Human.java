/**
 * Created by falyanguzov on 09.11.2016.
 */
public class Human extends Player {


    public Human(String name) {
        super(new HumanIntellect(), name);
        super.setMoney(500); // TODO: доделать
    }
}

import java.util.LinkedList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        Table t = new Table();
        t.initTable();
        String choice;
        boolean play = true;

        while (play) {
            t.newRound();
            System.out.println("Do you wan`t another round? (Y/N): ");
            choice = HumanIntellect.in.nextLine();

            if ("yes".startsWith(choice.toLowerCase())) t.clear();
            else System.exit(0);
        }

    }
}

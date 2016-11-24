import java.util.Scanner;

/**
 * Created by falyanguzov on 16.11.2016.
 */
public class HumanIntellect extends Intellect {
    static Scanner in = new Scanner(System.in);

    @Override
    public Command decide(int score) {
        do{
            System.out.print("Hit/Stand/Exit: ");
            String s = in.nextLine();

            if("hit".startsWith(s.toLowerCase())){
                return Command.HIT;
            }else if("stand".startsWith(s.toLowerCase())) {
                return Command.STAND;
            }else if ("exit".startsWith(s.toLowerCase()))  {
                System.exit(0);
            }else{
                System.out.println("Command not recognized...");
            }
        }while(true);
    }
}

import java.util.LinkedList;
import java.util.List;

/**
 * Created by student4 on 17.11.16.
 */
public class Table {

    private List<Player> players;
    private Dealer dealer;


    public void initTable() {
        players = new LinkedList<Player>();
        dealer = new Dealer();

        System.out.println("Enter your name...");
        String name = HumanIntellect.in.nextLine();

        players.add(new Computer(new LimitIntellect(14)));
        players.add(new Computer(new LimitIntellect(20)));
        players.add(new Human(name));
        players.add(dealer);

    }

    public void newRound() {
        pay();
        startRound();
        playRound();
        decideWiners();
    }

    public void clear() {
        for (Player player : players)
            player.hand.clear();
    }

    public void pay() {

        System.out.println("Enter value...");
        int money = HumanIntellect.in.nextInt();

        if (money <= 0) System.exit(-1); // защита от "дурака"

        for (Player player: players) {
            if (!(player instanceof Dealer)) {

                if (player instanceof Computer)
                    player.hand.setComputerRate(player, 200);

                if (player instanceof Human)
                    player.hand.setHumanRate(player, money);


                player.setMoney(player.getMoney() - player.hand.getRate().getValueRate());


                System.out.println(player.getName() + " rate: " +
                        player.hand.getRate().getValueRate()
                        + " money: " + player.getMoney());
            }
        }

    }

    public void checkRate() {
        for (Player player: players) {
            if (!(player instanceof Dealer)) {

            }
        }
    }

    // раздаем по две карты каждому игроку
    public void startRound() {
        for (Player player : players) {
            dealer.deal(player);
            dealer.deal(player);
        }
    }


    public void playRound() {
        for (Player player : players) {
            Command command;
            do {
                System.out.println(player.getName() + " " + player.hand.countScore() + ": " + player.hand);
                command = player.decision();
                switch (command) {
                    case HIT:
                        dealer.deal(player);
                        break;
                }
            } while (command != Command.STAND);
        }

        System.out.println(dealer.getName() + " " + dealer.hand.countScore() + " " + dealer.hand);
    }


    public void decideWiners() {
        // определяем победу
        for (Player player : players) {
            if (player != dealer) {

                if (player.hand.countScore() > 21)
                    player.state = PlayerState.LOSS;

                else if (dealer.hand.countScore() > 21) {
                    player.state = PlayerState.WIN;
                    if (player instanceof Human)
                        player.setMoney(2 * player.hand.getRate().getValueRate() + player.getMoney());
                    if (player instanceof Computer)
                        player.setMoney(2 * player.hand.getRate().getValueRate() + player.getMoney());
                }

                else if (player.hand.countScore() > dealer.hand.countScore()) {
                    player.state = PlayerState.WIN;
                    if (player instanceof Human)
                        player.setMoney(2 * player.hand.getRate().getValueRate() + player.getMoney());
                    if (player instanceof Computer)
                        player.setMoney(2 * player.hand.getRate().getValueRate() + player.getMoney());
                }

                else if (player.hand.countScore() < dealer.hand.countScore())
                    player.state = PlayerState.LOSS;

                else player.state = PlayerState.DRAW;

                // выводим победителя
                System.out.println(player.getName() + " " + player.state + " with " + player.hand);
            }
        }

    }


}
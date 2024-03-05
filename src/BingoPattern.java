import java.util.List;

public abstract class BingoPattern implements Runnable {
    List<BingoChecker> checkers;
    BingoCard toCheckCard;

    public BingoPattern(BingoCard card) {
        toCheckCard = card;
    }

    @Override
    public void run() {
        Thread[] checkerRowThrds = new Thread[5];
        Thread[] checkerColThrds = new Thread[5];
        for (int i = 0; i < 5; i++) {
            for(int j = 1; j <= 5; j++) {
                checkerRowThrds[i] = new Thread(new BingoRowChecker(BingoGame.cards.get(i), j));
                checkerRowThrds[i].start();

                checkerColThrds[i] = new Thread(new BingoColumnChecker(BingoGame.cards.get(i), j));
                checkerColThrds[i].start();
            }
        }
    }
}

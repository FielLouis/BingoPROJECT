import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BingoGame implements Runnable {
    static final boolean[] result = new boolean[76];
    static boolean isBingo;
    static List<BingoCard> cards;

    @Override
    public void run() {
        result[0] = true;

        Scanner sc = new Scanner(System.in);
        System.out.print("How many players? ");
        int cnt = sc.nextInt();

        cards = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            cards.add(new BingoCard(i + 1));
        }

        for (BingoCard card : cards) {
            System.out.println("Card " + card.id);
            System.out.println(card);
        }
        // TODO create your checker threads per card
        // TODO start all threads
        Thread[] checkerPlus = new Thread[cnt];
        Thread[] checkerHash = new Thread[cnt];
        for(int i = 0; i < cnt; i++) {
            checkerPlus[i] = new Thread(new BingoPatternPlus(cards.get(i)));
            checkerPlus[i].start();
        }
//        Thread[] checkerRowThrds = new Thread[cnt];
//        Thread[] checkerColThrds = new Thread[cnt];
//        for (int i = 0; i < cnt; i++) {
//            for(int j = 1; j <= 5; j++) {
//                checkerRowThrds[i] = new Thread(new BingoRowChecker(cards.get(i), j));
//                checkerRowThrds[i].start();
//
//                checkerColThrds[i] = new Thread(new BingoColumnChecker(cards.get(i), j));
//                checkerColThrds[i].start();
//            }
//        }

        // TODO RANDOM RESULTS
        // TODO randomly get number from 1-75 while not bingo
        while(!isBingo) {
            Random r = new Random();
            int numChosen;

            do {
                numChosen = r.nextInt(1, 76);
            } while ( result[numChosen] );

            System.out.print(numChosen + " ");
            result[numChosen] = true;

            synchronized (result) {
                result.notifyAll();
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
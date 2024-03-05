import java.util.ArrayList;

public class BingoPatternPlus extends BingoPattern {

    public BingoPatternPlus(BingoCard card) {
        super(card);
        this.checkers = new ArrayList<>();
        this.checkers.add(new BingoRowChecker(toCheckCard, 3));
        this.checkers.add(new BingoColumnChecker(toCheckCard, 3));
    }

    @Override
    public void run() {
    }
}

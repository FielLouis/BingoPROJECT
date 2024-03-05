import java.util.ArrayList;

public class BingoPatternHash extends BingoPattern {
    public BingoPatternHash(BingoCard bc) {
        super(bc);
        this.checkers = new ArrayList<>();
        this.checkers.add(new BingoColumnChecker(toCheckCard,2));
        this.checkers.add(new BingoColumnChecker(toCheckCard,4));
        this.checkers.add(new BingoRowChecker(toCheckCard,2));
        this.checkers.add(new BingoRowChecker(toCheckCard,4));
    }

    @Override
    public void run() {
    }
}

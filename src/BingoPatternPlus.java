public class BingoPatternPlus extends BingoPattern {

    public BingoPatternPlus(BingoCard card) {
        super(card);
    }

    @Override
    public void run() {
        Thread checkerRow = new Thread(new BingoRowChecker(toCheckCard, 3));
        Thread checkerCol = new Thread(new BingoColumnChecker(toCheckCard, 3));

        checkerRow.start();
        checkerCol.start();
    }
}

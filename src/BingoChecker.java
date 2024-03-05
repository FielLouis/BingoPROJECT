import java.util.List;

public abstract class BingoChecker implements Runnable {
    BingoCard card;

    public BingoChecker(BingoCard bc) {
        this.card = bc;
    }
}

package pen.pen;

import pen.pen.content.Refill;
import pen.strategy.WriteStrategy;

public class BallPen extends Pen{
    private Refill refill;

    public BallPen(WriteStrategy writeStrategy, Refill refill) {
        super(writeStrategy);
        this.refill = refill;
    }

    @Override
    public void write() {
        System.out.println("BallPen!!");
        writeStrategy.writeBehaviour();
    }
}

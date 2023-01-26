package pen;

import pen.pen.BallPen;
import pen.pen.Pen;
import pen.pen.content.Refill;
import pen.strategy.SmoothWritingStrategy;

public class Client {
    public static void main(String[] args) {
        Pen ballPen = new BallPen(new SmoothWritingStrategy(), new Refill());
        ballPen.write();
    }
}

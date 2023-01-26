package pen.pen;

import pen.pen.content.Cap;
import pen.strategy.WriteStrategy;

public abstract class Pen {
    String name;
    String bodyColor;
    int length;
    int price;
    Cap cap;

    WriteStrategy writeStrategy;

    public Pen(WriteStrategy writeStrategy) {
        this.writeStrategy = writeStrategy;
    }
    public abstract void write();
}

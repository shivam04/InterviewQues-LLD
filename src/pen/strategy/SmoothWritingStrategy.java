package pen.strategy;

public class SmoothWritingStrategy implements WriteStrategy{
    @Override
    public void writeBehaviour() {
        System.out.println("Smooth Writing!!");
    }
}

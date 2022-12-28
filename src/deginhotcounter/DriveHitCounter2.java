package deginhotcounter;

public class DriveHitCounter2 {
    public static void main(String[] args) {
        HitCounter2 counter = new HitCounter2();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println(counter.getHits(4)); //3
        counter.hit(300);
        System.out.println(counter.getHits(300)); //4
        System.out.println(counter.getHits(301));//3
    }
}

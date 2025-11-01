import java.util.concurrent.CountDownLatch;

public class Main {
    static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(4);


        Thread Th1 = new Thread(new ThreadOne(latch));
        Th1.start();
        Thread Th2 = new Thread(new ThreadTwo(latch));
        Th2.start();
        Thread Th3 = new Thread(new ThreadThree(latch));
        Th3.start();
        Thread Th4 = new Thread(new ThreadFour(latch));
        Th4.start();

    }
}

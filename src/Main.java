import org.w3c.dom.css.Counter;

import java.util.concurrent.CountDownLatch;

public class Main {
    static void main(String[] args) {
        CountDownLatch WorkDone = new CountDownLatch(4);
        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);
        CountDownLatch latch3 = new CountDownLatch(1);
        CountDownLatch latch4 = new CountDownLatch(1);


        Thread Th1 = new Thread(new ThreadOne(WorkDone, latch1));
        Th1.start();
        Thread Th2 = new Thread(new ThreadTwo(WorkDone,latch1, latch2));
        Th2.start();
        Thread Th3 = new Thread(new ThreadThree(WorkDone,latch2, latch3));
        Th3.start();
        Thread Th4 = new Thread(new ThreadFour(WorkDone,latch3,latch4));
        Th4.start();
    }
}

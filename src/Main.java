import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Main {
    static synchronized void print(String out){
        System.out.println(out);
    }
    static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(4);
        Monitor monitor = new Monitor();

        Scanner input = new Scanner(System.in);
        System.out.println("Выберите вариант: 1) Слободенюк 2)Кравченко");
        int choice = input.nextInt();
        switch (choice) {
            case 1:Thread Th1 = new Thread(new ThreadOne(latch));
                    Th1.start();
                    Thread Th2 = new Thread(new ThreadTwo(latch));
                    Th2.start();
                    Thread Th3 = new Thread(new ThreadThree(latch));
                    Th3.start();
                    Thread Th4 = new Thread(new ThreadFour(latch));
                    Th4.start();

                break;
                case 2:Thread CravTh1 = new Thread(new Thread1(monitor));
                    CravTh1.start();

                    Thread CravTh2 = new Thread(new Thread2(monitor));
                    CravTh2.start();

                    Thread CravTh3 = new Thread(new Thread3(monitor));
                    CravTh3.start();

                    Thread CravTh4 = new Thread(new Thread4(monitor));
                    CravTh4.start();
                    break;
        }
    }
}

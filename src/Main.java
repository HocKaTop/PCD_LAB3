public class Main {
    static void main(String[] args) {
        Thread Th1 = new Thread(new ThreadOne());
        Th1.start();
        Thread Th2 = new Thread(new ThreadTwo());
        Th2.start();
        try {
            Th1.join();
            Th2.join();
        } catch (InterruptedException e) { e.printStackTrace();}

        Thread Th3 = new Thread(new ThreadThree());
        Thread Th4 = new Thread(new ThreadFour());
        Th3.start();
        while (Th3.isAlive()){
            if(!Th3.isAlive()){
                Th4.start();
            }
        }
    }
}

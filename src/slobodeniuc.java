import java.util.concurrent.CountDownLatch;

class ThreadOne implements Runnable {
    private CountDownLatch latch;
    public ThreadOne (CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        int oddCount = 0;
        int index = 0;

        for (int i = 1111; i <=1748 ; i++) {
            if(i%2!=0) {
                oddCount++;
            }
        }
        int[] oddNumbers = new int[oddCount];

        for (int i = 1111; i <=1748 ; i++) {
            if(i%2!=0) {
                oddNumbers[index]= i;
                index++;
            }
        }


        int first = oddNumbers[0];
        int sum = 0;
        // сумма произведений чисел по два с первым элементом
        for (int i = 0; i < oddNumbers.length ; i++) {
            sum += first * oddNumbers[i];
            //System.out.println(sum);
        }
        System.out.println("Выполненный результат потока 1 : "+sum);
        latch.countDown();
    }
}
class ThreadTwo implements Runnable {
    private CountDownLatch latch;
    private CountDownLatch waitFor;

    public ThreadTwo(CountDownLatch waitFor, CountDownLatch latch) {
        this.waitFor = waitFor;
        this.latch = latch;
    }
    public void run() {

        int oddCount = 0;
        int index = 0;

        for (int i = 1111; i <=1748 ; i++) {
            if(i%2!=0) {
                oddCount++;
            }
        }
        int[] oddNumbers = new int[oddCount];

        for (int i = 1111; i <=1748 ; i++) {
            if(i%2!=0) {
                oddNumbers[index]= i;
                index++;
            }
        }


        int last = oddNumbers[oddNumbers.length-1];
        int sum = 0;
        // сумма произведений чисел по два с первым элементом
         for (int i = 0; i < oddNumbers.length ; i++) {
            if (oddNumbers[i]!=last) {
                sum += last * oddNumbers[i];
               // System.out.println(sum);
            }
        }
        try{
            waitFor.await();
        } catch (InterruptedException e) {}
        System.out.println("Выполненный результат потока 2 : "+sum);
        latch.countDown();


        System.out.println("Работу выполнил Олег");
    }
}

class ThreadThree implements Runnable{
    private CountDownLatch latch;
    private CountDownLatch waitFor;
    public ThreadThree(CountDownLatch waitFor, CountDownLatch latch) {
        this.waitFor = waitFor;
        this.latch = latch;
    }

    public void run(){
        try{
            waitFor.await();
        } catch (InterruptedException e) {}
        for (int i = 1111; i <=1748 ; i++) {
            //System.out.println("я даун");
        }
        System.out.println("Третий закончил");
        latch.countDown();
    }
}

class ThreadFour implements Runnable{
    private CountDownLatch latch;
    private CountDownLatch waitFor;

    public ThreadFour (CountDownLatch waitFor, CountDownLatch latch) {
        this.waitFor = waitFor;
        this.latch = latch;
    }


    public void run(){
        try{
            waitFor.await();
        } catch (InterruptedException e) {}

        for (int j = 2000; j >=1478 ; j--) {
           // System.out.println(j);
        }
        System.out.println("Четвертый закончил");
        latch.countDown();

    }
}

//воу воу братишка полегче
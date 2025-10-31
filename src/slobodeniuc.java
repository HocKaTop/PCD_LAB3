import java.util.concurrent.CountDownLatch;

class ThreadOne implements Runnable {
    private CountDownLatch latch;
    private CountDownLatch WorkDone;
    public ThreadOne (CountDownLatch WorkDone, CountDownLatch latch) {
        this.WorkDone = WorkDone;
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
            System.out.println("Поток 1 высрал: "+sum);
        }
        WorkDone.countDown();
        System.out.println("Выполненный результат потока 1 : "+sum);
        latch.countDown();
    }
}
class ThreadTwo implements Runnable {
    private CountDownLatch latch;
    private CountDownLatch waitFor;
    private CountDownLatch WorkDone;

    public ThreadTwo(CountDownLatch WorkDone, CountDownLatch waitFor, CountDownLatch latch) {
        this.waitFor = waitFor;
        this.latch = latch;
        this.WorkDone = WorkDone;
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
               System.out.println("Поток 2 высрал: "+sum);
            }
        }
         WorkDone.countDown();
        try{
            waitFor.await();
        } catch (InterruptedException e) {}
        System.out.println("Выполненный результат потока 2 : "+sum);
        latch.countDown();


        //System.out.println("Работу выполнил Олег");
    }
}

class ThreadThree implements Runnable{
    private CountDownLatch latch;
    private CountDownLatch waitFor;
    private CountDownLatch WorkDone;
    public ThreadThree(CountDownLatch WorkDone, CountDownLatch waitFor, CountDownLatch latch) {
        this.WorkDone = WorkDone;
        this.waitFor = waitFor;
        this.latch = latch;
    }

    public void run(){
        for (int i = 1111; i <=1748 ; i++) {
            System.out.println(i);
        }
        try{
            waitFor.await();
        } catch (InterruptedException e) {}
        WorkDone.countDown();
       System.out.println("Третий закончил");
        latch.countDown();
    }
}

class ThreadFour implements Runnable{
    private CountDownLatch WorkDone;
    private CountDownLatch latch;
    private CountDownLatch waitFor;

    public ThreadFour (CountDownLatch WorkDone,CountDownLatch waitFor, CountDownLatch latch) {
        this.WorkDone= WorkDone;
        this.waitFor = waitFor;
        this.latch = latch;
    }


    public void run(){
        for (int j = 2000; j >=1478 ; j--) {
            System.out.println(j);
        }
        try{
            waitFor.await();
        } catch (InterruptedException e) {}
        WorkDone.countDown();
        System.out.println("Четвертый закончил");
        latch.countDown();

    }
}

//воу воу братишка полегче
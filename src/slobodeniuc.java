import java.util.concurrent.CountDownLatch;

    class ThreadOne implements Runnable {
        private CountDownLatch latch;

        public ThreadOne(CountDownLatch latch) {
            this.latch = latch;
        }

        public void run() {
            int oddCount = 0;
            int index = 0;

            for (int i = 1111; i <= 1748; i++) {
                if (i % 2 != 0) {
                    oddCount++;
                }
            }
            int[] oddNumbers = new int[oddCount];

            for (int i = 1111; i <= 1748; i++) {
                if (i % 2 != 0) {
                    oddNumbers[index] = i;
                    index++;
                }
            }


            int first = oddNumbers[0];
            int sum = 0;
            // сумма произведений чисел по два с первым элементом
            for (int i = 0; i < oddNumbers.length; i++) {
                sum += first * oddNumbers[i];
                System.out.println("Поток 1 : " + sum);
            }
            latch.countDown();
            try{latch.await();}catch(InterruptedException e){}

            System.out.println("Выполненный результат потока 1 : " + sum);

            Main.print("Slobodeniuc");
        }
    }

    class ThreadTwo implements Runnable {
        private CountDownLatch latch;

        public ThreadTwo(CountDownLatch latch) {
            this.latch = latch;
        }

        public void run() {

            int oddCount = 0;
            int index = 0;

            for (int i = 1111; i <= 1748; i++) {
                if (i % 2 != 0) {
                    oddCount++;
                }
            }
            int[] oddNumbers = new int[oddCount];

            for (int i = 1111; i <= 1748; i++) {
                if (i % 2 != 0) {
                    oddNumbers[index] = i;
                    index++;
                }
            }


            int last = oddNumbers[oddNumbers.length - 1];
            int sum = 0;
            // сумма произведений чисел по два с первым элементом
            for (int i = 0; i < oddNumbers.length; i++) {
                if (oddNumbers[i] != last) {
                    sum += last * oddNumbers[i];
                    System.out.println("Поток 2 : " + sum);
                }
            }
            latch.countDown();
            try{latch.await();}catch(InterruptedException e){}

            System.out.println("Выполненный результат потока 2 : " + sum);
            Main.print("Oleg");

        }
    }

    class ThreadThree implements Runnable {
        private CountDownLatch latch;

        public ThreadThree(CountDownLatch latch) {
            this.latch = latch;
        }

        public void run() {
            for (int i = 1111; i <= 1748; i++) {
                System.out.println("Поток 3: " + i);
            }
            latch.countDown();
            try{latch.await();}catch(InterruptedException e){}
            System.out.println("Третий закончил");
            Main.print("PCD");
        }
    }

    class ThreadFour implements Runnable {
        private CountDownLatch latch;

        public ThreadFour(CountDownLatch latch) {

            this.latch = latch;
        }


        public void run() {
            for (int j = 2000; j >= 1478; j--) {
                System.out.println("Поток 4: " + j);
            }
            latch.countDown();
            try{latch.await();}catch(InterruptedException e){}

            System.out.println("Четвертый закончил");
            Main.print("CR-233");
        }
    }

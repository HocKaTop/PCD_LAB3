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
            try {
                Thread.sleep(50);
                latch.countDown();

            } catch (InterruptedException e) {
            }
            System.out.println("Выполненный результат потока 1 : " + sum);

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

            try {
                Thread.sleep(110);
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Выполненный результат потока 2 : " + sum);

            String name = new String();
            name = "Slobodeniuc Oleg";
            for (int i = 0; i < name.length(); i++) {
                try {
                    Thread.sleep(100);
                    System.out.print(name.charAt(i));
                } catch (Exception e) {
                }
            }


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
            try {
                Thread.sleep(150);
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Третий закончил");

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
            try {
                Thread.sleep(200);
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Четвертый закончил");


            try {
                Thread.sleep(1550);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String grup = new String();
            grup = " CR-233";
            for (int i = 0; i < grup.length(); i++) {
                try {
                    Thread.sleep(100);
                    System.out.print(grup.charAt(i));
                } catch (Exception e) {
                }
            }

        }
    }
//воу воу братишка полегч

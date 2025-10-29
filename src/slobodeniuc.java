class ThreadOne implements Runnable {
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
            System.out.println(sum);
        }
        try {Thread.sleep(100);} catch (InterruptedException e) {}
        System.out.println("Выполненный результат потока 1 : "+sum);
    }
}
class ThreadTwo implements Runnable {
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
                System.out.println(sum);
            }
        }
            try{
            Thread.sleep(110);}catch(Exception e){}
        System.out.println("Выполненный результат потока 2 : "+sum);
    }
}

class ThreadThree implements Runnable{
    public void run(){

        for (int i = 1111; i <=1748 ; i++) {
            System.out.println(i);
        }

    }
}

class ThreadFour implements Runnable{
    public void run(){
        System.out.println("--------------------------------");
        for (int j = 2000; j >=1478 ; j--) {
            System.out.println(j);
        }

    }
}
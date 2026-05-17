class PingThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("Ping");
            try {
                Thread.sleep(1000); // pause for 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class PongThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("PONG");
            try {
                Thread.sleep(1000); // pause for 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class PingPong {
    public static void main(String[] args) {
        PingThread t1 = new PingThread();
        PongThread t2 = new PongThread();

        t1.start();
        t2.start();
    }
}














class SharedBuffer {
    int item;
    boolean available = false;

    synchronized void produce(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        item = value;
        available = true;

        System.out.println("Produced: " + item);

        notify();
    }

    synchronized void consume() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println("Consumed: " + item);

        available = false;

        notify();
    }
}

class Producer extends Thread {
    SharedBuffer buffer;

    Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        int i = 1;

        while (true) {
            buffer.produce(i);

            i++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Consumer extends Thread {
    SharedBuffer buffer;

    Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            buffer.consume();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Producer p = new Producer(buffer);
        Consumer c = new Consumer(buffer);

        p.start();
        c.start();
    }
}

















class MaxThread extends Thread {
    int arr[];
    int max;

    MaxThread(int arr[]) {
        this.arr = arr;
    }

    public void run() {
        max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Maximum Element = " + max);
    }
}

class AvgThread extends Thread {
    int arr[];
    double avg;

    AvgThread(int arr[]) {
        this.arr = arr;
    }

    public void run() {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        avg = (double) sum / arr.length;

        System.out.println("Average = " + avg);
    }
}

public class ArrayOperation {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50};

        MaxThread t1 = new MaxThread(arr);
        AvgThread t2 = new AvgThread(arr);

        // Start both threads
        t1.start();
        t2.start();

        try {
            // Wait for both threads to finish
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        // Parent thread calculation
        double result = t1.max / t2.avg;

        System.out.println("(Max / Average) = " + result);
    }
}

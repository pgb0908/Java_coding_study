import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    //volatile static int i = 0;
    static AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        AtomicTest t = new AtomicTest();

        AtomicThread t1 = new AtomicThread();
        AtomicThread t2 = new AtomicThread();
        AtomicThread t3 = new AtomicThread();
        AtomicThread t4 = new AtomicThread();
        AtomicThread t5 = new AtomicThread();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        Thread.sleep(2000);
        System.out.println(t.i);
    }
}

class AtomicThread extends Thread {
    @Override
    public void run() {
        for(int i=0; i < 10000; i++){
            // AtomicTest.i = AtomicTest.i +1;
            AtomicTest.i.getAndAdd(1);

        }
        System.out.println(this + "::::: END");
    }
}

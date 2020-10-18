public class VolatileTest extends Thread {
    // volatile 제거시 계속해서 동작
    volatile boolean isAdd = true;
    public void run() {
        long count = 0;
        while(isAdd){
            count++;
        }
        System.out.println("Thread terminated : " + count);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest t = new VolatileTest();
        t.start();
        Thread.sleep(1000);
        System.out.println("after sleeping in main");

        t.isAdd = false;
        t.join();
        System.out.println("main Thread End... " + t.isAdd);
    }
}

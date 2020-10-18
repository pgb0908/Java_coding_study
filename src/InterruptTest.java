public class InterruptTest extends Thread{

    public void run() {
        for(int i=0; i < 3; i++){
            System.out.println( i+1 + ". before sleep...");
        }

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException 발생");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptTest t = new InterruptTest();
        t.start();
        t.interrupt();

        t.join();
        System.out.println("Main Thread 종료...");
    }
}

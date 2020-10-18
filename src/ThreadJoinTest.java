public class ThreadJoinTest {
    static int sum = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> Sum(1, 20)); t1.start(); t1.join();
        Thread t2 = new Thread(() -> Sum(21, 40)); t2.start(); t2.join();
        Thread t3 = new Thread(() -> Sum(41, 60)); t3.start(); t3.join();
        Thread t4 = new Thread(() -> Sum(61, 80)); t4.start(); t4.join();
        Thread t5 = new Thread(() -> Sum(81, 100)); t5.start(); t5.join();

        System.out.println("1 ~ 100 합은 : " + sum);
    }

    public static void Sum(int start, int end) {
        for(int i= start; i <= end; i++){
            sum += i;
        }
    }
}

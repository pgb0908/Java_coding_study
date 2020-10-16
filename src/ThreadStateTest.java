public class ThreadStateTest {
    public static void main(String args[]) throws InterruptedException {
        Thread t = new Thread(() -> {
            Thread self = Thread.currentThread();
            System.out.println(self.getName() + " ::: " + self.getState());

            for(int i = 0; i < 10; i++){
                System.out.print(".");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(t.getState());

        t.start();
        System.out.println(t.getState());

        t.join();
        System.out.println(t.getState());

        if(t.getState() == Thread.State.TERMINATED){
            System.out.println(t.getName() + " ::: Terminated");
        }
    }
}

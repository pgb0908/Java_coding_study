public class WaitTest {
    public static void main(String[] args) {
        SharedData shared = new SharedData();

        GetThread r1 = new GetThread("GetThread-1", shared);
        GetThread r2 = new GetThread("GetThread-2", shared);
        GetThread r3 = new GetThread("GetThread-3", shared);

        PutThread w1 = new PutThread("PutThread-1", shared, 10);
        PutThread w2 = new PutThread("PutThread-2", shared, 20);
        PutThread w3 = new PutThread("PutThread-3", shared, 30);

        r1. start();
        r2. start();
        r3. start();

        w1. start();
        w2. start();
        w3. start();
    }

}

class PutThread extends Thread {
    private SharedData shared;
    private int data;
    public PutThread(String name, SharedData shared, int data){
        super.setName(name);
        this.shared = shared;
        this.data = data;
    }

    @Override
    public void run() {
        shared.put(data);
        //System.out.println(getName() + " put " + data);
    }
}

class GetThread extends Thread {
    SharedData shared;
    public GetThread(String name, SharedData shared){
        super.setName(name);
        this.shared = shared;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(getName() + " get " + shared.get());
        }
    }
}


class SharedData{
    private boolean isFullData = false;
    private int data;

    public synchronized void put(int data){
        try {
            while(isFullData) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = data;
        isFullData = true;
        notifyAll();
    }

    public synchronized int get() {
        try {
            while(!isFullData) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isFullData = false;
        notifyAll();

        return data;
    }
}

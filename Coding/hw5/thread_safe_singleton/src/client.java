public class client {


    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
           ThreadSafeSingleton tss = ThreadSafeSingleton.getInstance();
        });

        Thread t2 = new Thread(() -> {
            ThreadSafeSingleton tss = ThreadSafeSingleton.getInstance();
        });

        MyThread s = new MyThread();

        t1.start();
        t2.start();
        s.start();

        t1.join();
        t2.join();

    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("***");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

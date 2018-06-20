public class Main {

    public static void main(String[] args) {
        final ClassA a = new ClassA();
        final ClassB b = new ClassB();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a){
                    try {
                        a.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                a.first(b);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                b.first(a);
                synchronized (a){
                    a.notify();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}


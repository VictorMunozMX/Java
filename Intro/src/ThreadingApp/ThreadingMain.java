package ThreadingApp;

public class ThreadingMain {
    public static void main(String[] args) {

        // A Thread is a single sequential flow of control within a program.
        System.out.println("Main thread starts here...1");

        Task task1 = new Task("A");
        //task1.setName("A");
        //task1.start();
        Thread thread = new Thread(task1);
        thread.start();

        System.out.println("Main thread starts here...2");

        Task task2 = new Task("B");
        //task2.setName("B");
        //task2.start();
        Thread thread2 = new Thread(task2);
        thread2.start();

    }
}

//class Task extends Thread {
class Task implements Runnable {

    String name;
    public Task(String name) {
        this.name = name;
    }

    public void run() {
        Thread.currentThread().setName(name);
        for (int i = 0; i < 501; i++) {
            System.out.println("Number: " + i + " - Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

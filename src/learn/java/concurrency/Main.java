package learn.java.concurrency;

public class Main {

    public static void main(String[] args) {

        // Main thread
        var currentThread = Thread.currentThread();
        System.out.println(currentThread.getClass().getName());

        System.out.println(currentThread);
        currentThread.setName("MainGuy");

        currentThread.setPriority(Thread.MAX_PRIORITY);
        printThreadState(currentThread);

        // Create thread by extending Thread class
        CustomThread customThread = new CustomThread();
        customThread.start();

        // Create Thread by using Runnable
        Runnable runnable = () -> {
            for(int i = 0 ; i <= 8 ; i++){
                System.out.print(" 2 ");
                try{
                   Thread.sleep(100);
                }catch (InterruptedException e){
                    Thread.interrupted();
                    e.printStackTrace();
                }
            }
        };

        Thread myThread = new Thread(runnable);
        myThread.start();
//        myThread.interrupt();

        for (int i = 0; i <= 3; i++) {
            System.out.print(" 0 ");

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void printThreadState(Thread thread){
        System.out.println("----------------------");
        System.out.println("Thread ID: " + thread.getId());
        System.out.println("Thread Name: " + thread.getName());
        System.out.println("Thread Priority: " + thread.getPriority());
        System.out.println("Thread State: " + thread.getState());
        System.out.println("Thread Group: " + thread.getThreadGroup());
        System.out.println("Thread Is Alive: " + thread.isAlive());
        System.out.println("----------------------");
    }
}

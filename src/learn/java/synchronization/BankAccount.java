package learn.java.synchronization;

/**
 * This case explains how to use synchronized methods and bocks can be used in multithreading .
 *
 */
public class BankAccount {

    private double balance;
    private String name;
    private final Object lockName = new Object(); // Using this variable as reference for locking on Name
    private final Object lockBalance = new Object(); // Using this variable as reference for locking on Balance

    public BankAccount(String name, double balance) {
        this.balance = balance;
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        synchronized(lockName) {
            this.name = name;
            System.out.println("Updated name = " + this.name);
        }
    }

    public void deposit(double amount){
        try{
            System.out.println("Deposit - Talking to the teller at the bank....");
            Thread.sleep(7000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        synchronized (lockBalance){
            double origBalance = balance;
            balance += amount;
            System.out.printf("STARTING BALANCE: %.0f, DEPOSIT (%.0f)" +
                    " : NEW BALANCE = %.0f%n", origBalance, amount, balance);
            addPromoDollars(amount);
        }
    }

    private void addPromoDollars(double amount){
        if(amount >= 5000){
            // This is not causing deadlock because of Reentrance Synchronization
            synchronized (lockBalance) {
                System.out.println("Congrats, you earned a promotional deposit.");
                balance += 25;
            }
        }
    }

    public synchronized void withdraw(double amount){
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        double origBalance = balance;
        if(amount <= balance) {
            balance -= amount;
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f)" +
                    " : NEW BALANCE = %.0f%n", origBalance, amount, balance);
        }else{
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f)" +
                    " : INSUFFICIENT FUNDS!%n", origBalance, amount);
        }
    }

    public static void main(String[] args) {

        BankAccount companyAccount = new BankAccount("Dhanu", 10_000);

        Thread thread1 = new Thread(() -> companyAccount.withdraw(2_500));
        Thread thread2 = new Thread(() -> companyAccount.deposit(5_000));
        Thread thread3 = new Thread(() -> companyAccount.setName("Dhanunjeya Varma"));
        Thread thread4 = new Thread(() -> companyAccount.withdraw(2_500));

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread3.start();
        thread4.start();

        // Need to join all threads to get the current balance so, that main thread waits
        // till all other threads to finish before getting Final Balance.
        try{
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + companyAccount.getBalance());
    }
}

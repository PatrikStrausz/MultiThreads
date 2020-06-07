package sk.itsovy.strausz.threads;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	Counter cc = new Counter();
	Scanner s = new Scanner(System.in);
        System.out.println("Enter repetitions:");
        int repetitions= s.nextInt();


       Thread t1 = new Thread(() -> {
           try {
               cc.findDivisor();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       });

       Thread t2 = new Thread(() -> {
           try {
               cc.multiplyByTwo(repetitions);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       });

t1.start();
t2.start();

t1.join();
t2.join();

    }
}

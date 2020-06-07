package sk.itsovy.strausz.threads;


import java.util.Scanner;

public class Counter {

public long counter;


    public Counter() throws InterruptedException {
    }


    public void findDivisor()throws InterruptedException
    {

        synchronized(this)
        {

            wait();
            System.out.println("findDivisors() started");
             int maxEven = 0;
            for (int i = 1; i <= counter; i++) {
                if(counter%i==0){
                    maxEven =i;
                }

            }
            System.out.println("Highest even divider: "+maxEven);
            System.out.println("findDivisors() ended");





        }
    }


    public void multiplyByTwo(int number)throws InterruptedException
    {
        System.out.println("multiplyByTwo() started");
        Scanner  scanner= new Scanner(System.in);
        System.out.println("Enter number:");
        counter = scanner.nextInt();
        synchronized(this)
        {

            for (int i = 0; i < number; i++) {
                counter*=2;
                System.out.println(counter);
            }
            System.out.println("final result: " +counter);


            notify();

            Thread.sleep(2000);
            System.out.println("multiplyByTwo() ended");
        }
    }
}


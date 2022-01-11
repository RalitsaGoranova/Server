package pik8;

import pik9.Count;
import pik9.Synch;
import pik9.Unsynch;

public class Main {
    public static void main(String[] args) {
        Count unsynch=new Unsynch();
        Count synch=new Synch();
        Runnable incrementR=()->{
            for(int i=0 ; i<500;i++)
            {
                unsynch.increment();
                synch.increment();
            }
        };
        Thread a=new Thread(incrementR);
        Thread b=new Thread(incrementR);
        Thread c=new Thread(incrementR);
        a.start();
        b.start();
        c.start();
       try {
            a.join();
            b.join();
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Unsynchronized:"+unsynch.getCount());
        System.out.println("Synchronized:"+synch.getCount());
    }
}

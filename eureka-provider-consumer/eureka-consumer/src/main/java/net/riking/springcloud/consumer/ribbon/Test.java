package net.riking.springcloud.consumer.ribbon;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class Helper extends TimerTask
{
    public static int i = 0;
    public void run()
    {
        System.out.println("开始 " + ++i);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Timer ran " + i);
    }
}

public class Test
{
    public static void main(String[] args)
    {

        Timer timer = new Timer();
        TimerTask task = new Helper();

        timer.schedule(task, new Date(), 2000);

    }
}
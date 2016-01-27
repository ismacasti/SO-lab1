/**
 *
 * @author Ari, Ismael
 */
import java.util.Random;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class Laboratorio 
{
    public static void main(String arg[])
    {
        while(true)
        {
            Pais thread1 = new Pais();
            Hora thread2 = new Hora();
            Mates thread3 = new Mates();
            thread1.start();
            thread2.start();
            thread3.start();
            try
            {
                while(true){
                    thread1.join();
                    thread2.join();
                    thread3.join();
                    break;
                }
            }
            catch(InterruptedException e){
            //nada 
            }
        }
    }
}

class Pais extends Thread  
{
    public void run()
    {
        Random rng = new Random();

        try
        {
            Thread.sleep(rng.nextInt(1000));
        }
        catch(InterruptedException e){
        }
        
        String palabra = "Finland";
        System.out.println(palabra); 
    }
}


class Hora extends Thread
{
    public void run()
    {
        Random rng = new Random();
        
        try
        {
            Thread.sleep(rng.nextInt(1000));
        }
        catch(InterruptedException e){
        }
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        
        //get current date time with Calendar()
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
    }
}

class Mates extends Thread
{
    public void run()
    {
        Random rng = new Random();
        int a = 5;
        for(int i = 0 ; i < 10 ; i++)
        {
            System.out.println(a+" x "+i+" = "+i*a);

            try
            {
                Thread.sleep(rng.nextInt(100));
            }
            catch(InterruptedException e){
            }
        }
    }
}
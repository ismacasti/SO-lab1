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
        Pais thread1 = new Pais();
        Hora thread2 = new Hora();
        Mates thread3 = new Mates();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Pais extends Thread  
{
    public void run()
    {
        while(true){
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
}


class Hora extends Thread
{
    public void run()
    {
        while(true){
            Random rng = new Random();
            
            try
            {
                Thread.sleep(rng.nextInt(1000));
            }
            catch(InterruptedException e){
            }
            
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SS");

            
            //get current date time with Calendar()
            Calendar cal = Calendar.getInstance();
            System.out.println(dateFormat.format(cal.getTime()));
        }
    }
}

class Mates extends Thread
{
    public void run()
    {
        int a = 5;
        int i = 0;
        while(true)
        {
            Random rng = new Random();

            System.out.println(a+" x "+i+" = "+i*a);
            i++;
            try
            {
                Thread.sleep(rng.nextInt(500));
            }
            catch(InterruptedException e){
            }
        }
    }
}
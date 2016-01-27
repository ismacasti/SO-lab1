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
        //Creamos tres hilos y los lanzamos
        //Ni Thread.join() ni nada, hacen loop infinito
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
        //los hilos están en un loop infinito
        while(true){ 
            Random rng = new Random();
            //esperan un número aleatorio de milisegundos entre 0 y 1000 (1 segundo)
            try
            {
                Thread.sleep(rng.nextInt(1000));
            }
            catch(InterruptedException e){
                //odio java
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
            //horas:minutos:segundos:milisegundos
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SS");
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
                //este lo ponemos que como mucho espere 500 milisegundos, porque no?
                Thread.sleep(rng.nextInt(500));
            }
            catch(InterruptedException e){
            }
        }
    }
}
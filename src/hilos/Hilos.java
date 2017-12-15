/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Camilo
 */
public class Hilos extends Thread {

    private int iteraciones;
    private Calendar calendario;

    public Hilos(String nombre, int iteraciones) {
        super(nombre);
        this.iteraciones = iteraciones;

    }

    @Override
    public void run() {

        System.out.println("Hilo::" + this.getName() + "Iniciado");
        for (int i = this.iteraciones; i >= 1; i--) {
            this.calendario = new GregorianCalendar();
            int hora = this.calendario.get(Calendar.HOUR);
            int minuto = this.calendario.get(Calendar.MINUTE);
            int segundo = this.calendario.get(Calendar.SECOND);
            int milisegundo = this.calendario.get(Calendar.MILLISECOND);
            System.out.println("\nIteracion numero " + i + " del hilo demoninado" + this.getName());
            System.out.println("Hora de ejecucion: " + hora + " : " + minuto + " : " + segundo + " : " + milisegundo);

            try {
                sleep(i * 50);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        Hilos hilo1 = new Hilos("Uno", 5);
        Hilos hilo2 = new Hilos("Dos", 3);
        Hilos hilo3 = new Hilos("Tres", 6);

        hilo1.start();
        hilo2.start();
        hilo3.start();

    }

}

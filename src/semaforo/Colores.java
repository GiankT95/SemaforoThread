/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.awt.Color;
import java.util.Random;
import javax.swing.JTextArea;

/**
 *
 * @author Sala_01
 */
public class Colores extends Thread {

    Color color;
    JTextArea area;
    String nombre;
    int rango;

    public Colores(JTextArea area, Color color, String nombre) {
        this.area = area;
        this.color = color;
        this.nombre = nombre;
    }
    
    public synchronized void cambiarSemaforo(){
        
        for (int i = 0; i < 10; i++) {
            area.setBackground(color);
            
            System.out.println(nombre + " " + i + " Tiempo: " + rango);

            esperarXsegundos();
            
        }
        
    }

    private void esperarXsegundos() {
        
        Random r = new Random();
        
        rango = r.nextInt(5);
        
        try {
            Thread.sleep(rango * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        cambiarSemaforo();
    }

}

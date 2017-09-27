/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Semaforo extends JApplet {

    private JTextArea areaColorear;
    private JButton boton;

    public void init() {
        areaColorear = new JTextArea(10, 10);
        boton = new JButton("Iniciar");

        boton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Colores hRojo = new Colores(areaColorear, Color.RED, "Hilo_Rojo");
                Colores hVerde = new Colores(areaColorear, Color.GREEN, "Hilo_Verde");
                hRojo.start();
                hVerde.start();
            }
        });

        Container contenedor = getContentPane();

        contenedor.setLayout(new GridLayout(1, 2));
        contenedor.add(areaColorear);
        contenedor.add(boton);
    }
}

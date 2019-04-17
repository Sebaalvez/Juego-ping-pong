/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JFrame;
import control.EngineGraphics;

/**
 *
 * @author salve
 */
public class Ventana extends JFrame{
    
    private final int Ancho=1300, Alto=650;
    Tablero Lamina;
    
    
    public Ventana (){
        setTitle("Ping-Pong");
        setSize(Ancho,Alto);
        setLocationRelativeTo(null);
        setResizable(false);
        Lamina = new Tablero();
        add(Lamina);
        
        addKeyListener(new EventoTeclado());
        new EngineGraphics(Lamina).start();
    }
}

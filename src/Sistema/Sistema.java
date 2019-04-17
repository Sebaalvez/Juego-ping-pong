/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import Clases.Ventana;
import javax.swing.JFrame;

/**
 *
 * @author salve
 */
public class Sistema {
    public static void main(String[] args) {
        
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//esta funcion permite que se termine la ejecucion cuando se cierra la ventana.
        //x 1294    y 621(Medidas de mi pantalla )
        
    }
            
}

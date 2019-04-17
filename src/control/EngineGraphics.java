/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Clases.Tablero;
import Clases.Pelota;


public class EngineGraphics extends Thread {

    private final Tablero Lamina;

    public EngineGraphics(Tablero Lamina) {
        this.Lamina = Lamina;
    }

    @Override
    public void run() {
        while (! Pelota.finJuego) {
            Lamina.repaint();
            try {
                Thread.sleep(0);
            } catch (Exception ex) {
                System.out.println("error in graphics engine: " + ex.getMessage());
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author salve
 */
public class Tablero extends JPanel{
    
    Pelota pelota= new Pelota(0,0);
    Raquetas Raqueta1 = new Raquetas(10, 250);
    Raquetas Raqueta2 = new Raquetas(1294-10-10, 250);
    
    public  Tablero(){
    
        setBackground(Color.BLACK);
    }
    
    @Override
    public void paintComponent(Graphics g){
    
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        Dibujar(g2);
        dibujarPuntaje(g2);
        Actualizar();
       
}
    
    public void Dibujar (Graphics2D g){
        
        Line2D.Double linea = new Line2D.Double(getBounds().getCenterX(), 0, getBounds().getCenterX(), getBounds().getMaxY());
        
        g.draw(linea);
        g.fill(pelota.getShape());
        g.fill(Raqueta1.getRaquetas());
        g.fill(Raqueta2.getRaquetas());
    }
    
    public void Actualizar (){
    
    pelota.Mover(getBounds(),Choque(Raqueta1.getRaquetas()),Choque(Raqueta2.getRaquetas()));
    Raqueta1.MovimientoR1(getBounds());
    Raqueta2.MovimientoR2(getBounds());
    }
    
    public void IterarJuego(){
        
    while(true){
        try {
            
                repaint();
            Thread.sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
    private boolean Choque(Rectangle2D r){
    
    return pelota.getShape().intersects(r);
    
    }
    
    
     private void dibujarPuntaje(Graphics2D g) {
        Graphics2D g1 = g, g2 = g;
        Font score = new Font("Arial", Font.BOLD, 30);
        g.setFont(score);

        g1.drawString(Integer.toString(pelota.getScore1()), (float) getBounds().getCenterX() - 50, 30);
        g2.drawString(Integer.toString(pelota.getScore2()), (float) getBounds().getCenterX() + 25, 30);
        if (pelota.getScore1() == 5) {
            g.drawString("GANÓ El JUGADOR 1", (float) getBounds().getCenterX() - 180, (float) getBounds().getCenterY() - 100);
            Pelota.finJuego = true;
        }
        if (pelota.getScore2() == 5) {
            g.drawString("GANÓ EL JUGADOR 2", (float) getBounds().getCenterX() - 180, (float) getBounds().getCenterY() - 100);
            Pelota.finJuego = true;
        }
    }
}

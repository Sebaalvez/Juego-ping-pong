/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.applet.AudioClip;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import obtenerRecursos.Audio;

/**
 *
 * @author salve
 */
public class Pelota {
    
    private double x = 0;
    private static double y = 0;
    private final int Ancho=15,Alto=15;
    private  int dx=1,dy=1;
    
    
    public Pelota(int x,int y){
    this.x=x;
    this.y=y;
    }
    
    private Integer score1 = 0, score2 = 0;
    public static boolean finJuego = false;
    
     Audio audio = new Audio();
     AudioClip rebote_1=audio.getAudio("/recursos/rebote_pelota1.wav");
     AudioClip rebote_2=audio.getAudio("/recursos/rebote_pelota2.wav");
     AudioClip falta=audio.getAudio("/recursos/falta.wav");
    
     
     
        public Rectangle2D getShape() {
        return new Rectangle2D.Double(x, y, Ancho, Alto);
    }
    
    public void Mover(Rectangle limites,boolean ChoqueR1,boolean ChoqueR2){
      x += dx;
      y += dy;
      
      if(ChoqueR1){
      dx= -dx;
      x=25;
      rebote_1.play();
      }
      
       if(ChoqueR2){
      dx= -dx;
      x=1240;
       rebote_1.play();
      }
      
        if (x < limites.getMinX()) {
            score2++; //el puntaje del jugador2 aumenta en uno
           
            x = limites.getCenterX();
            y = limites.getCenterY();
            dx = -dx;
            falta.play();
        }

        if (x + Ancho >= limites.getMaxX()) {
            score1++; //el puntaje del jugador1 aumenta en uno
            
            x = limites.getCenterX();
            y = limites.getCenterY();
            dx = -dx;
            audio.getAudio("/recursos/falta.wav").play();
        }

        if (y < limites.getMinY()) {

            y = limites.getMinY();

            dy = -dy;
            rebote_2.play();
        }

        if (y + Alto >= limites.getMaxY()) {

            y = limites.getMaxY() - Alto;

            dy = -dy;
            rebote_2.play();
        }

    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }
}

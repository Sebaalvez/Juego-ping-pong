/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author salve
 */
public class Raquetas {
    
    private int x,y;
    private  final int Ancho= 10,Alto=85;
    
    public Raquetas(int x ,int y){
    
        this.x=x;
        this.y=y;
        
    }
    
     public Rectangle2D getRaquetas(){
    
    return new Rectangle2D.Double(x,y,Ancho,Alto);
    
    }
     
     public void MovimientoR1(Rectangle limites){
         
         if(EventoTeclado.w ==true && y>limites.getMinY()){
             y--;
         }
         if(EventoTeclado.s ==true && y<limites.getMaxY()-Alto){
             y++;
         }
     }
     
          public void MovimientoR2(Rectangle limites){
         
         if(EventoTeclado.up ==true && y>limites.getMinY()){
             y--;
         }
         if(EventoTeclado.down ==true && y<limites.getMaxY()-Alto){
             y++;
         }
     }
     
}

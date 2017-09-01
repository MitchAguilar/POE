/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico;

/**
 *
 * @author Mitch
 */
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnimaApplet1 extends Applet implements Runnable {

    Thread anima;
    int radio=10;       //radio de la pelota
    int x, y;     	//posición del centro de la pelota
    int dx = 1;         //desplazamientos
    int dy = 1;
    int anchoApplet;
    int altoApplet;
    int retardo=80;
//Doble buffer
     Image imag;
     Graphics gBuffer;

  public void init () {
    setBackground(Color.white);
    anchoApplet=getSize().width;	//dimensiones del applet
    altoApplet=getSize().height;
    x=anchoApplet/4;			//posición inicial de partida
    y=altoApplet/2;  
}
  public void start(){
     if(anima ==null){
        anima=new Thread(this);
        anima.start();
     }
  }

  public void stop(){
     if(anima!=null){
        anima.stop();
        anima=null;
     }
  }
  public void run() {
    long t=System.currentTimeMillis();
    while (true) {
        mover();
        try{
            t+=retardo;
            Thread.sleep(Math.max(0, t-System.currentTimeMillis()));
        }catch(InterruptedException ex){
            break;
        }
    }
  }
  void mover(){
     x += dx;
     y += dy;
     if (x >= (anchoApplet-radio) || x <= radio) dx*= -1;
     if (y >= (altoApplet-radio)  || y <= radio) dy*= -1;
     repaint();		//llama a update
  }
  public void update(Graphics g){
     if(gBuffer==null){
          imag=createImage(anchoApplet, altoApplet);
          gBuffer=imag.getGraphics();
     }
     gBuffer.setColor(getBackground());
     gBuffer.fillRect(0,0, anchoApplet, altoApplet);
//dibuja la pelota
     gBuffer.setColor(Color.red);
     gBuffer.fillOval(x-radio, y-radio, 2*radio, 2*radio);
//transfiere la imagen al contexto gráfico del applet
     g.drawImage(imag, 0, 0, null);
 }

  public void paint (Graphics g) {
//se llama la primera vez que aparece el applet
  }
}

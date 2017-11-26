/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package braingames;

/**
 *
 * @author Usuario
 */
//public class BrainGames {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        frmMain p = new frmMain();
//        p.setVisible(true);
//
//    }
//}
/*
    Applet que dibuja los pricipales conjuntos fractales clásicos:
    
            Conjunto de Cantor :     <param name="conjunto" value=0>
            Triangulo de Sierpinski: <param name="conjunto" value=1>
            T. Sierpinski recto :    <param name="conjunto" value=2>
            Curva de koch :          <param name="conjunto" value=3>
            Alfombra de Sierpinski : <param name="conjunto" value=4>
            
            
 */

import java.awt.*;
import java.applet.*;

public class Fractales extends Applet {

 
    // Atributos
        String cjto;
        int fases = 0;
        int recto = 0;
        int cp[] = {250,60,550,350};
        
	void ListaConjuntos_Action(Event event) {
		// to do: place event handler code here.
        cjto = Lista_conjuntos.getSelectedItem();
		// Repaint the Panel
		repaint(cp[0],cp[1],cp[2]-cp[0],cp[3]-cp[1]);
		//}}
	}
		
	void bajarFases_Clicked(Event event) {
	    if (fases > 0) fases --;
	    sel_fases.setText(Integer.toString(fases));
	    repaint(cp[0],cp[1],cp[2]-cp[0],cp[3]-cp[1]);
		// to do: place event handler code here.
	}

	void subirFases_Clicked(Event event) {
	    fases ++;
	    sel_fases.setText(Integer.toString(fases));
	    repaint(cp[0],cp[1],cp[2]-cp[0],cp[3]-cp[1]);
		// to do: place event handler code here.
	}



	public void init() {
		super.init();
		//{{INIT_CONTROLS
		setLayout(null);
		addNotify();
		resize(591,383);
		setBackground(new Color(16777215));
		Lista_conjuntos = new java.awt.Choice();
		Lista_conjuntos.addItem("Cantor");
		Lista_conjuntos.addItem("Triangulo Sierpinski");
		Lista_conjuntos.addItem("Sierpinski recto");
		Lista_conjuntos.addItem("Koch");
		Lista_conjuntos.addItem("Alfombra Sierpinski");	
        int c=-1;
        try{
       	c = Integer.parseInt(getParameter("conjunto"));
       	}
     	catch (NumberFormatException e){
     	   }
		switch (c) {
		    case 0 : cjto = "Cantor";break;
		    case 1 : cjto = "Triangulo Sierpinski";break;
		    case 2 : cjto = "Sierpinski recto";break;
		    case 3 : cjto = "Koch";break;
            case 4 : cjto = "Alfombra Sierpinski";break;
            default : cjto = "Cantor";
        }        
		try {
			Lista_conjuntos.select(cjto);
		} catch (IllegalArgumentException e) {
		}
		add(Lista_conjuntos);
		Lista_conjuntos.reshape(36,96,158,21);
		Lista_conjuntos.setFont(new Font("Dialog", Font.BOLD, 12));
		Etiqueta = new java.awt.Label("Fractales Clásicos.",Label.CENTER);
		Etiqueta.reshape(60,12,446,39);
		Etiqueta.setFont(new Font("TimesRoman", Font.BOLD|Font.ITALIC, 40));
		add(Etiqueta);
		Etiqueta2 = new java.awt.Label("Fases:");
		Etiqueta2.reshape(36,132,63,29);
		Etiqueta2.setFont(new Font("Dialog", Font.BOLD, 14));
		add(Etiqueta2);
		sel_fases = new java.awt.TextField();
		sel_fases.setEditable(false);
		sel_fases.setText("0");
		sel_fases.reshape(108,132,36,23);
		add(sel_fases);
		subir_fases = new java.awt.Button("+");
		subir_fases.reshape(156,132,18,14);
		add(subir_fases);
		bajar_fases = new java.awt.Button("-");
		bajar_fases.reshape(156,144,18,14);
		add(bajar_fases);
		etiqueta3 = new java.awt.Label("Tipo de conjunto:");
		etiqueta3.reshape(36,72,142,24);
		add(etiqueta3);
		//}}
	}

	public boolean handleEvent(Event event) {
		if (event.target == Lista_conjuntos && event.id == Event.ACTION_EVENT) {
			ListaConjuntos_Action(event);
			return true;
		}
		if (event.target == subir_fases && event.id == Event.ACTION_EVENT) {
			subirFases_Clicked(event);
			return true;
		}
		if (event.target == bajar_fases && event.id == Event.ACTION_EVENT) {
			bajarFases_Clicked(event);
			return true;
		}
		return super.handleEvent(event);
	}

	//{{DECLARE_CONTROLS
	java.awt.Choice Lista_conjuntos;
	java.awt.Label Etiqueta;
	java.awt.Label Etiqueta2;
	java.awt.TextField sel_fases;
	java.awt.Button subir_fases;
	java.awt.Button bajar_fases;
	java.awt.Label etiqueta3;
	//}}
	
    public void paint(Graphics g){
        //setBackground(Color.white);
        g.drawRect(cp[0],cp[1],cp[2]-cp[0],cp[3]-cp[1]);
        if (cjto=="Cantor"){
            int x1,x2,y;
            x1 = cp[0]+ 10;
            x2 = cp[2]- 10;
            y  = ((cp[3]-cp[1])/2)+ cp[1];
            g.drawLine(x1,y,x2,y);
            cantorizar(g,x1,y,x2,y,fases);
        }else if (cjto=="Triangulo Sierpinski"){
            int cx[] = new int[3];
            int cy[] = new int[3];
            cx[0] = cp[0]+10;
            cy[0] = cp[3]-10;
            cy[1] = cp[1]+10;
            cx[2] = cp[2]-10;
            cy[2] = cy[0];
            cx[1] = ((cx[2]-cx[0])/2)+cx[0];
            g.fillPolygon(cx, cy, 3);
            sierp(g, cx[0], cy[0], cx[1], cy[1], cx[2], cy[2],fases);
        }else if (cjto=="Sierpinski recto"){
            int c_x[] = new int[3];
            int c_y[] = new int[3];
            c_x[0] = cp[0]+10;
            c_y[0] = cp[3]-10;
            c_y[1] = cp[1]+10;
            c_x[2] = cp[2]-10;
            c_y[2] = c_y[0];
            c_x[1] = c_x[0];
            g.fillPolygon(c_x, c_y, 3);
            sierp(g, c_x[0], c_y[0], c_x[1], c_y[1], c_x[2], c_y[2],fases);
        }else if (cjto=="Koch"){
            int x_1,x_2,y_1;
            x_1 = cp[0]+ 10;
            x_2 = cp[2]- 10;
            y_1  = ((cp[3]-cp[1])/3)*2 + cp[1];
            g.drawLine(x_1,y_1,x_2,y_1);
            kochizar(g,x_1,y_1,x_2,y_1,fases);   
        }else if (cjto=="Alfombra Sierpinski"){
            g.fillRect(cp[0]+25,cp[1]+20,cp[3]-cp[1]-40,cp[3]-cp[1]-40);
            alfombrizar(g,cp[0]+25,cp[1]+20,cp[0]+cp[3]-cp[1]-15,cp[3]-20,fases);   
        }
    }
    
    public void alfombrizar(Graphics g, int x1, int y1, int x2, int y2, int f){
        g.setColor(Color.white);
        if (f > 0){
            f--;
            g.fillRect((x2-x1)/3+x1,(y2-y1)/3+y1,(x2-x1)/3,(y2-y1)/3);
            alfombrizar(g,x1,y1,(x2-x1)/3+x1,(y2-y1)/3+y1,f);    
            alfombrizar(g,(x2-x1)/3+x1,y1,(x2-x1)*2/3+x1,(y2-y1)/3+y1,f);    
            alfombrizar(g,(x2-x1)*2/3+x1,y1,x2,(y2-y1)/3+y1,f);    
            alfombrizar(g,x1,(y2-y1)/3+y1,(x2-x1)/3+x1,(y2-y1)*2/3+y1,f);    
            alfombrizar(g,(x2-x1)*2/3+x1,(y2-y1)/3+y1,x2,(y2-y1)*2/3+y1,f);    
            alfombrizar(g,x1,(y2-y1)*2/3+y1,(x2-x1)/3+x1,y2,f);    
            alfombrizar(g,(x2-x1)/3+x1,(y2-y1)*2/3+y1,(x2-x1)*2/3+x1,y2,f);    
            alfombrizar(g,(x2-x1)*2/3+x1,(y2-y1)*2/3+y1,x2,y2,f);    
        }
    }
    public void kochizar(Graphics g, int x1, int y1, int x2, int y2, int f){
        
        float unt_x,unt_y,dost_x,dost_y,pico_x,pico_y,med_x,med_y;
        if (f>0){
            f--;
            unt_x = ((x2-x1)/3)+x1;
            unt_y = ((y2-y1)/3)+y1;
            dost_x= unt_x + ((x2-x1)/3);
            dost_y= unt_y + ((y2-y1)/3);
            med_x = (x1+x2)/2;
            med_y = (y1+y2)/2;
            pico_x = med_x + ((y2-y1)/3);
            pico_y = med_y - ((x2-x1)/3);
            // Borrar la linea del medio
            g.setColor(Color.white);
            g.drawLine((int)unt_x,(int)unt_y,(int)dost_x,(int)dost_y);          
            g.drawLine((int)unt_x,(int)unt_y-1,(int)dost_x,(int)dost_y-1);
            g.drawLine((int)unt_x,(int)unt_y+1,(int)dost_x,(int)dost_y+1);
            g.drawLine((int)unt_x,(int)unt_y-2,(int)dost_x,(int)dost_y-2);
            g.drawLine((int)unt_x,(int)unt_y+2,(int)dost_x,(int)dost_y+2);
            
            
            g.setColor(Color.black);
            g.drawLine((int)unt_x,(int)unt_y,(int)pico_x,(int)pico_y);
            g.drawLine((int)pico_x,(int)pico_y,(int)dost_x,(int)dost_y);
            kochizar(g,x1,y1,(int)unt_x,(int)unt_y,f);
            kochizar(g,(int)unt_x,(int)unt_y,(int)pico_x,(int)pico_y,f);
            kochizar(g,(int)pico_x,(int)pico_y,(int)dost_x,(int)dost_y,f);
            kochizar(g,(int)dost_x,(int)dost_y,x2,y2,f);
        }
    }
                   
    public void cantorizar(Graphics g,int x1, int y1, int x2, int y2,int f){
        float untercio,dostercios;
        untercio = (x1+((x2-x1)/3)) ;
        dostercios = (2*((x2-x1)/3))+x1;
        g.setColor(Color.white);
        if (f > 0) {
            f--;
            g.drawLine((int)untercio,y1,(int)dostercios,y2);
            cantorizar(g, x1, y1, (int)untercio , y2,f);
            cantorizar(g, (int)dostercios, y1, x2, y2,f);
        }
    }
    public void sierp (Graphics g, int x0,int y0,int x1,int y1,int x2,int y2, int f){
        int nx[] = new int[3];
        int ny[] = new int[3];
        // Punto medio del lado izquierdo
        nx[0]=((x1-x0)/2)+x0;
        ny[0]=((y0-y1)/2)+y1;
        // Punto medio de la base
        nx[1]=((x2-x0)/2)+x0;
        ny[1]=y0;
        // Punto medio del lado derecho
        nx[2]=((x2-x1)/2)+x1;
        ny[2]=ny[0];
        
        if (f>0) {
            f--;
            //Borrar triangulo central
            g.setColor(Color.white);
            g.fillPolygon(nx, ny, 3);
            //Lanzar llamada recursiva en el primer triangulo
            sierp(g, x0, y0, nx[0], ny[0], nx[1], ny[1], f);
            //Lanzar llamada recursiva en el segundo triangulo
            sierp(g, nx[0], ny[0], x1, y1, nx[2], ny[2], f);
            //Lanzar llamada recursiva en el tercer triangulo
            sierp(g, nx[1], ny[1], nx[2], ny[2], x2, y2, f);
        } 
    }
    
    /*
    public void box_counting(){
        Image imagen1;
        imagen1 = createImage();
    }   */    
        
}
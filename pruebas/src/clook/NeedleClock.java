package clook;

/**
  @(#)NeedleClock
  NeedleClock - Simulaci�n de un reloj de agujas
  Copyright (C) 1997 Francisco Cascales <fco@proinf.net>

  This program is free software; you can redistribute it and/or modify
  it under the terms of the GNU General Public License as published by
  the Free Software Foundation; either version 2 of the License, or
  (at your option) any later version.

  This program is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along
  with this program; if not, write to the Free Software Foundation, Inc.,
  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.       
 */

//package es.fcocascales.relojagujas;

/*
 * Frame: javaw -jar NeedleClock.jar
 * Applet: appletviewer NeedleClock.java
 *
 * <applet code="NeedleClock.class" archive="NeedleClock.jar" width=400 height=400>
 *   <param name="MinutesOffset" value="120">
 *	 <param name="Image"         value="InBlue.jpg">
 * </APPLET>
 */


import java.util.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;





/**
 * Reloj de agujas
 *
 * @author	Fco. Cascales
 * @version	1.0 12-Julio-1997
 * @version 1.2 18-Agosto-1999 (Actualizado a jdk1.2)
 * @version 1.3 15-Agosto-1999 (desplazamiento horario)
 */
public class NeedleClock extends Applet 

    implements Runnable, 
               ImageObserver
{
  Needle needleHour; // Aguja de las horas
  Needle needleMin;  // Aguja de los minutos
  Needle needleSec;  // Aguja de los segundos

  int xCen, yCen, radius;   // C�rculo horario
  volatile Thread timer = null;  // Temporizador
  boolean isPM = false;     // �Pasado mediod�a?
  Image image = null;       // Imagen de fondo

  private static boolean standAlone = false; // �No es un applet?

  /**
   * Si no es un applet hay una funci�n main
   * la cual crea un frame para meter el applet
   */
  public static void main (String args[])
  {
    Frame frame = new Frame("Clock");

    frame.addWindowListener (new WindowAdapter () {
            @Override
        public void windowClosing (WindowEvent e) {
            System.exit (0);
        }
    });

    // Must show Frame before we size it so
    // insets() will return valid values
	frame.setVisible (true);
    frame.setVisible (false);
	frame.setSize (
      frame.getInsets().left + frame.getInsets().right  + 400,
	  frame.getInsets().top  + frame.getInsets().bottom + 400
    );

    NeedleClock clock = new NeedleClock ();
	frame.add ("Center", clock);
    
    NeedleClock.standAlone = true;
	clock.init ();
	clock.start ();
    frame.setVisible (true);
  }

  /**
   * C�digo de inicializaci�n
   */
    @Override
  public void init ()
  {
    if (NeedleClock.standAlone) {
      resize(400, 400);
    }
    else {
      getParameters ();
    }

    if (image == null) {
      ImageBackground imgBack = new ImageBackground (50, 50);
      image = imgBack.getImage ();
    }

    setBackground (Color.blue.darker ());

    needleHour = new Needle();
    needleMin = new Needle();
    needleSec = new Needle();
  }

  /**
   * Obtener los par�metros del applet
   */
  void getParameters ()
  {
    String s;

    if ((s = getParameter("Image")) != null) {
        image  = getImage (getCodeBase(), s);
    }
  }

  /** Listado de par�metros */
  public String[][] getParameterInfo()
  {
    String[][] info = {
      {"image", "string","Clock background image"},
    };
    return info;
  }

  /** Nombre del applet, versi�n y autor */
  public String getAppletInfo()
  {
    return "NeedleClock 1.3 (C) 1999 by Fco. Cascales";
  }

  /**
   * Arranque
   */
  public void start ()
  {
    if (timer == null)
    {
      timer = new Thread (this);
      timer.start();
    }
  }

  /**
   * Parada
   */
    @Override
  public void stop ()
  {
    timer = null;
  }

  public final static double SIXTY  = 2*Math.PI/60;
  public final static double TWELVE = 2*Math.PI/12;

  long oldSeconds = -1;

  /**
   * C�lculo de las posiciones de las agujas
   * a lo largo del tiempo
   */
    @Override
  public void run ()
  {
    Thread thread = Thread.currentThread ();
    thread.setPriority (Thread.MIN_PRIORITY);

    // Segundos de diferencia por zona horaria y tambi�n por horario de verano/invierno
    Calendar calendar = new GregorianCalendar ();
    long secondsOffset = (calendar.get (Calendar.ZONE_OFFSET) + calendar.get (Calendar.DST_OFFSET)) / 1000;
    
    while (timer == thread)
    {
      long seconds = System.currentTimeMillis()/1000;
      seconds += secondsOffset; 

      if (oldSeconds != seconds) 
      {
          oldSeconds = seconds;
          
          long minutes = seconds /60;
          double hours = seconds /3600d;
          isPM = (hours >= 12d);

          needleHour.setAngle (hours * TWELVE);
          needleMin.setAngle (minutes * SIXTY);
          needleSec.setAngle (seconds * SIXTY);
          
          repaint ();
      }

      try { Thread.sleep (100); }
      catch (Exception e) {}
    }
  }

  ////////// OFF-SCREEN //////////

  protected Image imgOff;
  protected Graphics gOff;
  protected Dimension dimOff = null;

  /**
   * Crea una imagen fuera de la pantalla
   * para pintar. M�s tarde esta imagen se
   * vuelca a la pantalla.
   */
  protected void createOffScreen ()
  {
    Dimension dim = getSize();

    if ((dimOff == null)
      || (dimOff.width != dim.width)
      || (dimOff.height != dim.height))
    {
      dimOff = dim;
      imgOff = createImage (dim.width, dim.height);
      gOff = imgOff.getGraphics ();
    }
  }

  /**
   * Pinta las divisiones de minutos y horas
   * en la esfera del reloj
   */
  void drawDivisions (Graphics g)
  {
    int K = 5;
    int r1 = radius - K;
    int r2 = r1 - K*2;
    int rM = (r2+r1)/2;
    double angle;

    g.setColor (Color.cyan);

    for (angle = 0d; angle < 2*Math.PI; angle += SIXTY)
    {
      int x1 = (int)(xCen + r1 * Math.cos(angle));
      int y1 = (int)(yCen + r1 * Math.sin(angle));
      int x2 = (int)(xCen + r2 * Math.cos(angle));
      int y2 = (int)(yCen + r2 * Math.sin(angle));
      g.drawLine (x1, y1, x2, y2);
    }

    for (angle=0d; angle < 2*Math.PI; angle += TWELVE)
    {
      int x = (int)(xCen + rM * Math.cos(angle));
      int y = (int)(yCen + rM * Math.sin(angle));
      g.fillOval (x-K, y-K, K*2, K*2);
    }
  }

  /**
   * Pinta un adorno de fondo en
   * la esfera del reloj.
   */
  void drawDesign (Graphics g)
  {
    double angle;
    double angle2 = SIXTY*31;
    int x1, x2, y1, y2;

    for (angle = 0d; angle < 2*Math.PI; angle += SIXTY)
    {
      x1 = (int)(xCen + radius * Math.cos (angle));
      y1 = (int)(yCen + radius * Math.sin (angle));

      x2 = (int)(xCen + radius * Math.cos (angle2));
      y2 = (int)(yCen + radius * Math.sin (angle2));
      g.setColor (Color.blue.darker());
      g.drawLine (x1, y1, x2, y2);
      angle2 += SIXTY;
    }
  }

  static String[] romanos = {"3", "4", "5", "6", "7",
    "8", "9", "10", "11", "12", "1", "2"};

  /**
   * Pinta los n�meros horarios en
   * la esfera del reloj.
   */
  void drawNumbers (Graphics g)
  {
    FontMetrics fm = g.getFontMetrics(g.getFont());
    if (fm == null) return;
    int desc = fm.getMaxDescent()*2;
    int height = fm.getHeight();
    int radius = this.radius - height*3;

    g.setColor (Color.white);
    for (int i=0; i<12; ++i)
    {
      int x1 = (int)(xCen + radius * Math.cos (i * TWELVE));
      int y1 = (int)(yCen + radius * Math.sin (i * TWELVE));

      //String num = String.valueOf ((i+2)%12+1); //+(isPM?12:0));
      String num = romanos [i];

      int width = fm.stringWidth (num);
      g.drawString (num, x1 - width/2, y1 + desc);

      g.drawOval (x1-height, y1-height, height*2, height*2);
    }
  }

  /**
   * Pinta el reloj para actualizar la
   * posici�n de las agujas.
   */
  public void update (Graphics g)
  {
    createOffScreen ();

    if (image != null)
      gOff.drawImage (image, 0, 0, dimOff.width, dimOff.height, this);
    else {
      gOff.setColor (getBackground().darker ());
      gOff.fillOval (xCen-radius, yCen-radius, radius*2, radius*2);
    }

    //drawDesign (gOff);
    drawDivisions (gOff);

    needleHour.paint (gOff);
    needleMin.paint (gOff);
    needleSec.paint (gOff);

    if (radius >= 100)
      drawNumbers (gOff);

    g.drawImage (imgOff, 0, 0, null);
  }

  /**
   * No pinta el reloj sino que calcula el
   * tama�o de las agujas seg�n la dimensi�n del applet.
   */
  public void paint (Graphics g)
  {
    Dimension dim = getSize ();
    xCen = dim.width / 2;
    yCen = dim.height / 2;
    radius = Math.min (dim.width, dim.height)/2;
    //System.out.println (radius);

    /* Inicializa las agujas */
    needleHour.setFormat (xCen, yCen,
      radius*6/10, radius*3/15, Color.pink);
    needleMin.setFormat (xCen, yCen,
      radius*8/10, radius*2/15, Color.orange);
    needleSec.setFormat (xCen, yCen,
      radius*9/10, radius*1/15, Color.red);

    // Se comenta porque no est�n calculadas
    // las posiciones de las agujas a�n
    //update (g);
  }

  /**
   * Este m�todo me va indicando cu�nto
   * de la imagen est� ya cargado
   */
  public boolean imageUpdate(Image img, int infoflags,
    int x, int y, int width, int height)
  {
    if (infoflags == ImageObserver.ALLBITS)
      repaint ();
    else if (infoflags == ImageObserver.ERROR)
      image = null;

    return (infoflags & (ALLBITS | ERROR)) == 0;
  }
}

// END OF FILE






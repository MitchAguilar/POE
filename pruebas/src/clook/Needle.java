
package clook;

/**
 * @(#)Needle
 */

//package es.fcocascales.relojagujas;


import java.awt.*;

/**
 * Aguja de reloj
 *
 * @author	Fco. Cascales
 * @version	1.0 Julio-1997
 */
public class Needle
{
  int xCen, yCen, radius, thickness;
  Color color;
  double angle;

  public Needle ()
  {
    xCen = yCen = 0;
    radius = 1;
    angle = 0d;
  }

  /**
   * Inicializa los par�metros de la aguja
   */
  public void setFormat (int xCen, int yCen,
    int radius, int thickness, Color color)
  {
    this.xCen = xCen;
    this.yCen = yCen;
    this.radius = radius;
    this.thickness = thickness;
    this.color = color;
    //angle = 0d;
    calculate ();
  }

  /**
   * Pone un nuevo �ngulo
   */
  public void setAngle (double angle)
  {
    this.angle = angle;
    calculate ();
  }

  public final static double QUARTER = Math.PI/2;
  public final static double HALF = Math.PI;

  // Puntos que definen la forma de la aguja
  int[] xPoints = new int[4];
  int[] yPoints = new int[4];

  /**
   * Calcular la forma poligonal de la aguja
   */
  public void calculate ()
  {
    int radius2 = thickness/2;
    double angle = -this.angle + QUARTER;

    xPoints[0] = (int)(xCen + radius * Math.cos (angle));
    yPoints[0] = (int)(yCen - radius * Math.sin (angle));

    for (int i=1; i<4; ++i)
    {
      angle += QUARTER;
      xPoints[i] = (int)(xCen + radius2 * Math.cos (angle));
      yPoints[i] = (int)(yCen - radius2 * Math.sin (angle));
    }
  }

  /**
   * Pinta la aguja
   */
  public void paint (Graphics g)
  {
    g.setColor (color);
    g.fillPolygon (xPoints, yPoints, 4);
    g.setColor (color.brighter ());
    g.drawPolygon (xPoints, yPoints, 4);
  }
}

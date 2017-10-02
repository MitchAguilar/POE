/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico;

import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author Usuario
 */
public class FormularioV2 {

    Meives.frameM a;
    Meives.PanelM b;
    Meives.labelM c;

    public void Cp() {
        b = new Meives.PanelM(Color.WHITE, 0.5f, 30, 30, 740, 520);
        c = new Meives.labelM("COLOMBIA 4.0", new Color(125, 33, 129), 270, 0, 200, 40);
        c.tam = 50;

        b.add(c);
    }

    public void Fr() {
        a = new Meives.frameM(new Dimension(800, 600), "Colombia  4️⃣.0️⃣ ");

        a.add(b);
        a.InsertImgIcon("/Complements/icon.jpg");
        a.InsertImg("/Complements/img3.jpg");
        a.repaint();
    }

    public FormularioV2() {
        Cp();
        Fr();
    }
}

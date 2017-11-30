/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

import MotorLogico.Meives;
import MotorLogico.Sound;
import java.awt.Dimension;

/**
 *
 * @author Usuario
 */
public class GameOver {

    Meives.frameM fr;

    public GameOver() {
        fr = new Meives.frameM(new Dimension(1026, 600), "Game Over");
        fr.InsertImg("/Complements/Img/Gove.jpg");
        fr.InsertImgIcon("/Complements/Img/icon.png");
        Sound.gmo.play();

    }

    public void Disp() {
        fr.dispose();
    }

}
